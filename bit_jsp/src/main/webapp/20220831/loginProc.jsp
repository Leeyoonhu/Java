<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProc</title>
</head>
<body>
<!-- 파라미터의 이름을 알 때 속성값을 가져오는 메서드 사용 -->
<%
request.setCharacterEncoding("UTF-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
// 유효성 검사 
// 만약에 받은 Id, Pwd 값이 없으면, 다시 로그인 페이지로 돌아가게 설정
if(userId.isEmpty() || userPwd.isEmpty()){
	RequestDispatcher rd = request.getRequestDispatcher("./loginFrm.jsp");
	// RequestDispatcher : 요청 재지정
	// id, pwd 값 둘중 하나가 비었다면 요청과 응답 이전으로 보낸다
	rd.forward(request, response);
	return;
}
%>
아이디 / 비밀번호 : <%= userId %> / <%= userPwd %>
</body>
</html>