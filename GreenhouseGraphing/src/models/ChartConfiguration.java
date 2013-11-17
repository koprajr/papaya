package models;

import java.util.List;

public class ChartConfiguration {

    private int id;
    private int reportTemplateId;
    private String title;
    private String xAxis;
    private String yAxis;
    private String chartType;
    private List<Sensor> sensors;
    private List<Equation> equations;
    private List<ManualDataPoint> manualData;
    private String type;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getxAxis() {
        return xAxis;
    }

    public void setxAxis(String xAxis) {
        this.xAxis = xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }

    public void setyAxis(String yAxis) {
        this.yAxis = yAxis;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setReportTemplateId(int reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public void setEquations(List<Equation> equations) {
        this.equations = equations;
    }

    public List<ManualDataPoint> getManualData() {
        return manualData;
    }

    public void setManualData(List<ManualDataPoint> manualData) {
        this.manualData = manualData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
