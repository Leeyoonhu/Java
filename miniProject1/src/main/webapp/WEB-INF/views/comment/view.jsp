<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 보기</title>
</head>
<body>
<img src="https://i.ibb.co/C96m34C/image.jpg" width="20" height="20" style="margin-bottom: 5px; margin-right:2px" > <strong style="font-size: 1.1em;">
댓글 (<c:out value="${fn:length(cList)}"></c:out>)
</strong><br>
<hr>
<c:forEach var="comment" items="${cList}">
<div style="margin-left: 20px">
<strong style="font-size: 1em">
		<c:forEach var="member" items="${mList}">
			<c:if test="${member.nickName eq comment.writer}">
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
		</c:forEach>
${comment.writer}</strong>
<!-- 작성자 표시 -->
	<c:if test="${comment.writer eq bList.writer}">
		<img src="https://i.ibb.co/gZ2Pww5/icon-writer-42x15.png" style="width:42px;height:15px;margin-left:2px;margin-bottom:2px" border="0">
	</c:if>
<span style="color: gray">(${comment.regDate})</span>
<!-- 삭제 버튼 표시 -->
	<c:if test="${comment.writer eq userInfo.nickName}">
		<img src="https://i.ibb.co/jM9Tyxf/image.png" style="cursor: pointer;" id="deleteImage">
		<input type="text" value="${comment.comNumber}" style="display: none" id="deletecNumber"></input>
	</c:if>
<br>
${comment.comment}
</div>
<hr>
</c:forEach>
</body>
</html>