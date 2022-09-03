<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/* 가져온 값은 현재 수정이 된 상태
해당 값들을 DB에 넣고 Result로 보낸다*/
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
String userName = request.getParameter("userName");
String phoneNo = request.getParameter("phoneNo");
String address = request.getParameter("address");
String email = request.getParameter("email");
%>
<!-- DB열어 -->
<%
String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
String sql = null;
String user = "scott";
String password = "tiger";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
	/* 수정 할거야 */
	sql = "update members set userId = ?, userPwd = ?, userName = ?, phoneNo = ?, address = ?, email = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userId);
	pstmt.setString(2, userPwd);
	pstmt.setString(3, userName);
	pstmt.setString(4, phoneNo);
	pstmt.setString(5, address);
	pstmt.setString(6, email);
	pstmt.executeUpdate();
	/* 기존 쿠키 다주겨 */
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	/* 바뀐 값으로 쿠키 넣어 */
	Cookie cookie = new Cookie("userName", userName);
	response.addCookie(cookie);
	
	response.sendRedirect("./updateResult.jsp");
} catch (Exception e){
	e.printStackTrace();
}

conn.close();
%>

</body>
</html>