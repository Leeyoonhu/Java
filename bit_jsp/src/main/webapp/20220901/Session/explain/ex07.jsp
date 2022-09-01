<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 세션 아이디와 웹 사이트 유지 시간 -->
	<!-- 웹 사이트 접속 후 경과 시간 확인 // 마지막 시간에서 시작 시간을 뺴야하는 가공과정 필요 -->
	<!-- LastAccessedTime과 CreationTime의 기준은 1970/1/1 -->
<%
	String sessionId = session.getId();
	long lastTime = session.getLastAccessedTime();
	long startTime = session.getCreationTime();		
	long lapse = (lastTime-startTime)/1000/60;	/* 웹 사이트 접속 후 경과시간 */
	out.println("세션 아이디 : "+sessionId+"<br>");
	out.println("요청 시작 시간 : "+startTime+"<br>");
	out.println("요청 마지막 시간 : "+lastTime+"<br>");
	out.println("웹사이트 경과 시간 : "+lapse+"분<br>");
%>
</body>
</html>