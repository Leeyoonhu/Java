<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패..</title>
<style type="text/css">


</style>
</head>
<body>
<!-- 아이디는 있는데 암호가 틀렸을 때 가는 페이지 -->
<script type="text/javascript">
	alert("비밀번호가 틀렸습니다.");
</script>
<table>
	<tr>
		<td
		style="
		position: absolute;
		top: 40%;
		left: 35%;
		">
			<form action="./loginForm.jsp">
			<input type="submit" value="로그인 하러가기"> <br>
			</form>
		</td>
		<td
		style="
		position: absolute;
		top: 40%;
		left: 45%;
		">
			<form action="./mainForm.jsp">
			<input type="submit" value="메인으로 가기"> <br>
			</form>
		</td>
	</tr>
	<tr>
		<td
		style="
		position: absolute;
		top: 45%;
		left: 35%;
		">
			<form action="./findIdForm.jsp">
			<input type="submit" value="아이디 찾기">
			</form>
		</td>
		<td
		style="
		position: absolute;
		top: 45%;
		left: 45%;
		">
			<form action="./findPwdForm.jsp">
			<input type="submit" value="비밀번호 찾기">
			</form>
		</td>
	</tr>
</table>
</body>
</html>