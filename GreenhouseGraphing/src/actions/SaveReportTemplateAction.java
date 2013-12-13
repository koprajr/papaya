package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.ChartConfiguration;
import models.ManualDataPoint;
import models.ReportTemplate;
import models.Sensor;

import java.util.ArrayList;
import java.util.List;

public class SaveReportTemplateAction extends ActionSupport {
    private MangoDAO dao;
    private ReportTemplate template;
    private List<Integer> sensorIds;
    private List<Integer> manualDataIds;
    private List<String> configurationNames;
    private List<String> configurationTypes;
    private List<String> configurationXLabels;
    private List<String> configurationYLabels;
    private List<List<String>> chartSensorIds;
    private List<List<String>> chartManualDataIds;


    @Override
    public String execute() throws Exception {

        // - Associate the selected individual sensors with the template.
        List<Sensor> individualSensors = new ArrayList<Sensor>();
        if (sensorIds != null) {
            for (Integer id : sensorIds) {
                individualSensors.add(dao.getSensor(id));
            }
            template.setSensors(individualSensors);
        }

        // - Associate the selected indivisual data with the template.
        List<ManualDataPoint> manualData = new ArrayList<ManualDataPoint>();
        if (manualDataIds != null) {
            for (Integer id : manualDataIds) {
                manualData.add(dao.selectManualDataPointById(id));
            }
            template.setManualData(manualData);
        }

        // - Compose the chart configurations.
        List<ChartConfiguration> chartConfigurations = new ArrayList<ChartConfiguration>();
        if (configurationNames != null) {
            for (int i = 0; i < configurationNames.size(); i++) {
                ChartConfiguration cc = new ChartConfiguration();
                cc.setName(configurationNames.get(i));
                cc.setChartType(configurationTypes.get(i));
                cc.setxLabel(configurationXLabels.get(i));
                cc.setyLabel(configurationYLabels.get(i));
                // - Associate the selected sensors with the associated chart configuration.
                List<Sensor> chartSensors = new ArrayList<Sensor>();
                if (chartSensorIds != null) {
                    for (String id : chartSensorIds.get(i)) {
                        chartSensors.add(dao.getSensor(Integer.parseInt(id)));
                    }
                    cc.setSensors(chartSensors);
                }
                // - Associate the select manual data with the associated chart configuration.
                List<ManualDataPoint> chartManualData = new ArrayList<ManualDataPoint>();
                if (chartManualDataIds != null) {
                    for (String id : chartManualDataIds.get(i)) {
                        chartManualData.add(dao.selectManualDataPointById(Integer.parseInt(id)));
                    }
                    cc.setManualData(chartManualData);
                }

                chartConfigurations.add(cc);
            }
            // - Associate chart configurations with the template.
            template.setChartConfigurations(chartConfigurations);
        }

        dao.createReportTemplate(template);
        return SUCCESS;
    }

    public SaveReportTemplateAction() {
        super();
        dao = new MangoDAO();
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

    public List<List<String>> getChartSensorIds() {
        return chartSensorIds;
    }

    public void setChartSensorIds(List<List<String>> chartSensorIds) {
        this.chartSensorIds = chartSensorIds;
    }

    public List<Integer> getManualDataIds() {
        return manualDataIds;
    }

    public void setManualDataIds(List<Integer> manualDataIds) {
        this.manualDataIds = manualDataIds;
    }

    public List<List<String>> getChartManualDataIds() {
        return chartManualDataIds;
    }

    public void setChartManualDataIds(List<List<String>> chartManualDataIds) {
        this.chartManualDataIds = chartManualDataIds;
    }
}
