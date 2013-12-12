package actions;

import java.util.List;

import utils.DataUtils;
import utils.TimeUtils;
import models.ChartConfiguration;
import models.ManualDataPoint;
import models.ManualDataPointValue;
import models.PointValue;
import models.ReportTemplate;
import models.Sensor;
import models.SensorValueSelect;
import dao.MangoDAO;

public class RunReportAction {
	private final int max = 50;

	private MangoDAO dao;
	private ReportTemplate template;
	private String reportName;
	private String start, end;
	private List<Sensor> sensors;
	private List<ManualDataPoint> manualData;
	private List <ChartConfiguration> charts;

	public String execute() {
		dao = new MangoDAO();

		if (start != null && end != null) {
			template = dao.getReportTemplateByName(reportName);

			System.err.println(template.getId());
			
			sensors = template.getSensors();
			preprocessSensors(sensors);

			manualData = template.getManualData();
			prepocessManualData();

			charts = template.getChartConfigurations();
			
			for (ChartConfiguration c : charts){
				preprocessSensors(c.getSensors());
			}
			
		}

		return "success";

	}

	private void prepocessManualData() {
		for (ManualDataPoint m : manualData){
			
			System.err.println(m.getName());
			
			List<ManualDataPointValue> manuals = dao.getManualDataPointValues(m.getId());
			m.setValues(manuals);
		}
	}

	private void preprocessSensors(List<Sensor> sensorList) {
		for (Sensor s : sensorList) {
			List<PointValue> dataPoints = dao
					.getPointValues(new SensorValueSelect(s.getId(), TimeUtils
							.timeStampToEpochTime(start), TimeUtils
							.timeStampToEpochTime(end)));

			List<PointValue> values;

			try {
				values = dataPoints.subList(0, max);
			} catch (Exception e) {
				values = dataPoints;
			}

			values = DataUtils.interpolateMissingValues(values);
			s.setValues(values);
		}
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public ReportTemplate getTemplate() {
		return template;
	}

	public List<ManualDataPoint> getManualData() {
		return manualData;
	}

	public List <ChartConfiguration> getCharts() {
		return charts;
	}

	public void setCharts(List <ChartConfiguration> charts) {
		this.charts = charts;
	}

}
