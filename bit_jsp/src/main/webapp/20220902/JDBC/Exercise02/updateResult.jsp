<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그아웃이나 정보수정 누르기전에 쿠키초기화?? 눌렀을때 초기화?? -->
<!-- 정보가 수정이 되고나서 결과에서 바뀐값이 나와야지? -->

<%
Cookie[] cookies = request.getCookies();
%>
<%=cookies[0].getValue() %>님 정보 수정이 정상적으로 되었습니다. <br>

<a href="./logoutProcess.jsp">로그아웃</a>
<a href="./updateForm.jsp">정보수정</a>
</body>
</html>