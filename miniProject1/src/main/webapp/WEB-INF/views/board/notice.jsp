<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
#noticeBoardForm {
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
<div id="noticeBoardForm">
	<h2>전지적 군인 시점 전체게시판</h2>
	<br>
	<a href="../board/main" id="mainFormCheck" style="display: none"></a>
	<button class="custom-btn btn-12" onclick="document.getElementById('mainFormCheck').click();">
	<span>Click!</span><span>메인으로</span></button>
		<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
		<thead>
			<tr style="height: 52px">
				<th style="background-color : #C8E6A8; text-align:center; width:80px">글번호</th>
				<th style="background-color : #C8E6A8; text-align:center; width:80px">
					<img alt="" src="https://i.ibb.co/yQ8yXZM/icons8-noticeboard-48.png" width="24px" height="24px">
				</th>
				<th style="background-color : #C8E6A8; text-align:center; width:700px">제목</th>
				<th style="background-color : #C8E6A8; text-align:center; width:200px">닉네임</th>
				<th style="background-color : #C8E6A8; text-align:center; width:200px">등록일</th>
				<th style="background-color : #C8E6A8; text-align:center; width:100px">조회</th>
				<th style="background-color : #C8E6A8; text-align:center; width:100px">추천</th>
			</tr>
		</thead>

<%!int count = 0;%>
<!-- start table body -->
<c:forEach var="board" items="${bList}">
	<tr style="text-align: center; height: 52px" class="boardElement">
		<td>${board.number}</td>
		<td>
		<c:choose>
		<c:when test="${board.boardTitle eq 'question'}">
			<img alt="" src="https://i.ibb.co/cNBBrXT/icons8-question-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToQuestionBoard').click()">
			<a href="./question" style="display: none" id="goToQuestionBoard"></a>	
		</c:when>
			<c:when test="${board.boardTitle eq 'screen'}">
				<img alt="" src="https://i.ibb.co/cyJSqsg/icons8-image-48.png" width="26px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToScreenBoard').click()">
			<a href="./screen" style="display: none" id="goToScreenBoard"></a>	
		</c:when>
		<c:when test="${board.boardTitle eq 'info'}">
			<img alt="" src="https://i.ibb.co/sVDnSPC/icons8-information-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToInformationBoard').click()">
			<a href="./info" style="display: none" id="goToInformationBoard"></a>	
		</c:when>
		<c:when test="${board.boardTitle eq 'free'}">
			<img alt="" src="https://i.ibb.co/Dwxw9bX/icons8-cheque-58.png" width="22px" height="24px" style="margin-bottom: 2px; cursor: pointer;" onclick="document.getElementById('goToFreeBoard').click()">
			<a href="./free" style="display: none" id="goToFreeBoard"></a>	
		</c:when>
		</c:choose>
		</td>
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
					<c:when test="${member.userExp > 800}">
						<img src="https://i.ibb.co/b1CtsSW/image.png" width="20px" height="20px">
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
	<a href="../board/main" id="mainFormCheck" style="display: none;"></a>
<br>
<script type="text/javascript">
	function checkContent(){
		let form = document.searchForm;
		if(form.content.value == ""){
			alert("검색하실 내용을 입력해주세요.");
		}
		else {
			form.submit();
		}
	}
</script>
<!-- start search -->
<form action="../board/search" method="post" style="text-align: center;" name = "searchForm">
<select name="title" style="padding-left: 5px; width: 120px; height: 38px;  box-sizing: border-box; border: 1px solid #ccc;">
	<option selected="selected">제목</option>
	<option >닉네임</option>
</select>
<input type="text" name="content" style="padding: 0px 5px; width: 400px; height: 38px; box-sizing: border-box; border: 1px solid #ccc; padding-left: 6px">
<button type="button" style=" width: 60px;height: 38px;border: 1px solid #ccc;box-sizing: border-box;background: url(https://i.ibb.co/q1QvKRf/image.png) no-repeat;
background-position:center;cursor: pointer;padding: 0px 6px;"onclick="checkContent()">&nbsp;</button>
</form>
<br>
<!-- end search -->

<!-- start paging -->
<ul class="pagination">
	<c:if test="${pageMaker.next}">
		<li class="page-item" style="text-align: center"><a class="page-link"
			href="${pageMaker.endPage+1}">Next</a></li>
	</c:if>
	<c:forEach var="num" begin="${pageMaker.startPage }"
		end="${pageMaker.endPage }">
		<li class="page-item ${pageMaker.cri.pageNum==num?"active":"" }" style="text-align: center"><a
			class="page-link" href="${num}">${num}</a></li>
	</c:forEach>
	<c:if test="${pageMaker.prev}">
		<li class="page-item" style="text-align: center"><a class="page-link"
			href="${pageMaker.startPage-1}">Previous</a></li>
	</c:if>
</ul>
<form id='actionForm' action="/board/notice" method='get'>
	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
	<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
</form>
<!-- end paging -->
<!-- end body  -->
</div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>