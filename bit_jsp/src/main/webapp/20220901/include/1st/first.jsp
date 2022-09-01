<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1st</title>
</head>
<body>
	<h3>first page 임</h3>
	<jsp:include page="./second.jsp" flush = "false"></jsp:include> 
	<!-- 파일 경로의 내용을 포함하는데, 버퍼를 비우지 않았으므로 first page도 출력됨 -->
	<p>=====first page=====</p>
</body>
</html>