package org.ai.service;

import org.ai.domain.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO vo);
	public boolean join(MemberVO vo);
}
