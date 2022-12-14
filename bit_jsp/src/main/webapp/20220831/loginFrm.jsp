<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginFrm</title>
</head>
<body>
<!-- 로그인 폼임 -->
<!-- 세션이 처음이거나, 세션이 가져온 userId의 값이 null일 경우  
위 조건에 따라서 로그인, 로그아웃 창 나눠서 보이게 할 것임-->
<%if(session.isNew() || session.getAttribute("userId") == null){
	String msg = (String)request.getAttribute("error");%>
<form action="./loginProc.jsp" method="post">
	ID : <input type="text" name="userId"> <br>
	비밀번호 : <input type="password" name="userPwd"> <br>
	<input type="submit" value = "로그인">
<!-- 아이디와 비밀번호를 넣고 로그인을 누르면  -->
<!-- ip:portNum/file경로 ? userID=입력한ID값 & userPwd=입력한Pwd값 
이 주소로변경되는 이유는 method = "GET" 가 default 값이기 때문 -->
<!-- 폼에서 기입된 내용을 전달받아서 back-end 단에서 처리해야 할 부분을 action 에 기입 -->
<!-- 해당 예제에서는 loginProc.jsp에서 처리 -->
<!-- 주소창에 아이디 비밀번호를 노출시키고 싶지 않다면 method = "POST"변경 -->
<!-- 아이디나 비밀번호에 입력하는 정보는 인코딩 형식이 지정안되있어서 한글이 깨짐 -->
<!-- 따라서 back-end 단에서 인코딩 형식도 처리해 줘야 함 -->
<!-- request.setCharacterEncoding("인코딩 형식") 사용 -->
</form>
<%} else {%>
<a href="./loginProc.jsp">로그아웃</a>
<!-- a 태그를 이용해서 파일 경로로 이동하는 것은 method="get"방식임 -->
<!-- 로그인과 로그아웃의 method 방식 차이에 따라 나오는 내용을 다르게 할 것임 -->
<%} %>
</body>
</html>