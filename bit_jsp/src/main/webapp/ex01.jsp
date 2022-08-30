<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿Ex01</title>
</head>
<body>
<%  
int count =0;
// 자바 주석은 자바 선언문 안에서만 가능~
%>
1이 증가된 후 카운트 값은
<%	out.print(++count); %>
</body>
</html>