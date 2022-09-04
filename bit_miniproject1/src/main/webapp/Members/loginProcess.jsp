<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*, java.sql.*, org.ai.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 폼에서 받은 정보를 db정보와 판별하여 로그인시킴 -->
<!-- 로그인 되면 세션과 쿠키 생성 -->
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
%>
<!-- db에서 정보 뽑기 -->
<%
	String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
	String sql = null;
	String user = "root";
	String password = "1234";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		out.println("연결됨");
	} catch (Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>