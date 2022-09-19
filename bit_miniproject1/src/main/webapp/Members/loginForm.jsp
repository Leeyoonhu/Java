<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<style type="text/css">

#loginForm {
display: inline-block;
	width: 1950px;
	height: AUTO;
	margin-bottom: 100px;
	text-align: center;
}
</style>
</head>
<body>
<script type="text/javascript" src="../Js/loginCheck.js"></script>
	<jsp:include page="./header.jsp"></jsp:include>
	<div id="loginForm">
		<h1 style="text-align: center; margin-bottom : 2.0rem; margin-top : 10.0rem;">로그인</h1>
		<h4 style="text-align: center">로그인 하시면 전군시의 모든 서비스를 이용 하실 수 있습니다.</h4>
		<h4 style="text-align: center; margin-bottom : 2.0rem;">아직 회원이 아니시면 회원가입을 해주세요.</h4>
		<form action="./loginProcess.jsp" method="post" name="loginForm">
				<input type="text" placeholder="아이디" name="userId"
				style="width: 490px; height: 30px; margin-bottom: 20px;"
				autofocus="autofocus" id="loginUserId"> <br> 
				<input type="password"
				placeholder="패스워드" name="userPwd" id="loginUserPwd"
				style="width: 490px; height: 30px; margin-bottom: 20px"> <br>
				<input type="button" value="로그인" id="tryLogin"
				style="opacity: 0.8; width: 490px; height: 30px; margin-bottom: 30px; background-color: rgb(167, 230, 167);"><br>		
			<div style="text-align: center; margin-bottom : 5.0rem;">
				<a href="./findIdForm.jsp">아이디 찾기</a> | <a href="./findPwdForm.jsp">비밀번호
					찾기</a> | <a href="./joinForm.jsp">회원가입</a>
			</div>
		</form>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>