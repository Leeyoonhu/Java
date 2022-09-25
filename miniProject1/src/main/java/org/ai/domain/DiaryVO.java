package org.ai.domain;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DiaryVO {
	private int dNumber;
	private String intro, nickName, title, content;
	private Date regDate;
}
