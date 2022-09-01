<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- //체크 여부를 판단해서 쿠키에 체크여부 즉 유저아디를 출력할 것인가를 결정짓는 쿠키를 생성후 리스판스에 애드... -->

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String check = request.getParameter("check");
String id2 = application.getInitParameter("adminId");
String pwd2 = application.getInitParameter("adminPwd");
%>

 
<%if((id.equalsIgnoreCase(id2) && pwd.equalsIgnoreCase(pwd2))){
	Cookie cookie = new Cookie("id", id);%>

	로그인에 성공했음 <br>
	<a href="./loginForm.jsp">로그인 폼으로</a>	
	<%if(check == null){
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}else{
		response.addCookie(cookie);
	}%>
<%}
else {
	out.println("아이디나 비밀번호가 맞지 않습니다.");
}
%>
	
	
		
	
	

	


</body>
</html>