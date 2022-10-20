package com.ai.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "team")
public class TeamDTO {
   private String tName,captain, uniform, tAge;
   private String tArea, TeamInfo, TeamMember, applyName;
   private String tName2, fName, rTime, foundingDate;
   private int tTotal, tManner;
   
   public TeamDTO() {}

   public TeamDTO(String tName, String captain, String tArea, int tTotal, int tManner, String teamInfo,
         String teamMember, String applyName, String tName2, String fName, String rTime, String foundingDate,
         String uniform, String tAge) {
      super();
      this.tName = tName;
      this.captain = captain;
      this.tArea = tArea;
      this.tTotal = tTotal;
      this.tManner = tManner;
      this.TeamInfo = teamInfo;
      this.TeamMember = teamMember;
      this.applyName = applyName;
      this.tName2 = tName2;
      this.fName = fName;
      this.rTime = rTime;
      this.foundingDate = foundingDate;
      this.tAge = tAge;
   }  
}