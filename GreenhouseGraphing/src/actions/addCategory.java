package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/19/13
 * Time: 12:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class addCategory extends ActionSupport {
    private MangoDAO mangoDAO;
    private AddCategoryBean bean;


    public addCategory() {
        mangoDAO = new MangoDAO();
    }

    public String execute() {

        if (bean.getItem() == null) return "invalid";
        Category tableCategory;
        CategoryHelper tableCategoryHelper;
        CategoryHelper categoryHelper = new CategoryHelper();
        Category category = new Category();
        switch (bean.getType()) {
            case 'M':
                ManualDataType manualDataType = new ManualDataType();
                manualDataType.setName(bean.getItem().toUpperCase());
                ManualDataType tableManualDataType = mangoDAO.selectManualDataType(manualDataType);

                if (tableManualDataType == null) return "invalid";
                categoryHelper.setDataId(tableManualDataType.getId());
                category.setName(bean.getCategory());
                tableCategory = mangoDAO.selectCategory(category);
                categoryHelper.setCategoryId(tableCategory.getId());
                tableCategoryHelper = mangoDAO.selectCategoryManualData(categoryHelper);

                if (tableCategoryHelper != null) return "invalid";
                mangoDAO.insertCategoryManualData(categoryHelper);
                break;
            case 'T':
                ReportTemplate reportTemplate = new ReportTemplate();
                reportTemplate.setName(bean.getItem());
                ReportTemplate tableReportTemplate = mangoDAO.selectReportTemplate(reportTemplate);

                if (tableReportTemplate == null) return "invalid";
                categoryHelper.setDataId(tableReportTemplate.getId());
                category.setName(bean.getCategory());
                tableCategory = mangoDAO.selectCategory(category);
                categoryHelper.setCategoryId(tableCategory.getId());
                tableCategoryHelper = mangoDAO.selectCategoryReportTemplate(categoryHelper);

                if (tableCategoryHelper != null) return "invalid";
                mangoDAO.insertCategoryReportTemplate(categoryHelper);
                break;
            default:

                return "invalid";
        }

        return "success";
    }

    public AddCategoryBean getBean() {
        return bean;
    }

    public void setBean(AddCategoryBean bean) {
        this.bean = bean;
    }
}
