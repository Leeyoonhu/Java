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
background-image:URL('https://i.ibb.co/JvXcXyS/army.jpg'); 
background-size: cover;
background-repeat: repeat;
float: left;
display: block;
width: 300px;
}

header {
background-image:URL('https://i.ibb.co/JvXcXyS/army.jpg'); 
background-size: cover;
background-repeat: repeat
}
</style>
</head>
<body>
<!-- 로그인 이후 메인 홈페이지(군인이 아닐때) -->
<!-- 회원가입, 로그인쪽이 로그아웃으로 변경 -->
<header>
<h1 style="text-align: center; font-size: 4.5em;" >ROK ARMY</h1>
<div style="float: right">
	<a href="./logoutProcess.jsp">로그아웃</a>
	&nbsp 
</div><br><br>
<table>
<tr style="text-align: center">
	<th>
		<form action="./freeBoardForm.jsp" method="post">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 150px" type="submit" value="자유게시판">
		</form>
	</th>
	<th>
		<form action="" method="post">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="출석체크">
		</form>
	</th> 
	<th>
		<form action="" method="post">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="사진게시판">
		</form>
	</th> 
	<th>
		<form action="" method="post">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="질문게시판">
		</form>
	</th> 
	<th>
		<form action="" method="post">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="정보게시판">
		</form>
	</th> 
</tr>
</table>
<br>
</header>
<!-- 헤더 끝나는 부분 -->
<%

%>
<div id="content">
<aside>
	<table>
	<tr>
		<th></th>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="button" value="내 글관리">
			</form>
		</th>
	</tr>
	<tr>
		<th>
			<form action="" method="post">
				<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="내 댓글관리">
			</form>
		</th> 
	</tr>
	</table>
</aside>
</div>
</body>
</html>