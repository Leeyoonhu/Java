<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/butnn.css">
<meta charset="UTF-8">
<title>사진 게시판</title>
<style type="text/css">
#screenBoardForm {
	display: inline-block;
	float: right;
	width: 1400px;
	height: 1200px;
	margin-top: 150px;
}
.but {
   text-align: center;
   margin-bottom : -40px;
}
</style>
</head>
<body>
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
<div id="screenBoardForm">
<div class="but">
<h2 style="text-align: center; margin-left: 100px;">전지적 군인 시점 사진게시판</h2> <br>
   <a href="../board/main" id="mainFormCheck" style="display: none"></a>
   <button class="custom-btn btn-12" onclick="document.getElementById('mainFormCheck').click();">
   <span>Click!</span><span>메인으로</span></button>
<!-- 여기다가 boardTitle = screenBoard인 애들 나오게할것 -->
<c:if test="${not empty userInfo.userId}">
   <a href="../board/write" id="boardWrite" style="display: none"></a>
    <button class="custom-btn btn-12" onclick="document.getElementById('boardWrite').click();" >
    <span>Click!</span><span>글쓰기</span></button>
</c:if>
</div>
<br>
	<hr>
	<br>
<%!int count = 0;%>
<%int lineCount = 0; %>
<c:forEach var="item" items="${bList}">
	<div style="width: 200px; height: 320px; display: inline-block; margin-left: 70px; border: 1px solid gray; box-sizing: border-box; border-radius: 3px;" >
		<div>
		<a href="./view?number=${item.number}" id="goScreenView" style="display: none;"></a>
		<c:choose>
			<c:when test="${item.imageFileName eq null || item.imageFilePath eq null}">
				<img alt="" src="https://i.ibb.co/58bQ29v/noimage.jpg" width="198px" height="200px" style="border-bottom: 1px solid gray; text-align: center; overflow: hidden; cursor: pointer;" onerror="this.style.display='none'" onclick="document.getElementById('goScreenView').click()"> <br>
			</c:when>
			<c:otherwise>
				<img alt="" src="<%-- <%=path%> --%>${item.imageFileName}" width="198px" height="200px" onerror="this.style.display='none'" onclick="document.getElementById('goScreenView').click()" style="border-bottom: 1px solid gray; overflow: hidden; cursor: pointer;"> <br>
			</c:otherwise>
		</c:choose>
		</div>
		<div>
		<ul style="list-style:none; padding-left:0px;">
		<li style="margin-top:12px; margin-left:7px;"><a href="./view?number=${item.number}" style="font-family:'Malgun Gothic', '맑은 고딕', helvetica, 'Apple SD Gothic Neo', sans-serif; font-size: 100%; color: black;">${item.title}</a>
		<!-- 2중 for문으로 댓글 숫자 보여줘야함 -->
		<!-- 두 글 번호가 같을경우.. 카운트가 올라가고.. 다를경우에 출력.. -->
		<%-- <c:forEach var="item2" items="${items2}">
			<c:if test="${item.number eq item2.number}">
				<%count++;%>
			</c:if>
		</c:forEach>
		<%if(count != 0){ %>
		<a href="./searchCommentProcess.jsp?number=${item.number}&writer=${item.writer}" target="_blank" onClick="window.open(this.href, '', 'width=600, height=400'); return false;" style="text-decoration: none; color: red;">[<%=count%>]</a>
		<%} count = 0; %> --%>
		</li>
		<br>
		<li style="color: gray; margin-left:7px;">
				<%-- <c:choose>
					<c:when test="${userInfo.userExp == 0}">
						<img src="https://i.ibb.co/DYQFRjq/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 100}">
						<img src="https://i.ibb.co/Hnhvny8/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 200}">
						<img src="https://i.ibb.co/NKXW0C9/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 300}">
						<img src="https://i.ibb.co/HNzQDJT/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 400}">
						<img src="https://i.ibb.co/M6PwMcC/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 500}">
						<img src="https://i.ibb.co/QkmbTmL/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 600}">
						<img src="https://i.ibb.co/WHGk9tW/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 700}">
						<img src="https://i.ibb.co/4PJ9wVk/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 800}">
						<img src="https://i.ibb.co/M7SJqZW/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp > 800}">
						<img src="https://i.ibb.co/QrPKh3V/image.jpg" width="18px" height="18px">
					</c:when>
				</c:choose> --%>
		${item.writer}</li>
		<li style="float: left; display: inline-block; margin-left:7px;"><img src="https://i.ibb.co/fHKtYnX/image.jpg" width="20px" height="16px" style="margin-bottom:2px; margin-right:2px"/>${item.views} </li><li style="float: right; display: inline-block; color: navy; margin-right: 7px"> <img alt="" src="https://i.ibb.co/2Y2ghNY/image.jpg" width="19px" height="18px"/> ${item.recommends} </li>
		</ul>	
		</div>
	</div>
	<%lineCount++; %>
	<%
	if(lineCount == 5){
		lineCount = 0; 
	%>	
			<br><br><br><br><br>
		<%}%>
</c:forEach>	
</div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>