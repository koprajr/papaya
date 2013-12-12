package models.associations;

public class ChartConfigurationDataPointAssoc {

    private Integer chartConfigurationId;
    private Integer dataPointId;

    public ChartConfigurationDataPointAssoc() {
    }

    public ChartConfigurationDataPointAssoc(Integer chartConfigurationId, Integer dataPointId) {
        this.chartConfigurationId = chartConfigurationId;
        this.dataPointId = dataPointId;
    }

    public Integer getChartConfigurationId() {
        return chartConfigurationId;
    }

    public void setChartConfigurationId(Integer chartConfigurationId) {
        this.chartConfigurationId = chartConfigurationId;
    }

    public Integer getDataPointId() {
        return dataPointId;
    }

    public void setDataPointId(Integer dataPointId) {
        this.dataPointId = dataPointId;
    }
}
