<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
	background-color: yellow;
}
</style>
</head>
<body>
<h1>Header임!!</h1>
<%! int cnt = 1;%>
<%out.println(cnt++ +"번째 방문입니다");%>

</body>
</html>