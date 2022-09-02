<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ex01에서 1번 값 수정, 3번 값 삭제 -->
<%@ page import="java.util.*" %>
<%@ page import="org.ai.beans.*" %>
<%
	/* allowPublicKeyRetrieval=true // mySQL 공개키의 공개 오류 방지용 */
	String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
	String dbId = "scott";
	String dbPwd = "tiger";
	String sql = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Book> list = new ArrayList<Book>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, dbId, dbPwd);
		sql = "select * from Book";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()){
			list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		list.remove(2);
		list.get(0).setPrice(15000);
	}catch (Exception e) {
		e.printStackTrace();
	} 
%>
<c:set var="list" value="<%=list%>"></c:set>
<table border="1">
	<tr>
		<th>BOOKID</th>
		<th>BOOK NAME</th>
		<th>PUBLISHER</th>
		<th>PRICE</th>
	</tr>
	<c:forEach var = "item" items ="${list}">
	<tr>
		<td>${item.bookId}</td>
		<td>${item.bookName}</td>
		<td>${item.publisher}</td>
		<td>${item.price}</td>
	</tr>
	</c:forEach>
</table>
<%
	conn.close();
%>
</body>
</html>