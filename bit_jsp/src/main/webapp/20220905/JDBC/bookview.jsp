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
String bookName = request.getParameter("bookName");
String publisher = request.getParameter("publisher");
String price = request.getParameter("price");
%>
<table border="1">
	<tr>
		<td>책 제 목</td>
		<td><%= bookName%></td>
	</tr>
	<tr>
		<td>출 판 사</td>
		<td><%= publisher%></td>
	</tr>
	<tr>
		<td>가 격</td>
		<td><%= price%></td>
	</tr>
	<tr>
		<td colspan="2" style="float: right"> <a href="./booklist.jsp">목록</a> </td>
	</tr>
</table>
</body>
</html>