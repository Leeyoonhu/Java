<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HttpServletResponse ==> 요청 재지정만 -->
<!-- HttpServletResponseEx01.java와 연동할 예정 -->
<form action="../../../portal">	<!-- Servlet에서 지정한 URL경로 -->
<input type="radio" name="site" value="naver">네이버<br>
<input type="radio" name="site" value="google">구글<br>
<input type="submit" value="이동">
</form>
</body>
</html>