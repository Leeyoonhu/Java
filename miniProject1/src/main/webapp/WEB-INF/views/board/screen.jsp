<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="/resources/css/thumbnail.css" />
    <link rel="stylesheet" href="/resources/css/butnn4.css">
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<style>
 	* { 
     font-family: 'Pretendard-Regular'; 
     src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff'); 
     font-weight: 400; 
     font-style: normal; 
 } 
 .but{
 text-align: center;
 }
 #screenBoardForm{
 margin-left : 310px;
 }
	
	</style>
    <title>사진 게시판</title>
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
    
    <!-- body -->
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
    
    <!-- content -->
    <div id="screenBoardForm">
      <div class="container gallery-container">
          <div class="but"><br><br><br><br><br><br>
            <h2 style="font-weight:bold;">전지적 군인 시점 사진게시판</h2>
              <!-- buttons -->
              <a href="../board/main" id="mainFormCheck" style="display: none"></a>
                <button class="custom-btn btn-12" onclick="document.getElementById('mainFormCheck').click();">
                <span>Click!</span><span>메인으로</span></button>
              <c:if test="${not empty userInfo.userId}">
                <a href="../board/write" id="boardWrite" style="display: none"></a>
                <button class="custom-btn btn-12" onclick="document.getElementById('boardWrite').click();" >
                <span>Click!</span><span>글쓰기</span></button>
              </c:if>
          </div>
          <!-- before forEach property -->
          <p class="page-description text-center"></p>
            <div class="tz-gallery">
              <div class="row">
              <%!int count = 0;%>
              <!-- need forEach -->
              <c:forEach var="board" items="${bList}">
                <div class="col-sm-6 col-md-4">
                  <div class="thumbnail">
                      <c:choose>
                        <c:when test="${board.imageFileName eq null || board.imageFilePath eq null}">
                          <a href="./view?number=${board.number}">
                          <img alt="" src="https://i.ibb.co/58bQ29v/noimage.jpg" width="323.33px" height="200px" style="border-bottom: 1px solid gray; text-align: center; overflow: hidden; cursor: pointer; color:black;" onerror="this.style.display='none'"> <br>
                          </a>
                        </c:when>
                        <c:otherwise>
                          <a href="./view?number=${board.number}">
                          <img alt="" src="/board/display?fileName=${board.imageFilePath}${board.imageFileName}" width="323.33px" height="200px" onerror="this.style.display='none'" style="border-bottom: 1px solid gray; overflow: hidden; cursor: pointer;"> <br>
                          </a>
                        </c:otherwise>
                      </c:choose>
                    
                    <div class="caption">
                      <h3><a href="./view?number=${board.number}" style="color: #ff4e1f; text-decoration: none; font-weight: bold; font-size: 15px;">${board.title}</a></h3>
                      <br>
                     <!-- start forEach for mList -->
                      <p><c:forEach var="member" items="${mList}">
					<c:if test="${board.writer eq member.nickName}">
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
		${board.writer}</p>
    <p><img src="https://i.ibb.co/fHKtYnX/image.jpg" width="20px" height="16px" style="margin-bottom:2px; margin-right:2px"/>${board.views}</p>
    <p><img alt="" src="https://i.ibb.co/2Y2ghNY/image.jpg" width="19px" height="18px"/> ${board.recommends}</p>
                    </div>
                  </div>
                </div>
              </c:forEach>
              <!-- end forEach -->
          </div>
        </div>
      </div>
      <!-- start paging -->
<ul class="pagination">
	<c:if test="${pageMaker.prev}">
		<li class="page-item"><a class="page-link"
			href="${pageMaker.startPage-1}">Previous</a></li>
	</c:if>
	<c:forEach var="num" begin="${pageMaker.startPage }"
		end="${pageMaker.endPage }">
		<li class="page-item ${pageMaker.cri.pageNum==num?"active":"" }"><a
			class="page-link" href="${num}">${num}</a></li>
	</c:forEach>
	<c:if test="${pageMaker.next}">
		<li class="page-item"><a class="page-link"
			href="${pageMaker.endPage+1 }">Next</a></li>
	</c:if>
</ul>
<form id='actionForm' action="/board/screen" method='get'>
	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
	<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
</form>
<!-- end paging -->
    </div>
    <!-- end content -->
    </div>
    <!-- end body -->
    <script>
      baguetteBox.run(".tz-gallery");
    </script>
    <%@ include file="../includes/footer.jsp" %>
  </body>
</html>
