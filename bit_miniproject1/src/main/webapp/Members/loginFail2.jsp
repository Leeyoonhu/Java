<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패..</title>
<style type="text/css">
#loginFail2 {
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
<!-- 아이디는 있는데 암호가 틀렸을 때 가는 페이지 -->
<script type="text/javascript">
	alert("존재하지 않는 회원입니다.");
</script>
<jsp:include page="./header.jsp"></jsp:include>
<div id="content">
<div id="loginFail2">
	<form action="./loginForm.jsp">
		<input type="submit" value="로그인 하러가기">
	</form><br>
	<form action="./mainForm.jsp">
		<input type="submit" value="메인으로 가기"> 
	</form><br>
	<form action="./findIdForm.jsp">
		<input type="submit" value="아이디 찾기">
	</form> <br>
	<form action="./findPwdForm.jsp">
		<input type="submit" value="비밀번호 찾기">
	</form> <br>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>