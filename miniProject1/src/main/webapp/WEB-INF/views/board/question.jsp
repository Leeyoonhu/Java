<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/butnn.css">
<meta charset="UTF-8">
<title>질문 게시판</title>
<style type="text/css">
#questionBoardForm {
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
<!-- body -->
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
<div id="questionBoardForm">
	<h2 style="font-weight:bold;">전지적 군인 시점 질문게시판</h2>
	<br>
	<a href="../board/main" id="mainFormCheck" style="display: none"></a>
	<button class="custom-btn btn-12" onclick="document.getElementById('mainFormCheck').click();">
	<span>Click!</span><span>메인으로</span></button>
<c:if test="${not empty userInfo.userId}">
	<a href="../board/write" id="boardWrite" style="display: none"></a>
	 <button class="custom-btn btn-12" onclick="document.getElementById('boardWrite').click();" >
	 <span>Click!</span><span>글쓰기</span></button>
</c:if>
<!-- table head -->
	<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
	<thead>
		<tr style="height: 52px">
			<th style="background-color : rgb(245, 244, 187); text-align:center; width:80px; font-weight:bold;">글번호</th>
			<th style="background-color : rgb(245, 244, 187); text-align:center; width:700px; font-weight:bold;">제목</th>
			<th style="background-color : rgb(245, 244, 187); text-align:center; width:200px; font-weight:bold;">닉네임</th>
			<th style="background-color : rgb(245, 244, 187); text-align:center; width:200px; font-weight:bold;">등록일</th>
			<th style="background-color : rgb(245, 244, 187); text-align:center; width:100px; font-weight:bold;">조회</th>
			<th style="background-color : rgb(245, 244, 187); text-align:center; width:100px; font-weight:bold;">추천</th>
		</tr>
	</thead>
<%!int count = 0;%>
<!-- table body -->
<c:forEach var="board" items="${bList}">
	<tr class="boardElement" style="text-align: center; height: 52px">
		<td>${board.number}</td>
		<!-- title + comment Proc -->
		<td><a href="./view?number=${board.number}" style="text-decoration: none; color: black;">${board.title}</a>
		<c:forEach var="comment" items="${cList}">
			<c:if test="${board.number eq comment.number}">
			 <%count++;%>
			</c:if>
		</c:forEach>
		<%if(count != 0){ %>
		<a href="../comment/view?number=${board.number}" target="_blank"  onClick="window.open(this.href, '', 'width=600, height=400'); return false;" style="text-decoration: none; color: red;">
		 [<%=count%>]</a><%}%>
		<%count = 0;%>
		<c:if test="${board.imageFileName ne null && board.imageFilePath ne null}">
			<img src="https://i.ibb.co/JjjkzJB/imageicon.jpg" style="width:15px;height:12px;margin-left:1px; margin-bottom: 2px" border="0">
		</c:if>
		</td>
		<!-- 닉네임 옆 경험치에따른 계급표 -->
		<td>
		<c:forEach var="member" items="${mList}">
			<c:if test="${board.writer eq member.nickName}">
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
					<c:when test="${member.userExp > 800 && member.userExp < 10000}">
						<img src="https://i.ibb.co/XpZfLv1/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp >= 10000}">
						<img src="https://i.ibb.co/Yy9cYn3/image.png" width="20px" height="20px">
					</c:when>
				</c:choose>
			</c:if>
		</c:forEach>
		${board.writer}
		</td>
		<td>
			<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd"/>
		</td>
		<td>${board.views}</td>
		<td>${board.recommends}</td>
	</tr>
</c:forEach>
</table>
<!-- end table -->
<!-- start paging -->
<ul class="pagination">
	<c:if test="${pageMaker.prev}">
		<li class="page-item"><a class="page-link"
			href="${pageMaker.startPage-1}">Previous</a></li>
	</c:if>
	<c:forEach var="num" begin="${pageMaker.startPage }"
		end="${pageMaker.endPage }">
		<li class="page-item ${pageMaker.cri.pageNum==num?"active":"" }"><a
			class="page-link" href="${num}">${num}</a></li>
	</c:forEach>
	<c:if test="${pageMaker.next}">
		<li class="page-item"><a class="page-link"
			href="${pageMaker.endPage+1 }">Next</a></li>
	</c:if>
</ul>
<form id='actionForm' action="/board/question" method='get'>
	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
	<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
</form>
<!-- end paging -->
	<a href="./main" id="mainFormCheck" style="display: none;"></a>
</div>
</div>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
</body>
</html>