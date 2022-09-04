<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form {
	display: inline-block;
}
</style>
</head>
<body>
<!-- 아이디 찾기에 입력받을 정보.. -->
<!-- 입력받은 값들 중에서 화면을 보고있는 유저가 잘 기억할만한걸로 -->
<!-- 이름과 전화번호로 아이디를 찾음 -->
<h1 style="
position: absolute;
	top: 27%;
	left: 40%;">아이디 찾기</h1>
<form action="./findIdProcess.jsp" method="post">
<p style="
position: absolute;
	top: 34%;
	left: 38%;"> 성 : <input type="text" name="firstName"> </p> <br>
<p style="
position: absolute;
	top: 37%;
	left: 38%;"> 이름 : <input type="text" name="lastName"> </p> <br>
	<p style="
position: absolute;
	top: 40%;
	left: 38%;"> 전화번호 : <input type="tel" name="phoneNo"> </p> <br>
	<p style="
position: absolute;
	top: 45%;
	left: 43%;"> <input type="submit" value="조회하기"></p>
</form>	
</body>
</html>