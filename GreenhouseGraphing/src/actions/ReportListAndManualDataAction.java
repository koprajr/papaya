package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.ReportListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/13/13
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReportListAndManualDataAction extends ActionSupport {
    private MangoDAO mangoDAO;
    private ReportListBean reportListBean;
    private List<String> manualDataTypes;
    private List<String> reportSystemList;

    public ReportListAndManualDataAction() {
        mangoDAO = new MangoDAO();
        manualDataTypes = mangoDAO.selectManualDataTypes();
        reportSystemList = new ArrayList<String>();
        reportSystemList.add("dog");
        reportSystemList.add("cat");
        reportSystemList.add("monkey");
        reportSystemList.add("bird");
        reportSystemList.add("bear");
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

    public ReportListBean getReportListBean() {
        return reportListBean;
    }

    public void setReportListBean(ReportListBean reportListBean) {
        this.reportListBean = reportListBean;
    }

    public List<String> getReportSystemList() {
        return reportSystemList;
    }

    public void setReportSystemList(List<String> reportSystemList) {
        this.reportSystemList = reportSystemList;
    }
}
