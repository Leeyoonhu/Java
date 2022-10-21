//package com.ai.domain;
//
//import java.time.LocalDateTime;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import lombok.Data;
//
//@Data
//@Document(collection = "reserve")
//public class ReserveDTO {
//   @Id
//   private String nickName, fName, fPrice ;
//   private LocalDateTime rDate1; //A팀이구장대여한시간
//   private String rTime; //구장사용할시간
//   private String fPhoneNo; //구장연락처
//   private String rState; //예약상태
//   private String tName1; // 구장대여한팀이름
//   private String type; // 구장대여한팀이 모르는상대받을지, 혼자다쓸지
//   // 혼자다쓰는 type이면 tName2,rDate2에도 tName1,rDate1값이 들어가야함
//   private String tName2;
//   private LocalDateTime rDate2; //B팀이 도전하기 한 시간
//   private int hadPoint; //?? 대가리포인트가뭐지 그냥 drawio에 있길래 넣음
//   
//   
//   public ReserveDTO() {}
//
//   
//
//}