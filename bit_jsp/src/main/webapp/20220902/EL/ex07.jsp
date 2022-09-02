<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 간단하게 header정보 뽑기 -->
<h3> JSP </h3>
<%
Enumeration<String> hnList = request.getHeaderNames();
while (hnList.hasMoreElements()){
	String key = hnList.nextElement();
	out.println(key + "<br>");
}
%>

${header}
</body>
</html>