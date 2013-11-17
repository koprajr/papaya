package models;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Set;

public class ReportTemplate {

    int id;
    String name = "";
    String description = "";
    Set<Sensor> individualSensors;
    Set<Equation> equations;
    Set<ManualDataPoint> manualDataPoints;
    Set<ChartConfiguration> chartConfigurations;

    public ReportTemplate() {
    }

    public ReportTemplate(Set<Sensor> individualSensors,
                          Set<Equation> equations,
            Set<ManualDataPoint> manualDataPoints,
            Set<ChartConfiguration> chartConfigurations) {
                this.individualSensors = individualSensors;
                this.equations = equations;
                this.manualDataPoints = manualDataPoints;
                this.chartConfigurations = chartConfigurations;
            }

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public Set<ManualDataPoint> getManualDataPoints() {
            return manualDataPoints;
        }

        public void setManualDataPoints(Set<ManualDataPoint> manualDataPoints) {
            this.manualDataPoints = manualDataPoints;
        }

        public Set<ChartConfiguration> getChartConfigurations() {
            return chartConfigurations;
        }

        public void setChartConfigurations(Set<ChartConfiguration> chartConfigurations) {
            this.chartConfigurations = chartConfigurations;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ReportTemplate) {
                EqualsBuilder eb = new EqualsBuilder();
                ReportTemplate other = (ReportTemplate) obj;
                eb.append(id, other.getId());
                eb.append(name, other.getName());
                eb.append(individualSensors.size(), other.getIndividualSensors().size());

//                ArrayList<Sensor> sensorList = new ArrayList<Sensor>(individualSensors);
//                ArrayList<Sensor> otherSensorList = new ArrayList<Sensor>(other.getIndividualSensors());
                eb.append(individualSensors.containsAll(other.getIndividualSensors()), true);
//                for (int i = 0; i < sensorList.size(); i++) {
//                    eb.append(sensorList.get(i), otherSensorList.get(i));
//                }

                eb.append(manualDataPoints.containsAll(other.getManualDataPoints()), true);

//                eb.append(manualDataPoints, other.getManualDataPoints());

//            eb.append(chartConfigurations, o.chartConfigurations);
           // TODO: Add more params to test equals



            return eb.isEquals();
        }
        return false;
    }
}
