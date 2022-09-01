<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoTohello.jsp</title>
</head>
<body>
<!-- 객체를 통해 이동하고 싶은 페이지 정보 전달 -->
<!-- 홈페이지 경로 뒤에 나온 쿼리문이 파일경로?name=value 형식이기에 name과 value를 이용한 getParameter()함수를 사용할것임 -->
<% String p = request.getParameter("p"); %>	<!-- name = p인 놈의 값을 변수 p에 저장 -->
<jsp:forward page="<%=p%>"></jsp:forward>	<!-- 변수 p에 담겨진 값을 주소로 이동 -->
</body>
</html>