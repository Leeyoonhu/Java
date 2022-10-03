<%@page import="java.util.concurrent.ExecutionException"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.*, java.sql.*" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기</title>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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
  background-color: rgb(253, 198, 152);
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
}

.buttonmn:hover {
  background-color: rgb(255, 230, 210);
  box-shadow: 0px 15px 20px rgb(255, 230, 210);
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
        <c:forEach var="member" items="${mList}">
         <c:if test="${member.nickName eq bList.writer}">
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
       
    
<!-- 추천 버튼 -->
<c:if test="${not empty userInfo.userId}">
	<form action="./plusreco" method="post">
	   <!-- 추천을 누르면 현재 게시글 정보의 추천이 process로 가서 1 올라서 다시 일로와야해 -->
	   <input type="hidden" name ="number" value="${bList.number}" id="boardNumber" >
	   <input style="width: 90px; height: 55px;border: 1px solid #ccc;border-radius: 5px;box-sizing: border-box;background: url(https://i.ibb.co/vVmM42G/image.jpg) no-repeat;background-position:center;" type="submit" value="">
	</form> <br>
</c:if>
	<a href="../board/${boardTitle}" id="boardForm" style="display: none;"></a>

<div class="wrappp">
<!-- 목록 버튼 -->
<button style="font-size:13px; font-weight: bold;"class="buttonmn" onclick="document.getElementById('boardForm').click();">목록</button>
<!-- 글 작성자와 현재 접속자가 동일하면 글 수정 버튼 -->
<c:if test="${bList.writer eq userInfo.nickName}">
   <a href="../board/update?number=${bList.number}" id="boardUpdate" style="display: none;"></a>
   <button style="font-size:13px; font-weight: bold;" class="buttonmn" onclick="document.getElementById('boardUpdate').click();">글 수정</button>
   <input id="boardTitle" value="${boardTitle}" type="text" style="display: none">
   <button style="font-size:13px; font-weight: bold;" class="buttonmn" id="deleteBoard">글 삭제</button>
</c:if>
</div>
<hr>


<!-- start comment -->
<div class="card bg-light" style="width: 1000px">
	<br>
	<strong style="font-size: 1.1em">댓글 (<c:out value="${fn:length(cList)}"></c:out>)</strong>
	<hr>
	<c:if test="${not empty userInfo.userId}">
	<input type="button" id="addComment" style="font: 10px; font-weight: bold; background: #444; width: 80px; color: #fff; border: 1px solid #303030; margin-left: 900px; border-radius: 3px;" value="등록">
	<input type="hidden" value="${userInfo.nickName}" name="commentWriter">
    </c:if>
    <div class="card-body"> 
        <!-- write comment -->
        <c:if test="${not empty userInfo.userId}">
	        <form action="mb-4">
	            <textarea class="form-control" name="comment" id="" cols="30" rows="3" style="height: 64px; resize: none;"placeholder="명예훼손, 개인정보 유출, 분쟁 유발, 허위사실 유포 등의 이용약관에 의한 제재는 영창으로 갑니다." maxlength="50"></textarea>
	        </form>
        </c:if>
        <!-- end write comment -->
        <!-- try forEach -->
        <c:forEach var="comment" items="${cList}">
        	<br>
	        <div class="d-flex">
	            <div class="flex-shrink-0">
	                <!-- char image -->
	                <img class="rounded-circle" src="https://i.ibb.co/mGCzCtg/soldier.png" style="width: 50px; height: 50px;">
	            </div>
	            <div>
	            <!-- writer -->
	                <div>
	                	<c:forEach var="member" items="${mList}">
							<c:if test="${member.nickName eq comment.writer}">
								<c:choose>
									<c:when test="${member.userExp == 0}">
										<img src="https://i.ibb.co/DYQFRjq/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp == 100}">
										<img src="https://i.ibb.co/Hnhvny8/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp == 200}">
										<img src="https://i.ibb.co/NKXW0C9/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp == 300}">
										<img src="https://i.ibb.co/HNzQDJT/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp == 400}">
										<img src="https://i.ibb.co/M6PwMcC/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp == 500}">
										<img src="https://i.ibb.co/QkmbTmL/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp == 600}">
										<img src="https://i.ibb.co/WHGk9tW/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp == 700}">
										<img src="https://i.ibb.co/4PJ9wVk/image.png" style="float:left" width="20px" height="20px">
									</c:when>
									<c:when test="${member.userExp == 800}">
										<img src="https://i.ibb.co/M7SJqZW/image.png" style="float:left" width="20px" height="20px">
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
							<img src="https://i.ibb.co/gZ2Pww5/icon-writer-42x15.png" style="width:42px;height:15px;margin-left:2px;margin-bottom:2px; float:left; margin-top: 5px; margin-left: 5px;" border="0">
						</c:if>
						<!-- delete check -->
						<c:if test="${comment.writer eq userInfo.nickName}">
							<input type="text" value="${comment.comNumber}" style="display: none;" name="deletecNumber"></input>
							<img src="https://i.ibb.co/jM9Tyxf/image.png" name="deleteImage" style="cursor: pointer; float:left; margin-top: 5px; margin-left: 5px;">
						</c:if>
						<br>
						<div style="float:left">${comment.comment}</div> 
	                </div>
	            </div>
	        </div>
        </c:forEach>
        <!-- end forEach -->
    </div>
</div>
<!-- end comment -->
</div>
</div>
<%@ include file="../includes/footer.jsp" %> 
</body>
<script type="text/javascript" src="/resources/js/delete.js"></script>
<script type="text/javascript" src="/resources/js/addComment.js"></script>
<script type="text/javascript" src="/resources/js/view.js"></script>
<script type="text/javascript" src="/resources/js/delComment.js">
</script>
</html>