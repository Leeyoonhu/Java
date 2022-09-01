<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");
String str = null;
if (request.getParameter("bloodType") != null){
	str = request.getParameter("bloodType") + ".jsp";
}
%>
<jsp:forward page="<%=str%>">
	<jsp:param value='코난' name="name"/>
	<jsp:param value='<%=request.getParameter("bloodType") %>' name="bloodType"/>
</jsp:forward>
</body>
</html>