package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.PasswordBean;
import models.User;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/18/13
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdminChangePassword extends ActionSupport{
    private MangoDAO mangoDAO;
    private PasswordBean bean;
    public static final Charset UTF8_CS = Charset.forName("UTF-8");

    public AdminChangePassword() {
        mangoDAO = new MangoDAO();
    }

    public String execute() {
        User testUser = new User();
        testUser.setUsername(bean.getUsername());
        User tableUser = mangoDAO.getUser(testUser);

        if (tableUser == null) return "invalid";

        String plainText = bean.getNewPass();
        String hash = encrypt(plainText);

        if (hash == null) return "invalid";

        if (!tableUser.getPassword().equals(hash)) {
            tableUser.setPassword(hash);
            mangoDAO.updateUserPass(tableUser);
            return "success";
        }

        return "invalid";

    }

    public PasswordBean getBean() {
        return bean;
    }

    public void setBean(PasswordBean bean) {
        this.bean = bean;
    }

    public String encrypt(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(plainText.getBytes(UTF8_CS));
            byte raw[] = md.digest();
            String hash = new String(Base64.encodeBase64(raw));
            return hash;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
