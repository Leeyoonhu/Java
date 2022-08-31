<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>
<h3>
1부터 10까지의 합은? 
<%
// 1 부터 10까지의 합을 구하여 출력 양식에 맞춰 출력
int sum = 0;
for(int i = 1; i <= 10; i++){
	sum += i;
	if(i < 10){
		out.println(i + " + ");
	}
	else{
		out.println(i + " = ");
	}
}
	out.println(sum);
%></h3>
</body>
</html>