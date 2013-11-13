package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.LoginBean;
import models.User;
import models.UserPriv;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class LoginAction extends ActionSupport{
    private LoginBean bean;
    private MangoDAO mangoDao;
    //private List<User> users;
    public static final Charset UTF8_CS = Charset.forName("UTF-8");

    public LoginAction() {
        mangoDao = new MangoDAO();
    }

	public String execute(){
        if (!bean.getName().equals("") && !bean.getPassword().equals("")){
            // grab the session from the action context and add a loggedIn flag and the username
            User testUser = new User();
            testUser.setUsername(bean.getName());
            User tableUser = mangoDao.getUser(testUser);

            if (tableUser == null) return "invalid";

            try {

                String plainText = bean.getPassword();
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(plainText.getBytes(UTF8_CS));
                byte raw[] = md.digest();
                String hash = new String(Base64.encodeBase64(raw));

                if (tableUser.getPassword().equals(hash)) {

                    Map<String, Object> session = ActionContext.getContext().getSession();
                    session.put("loggedIn", true);
                    session.put("username", bean.getName());

                    UserPriv userPriv = mangoDao.getLevel(tableUser);

                    char level = userPriv.getLevel();

                    switch (level) {
                        case 'A':
                            session.put("level", "admin");
                            break;

                        case 'R':
                            session.put("level", "researcher");
                            break;

                        case 'S':
                            session.put("level", "student");
                            break;

                        default:
                            return "invalid";
                    }

                    return "success";

                }

            } catch (NoSuchAlgorithmException e) {
                return "invalid";
            }
        }
        return "invalid";
	}

	public LoginBean getBean() {
		return bean;
	}

	public void setBean(LoginBean bean) {
		this.bean = bean;
	}

	
}
