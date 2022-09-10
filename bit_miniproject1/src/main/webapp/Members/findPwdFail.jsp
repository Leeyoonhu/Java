<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#findPwdFail {
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
<!-- 회원 가입시 아이디가 존재하는 경우 -->
<!--  -->
<script type="text/javascript">
	alert("입력하신 정보를 가진 회원이 없거나 질문/답변이 틀렸습니다.")
</script>
<jsp:include page="./header.jsp"></jsp:include>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="findPwdFail">
<form action="./findIdForm.jsp" method="post">
<input type="submit" value="아이디 찾기">
</form>
<form action="./findPwdForm.jsp" method="post">
<input type="submit" value="다시 비밀번호 찾기">
</form>
</div>
</div>
</body>
<jsp:include page="./footer.jsp"></jsp:include>
</html>