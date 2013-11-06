package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import models.LoginBean;

import java.util.Map;

public class LoginAction extends ActionSupport{
	private LoginBean bean;
	
	public String execute(){
		
		if (bean != null){
			System.err.println("good to go!");
		}
		
		if (!bean.getName().equals("") && !bean.getPassword().equals("")){
			// grab the session from the action context and add a loggedIn flag and the username
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("loggedIn", true);
			session.put("username", bean.getName());
			return "success";
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
