<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- scope="request"로 forward에 지정된 파일에게 클래스 정보 넘김 -->
	<jsp:useBean class="org.ai.beans.Members" id="member" scope="request"></jsp:useBean>
	<jsp:setProperty property="userId" name="member" value="conan"/>
	<jsp:setProperty property="name" name="member" value="코난"/>
	<jsp:forward page="./useObject.jsp"></jsp:forward>
	
	
</body>
</html>