package com.ai.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.MemberDTO;

public interface MemberRepository extends MongoRepository<MemberDTO, String> {
	MemberDTO findByid(@RequestParam("_id") String _id);

	MemberDTO insert(MemberDTO joinMember);

	MemberDTO findByPhoneNo(@RequestParam("phoneNo") String phoneNo);

	MemberDTO findByNickName(@RequestParam("nickName") String nickName);

	MemberDTO save(MemberDTO member);
}