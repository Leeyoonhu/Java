package org.ai.domain;

import lombok.ToString;

@ToString
public class Criteria {
	// 검색의 기준 Criteria
	// 페이지 번호
	private int pageNum; 
	// 한 페이지에 출력되는 데이터 수
	private int amount; 
	
	public Criteria() {
		this(1, 10);
	}
	
	// mySQL에서 limit을 고려함
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum; 
		this.amount = amount;
	}

	public void setPageNum(int pageNum) {
		if (pageNum <= 0) {
			this.pageNum = 1;
			return;
		}
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		return this.pageNum;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	// limit구문에서 시작 위치 지정
	public int getPageStart() { 
		return (this.pageNum - 1) * this.amount;
	}
}
