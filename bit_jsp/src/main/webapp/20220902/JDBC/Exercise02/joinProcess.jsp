<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 폼에서 받은걸 DB에 넣고, 그 후에 joinResult로 보내라 -->
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
String userName = request.getParameter("userName");
String phoneNo = request.getParameter("phoneNo");
String address = request.getParameter("address");
String email = request.getParameter("email");
%>
<%
String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
String sql = null;
String dbId = "scott";
String dbPwd = "tiger";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, dbId, dbPwd);
	sql = "insert into members (userId, userPwd, userName, phoneNo, address, email) values (?, ?, ?, ?, ?, ?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userId);
	pstmt.setString(2, userPwd);
	pstmt.setString(3, userName);
	pstmt.setString(4, phoneNo);
	pstmt.setString(5, address);
	pstmt.setString(6, email);
	pstmt.executeUpdate();
	response.sendRedirect("./joinResult.jsp");	
} catch (Exception e) {
	e.printStackTrace();
}

conn.close();
%>


</body>
</html>