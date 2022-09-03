package org.ai.beans;

public class Members {
	String userId, userPwd, checkPwd, nickName, firstName, lastName, phoneNo, pwdHintQ, pwdHint, userJob, gender;
	public Members() {
	}
	public Members(String userId, String userPwd, String checkPwd, String nickName, String firstName, String lastName,
			String phoneNo, String pwdHintQ, String pwdHint, String userJob, String gender) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.checkPwd = checkPwd;
		this.nickName = nickName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.pwdHintQ = pwdHintQ;
		this.pwdHint = pwdHint;
		this.userJob = userJob;
		this.gender = gender;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getCheckPwd() {
		return checkPwd;
	}
	public String getNickName() {
		return nickName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getPwdHintQ() {
		return pwdHintQ;
	}
	public String getPwdHint() {
		return pwdHint;
	}
	public String getUserJob() {
		return userJob;
	}
	public String getGender() {
		return gender;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setCheckPwd(String checkPwd) {
		this.checkPwd = checkPwd;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setPwdHintQ(String pwdHintQ) {
		this.pwdHintQ = pwdHintQ;
	}
	public void setPwdHint(String pwdHint) {
		this.pwdHint = pwdHint;
	}
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
