<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 홈페이지 주소에서 파일경로 후에 쿼리문으로 name- value값을 줄것 -->
<!-- include 로 request.getParamet(name) 하는애를 가지고왔기때문에
한글을 출력하고 싶다면 인코딩 방식을 지정해 주어야 한다 -->
<%request.setCharacterEncoding("UTF-8"); %>
include 전 name 파라미터 : <%=request.getParameter("name") %>
<hr>
<jsp:include page="./body_sub.jsp" flush = "false">
	<jsp:param name="name" value="장미" ></jsp:param>
</jsp:include>
<hr>
include 후 name 파라미터 : <%=request.getParameter("name") %>
</body>
</html>