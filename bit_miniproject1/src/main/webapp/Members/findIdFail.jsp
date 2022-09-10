<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 실패..</title>
<style type="text/css">
#findIdForm {
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
	alert("존재하지 않는 회원입니다.")
</script>
<jsp:include page="./header.jsp"></jsp:include>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="findIdForm">
	<form action="./findIdForm.jsp" method="post">
	<input type="submit" value="다시 아이디 찾기">
	</form>
	<form action="./mainForm.jsp" method="post">
	<input type="submit" value="메인으로 가기">
	</form>
</div>
</div>

<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>