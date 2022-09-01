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
<jsp:getProperty property="number" name="hello"/> <hr>
<jsp:setProperty property="number" name="hello" value="1234"/>
<jsp:getProperty property="name" name="hello"/>
<jsp:getProperty property="number" name="hello"/>
<!-- useBean의 id ==> hello = new HelloBean() -->
</body>
</html>