<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보게시판</title>
<style type="text/css">
#freeBoardForm {
	display: inline-block;
	float: right;
	width: 1300px;
	height: 1200px;
	margin-top: 150px;
	text-align: center;
}
</style>
</head>
<body>
<!-- 11행 6열 -->
<!-- 홈으로 보낼때 session에서의 아이디 비번을 parameter로 보내자 -->
<%-- <%
String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String userJob = (String)session.getAttribute("userJob");
	String boardTitle = "informationBoard";
	ArrayList<BoardVO> bList = new ArrayList<BoardVO>();
	ArrayList<BoardVO> bList2 = new ArrayList<BoardVO>();
	ArrayList<Comment> cList = new ArrayList<Comment>();
	int pages = Integer.parseInt(request.getParameter("pages"));
%> --%>
<%-- <jsp:include page="./boardInfo.jsp" flush="false">
	<jsp:param value="<%=boardTitle%>" name="boardTitle"/>
	<jsp:param value="<%=pages%>" name="pages"/>
</jsp:include> --%>
<!-- header -->
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/header.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="../includes/header2.jsp" %>
	</c:otherwise>
</c:choose>

<div id="content">
<!-- aside -->
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/aside.jsp" %>
	</c:when>
	<%-- <c:otherwise>
		<c:choose>
			<c:when test="${userInfo.userJob eq 'soldier'}">
				<%@include file="../includes/aside3.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="../includes/aside2.jsp" %>
			</c:otherwise>
		</c:choose>
	</c:otherwise> --%>
</c:choose>


<div id="freeBoardForm">

<%-- <a href="./boardWrite.jsp?boardTitle=<%=boardTitle%>" id="boardWrite" style="display: none;"></a> --%>
	<h2>ROK ARMY 정보게시판</h2>
	<br>
	<input type="button" value="메인으로" class="goToMain" onclick="document.getElementById('mainFormCheck').click();" />
<%-- <%if(session.getAttribute("userId") != null){ %> 
	<input type="button" value="글쓰기" class="writeBoard" onclick="document.getElementById('boardWrite').click();" />
<%}%> --%>
		<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
		<thead>
			<tr style="height: 52px">
				<th style="background-color : #eeeeee; text-align:center; width:80px">글번호</th>
				<th style="background-color : #eeeeee; text-align:center; width:700px">제목</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">닉네임</th>
				<th style="background-color : #eeeeee; text-align:center; width:200px">등록일</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">조회</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">추천</th>
			</tr>
		</thead>
			<!-- board db에서 가져와서 10줄씩 테이블 생성 -->
		
<%!int count = 0;%>
<!-- item 이 보드 -->
<%-- <c:set var="items2" value="${cList}"></c:set> --%>
<!-- item2 가 댓글 -->
<c:forEach var="item" items="${bList}">
<!-- 이 링크를 누르면 해당 게시글로 가야됨 -->
	<tr style="text-align: center; height: 52px" class="boardElement">
		<td>${item.number}</td>
		<td>
		<a href="./view?number=${item.number}" style="text-decoration: none; color: black;">${item.title}</a>
		<!-- 2중 for문으로 댓글 숫자 보여줘야함 -->
		<!-- 두 글 번호가 같을경우.. 카운트가 올라가고.. 다를경우에 출력.. -->
		<%-- <c:forEach var="item2" items="${items2}">
			<c:if test="${item.number eq item2.number}">
				<%count++;%>
			</c:if>
		</c:forEach>
		<%if(count != 0){ %>
		<a href="./searchCommentProcess.jsp?number=${item.number}&writer=${item.writer}" target="_blank"  onClick="window.open(this.href, '', 'width=600, height=400'); return false;" style="text-decoration: none; color: red;">[<%=count%>]</a>
		<%} count = 0; %> --%>
		<c:if test="${item.imageFileName ne null}">
			<img src="https://i.ibb.co/JjjkzJB/imageicon.jpg" style="width:15px;height:12px;margin-left:1px; margin-bottom: 2px" border="0">
		</c:if>
		</td>
		<td>${item.writer}</td>
		<td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>
		<td>${item.views}</td>
		<td>${item.recommends}</td>
	</tr>
</c:forEach>
<!-- 추가된 테이블 열이 overflow되면.. 다음 페이지 생성하고 보여주는 목록이 그쪽 페이지로 넘어가게해야함.. -->		
</table>
<%-- <%
int size = (int)session.getAttribute("size");
int lastPage = 0;
if(size / 15 > 0) {
	lastPage = (size / 15) + 1;
}
else {
	lastPage = 1;
}
for(int i = 1; i <= lastPage; i++){
	if(i == 1){%>
	<a style="text-decoration: none; color: black" href="./informationBoardForm.jsp?pages=<%=i%>"><%=i%></a>
	<% } else if(i > 1){ %>
	<a style="text-decoration: none; color: black" href="./informationBoardForm.jsp?pages=<%=i%>"> | <%=i%></a>
	<% }
}%> --%>
	<a href="../board/main" id="mainFormCheck" style="display: none;"></a>
</div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>