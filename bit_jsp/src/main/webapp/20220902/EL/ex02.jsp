<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 예시2 list -->
<%@ page import="java.util.*" %>
<% 
String[] sArray = {"1", "2", "3"}; 
List<String> list = Arrays.asList(sArray);
request.setAttribute("list", list);
%>
<%= ((List)request.getAttribute("list")).get(0) %> <br>
${list[0]}


</body>
</html>