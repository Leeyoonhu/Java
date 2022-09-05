<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ROK ARMY</title>
<style type="text/css">
#content {
margin-top: 30px;
margin-bottom: 30px;
text-align: center;
width: 1200px;
height: 2080px;
}
aside {
background-image:URL('https://i.ibb.co/0Z5ZMXF/A.png'); 
background-size: cover;
background-repeat: repeat;
float: left;
display: block;
width: 300px;
}

header {
background-image:URL('https://i.ibb.co/0Z5ZMXF/A.png'); 
background-size: cover;
background-repeat: repeat
}
</style>
</head>
<body>
<!-- 로그인 이전 메인홈페이지 -->
<!-- 공용 헤더(수정한 후 src파일로 만들어서 모든곳에 돌려쓸예정)  -->
<!-- 헤더 백그라운드 -->
<header>
<h1 style="text-align: center; font-size: 4.5em;" >ROK ARMY</h1>
<div style="float: right">
	<a href="./joinForm.jsp">회원가입</a>
	&nbsp
	<a href="./loginForm.jsp">로그인</a>
	&nbsp 
</div><br><br>
<table>
<tr style="text-align: center">
	<th>
		<form action="./freeBoard.jsp" method="post">
			<input style="width: 300px; height: 40px; font-size: 1.2em; margin-left: 300px" type="submit" value="자유게시판">
		</form>
	</th>
	<th>
		<form action="" method="post">
			<input style="width: 300px; height: 40px; font-size: 1.2em; margin-left: 10px" type="submit" value="출석체크">
		</form>
	</th> 
	<th>
		<form action="" method="post">
			<input style="width: 300px; height: 40px; font-size: 1.2em; margin-left: 10px" type="submit" value="사진게시판">
		</form>
	</th> 
	<th>
		<form action="" method="post">
			<input style="width: 300px; height: 40px; font-size: 1.2em; margin-left: 10px" type="submit" value="질문게시판">
		</form>
	</th> 
	<th>
		<form action="" method="post">
			<input style="width: 300px; height: 40px; font-size: 1.2em; margin-left: 10px" type="submit" value="정보게시판">
		</form>
	</th> 
</tr>
</table>
<br>
</header>
<!-- 헤더 끝나는 부분 -->
<div id="content">
<aside>
	<table>
	<tr>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 40px; font-size: 1.2em; margin-top : 50px; margin-bottom : 100px; margin-left: 10px"  type="button" value="회원정보">
			</form>
		</th>
	</tr>
	<tr>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 40px; font-size: 1.2em; margin-bottom : 100px; margin-left: 10px" type="submit" value="정보게시판">
			</form>
		</th> 
	</tr>
	<tr>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 40px; font-size: 1.2em; margin-bottom : 100px; margin-left: 10px" type="submit" value="사진게시판">
			</form>
		</th> 
	</tr>
	<tr>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 40px; font-size: 1.2em; margin-bottom : 100px; margin-left: 10px" type="submit" value="질문게시판">
			</form>
		</th> 
	</tr>
	<tr>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 40px; font-size: 1.2em; margin-bottom : 100px; margin-left: 10px" type="submit" value="일기장">
			</form>
		</th> 
	</tr>
	<tr>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 40px; font-size: 1.2em; margin-bottom : 100px; margin-left: 10px" type="submit" value="편지함">
			</form>
		</th> 
	</tr>
	<tr>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 40px; font-size: 1.2em; margin-bottom : 100px; margin-left: 10px" type="submit" value="출석체크">
			</form>
		</th> 
	</tr>
	</table>
</aside>
</div>
</body>
</html>