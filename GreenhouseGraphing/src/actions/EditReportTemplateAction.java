package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.ChartConfiguration;
import models.ManualDataPoint;
import models.ReportTemplate;
import models.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EditReportTemplateAction extends ActionSupport {
    private MangoDAO dao;
    private String templateName;
    private List<Integer> sensorIds;
    private List<Integer> manualDataIds;

    private ReportTemplate template;
    private Set<ChartConfiguration> chartConfigurations;
    private List<Sensor> sensors;
    private List<ManualDataPoint> manualData;

    @Override
    public String execute() throws Exception {
        template = dao.getReportTemplateByName(templateName);

        sensors = new ArrayList<Sensor>();
        if (sensorIds != null) {
            for (Integer id : sensorIds) {
                sensors.add(dao.getSensor(id));
            }
        }
        manualData = new ArrayList<ManualDataPoint>();
        if (manualDataIds != null) {
            for (Integer id : manualDataIds) {
                manualData.add(dao.selectManualDataPointById(id));
            }
        }

        return SUCCESS;
    }

    public EditReportTemplateAction() {
        dao = new MangoDAO();
    }

    public List<Integer> getManualDataIds() {
        return manualDataIds;
    }

    public void setManualDataIds(List<Integer> manualDataIds) {
        this.manualDataIds = manualDataIds;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public ReportTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ReportTemplate template) {
        this.template = template;
    }

    public List<Integer> getSensorIds() {
        return sensorIds;
    }

    public void setSensorIds(List<Integer> sensorIds) {
        this.sensorIds = sensorIds;
    }

    public Set<ChartConfiguration> getChartConfigurations() {
        return chartConfigurations;
    }

    public void setChartConfigurations(Set<ChartConfiguration> chartConfigurations) {
        this.chartConfigurations = chartConfigurations;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<ManualDataPoint> getManualData() {
        return manualData;
    }

    public void setManualData(List<ManualDataPoint> manualData) {
        this.manualData = manualData;
    }
}
