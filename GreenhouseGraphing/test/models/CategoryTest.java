package models;

import dao.MangoDAO;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/18/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryTest {


    @Test
    public void testCategories() {
        MangoDAO dao = new MangoDAO();
        Category testCategory = getTestCategory();
        dao.insertCategory(testCategory.getName());

        List<Category> categoriesFromDB = null;
        categoriesFromDB = dao.selectCategories();
        boolean found = false;
        for (Category category : categoriesFromDB) {
            if (category.getName().equals(testCategory.getName())) {
                found = true;
            }
        }
        Assert.assertEquals(true, found);

        dao.deleteCategory(testCategory.getName());
        categoriesFromDB = dao.selectCategories();
        found = false;
        for (Category category : categoriesFromDB) {
            if (category.getName().equals(testCategory.getName())) {
                found = true;
            }
        }
        Assert.assertEquals(false, found);

    }

    private static Category getTestCategory() {
        Category category = new Category();
        category.setName("A test category");
        return category;
    }

}
