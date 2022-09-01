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
/* 아이디나 비밀번호를 입력하지 않았을 경우 */
if(id.isEmpty() || pwd.isEmpty()){
	RequestDispatcher rd = request.getRequestDispatcher("./loginForm.jsp");
	rd.forward(request, response);
}
/* 관리자로 접속했을 경우(loginSuccess)와 그렇지 않은 경우(loginFail) */
if(id.equals("admin") && pwd.equals("admin")){
	response.sendRedirect("./loginSuccess.jsp");
}
else {
	response.sendRedirect("./loginFail.jsp");
}
%>
</body>
</html>