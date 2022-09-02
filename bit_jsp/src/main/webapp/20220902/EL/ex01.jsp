<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 예시1 -->
<% request.setAttribute("cnt", 3);%>
request로 출력 : <%= request.getAttribute("cnt") %>	<br>
EL로 출력 : ${cnt}
</body>
</html>