<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.*, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기게시글</title>
<style type="text/css">
</style>
</head>
<body>
<div>
<!-- table start -->
<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
	<thead>
		<tr>
			<th colspan="3" style="background-color : #295298; z-index: 1; width:780px; height: 40px; color: white">인기 게시글</th>
		</tr>
	</thead>
<%!int count = 0;%>
<c:forEach var="board" items="${bList}">
	<tr style="text-align: center" class="boardElement">
		<td style="width:80px; height: 30px">
		<c:choose>
		<c:when test="${board.boardTitle eq 'question'}">
			<img alt="" src="https://i.ibb.co/cNBBrXT/icons8-question-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToQuestionBoard').click()">
			<a href="question" style="display: none" id="goToQuestionBoard" target="_parent"></a>	
		</c:when>
			<c:when test="${board.boardTitle eq 'screen'}">
				<img alt="" src="https://i.ibb.co/cyJSqsg/icons8-image-48.png" width="26px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToScreenBoard').click()">
			<a href="screen" style="display: none" id="goToScreenBoard" target="_parent"></a>	
		</c:when>
		<c:when test="${board.boardTitle eq 'info'}">
			<img alt="" src="https://i.ibb.co/sVDnSPC/icons8-information-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToInformationBoard').click()">
			<a href="info" style="display: none" id="goToInformationBoard" target="_parent"></a>	
		</c:when>
		<c:when test="${board.boardTitle eq 'free'}">
			<img alt="" src="https://i.ibb.co/Dwxw9bX/icons8-cheque-58.png" width="22px" height="24px" style="margin-bottom: 2px; cursor: pointer;" onclick="document.getElementById('goToFreeBoard').click()">
			<a href="free" style="display: none" id="goToFreeBoard" target="_parent"></a>	
		</c:when>
		</c:choose>
		</td>
		<td style="width:700px; height: 30px">
		<a href="../board/view?number=${board.number}" style="text-decoration: none; color: black;" target="_parent">${board.title}</a>
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
			
			<img src="https://i.ibb.co/vVmM42G/image.jpg" width="20px" height="20px" style="float: right"/>
		</td>
		<td>
			<div style="float: right; width: auto; margin-right: 10px">
				<c:out value="${board.recommends}"></c:out>
			</div>
		</td>
	</tr>
</c:forEach>
</table>
	<a href="../board/main" id="mainFormCheck" style="display: none;"></a>
</div>
</body>
</html>