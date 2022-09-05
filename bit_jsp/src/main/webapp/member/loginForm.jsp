<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./loginProc.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId" placeholder ="아이디"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPwd" placeholder ="비밀번호"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>
</body>
</html>