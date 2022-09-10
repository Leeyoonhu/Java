<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/* form에서 가져온 data */
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
String checkPwd = request.getParameter("checkPwd");
String nickName = request.getParameter("nickName");
String firstName = request.getParameter("firstName");
String lastName = request.getParameter("lastName");
String phoneNo = request.getParameter("phoneNo");
String pwdHintQ = request.getParameter("pwdHintQ");
String pwdHint = request.getParameter("pwdHint");
String userJob = request.getParameter("userJob");
String gender = request.getParameter("gender");
%>

<!-- userPwd와 checkPwd가 다를경우 다시보냄.. (알림창띄우면서 보내고 싶다) -->
<%
if (!userPwd.equals(checkPwd)){
	response.sendRedirect("./joinFail2.jsp");
}
%>

<%@ page import="java.util.*, java.sql.*, org.ai.beans.*" %>

<%
/* db와 연동 */
/* 넣기 전에 이미 있는 회원 정보인지 확인(Id로) */
String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
String sql = null;
String user = "root";
String password = "1234";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
ArrayList<String> aList = new ArrayList<String>();

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
	/* 일단 있는 정보인지 먼저 확인*/
	sql = "select userId from Members";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		if(rs.getString(1).equals(userId)){
			/* 회원 정보가있다는 알림창 어떻게 띄울건지 고민할 것 */ 
			response.sendRedirect("./joinFail.jsp");
		}
	}
	/* 없으면 추가 */
	sql = "insert into Members 	(userId, userPwd, checkPwd, nickName, firstName, lastName, phoneNo, pwdHintQ, pwdHint, userJob, gender) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userId);
	pstmt.setString(2, userPwd);
	pstmt.setString(3, checkPwd);
	pstmt.setString(4, nickName);
	pstmt.setString(5, firstName);
	pstmt.setString(6, lastName);
	pstmt.setString(7, phoneNo);
	pstmt.setString(8, pwdHintQ);
	pstmt.setString(9, pwdHint);
	pstmt.setString(10, userJob);
	pstmt.setString(11, gender);
	pstmt.executeUpdate();
	response.sendRedirect("./joinSuccess.jsp");
} catch (Exception e){
	e.printStackTrace();
}

%>
<%
	conn.close();
%>
</body>
</html>