package org.ai.mapper;

import org.ai.domain.MemberVO;

public interface MemberMapper {
	public MemberVO login(MemberVO vo);
	public int join(MemberVO vo);
	
	public String idCheck(String userId);
	public String nickCheck(String nickName);
	public String pNCheck(String phoneNo);

}
