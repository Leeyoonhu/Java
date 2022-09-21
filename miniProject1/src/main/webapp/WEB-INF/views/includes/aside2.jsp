<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어사이드2</title>
<style>
/* 로그인했을때 보이는 화면(군인x) */
    #nav{
		display : inline-block;
        width : 200px;
        height: 1400px;
        position: absolute;
        background-color: #343a40;
        color:white;
        font-size: 15px;
        
    }
    .btn1 {
  		font-size: 25px;
  		padding: 0; 
   		border: none; 
		background-color: transparent; 
		text-transform: uppercase;
	    letter-spacing: 5px;
	    color: white;
		font-weight: bold;
		overflow: hidden; 
		position: relative;
	}
	.btn1:hover {
		font-weight: bold;
/* 		background: white; */
		color: black;
/* 		border: 1px solid black; */
		transition: 0.4s;
		position: relative;
	}
	.asideMain{
		margin-top: 20px;
		color: white; 
		width: 200px; 
		height: 50px;
		font-size: 25px;
		border: 1px solid white;
  		border-radius:20px;
  		text-transform: uppercase;
  		font-weight: bold;
  		background: #343a40;
	}
	.asideMain:hover{
		font-weight: bold;
		color: black;
		border: 1px solid black;
		transition: 0.4s;
		position: relative;
		background: white;
	}
	.aside2btn {
		font-size: 0.8em;
  		border: 1px solid white;
  		border-radius:20px;
		background-color: transparent;
		text-transform: uppercase;
	    color: white;
		font-weight: bold;
		overflow: hidden; 
		position: relative;
	}
	.aside2btn:hover {
		font-weight: bold;
		background: white;
		color: black;
		border: 1px solid black;
		transition: 0.4s;
		position: relative;
	}
}   
</style>
</head>
<!-- 멤버정보가 세션의  ~와 같은경우-->
<body>
    <nav id ="nav">
        <div style="height: 185px; width: 200px; color: white">
        	<a href="../board/main" style="display: none" id="asideToMain"></a>
        	<a href="../board/myArticle" style="display: none" id="watchMyWrite"></a>
        	<a href="" style="display: none" id="watchMyComment"></a>
        	<a href="../members/logout" style="display: none" id="asideLogout"></a>
        	<a href="../board/calendar" style="display: none" id="asideCalendarForm"></a>
        	<button class="asideMain" onclick="document.getElementById('asideToMain').click()">ROK ARMY</button>
        	<div style="font-size: 1.2em; margin-left: 30px; margin-top: 8px">
				<c:choose>
					<c:when test="${userInfo.userExp == 0}">
						<img src="https://i.ibb.co/DYQFRjq/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 100}">
						<img src="https://i.ibb.co/Hnhvny8/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 200}">
						<img src="https://i.ibb.co/NKXW0C9/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 300}">
						<img src="https://i.ibb.co/HNzQDJT/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 400}">
						<img src="https://i.ibb.co/M6PwMcC/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 500}">
						<img src="https://i.ibb.co/QkmbTmL/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 600}">
						<img src="https://i.ibb.co/WHGk9tW/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 700}">
						<img src="https://i.ibb.co/4PJ9wVk/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp == 800}">
						<img src="https://i.ibb.co/M7SJqZW/image.png" width="18px" height="18px">
					</c:when>
					<c:when test="${userInfo.userExp > 800}">
						<img src="https://i.ibb.co/QrPKh3V/image.jpg" width="18px" height="18px">
					</c:when>
				</c:choose>
        	<c:out value="${userInfo.nickName}"></c:out>'s</div>
        	<div style="font-size: 1em; margin-left: 20px; margin-top: 8px; display: inline-block;">현재 경험치 : ${userInfo.userExp}</div>
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('watchMyWrite').click()">내글 보기</button>
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('watchMyComment').click()">내댓글 보기</button> 
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('asideLogout').click()">로그아웃</button>
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('asideCalendarForm').click()">출석체크</button>
        </div>
        <form action="../board/notice" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="전체게시판">
		</form>
		<form action="../board/free" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="자유게시판">
		</form>
		<form action="../board/screen" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="사진게시판">
		</form>
		<form action="../board/question" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="질문게시판">
		</form>
		<form action="../board/info" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="정보게시판">
		</form>
		<form action="../board/calendar" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="출석체크">
		</form>
        <br><br>
    </nav>
</body>
</html>