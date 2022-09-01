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
session.setAttribute("userId", "rose"); 	/* setParameter와 헷갈리지말것 */
out.print((String)session.getAttribute("userId"));	/* 반환형이 object라서 필요 시 형변환이 필요 */
out.print((String)session.getAttribute("rose"));
%>
</body>
</html>