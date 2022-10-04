<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Kakao Login Test</h1>
	<!-- 카카오 로그인 -->
	<!-- https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-code -->
	<span c:if="${userId==null}">
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=d23a3184f03474573dded85b7450aa27&redirect_uri=http://localhost:8080/login&response_type=code">
			<img alt="" src="/resources/img/kakao_login_medium_narrow.png">
		</a>
	</span>
	<!-- 카카오 로그아웃 -->
	<span th:if="${userId!=null}">
		<form name="logout" action="http://localhost:8080/logout">
			<input type="submit" value="로그아웃">
		</form>
	</span>
</body>
</html>