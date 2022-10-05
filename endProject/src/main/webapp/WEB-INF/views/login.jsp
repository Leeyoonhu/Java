<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
	<h1>Login Test</h1>
	<!-- 카카오 로그인 -->
	<!-- https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-code -->
	<c:set var="userId" value="${userId}"></c:set>
	<c:if test="${userId eq null}">
		<span>
			<a href="#" id="kakao">
				<img alt="" src="/resources/img/kakao_login_medium_narrow.png">
			</a>
		</span>
	</c:if>
	<c:if test="${userId eq null}">
		<span>
			<!-- 네이버 로그인 controller의 apiURL -->
			<input style="display: none" value="${apiURL}" id="naverURL">
			<a href="#" id="naver"><img height="40" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
		</span>
	</c:if>
	<!-- 로그아웃 -->
	<c:if test="${userId ne null}">
		<span>
			<form name="logout" action="http://localhost:8080/logout">
				<input type="submit" value="로그아웃">
			</form>
		</span>
	</c:if>
</body>
<script type="text/javascript" src="/resources/js/login.js"></script>
</html>