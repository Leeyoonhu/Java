<%@page import="java.util.concurrent.ExecutionException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
int bookId = Integer.parseInt(request.getParameter("bookId"));
String bookName = null;
String url = "jdbc:mysql://localhost:3306/scottDB?useSSL=false&allowPublicKeyRetrieval=true";
String sql = null;
String user = "scott";
String password = "tiger";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
	sql = "select bookname from book where bookId = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, bookId);
	rs = pstmt.executeQuery();
	while(rs.next()){
		bookName = rs.getString(1);
	}
} catch (Exception e){
	e.printStackTrace();
}
%>
</body>
</html>