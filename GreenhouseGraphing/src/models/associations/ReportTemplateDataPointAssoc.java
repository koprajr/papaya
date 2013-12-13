package models.associations;

public class ReportTemplateDataPointAssoc {

    Integer reportTemplateId;
    Integer dataPointId;

    public ReportTemplateDataPointAssoc(Integer reportTemplateId, Integer dataPointId) {
        this.reportTemplateId = reportTemplateId;
        this.dataPointId = dataPointId;
    }

    public long getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(Integer reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public long getDataPointId() {
        return dataPointId;
    }

    public void setDataPointId(Integer dataPointId) {
        this.dataPointId = dataPointId;
    }
}