<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


</style>
</head>
<body>
<form action="./JoinProcess.jsp">
	<table border="1">
		<tr>
			<td colspan="4" style="text-align: center">회원 가입</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
			<td>비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
			<td>이메일</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>	
</body>
</html>