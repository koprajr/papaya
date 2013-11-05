package actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	public String execute(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("loggedIn");
		session.remove("username");
		
		return "success";
	}
	
}
