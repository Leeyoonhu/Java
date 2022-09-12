<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*, java.sql.*, org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 게시판</title>
<style type="text/css">
#screenBoardForm {
	display: inline-block;
	float: right;
	width: 1400px;
	height: 1800px;
	margin-top: 200px;
}
</style>
</head>
<body>
<%
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String userJob = (String)session.getAttribute("userJob");
	String path = request.getServletContext().getContextPath()+"/upload/";
	String boardTitle = "screenBoard";
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
<div id="screenBoardForm">
<!-- 여기다가 boardTitle = screenBoard인 애들 나오게할것 -->
<ul>
<li> <a href="./boardWrite.jsp?boardTitle=<%=boardTitle%>" id="freeBoardWrite" style="display: none;"></a>
	<%if(session.getAttribute("userId") != null){ %>
	<input type="button" value="글쓰기" style="margin-bottom: 5px; float: right;" onclick="document.getElementById('freeBoardWrite').click();" />
	<%}%> </li>
</ul>
<%!
int count = 0;
int lineCount = 0;
%>
<c:set var="items" value="${bList}"></c:set>	
<c:set var="items2" value="${cList}"></c:set>
<c:forEach var="item" items="${items}">
		<%if(lineCount == 4){
			count = 0; 
		%>	
			<br>
		<%}%>
	<div style="width: 200px; height: 300px">
		<p>글 번호 : ${item.number}</p>
		<a href="./screenBoardView.jsp?number=${item.number}" id="goScreenView" style="display: none;"></a>
		<img alt="" src="<%=path%>${item.imageFileName}" onerror="https://i.ibb.co/58bQ29v/noimage.jpg" onclick="document.getElementById('goScreenView').click()"> <br>
		<div>
		<ul>
		<li><a href="./screenBoardView.jsp?number=${item.number}" style="font-weight: bold;">${item.title}</a>
		<!-- 2중 for문으로 댓글 숫자 보여줘야함 -->
		<!-- 두 글 번호가 같을경우.. 카운트가 올라가고.. 다를경우에 출력.. -->
		<c:forEach var="item2" items="${items2}">
			<c:if test="${item.number eq item2.number}">
				<%count++;%>
			</c:if>
		</c:forEach>
		<%if(count != 0){ %>
		<a href="./searchCommentProcess.jsp?number=${item.number}&writer=${item.writer}" target="_blank" onClick="window.open(this.href, '', 'width=600, height=400'); return false;" style="text-decoration: none; color: red;">[<%=count%>]</a>
		<%} count = 0; %>
		</li>
		<li style="font: gray">${item.writer}</li><br>
		<p><li> 조회수 : ${item.views} <li><li> 추천수 : ${item.recommends} </li> </p>
		</ul>
		</div>
	</div>
	<%lineCount++; %>
</c:forEach>	

<a href="./mainForm.do?userId=<%=userId%>&userPwd=<%=userPwd%>&userJob=<%=userJob%>" id="mainFormCheck" style="display: none;"></a>
	<input type="button" value="메인 페이지로" style="margin-top: 10px;" onclick="document.getElementById('mainFormCheck').click();" />
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>