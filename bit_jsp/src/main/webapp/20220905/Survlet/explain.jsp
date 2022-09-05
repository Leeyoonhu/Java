<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	서블릿(Servlet) : 일반 자바 프로그램을 통해 웹 컨텐츠 표현 (MVC에서 C역할)
	OS 나 HW 영향 x
	MVC pattern을 쉽게 적용할 수 있음 (model - view - controller) => 스프링에선 이 구조를 기본으로 함
	단점 : 개발 관리가 어려움
	오픈 소스 프레임 워크가 있음
	*.java파일
	
	여태 Jsp로 작업했지만 Tomcat에서 Servlet으로 변경 해줬던것임	
	Servlet으로 변환된 JSP 는 _jsplnit() 메소드에 의해 실행됨 => Ready 상태 (딱 한번만)
	이후 사용자 요청은 _jspServlet
	
	method = "post" => doPost()로 사용자 요청 처리
	method = "get" => doGet()으로 사용자 요청 처리 
	생명주기
	init() : 서블릿 실행시 한번만 실행
	service() : 사용자 요청시 매번 호출되는 메소드
	destroy() : 서블릿 종료 시 실행되는 메소드
	
	
-->
</body>
</html>