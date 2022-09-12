package org.ai.beans;

import java.sql.Blob;

public class Board {
	private int number, views, recommends;
	private String title, content, writer, imageFileName, fileName, boardTitle;
	private String regDate;
	
	public Board() {
	}
//	출력 생성자
	public Board(int number, int views, int recommends, String title, String content, String writer, String imageFileName,
			String fileName, String boardTitle, String regDate) {
		this.number = number;
		this.views = views;
		this.recommends = recommends;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.imageFileName = imageFileName;
		this.fileName = fileName;
		this.boardTitle = boardTitle;
		this.regDate = regDate;
	}
	
	
//	입력 생성자
	public Board(String title, String content, String writer, String imageFileName, String fileName, String boardTitle) {
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.imageFileName = imageFileName;
	this.fileName = fileName;
	this.boardTitle = boardTitle;
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

	public String getImageFileName() {
		return imageFileName;
	}

	public String getFileName() {
		return fileName;
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

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	
}
