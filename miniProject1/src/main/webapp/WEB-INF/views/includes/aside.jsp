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
}   
</style>
</head>
<body>
    <nav id ="nav">
        <form action="../members/login" method="get" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="로그인">
		</form>  
		<form action="../members/join" method="get" style=" margin-top: 10px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="회원가입">
		</form>
        <br><br>
        <form action="../board/notice" method="get" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="전체게시판">
		</form>
		<form action="../board/free" method="get" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="자유게시판">
		</form>
		<form action="../board/screen" method="get" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="사진게시판">
		</form>
		<form action="../board/question" method="get" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="질문게시판">
		</form>
		<form action="../board/info" method="get" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="submit" value="정보게시판">
		</form>
		<form action="" method="get" style=" margin-top: 50px">
			<input class="btn1" style="width: 180px; height: 40px; font-size: 1.0em; margin-left: 9px;" type="button" value="출석체크" onclick="alert('로그인 후 이용해주세요')">
		</form>
        <br><br>
    </nav>
</body>
</html>