package org.ai.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class PageDTO {
	private int startPage; // 화면에 보여지는 페이지의 시작번호
	private int endPage; // 화면에 보여지는 페이지의 끝번호
	private boolean prev, next; // 이전 혹은 다음페이지 존재 여부
	private int total; // 전체 데이터 수 , list의 size
	private Criteria cri;

	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		// 올림 처리
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		// 진짜 endpage가 올림처리한 endpage보다 작으면 realend로 표현....
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
