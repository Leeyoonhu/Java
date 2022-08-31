<!-- 에러가 날 경우 핸들링 하기 위한 에러핸들러 추가 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAGE 디렉티브 태그Ex03</title>
</head>
<body>
<%@ page errorPage = "errHandler.jsp" %>
<!-- 페이지 에러가 날 경우 해당 파일 사용 -->
<%
int one = 1;
int zero = 2;
%>
one과 zero의 사칙연산 <p></p>
one + zero <%= one + zero %> <p>
one - zero <%= one - zero %> <p>
one * zero <%= one * zero %> <p>
one / zero <%= one / zero %> <p>
</body>
</html>