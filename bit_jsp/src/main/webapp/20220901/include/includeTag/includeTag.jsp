<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includeTag-Top</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name = "장미장미";
%>
<jsp:include page="includeTagTop.jsp"></jsp:include>
include ActionTag 의 Body임 
</body>
</html>