package models.associations;

public class ReportTemplateChartConfigurationAssoc {

    Integer reportTemplateId;
    Integer chartConfigurationId;

    public ReportTemplateChartConfigurationAssoc(Integer reportTemplateId, Integer chartConfigurationId) {
        this.reportTemplateId = reportTemplateId;
        this.chartConfigurationId = chartConfigurationId;
    }

    public long getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(Integer reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public long getChartConfigurationId() {
        return chartConfigurationId;
    }

    public void setChartConfigurationId(Integer chartConfigurationId) {
        this.chartConfigurationId = chartConfigurationId;
    }
}