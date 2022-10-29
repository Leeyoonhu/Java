package com.ai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.ReserveDTO;

public interface ReserveReposiotry extends MongoRepository<ReserveDTO, String> {
	ReserveDTO findByNameAndNameAAndTime(@RequestParam("name") String name, @RequestParam("tName1") String tName1, @RequestParam("fTime") String fTime);
	ReserveDTO insert(ReserveDTO reserve);
}
