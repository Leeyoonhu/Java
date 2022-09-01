<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first page</title>
</head>
<body>
	<h3>first page임</h3>	<!-- 출력x => 출력 버퍼에 저장 -->
	<jsp:forward page="./second.jsp"></jsp:forward>	<!-- 지정 경로로 이동하면서 버퍼를 비우기때문에 출력안됨 -->
	<p>===== first page =====</p>
</body>
</html>