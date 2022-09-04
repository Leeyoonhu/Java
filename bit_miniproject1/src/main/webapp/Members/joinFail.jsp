<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
<script type="text/javascript">
	alert("이미 존재하는 회원입니다.")
</script>
<form action="./joinForm.jsp">
<input type="submit" value="회원가입 하러가기">
</form>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<form action="./main.jsp">
<input type="submit" value="메인으로 가기">
</body>
</html>