<%@page import="java.sql.*, java.util.*, org.ai.beans.*"%>
<%@page import="com.mysql.cj.jdbc.ha.ReplicationMySQLConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- book db사용한 테이블에서부터 시작  -->
<%
	String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
	String sql = null;
	String user = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Book> bList = new ArrayList<Book>();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		sql = "select * from book";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			bList.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
	} catch (Exception e){
		e.printStackTrace();
	}
	/* 모든 정보를 담은 bList */
%>

<c:set var="list" value="<%=bList %>"></c:set>

<table border="1">
	<tr>
		<th style="text-align: center">BOOKNAME</th>
		<th style="text-align: center">PUBLISHER</th>
		<th style="text-align: center">PRICE</th>
	</tr>
	<c:forEach var="item" items="${list }">	
	<tr>
		<!-- a태그에서 파라미터 전송하려면 ?쿼리문에 name-value -->
		<!-- 항상 parameter와 attribute를 구분할 것 -->
		<td><a href="./bookview.jsp?bookName=${item.bookName}&publisher=${item.publisher}&price=${item.price}"> ${item.bookName}</a></td>
		<td>${item.publisher}</td>
		<td>${item.price}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>