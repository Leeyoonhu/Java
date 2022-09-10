<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 성공!</title>
<style type="text/css">
#findIdSuccess {
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
<%
Cookie[] cookies = request.getCookies();
%>
<jsp:include page="./header.jsp"></jsp:include>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="findIdSuccess">
<p style="font-size: 1.3em">회원님의 아이디는 
<strong style="font-size: 1.6em"><%=cookies[0].getValue()%></strong> 
입니다</p>
<!-- 쿠키 죽여야함 -->
<%
for(int i = 0; i < cookies.length; i++){
	cookies[i].setMaxAge(0);
	response.addCookie(cookies[i]);
}
%>
<form action="./loginForm.jsp">
<input style="margin-left: 40px" type="submit" value="로그인 하러가기" method="post">
</form>
<form action="./findPwdForm.jsp" method="post" style="margin-top: 20px">
<input type="submit" value="비밀번호 찾으러 가기">
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>