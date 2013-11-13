package models;

import java.util.Set;

public class ReportTemplate {

    private Long id;
    private String name;
    Set<Sensor> individualSensors;
    Set<Equation> equations;
    Set<ManualData> manualData;
    Set<ChartConfiguration> chartConfigurations;

    public ReportTemplate(Set<Sensor> individualSensors,
                          Set<Equation> equations,
                          Set<ManualData> manualData,
                          Set<ChartConfiguration> chartConfigurations) {
        this.individualSensors = individualSensors;
        this.equations = equations;
        this.manualData = manualData;
        this.chartConfigurations = chartConfigurations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Sensor> getIndividualSensors() {
        return individualSensors;
    }

    public void setIndividualSensors(Set<Sensor> individualSensors) {
        this.individualSensors = individualSensors;
    }

    public Set<Equation> getEquations() {
        return equations;
    }

    public void setEquations(Set<Equation> equations) {
        this.equations = equations;
    }

    public Set<ManualData> getManualData() {
        return manualData;
    }

    public void setManualData(Set<ManualData> manualData) {
        this.manualData = manualData;
    }

    public Set<ChartConfiguration> getChartConfigurations() {
        return chartConfigurations;
    }

    public void setChartConfigurations(Set<ChartConfiguration> chartConfigurations) {
        this.chartConfigurations = chartConfigurations;
    }
}
