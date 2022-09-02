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
Cookie[] cookies = request.getCookies();
%>
<%=cookies[0].getValue() %>님 안녕하세요 <br>
<a href="./updateForm.jsp">회원정보 수정</a>
</body>
</html>