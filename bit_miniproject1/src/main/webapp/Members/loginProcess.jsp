<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*, java.sql.*, org.ai.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 폼에서 받은 정보를 db정보와 판별하여 로그인시킴 -->
<!-- 로그인 되면 세션과 쿠키 생성 -->
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
%>
<!-- db에서 정보 뽑기 -->
<%
	String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
	String sql = null;
	String user = "root";
	String password = "1234";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Members> memList = new ArrayList<Members>();
	int cnt = 0;
	/* db 에서 꺼낸 고객 아이디, 비밀번호를 가지고 있는 memList */
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		sql = "select * from members";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		/* 가져온 고객 정보(아이디, 비번만 가져오려했는데.. )
			언제 더 쓸지 모르니 일단 다가져옴 (나중에 다 만들면 필요한 정보만 가져올 것)
		*/
		while(rs.next()){
			memList.add(new Members(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
					, rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)
					, rs.getString(13), rs.getString(14)));
		}
		for(int i = 0; i< memList.size(); i++){
			/* 아이디 같을때*/
			if(userId.equals(memList.get(i).getUserId())){
				/* 비밀번호 같을 때 */
				if(userPwd.equals(memList.get(i).getUserPwd())){
					/* 쿠키 생성(일단은 닉네임과 회원번호, 회원 경험치만) */
					Cookie cookie = new Cookie("nickName", memList.get(i).getNickName());
					response.addCookie(cookie);
					String str1 = String.format("%d", memList.get(i).getUserNum());
					Cookie cookie1 = new Cookie("userNum", str1);
					response.addCookie(cookie1);
					String str2 = String.format("%d", memList.get(i).getUserExp());
					Cookie cookie2 = new Cookie("userExp", str2);
					response.addCookie(cookie2);
					/* 로그인 세션 생성 */
					session.setAttribute("userId", userId);
					session.setAttribute("userPwd", userPwd);
					/* 글쓰기 등을 할 때 필요한 nickName 세션 추가 // board에선 writer역할 */
					session.setAttribute("nickName", memList.get(i).getNickName());
					/* 군인인지 판별을 위해 job 세션 추가*/
					session.setAttribute("userJob", memList.get(i).getUserJob());
					/* 성공 페이지 이동 */
					/* 로그인 성공 페이지가아니고.. 메인페이지에 군인인지 아닌지로 보낼까? */
					if(memList.get(i).getUserJob().equals("soldier")){
						response.sendRedirect("./mainForm3.jsp");
					}
					else {
						response.sendRedirect("./mainForm2.jsp");
					} 
				}
			}
		}
		for(int i = 0; i< memList.size(); i++){
			if(userId.equals(memList.get(i).getUserId())){
				/* 아이디 같고 */
				if(!userPwd.equals(memList.get(i).getUserPwd())){
					/*  비밀번호 다를때 */
					response.sendRedirect("./loginFail.jsp");
				}
			}
		}
			/* 아이디조차 없을때 */
			/* 같은 아이디를 찾지 못했을때 없다는 것을 알려주고, 메인 / 회원가입 을 선택할수 있는 페이지로 이동 */
		response.sendRedirect("./loginFail2.jsp");
	} catch (Exception e){
		e.printStackTrace();
	}
%>
<%
conn.close();
%>
</body>
</html>