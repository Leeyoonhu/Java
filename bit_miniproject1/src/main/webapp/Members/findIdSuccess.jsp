<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 성공!</title>
<style type="text/css">
body {
	position: absolute;
	top: 42%;
	left: 35%;
}
form {
	display: inline-block;
}
</style>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
%>
<p style="font-size: 1.3em">회원님의 아이디는 
<strong style="font-size: 1.6em"><%=cookies[0].getValue()%></strong> 
입니다</p>
<form action="./loginForm.jsp">
<input style="margin-left: 40px" type="submit" value="로그인 하러가기" method="post">
</form>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<form action="./findPwdForm.jsp" method="post">
<input type="submit" value="비밀번호 찾기">
</body>
</html>