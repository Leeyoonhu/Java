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
<!-- 다중 세션 정보 얻기 -->
<%
Enumeration e = session.getAttributeNames(); 
while(e.hasMoreElements()){	/* 열거 타입 변수 e가 요소를 가지고 있다면 */
	String name = e.nextElement().toString();	
	String value = session.getAttribute(name).toString();
}

%>
</body>
</html>