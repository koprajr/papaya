package models;

import java.util.Set;

public class ChartConfiguration {

    Set<Sensor> individualSensors;
    Set<Equation> equations;
    Set<ManualDataPoint> manualDataPoint;

    public ChartConfiguration(Set<Sensor> individualSensors,
                              Set<Equation> equations,
                              Set<ManualDataPoint> manualDataPoint) {
        this.individualSensors = individualSensors;
        this.equations = equations;
        this.manualDataPoint = manualDataPoint;
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

    public Set<ManualDataPoint> getManualDataPoint() {
        return manualDataPoint;
    }

    public void setManualDataPoint(Set<ManualDataPoint> manualDataPoint) {
        this.manualDataPoint = manualDataPoint;
    }
}
