<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginFrm-17</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
session.setAttribute("userId", userId);
session.setMaxInactiveInterval(60 * 1);
%>
<form action="./ex18.jsp" method ="post">
<h1>Session 예제</h1>
	<p>1. 가장 좋아하는 계절은?</p>
	<input type="radio" name="season" value="봄">봄
	<input type="radio" name="season" value="여름">여름
	<input type="radio" name="season" value="가을">가을
	<input type="radio" name="season" value="겨울">겨울
	<p>2. 가장 좋아하는 과일은?</p>
	<input type="radio" name="fruit" value="수박">수박
	<input type="radio" name="fruit" value="사과">사과
	<input type="radio" name="fruit" value="복숭아">복숭아
	<input type="radio" name="fruit" value="딸기">딸기
	<br><br>
	<input type="submit" value="결과보기">
</form>
</body>
</html>