<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- web.xml 내부에 파라미터를 추가한 후에 서버 재시작 -->
<!-- 
	loginFrm2 = 아이디, 비밀번호 입력 양식 
	loginProc2 = 초기 설정된 정보와 입력 받은 아이디, 비밀번호 확인 후 일치한 경우만 아이디 세션 저장
	loginChk = 세션에 저장된 아이디 정보 출력
	logout = 세션을 무효화 시킨 후 로그인창 이동
 -->
<form action="loginProc2.jsp">
	관리자 로그인<br>
	아뒤 : <input type="text" name="id"> <br>
	비번 : <input type="password" name="pwd">
	<input type="submit" value="전송">
</form>

</body>
</html>