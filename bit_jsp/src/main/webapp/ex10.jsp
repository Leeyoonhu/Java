<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 태그Ex02</title>
</head>
<body>
<%! int sum(int a, int b){
	return a + b;
}
// 메서드 sum 선언
%>
<%
	out.println("2 + 3 = " + sum(2,3));
%>
</body>
</html>