<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*, java.util.*, com.conan.vo.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="./menu.jsp" %>	 <!-- 헤드 배너 -->
<div class="jumbotron">	<!-- 회색배경 -->
	<div class="container">
		<h1 class="display-3">상품 목록</h1>		
	</div>
</div>
<div class="container">
	<div class="row" align="center">
		<c:forEach var="item" items="${pl}">
			<div class="col-md-4">
				<h3>${item.proName}</h3>
				<p>${item.description}</p>
				<p>${item.unitPrice}원</p>
				<a href="./productDetail.jsp?proId=${item.proId}"
				class="btn btn-secondary"
				role="button">
				상세정보 &raquo;
				</a>
			</div>
		</c:forEach>
	</div>
</div>
<%@include file="./footer.jsp" %>
</body>
</html>