package com.ai.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.ReserveDTO;

public interface ReserveRepository extends MongoRepository<ReserveDTO, String> {
	ReserveDTO findByFieldAndNameAAndDateAndTime(@RequestParam("name") String name, @RequestParam("tName1") String tName1, @RequestParam("fDate") String fDate, @RequestParam("fTime") String fTime);
	ReserveDTO findByFieldAndDateAndTime(@RequestParam("name") String name, @RequestParam("fDate") String fDate, @RequestParam("fTime") String fTime);
	ReserveDTO insert(ReserveDTO reserve);
	ReserveDTO save(ReserveDTO reserve);
	ArrayList<ReserveDTO> findByField(String name);
}
