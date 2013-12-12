package models.associations;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/14/13
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReportTemplateDataPointAssoc {

    long reportTemplateId;
    long dataPointId;

    public ReportTemplateDataPointAssoc(long reportTemplateId, long dataPointId) {
        this.reportTemplateId = reportTemplateId;
        this.dataPointId = dataPointId;
    }

    public long getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(long reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public long getDataPointId() {
        return dataPointId;
    }

    public void setDataPointId(long dataPointId) {
        this.dataPointId = dataPointId;
    }
}