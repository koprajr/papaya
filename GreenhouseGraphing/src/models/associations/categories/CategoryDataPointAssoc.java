package models.associations.categories;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/18/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDataPointAssoc {

    int categoryId;
    int dataPointId;

    public CategoryDataPointAssoc() {
    }

    public CategoryDataPointAssoc(int categoryId, int dataPointId) {
        this.categoryId = categoryId;
        this.dataPointId = dataPointId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDataPointId() {
        return dataPointId;
    }

    public void setDataPointId(int dataPointId) {
        this.dataPointId = dataPointId;
    }
}
