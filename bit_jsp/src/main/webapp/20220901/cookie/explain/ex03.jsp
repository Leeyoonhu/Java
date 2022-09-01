<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 쿠키 삭제 => setMaxAge()로 쿠키의 유효시간을 변경할 수 있는데, 0으로 바꾸면 쿠키가 삭제됨 -->
<% 
Cookie[] cookies = request.getCookies();
for(int i = 0; i < cookies.length; i++){
	/* 쿠키는 Client(컴퓨터)에 저장되기떄문에 response에 남아있다 ex) 자동 로그인 정보 등 */
	cookies[i].setMaxAge(0);	/* 쿠키 배열들의 setMaxAge값을 0으로 둠으로써 모든 쿠키 삭제 */
	response.addCookie(cookies[i]); /* 쿠키들의 setMaxAge가 0이 됬음을 response에 더함 */
}
response.sendRedirect("./tasteCookie.jsp");	/* 모든 쿠키가 삭제된 응답을 tasteCookie.jsp에 보냄 */
/* 단, 삭제되었어도 브라우저를 실행시 생성되는 세션 쿠키는 재생성됨 */
%>
</body>
</html>