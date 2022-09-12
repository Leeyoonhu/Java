<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*, java.sql.*, org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	request.setCharacterEncoding("utf-8");
	String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
	String sql = null;
	String user = "root";
	String password = "1234";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Board> bList = new ArrayList<Board>();
	ArrayList<Comment> cList = new ArrayList<Comment>();
	String boardTitle = request.getParameter("boardTitle");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		/* 게시판에 따른 보여줄 정보 거르기 */
		sql = "select * from board where boardTitle= ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardTitle);
		rs = pstmt.executeQuery();
		while(rs.next()){
			bList.add(new Board(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
		}
		// 해당 글에 댓글이 몇개있는지 보여줘야함
		sql = "select number from comment";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			cList.add(new Comment(rs.getInt(1)));
		}
		Collections.reverse(bList);
		request.setAttribute("bList", bList);
		request.setAttribute("cList", cList);
	} catch (Exception e){
		e.printStackTrace();
	}
%>
<%conn.close(); %>
</body>
</html>