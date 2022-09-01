<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#left {
	float: left;
	padding-right : 30px;
	padding-bottom : 400px;
}
</style>
</head>
<body>
	<table border="1">
	<tr>
		<td colspan="2"> <jsp:include page="./include/top.jsp"></jsp:include> </td>
	</tr>
	<tr>
		<td id = "left"><jsp:include page="./include/menu.jsp"></jsp:include></td>
		<td>
			<jsp:include page="./home.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
		<td colspan="2"> <jsp:include page="./include/bottom.jsp"></jsp:include> </td>
	</tr>
	</table>
</body>
</html>