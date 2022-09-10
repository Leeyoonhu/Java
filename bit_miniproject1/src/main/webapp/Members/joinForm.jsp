<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
#joinForm {
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
<jsp:include page="./aside.jsp"></jsp:include>
<div id="joinForm">
<form action="./joinProcess.jsp" method="post">
<h3>회원가입</h3>
	아이디 : <input type="text" name="userId" autofocus="autofocus"> <br>		
	비밀번호 : <input type="password" name="userPwd"> <br>
	비밀번호 확인 : <input type="password" name="checkPwd">	<br>
	<!-- 현재 userPwd와 checkPwd가 다를경우 판별을 submit 이후에 하고있기때문에 입력했을 당시 다른지 알려주려면 어떻게할까 -->
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
	 <!-- 군인 > 남자 / 여자친구 > 여자로 자동체크 될 방법 생각해보기 -->
	성별 : 
	<input type="radio" name="gender" id="male" value="male" checked="checked">
	<label for="male">남자</label>
	<input type="radio" name="gender" id="female" value="female"> 
	<label for="female">여자</label> <br>
	<input type="submit" value="회원가입 하기">
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>