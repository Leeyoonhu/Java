<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*, org.ai.beans.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체게시판</title>
<style type="text/css">
#noticeBoardForm {
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
<%
	request.setCharacterEncoding("utf-8");
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String userJob = (String)session.getAttribute("userJob");
	int pages = Integer.parseInt(request.getParameter("pages"));
	request.setAttribute("questionBoard", "questionBoard");
	request.setAttribute("screenBoard", "screenBoard");
	request.setAttribute("informationBoard", "informationBoard");
	request.setAttribute("freeBoard", "freeBoard");	
%>
<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./header2.jsp"></jsp:include>
<%} 
else {%>
<jsp:include page="./header.jsp"></jsp:include>
<%}%>
<div id="content">
<%if(session.getAttribute("userId") != null){ 
	if("soldier".equals((String)session.getAttribute("userJob"))){ %>
		<jsp:include page="./aside3.jsp"></jsp:include>
	<%} else { %>
		<jsp:include page="./aside2.jsp"></jsp:include>
	<% }
}else {%>
<jsp:include page="./aside.jsp"></jsp:include>
<%}%>
<%if(session.getAttribute("bList") == null){ %>
<jsp:include page="./noticeBoardProcess.jsp">
	<jsp:param value="<%=pages%>" name="pages"/>
</jsp:include>
<%} %>
<div id="noticeBoardForm">
	<h2>ROK ARMY 전체게시판</h2>
	<br>
	<input type="button" value="메인으로" class="goToMain" onclick="document.getElementById('mainFormCheck').click();" />
		<table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
		<thead>
			<tr style="height: 52px">
				<th style="background-color : #eeeeee; text-align:center; width:80px">글번호</th>
				<th style="background-color : #eeeeee; text-align:center; width:80px">
					<img alt="" src="https://i.ibb.co/yQ8yXZM/icons8-noticeboard-48.png" width="24px" height="24px">
				</th>
				<th style="background-color : #eeeeee; text-align:center; width:700px">제목</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">닉네임</th>
				<th style="background-color : #eeeeee; text-align:center; width:200px">등록일</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">조회</th>
				<th style="background-color : #eeeeee; text-align:center; width:100px">추천</th>
			</tr>
		</thead>
<%!int count = 0;%>
<c:set var="items" value="${bList}"></c:set>	
<c:set var="items2" value="${cList}"></c:set>
<c:forEach var="item" items="${items}">
	<tr style="text-align: center; height: 52px" class="boardElement">
		<td>${item.number}</td>
		<td>
		<c:choose>
		<c:when test="${item.boardTitle eq questionBoard}">
			<img alt="" src="https://i.ibb.co/cNBBrXT/icons8-question-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToQuestionBoard').click()">
			<a href="./questionBoardForm.jsp?pages=1" style="display: none" id="goToQuestionBoard"></a>	
		</c:when>
			<c:when test="${item.boardTitle eq screenBoard}">
				<img alt="" src="https://i.ibb.co/cyJSqsg/icons8-image-48.png" width="26px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToScreenBoard').click()">
			<a href="./screenBoardForm.jsp?pages=1" style="display: none" id="goToScreenBoard"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq informationBoard}">
			<img alt="" src="https://i.ibb.co/sVDnSPC/icons8-information-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToInformationBoard').click()">
			<a href="./informationBoardForm.jsp?pages=1" style="display: none" id="goToInformationBoard"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq freeBoard}">
			<img alt="" src="https://i.ibb.co/Dwxw9bX/icons8-cheque-58.png" width="22px" height="24px" style="margin-bottom: 2px; cursor: pointer;" onclick="document.getElementById('goToFreeBoard').click()">
			<a href="./freeBoardForm.jsp?pages=1" style="display: none" id="goToFreeBoard"></a>	
		</c:when>
		</c:choose>
		</td>
		<td>
		<a href="./boardView.jsp?number=${item.number}&boardTitle=${item.boardTitle}" style="text-decoration: none; color: black;">${item.title}</a>
		<c:forEach var="item2" items="${items2}">
			<c:if test="${item.number eq item2.number}">
				<%count++;%>
			</c:if>
		</c:forEach>
		<%if(count != 0){ %>
		<a href="./searchCommentProcess.jsp?number=${item.number}&writer=${item.writer}" target="_blank"  onClick="window.open(this.href, '', 'width=600, height=400'); return false;" style="text-decoration: none; color: red;">[<%=count%>]</a>
		<%} count = 0; %>
		<c:if test="${item.imageFileName ne null}">
			<img src="https://i.ibb.co/JjjkzJB/imageicon.jpg" style="width:15px;height:12px;margin-left:1px; margin-bottom: 2px" border="0">
		</c:if>
		</td>
		<td>${item.writer}</td>
		<td>${item.regDate}</td>
		<td>${item.views}</td>
		<td>${item.recommends}</td>
	</tr>
</c:forEach>	
</table>	
	<a href="./mainForm.do?userId=<%=userId%>&userPwd=<%=userPwd%>&userJob=<%=userJob%>" id="mainFormCheck" style="display: none;"></a>
<br>
<script type="text/javascript">
	function checkContent(){
		let form = document.searchForm;
		if(form.content.value == ""){
			alert("검색하실 내용을 입력해주세요.");
		}
		else {
			form.submit();
		}
	}
</script>
<form action="./searchSession.jsp" method="post" style="text-align: center;" name = "searchForm">
<select name="searchTitle" style="padding-left: 5px; width: 120px; height: 38px;  box-sizing: border-box; border: 1px solid #ccc;">
	<option selected="selected">제목</option>
	<option>닉네임</option>
</select>
<input type="text" name="content" style="padding: 0px 5px; width: 400px; height: 38px; box-sizing: border-box; border: 1px solid #ccc; padding-left: 6px">
<button type="button" style=" 
	width: 60px;
    height: 38px;
    border: 1px solid #ccc;
    box-sizing: border-box;
    background: url(https://i.ibb.co/q1QvKRf/image.png) no-repeat;
    background-position:center;
    cursor: pointer;
    padding: 0px 6px;
    "
    onclick="checkContent()">&nbsp;</button>
</form>
<br>
<%
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
	<a style="text-decoration: none; color: black" href="./searchNoticeBoard.do?pages=<%=i%>"><%=i%></a>
	<% } else if(i > 1){ %>
	<a style="text-decoration: none; color: black" href="./searchNoticeBoard.do?pages=<%=i%>"> | <%=i%></a>
	<% }
}%>


<%
session.removeAttribute("size");
session.removeAttribute("bList");
session.removeAttribute("cList");
%>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>