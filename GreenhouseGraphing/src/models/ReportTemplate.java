package models;

import java.util.Set;

/**
 *  This is a model representation of the 'report_templates' database table
 *  from Mango's embedded Apache Derby database.
 */
public class ReportTemplate {

    Set<Sensor> individualSensors;
    Set<Equation> equations;
    Set<Object> manualData;
    Set<ChartConfiguration> chartConfigurations;

    public ReportTemplate(Set<Sensor> individualSensors,
                          Set<Equation> equations,
                          Set<Object> manualData,
                          Set<ChartConfiguration> chartConfigurations) {
        this.individualSensors = individualSensors;
        this.equations = equations;
        this.manualData = manualData;
        this.chartConfigurations = chartConfigurations;
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

    public Set<Object> getManualData() {
        return manualData;
    }

    public void setManualData(Set<Object> manualData) {
        this.manualData = manualData;
    }

    public Set<ChartConfiguration> getChartConfigurations() {
        return chartConfigurations;
    }

    public void setChartConfigurations(Set<ChartConfiguration> chartConfigurations) {
        this.chartConfigurations = chartConfigurations;
    }
}
