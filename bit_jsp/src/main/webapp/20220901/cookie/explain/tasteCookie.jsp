<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>---쿠키 정보 확인---</h3>
<%
Cookie[] cookies = request.getCookies();
/* 받은 쿠키 값들의 배열 생성 */
if(cookies != null){
	/* 쿠키 배열이 null값이 아닐 경우 */
	out.println("현재 설정된 쿠키의 수 : " + cookies.length);
	out.println("<br>=================================<br>");
	for(int i = 0; i < cookies.length; i++){
		out.println("쿠키 속성 이름 ["+i+"] : " + cookies[i].getName() + "<br>");
		out.println("쿠키 속성 값 ["+i+"] : " + cookies[i].getValue() + "<br>");
		out.println("======================================<br>");
	}
	/* 브라우저를 실행시켰을 때 생성된 세션도 쿠키 배열에 저장됨 (세션이름, 세션값) */
}%>
</body>
</html>