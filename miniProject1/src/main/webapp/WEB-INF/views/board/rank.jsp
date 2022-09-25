<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시판</title>
<link rel="stylesheet" href="/resources/css/butnn3.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style type="text/css">
#ranking {
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
<div id="ranking">
	<h2>전지적 군인 시점 랭킹게시판</h2>
	<br>
	<a href="../board/main" id="mainFormCheck" style="display: none"></a>
	<button class="custom-btn btn-12" onclick="document.getElementById('mainFormCheck').click();">
	<span>Click!</span><span>메인으로</span></button>
		<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
		<thead>
			<tr style="height: 52px">
				<th style="background-color : #C8E6A8; text-align:center; width:80px">순위</th>
				<th style="background-color : #C8E6A8; text-align:center; width:400px">닉네임</th>
				<th style="background-color : #C8E6A8; text-align:center; width:200px">가입일</th>
				<th style="background-color : #C8E6A8; text-align:center; width:100px">직업</th>
				<th style="background-color : #C8E6A8; text-align:center; width:100px">성별</th>
			</tr>
		</thead>
<%
	int rankingCount = 0;
%>
<!-- start table body -->
<c:forEach var="member" items="${mList}">
	<%rankingCount++;%>
	<!-- if userInfo.nickName eq member.nickName // else -->
	<c:choose>
		<c:when test="${userInfo.nickName eq member.nickName}">
			<tr style="background: #343A40; text-align: center; height: 52px" class="boardElement">
			<td><%=rankingCount%></td>
			<td>
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
					${member.nickName}
				</td>
				<td>
					<fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>${member.userJob}</td>
				<td>${member.gender}</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr style="text-align: center; height: 52px" class="boardElement">
				<td><%=rankingCount%></td>
				<td>
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
					${member.nickName}
				</td>
				<td>
					<fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>${member.userJob}</td>
				<td>${member.gender}</td>
			</tr>
		</c:otherwise>
	</c:choose>
</c:forEach>
</table>


<!-- start paging -->
<ul class="pagination">
	<c:if test="${pageMaker.next}">
		<li class="page-item" style="text-align: center"><a class="page-link"
			href="${pageMaker.endPage+1}">Next</a></li>
	</c:if>
	<c:forEach var="num" begin="${pageMaker.startPage}"
		end="${pageMaker.endPage }">
		<li class="page-item ${pageMaker.cri.pageNum==num?"active":"" }" style="text-align: center"><a
			class="page-link" href="${num}">${num}</a></li>
	</c:forEach>
	<c:if test="${pageMaker.prev}">
		<li class="page-item" style="text-align: center"><a class="page-link"
			href="${pageMaker.startPage-1}">Previous</a></li>
	</c:if>
</ul>
<form id='actionForm' action="/board/rank" method='get'>
	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
	<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
</form>
<!-- end paging -->

<!-- end body  -->
</div>
</div>
<%@ include file="../includes/footer.jsp" %>
<!-- end footer -->
</body>
</html>