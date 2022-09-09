<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*, org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
sql = "select * from Comment";
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery();
while(rs.next()){
	cList.add(new Comment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
}
for(int i = 0; i < cList.size(); i++){
	if(cList.get(i).getNumber() == number){
		cList2.add(cList.get(i));
	}
}
if(cList2 != null){
	request.setAttribute("cList", cList2);
}

%>
</body>
</html>