<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어사이드3</title>
<style>
/* 로그인했을때 보이는 화면(군인) */
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
<%
String nickName = (String)session.getAttribute("nickName"); 
%>
<jsp:include page="./asideProcess.jsp">
	<jsp:param value="<%=nickName%>" name="nickName"/>
</jsp:include>
<body>
    <nav id ="nav">
        <div style="height: 185px; width: 200px; color: white">
        	<a href="./mainForm2.jsp" style="display: none" id="asideToMain"></a>
        	<a href="./myArticleForm.jsp" style="display: none" id="watchMyWrite"></a>
        	<a href="" style="display: none" id="watchMyComment"></a>
        	<a href="./logoutProcess.jsp" style="display: none" id="asideLogout"></a>
        	<a href="./calendarForm.jsp" style="display: none" id="asideCalendarForm"></a>
        	<button class="asideMain" onclick="document.getElementById('asideToMain').click()">ROK ARMY</button>
        	<div style="font-size: 1.2em; margin-left: 30px; margin-top: 8px"><%=nickName%>'s</div>
        	<div style="font-size: 1em; margin-left: 20px; margin-top: 8px; display: inline-block;">현재 경험치 : ${userExp}</div>
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('watchMyWrite').click()">내글 보기</button>
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('watchMyComment').click()">내댓글 보기</button> 
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('asideLogout').click()">로그아웃</button>
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('asideCalendarForm').click()">출석체크</button>
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onClick="window.open('./diaryForm.jsp', '', 'width=1000, height=700'); return false;">일기 쓰기</button>
        	<button class="aside2btn" style="width: 80px; height: 25px; margin-left: 10px; margin-top: 5px" onclick="document.getElementById('diaryBoardForm').click()">내 일기장</button>
        </div>
        <form action="./noticeboardForm.jsp?pages=1" method="post" style=" margin-top: 100px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-top: 30px; margin-left: 9px;" type="submit" value="전체게시판">
		</form>
		<form action="./freeBoardForm.jsp?pages=1" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-top: 30px; margin-left: 9px;" type="submit" value="자유게시판">
		</form>
		<form action="./screenBoardForm.jsp?pages=1" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-top: 30px; margin-left: 9px;" type="submit" value="사진게시판">
		</form>
		<form action="./questionBoardForm.jsp?pages=1" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-top: 30px; margin-left: 9px;" type="submit" value="질문게시판">
		</form>
		<form action="./informationBoardForm.jsp?pages=1" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-top: 30px; margin-left: 9px;" type="submit" value="정보게시판">
		</form>
		<form action="./calendarForm.jsp" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-top: 30px; margin-left: 9px;" type="submit" value="출석체크">
		</form>
        <br><br>
    </nav>
</body>
</html>