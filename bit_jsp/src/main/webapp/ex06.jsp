<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현문 태그Ex02</title>
</head>
<body>
<%
	int a = 10;
	int b = 20;
	int c = 30;
// 표현문 태그로 바로 출력 가능
%>
<%= a + b + c %>
</body>
</html>