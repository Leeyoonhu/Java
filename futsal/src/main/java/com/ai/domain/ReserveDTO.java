package com.ai.domain;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


@Data
@Document(collection = "reserve")
public class ReserveDTO {
	@Id
	private String id;
// 구장
	private String name, price, date, time, phoneNo, type; 
	private String state; 
// 예약상태 ==> b 예약시 rState = B로 바꾸고, 예약페이지에서 rState가 B일경우 || type이 all일경우는 예약불가
// type이 all이면 tName2,rDate2에도 tName1,rDate1값이 들어가야함==> 컨트롤러에서 처리

// A팀   
	private String nickNameA, nameA, dateA;
// B팀   
	private String nickNameB, nameB, dateB;
/* 일단 필요 없을듯   
   private Integer hadPoint; */
   
//   public ReserveDTO() {}
}
