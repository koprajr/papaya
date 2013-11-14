package models;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/13/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReportTemplateSensorAssociation {

    int id;
    int reportTemplateId;
    int constantId;
    int dataPointId;
    int manualDataPointId;
    int equationId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(int reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public int getConstantId() {
        return constantId;
    }

    public void setConstantId(int constantId) {
        this.constantId = constantId;
    }

    public int getDataPointId() {
        return dataPointId;
    }

    public void setDataPointId(int dataPointId) {
        this.dataPointId = dataPointId;
    }

    public int getManualDataPointId() {
        return manualDataPointId;
    }

    public void setManualDataPointId(int manualDataPointId) {
        this.manualDataPointId = manualDataPointId;
    }

    public int getEquationId() {
        return equationId;
    }

    public void setEquationId(int equationId) {
        this.equationId = equationId;
    }
}
