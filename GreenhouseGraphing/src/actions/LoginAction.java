package actions;

import java.util.Map;

import models.LoginBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private LoginBean bean;
	
	public String execute(){
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
