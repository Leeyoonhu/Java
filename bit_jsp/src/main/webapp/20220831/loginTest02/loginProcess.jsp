<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProcess</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
%>
<%
if(id.isEmpty() || pwd.isEmpty()){
	RequestDispatcher rd = request.getRequestDispatcher("./loginForm.jsp");
	rd.forward(request, response); 
}
%>
</body>
</html>