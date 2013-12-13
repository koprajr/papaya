package models.associations;

public class ReportTemplateManualDataPointAssoc {

    Integer reportTemplateId;
    Integer manualDataPointId;

    public ReportTemplateManualDataPointAssoc(Integer reportTemplateId, Integer manualDataPointId) {
        this.reportTemplateId = reportTemplateId;
        this.manualDataPointId = manualDataPointId;
    }

    public long getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(Integer reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public long getManualDataPointId() {
        return manualDataPointId;
    }

    public void setManualDataPointId(Integer manualDataPointId) {
        this.manualDataPointId = manualDataPointId;
    }
}
