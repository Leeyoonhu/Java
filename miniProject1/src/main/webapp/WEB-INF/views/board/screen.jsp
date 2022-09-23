<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="/resources/css/thumbnail.css" />
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>사진 게시판</title>

    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Droid+Sans:400,700"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.css"
    />
  </head>
  <body>
    <%-- header --%>
    <c:choose>
      <c:when test="${empty userInfo.userId}">
        <%@ include file="../includes/header.jsp" %>
      </c:when>
      <c:otherwise>
        <%@ include file="../includes/header2.jsp" %>
      </c:otherwise>
    </c:choose>
    <%-- content --%>
    <div id="content">
    <%-- aside --%>
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
    <div id="screenBoardForm">
      <div class="container gallery-container">
          <div class="but">
            <h1>전지적 군인 시점 사진게시판</h1>
              <%-- buttons --%>
              <a href="../board/main" id="mainFormCheck" style="display: none"></a>
                <button class="custom-btn btn-12" onclick="document.getElementById('mainFormCheck').click();">
                <span>Click!</span><span>메인으로</span></button>
              <c:if test="${not empty userInfo.userId}">
                <a href="../board/write" id="boardWrite" style="display: none"></a>
                <button class="custom-btn btn-12" onclick="document.getElementById('boardWrite').click();" >
                <span>Click!</span><span>글쓰기</span></button>
              </c:if>
          </div>
          <%-- 반복되기 전 원래 속성 --%>
          <p class="page-description text-center"></p>
            <div class="tz-gallery">
              <div class="row">
              <%!int count = 0;%>
              <%-- 반복 될 내용 --%>
              <c:forEach var="item" items="${bList}">
                <div class="col-sm-6 col-md-4">
                  <div class="thumbnail">
                      <c:choose>
                        <c:when test="${item.imageFileName eq null || item.imageFilePath eq null}">
                          <img alt="" src="https://i.ibb.co/58bQ29v/noimage.jpg" style="border-bottom: 1px solid gray; width: 198px; height:115px; text-align: center; overflow: hidden; cursor: pointer;" onerror="this.style.display='none'" onclick="document.getElementById('goScreenView').click()"> <br>
                          <a href="./view?number=${item.number}" id="goScreenView" style="display: none;"></a>
                        </c:when>
                        <c:otherwise>
                          <img alt="" src="/board/display?fileName=${item.imageFilePath}${item.imageFileName}" width="198px" height="200px" onerror="this.style.display='none'" onclick="document.getElementById('goScreenView2').click()" style="border-bottom: 1px solid gray; overflow: hidden; cursor: pointer;"> <br>
                          <a href="./view?number=${item.number}" id="goScreenView2" style="display: none;"></a>
                        </c:otherwise>
                      </c:choose>
                    </a>
                    <div class="caption">
                      <h3><a href="./view?number=${item.number}">${item.title}</a></h3>
                      <%-- 
                      title 옆에 댓글 보여주기, 필요시 a태그 안에 넣을것
                      <c:forEach var="item2" items="${items2}">
                      <c:if test="${item.number eq item2.number}">
                        <%count++;%>
                      </c:if>
                    </c:forEach>
                    <%if(count != 0){ %>
                    <a href="./searchCommentProcess.jsp?number=${item.number}&writer=${item.writer}" target="_blank" onClick="window.open(this.href, '', 'width=600, height=400'); return false;" style="text-decoration: none; color: red;">[<%=count%>]</a>
                    <%} count = 0; %> --%>
                      <br>
                      <%-- 글내용위치에 작성자, 조회, 추천 --%>
                      <p><c:forEach var="member" items="${mList}">
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
		${item.writer}</p>
    <img src="https://i.ibb.co/fHKtYnX/image.jpg" width="20px" height="16px" style="margin-bottom:2px; margin-right:2px"/>${item.views}</p>
    <img alt="" src="https://i.ibb.co/2Y2ghNY/image.jpg" width="19px" height="18px"/> ${item.recommends}</p>
                    </div>
                  </div>
                </div>
              </c:forEach>
              <!-- 반복 끝 -->
          </div>
        </div>
      </div>
    </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.js"></script>
    <script>
      baguetteBox.run(".tz-gallery");
    </script>
    <%@ include file="../includes/footer.jsp" %>
  </body>
</html>
