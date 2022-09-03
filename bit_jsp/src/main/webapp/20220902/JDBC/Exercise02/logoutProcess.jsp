<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그아웃에 필요한 작업? -->
<!-- Session(서버)에 담았던 로그인 정보를 날리고.. 쿠키도 초기화해주고.. -->
<%
/* 세션 이름 배열 enumeration */
Enumeration en = session.getAttributeNames();
while(en.hasMoreElements()){
	session.removeAttribute((String)en.nextElement());
}
response.sendRedirect("./loginForm.jsp");
%>

</body>
</html>