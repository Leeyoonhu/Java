package org.ai.service;

import org.ai.domain.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO vo);
	public boolean join(MemberVO vo);
	public String idCheck(String userId);
	public String nickCheck(String nickName);
	public String pNCheck(String phoneNo);
}
