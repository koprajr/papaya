package models.associations;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/17/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChartConfigurationDataPointAssoc {

    int chartConfigurationId;
    int dataPointId;



    public ChartConfigurationDataPointAssoc() {
    }

    public ChartConfigurationDataPointAssoc(int chartConfigurationId, int dataPointId) {
        this.chartConfigurationId = chartConfigurationId;
        this.dataPointId = dataPointId;
    }

    public int getChartConfigurationId() {
        return chartConfigurationId;
    }

    public void setChartConfigurationId(int chartConfigurationId) {
        this.chartConfigurationId = chartConfigurationId;
    }

    public int getDataPointId() {
        return dataPointId;
    }

    public void setDataPointId(int dataPointId) {
        this.dataPointId = dataPointId;
    }
}
