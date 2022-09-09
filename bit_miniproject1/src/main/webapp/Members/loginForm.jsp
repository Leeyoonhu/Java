<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<style type="text/css">

container {
	position: relative;
	top: 50%;
	left: 50%;
	margin-left: -300px;
	margin-top: 0px;
}

</style>
</head>
<body>
	<%@ include file="./header.jsp"	%>
	<div class="container">
		<h1 style="text-align: center; margin-bottom : 2.0rem; margin-top : 10.0rem;">로그인</h1>
		<h4 style="text-align: center">로그인 하시면 전군시의 모든 서비스를 이용 하실 수 있습니다.</h4>
		<h4 style="text-align: center; margin-bottom : 2.0rem;">아직 회원이 아니시면 회원가입을 해주세요.</h4>
		<form action="./loginProcess.jsp" method="post">
			
				<input type="text" placeholder="아이디" name="userId"
				style="position : relative; right : -310px; width: 490px; height: 30px; margin-bottom: 20px;"
				autofocus="autofocus"> <br> 
				<input type="password"
				placeholder="패스워드" name="userPwd"
				style="position : relative; right : -310px; width: 490px; height: 30px; margin-bottom: 20px"> <br>
				<input type="submit" value="로그인"
				style="position : relative; right : -310px; text-align: center; opacity: 0.8; width: 490px; height: 30px; margin-bottom: 30px; background-color: rgb(167, 230, 167);"><br>
			
			<div style="text-align: center; margin-bottom : 5.0rem;">
				<a href="./findIdForm.jsp">아이디 찾기</a> | <a href="./findPwdForm.jsp">비밀번호
					찾기</a> | <a href="./joinForm.jsp">회원가입</a>
			</div>
		</form>
	</div>
	<%@ include file="./footer.jsp"%>
</body>
</html>