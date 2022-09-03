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
<!-- DB에 저장된 내용과 일치하여 조건에 맞는경우 loginResult, 틀리면 loginForm으로 -->
<!-- 폼에서 가져온 내용 -->
<%! Members mem; %>
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
%>
<!-- DB에서 가져온 내용 -->
<%
String url ="jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
String sql = null;
String user = "scott";
String password = "tiger";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
	sql = "select * from members";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		mem = new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)
				, rs.getString(5), rs.getString(6));
	}
} catch (Exception e){
	e.printStackTrace();
}
%>
<!-- 두 정보 비교하기 -->
<% 
if(userId.equals(mem.getUserId()) && userPwd.equals(mem.getUserPwd())){
	Cookie cookie = new Cookie("userName", mem.getUserName());
	response.addCookie(cookie);
	session.setAttribute("userId", userId);
	session.setAttribute("userPwd", userPwd);
	/* 세션 지속시간을 넣어줄 필요가 있을까...... */
	response.sendRedirect("./loginResult.jsp");
}
else {
	response.sendRedirect("./loginForm.jsp");
}
%>

</body>
</html>