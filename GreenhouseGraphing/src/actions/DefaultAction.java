package actions;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction extends ActionSupport{

	public String execute(){
		if (getSession().get("loggedIn") == null){
			return "invalid";
		} else {
			return Action.SUCCESS;
		}
	}
	
	protected Map<String, Object> getSession(){
		return ActionContext.getContext().getSession();
	}
	
	public boolean getLoggedIn(){
		return getSession().containsKey("loggedIn");
	}
	
	public String getUsername(){
		return (String) getSession().get("username");
	}
}
