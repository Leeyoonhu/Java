<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 실패..</title>
<style type="text/css">
body {
	position: absolute;
	top: 45%;
	left: 40%;
}
form {
	display: inline-block;
}
</style>
</head>
<body>
<!-- 회원 가입시 아이디가 존재하는 경우 -->
<!--  -->
<script type="text/javascript">
	alert("입력하신 비밀번호와 비밀번호 확인이 다릅니다..")
</script>
<form action="./joinForm.jsp" method="post">
<input type="submit" value="다시 회원가입 하러가기">
</form>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<form action="./mainForm.jsp" method="post">
<input type="submit" value="메인으로 가기">
</body>
</html>