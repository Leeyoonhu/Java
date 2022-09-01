<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
쿠키와 세션의 차이
세션은 서버에 저장되고, 쿠키는 클라이언트(컴퓨터)에 저장되기때문에 보안이 상대적으로 취약
종료시점은 쿠키는 저장시 설정, 세션은 알 수 없음

쿠키 생성
Cookie myCookie = new Cookie(이름, 값) // 차별하기 위해서 이름으로 구분	
생성 후 반드시 response 내장 객체의 addCookie()메소드로 쿠키를 설정해야 함
쿠키 값을 변경하려면 myCookie.setValue(변경값)
	
쿠키 객체 얻기
요청에 포함된 쿠키 가져오기
Cookie[] cookies = request.getCookies()
	
예제 1)
-->
<%
	Cookie cookie = new Cookie("appleCookie", "apple");
	cookie.setMaxAge(60 * 1); /* 1 min */
	cookie.setValue("tea");
	response.addCookie(cookie);	/* 반드시 해야할 과정 */
%>
<h3>---쿠키 생성---</h3>
<p> 쿠키 내용 확인은 <a href="./tasteCookie.jsp">여기로</a>!!! </p>
</body>
</html>