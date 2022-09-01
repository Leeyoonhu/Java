<%@page import="java.util.Enumeration"%>
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
	session.setAttribute("userId", "rose");
	session.setAttribute("userPwd", "1234");
	/* 세션에 값 2개 저장 */
	Enumeration e = session.getAttributeNames();
	/* userId의 값 출력해라 */
	out.println((String)session.getAttribute("userId"));
%>
</body>
</html>