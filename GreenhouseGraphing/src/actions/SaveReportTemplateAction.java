package actions;

import com.opensymphony.xwork2.ActionSupport;
import models.ChartConfiguration;
import models.ReportTemplate;

import java.util.Arrays;
import java.util.List;

public class SaveReportTemplateAction extends ActionSupport {
    private ReportTemplate template;
    private List<ChartConfiguration> chartConfigurations;
    private List<Integer> sensorIds;

    private List<String> configurationNames;
    private List<String> configurationTypes;
    private List<String> configurationXLabels;
    private List<String> configurationYLabels;
    private List<List<Integer>> chartSensorIds;

    @Override
    public String execute() throws Exception {
        // - BEGIN TEST CODE
        System.out.println(template.getName());                   // - print name of template
        System.out.println(template.getDescription());            // - print description of template
        System.out.println(Arrays.asList(sensorIds));             // - print all selected individual sensors
        System.out.println(Arrays.asList(configurationNames));    // - print all configuration chart names
        System.out.println(Arrays.asList(configurationTypes));    // - print all configuration chart types
        System.out.println(Arrays.asList(configurationXLabels));  // - print all configuration chart x labels
        System.out.println(Arrays.asList(configurationYLabels));  // - print all configuration chart y labels
        System.out.println(Arrays.asList(chartSensorIds.get(0))); // - print all selected sensors for 1st configuration chart
        System.out.println(Arrays.asList(chartSensorIds.get(1))); // - print all selected sensors for 2nd configuration chart
        // - END TEST CODE

        return SUCCESS;
    }

    public ReportTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ReportTemplate template) {
        this.template = template;
    }

    public List<ChartConfiguration> getChartConfigurations() {
        return chartConfigurations;
    }

    public void setChartConfigurations(List<ChartConfiguration> chartConfigurations) {
        this.chartConfigurations = chartConfigurations;
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
