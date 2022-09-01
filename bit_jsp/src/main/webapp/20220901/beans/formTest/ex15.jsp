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
	request.setCharacterEncoding("utf-8"); %>
	이름 : <%= request.getParameter("name") %> <br>
	번호 : <%= request.getParameter("number") %> <br>

	<jsp:useBean class="org.ai.beans.HelloBean" id="hello"></jsp:useBean>
	<jsp:setProperty property="name" name="hello" param="name"/>
	<jsp:setProperty property="number" name="hello" param="number"/>
	<p>입력하신 정보는 </p>
	이름 : <jsp:getProperty property="name" name="hello"/>
	번호 : <jsp:getProperty property="number" name="hello"/>

<!-- hello 객체의 모든 속성값을 한번에 set 할 수도 있음 "*"을 사용 -->
	<jsp:useBean class="org.ai.beans.HelloBean" id="hello1"></jsp:useBean>
	<jsp:setProperty property="*" name="hello"/>
	
</body>
</html>