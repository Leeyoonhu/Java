package com.ai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.MemberDTO;

public interface MemberRepository extends MongoRepository<MemberDTO, String>{
   MemberDTO insert(MemberDTO joinMember);
   MemberDTO findByPhoneNo(@RequestParam("phoneNo") String phoneNo);
   MemberDTO findByNickName(@RequestParam("nickName") String nickName);
   MemberDTO findBy_id(@RequestParam("_id") String _id);
   MemberDTO save(MemberDTO member);
}