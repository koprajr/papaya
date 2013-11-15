package models.associations;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/14/13
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReportTemplateManualDataPointAssoc {

    long reportTemplateId;
    long manualDataPointId;

    public ReportTemplateManualDataPointAssoc(long reportTemplateId, long manualDataPointId) {
        this.reportTemplateId = reportTemplateId;
        this.manualDataPointId = manualDataPointId;
    }

    public long getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(long reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public long getManualDataPointId() {
        return manualDataPointId;
    }

    public void setManualDataPointId(long manualDataPointId) {
        this.manualDataPointId = manualDataPointId;
    }
}
