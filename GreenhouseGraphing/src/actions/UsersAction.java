package actions;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import dao.MangoDAO;
import models.User;
import org.apache.commons.codec.binary.Base64;

public class UsersAction extends DefaultAction{
	private MangoDAO mangoDao;
	private List<User> users;
	private User user;
    public static final Charset UTF8_CS = Charset.forName("UTF-8");
	
	public UsersAction() {
        User user = new User();
		mangoDao = new MangoDAO();
	}

	public String execute(){   // list users
		users = mangoDao.getUsers();
		return "success";
	}

	public String create(){    // create a new user
		user.setAdmin("N");    //set default values
		user.setDisabled("N");
		user.setReceiveAlarmEmails(0);
		user.setReceiveOwnAuditEvents("N");

        user.setPassword(hashPass(user.getPassword())); //hash the password

		mangoDao.createUser(user); //create the User
		
		return "success";
	}

    public User setUserInfo(User user, String[] userData) { //set user info from a string[]
        try {
            user.setUsername(userData[0]);   //set user info from file
            user.setPassword(hashPass(userData[1]));
            user.setEmail(userData[2]);
            user.setPhone(userData[3]);

            user.setAdmin("N");              //set default user info
            user.setDisabled("N");
            user.setReceiveAlarmEmails(0);
            user.setReceiveOwnAuditEvents("N");
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds.");
            e.printStackTrace();
        }
        return user;
    }

    public String hashPass(String password) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(password.getBytes(UTF8_CS));
            byte raw[] = md.digest();
            hash = new String(Base64.encodeBase64(raw));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Password Hashing Error");
            e.printStackTrace();
        }
        return hash;
    }

	//TODO: update a user
	public String update(){
		
		return null;
	}
	
	// delete a user
	public String delete(){
		mangoDao.deleteUser(user);
		return "success";
	}
	
	// getters and setters
	public User getUser(){
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

}
