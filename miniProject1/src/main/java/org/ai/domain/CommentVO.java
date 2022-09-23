package org.ai.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CommentVO {
	private Integer comNumber;
	private int number;
	private String writer, comment, regDate;
	public CommentVO() {
	}
	
	public CommentVO(int number) {
		this.number = number;
	}
	public CommentVO(Integer comNumber) {
		this.comNumber= comNumber;
	}
	public CommentVO(Integer comNumber, int number,  String writer, String comment, String regDate) {
		this.comNumber = comNumber;
		this.number = number;
		this.writer = writer;
		this.comment = comment;
		this.regDate = regDate;
	}
}
