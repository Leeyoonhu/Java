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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/resources/js/delete.js"></script>
<script type="text/javascript" src="/resources/js/delComment.js"></script>
<script type="text/javascript" src="/resources/js/addComment.js"></script>
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
<form action="./plusreco" method="post">
   <!-- 추천을 누르면 현재 게시글 정보의 추천이 process로 가서 1 올라서 다시 일로와야해 -->
   <input type="hidden" name ="number" value="${bList.number}" id="boardNumber" >
   <input style="width: 90px; height: 55px;border: 1px solid #ccc;border-radius: 5px;box-sizing: border-box;background: url(https://i.ibb.co/vVmM42G/image.jpg) no-repeat;background-position:center;" type="submit" value="">
</form> <br>
<a href="../board/${boardTitle}" id="boardForm" style="display: none;"></a>

<div class="wrappp">
<!-- 목록 버튼 -->
<button class="buttonmn" onclick="document.getElementById('boardForm').click();">목록</button>
<!-- 글 작성자와 현재 접속자가 동일하면 글 수정 버튼 -->
<c:if test="${bList.writer eq userInfo.nickName}">
   <a href="../board/update?number=${bList.number}" id="boardUpdate" style="display: none;"></a>
   <button class="buttonmn" onclick="document.getElementById('boardUpdate').click();">글 수정</button>
   <input id="boardTitle" value="${boardTitle}" type="text" style="display: none">
   <button class="buttonmn" id="deleteBoard">글 삭제</button>
</c:if>
</div>
<hr>

<!-- 댓글 보여주기(삭제도 가능) -->
<div style="height: auto">
<img alt="" src="https://i.ibb.co/C96m34C/image.jpg" width="17" height="15" style="margin-bottom: 5px; margin-right:2px" > <strong style="font-size: 1.1em">
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
</div>


<!-- 댓글 달기 (로그인 된 사람만 보이게) -->
<c:if test="${not empty userInfo.userId}">
	<div style="height: auto">
	   <form method = "post"> 
	      <input type="button" style="font: 13px; font-weight: bold; float: right; height: 85px; width: 80px; background: #444;
	       border: 1px solid #303030;
	       color: #fff; border-radius: 3px;
	       box-sizing: border-box;  margin-right: 230px;" id="addComment" value="등록">
	      <textarea style="border: 1px solid #abadb3; height: 85px; margin-right: 20px; float: right; resize: none;"
	      	placeholder="명예훼손, 개인정보 유출, 분쟁 유발, 허위사실 유포 등의 이용약관에 의한 제재는 영창으로 갑니다." rows="" cols="100" name="comment"></textarea>
	      	<strong style="float: right; margin-right: 20px; margin-top: 30px; font-size: 1.2em">
		      	<c:forEach var="member" items="${mList}">
		         	<c:if test="${member.nickName eq userInfo.nickName}">
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
			      <input type="hidden" value="${userInfo.nickName}" name="commentWriter">
		      	${userInfo.nickName}
	      		</strong>
   			</form>
   		</div>
	</c:if>	
</div>
</div>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
</body>
</html>