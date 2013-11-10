package models;

import java.util.Set;

/**
 *  This is a model representation of the 'chart_configurations' database table
 *  from Mango's embedded Apache Derby database.
 */
public class ChartConfiguration {

    Set<Sensor> individualSensors;
    Set<Equation> equations;
    Set<Object> manualData;

    public ChartConfiguration(Set<Sensor> individualSensors,
                              Set<Equation> equations,
                              Set<Object> manualData) {
        this.individualSensors = individualSensors;
        this.equations = equations;
        this.manualData = manualData;
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
}
