<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<%-- <%
	request.setCharacterEncoding("utf-8");
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	String userJob = (String)session.getAttribute("userJob");
	int pages = Integer.parseInt(request.getParameter("pages"));
	request.setAttribute("questionBoard", "questionBoard");
	request.setAttribute("screenBoard", "screenBoard");
	request.setAttribute("informationBoard", "informationBoard");
	request.setAttribute("freeBoard", "freeBoard");	
%> --%>
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
	<c:otherwise>
		<c:choose>
			<c:when test="${userInfo.userJob eq 'soldier'}">
				<%@include file="../includes/aside3.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="../includes/aside2.jsp" %>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
<div id="noticeBoardForm">
	<h2>전지적 군인 시점 전체게시판</h2>
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
<%-- <c:set var="items" value="${bList}"></c:set>	 --%>
<%-- <c:set var="items2" value="${cList}"></c:set> --%>
<c:forEach var="item" items="${bList}">
	<tr style="text-align: center; height: 52px" class="boardElement">
		<td>${item.number}</td>
		<td>
		<c:choose>
		<c:when test="${item.boardTitle eq 'question'}">
			<img alt="" src="https://i.ibb.co/cNBBrXT/icons8-question-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToQuestionBoard').click()">
			<a href="./question" style="display: none" id="goToQuestionBoard"></a>	
		</c:when>
			<c:when test="${item.boardTitle eq 'screen'}">
				<img alt="" src="https://i.ibb.co/cyJSqsg/icons8-image-48.png" width="26px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToScreenBoard').click()">
			<a href="./screen" style="display: none" id="goToScreenBoard"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq 'info'}">
			<img alt="" src="https://i.ibb.co/sVDnSPC/icons8-information-64.png" width="24px" height="24px" style="cursor: pointer;" onclick="document.getElementById('goToInformationBoard').click()">
			<a href="./info" style="display: none" id="goToInformationBoard"></a>	
		</c:when>
		<c:when test="${item.boardTitle eq 'free'}">
			<img alt="" src="https://i.ibb.co/Dwxw9bX/icons8-cheque-58.png" width="22px" height="24px" style="margin-bottom: 2px; cursor: pointer;" onclick="document.getElementById('goToFreeBoard').click()">
			<a href="./free" style="display: none" id="goToFreeBoard"></a>	
		</c:when>
		</c:choose>
		</td>
		<td>
		<a href="../board/view?number=${item.number}" style="text-decoration: none; color: black;">${item.title}</a>
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
		<td>
		<c:forEach var="member" items="${mList}">
			<c:if test="${item.writer eq member.nickName}">
				<c:choose>
					<c:when test="${member.userExp == 0}">
						<img src="https://i.ibb.co/DYQFRjq/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 100}">
						<img src="https://i.ibb.co/Hnhvny8/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 200}">
						<img src="https://i.ibb.co/NKXW0C9/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 300}">
						<img src="https://i.ibb.co/HNzQDJT/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 400}">
						<img src="https://i.ibb.co/M6PwMcC/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 500}">
						<img src="https://i.ibb.co/QkmbTmL/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 600}">
						<img src="https://i.ibb.co/WHGk9tW/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 700}">
						<img src="https://i.ibb.co/4PJ9wVk/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp == 800}">
						<img src="https://i.ibb.co/M7SJqZW/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp > 800}">
						<img src="https://i.ibb.co/b1CtsSW/image.png" width="20px" height="20px">
					</c:when>
				</c:choose>
			</c:if>
		</c:forEach>
		${item.writer}
		</td>
		<td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>
		<td>${item.views}</td>
		<td>${item.recommends}</td>
	</tr>
</c:forEach>	
</table>	
	<a href="../board/main" id="mainFormCheck" style="display: none;"></a>
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
<form action="../board/search" method="post" style="text-align: center;" name = "searchForm">
<select name="title" style="padding-left: 5px; width: 120px; height: 38px;  box-sizing: border-box; border: 1px solid #ccc;">
	<option selected="selected">제목</option>
	<option >닉네임</option>
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
	<a style="text-decoration: none; color: black" href="./noticeboardForm.jsp?pages=<%=i%>"><%=i%></a>
	<% } else if(i > 1){ %>
	<a style="text-decoration: none; color: black" href="./noticeboardForm.jsp?pages=<%=i%>"> | <%=i%></a>
	<% }
}%> --%>
</div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>