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
}