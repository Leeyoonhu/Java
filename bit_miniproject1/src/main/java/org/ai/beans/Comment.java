package org.ai.beans;

public class Comment {
	private int number;
	private String writer, comment, regDate;
	public Comment() {
	}
	public Comment(int number, String writer, String comment, String regDate) {
		this.number = number;
		this.writer = writer;
		this.comment = comment;
		this.regDate = regDate;
	}
	public int getNumber() {
		return number;
	}
	public String getWriter() {
		return writer;
	}
	public String getComment() {
		return comment;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
