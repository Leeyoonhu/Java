<%@page import="java.util.concurrent.ExecutionException"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.*, java.sql.*" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<style type="text/css">
.wrappp {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.buttonmn {
  width: 140px;
  height: 45px;
  font-family: "Roboto", sans-serif;
  font-size: 11px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 500;
  color: #000;
  background-color: #fff;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
}

.buttonmn:hover {
  background-color: #f1d1cf;
  box-shadow: 0px 15px 20px #f1d1cf;
  color: navy;
  transform: translateY(-7px);
}

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
<script type="text/javascript" src="../Js/deleteBoard.js"></script>
<%-- <%
request.setCharacterEncoding("utf-8");  
int number = 0; 
String writer = null;
String title = null;
String regDate = null;
String content = null;
String imageFileName = null;
String fileName = null;
/* String path = request.getServletContext().getContextPath()+"/upload/"; */
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
/* 	ArrayList<BoardVO> bList = new ArrayList<BoardVO>(); */
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		sql = "select * from board";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
	bList.add(new BoardVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
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
%> --%>
<%-- <%
String nickName = (String)session.getAttribute("nickName");
ArrayList<Comment> cList = new ArrayList<Comment>();
ArrayList<Comment> cList2 = new ArrayList<Comment>();
request.setAttribute("nickName", nickName);  
// 댓글이 있는지 찾기 위해서 댓글 db에서 서치
sql = "select * from Comment";
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery();
while(rs.next()){
	cList.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
<jsp:include page="./memberInfo.jsp"></jsp:include>
--%> 
<!-- header -->
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/header.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="../includes/header2.jsp" %>
	</c:otherwise>
</c:choose>
<div id="content2">
<div id="freeBoardView">
		<div class="container">
        <div class="row">
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
                <thead>
                    <tr>
                    	<th colspan="3" style="background-color: #ffdfdf; font-weight: bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시판글보기
                        	<a style="float: right;"> 조회 : ${bList.views} 추천 : ${bList.recommends}</a></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td style="width:20%;">글제목</td>
                        <td colspan="2">${bList.title}</td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td colspan="2">
        <%-- <c:forEach var="member" items="${mList}">
			<c:if test="${member.nickName eq writer}">
				<c:choose>
					<c:when test="${member.userExp == 0}">
						<img src="https://i.ibb.co/DYQFRjq/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 100}">
						<img src="https://i.ibb.co/Hnhvny8/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 200}">
						<img src="https://i.ibb.co/NKXW0C9/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 300}">
						<img src="https://i.ibb.co/HNzQDJT/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 400}">
						<img src="https://i.ibb.co/M6PwMcC/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 500}">
						<img src="https://i.ibb.co/QkmbTmL/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 600}">
						<img src="https://i.ibb.co/WHGk9tW/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 700}">
						<img src="https://i.ibb.co/4PJ9wVk/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 800}">
						<img src="https://i.ibb.co/M7SJqZW/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp > 800}">
						<img src="https://i.ibb.co/b1CtsSW/image.png" width="18px" height="18px">
					</c:when>
				</c:choose>
			</c:if>
		</c:forEach> --%>
                        ${bList.writer}</td>
                    </tr>
                    <tr>
                        <td>작성일자</td>
                        <td colspan="2">
                        <fmt:formatDate value="${bList.regDate}" pattern="yyyy년 MM월 dd일 hh시 mm분"/>
                        </td>
                    </tr>
                    <tr>
                        <td>내용</td>
                       <td colspan="2" style="min-height:200px; text-align:left;"><img alt="" src="/board/display?fileName=${bList.imageFilePath}${bList.imageFileName}" onerror="this.style.display='none'"><br>
 <p>${bList.content}</p></td>
                    </tr>
                </tbody>
            </table>
    	</div>
    </div>
    	
    
<%-- <c:set var ="number" value="<%=number%>"></c:set> --%>
<form action="./plusreco" method="post">
	<!-- 추천을 누르면 현재 게시글 정보의 추천이 process로 가서 1 올라서 다시 일로와야해 -->
	<input type="hidden" name ="number" value="${bList.number}" >
	<input style="width: 90px;
    height: 55px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    background: url(https://i.ibb.co/vVmM42G/image.jpg) no-repeat;
    background-position:center;" type="submit" value="">
</form> <br>

</div>
</div>
<%-- 	
<a href="./<%=boardTitle%>Form.jsp?pages=1" id="boardForm" style="display: none;"></a>
<div class="wrappp">
<button class="buttonmn" onclick="document.getElementById('boardForm').click();">목록</button>
<%if(writer.equals((String)session.getAttribute("nickName"))){
session.setAttribute("title", title);
session.setAttribute("content", content);
session.setAttribute("imageFileName", imageFileName);
session.setAttribute("number", number);
%>
<a href="./boardUpdate.jsp?boardTitle=<%=boardTitle%>"id="boardUpdate" style="display: none;"></a>
<button class="buttonmn" onclick="document.getElementById('boardUpdate').click();">글 수정</button>
<input id="deleteNumber" value="<%=number%>" type="text" style="display: none">
<input id="boardTitle" value="<%=boardTitle%>" type="text" style="display: none">
<button class="buttonmn" id="deleteBoard">글 삭제</button>
<%} %>
</div>
<hr>

<div style="height: auto">
<jsp:include page="./searchCommentProcess.jsp">
	<jsp:param value="${number}" name="number"/>
	<jsp:param value="${writer}" name="writer"/>
</jsp:include>
</div>
UserID : <c:out value="${session.userId}"></c:out>
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
		<textarea style="border: 1px solid #abadb3; height: 85px; margin-right: 20px; float: right; resize: none;"
		placeholder="명예훼손, 개인정보 유출, 분쟁 유발, 허위사실 유포 등의 이용약관에 의한 제재는 영창으로 갑니다." rows="" cols="100" name="comment"></textarea>
		<strong style="float: right; margin-right: 20px; margin-top: 30px; font-size: 1.2em">
		<c:forEach var="member" items="${mList}">
			<c:if test="${member.nickName eq nickName}">
				<c:choose>
					<c:when test="${member.userExp == 0}">
						<img src="https://i.ibb.co/DYQFRjq/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 100}">
						<img src="https://i.ibb.co/Hnhvny8/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 200}">
						<img src="https://i.ibb.co/NKXW0C9/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 300}">
						<img src="https://i.ibb.co/HNzQDJT/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 400}">
						<img src="https://i.ibb.co/M6PwMcC/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 500}">
						<img src="https://i.ibb.co/QkmbTmL/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 600}">
						<img src="https://i.ibb.co/WHGk9tW/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 700}">
						<img src="https://i.ibb.co/4PJ9wVk/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp == 800}">
						<img src="https://i.ibb.co/M7SJqZW/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${member.userExp > 800}">
						<img src="https://i.ibb.co/QrPKh3V/image.jpg" width="18px" height="18px">
					</c:when>
				</c:choose>
			</c:if>
		</c:forEach>
		${nickName}
		</strong>
	</form>
	</div>
</div>
<%}%>
</div>
</div>
<%conn.close(); %> --%>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
</body>
</html>