<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일기쓰기</title>
 <link rel="stylesheet" href="/resources/css/diary.css" />
</head>
<body class="bodybody">
    <div class="bookcover">
      <div class="bookdot">
        <div class="page">
            <div class="contam">
                <div class="column1">
                    <div class="row1_1">
                    </div>
                    <div class="row1_2 box">
                        <img class="profile" src="https://i.ibb.co/mGCzCtg/soldier.png">
                        <div class="intro">
                        	<h2>${userInfo.nickName}</h2>
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
                            <div class="forming">
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
												<td>${diary.title}</td>
												<td><fmt:formatDate value="${diary.regDate}" pattern="yyyy-MM-dd"/></td>
											</tr>
										</c:forEach>
									</table>
                                </div>
                                
                            </div>
                        </div>
                    </div>  
                </div>
              <div class="column3">
                <div class="sidebar">
                    <div onclick="location.href='../board/diaryWrite';" style="cursor:pointer;" class="side-menu">일기 쓰기</div>
                    <div onclick="location.href='../board/diary';" style="cursor:pointer;" class="side-menu">내 일기장</div>
                </div>
              </div>       
        </div>
    </div>
</div>
</div>
</body>
</html>