<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProc</title>
</head>
<body>

<%
// 예제 1
// 파라미터의 이름을 알 때 속성값을 가져오는 메서드 사용
request.setCharacterEncoding("UTF-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
// method = "posd" 일때
if(request.getMethod().equalsIgnoreCase("post")){
// 유효성 검사  -->
// 만약에 받은 Id, Pwd 값이 없으면, 다시 로그인 페이지로 돌아가게 설정 -->
if(userId.isEmpty() || userPwd.isEmpty()){
	RequestDispatcher rd = request.getRequestDispatcher("./loginFrm.jsp"); 
	// RequestDispatcher : 요청 재지정 -->
	// id, pwd 값 둘중 하나가 비었다면 요청과 응답 이전으로 보낸다 -->
	rd.forward(request, response); 
	return; 
} 

// 예제 2
// request.setCharacterEncoding("UTF-8");
// String userId = request.getParameter("userId");
// String userPwd = request.getParameter("userPwd");
// // 아이디와 비밀번호 확인
// if(userId.equals("admin") && userPwd.equals("admin")){
// 	response.sendRedirect("./loginSuccess.jsp");
// // 아이디 비밀번호가 admin일 경우, loginSuccess.jsp 파일경로로 보냄
// }
// else {
// 	response.sendRedirect("./loginFail.jsp");
// }

// 로그인 처리
// 세션이 새로 생성되었거나, 가져온 아이디 값이 null값인경우
// 한번 접속을 하면 세션이 생성됨
if(session.isNew() || session.getAttribute("userId") == null){
	session.setAttribute("userId", userId);
	out.print("로긴 완료되었음");
}
else {
	out.print("이미 로긴 상태임");
}
%>

아이디 / 비밀번호 : <%= userId %> / <%= userPwd %>

<%
// method = "get" 일 때
} else if (request.getMethod().equalsIgnoreCase("get")){
// 	세션이 null이 아니거나, userId의 속성값이 null이 아닐 때
	if (session != null || session.getAttribute("userId") != null){
// 		세션을 초기화 하고 로그아웃 문구 출력
		session.invalidate();
		out.print("로그아웃 작업이 완료됨");
	}
	else {
		out.print("현재 로긴 상태가 아님");
	}
}
%>
</body>
</html>