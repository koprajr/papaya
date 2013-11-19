package models.associations;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/14/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReportTemplateChartConfigurationAssoc {

    long reportTemplateId;
    long chartConfigurationId;

    public long getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(long reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public long getChartConfigurationId() {
        return chartConfigurationId;
    }

    public void setChartConfigurationId(long chartConfigurationId) {
        this.chartConfigurationId = chartConfigurationId;
    }
}