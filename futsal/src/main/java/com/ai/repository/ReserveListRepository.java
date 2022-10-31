package com.ai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ai.domain.ReserveListDTO;

public interface ReserveListRepository extends MongoRepository<ReserveListDTO, String> {

}
