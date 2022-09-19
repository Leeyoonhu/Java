<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ROK ARMY</title>
</head>
<body>
<!-- 군인이 아닐때 보이는 홈페이지 -->
<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./header2.jsp"></jsp:include>
<%} 
else {%>
<jsp:include page="./header.jsp"></jsp:include>
<%}%>
<div id="content">
<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./aside2.jsp"></jsp:include>
<%}else {%>
<jsp:include page="./aside.jsp"></jsp:include>
<%}%>
<div class="mainForm">
<div class="mainFormContent"> <!-- 인기게시글, 최근 게시글 을 담을거 -->
	<iframe src="./popularBoardForm.jsp" width="400px" height="300px" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
	<iframe src="./currentBoardForm.jsp" width="400px" height="300px" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
</div>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>