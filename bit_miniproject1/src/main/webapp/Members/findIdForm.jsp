<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style type="text/css">
#findIdForm {
	display: inline-block;
	float: right;
	width: 1400px;
	height: 1800px;
	margin-top: 200px;
	text-align: center;
}
</style>
</head>
<body>
<!-- 아이디 찾기에 입력받을 정보.. -->
<!-- 입력받은 값들 중에서 화면을 보고있는 유저가 잘 기억할만한걸로 -->
<!-- 이름과 전화번호로 아이디를 찾음 -->
<jsp:include page="./header.jsp"></jsp:include>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="findIdForm">
<h1>아이디 찾기</h1>
<form action="./findIdProcess.jsp" method="post">
<p style="margin-top: 50px"> 성 : <input type="text" name="firstName" autofocus="autofocus"> </p>
<p> 이름 : <input type="text" name="lastName"> </p>
	<p> 전화번호 : <input type="tel" name="phoneNo"> </p>
	<p style="display:inline-block;"> <input type="submit" value="아이디 조회하기"></p>
</form>
<form action="./mainForm.jsp">
<p><input type="submit" value="메인으로"> </p>
</form>
<form action="./findPwdForm.jsp" method="post">
<input type="submit" value="비밀번호 찾기"> </p>
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>