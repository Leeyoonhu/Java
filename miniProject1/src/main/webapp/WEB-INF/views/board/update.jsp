<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/resources/js/update.js"></script>
<title>글 쓰기</title>
<style type="text/css">
#freeBoardWrite {
   display: inline-block;
   float: right;
   width: 1400px;
   height: 1200px;
   margin-top: 200px;
   text-align: center;
}
 .table_input {
        display: block;
        width: 1500px;
        min-height: 40px;
        padding: 11px 12px 10px;
        border: 1px solid #ebecef;
        box-sizing: border-box;
        overflow: hidden;
        word-break: break-all;
        font-size: 15px;
        letter-spacing: -.23px;
        line-height: 17px;
        outline: none;
        height: 40px;
        }
</style>
</head>
<body>
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
<div id="freeBoardWrite">
<h1 style="position: relative;
    margin-top: 20px;
    margin-bottom: 50px;
    padding-bottom: 50px;
    border-bottom: 1px solid #323232;
    ">ROK ARMY 글쓰기</h1>
   <!-- db에 어느 보드에서 작성됬는지 알려줘야해 -->
	<input type="text" style="display: none;" name="writer" readonly="readonly" value="${userInfo.nickName}">
	<span style="margin-left: 940px; border: 0; font: bold; font-size: 18px; margin-bottom: 10px">
	<!-- 닉네임 옆 경험치에따른 계급표 -->
		<td>
		<c:forEach var="member" items="${mList}">
			<c:if test="${userInfo.nickName eq member.nickName}">
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
					<c:when test="${member.userExp > 800 && member.userExp < 10000}">
						<img src="https://i.ibb.co/XpZfLv1/image.png" width="20px" height="20px">
					</c:when>
					<c:when test="${member.userExp >= 10000}">
						<img src="https://i.ibb.co/Yy9cYn3/image.png" width="20px" height="20px">
					</c:when>
				</c:choose>
			</c:if>
		</c:forEach>
	${userInfo.nickName}</span>
	<input class="table_input" type="text" placeholder="제목을 입력 하세요." 
	style="width: 1040px; height: 30px; margin-right: 280px; margin-top: 4px; position:relative; right: -180px;" 
	name="title" autofocus="autofocus" maxlength="50" value="${bList.title}"><br>
	<textarea class="table_input" rows="" cols="" style="width: 1040px; height: 600px; position:relative; right: -180px; resize: none;" name="content" placeholder="내용을 입력하세요.">${bList.content}</textarea> <br>
	<input type="file" style="display:none;" id="addImage" name="uploadFile" accept="image/*"/>
	<input type="button" class="imageUploaded" value="이미지 첨부" onclick="document.getElementById('addImage').click();" />
	<input type="text" style="display: none;" name="boardTitle" value="${bList.boardTitle}">
	<input type="hidden" value="${bList.number}" name="boardNumber"/>
	<input class="endWrite" type="button" id="updateBtn" value="수정 완료">	
</div>
</div>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
</body>
</html>