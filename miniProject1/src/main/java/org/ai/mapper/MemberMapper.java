package org.ai.mapper;

import java.util.List;

import org.ai.domain.Criteria;
import org.ai.domain.MemberVO;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
	public MemberVO login(MemberVO vo);
	public int join(MemberVO vo);
	
	public String idCheck(String userId);
	public String nickCheck(String nickName);
	public String pNCheck(String phoneNo);
	public String findIdProc(@Param("firstName")String firstName, @Param("lastName")String lastName, @Param("phoneNo")String phoneNo);
	public String idToPwdHintQ(String userId);
	public String findPwdProc(@Param("userId")String userId, @Param("pwdHint")String pwdHint);
	public void attend(String userId);
	public MemberVO renew(String userId);
	public String loginCheck(@Param("userId")String userId, @Param("userPwd")String userPwd);
	public List<MemberVO> getList();
	public List<MemberVO> getRankListWithPaging(Criteria cri);
	// 내림차순 랭킹 조회
	public List<MemberVO> getRankList();
}
