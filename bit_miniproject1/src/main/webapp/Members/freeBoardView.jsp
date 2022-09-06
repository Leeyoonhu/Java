<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.*, java.sql.*, org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
	position: absolute;
	top : 20%;
	left : 7%;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<%
request.setCharacterEncoding("utf-8");  
int number = 0; 
String writer = null;
String title = null;
String regDate = null;
String content = null;
int views = 0;
int recommends = 0;

try {
	number= Integer.parseInt(request.getParameter("number"));
} catch (Exception e){
	response.sendRedirect("./freeBoardForm.jsp");
}
%>
<%	
/* db내에서 글번호 조회 */
	String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
	String sql = null;
	String user = "root";
	String password = "1234";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Board> bList = new ArrayList<Board>();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		sql = "select * from board";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			bList.add(new Board(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
					rs.getBlob(7), rs.getBlob(8), rs.getString(9)));
		}
		for(int i = 0; i < bList.size(); i++){
			if(number == bList.get(i).getNumber()){
				writer = bList.get(i).getWriter();
				title = bList.get(i).getTitle();
				regDate = bList.get(i).getRegDate();
				content = bList.get(i).getContent();
				views = bList.get(i).getViews();
				recommends = bList.get(i).getRecommends();
			}
		}
	} catch (Exception e){
		e.printStackTrace();
	}
%>

<h1>메인 게시판 글 보는곳</h1>
<div class="container">
	<div class="jumbotron">
		<p style="float: left;">닉네임 : <%=writer %></p> <p style="text-align: center;">작성일 : <%=regDate %></p>  <p style="float: right;"> 조회 : <%=views %> &nbsp;&nbsp; 추천 : <%=recommends %></p>
	</div>
	<hr>
</div>
	<div style=
	"position: absolute;
	top : 45%;
	left : 20%;">
	<h1><%=title %></h1>
	</div>
	<hr>
<div style="
	position: absolute;
	top : 55%;
	left : 8%;">
	<div class="jumbotron" style="height: 640px; width: 1120px">
		<p style="float: left;"><%=content %>
	</div>
</div>

<c:set var ="number" value="<%=number %>"></c:set>
<form style="
	position: absolute;
	top : 115%;
	left : 35%;" action="./recommendsProcess.do?number=${number}" method="post">
	<!-- 추천을 누르면 현재 게시글 정보의 추천이 process로 가서 1 올라서 다시 일로와야해 -->
	<input style="text-align: center; width: 100px; height: 50px" type="submit" value="추천">
</form> 
</body>
</html>