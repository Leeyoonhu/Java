<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- javabeans(Bookbean) 를 사용한 예제 -->
<%
request.setCharacterEncoding("utf-8");
%>
<form action="./example22.jsp" method="post">
책 제목 : <input type="text" name="title"> <br>
책 저자 : <input type="text" name="author"> <br>
출판사 : <input type="text" name="publisher"> <br>
<input type="submit" value="등록">
</body>
</html>