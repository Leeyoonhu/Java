package com.ai.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ai.domain.FieldDTO;

public interface FieldRepository extends MongoRepository<FieldDTO, String> {
	FieldDTO findByid(String id);
	ArrayList<FieldDTO> findAll();
}
