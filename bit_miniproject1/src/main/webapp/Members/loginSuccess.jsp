<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공!</title>
<style type="text/css">
h1 {
	position: absolute;
	top : 50%;
	left : 50%;
	margin-left: -200px;
	margin-top: -100px;
}
a {
	position: absolute;
	top : 70%;
	left : 50%;
	margin-left: -100px;
	margin-top: -100px;
}
</style>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
%>
<h1>ROK ARMY의 <%=cookies[1].getValue() %>번째 회원!</h1>
<p style="position: absolute;
	top : 58%;
	left : 50%;
	margin-left: -100px;
	margin-top: -100px;
	font-size: 1.2em;"> 
	<%=cookies[0].getValue() %>님 어서오세요^^ </p> <br> 
<p style="position: absolute;
	top : 62%;
	left : 48%;
	margin-left: -100px;
	margin-top: -100px;
	font-size: 1.2em;">
	현재 경험치는 <%=cookies[2].getValue()%>입니다. <br>
</p>
<a href="./mainForm2.jsp">메인 홈페이지로 가기</a>
</body>
</html>