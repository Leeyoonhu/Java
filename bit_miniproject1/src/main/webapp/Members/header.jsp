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
background-image:URL('https://i.ibb.co/L99MpYL/A.png'); 
background-size: cover;
background-repeat: repeat
}
  
.btn {
  font-size: 25px;
  padding: 10px 30px;
  border: 3px solid navy;
  background-color: transparent;
  color: navy;
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
  color: rgb(228, 49, 49);
  border : 3px solid rgb(228, 49, 49);
}

</style>
</head>
<body>
<!-- 로그인 이전 메인홈페이지 -->
<!-- 공용 헤더(수정한 후 src파일로 만들어서 모든곳에 돌려쓸예정)  -->
<!-- 헤더 백그라운드 -->
<header>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
<a class="navbar-brand" href="./joinForm.jsp" style="position:relative; right: -1700px; font-size: 0.8em">회원가입</a>
&nbsp;
<a class="navbar-brand" href="./loginForm.jsp" style="position:relative; right: -1700px; font-size: 0.8em">로그인</a>
</nav>
</header>
<!-- 헤더 끝나는 부분 -->
<br>
<br>
<br>
<div style="background-image: URL('https://i.ibb.co/L99MpYL/A.png'); background-size : cover; position: absolute; width: 1950px; height: 210px; top:4%"> 
<h1 style="text-align: center; font-size: 4.5em; position: relative; margin-top : 30px;" >전군시</h1> </div>

<br>
<table>
<tr style="text-align: center">
	<th>
		<form action="" method="post" style="position: relative; margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 500px" type="submit" value="자유게시판">
		</form>
	</th>
	<th>
		<form action="" method="post" style="position: relative; margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="출석체크">
		</form>
	</th> 
	<th>
		<form action="" method="post" style="position: relative; margin-top: 100px" >
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="사진게시판">
		</form>
	</th> 
	<th>
		<form action="" method="post" style="position: relative; margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="질문게시판">
		</form>
	</th> 
	<th>
		<form action="" method="post" style="position: relative; margin-top: 100px">
			<input class="btn" style="width: 180px; height: 50px; font-size: 1.0em; margin-left: 10px" type="submit" value="정보게시판">
		</form>
	</th> 
</tr>
</table>


</body>
</html>