<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 세션 유효 시간(세션을 유지하기 위한 시간 조정, default값 30분) -->
	<h3>---세션 유효 시간 변경 전---</h3>
	<%
		int time = session.getMaxInactiveInterval()/60;	/* 모든 시간의 초를 60으로 나눈 분단위를 time에 저장 */
		out.println("세션 유효 시간 : "+time+"분<br>");
		session.setMaxInactiveInterval(60 * 60);	/* 60초 * 60초 = 3600초로 변경 */
	%>
	<h3>---세션 유효 시간 변경 후---</h3>
	<%
		time = session.getMaxInactiveInterval()/60;
		out.println("세션 유효 시간 : "+time+"분<br>");
	%>
</body>
</html>