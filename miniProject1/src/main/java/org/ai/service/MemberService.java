package org.ai.service;

import org.ai.domain.MemberVO;
import org.apache.ibatis.annotations.Param;

public interface MemberService {
	public MemberVO login(MemberVO vo);
	public boolean join(MemberVO vo);
	public String idCheck(String userId);
	public String nickCheck(String nickName);
	public String pNCheck(String phoneNo);
	public String findIdProc(@Param("firstName")String firstName, @Param("lastName")String lastName, @Param("phoneNo")String phoneNo);
	public String idToPwdHintQ(String userId);
	public String findPwdProc(@Param("userId")String userId, @Param("pwdHint")String pwdHint);
	public void attend(String userId);
	public MemberVO renew(String userId);
	public String loginCheck(@Param("userId")String userId, @Param("userPwd")String userPwd);
}
