package models;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/19/13
 * Time: 12:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddCategoryBean {
    private String category;
    private String item;
    private char type;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
