package actions;

import com.opensymphony.xwork2.ActionSupport;

import dao.MangoDAO;
import models.Category;
import models.ManualDataPoint;
import models.ReportListBean;
import models.ReportTemplate;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

public class ReportListAndManualDataAction extends ActionSupport {
    private MangoDAO mangoDAO;
    private ReportListBean reportListBean;
    private List<String> manualDataTypes;
    private List<ReportTemplate> reportTemplates;
    private String category;
    private String name;

    public ReportListAndManualDataAction() {
        mangoDAO = new MangoDAO();
        reportListBean = new ReportListBean();
    }

    public String execute() {

        if (!category.equals("overallSystem"))  {
            Category testCategory = new Category();
            testCategory.setName(category);
            Category tableCategory = mangoDAO.selectCategory(testCategory);
            if (tableCategory == null) return "invalid";
            int categoryId = tableCategory.getId();
            testCategory.setId(categoryId);

            manualDataTypes = mangoDAO.selectManualDataPointTypesForCategory(testCategory);
            reportTemplates = mangoDAO.selectReportTemplatesForCategory(testCategory);
        }
        else {
            manualDataTypes = mangoDAO.selectManualDataTypes();
            reportTemplates = mangoDAO.getAllReportTemplates();
        }

        reportListBean.setSystem(name);

        return "success";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
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
