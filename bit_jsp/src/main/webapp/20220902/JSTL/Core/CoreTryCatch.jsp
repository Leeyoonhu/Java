<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 예외 처리 -->
<% 
String str = request.getParameter("msg");
%>
<c:catch var="e">
<!-- 예외가 났을 경우의 변수 e 선언// 예외 처리 변수 -->
<% if(str.equals("add")){
	out.print(str);	
}%>
</c:catch>
<c:out value="${e }"></c:out>
<!-- 예외경우의 e 출력 -->
</body>
</html>