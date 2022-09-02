<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- begin => 시작 / end => 끝 / 보통 별 조건없으면 1씩 증가함 -->
<c:forEach var="i" begin="2" end="9">	<!-- 변수 i 2부터 9까지 1씩증가 -->
	*** ${i} 단 ***	<br>	
	<c:forEach var="j" begin="1" end="9">	<!-- 변수 j 1부터 9까지 1씩증가 // 중첩 for 문 -->
		${i } * ${j } = ${i * j}	<br>	
	</c:forEach>
</c:forEach>
<hr>
<c:forEach var="k" begin="1" end="10" step="2">	<!-- 변수 k 1부터 10까지 2씩증가 -->
		${k }
</c:forEach>
</body>
</html>