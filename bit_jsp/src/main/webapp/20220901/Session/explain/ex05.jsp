<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 단일 세션 삭제하기 -->
	<%
		session.setAttribute("userId", "rose");
		session.setAttribute("userPwd", "1234");
		out.println(session.getAttribute("userId"));
		out.println(session.getAttribute("userPwd")+"<br>");
		session.removeAttribute("userPwd");	/* 세션내의 특정값만 삭제 */
		/* 세션내의 모든 값을 삭제(다중 세션 삭제)하고 싶다면 .invalidate() 메서드 사용 */
		out.println(session.getAttribute("userId"));
		/* 삭제 후 패스워드 확인 */
		out.println(session.getAttribute("userPwd")+"<br>");
	%>
</body>
</html>