package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.ChartConfiguration;
import models.ReportTemplate;
import models.Sensor;

import java.util.ArrayList;
import java.util.List;

public class SaveReportTemplateAction extends ActionSupport {
    private ReportTemplate template;
    private List<Integer> sensorIds;
    private List<String> configurationNames;
    private List<String> configurationTypes;
    private List<String> configurationXLabels;
    private List<String> configurationYLabels;
    private List<List<Integer>> chartSensorIds;

    @Override
    public String execute() throws Exception {

        MangoDAO dao = new MangoDAO();

        // -- Associate the selected individual sensors with the template.
        List<Sensor> individualSensors = new ArrayList<Sensor>();
        for (Integer id : sensorIds) {
            individualSensors.add(dao.getSensor(id));
        }
        template.setSensors(individualSensors);

        // -- Compose the chart configurations.
        List<ChartConfiguration> chartConfigurations = new ArrayList<ChartConfiguration>();
        for (int i = 0; i < configurationNames.size(); i++) {
            ChartConfiguration cc = new ChartConfiguration();
            cc.setName(configurationNames.get(i));
            cc.setChartType(configurationTypes.get(i));
            cc.setxLabel(configurationXLabels.get(i));
            cc.setyLabel(configurationYLabels.get(i));
            // -- Associate the selected sensors with the associated chart configuration.
            List<Sensor> chartSensors = new ArrayList<Sensor>();
            for (Integer id : chartSensorIds.get(0)) {
                chartSensors.add(dao.getSensor(id));
            }
            cc.setSensors(chartSensors);
            chartConfigurations.add(cc);
        }

        // - Associate chart configurations with the template.
        template.setChartConfigurations(chartConfigurations);

        dao.createReportTemplate(template);
        return SUCCESS;
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

    public List<String> getConfigurationNames() {
        return configurationNames;
    }

    public void setConfigurationNames(List<String> configurationNames) {
        this.configurationNames = configurationNames;
    }

    public List<String> getConfigurationTypes() {
        return configurationTypes;
    }

    public void setConfigurationTypes(List<String> configurationTypes) {
        this.configurationTypes = configurationTypes;
    }

    public List<String> getConfigurationXLabels() {
        return configurationXLabels;
    }

    public void setConfigurationXLabels(List<String> configurationXLabels) {
        this.configurationXLabels = configurationXLabels;
    }

    public List<String> getConfigurationYLabels() {
        return configurationYLabels;
    }

    public void setConfigurationYLabels(List<String> configurationYLabels) {
        this.configurationYLabels = configurationYLabels;
    }

    public List<List<Integer>> getChartSensorIds() {
        return chartSensorIds;
    }

    public void setChartSensorIds(List<List<Integer>> chartSensorIds) {
        this.chartSensorIds = chartSensorIds;
    }
}
