<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! Members mem; %>
<%
String url = "jdbc:mysql://localhost:3306/scottdb?useSSl=false&allowPublicKeyRetrieval=true";
String sql = null;
String dbId = "scott";
String dbPwd = "tiger";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, dbId, dbPwd);
	sql = "select * from members";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		mem = new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	}
	
} catch (Exception e) {
	e.printStackTrace();
}
		

%>

<form action="./updateProcess.jsp">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId" value="<%=mem.getUserId() %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPwd" value="<%=mem.getUserPwd() %>"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" value="<%=mem.getUserName() %>"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phoneNo" value="<%=mem.getPhoneNo() %>"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address" value="<%=mem.getAddress() %>"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="<%=mem.getEmail() %>"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center"><input type="submit" value="수정하기"></td>
		</tr>
	</table>
</form>
</body>
</html>