<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 오류 문구 확인해보기 -->
<%
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
%>
<p>문자 인코딩: <%= response.getCharacterEncoding() %></p>
<p>콘텐츠 유형:<%= response.getContentType() %></p> 
<%
// response.sendError(404, "요청 페이지를 찾을 수 없음");
response.sendError(500, "실행 오류 발생");
// 200 ==> OK, 404 ==> NOT FOUND, 500 ==> SERVER ERROR
%>
</body>
</html>