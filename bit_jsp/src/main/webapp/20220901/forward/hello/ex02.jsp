<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01을 hello.jsp로 보내기</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String str = request.getParameter("go");
	String letsGo = str + ".jsp";
%>
<jsp:forward page="<%=letsGo%>"></jsp:forward>
</body>
</html>