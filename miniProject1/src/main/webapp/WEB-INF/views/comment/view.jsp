<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/butl.css">
<link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
<link href="/resources/css/view.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title>댓글 보기</title>
</head>
<body style="overflow-x:hidden;">
<div class="card bg-light" style="width: 600px">
	<br>
	<strong style="font-size: 1.1em; text-align: center;">댓글 (<c:out value="${fn:length(cList)}"></c:out>)</strong>
	<hr>
    <div class="card-body"> 
        <!-- try forEach -->
        <c:forEach var="comment" items="${cList}">
	        <div class="d-flex">
	            <div class="flex-shrink-0">
	                <!-- char image -->
	                <img class="rounded-circle" src="https://i.ibb.co/mGCzCtg/soldier.png" style="width: 50px; height: 50px;">
	            </div>
	            <div class="ms-4">
	            <!-- writer -->
	                <div>
	                	<c:forEach var="member" items="${mList}">
							<c:if test="${member.nickName eq comment.writer}">
								<c:choose>
									<c:when test="${member.userExp == 0}">
										<img src="https://i.ibb.co/DYQFRjq/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp == 100}">
										<img src="https://i.ibb.co/Hnhvny8/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp == 200}">
										<img src="https://i.ibb.co/NKXW0C9/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp == 300}">
										<img src="https://i.ibb.co/HNzQDJT/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp == 400}">
										<img src="https://i.ibb.co/M6PwMcC/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp == 500}">
										<img src="https://i.ibb.co/QkmbTmL/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp == 600}">
										<img src="https://i.ibb.co/WHGk9tW/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp == 700}">
										<img src="https://i.ibb.co/4PJ9wVk/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp == 800}">
										<img src="https://i.ibb.co/M7SJqZW/image.png" style="float:left" width="18px" height="18px">
									</c:when>
									<c:when test="${member.userExp > 800 && member.userExp < 10000}">
										<img src="https://i.ibb.co/XpZfLv1/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp >= 10000}">
										<img src="https://i.ibb.co/Yy9cYn3/image.png" style="float:left" width="20px" height="20px">
									</c:when>
								</c:choose>
							</c:if>
						</c:forEach>
						<strong style="float:left">${comment.writer}</strong>
						<!-- writer check -->
						<c:if test="${comment.writer eq bList.writer}">
							<img src="https://i.ibb.co/gZ2Pww5/icon-writer-42x15.png" style="width:42px;height:15px;margin-left:2px;margin-bottom:2px" border="0">
						</c:if>
						<br>
						${comment.comment}
	                </div>
	            </div>
	        </div>
	        <br>
        </c:forEach>
        <!-- end forEach -->
    </div>
</div>
</body>
</html>