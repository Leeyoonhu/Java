package org.ai.beans;

public class Members {
	private String userId, userPwd, name, address, email;
	private java.util.Date regDate;
	public Members() {

	}
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public java.util.Date getRegDate() {
		return regDate;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}
	
	
}
