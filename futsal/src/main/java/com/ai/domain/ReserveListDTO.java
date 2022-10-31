package com.ai.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "reservelist")
public class ReserveListDTO {
// 구장신청 B리스트
	@Id
	private String id;
// 구장 (예약 리스트에 보여줄 구장 정보)
	private String field, price, date, time; 
// 신청 팀 정보
	private String team;
// 예약 신청자 정보
	private String nickName, regDate;
}
