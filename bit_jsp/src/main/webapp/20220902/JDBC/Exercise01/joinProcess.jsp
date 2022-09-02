<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.ai.beans.*, java.sql.*, java.util.*" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
String userName = request.getParameter("userName");
String phoneNo = request.getParameter("phoneNo");
String address = request.getParameter("address");
String email = request.getParameter("email");
%>


<table border="1">
<caption>사용자가 입력한 데이터</caption>
<tr>
	<td>아이디</td>
	<td><%=userId %></td>
	<td>비밀번호</td>
	<td><%=userPwd%></td>
</tr>
<tr>
	<td>이름</td>
	<td><%=userName %></td>
	<td>전화번호</td>
	<td><%=phoneNo %></td>
</tr>
<tr>
	<td>주소</td>
	<td><%=address%></td>
	<td>이메일</td>
	<td><%=email %></td>
</tr>
</table>
<hr>

<!-- DB 연동 -->
<%! Members mem; %>
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
		sql = "insert into members (userId, userPwd, userName, phoneNo, address, email) values (?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, userPwd);
		pstmt.setString(3, userName);
		pstmt.setString(4, phoneNo);
		pstmt.setString(5, address);
		pstmt.setString(6, email);
		pstmt.executeUpdate();
		sql = "select * from members";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		/* 1행만 가져오니까 맴버에 저장 */
		while (rs.next()){
			mem = new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
					,rs.getString(6), rs.getString(7));
		}
	} catch (Exception e){
		e.printStackTrace();
	}
%>
<%
	
%>

<table border="1">
<caption>테이블에서 읽어온 데이터</caption>
<tr>
	<td>아이디</td>
	<td><%=mem.getUserId()%></td>
	<td>비밀번호</td>
	<td><%=mem.getUserPwd() %></td>
</tr>
<tr>
	<td>이름</td>
	<td><%=mem.getUserName() %></td>
	<td>전화번호</td>
	<td><%=mem.getPhoneNo() %></td>
</tr>
<tr>
	<td>주소</td>
	<td><%=mem.getAddress() %></td>
	<td>이메일</td>
	<td><%=mem.getEmail() %></td>
</tr>
<tr>
	<td>가입일</td>
	<td colspan="4	"><%=mem.getRegDate() %></td>	
</tr>
</table>

<%
	conn.close();
%>
</body>
</html>