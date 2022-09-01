<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="org.ai.beans.Members" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Members m = new Members();
		m.setUserId("conan");
		m.setName("코난");
	%>
	이름 : <%=m.getName()%>,	 
	아이디 : <%=m.getUserId() %>
</body>
</html>