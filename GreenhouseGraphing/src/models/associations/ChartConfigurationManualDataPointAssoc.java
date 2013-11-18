package models.associations;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/17/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
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