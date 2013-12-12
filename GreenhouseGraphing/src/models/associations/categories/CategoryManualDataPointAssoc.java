package models.associations.categories;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/18/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryManualDataPointAssoc {

    int categoryId;
    int manualDataPointId;

    public CategoryManualDataPointAssoc() {
    }

    public CategoryManualDataPointAssoc(int categoryId, int manualDataPointId) {
        this.categoryId = categoryId;
        this.manualDataPointId = manualDataPointId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getManualDataPointId() {
        return manualDataPointId;
    }

    public void setManualDataPointId(int manualDataPointId) {
        this.manualDataPointId = manualDataPointId;
    }
}
