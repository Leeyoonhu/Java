package com.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ai.domain.MemberDTO;
import com.ai.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemberServiceImpl implements MemberService{
   @Autowired
   MemberRepository memberRepository;
   
   @Override
   public MemberDTO insert(MemberDTO joinMember) {
      // TODO Auto-generated method stub
       MemberDTO joinedMember = memberRepository.insert(joinMember); 
       return joinedMember;
      
   }

	@Override
	public MemberDTO findByPhoneNo(String phoneNo) {
		MemberDTO member = memberRepository.findByPhoneNo(phoneNo);
		return member;
	}

	@Override
	public MemberDTO findByNickName(String nickName) {
		MemberDTO member = memberRepository.findByNickName(nickName);
		return member;
	}

	@Override
	public MemberDTO findBy_id(String _id) {
		MemberDTO member = memberRepository.findBy_id(_id);
		return member;
	}

	@Override
	public void save(MemberDTO member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
	}
}