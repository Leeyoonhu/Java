<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어사이드</title>
<style>
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
 		padding: 10px 30px;
  		border: 1px solid white;
  		border-radius:20px;
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
		background: white;
		color: black;
		border: 1px solid black;
		transition: 0.4s;
		position: relative;
	}
}   
</style>
</head>
<body>
    <nav id ="nav">
        <form action="./loginForm.jsp" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="로그인">
		</form>  
		<form action="./joinForm.jsp" method="post" style=" margin-top: 10px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="회원가입">
		</form>
        <br><br>
        <form action="./noticeboardForm.jsp" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="전체게시판">
		</form>
		<form action="./freeBoardForm.jsp" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="자유게시판">
		</form>
		<form action="./screenBoardForm.jsp" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="사진게시판">
		</form>
		<form action="./questionBoardForm.jsp" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="질문게시판">
		</form>
		<form action="./informationBoardForm.jsp" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="정보게시판">
		</form>
		<form action="" method="post" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="button" value="출석체크" onclick="alert('로그인 후 이용해주세요')">
		</form>
        <br><br>
    </nav>
</body>
</html>