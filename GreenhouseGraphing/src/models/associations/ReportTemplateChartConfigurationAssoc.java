package models.associations;

public class ReportTemplateChartConfigurationAssoc {

    long reportTemplateId;
    long chartConfigurationId;

    public ReportTemplateChartConfigurationAssoc(long reportTemplateId, long chartConfigurationId) {
        this.reportTemplateId = reportTemplateId;
        this.chartConfigurationId = chartConfigurationId;
    }

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