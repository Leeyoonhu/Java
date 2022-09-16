package org.conan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
// 모든 생성자 생성
@NoArgsConstructor
// 기본 생성자 생성(디폴트 생성자)
public class SampleVO {
	private Integer mno;
	private String firstName, lastName;
}
