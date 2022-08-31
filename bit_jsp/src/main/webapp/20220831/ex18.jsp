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
String userId = (String)session.getAttribute("userId");
String userPwd = (String)session.getAttribute("userPwd");
String season = request.getParameter("season");
String fruit = request.getParameter("fruit");
%>
<h1>Session 예제</h1>
<p><strong><%=userId%></strong>님이 좋아하는 계절과 과일은 <strong><%=season%></strong>과 <strong><%=fruit%></strong>입니다.</p>
<p>세션 ID : <%=session.getId() %> </p>
<p>세션 유지시간 : <%=session.getMaxInactiveInterval()%>초 </p>
</body>
</html>