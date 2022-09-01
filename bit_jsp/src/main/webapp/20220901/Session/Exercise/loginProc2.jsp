<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String id2 = application.getInitParameter("adminId");
String pwd2 = application.getInitParameter("adminPwd");
%>
<%
if ((id.equalsIgnoreCase(id2) && pwd.equalsIgnoreCase(pwd2))){
	session.setAttribute("userId", id); %>
	로그인에 성공했음 <br>
	<a href="./loginChk.jsp" >로그인 정보 확인</a>
<%}
%>
</body>
</html>