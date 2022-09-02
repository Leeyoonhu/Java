<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 상황에 따라 변하는 EL -->
Literal : ${"Literals"} <br>
Operation : ${5>3} <br>
Implicit Object : ${header["host"]}
<!-- 
header는 request나 response할때 HTTP에 맞춰서 생성이됨  
홈페이지 검사기 > network > Headers에서 볼 수 있음
-->
</body>
</html>