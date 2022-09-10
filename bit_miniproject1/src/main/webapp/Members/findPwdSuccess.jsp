<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
#findPwdSuccess {
display: inline-block;
	float: right;
	width: 1400px;
	height: 1800px;
	margin-top: 200px;
	text-align: center;
}
</style>
<body>
<%
Cookie[] cookies = request.getCookies();
%>
<jsp:include page="./header.jsp"></jsp:include>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="findPwdSuccess">
<p style="font-size: 1.3em">회원님의 비밀번호는 
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
<input type="submit" value="로그인 하러가기" method="post">
</form>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<form action="./mainForm.jsp" method="post">
<input type="submit" value="메인으로 가기">
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>