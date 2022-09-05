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
request.setCharacterEncoding("utf-8");
String firstName = request.getParameter("firstName");
String lastName = request.getParameter("lastName");
String phoneNo = request.getParameter("phoneNo");
%>
<!-- DB에 해당 정보 있는지 조회 -->
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
		while(rs.next()){
			memList.add(new Members(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
					, rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)
					, rs.getString(13), rs.getString(14)));
		}
		/* 만약 가져온 이름과 전화번호가 같을경우 */
		for(int i = 0; i < memList.size(); i++){
			if(firstName.equals(memList.get(i).getFirstName())&&
					lastName.equals(memList.get(i).getLastName())&&
					phoneNo.equals(memList.get(i).getPhoneNo())){
				/* 쿠키에 담아서 다음 페이지에서 알려주고 죽이자 */
				Cookie cookie = new Cookie("userId", memList.get(i).getUserId());
				response.addCookie(cookie);
				response.sendRedirect("./findIdSuccess.jsp");
			}
			/* 하나라도 다를경우 */
		}
		response.sendRedirect("./findIdFail.jsp");	
	} catch(Exception e){
		e.printStackTrace();
	}

%>
<%
conn.close();
%>
</body>
</html>