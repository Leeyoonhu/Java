package com.ai.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "team")
public class TeamDTO {
   @Id
   private String _id; // 캡틴닉네임
   private String tName, uniform, tAge;
   private String tArea, TeamInfo, TeamMember, applyName;
   private String tName2, fName, rTime, foundingDate;
   private int tTotal, tManner;
   
   public TeamDTO() {}
}