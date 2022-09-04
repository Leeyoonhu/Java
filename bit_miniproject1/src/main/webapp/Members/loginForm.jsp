<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
body {
	position: absolute;
	top : 50%;
	left : 50%;
	margin-left: -300px;
	margin-top: -250px;
}
</style>
</head>
<body>
<h3 style="text-align: center">로그인</h3>
<h4 style="text-align: center">정보를 입력하세요</h4>
<form action="./loginProcess.jsp" method="post">
	<input type ="text" placeholder ="아이디" name ="userId" style="width: 490px; height: 30px; margin-bottom: 10px" > <br>
	<input type="password" placeholder="패스워드" name="userPwd" style="width: 490px; height: 30px; margin-bottom: 10px"> <br>
	<input type="submit" value ="로그인" style="text-align: center; opacity: 0.8; width: 500px; height: 30px; margin-bottom: 30px"> <br>
 	<div style="text-align: center"><a href="./findIdForm.jsp">아이디 찾기</a> | <a href="./findPwdForm.jsp">비밀번호 찾기</a> | <a href="./joinForm.jsp">회원가입</a> </div>
</form>
</body>
</html>