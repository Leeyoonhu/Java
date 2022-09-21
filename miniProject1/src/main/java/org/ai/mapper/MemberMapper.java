package org.ai.mapper;

import org.ai.domain.MemberVO;

public interface MemberMapper {
	public MemberVO login(MemberVO vo);
	public int join(MemberVO vo);
}
