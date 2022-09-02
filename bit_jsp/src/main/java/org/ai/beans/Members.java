package org.ai.beans;

import java.util.Date;

public class Members {
	private String userId, userPwd, userName, phoneNo, address, email, regDate; 
	public Members() {

	}
	
	public Members(String userId, String userPwd, String userName, String phoneNo, String address, String email,
			String regDate) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.regDate = regDate;
	}

	public Members(String userId, String userPwd, String userName, String phoneNo, String address, String email) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	
}
