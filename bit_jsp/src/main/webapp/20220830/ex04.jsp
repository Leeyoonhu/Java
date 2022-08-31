<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿Ex04</title>
</head>
<body>
<h3>구구단 출력</h3>
<%
// 여기는 자바 구간임 ㅋ
for(int i = 2; i <= 9; i++){
	for(int j = 1; j <= 9; j++){
		out.println(i + " * " + j + " = " + i * j);%><br>
	<%
	}
	%>
	<br>
	<% 
} 
// 안쪽 for문에서 j값이 증가할때마다 줄바꿈을 해주기 위해 <br> 삽입
%>
</body>
</html>