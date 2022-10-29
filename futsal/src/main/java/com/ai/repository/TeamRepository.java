package com.ai.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ai.domain.TeamDTO;

public interface TeamRepository extends MongoRepository<TeamDTO, String> {
   TeamDTO findBytName(String tName);
   TeamDTO insert(TeamDTO insertTeam);
   ArrayList<TeamDTO> findAll();
   
   @Query("{'tName':{'$regex':'?0','$options':'i'}}")
   ArrayList<TeamDTO> findByTNameRegex(String tName);
}
