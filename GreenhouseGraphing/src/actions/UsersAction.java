package actions;

import java.util.List;

import dao.MangoDAO;
import models.User;

public class UsersAction extends DefaultAction{
	private MangoDAO mangoDao;
	private List<User> users;
	private User user;
	
	public UsersAction() {
		mangoDao = new MangoDAO();
	}
	
	// list users
	public String execute(){
		users = mangoDao.getUsers();
		return "success";
	}
	
	// create a new user
	public String create(){
		user.setAdmin("N");
		user.setDisabled("N");
		user.setReceiveAlarmEmails(0);
		user.setReceiveOwnAuditEvents("N");
		
		mangoDao.createUser(user);
		
		return "success";
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
