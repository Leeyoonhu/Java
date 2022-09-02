<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
	String dbId = "scott";
	String dbPwd = "tiger";
	String sql = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, dbId, dbPwd);
		sql = "select * from Book";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()){
			out.println(rs.getString(1) +"&nbsp;" + rs.getString(2) +"&nbsp;" + rs.getString(3) +"&nbsp;" + rs.getString(4) +"<br>");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		conn.close();
	}

%>
</body>
</html>