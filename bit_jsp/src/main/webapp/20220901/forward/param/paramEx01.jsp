<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paramEx01-Ex02</title>
</head>
<body>
	<jsp:forward page="./paramEx02.jsp">
		<jsp:param value='admin' name="userId"/>
		<jsp:param value='<%=URLEncoder.encode("관리자") %>' name="name"/>
	</jsp:forward>
	<p>Java Server Page
</body>
</html>