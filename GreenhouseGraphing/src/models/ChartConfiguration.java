package models;

import java.util.List;

/**
 *  This is a model representation of the 'chart_configurations' database table
 *  from Mango's embedded Apache Derby database.
 */
public class ChartConfiguration {

    List<Sensor> individualSensors;
    List<Equation> equations;
    List<Object> manualData;

    public ChartConfiguration(List<Sensor> individualSensors,
                              List<Equation> equations,
                              List<Object> manualData) {
        this.individualSensors = individualSensors;
        this.equations = equations;
        this.manualData = manualData;
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
}
