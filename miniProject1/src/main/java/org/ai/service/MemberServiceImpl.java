package org.ai.service;

import javax.servlet.http.HttpSession;

import org.ai.domain.MemberVO;
import org.ai.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService {
	@Setter(onMethod_ = @Autowired)
	MemberMapper mapper;
	
	@Override
	public MemberVO login(MemberVO vo) {
		// TODO Auto-generated method stub
		MemberVO memberVO  =mapper.login(vo);
		
		return memberVO!=null ? memberVO : null;
	}

	@Override
	public boolean join(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.join(vo) == 1 ? true : false;
	}

	@Override
	public String idCheck(String userId) {
		// TODO Auto-generated method stub
		// js에서 받은 result가 notnull이면 존재..
		return mapper.idCheck(userId);
	}

	@Override
	public String nickCheck(String nickName) {
		// TODO Auto-generated method stub
		return mapper.nickCheck(nickName);
	}

	@Override
	public String pNCheck(String phoneNo) {
		// TODO Auto-generated method stub
		return mapper.pNCheck(phoneNo);
	}
	
	

}
