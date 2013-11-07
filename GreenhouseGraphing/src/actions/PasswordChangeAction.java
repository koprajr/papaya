package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.PasswordBean;
import models.User;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * User: Daniel Deloff
 * Date: 11/6/13
 * Time: 10:33 PM
 */
public class PasswordChangeAction extends ActionSupport {
    private PasswordBean bean;
    private MangoDAO mangoDAO;
    public static final Charset UTF8_CS = Charset.forName("UTF-8");

    public PasswordChangeAction() {
        mangoDAO = new MangoDAO();
    }

    public String execute() {

        if (!bean.getOldpass().equals("")&&!bean.getNewPass().equals("")) {
            Map<String, Object> session = ActionContext.getContext().getSession();
            String username = (String) session.get("username");

            if (username.equals("")) return "invalid";

            User testUser = new User();
            testUser.setUsername(username);
            User tableUser = mangoDAO.getUser(testUser);

            if (tableUser == null) return "invalid";

            if (!tableUser.getPassword().equals(encrypt(bean.getOldpass()))) return "invalid";

            String plainText = bean.getNewPass();
            String hash = encrypt(plainText);

            if (hash == null) return "invalid";

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
