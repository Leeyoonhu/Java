<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<meta charset="UTF-8">
<title>ROK ARMY</title>
<style type="text/css">
#content {
width: 1650px;
height: 1400px;
}
#content2 {
width: 1650px;
height: 1600px;
}
.btn {
  font-size: 25px;
  padding: 10px 30px;
  border: 3px solid white;
  background-color: transparent;
  color: white;
  text-transform: uppercase;
  letter-spacing: 5px;
  font-weight: bold;
  position: relative;
  transition: all 0.4s;
  overflow: hidden; 
}

.btn:focus {
  outline: none;
}

.btn::before {
  content: "";
  position: absolute;
  height: 100%;
  width: 100%;
  background-color: gold;
  top: 100%;
  left: 0;
  transition: all 0.4s;
  z-index: 0;
}

.btn:hover {
  color: rgb(170, 240, 170);
  border : 3px solid rgb(170, 240, 170);
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
</style>
</head>
<body>
<!-- 로그인 이전 메인홈페이지 -->
<!-- 공용 헤더(수정한 후 src파일로 만들어서 모든곳에 돌려쓸예정)  -->
<!-- 헤더 백그라운드 -->

<!-- 헤더 끝나는 부분 -->
<div style="background-color: #343a40; position: static; width: 1950px; height: 290px;"> 
<a href="./logoutProcess.jsp"style="position:relative; color:white; right: -1700px; font-size: 0.8em; top :4%; text-decoration: none">로그아웃</a>
<%if(session.getAttribute("userJob") == null){%>
<a href="./mainForm.jsp" style="display: none" id="jungunsi2"></a>
<%} %>
<%if("soldier".equals((String)session.getAttribute("userJob"))) {%>
<a href="./mainForm3.jsp" style="display: none" id="jungunsi2"></a>
<%}else if(session.getAttribute("userJob") != null) { %>
<a href="./mainForm2.jsp" 	style="display: none" id="jungunsi2"></a>
<%} %>
<h1 style="text-align: center; font-size: 4.5em; position: relative; margin-top : 30px; color: white;" onclick="document.getElementById('jungunsi2').click()">
<img alt="" src="https://i.ibb.co/6vRsqtw/Kakao-Talk-20220915-202814741.png" width="120px" height="120px">
ROK ARMY</h1> 

<br>
<table>
<tr style="text-align: center">
	<th>
		<form action="./freeBoardForm.jsp" method="post" style="position: relative;">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 500px" type="submit" value="자유게시판">
		</form>
	</th>
	<th>
		<form action="./screenBoardForm.jsp" method="post" style="position: relative;" >
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="사진게시판">
		</form>
	</th> 
	<th>
		<form action="./questionBoardForm.jsp" method="post" style="position: relative;">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="질문게시판">
		</form>
	</th> 
	<th>
		<form action="./informationBoardForm.jsp" method="post" style="position: relative;">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="정보게시판">
		</form>
	</th> 
	<th>
		<form action="./calendarForm.jsp" method="post" style="position: relative;">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="달력">
		</form>
	</th> 
</tr>
</table>
</div>

</body>
</html>