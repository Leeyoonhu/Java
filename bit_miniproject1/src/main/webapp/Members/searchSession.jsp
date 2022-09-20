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
String content = request.getParameter("content");
String searchTitle = request.getParameter("searchTitle");
String boardTitle = request.getParameter("boardTitle");
session.setAttribute("content", content);
session.setAttribute("searchTitle", searchTitle);
session.setAttribute("boardTitle", boardTitle);
response.sendRedirect("./searchNoticeBoard.do?pages=1");
%>
</body>
</html>