package actions;

import java.util.List;

import utils.DataUtils;
import utils.TimeUtils;
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

	public String execute() {
		dao = new MangoDAO();

		if (start != null && end != null) {
			template = dao.getReportTemplateByName(reportName);

			sensors = template.getSensors();
			preprocessSensors();

			manualData = template.getManualData();
//			prepocessManualData();
			//TODO: wait until the dao is sorted out...

		}

		return "success";

	}

//	private void prepocessManualData() {
//		for (ManualDataPoint m : manualData) {
//			List<ManualDataPointValue> values = dao
//					.getManualDataPointValuesForPointInRange(m.getId()/*,
//							TimeUtils.timeStampToEpochTime(start),
//							TimeUtils.timeStampToEpochTime(end)*/);
//			
//			System.err.println(values.size());
//			
//			m.setValues(values);
//		}
//	}

	private void preprocessSensors() {
		for (Sensor s : sensors) {
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

}
