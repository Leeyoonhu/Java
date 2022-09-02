<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 접두사를 c로 쓸거임 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- c set -->
<%@ page import="org.ai.beans.*" %>
<!-- 접두사를 c로 줬기때문에 c:set -->
<c:set var="name" value="amy"></c:set>
<c:out value="${name}"></c:out><br>	<!-- 변수 name에 저장된 값 출력 -->
<c:remove var="name"/>
<c:out value="${name}"></c:out><br>	<!-- 삭제한 변수 출력해도 없음 -->
<hr>
<%
Bookbean book1 = new Bookbean("명탐정 홈즈", "코난 도일", "모름");
request.setAttribute("bookOne", book1);
/* HttpServletRequest에 boo1변수의 값 저장 */
%>
<c:set var="title" value ="${bookOne.title}"></c:set>
<!-- 변수 title에 bookOne의 title속성 값 저장 -->
<c:out value="${title}"></c:out>	<!-- 출력 -->
<c:set var="author" value = "<%=book1.getAuthor()%>"></c:set>
<!-- 변수 author에 book1의 author값 getter -->
<c:out value="${author}"></c:out>	<!-- 출력 -->
<hr>
<c:set var="name">Wilde</c:set>
<!-- 변수 name의 값 Wilde 선언 -->
<c:out value="${name}"></c:out>	<!-- 출력 --><br>

<%
Bookbean book2 = new Bookbean("도리안", "그레이의 초상", "모름");
request.setAttribute("bookTwo", book2);
%>
<c:set var="title" value="${bookTwo.title}" ></c:set>
<c:set var="author" value="<%=book2.getAuthor() %>"></c:set>
<c:set var="name">오스카 와일드</c:set>
<c:out value="${title }"></c:out>
<c:out value="${author }"></c:out>
<c:out value="${name }"></c:out>

</body>
</html>