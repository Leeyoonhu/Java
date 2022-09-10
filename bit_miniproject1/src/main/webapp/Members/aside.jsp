<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어사이드</title>
<style>
    #nav{
		/* float: left; */
		display : inline-block;
        width : 200px;
        height: auto;
        position: relative;
        bottom : 0;
        left: 0;
        background-color: #343a40;
        color:white;
        padding-top: 0px;
        font-size: 15px;
        
    }
    #navDiv {
        border-radius: 20px;
        width : 100%;
        height : 200px;
        border: 1px solid white;
        text-align: center;
        vertical-align:auto;
        color : white;
        font-size : 40px;
    }
    #navSpan {
        border-radius: 20px;
        width : 100%;
        text-align: center;
        vertical-align:auto;
        color : white;
        font-size : 15px;
    }
    .btn {
  		font-size: 25px;
 		padding: 10px 30px;
  		border: 1px solid white;
  		border-radius:20px;
		background-color: transparent;
		color: white;
		text-transform: uppercase;
	    letter-spacing: 5px;
		font-weight: bold;
		position: relative;
	    transition: all 0.4s;
		overflow: hidden; 
	}
	   
</style>
</head>
<body>
    <nav id ="nav">
        <form action="" method="post" style=" margin-top: 50px">
			<input class="btn" style="width: 180px; height: 30px; font-size: 1.0em; margin-left: 9px; type="submit"; value="R.A.로그인">
		</form>  
		<form action="" method="post" style=" margin-top: 10px">
			<input class="btn" style="width: 180px; height: 30px; font-size: 1.0em; margin-left: 9px; type="submit"; value="회원가입">
		</form>  
		<form action="" method="post" style=" margin-top: 10px">
			<input class="btn" style="width: 180px; height: 30px; font-size: 1.0em; margin-left: 9px; type="submit"; value="ID/PW찾기">
		</form>  
        <br><br><br><br><br>
        <form action="" method="post" style=" margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 9px; type="submit"; value="전체게시판">
		</form>
		<form action="" method="post" style=" margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 9px; type="submit" value="자유게시판">
		</form>
		<form action="" method="post" style=" margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 9px; type="submit" value="정보게시판">
		</form>
		<form action="" method="post" style=" margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 9px; type="submit" value="사진게시판">
		</form>
		<form action="" method="post" style=" margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 9px; type="submit" value="질문게시판">
		</form>
		<form action="" method="post" style=" margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 9px; type="submit" value="일기장">
		</form>
		<form action="" method="post" style=" margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 9px; type="submit" value="편지함">
		</form>
		<form action="" method="post" style=" margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 9px; type="submit" value="출석체크">
		</form>
        <br><br><br><br><br>
        
        <span id="navSpan">현재 접속자 리스트( 명)</span>
        <div id="navDiv"></div>
        <div id="navDiv"></div>
    </nav>

</body>
</html>