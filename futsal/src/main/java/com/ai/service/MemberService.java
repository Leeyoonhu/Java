package com.ai.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.MemberDTO;

public interface MemberService {
   public MemberDTO insert(MemberDTO joinMember);
   public MemberDTO findByPhoneNo(@RequestParam("phoneNo") String phoneNo);
   public MemberDTO findByNickName(@RequestParam("nickName") String nickName);
}