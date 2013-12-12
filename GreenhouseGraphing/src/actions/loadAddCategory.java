package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/19/13
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class loadAddCategory extends ActionSupport {
    private MangoDAO mangoDAO;
    private List<String> categories;

    public loadAddCategory() {
        mangoDAO = new MangoDAO();
        //categories = mangoDAO.selectCategories();
    }

    public String execute() {
        return "success";
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
