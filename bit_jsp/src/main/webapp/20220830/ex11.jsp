<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 태그Ex03</title>
</head>
<body>
<%!
	int one;
	int two = 1;
	String msg;
	int three;
	public int add(){
		return one + two;
	}
%>
one과 two의 합은? <%= add() %><p>
String msg의 값은 ? <%= msg %><p>
int three의 값은? <%= three %>
</body>
</html>