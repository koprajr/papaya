package actions;

import dao.MangoDAO;
import models.ManualDataType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/13/13
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReportListAndManualDataAction {
    private MangoDAO mangoDAO;
    private List<String> manualDataTypes;

    public ReportListAndManualDataAction() {
        mangoDAO = new MangoDAO();
        manualDataTypes = mangoDAO.selectManualDataTypes();
    }

    public String execute() {
        return "success";
    }

    public List<String> getManualDataTypes() {
        return manualDataTypes;
    }

    public void setManualDataTypes(List<String> manualDataTypes) {
        this.manualDataTypes = manualDataTypes;
    }
}
