<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브 태그Ex01</title>
</head>
<body>
<%-- <%@ include file ="파일명" %> --%>
<!-- 예시를 확인하기 위해 header, footer 생성 -->
<%@ include file ="header.jsp" %>
<hr>
본문임!!
<hr>
<%@ include file ="footer.jsp" %>
</body>
</html>