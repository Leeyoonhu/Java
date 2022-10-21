//package com.ai.repository;
//
//import java.util.ArrayList;
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import com.ai.domain.FieldDTO;
//import com.ai.domain.ReserveDTO;
//
//public interface ReserveRepository extends MongoRepository<FieldDTO, String> {
//   ArrayList<ReserveDTO> findAll(String tName);
//}