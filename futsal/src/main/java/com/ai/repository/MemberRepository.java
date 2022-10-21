package com.ai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ai.domain.FieldDTO;
import com.ai.domain.MemberDTO;
import com.ai.domain.TeamDTO;

public interface MemberRepository extends MongoRepository<MemberDTO, String>{
   MemberDTO insert(MemberDTO joinMember);

}