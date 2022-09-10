<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#findPwdForm {
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
<!-- 비밀번호 찾기에 입력받을 정보.. -->
<!-- 아이디와 질문, 질답이 같으면.. 비밀번호 알려줌.. -->
<jsp:include page="./header.jsp"></jsp:include>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="findPwdForm">
<h1>비밀번호 찾기</h1>
<form action="./findPwdProcess.jsp" method="post">
<p> 아이디 : <input type="text" name="userId" autofocus="autofocus"> </p> <br>
<p> 
	비밀번호 찾기 질문 :	<select name="pwdHintQ">
	<option>내가 태어난 곳은?</option>
	<option>내가 졸업한 초등학교는?</option>
	<option>내가 사는 지역은?</option>
	<option>나의 별명은?</option>
	<option>나의 보물 1호는?</option>
	</select> <br>
	<p> 비밀번호 찾기 답변 : <input type="text" name="pwdHint"> <br>
	<p> <input type="submit" value="비밀번호 조회하기"></p>
</form>
<form action="./findIdForm.jsp" method="post">
<p> <input type="submit" value="아이디 찾기"> </p>
</form>
<form action="./mainForm.jsp" method="post">
<p> <input type="submit" value="메인으로"> </p>
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>