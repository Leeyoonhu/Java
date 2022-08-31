<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿Ex03</title>
</head>
<body>
<%
/* println 줄바꿈안되서 br넣어야함
1~10까지 짝수인 경우만 출력 */
	for(int i = 1; i <= 10; i++)
	{
		if(i % 2 == 0){
			out.println(i + "<br>");
		}
	}
%>
</body>
</html>