<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 태그Ex01</title>
</head>
<body>
<%! 
// <%! 전역변수 선언 or 메소드 선언 %.> 
	int count = 0;	// 전역변수 count 선언
%>
1이 증가된 후 카운트 값은
<%
	out.println(++count);
%>
</body>
</html>