package com.ai.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.MemberDTO;

@Service
public interface MemberService {
   public MemberDTO insert(MemberDTO joinMember);
   public MemberDTO findByPhoneNo(@RequestParam("phoneNo") String phoneNo);
   public MemberDTO findByNickName(@RequestParam("nickName") String nickName);
   public MemberDTO findBy_id(@RequestParam("_id") String _id);
   public void save(MemberDTO member);
}