package com.ai.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "member")
public class MemberDTO {
   private String userId; //카카오구글네이버에서 받아온 이메일값, 프라이머리키
   private String name, Nickname, sex;
//   private String birthday; // 타입어떻게하지?
   private String phoneNo;
   private LocalDateTime regDate; //가입날짜
   private String platform; //소셜로그인어떤거했는지
   private String tName; //회원가입시는 null, 팀생성할때들어감
   private int hadPoint; // 보유포인트, 회원가입시 0
}