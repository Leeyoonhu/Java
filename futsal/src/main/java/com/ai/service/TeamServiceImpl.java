package com.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ai.domain.TeamDTO;
import com.ai.repository.TeamRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Repository
public class TeamServiceImpl implements TeamService {
   @Autowired
   TeamRepository teamRepository;

   public TeamDTO findBytName(String tName) {
      TeamDTO team = teamRepository.findBytName(tName);
      try {
         if(teamRepository.findBytName(tName) == null) {
            return null;
         }
         else { // 검색한 팀이 존재하면 
            return team;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return team;
   }

   
   @Override 
   public TeamDTO insert(TeamDTO insertTeam) { 
      TeamDTO insertedTeam = teamRepository.insert(insertTeam); 
      return insertedTeam; 
   }
}