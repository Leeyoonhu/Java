<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 객체들의 collection 을 수행할 경우 -->
<!-- 자바의 향상된 for문과 동일한 개념 -->
<%-- <c:forEach [var="varName"] itmes="collections" [varStatus="varStatusName"] [begin="begin"] [end="end"] [step="step"]></c:forEach>
 --%>
<%@ page import="org.ai.beans.*" %>
<%
ArrayList<Bookbean> bList = new ArrayList<Bookbean>();
bList.add(new Bookbean("명탐정 홈즈", "코난 도일", "모름"));
bList.add(new Bookbean("코스모스", "칼 세이건", "모름"));

String[] bookCode = {"소설", "역사", "인문", "정치", "미술", "종교", "여행", "과학", "만화"};
%>
<c:set var="list" value="<%=bList %>"></c:set>
<!-- bList값을 지닌 list변수 -->
<c:forEach var="item" items="${list }">	
<!-- list변수 값들중 각각을 item 변수에 저장 -->
${item.title } / ${item.author } / ${item.publisher } <br>
<!-- 변수의 속성들 출력 -->
</c:forEach>
<!-- 위의 for-each는 for(Bookbean item : items){print(item)}과 같음-->
<hr>
<c:set var="code" value="<%=bookCode %>"></c:set>
<c:forEach var="item" items="${code }">	<!-- 변수 이름이 code인 애의 값을 하나씩 item변수에 저장해서 -->
<c:out value="${item }"></c:out>	<!-- 변수 이름이 item인 애 출력 -->
</c:forEach>
</body>
</html>