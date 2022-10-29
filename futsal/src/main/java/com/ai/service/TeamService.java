package com.ai.service;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.ai.domain.TeamDTO;

@Service
public interface TeamService {
   public TeamDTO findBytName(String tName);
   public TeamDTO insert(TeamDTO insertTeam);
   public ArrayList<TeamDTO> findAll();
   
   @Query("{'tName':{'$regex':'?0','$options':'i'}}")
   public ArrayList<TeamDTO> findByTNameRegex(String tName);
}