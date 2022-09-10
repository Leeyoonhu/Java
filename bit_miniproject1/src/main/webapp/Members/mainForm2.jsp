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
<jsp:include page="./aside.jsp"></jsp:include>
<!-- <div id="메인내용물2">
	내용물올것임2 //  로그인했을때만 보이는 aside.jsp로 교체 필요
</div> -->
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>