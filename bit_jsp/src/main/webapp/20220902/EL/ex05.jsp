<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("name", "conan");
%>
요청 URI : ${pageContext.request.requestURI} <br>		<!-- 실행한 파일의 경로 -->
request의 name : ${requestScope.name} <br>	<!-- name의 value값 출력 -->
<!-- request.getAttribute("name"); 속성 꺼내기 -->	
request의 parameter : ${param.name}
<!-- request.getParameter("name"); 파라미터 꺼내기 -->
</body>
</html>