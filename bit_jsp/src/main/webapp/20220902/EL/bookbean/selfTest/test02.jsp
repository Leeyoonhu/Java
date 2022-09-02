<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="org.ai.beans.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Bookbean book = new Bookbean();
	book.setTitle(request.getParameter("title"));
	book.setAuthor(request.getParameter("author"));
	book.setPublisher(request.getParameter("publisher"));
%>
${param.title} <br>
${param.author} <br>
${param.publisher}
</body>
</html>