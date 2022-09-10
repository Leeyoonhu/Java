<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 성공!</title>
<style type="text/css">
#joinSuccess {
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
<jsp:include page="./header.jsp"></jsp:include>
<div id="content">
<div id="joinSuccess">
<h3>회원 가입을 축하드립니다</h3> <br>
<form action="./loginForm.jsp" method="post">
<input type="submit" value="로그인 하러가기">
</form>
<form action="./mainForm.jsp" method="post">
<input type="submit" value="메인으로 가기">
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>