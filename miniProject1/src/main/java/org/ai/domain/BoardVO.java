package org.ai.domain;

import java.sql.Blob;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	private int number, views, recommends;
	private String title, content, writer, imageFileName, fileName, boardTitle;
	private Date regDate;
	
	public BoardVO() {
	}
//	출력 생성자
	public BoardVO(int number, int views, int recommends, String title, String content, String writer, String imageFileName,
			String fileName, String boardTitle, Date regDate) {
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
	public BoardVO(String title, String content, String writer, String imageFileName, String fileName, String boardTitle) {
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.imageFileName = imageFileName;
	this.fileName = fileName;
	this.boardTitle = boardTitle;
	}

	
}
