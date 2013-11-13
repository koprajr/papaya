package models;

import java.util.Set;

public class ChartConfiguration {

    Set<Sensor> individualSensors;
    Set<Equation> equations;
    Set<ManualData> manualData;

    public ChartConfiguration(Set<Sensor> individualSensors,
                              Set<Equation> equations,
                              Set<ManualData> manualData) {
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

    public Set<ManualData> getManualData() {
        return manualData;
    }

    public void setManualData(Set<ManualData> manualData) {
        this.manualData = manualData;
    }
}
