package models.associations.categories;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/18/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryReportTemplateAssoc {

    int categoryId;
    int reportTemplateId;

    public CategoryReportTemplateAssoc() {
    }

    public CategoryReportTemplateAssoc(int categoryId, int reportTemplateId) {
        this.categoryId = categoryId;
        this.reportTemplateId = reportTemplateId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(int reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }
}
