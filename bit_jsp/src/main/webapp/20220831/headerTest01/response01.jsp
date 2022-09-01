<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>headerTest</title>
</head>
<body>
<%@page import= "java.util.*" %> 
<%
response.setHeader("Cache-control", "use_cache");
response.addHeader("contentType", "text/html; charset=utf-8");
response.setDateHeader("date", 1L);
%>
Cache-control : <%=response.getHeader("Cache-control") %>
contentType : <%=response.getHeader("contentType") %>
date : <%=response.getHeader("date") %>
<p>이 페이지는 5초마다 갱신되고 있음</p>
<% response.setIntHeader("refresh", 5); %>
<p><%= new Date().getDate() %></p>
</body>
</html>