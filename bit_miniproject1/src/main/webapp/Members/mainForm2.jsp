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
<%if(session.getAttribute("userId") != null){ 
	if("soldier".equals((String)session.getAttribute("userJob"))){ %>
		<jsp:include page="./aside3.jsp"></jsp:include>
	<%} else { %>
		<jsp:include page="./aside2.jsp"></jsp:include>
	<% }
}else {%>
<jsp:include page="./aside.jsp"></jsp:include>
<%}%>
<div class="mainForm">
<div class="mainFormContent"> <!-- 인기게시글, 최근 게시글 을 담을거 -->
	<iframe style="margin-right : 50px"src="./popularBoardForm.jsp" width="500px" height="300px" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
	
	<iframe style="margin-left : 50px" src="./currentBoardForm.jsp" width="500px" height="300px" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
</div>
<div class="mainFormContent2">
<iframe style="margin-right : 600px"
      width="500"
      height="300"
      src="https://www.youtube.com/embed/Ql7Gau1FhHA"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
      allowfullscreen
    ></iframe>
</div>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>