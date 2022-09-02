<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 예시2 맵 -->
<%@ page import="java.util.*" %>
<%
Map<String, String> map = new HashMap<String, String>();
map.put("name", "코난");
request.setAttribute("map", map);
%>

<%=(((Map)request.getAttribute("map")).get("name"))%> <br>
${map.name}

</body>
</html>