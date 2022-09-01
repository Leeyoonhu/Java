package org.ai.beans;
// 자바 빈즈
// 기본 생성자가 필수이며 모든 맴버는 private
// <jsp:useBean class="사용할 beans가 있는 패키지.클래스 명" id ="생성한 객체 이름" />	==> 기본 생성자 호출 태그
// <jsp:getProperty property="사용할 객체의 속성(변수/필드)" name="객체 명"  ==> getName
// <jsp:setProperty property="사용할 객체의 속성(변수/필드)" name="객체 명" value="객체의 속성(변수/필드) 값 지정"/> ==> setName
// <jsp:setProperty 에서 value대신 param = "@"일때, 주소창에서 name이 @인 값을 가져옴
public class HelloBean {
	private String name;
	private String number;
	public HelloBean() {
		this.name = "노네임";
		this.number = "노넘버";
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
