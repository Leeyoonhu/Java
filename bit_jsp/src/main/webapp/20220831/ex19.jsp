<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 객체</title>
</head>
<body>
<!-- 웹 애플리케이션마다 하나씩 서비스가 시작될 때 생성 -->
<!-- 가급적이면 모두가 접속 가능한 애플리케이션에 사용자 정보를 저장하지말것 -->
<!-- web.xml에 다음 내용 추가 후 서버 재시작 -->
<!-- 프로젝트 우클릭 >> Java EE tools >> Generate... >> WEB-INF안에 web.xml 생성 -->
<!-- web.xml에 저장된 adminId와 Pwd값 출력 -->
관리자 아이디 : <%=application.getInitParameter("adminId") %>
관리자 비밀번호 : <%=application.getInitParameter("adminPwd") %>
</body>
</html>