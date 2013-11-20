package models;

import java.util.List;

public class ReportTemplate {

    private Integer id;
    private String name;
    private String description;
    private List<Sensor> sensors;
    private List<Equation> equations;
    private List<ManualDataPoint> manualData;
    private List<ChartConfiguration> chartConfigurations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public void setEquations(List<Equation> equations) {
        this.equations = equations;
    }

    public List<ManualDataPoint> getManualData() {
        return manualData;
    }

    public void setManualData(List<ManualDataPoint> manualData) {
        this.manualData = manualData;
    }

    public List<ChartConfiguration> getChartConfigurations() {
        return chartConfigurations;
    }

    public void setChartConfigurations(List<ChartConfiguration> chartConfigurations) {
        this.chartConfigurations = chartConfigurations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
