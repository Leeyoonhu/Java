package org.ai.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CommentVO {
	private int cNumber, number;
	private String writer, comment, regDate;
	public CommentVO() {
	}
	
	public CommentVO(int number) {
		this.number = number;
	}
	public CommentVO(int cNumber, int number,  String writer, String comment, String regDate) {
		this.cNumber = cNumber;
		this.number = number;
		this.writer = writer;
		this.comment = comment;
		this.regDate = regDate;
	}
}
