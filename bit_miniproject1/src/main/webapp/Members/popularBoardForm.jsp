<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.*, java.sql.*, org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기게시글</title>
<style type="text/css">
</style>
</head>
<body>
<jsp:include page="./popularBoardProcess.jsp"></jsp:include>

<%
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String userJob = (String)session.getAttribute("userJob");
	request.setCharacterEncoding("utf-8");
	request.setAttribute("questionBoard", "questionBoard");
	request.setAttribute("screenBoard", "screenBoard");
	request.setAttribute("informationBoard", "informationBoard");
	request.setAttribute("freeBoard", "freeBoard");
%>

<div>
		<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th colspan="2" style="background-color : #295298; z-index: 1; width:780px; height: 40px; color: white">인기 게시글</th>
			</tr>
		</thead>

<%!int count = 0;%>
<c:set var="items" value="${bList}"></c:set>	
<c:set var="items2" value="${cList}"></c:set>
<c:forEach var="item" items="${items}">
	<tr style="text-align: center" class="boardElement">
		<td style="width:80px">
		<c:choose>
		<c:when test="${item.boardTitle eq questionBoard}">
			<img alt="" src="https://i.ibb.co/cNBBrXT/icons8-question-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToQuestionBoard').click()">
			<a href="./questionBoardForm.jsp" style="display: none" id="goToQuestionBoard" target="_parent"></a>	
		</c:when>
			<c:when test="${item.boardTitle eq screenBoard}">
				<img alt="" src="https://i.ibb.co/cyJSqsg/icons8-image-48.png" width="26px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToScreenBoard').click()">
			<a href="./screenBoardForm.jsp" style="display: none" id="goToScreenBoard" target="_parent"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq informationBoard}">
			<img alt="" src="https://i.ibb.co/sVDnSPC/icons8-information-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToInformationBoard').click()">
			<a href="./informationBoardForm.jsp" style="display: none" id="goToInformationBoard" target="_parent"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq freeBoard}">
			<img alt="" src="https://i.ibb.co/Dwxw9bX/icons8-cheque-58.png" width="22px" height="26px" style="margin-bottom: 2px; cursor: pointer;" onclick="document.getElementById('goToFreeBoard').click()">
			<a href="./freeBoardForm.jsp" style="display: none" id="goToFreeBoard" target="_parent"></a>	
		</c:when>
		</c:choose>
		</td>
		<td style="width:700px">
		<a href="./boardView.jsp?number=${item.number}&boardTitle=${item.boardTitle}" style="text-decoration: none; color: black;" target="_parent">${item.title}</a>
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
	</tr>
</c:forEach>	
</table>
	<a href="./mainForm.do?userId=<%=userId%>&userPwd=<%=userPwd%>&userJob=<%=userJob%>" id="mainFormCheck" style="display: none;"></a>
</div>
</body>
</html>