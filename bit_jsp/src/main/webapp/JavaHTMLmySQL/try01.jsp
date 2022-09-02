<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*" %>
<%!
	String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
	String user = "scott";
	String password = "tiger";
	String sql = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
	sql = "Select * from emp";
	ps = conn.prepareStatement(sql);
	rs = ps.executeQuery(sql);
	
	while(rs.next()){%>
	<%=rs.getString(1)+"  "%><%=rs.getString(2)+"  " %><%=rs.getString(3)+"  " %><%=rs.getString(4)+"  " %>
	<%=rs.getString(5)+"  " %><%=rs.getString(6)+"  " %><%=rs.getString(7)+"  " %><%=rs.getString(8)+"  " %> <br>
	<%}
} catch (Exception e){
	out.print("오류가 났습니다");
}
%>


</body>
</html>