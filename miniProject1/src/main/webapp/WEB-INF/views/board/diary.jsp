<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/resources/js/paging.js"></script>
<link rel="stylesheet" href="/resources/css/diary.css" />
<meta charset="UTF-8">
<title>일기쓰기</title>
<style type="text/css">
.pagination {
	justify-content : center;
}
</style>
</head>
<body class="bodybody">
    <div class="bookcover" style="margin-top:58px;">
      <div class="bookdot" style="width : 882px;">
        <div class="page">
            <div class="contam">
                <div class="column1">
                    <div class="row1_1">
                    </div>
                    <div class="row1_2 box">
                        <img class="profile" src="https://i.ibb.co/mGCzCtg/soldier.png" style="width:200px;">
                        <div class="intro" style="padding : 2px;">
                        <br>
                        	<h2 style="font-size : 20px; font-weight : bold; margin-top:-5px; margin-bottom:15px;">${userInfo.nickName}</h2>
                            -----------<br>	
                            오늘 아침은 
                            소세지 야채볶음에
                            미역국이었다.
                            <br>
                            -----------
                        </div>
                    </div>
                </div>
                <div class="column2">
                    <div class="row2_1">
                        <div class="title">소중한 나의 병영 일기</div>
                        <div class="item2"></div>
                    </div>
                    <div class="row2_2 box">
                        <div class="album-box">
                            <div class="forming" style="width:470px">
                                <div class="headerone">
                                    <table class="table talbe-striped" style="text-align : center; border: 1px solid #dddddd">
										<thead>
											<tr style="height: 30px">
												<th style="background-color : #c6e7f5; text-align:center; width:400px">제목</th>
												<th style="background-color : #c6e7f5; text-align:center; width:150px">등록일</th>
											</tr>
										</thead>
										<c:forEach var="diary" items="${dList}">
											<tr>
												<td style="font-weight: normal; border: 1px solid #eeeeee;">
												<a href='../board/diaryView?diaryNumber=${diary.diaryNumber}' style="text-decoration: none; color: black;">${diary.title}</a></td>
												<td style="font-weight: normal; border: 1px solid #eeeeee;"><fmt:formatDate value="${diary.regDate}" pattern="yyyy-MM-dd"/></td>
											</tr>
										</c:forEach>
									</table>
                                </div>
                   				<!-- start paging -->
								<ul class="pagination" style="list-style: none; text-align: center;">
									<c:if test="${pageMaker.prev}">
										<li class="page-item"><a class="page-link"
											href="${pageMaker.startPage-1}"> << </a></li>
									</c:if>
									<c:forEach var="num" begin="${pageMaker.startPage }"
										end="${pageMaker.endPage }">
										<li class="page-item ${pageMaker.cri.pageNum==num?"active":"" }"><a
											class="page-link" href="${num}">${num}</a></li>
									</c:forEach>
									<c:if test="${pageMaker.next}">
										<li class="page-item"><a class="page-link"
											href="${pageMaker.endPage+1}"> >> </a></li>
									</c:if>
								</ul>
								<form id='actionForm' action="/board/diary" method='get'>
									<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
									<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
								</form>
								<!-- end paging -->
                            </div>
                        </div>
                    </div>  
                </div>
              <div class="column3">
                <div class="sidebar">
                    <div onclick="location.href='../board/diary'" style="cursor:pointer; margin-top : 50px; height: 21px" class="side-menu">내 일기장</div>
                    <div onclick="location.href='../board/diaryWrite'" style="cursor:pointer; height: 21px" class="side-menu">일기 쓰기</div>
                </div>
              </div>       
        </div>
    </div>
</div>
</div>
</body>
</html>