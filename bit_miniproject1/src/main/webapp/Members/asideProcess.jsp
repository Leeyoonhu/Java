<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*, java.sql.*, org.ai.beans.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String nickName = request.getParameter("nickName");
int userExp = 0;
String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
String sql = null;
String user = "root";
String password = "1234";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
%>
<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		sql = "select userExp from members where nickName = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nickName);
		rs = pstmt.executeQuery();
		while(rs.next()){
			userExp = rs.getInt(1);
		}
		request.setAttribute("userExp", userExp);
	} catch (Exception e){
		e.printStackTrace();
	}
%>
<% conn.close(); %>
</body>
</html>