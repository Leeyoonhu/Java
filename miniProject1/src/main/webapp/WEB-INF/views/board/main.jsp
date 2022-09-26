<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<meta charset="UTF-8">
<title>전지적 군사 시점</title>
<style type="text/css">
.big:hover {
    transform: translateY(-10px) scale(1.02);
}
</style>
</head>
<body>
<!-- 로그인 시 유저 정보담은 session = userInfo -->
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
<div class="mainForm">
<div class="mainFormContent"> <!-- 인기게시글, 최근 게시글 을 담을거 -->
<iframe width="800" height="400" src="https://www.youtube.com/embed/ZWJk8EvH5cc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
   <iframe style="margin-left : 50px; height : 400px; width : 600px;" src="popular" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
   
</div>
<br>
<br>
<br>
<div class="mainFormContent2">
<iframe width="800" height="400 " src="https://www.youtube.com/embed/H3uur6g_9CA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe style="margin-left : 50px; height : 400px; width : 600px;" src="current" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
</div>

<!-- start display screen -->
<br>
<br>
<table style=" margin-left:80px;">
	<tr><th colspan="3" style="text-align: center; font-size: 30px; font-weight: bold;">최근 사진 게시판</th></tr>
	<tr>
		<c:forEach var="currentScreen" items="${bList2}">
			<td class="big">
			    	<c:choose>
				      <c:when test="${currentScreen.imageFileName eq null || currentScreen.imageFilePath eq null}">
				        <a href="./view?number=${currentScreen.number}">
				        <img alt="" src="https://i.ibb.co/58bQ29v/noimage.jpg" width="323.33px" height="200px" style="border-bottom: 1px solid gray; text-align: center; overflow: hidden; color:black;" onerror="this.style.display='none'"> <br>
				        </a>
				      </c:when>
				      <c:otherwise>
				        <a href="./view?number=${currentScreen.number}">
				        <img alt="" src="/board/display?fileName=${currentScreen.imageFilePath}${currentScreen.imageFileName}" width="323.33px" height="200px" onerror="this.style.display='none'" style="border-bottom: 1px solid gray; overflow: hidden;  margin: 20px;"> <br>
				        </a>
				      </c:otherwise>
				    </c:choose>
			</td>
		</c:forEach>
	</tr>
	<tr style= "text-align: center;">
		<c:forEach var="currentScreen" items="${bList2}">
			<td>
				<a style="color: #ff4e1f; text-decoration: none; font-weight: bold; font-size: 20px;" href="./view?number=${currentScreen.number}">${currentScreen.title}</a>
			</td>
		</c:forEach>
	</tr>
</table>
<!-- end display screen -->

<!-- start ranking -->
<div style="display:inline-block;">
       <table style="border: 1px solid black; margin-left:1240px; margin-top:-260px; height:200px;">
          <tr><th colspan="1" style="background-color : #295298; z-index: 1; width:200px; height: 40px; color: white; text-align: center">랭킹 목록</th></tr>
             <c:forEach var="member" items="${mList}">
                <tr>
                   <td>
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
                  ${member.nickName}
               </td>
            </tr>
             </c:forEach>
       </table>
   </div>
<!-- end ranking -->


</div>

</div>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
</body>
</html>