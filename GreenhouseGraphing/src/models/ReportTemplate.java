package models;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Set;

public class ReportTemplate {

    Long id;
    String name = "";
    String description = "";
    Set<Sensor> individualSensors;
    Set<Equation> equations;
    Set<ManualDataPoint> manualDataPoint;
    Set<ChartConfiguration> chartConfigurations;

    public ReportTemplate() {
    }

    public ReportTemplate(Set<Sensor> individualSensors,
                          Set<Equation> equations,
            Set<ManualDataPoint> manualDataPoint,
            Set<ChartConfiguration> chartConfigurations) {
                this.individualSensors = individualSensors;
                this.equations = equations;
                this.manualDataPoint = manualDataPoint;
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

        public Set<ManualDataPoint> getManualDataPoint() {
            return manualDataPoint;
        }

        public void setManualDataPoint(Set<ManualDataPoint> manualDataPoint) {
            this.manualDataPoint = manualDataPoint;
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

                eb.append(manualDataPoint.containsAll(other.getManualDataPoint()), true);

//                eb.append(manualDataPoint, other.getManualDataPoint());

//            eb.append(chartConfigurations, o.chartConfigurations);
           // TODO: Add more params to test equals



            return eb.isEquals();
        }
        return false;
    }
}
