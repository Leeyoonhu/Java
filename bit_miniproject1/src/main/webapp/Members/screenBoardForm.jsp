<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	text-align: center;
}
</style>
</head>
<body>
<%
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String boardTitle = "screenBoard";
%>
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
<a href="./boardWrite.jsp?boardTitle=<%=boardTitle%>" id="freeBoardWrite" style="display: none;"></a>
	<%if(session.getAttribute("userId") != null){ %>
	<input type="button" value="글쓰기" style="margin-bottom: 5px; float: right;" onclick="document.getElementById('freeBoardWrite').click();" />
	<%}%> 
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>