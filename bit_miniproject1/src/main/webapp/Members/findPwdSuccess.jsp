<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<body>
<%
Cookie[] cookies = request.getCookies();
%>
<p style="font-size: 1.3em">회원님의 비밀번호는 
<strong style="font-size: 1.6em"><%=cookies[0].getValue()%></strong> 
입니다</p>
<!-- 쿠키 죽여야함 -->
<%
for(int i = 0; i < cookies.length; i++){
	cookies[i].setMaxAge(0);
	response.addCookie(cookies[i]);
}
%>
<form action="./loginForm.jsp">
<input style="margin-left: 40px" type="submit" value="로그인 하러가기" method="post">
</form>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<form action="./mainForm.jsp" method="post">
<input type="submit" value="메인으로 가기">
</body>
</html>