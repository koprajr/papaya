package models;

import java.util.List;

/**
 *  This is a model representation of the 'report_templates' database table
 *  from Mango's embedded Apache Derby database.
 */
public class ReportTemplate {

    List<Sensor> individualSensors;
    List<Equation> equations;
    List<Object> manualData;
    List<ChartConfiguration> chartConfigurations;

    public ReportTemplate(List<Sensor> individualSensors,
                          List<Equation> equations,
                          List<Object> manualData,
                          List<ChartConfiguration> chartConfigurations) {
        this.individualSensors = individualSensors;
        this.equations = equations;
        this.manualData = manualData;
        this.chartConfigurations = chartConfigurations;
    }

    public List<Sensor> getIndividualSensors() {
        return individualSensors;
    }

    public void setIndividualSensors(List<Sensor> individualSensors) {
        this.individualSensors = individualSensors;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public void setEquations(List<Equation> equations) {
        this.equations = equations;
    }

    public List<Object> getManualData() {
        return manualData;
    }

    public void setManualData(List<Object> manualData) {
        this.manualData = manualData;
    }

    public List<ChartConfiguration> getChartConfigurations() {
        return chartConfigurations;
    }

    public void setChartConfigurations(List<ChartConfiguration> chartConfigurations) {
        this.chartConfigurations = chartConfigurations;
    }
}
