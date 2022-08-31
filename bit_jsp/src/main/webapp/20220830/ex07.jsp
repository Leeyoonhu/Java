<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현문 태그Ex03</title>
</head>
<body>
<h3>구구단 출력</h3>
<%
for(int i = 2; i < 10; i++){
	for(int j = 1; j < 10; j++){%>
	<%= i %> * <%= j %> = <%= i * j %><br>
	<%
	}%><br><%
}%>
</body>
</html>