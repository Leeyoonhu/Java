package org.ai.domain;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MemberVO {
	private int userNum, userExp;
	private String userId, userPwd, checkPwd, nickName, firstName, lastName, phoneNo, pwdHintQ, pwdHint, userJob, gender, attDate;
	private Date regDate;
	public MemberVO() {
	}
	// 로그인 할때 판별하는 생성자
	public MemberVO(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
	// 회원 가입 할때 받는 정보 생성자 (11개)
	public MemberVO(String userId, String userPwd, String checkPwd, String nickName, String firstName, String lastName,
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
	// 회원이 갖고있는 모든 정보 생성자 (15개, 1,2번만 int, 나머지 String)
	public MemberVO(int userNum, int userExp, String userId, String userPwd, String checkPwd, String nickName,
			String firstName, String lastName, String phoneNo, String pwdHintQ, String pwdHint, String userJob,
			String gender, String attDate, Date regDate) {
		super();
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
		this.attDate = attDate;
		this.regDate = regDate;
	}
	
}
