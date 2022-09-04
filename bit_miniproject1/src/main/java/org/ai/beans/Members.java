package org.ai.beans;

public class Members {
	private int userNum, userExp;
	private String userId, userPwd, checkPwd, nickName, firstName, lastName, phoneNo, pwdHintQ, pwdHint, userJob, gender, regDate;
	public Members() {
	}
	// 로그인 할때 판별하는 생성자
	public Members(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
	// 회원 가입 할때 받는 정보 생성자 (11개)
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
	// 회원이 갖고있는 모든 정보 생성자 (14개, 1,2번만 int, 나머지 String)
	public Members(int userNum, int userExp, String userId, String userPwd, String checkPwd, String nickName,
			String firstName, String lastName, String phoneNo, String pwdHintQ, String pwdHint, String userJob,
			String gender, String regDate) {
		this.userNum = userNum;
		this.userExp = userExp;
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
		this.regDate = regDate;
	}
	
	public int getUserNum() {
		return userNum;
	}
	
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	public int getUserExp() {
		return userExp;
	}
	public void setUserExp(int userExp) {
		this.userExp = userExp;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
