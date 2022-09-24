<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<meta charset="UTF-8">
<title>전지적 군사 시점</title>
<style type="text/css">
</style>
</head>
<body>
<!-- 로그인 시 유저 정보담은 session = userInfo -->
<!-- header -->
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/header.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="../includes/header2.jsp" %>
	</c:otherwise>
</c:choose>
<div id="content">
<!-- aside -->
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/aside.jsp" %>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${userInfo.userJob eq 'soldier'}">
				<%@include file="../includes/aside3.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="../includes/aside2.jsp" %>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
<div class="mainForm">
<div class="mainFormContent"> <!-- 인기게시글, 최근 게시글 을 담을거 -->
	<iframe style="margin-right : 50px"src="popular" width="600px" height="300px" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
	<iframe style="margin-left : 50px" src="current" width="600px" height="300px" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
</div>
<!-- start ranking -->
<div class="card bg-light" style="width: 400px">
	<div class="card-body">
        <p class="m-0 text-center text-black">랭킹목록</p>
    </div>
    <div class="py-5 bg-dark">
        <p class="m-0 text-center text-white">랭킹목록</p>
    </div>
</div>
<!-- end ranking -->
<div class="mainFormContent2">
<iframe style="margin-right : 700px"
      width="1000"
      height="400"
      src="https://www.youtube.com/embed/Ql7Gau1FhHA"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
      allowfullscreen
    ></iframe>
<iframe style="margin-right : 700px"
width="1000" 
height="400" 
src="https://www.youtube.com/embed/yEJfWqOSZIE" 
title="YouTube video player" 
frameborder="0" 
allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
allowfullscreen></iframe>
</div>
</div>

</div>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
</body>
</html>