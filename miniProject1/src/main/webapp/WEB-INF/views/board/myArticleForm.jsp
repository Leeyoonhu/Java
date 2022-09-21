<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*, org.ai.beans.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내글 보기</title>
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
<%
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String userJob = (String)session.getAttribute("userJob");
	String nickName = (String)session.getAttribute("nickName");
	request.setCharacterEncoding("utf-8");
	request.setAttribute("questionBoard", "questionBoard");
	request.setAttribute("screenBoard", "screenBoard");
	request.setAttribute("informationBoard", "informationBoard");
	request.setAttribute("freeBoard", "freeBoard");
%>
<jsp:include page="./myArticleProcess.jsp">
	<jsp:param value="<%=nickName%>" name="nickName"/>
</jsp:include>
<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./header2.jsp"></jsp:include>
<%} 
else {%>
<jsp:include page="./header.jsp"></jsp:include>
<%}%>
<div id="content">
<%if(session.getAttribute("userId") != null){ 
	if("soldier".equals((String)session.getAttribute("userJob"))){ %>
		<jsp:include page="./aside3.jsp"></jsp:include>
	<%} else { %>
		<jsp:include page="./aside2.jsp"></jsp:include>
	<% }
}else {%>
<jsp:include page="./aside.jsp"></jsp:include>
<%}%>
<div id="myArticleForm">
	<h2><%=nickName%>님이 쓴 글</h2>
	<br>
	<input type="button" value="메인으로" class="goToMain" onclick="document.getElementById('mainFormCheck').click();" />
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
<c:set var="items" value="${bList}"></c:set>	
<c:set var="items2" value="${cList}"></c:set>
<c:forEach var="item" items="${items}">
	<tr style="text-align: center" class="boardElement">
		<td>${item.number}</td>
		<td>
		<c:choose>
		<c:when test="${item.boardTitle eq questionBoard}">
			<img alt="" src="https://i.ibb.co/cNBBrXT/icons8-question-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToQuestionBoard').click()">
			<a href="./questionBoardForm.jsp" style="display: none" id="goToQuestionBoard"></a>	
		</c:when>
			<c:when test="${item.boardTitle eq screenBoard}">
				<img alt="" src="https://i.ibb.co/cyJSqsg/icons8-image-48.png" width="26px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToScreenBoard').click()">
			<a href="./screenBoardForm.jsp" style="display: none" id="goToScreenBoard"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq informationBoard}">
			<img alt="" src="https://i.ibb.co/sVDnSPC/icons8-information-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToInformationBoard').click()">
			<a href="./informationBoardForm.jsp" style="display: none" id="goToInformationBoard"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq freeBoard}">
			<img alt="" src="https://i.ibb.co/Dwxw9bX/icons8-cheque-58.png" width="22px" height="26px" style="margin-bottom: 2px; cursor: pointer;" onclick="document.getElementById('goToFreeBoard').click()">
			<a href="./freeBoardForm.jsp" style="display: none" id="goToFreeBoard"></a>	
		</c:when>
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
</table>
	<a href="./mainForm.do?userId=<%=userId%>&userPwd=<%=userPwd%>&userJob=<%=userJob%>" id="mainFormCheck" style="display: none;"></a>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>