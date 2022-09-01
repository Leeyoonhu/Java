<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.setAttribute("userId", "rose");
session.setAttribute("userPwd", "1234");
/* 세션에 값 2개 저장 */
String name, value;
int i = 0;
Enumeration en = session.getAttributeNames();	
while(en.hasMoreElements()){
	/* 열거 타입 en이 요소를 가지고 있을 경우 반복문 실행 */
	i++;
	name = (String)en.nextElement();
	/* 열거타입 en에 저장된 요소를 name에 저장 */
	value = (String)session.getAttribute(name);
	/* 이름이 name인 value들을 String 형 변수 value에 저장 */
	out.println("설정된 세션의 속성 이름["+i+"] : "+name+"<br>");
	out.println("설정된 세션의 값 이름["+i+"] : "+value+"<br>");
}	
%>
</body>
</html>