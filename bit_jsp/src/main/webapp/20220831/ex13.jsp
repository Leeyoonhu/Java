<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 	5초마다 갱신되는 페이지 만들기 -->
	<%
	response.setHeader("Cache-control", "use_cache");
	response.addHeader("contentType", "text/html; charset=utf-8");
	response.setDateHeader("date", 1L);
	%>
	Cache-control :
	<%=response.getHeader("Cache-control")%>
	contentType:
	<%=response.getHeader("contentType")%>
	date :
	<%=response.getHeader("date")%>
	<p>이 페이지는 5초마다 새로고침 되고있음</p>
	<%
	response.setIntHeader("Refresh", 5);
	%>
	<p><%=(new Date())%></p>
</body>
</html>