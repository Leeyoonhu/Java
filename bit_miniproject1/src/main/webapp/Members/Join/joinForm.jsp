<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	position: absolute;
	top : 50%;
	left : 50%;
	margin-left: -300px;
	margin-top: -200px;
}
</style>
</head>
<body>
<form action="./joinProcess.jsp" method="post">
<h3>회원가입</h3>
	아이디 : <input type="text" name="userId" autofocus="autofocus"> <br>		
	비밀번호 : <input type="password" name="userPwd"> <br>
	비밀번호 확인 : <input type="password" name="checkPwd">	<br>
	닉네임 : <input type="text" name="nickName">	<br>
	성 :	<input type="text" name="firstName">
	이름 : <input type="text" name="lastName"> <br>
	전화번호 : <input type="tel" name="phoneNo"> <br>
	비밀번호 찾기 질문 :	<select name="pwdHintQ">
	<option>내가 태어난 곳은?</option>
	<option>내가 졸업한 초등학교는?</option>
	<option>내가 사는 지역은?</option>
	<option>나의 별명은?</option>
	<option>나의 보물 1호는?</option>
	</select> <br>
	비밀번호 찾기 답변 : <input type="text" name="pwdHint"> <br>
	직업 : 
	<input type="radio" name="userJob" id="soldier" value="soldier" checked="checked">
	<label for="soldier">군인</label>
	 <input type="radio" name="userJob" id="family" value="family">
	<label for="family">가족</label>
	 <input type="radio" name="userJob" id="normal" value="normal">
	 <label for="normal">일반인</label>
	 <input type="radio" name="userJob" id="girlfriend" value="girlfriend">
	 <label for="girlfriend">여자친구</label> 
	 <br>
	성별 : 
	<input type="radio" name="gender" id="male" value="male" checked="checked">
	<label for="male">남자</label>
	<input type="radio" name="gender" id="female" value="female"> 
	<label for="female">여자</label> <br>
	<input type="submit" value="회원가입 하기">
</form>

</body>
</html>