<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 태그Ex04</title>
</head>
<body>
<%-- 
선언문 태그 <%! %>와, <% %>의 차이는 전역/지역 차이 
JSP 주석처리는 ctrl + shift + c
--%>
<%
	Date date = new Date();
	int hour = date.getHours();
	int one = 10;
	int two = 12;
%>
<%!
	public int operation(int i, int j){
		return i > j? i : j;
	}
%>
지금은 오전일까요? 오후일까요?
<%= (hour < 12)? "오전" : "오후" %> <p></p>
one과 two 둘 중에 큰 숫자는? 
<%= operation(one, two) %>
</body>
</html>