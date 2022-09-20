<%@page import="java.util.concurrent.ExecutionException"%>
<%@page import="javax.naming.Context"%>
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
#freeBoardView {
	display: inline-block;
	float: right;
	width: 1450px;
	height: auto;
	margin-top: 150px;
	text-align: center;
	overflow: hidden;
}
</style>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");  
int number = 0; 
String writer = null;
String title = null;
String regDate = null;
String content = null;
String imageFileName = null;
String fileName = null;
String path = request.getServletContext().getContextPath()+"/upload/";
String boardTitle = request.getParameter("boardTitle");
/* 상대경로 지정 */
int views = 0;
int recommends = 0;

try {
	number= Integer.parseInt(request.getParameter("number"));
} catch (Exception e){
	response.sendRedirect("./freeBoardForm.jsp?pages=1");
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
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
		}
		for(int i = 0; i < bList.size(); i++){
			if(number == bList.get(i).getNumber()){
				writer = bList.get(i).getWriter();
				title = bList.get(i).getTitle();
				regDate = bList.get(i).getRegDate();
				content = bList.get(i).getContent();
				views = bList.get(i).getViews();
				recommends = bList.get(i).getRecommends();
				if(bList.get(i).getImageFileName() != null){
					request.setAttribute("imageFileName", bList.get(i).getImageFileName());
				}
				if(bList.get(i).getFileName() != null){
					request.setAttribute("fileName", bList.get(i).getFileName());
				}
			}
		}
		views += 1;
		sql = "update board set views = ? where number = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, views);
		pstmt.setInt(2, number);
		pstmt.executeUpdate();
	} catch (Exception e){
		e.printStackTrace();
	}
%>
<%
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
request.setAttribute("writer", writer);
%>

<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./header2.jsp"></jsp:include>
<%} 
else {%>
<jsp:include page="./header.jsp"></jsp:include>
<%}%>
<div id="content2">
<div id="freeBoardView">
		<div class="container">
        <div class="row">
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
                <thead>
                    <tr>
                        <th colspan="3" style="background-color: #eeeeee; text-align:center;">게시판 글보기 <div style="float: right;">조회 : <%=views %> 추천 : <%=recommends %></div> </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td style="width:20%;">글제목</td>
                        <td colspan="2"><%=title %></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td colspan="2"><%=writer %></td>
                    </tr>
                    <tr>
                        <td>작성일자</td>
                        <td colspan="2"><%=regDate %></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td colspan="2" style="min-height:200px; text-align:left;"><img alt="" src="<%=path%>${imageFileName}" onerror="this.style.display='none'"> <br>
		<p><%=content%></p></td>
                    </tr>
                </tbody>
            </table>
    	</div>
    </div>
<c:set var ="number" value="<%=number%>"></c:set>
<form action="./recommendsProcess.do?number=${number}" method="post">
	<!-- 추천을 누르면 현재 게시글 정보의 추천이 process로 가서 1 올라서 다시 일로와야해 -->
	<input style="width: 90px;
    height: 55px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    background: url(https://i.ibb.co/vVmM42G/image.jpg) no-repeat;
    background-position:center;" type="submit" value="">
</form> <br>
<a href="./<%=boardTitle%>Form.jsp" id="freeBoardForm" style="display: none;"></a>
<input type="button" value="목록" style="
	border: 1px solid black;
	background-color: #74bbbe;
	padding: 9px 0 10px;
    font-size: 13px;
    line-height: 16px;
    text-align: center;
    color: #fff;
    border-radius: 5px;
    width: 46px;
	" onclick="document.getElementById('freeBoardForm').click();"
	/>
<%if(writer.equals((String)session.getAttribute("nickName"))){
session.setAttribute("title", title);
session.setAttribute("content", content);
session.setAttribute("imageFileName", imageFileName);
session.setAttribute("number", number);
%>
<a href="./boardUpdate.jsp?boardTitle=<%=boardTitle%>"id="boardUpdate" style="display: none;"></a>
<input type="button" value="수정하기" style="
	border: 1px solid black;
	" onclick="document.getElementById('boardUpdate').click();"
	/>
<%} %>
<hr>

<div style="height: auto">
<jsp:include page="./searchCommentProcess.jsp">
	<jsp:param value="${number}" name="number"/>
	<jsp:param value="${writer}" name="writer"/>
</jsp:include>
</div>
	<!-- 댓글을 달면, 글번호(number), 글작성자(nickname), 댓글내용은 새로받은 내용(comment), 댓글 단 시간이 regDate -->
<%if(session.getAttribute("userId") != null){%>
<div style="height: auto">
	<div>
	</div>
	<div>
	<form action="./saveComment.do?number=${number}&writer=${nickName}" method = "post"> 
		<input type="submit" style="font: 13px; font-weight: bold; float: right; height: 85px; width: 80px; background: #444;
	    border: 1px solid #303030;
	    color: #fff; border-radius: 3px;
	    box-sizing: border-box;  margin-right: 230px;" value="등록">
		<textarea style="border: 1px solid #abadb3; height: 85px; margin-right: 20px; float: right;" rows="" cols="100" name="comment"></textarea>
		<strong style="float: right; margin-right: 20px; margin-top: 30px; font-size: 1.2em">${nickName}</strong>
	</form>
	</div>
</div>
<%}%>
</div>
</div>
<%conn.close(); %>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>