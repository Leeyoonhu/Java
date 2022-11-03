package com.ai.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
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
   TeamRepository repo;

   public TeamDTO findBytName(String tName) {
      TeamDTO team = repo.findBytName(tName);
      try {
         if(repo.findBytName(tName) == null) {
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
      TeamDTO insertedTeam = repo.insert(insertTeam); 
      return insertedTeam; 
   }
   @Override
   public ArrayList<TeamDTO> findAll() {
      // TODO Auto-generated method stub
      ArrayList<TeamDTO> tList = (ArrayList<TeamDTO>) repo.findAll();
      return tList;
   }


   @Override
   public ArrayList<TeamDTO> findByTNameRegex(String tName) {
      // TODO Auto-generated method stub
      ArrayList<TeamDTO> teams = repo.findByTNameRegex(tName);
      return teams;
   }
}