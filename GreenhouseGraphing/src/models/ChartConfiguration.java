package models;

import java.util.List;
import java.util.Set;

public class ChartConfiguration {

    private Integer id;
    private Integer reportTemplateId;
    private String name;
    private String xLabel;
    private String yLabal;
    private String chartType;
    private List<Sensor> sensors;
    private Set<Equation> equations;
    private Set<ManualData> manualData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(Integer reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getxLabel() {
        return xLabel;
    }

    public void setxLabel(String xLabel) {
        this.xLabel = xLabel;
    }

    public String getyLabal() {
        return yLabal;
    }

    public void setyLabal(String yLabal) {
        this.yLabal = yLabal;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
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
