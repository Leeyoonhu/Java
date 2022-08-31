<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제(08-09)09</title>
<style type="text/css">
</style>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String color = request.getParameter("color");

if(color.equals("붉은색")){%>
	<body bgcolor="red"><%}
else if(color.equals("초록색")){%>
	<body bgcolor="green"><%}
else if(color.equals("파란색")){%>
	<body bgcolor="blue"><%}%>
<h1>If-else Example</h1>
<strong><%=name%></strong>님이 좋아하는 색깔은 <strong><%=color%></strong>입니다.

</body>
</html>