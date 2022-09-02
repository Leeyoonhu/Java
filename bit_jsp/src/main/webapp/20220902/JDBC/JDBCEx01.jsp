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
<%@ page import="java.util.*" %>
<%@ page import="org.ai.beans.*" %>
<%
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
	}catch (Exception e) {
		e.printStackTrace();
	} 
%>
<c:set var="list" value="<%=list%>"></c:set>
<!-- 1. 테이블 안의 값들 해당 열에 맞는 java beans 만들어서 해당 클래스 ArrayList에 열 값들 담는다 -->
<!-- 2. 모든 열의 값이 들어있는 list를 변수 list에 c:set 변수 list에 담는다 -->
<!-- 3. 이제 for each문으로 list에 있는 객체 하나씩 꺼낸다 -->
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