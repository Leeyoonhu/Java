<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 아이디 기억을 했을때와 안했을때 로그인이 달라야함 -->
<form action="./loginProc.jsp">
관리자 로그인 <br>
<% 	Cookie[] cookies = request.getCookies();

	if(session.isNew() || cookies.length == 1) {%>
		아뒤 : <input type="text" name="id"> <input type="checkbox" name="check">아이디 기억 <br>
		비번 : <input type="password" name="pwd">
		<input type="submit" value="제출">
	<%}
	else {
		Cookie cookie = cookies[0];%>
		아뒤 : <input type="text" name="id" value="<%=cookie.getValue()%>"> <input type="checkbox" name="check">아이디 기억 <br>
		비번 : <input type="password" name="pwd">
		<input type="submit" value="제출">
	<%}%>
	

</form>
</body>
</html>