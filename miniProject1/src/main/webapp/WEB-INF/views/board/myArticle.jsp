<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내글 보기</title>
<link rel="stylesheet" href="/resources/css/butnn.css">
<style type="text/css">
#myArticleForm {
	display: inline-block;
	float: right;
	width: 1300px;
	height: 1200px;
	margin-top: 150px;
	text-align: center;
}
</style>
</head>
<body>
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
<div id="myArticleForm">
	<h2> <c:out value="${userInfo.nickName}"></c:out>님이 쓴 글</h2>
	<br>
	<a href="../board/main" id="mainFormCheck" style="display: none"></a>
	<button class="custom-btn btn-12" onclick="document.getElementById('mainFormCheck').click();">
	<span>Click!</span><span>메인으로</span></button>
		<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th style="background-color : #eeeeee; text-align:center; width:80px">글번호</th>
				<th style="background-color : #eeeeee; text-align:center; width:80px">
					<img alt="" src="https://i.ibb.co/yQ8yXZM/icons8-noticeboard-48.png" width="24px" height="24px">
				</th>
				<th style="background-color : #eeeeee; text-align:center; width:700px">제목</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">닉네임</th>
				<th style="background-color : #eeeeee; text-align:center; width:200px">등록일</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">조회</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">추천</th>
			</tr>
		</thead>

<%!int count = 0;%>
<%-- <c:set var="items2" value="${cList}"></c:set> --%>
<c:forEach var="item" items="${bList}">
	<tr style="text-align: center" class="boardElement">
		<td>${item.number}</td>
		<td>
		<c:choose>
		<c:when test="${item.boardTitle eq 'question'}">
			<img alt="" src="https://i.ibb.co/cNBBrXT/icons8-question-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToQuestionBoard').click()">
			<a href="./question" style="display: none" id="goToQuestionBoard"></a>	
		</c:when>
			<c:when test="${item.boardTitle eq 'screen'}">
				<img alt="" src="https://i.ibb.co/cyJSqsg/icons8-image-48.png" width="26px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToScreenBoard').click()">
			<a href="./screen" style="display: none" id="goToScreenBoard"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq 'info'}">
			<img alt="" src="https://i.ibb.co/sVDnSPC/icons8-information-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToInformationBoard').click()">
			<a href="./info" style="display: none" id="goToInformationBoard"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq 'free'}">
			<img alt="" src="https://i.ibb.co/Dwxw9bX/icons8-cheque-58.png" width="22px" height="24px" style="margin-bottom: 2px; cursor: pointer;" onclick="document.getElementById('goToFreeBoard').click()">
			<a href="./free" style="display: none" id="goToFreeBoard"></a>	
		</c:when>
		</c:choose>
		</td>
		<td>
		<a href="../board/view?number=${item.number}" style="text-decoration: none; color: black;">${item.title}</a>
		<%-- <c:forEach var="item2" items="${items2}">
			<c:if test="${item.number eq item2.number}">
				<%count++;%>
			</c:if>
		</c:forEach> --%>
		<%-- <%if(count != 0){ %>
		<a href="./searchCommentProcess.jsp?number=${item.number}&writer=${item.writer}" target="_blank"  onClick="window.open(this.href, '', 'width=600, height=400'); return false;" style="text-decoration: none; color: red;">[<%=count%>]</a>
		<%} count = 0; %> --%>
		<c:if test="${item.imageFileName ne null}">
			<img src="https://i.ibb.co/JjjkzJB/imageicon.jpg" style="width:15px;height:12px;margin-left:1px; margin-bottom: 2px" border="0">
		</c:if>
		</td>
		<!-- 닉네임 옆 경험치에따른 계급표 -->
		<td>
		<c:forEach var="member" items="${mList}">
			<c:if test="${item.writer eq member.nickName}">
				<c:choose>
					<c:when test="${member.userExp == 0}">
						<img src="https://i.ibb.co/DYQFRjq/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 100}">
						<img src="https://i.ibb.co/Hnhvny8/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 200}">
						<img src="https://i.ibb.co/NKXW0C9/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 300}">
						<img src="https://i.ibb.co/HNzQDJT/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 400}">
						<img src="https://i.ibb.co/M6PwMcC/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 500}">
						<img src="https://i.ibb.co/QkmbTmL/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 600}">
						<img src="https://i.ibb.co/WHGk9tW/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 700}">
						<img src="https://i.ibb.co/4PJ9wVk/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 800}">
						<img src="https://i.ibb.co/M7SJqZW/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp > 800}">
						<img src="https://i.ibb.co/b1CtsSW/image.png" width="20px" height="20px">
					</c:when>
				</c:choose>
			</c:if>
		</c:forEach>
		${item.writer}
		</td>
		<td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>
		<td>${item.views}</td>
		<td>${item.recommends}</td>
	</tr>
</c:forEach>	
</table>
</div>
</div>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
</body>
</html>