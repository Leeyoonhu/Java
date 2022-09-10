<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*, org.ai.beans.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 글 번호 넘겨받아야함 -->
<%
String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
String sql = null;
String user = "root";
String password = "1234";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
ArrayList<Board> bList = new ArrayList<Board>();
int number = Integer.parseInt(request.getParameter("number"));

String nickName = (String)session.getAttribute("nickName");
ArrayList<Comment> cList = new ArrayList<Comment>();
ArrayList<Comment> cList2 = new ArrayList<Comment>();
request.setAttribute("nickName", nickName);  
// 댓글이 있는지 찾기 위해서 댓글 db에서 서치

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
	sql = "select * from Comment";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		/* 댓글 db전부 cList */
		cList.add(new Comment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
	}
	/* 그 중 number가 같은애들 cList2 */
	for(int i = 0; i < cList.size(); i++){
		if(cList.get(i).getNumber() == number){
			cList2.add(cList.get(i));
		}
	}
	if(cList2 != null){
		/* 같은애가 있을때만 */
		request.setAttribute("cList2", cList2);
	}
	// 게시글 리스트에서 동일한 아이디 있으면 작성자 표시
	sql = "select * from Board";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		bList.add(new Board(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
				rs.getString(7), rs.getString(8), rs.getString(9)));
	}
} catch (Exception e){
	e.printStackTrace();
}
/* 글번호가 같을때, 작성자 */
%>
<strong style="font-size: 1.3em">댓글 (<%=cList2.size()%>)</strong><br>
<hr>
<c:set var="nickName" value="${nickName}"></c:set>
<c:forEach var="item" items="${cList2}">
<div style="margin-left: 20px">
<strong style="font-size: 1.2em">${item.writer}</strong>&nbsp;
	<c:if test="${item.writer eq ''}">
		<img src="https://i.ibb.co/gZ2Pww5/icon-writer-42x15.png" style="width:42px;height:15px;margin-left:4px;" border="0">
	</c:if>
&nbsp;
<span>(${item.regDate})</span><br>
${item.comment}
</div>
</c:forEach>
</body>
</html>