package actions;

import java.util.List;

import dao.MangoDAO;
import models.MailingList;
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
		
		System.err.println(user.getUsername());
		System.err.println(user.getPhone());
		System.err.println(user.getEmail());
		
		user.setAdmin("N");
		user.setDisabled("N");
		user.setReceiveAlarmEmails(0);
		user.setReceiveOwnAuditEvents("N");
		
//		mangoDao.createUser(user);
		
		MailingList list = new MailingList();
		list.setId(1000);
		list.setName("somename");
		list.setXid("lolxid");
		
		mangoDao.createMailingList(list);
		
		return "success";
	}

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
