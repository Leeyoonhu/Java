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
<!-- 사용자가 입력한 값 -->
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");
String pwdHintQ = request.getParameter("pwdHintQ");
String pwdHint = request.getParameter("pwdHint");
%>
<!-- DB에서 조회 -->
<%
	String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
	String sql = null;
	String user = "root";
	String password = "1234";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Members> memList = new ArrayList<Members>();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		sql = "select * from members";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		/* db 모든 정보를 담은 memList */
		while(rs.next()){
			memList.add(new Members(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
					, rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)
					, rs.getString(13), rs.getString(14)));
		}
		/* db에서 아이디,힌트,힌트답변이 같을때만 비밀번호 알려줌 */
		for(int i = 0; i < memList.size(); i++){
			if(userId.equals(memList.get(i).getUserId()) &&
					pwdHintQ.equals(memList.get(i).getPwdHintQ()) &&
					pwdHint.equals(memList.get(i).getPwdHint())){
				Cookie cookie = new Cookie("userPwd", memList.get(i).getUserPwd());
				response.addCookie(cookie);
				response.sendRedirect("./findPwdSuccess.jsp");
			}
		}
		response.sendRedirect("./findPwdFail.jsp");
	} catch (Exception e){
		e.printStackTrace();
	}
%>
<%
conn.close();
%>
</body>
</html>