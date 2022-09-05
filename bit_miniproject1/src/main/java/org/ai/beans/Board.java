package org.ai.beans;

import java.sql.Blob;

public class Board {
	private int number, views, recommends;
	private String title, content, writer;
	private java.sql.Blob image, file;
	private String regDate;
	public Board() {
	}
//	출력 생성자
	public Board(int number, int views, int recommends, String title, String content, String writer, Blob image,
			Blob file, String regDate) {
		this.number = number;
		this.views = views;
		this.recommends = recommends;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.image = image;
		this.file = file;
		this.regDate = regDate;
	}
//	입력 생성자
	public Board(String title, String content, String writer, Blob image, Blob file) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.image = image;
		this.file = file;
	}
	public int getNumber() {
		return number;
	}
	public int getViews() {
		return views;
	}
	public int getRecommends() {
		return recommends;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public java.sql.Blob getImage() {
		return image;
	}
	public java.sql.Blob getFile() {
		return file;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public void setRecommends(int recommends) {
		this.recommends = recommends;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setImage(java.sql.Blob image) {
		this.image = image;
	}
	public void setFile(java.sql.Blob file) {
		this.file = file;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
