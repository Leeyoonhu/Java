package com.ai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ai.domain.FieldDTO;

public interface FieldRepository extends MongoRepository<FieldDTO, String> {
	FieldDTO findByfName(String fName);
}
