package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.Login;
import models.User;

import java.nio.charset.Charset;

public class InsertUserAction extends ActionSupport {
    private User testUser;
    private Login bean;
    private MangoDAO mangoDao;
    public static final Charset UTF8_CS = Charset.forName("UTF-8");

    public InsertUserAction() {
        testUser = new User();
        mangoDao = new MangoDAO();
    }

    public String execute() {
        testUser = new User();
        testUser.setUsername(bean.getName());
        testUser.setPassword(bean.getPassword());

        mangoDao.insertUser(testUser);

        return "success";
    }

    public Login getBean() {
        return bean;
    }

    public void setBean(Login bean) {
        this.bean = bean;
    }
}
