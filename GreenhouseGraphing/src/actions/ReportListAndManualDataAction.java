package actions;

import com.opensymphony.xwork2.ActionSupport;

import dao.MangoDAO;
import models.ReportListBean;
import models.ReportTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReportListAndManualDataAction extends ActionSupport {
    private MangoDAO mangoDAO;
    private ReportListBean reportListBean;
    private List<String> manualDataTypes;
    private List<ReportTemplate> reportTemplates;

    public ReportListAndManualDataAction() {
        mangoDAO = new MangoDAO();
        manualDataTypes = mangoDAO.selectManualDataTypes();
        
        reportTemplates = mangoDAO.getAllReportTemplates();
        
//        reportSystemList = new ArrayList<String>();
//        reportSystemList.add("dog");
//        reportSystemList.add("cat");
//        reportSystemList.add("monkey");
//        reportSystemList.add("bird");
//        reportSystemList.add("bear");
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

	public List<ReportTemplate> getReportTemplates() {
		return reportTemplates;
	}

	public void setReportTemplates(List<ReportTemplate> reportTemplates) {
		this.reportTemplates = reportTemplates;
	}

}
