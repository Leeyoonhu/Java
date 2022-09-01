<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean class="org.ai.beans.HelloBean" id="hello"></jsp:useBean>
<jsp:getProperty property="name" name="hello"/>
<jsp:setProperty property="name" name="hello" value="conan"/>
<jsp:getProperty property="name" name="hello"/>
<!-- useBean의 id ==> hello = new HelloBean() -->
</body>
</html>