<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 9월 2일 Exercise01, 02 과제 Servlet을 사용해 회원가입 만들것임 -->
<!-- org.ai.members의 JoinProc.java Servlet을 만들것임 -->
<form action="./joinProc.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId" autofocus="autofocus" ></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPwd" ></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" ></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="tel" name="phoneNo" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>
</body>
</html>