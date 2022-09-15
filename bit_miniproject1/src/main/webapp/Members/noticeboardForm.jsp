<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*, org.ai.beans.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문게시판</title>
<style type="text/css">
#noticeBoardForm {
	display: inline-block;
	float: right;
	width: 1300px;
	height: 1200px;
	margin-top: 200px;
	text-align: center;
}
</style>
</head>
<body>
<%
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String userJob = (String)session.getAttribute("userJob");
	request.setCharacterEncoding("utf-8");
	request.setAttribute("questionBoard", "questionBoard");
	request.setAttribute("screenBoard", "screenBoard");
	request.setAttribute("informationBoard", "informationBoard");
	request.setAttribute("questionBoard", "questionBoard");
%>
<jsp:include page="./noticeBoardInfo.jsp"></jsp:include>
<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./header2.jsp"></jsp:include>
<%} 
else {%>
<jsp:include page="./header.jsp"></jsp:include>
<%}%>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="noticeBoardForm">
	<h2>ROK ARMY 전체게시판</h2>
	<br>
	<input type="button" value="메인으로" class="goToMain" onclick="document.getElementById('mainFormCheck').click();" />
		<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th style="background-color : #eeeeee; text-align:center; width:80px">글번호</th>
				<th style="background-color : #eeeeee; text-align:center; width:80px"></th>
				<th style="background-color : #eeeeee; text-align:center; width:700px">제목</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">닉네임</th>
				<th style="background-color : #eeeeee; text-align:center; width:200px">등록일</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">조회</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">추천</th>
			</tr>
		</thead>


<%!int count = 0;%>
<c:set var="items" value="${bList}"></c:set>	
<c:set var="items2" value="${cList}"></c:set>
<c:forEach var="item" items="${items}">
	<tr style="text-align: center" class="boardElement">
		<td>${item.number}</td>
		<td>
		<c:choose>
		
		</c:choose>
		</td>
		<td>
		<a href="./boardView.jsp?number=${item.number}&boardTitle=${item.boardTitle}" style="text-decoration: none; color: black;">${item.title}</a>
		<c:forEach var="item2" items="${items2}">
			<c:if test="${item.number eq item2.number}">
				<%count++;%>
			</c:if>
		</c:forEach>
		<%if(count != 0){ %>
		<a href="./searchCommentProcess.jsp?number=${item.number}&writer=${item.writer}" target="_blank"  onClick="window.open(this.href, '', 'width=600, height=400'); return false;" style="text-decoration: none; color: red;">[<%=count%>]</a>
		<%} count = 0; %>
		<c:if test="${item.imageFileName ne null}">
			<img src="https://i.ibb.co/JjjkzJB/imageicon.jpg" style="width:15px;height:12px;margin-left:1px; margin-bottom: 2px" border="0">
		</c:if>
		</td>
		<td>${item.writer}</td>
		<td>${item.regDate}</td>
		<td>${item.views}</td>
		<td>${item.recommends}</td>
	</tr>
</c:forEach>
<!-- 추가된 테이블 열이 overflow되면.. 다음 페이지 생성하고 보여주는 목록이 그쪽 페이지로 넘어가게해야함.. -->		
</table>
	<a href="./mainForm.do?userId=<%=userId%>&userPwd=<%=userPwd%>&userJob=<%=userJob%>" id="mainFormCheck" style="display: none;"></a>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>