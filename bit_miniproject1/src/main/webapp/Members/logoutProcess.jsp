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
<!-- 세션 다 죽이고 메인폼 보내야함 -->
<%
Enumeration<String> en = session.getAttributeNames();
if(en.hasMoreElements()){
	session.invalidate();
}
response.sendRedirect("./mainForm.jsp");
%>
</body>
</html>