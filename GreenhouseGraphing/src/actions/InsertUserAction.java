package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.Login;
import models.User;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InsertUserAction extends ActionSupport {
    private Login bean;
    private MangoDAO mangoDao;
    public static final Charset UTF8_CS = Charset.forName("UTF-8");

    public InsertUserAction() {
        mangoDao = new MangoDAO();
    }

    public String execute() {
        User testUser = new User();
        testUser.setUsername(bean.getName());

        try{
        String plainText = bean.getPassword();
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(plainText.getBytes(UTF8_CS));
        byte raw[] = md.digest();
        String hash = new String(Base64.encodeBase64(raw));

        testUser.setPassword(hash);
        } catch (NoSuchAlgorithmException e){}

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
