package org.conan.mapper;

import org.apache.ibatis.annotations.Select;

//Spring과 연동처리할것임
//인터페이스 클래스를 만들고, Spring으로 작동시키게
public interface TimeMapper {
	@Select("select now()")
	public String getTime();
	public String getTime2();
//	getTime2()는 xml 파일로 구현할것임
}
