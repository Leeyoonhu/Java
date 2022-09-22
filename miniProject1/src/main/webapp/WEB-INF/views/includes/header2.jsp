<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/butl.css">
<meta charset="UTF-8">
<title>ROK ARMY</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/resources/js/attend.js"></script>
<style type="text/css">

* {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}

#content {
width: 1650px;
height: 1400px;
position: static;
}
#content2 {
width: 1650px;
height: 1600px;
position: static;
}


.goToMain {
	width: 120px; 
	float: right;
	margin-right: 20px; 
	margin-bottom: 10px; 
	line-height: 30px; 
	border-radius: 3px; 
	box-sizing: border-box; 
	border: 1px solid #303030;
	color: gray;
}

.goToMain:hover {
	text-transform: uppercase;
    transition: 0.6s;
    color: black;
    text-align: center;
    width: 120px;
    background: white;
}
.writeBoard {
		margin-bottom: 10px; 
		float: right; 
		background: #444; 
		border: 1px solid #303030; 
		color: #fff;  
		border-radius: 3px; 
		box-sizing: border-box; 
		line-height: 30px; 
		text-align: center; 
		margin-right:20px; 
		width: 120px
}
.writeBoard:hover {
		text-transform: uppercase;
	    transition: 0.4s;
	    background: black;
	    color: white;
	    text-align: center;  
}
.endWrite {
	display:inline-block; width: 120px; height: 40px; background: #444;
	margin-left: 20px;
    border: 1px solid #303030;
    color: #fff; border-radius: 3px;
    box-sizing: border-box; transition: .2s; line-height: 30px;
    text-align: center; 
    display: inline-block;
}
.endWrite:hover {
	text-transform: uppercase;
    transition: 0.4s;
    background: black;
    color: white;
    text-align: center;  
}
.imageUploaded {
	margin-left: 700px; display: inline-block; width: 120px; height: 40px; line-height: 30px; border: 1px solid #303030; border-radius: 3px;
}
.imageUploaded:hover {
	text-transform: uppercase;
    transition: 0.6s;
    color: black;
    text-align: center;
    width: 120px;
    background: white;
}
.boardElement:hover {
	background: #eeeeee;
	transition: 0.4s;
}
.loginasd{
    	   display: inline-block;
		   float: right;
		   width: 1400px;
		   height: 1200px;
		   margin-top: 200px;
		   text-align: center;
    }
.bodywash {
    margin: 0;
      padding-top: 130px;
      padding-bottom: 40px;
      font-family: "Nanum Gothic", arial, helvetica, sans-serif;
      background-repeat: no-repeat;
}

.card {
    margin: 0 auto; /* Added */
    float: none; /* Added */
    margin-bottom: 10px; /* Added */
}

#btn-Yes{
    background-color: #e4932b;
    border: none;
}

.form-signin .form-control {
      position: relative;
      height: auto;
      -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
         box-sizing: border-box;
      padding: 10px;
      font-size: 16px;
}
.card-title{
    margin-left: 30px;
}
.links{
    text-align: center;
    margin-bottom: 10px;
    color : black;
}
.text2{
    color : blue;
}
 .checks{
    	color : red;
    }
.mainForm{
	display: inline-block;
	width: 1450px;
	height: 1200px;
	margin-top: 200px;
	float: right;
}
.mainFormContent {
	display: inline-block;
	text-align: center;
	width: 1560px;
	margin-top : -190px;
	
}
.mainFormContent2 {
	display: inline-block;
	text-align: center;
	width: 1300px;
	height: 400px;
	margin-left:270px;
}
</style>
</head>
<body>
<!-- 로그인 이전 메인홈페이지 -->
<!-- 공용 헤더(수정한 후 src파일로 만들어서 모든곳에 돌려쓸예정)  -->
<!-- 헤더 백그라운드 -->

<!-- 헤더 끝나는 부분 -->
<div style="background-color: #343a40; position: static; width: 1950px; height: 290px;">
<a href="../members/logout"style="position:relative; color:white; right: -1700px; font-size: 0.8em; top :4%; text-decoration: none">로그아웃</a>
<a href="../board/main" style="display: none" id="jungunsi"></a>
<h1 style="text-align: center; font-size: 3.5em; font-weight:bold; position: relative; margin-top : 30px; color:white; cursor: pointer;" onclick="document.getElementById('jungunsi').click()">
<img alt="" src="https://i.ibb.co/mGCzCtg/soldier.png" width="120px" height="120px">
전지적 군인 시점</h1>
<br>
<table>
<tr style="text-align: center">
	<th>
		<form action="../board/free" method="get" style="position: relative;">
			<input class="bts" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 500px" type="submit" value="자유게시판">
		</form>
	</th>
	<th>
		<form action="../board/screen" method="get" style="position: relative;" >
			<input class="bts" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="사진게시판">
		</form>
	</th> 
	<th>
		<form action="../board/question" method="get" style="position: relative;">
			<input class="bts" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="질문게시판">
		</form>
	</th> 
	<th>
		<form action="../board/info" method="get" style="position: relative;">
			<input class="bts" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="정보게시판">
		</form>
	</th>  
	<th>
		<form style="position: relative;">
			<input type="hidden" value="${userInfo.attDate}" id="attDate">
			<input type="hidden" value="${userInfo.userId}" id="loginedId">
			<input id="attend" class="bts" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="button" value="출석체크">
		</form>
	</th> 
</tr>
</table>
</div>

</body>
</html>