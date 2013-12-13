package models.associations;

public class ChartConfigurationManualDataPointAssoc {

    int chartConfigurationId;
    int manualDataPointId;

    public ChartConfigurationManualDataPointAssoc() {
    }

    public ChartConfigurationManualDataPointAssoc(int chartConfigurationId, int manualDataPointId) {
        this.chartConfigurationId = chartConfigurationId;
        this.manualDataPointId = manualDataPointId;
    }

    public int getChartConfigurationId() {
        return chartConfigurationId;
    }

    public void setChartConfigurationId(int chartConfigurationId) {
        this.chartConfigurationId = chartConfigurationId;
    }

    public int getManualDataPointId() {
        return manualDataPointId;
    }

    public void setManualDataPointId(int manualDataPointId) {
        this.manualDataPointId = manualDataPointId;
    }
}