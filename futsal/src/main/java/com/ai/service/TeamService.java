package com.ai.service;

import com.ai.domain.TeamDTO;

public interface TeamService {
   public TeamDTO findBytName(String tName);
   public TeamDTO insert(TeamDTO insertTeam);
}