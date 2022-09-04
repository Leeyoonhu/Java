<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	alert("입력하신 정보를 가진 회원이 없거나 질문/답변이 틀렸습니다.")
</script>
<form action="./findIdForm.jsp" method="post">
<input type="submit" value="아이디 찾기">
</form>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<form action="./findPwdForm.jsp" method="post">
<input type="submit" value="다시 비밀번호 찾기">
</body>
</html>
</body>
</html>