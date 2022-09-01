<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Members m = new Members();
	m.setUserId(request.getParameter("id"));
	m.setUserPwd(request.getParameter("pwd"));
	m.setName(request.getParameter("name"));
	m.setEmail(request.getParameter("email"));
%>

<table border="1">
	<tr>
		<td>아이디</td>
		<td><%=m.getUserId()%></td>
		<td>암호</td>
		<td><%=m.getUserPwd() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=m.getName() %></td>
		<td>이메일</td>
		<td><%=m.getEmail() %></td>
	</tr>

</table>

</body>
</html>