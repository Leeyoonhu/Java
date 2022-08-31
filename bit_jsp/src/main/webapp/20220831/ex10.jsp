<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- request의 header 정보 확인하기 
	요새는 브라우저의 검색기(f12)에서 헤더 정보를 보여줌
-->
<% Enumeration<?> en = request.getHeaderNames(); 
	while(en.hasMoreElements()){
		String headerName = (String)en.nextElement();
		String headerValue = request.getHeader(headerName);	
%>
<%= headerName %> : <%= headerValue %> <br>
<%
}
%>
</body>
</html>