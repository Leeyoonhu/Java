package com.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.domain.MemberDTO;
import com.ai.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemberServiceImpl implements MemberService{
   @Autowired
   MemberRepository memberRepository;
   
   @Override
   public MemberDTO insert(MemberDTO insertMember) {
      // TODO Auto-generated method stub
       MemberDTO insertedMember = memberRepository.insert(insertMember); 
        return insertedMember;
      
   }
}