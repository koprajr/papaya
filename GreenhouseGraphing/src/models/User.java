package models;

public class User {

	private int id;
	private String username;
	private String email;
	private String phone;
	private String password;
	private String admin;
	private String disabled;
	private int receiveAlarmEmails;
	private String receiveOwnAuditEvents;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public int getReceiveAlarmEmails() {
		return receiveAlarmEmails;
	}

	public void setReceiveAlarmEmails(int receiveAlarmEmails) {
		this.receiveAlarmEmails = receiveAlarmEmails;
	}

	public String getReceiveOwnAuditEvents() {
		return receiveOwnAuditEvents;
	}

	public void setReceiveOwnAuditEvents(String receiveOwnAuditEvents) {
		this.receiveOwnAuditEvents = receiveOwnAuditEvents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
