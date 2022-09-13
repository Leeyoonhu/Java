<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*, org.ai.beans.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<style type="text/css">
#freeBoardForm {
	display: inline-block;
	float: right;
	width: 1400px;
	height: 1800px;
	margin-top: 200px;
	text-align: center;
}
</style>
</head>
<body>
<!-- 11행 6열 -->
<!-- 홈으로 보낼때 session에서의 아이디 비번을 parameter로 보내자 -->
<%
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String userJob = (String)session.getAttribute("userJob");
	String boardTitle = "freeBoard";
%>
<jsp:include page="./boardInfo.jsp" flush="false">
	<jsp:param value="<%=boardTitle%>" name="boardTitle"/>
</jsp:include>
<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./header2.jsp"></jsp:include>
<%} 
else {%>
<jsp:include page="./header.jsp"></jsp:include>
<%}%>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="freeBoardForm">
	<a href="./boardWrite.jsp?boardTitle=<%=boardTitle%>" id="freeBoardWrite" style="display: none;"></a>
	<div class="row">
		<h2>전군시 자유게시판</h2>
		<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th style="background-color : #eeeeee; text-align:center; width:80px">글번호</th>
				<th style="background-color : #eeeeee; text-align:center; width:700px">제목</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">닉네임</th>
				<th style="background-color : #eeeeee; text-align:center; width:200px">등록일</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">조회</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">추천</th>
			</tr>
		</thead>
			<!-- board db에서 가져와서 10줄씩 테이블 생성 -->
		
<%!int count = 0;%>
<c:set var="items" value="${bList}"></c:set>	
<!-- item 이 보드 -->
<c:set var="items2" value="${cList}"></c:set>
<!-- item2 가 댓글 -->
<c:forEach var="item" items="${items}">
<!-- 이 링크를 누르면 해당 게시글로 가야됨 -->
	<tr style="text-align: center">
		<td>${item.number}</td>
		<td>
		<a href="./boardView.jsp?number=${item.number}&boardTitle=<%=boardTitle%>" style="text-decoration: none; color: black;">${item.title}</a>
		<!-- 2중 for문으로 댓글 숫자 보여줘야함 -->
		<!-- 두 글 번호가 같을경우.. 카운트가 올라가고.. 다를경우에 출력.. -->
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
	<input type="button" value="메인 페이지로" style="margin-top: 10px; margin-left: 1200px" onclick="document.getElementById('mainFormCheck').click();" />
	<%if(session.getAttribute("userId") != null){ %>
	<input type="button" value="글쓰기" style="margin-top: -30px; margin-left: 1350px" onclick="document.getElementById('freeBoardWrite').click();" />
	<%}%> 
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>