<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 참조 변수의 값을 변경해서 Core 사용하기 -->
<%@ page import="org.ai.beans.*" %>
<%
Bookbean book = new Bookbean();
%>
<c:set target="<%=book %>" property="title" value="코스모스"></c:set>
<!-- 타게팅된 참조변수 Bookbean형 book의 book.title = "코스모스"로 set -->
<%=book.getTitle() %> <br> <!-- set한 값 출력 -->
<c:set var="b" value="<%=book %>"></c:set>
<!-- 참조변수 Bookbean형 book의 값을 저장한 변수 b -->
<c:set target="${b }" property="author" value="세이건"></c:set>
<!-- 변수 b.author = "세이건"으로 set -->
${b.author}	<!-- set한 값 출력 -->
</body>
</html>