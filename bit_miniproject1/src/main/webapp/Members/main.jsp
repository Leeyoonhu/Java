<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
#content {
margin-top: 30px;
margin-bottom: 30px;
text-align: center;
width: 1200px;
height: 2080px;
}
aside {
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
<!-- �α��� ���� ����Ȩ������ -->
<!-- ���� ��� -->
<!-- ��� ��׶��� (���� ����) -->
<header>
<h1 style="text-align: center; font-size: 4.5em;" >ROK ARMY</h1>
<div style="float: right">
	<a href="./joinForm.jsp">ȸ������</a>
	&nbsp
	<a href="./loginForm.jsp">�α���</a>
	&nbsp 
</div><br><br>
<table>
<tr style="text-align: center">
	<th>
		<form action="">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 150px" type="submit" value="�����Խ���">
		</form>
	</th>
	<th>
		<form action="">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="�⼮üũ">
		</form>
	</th> 
	<th>
		<form action="">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="�����Խ���">
		</form>
	</th> 
	<th>
		<form action="">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="�����Խ���">
		</form>
	</th> 
	<th>
		<form action="">
			<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="�����Խ���">
		</form>
	</th> 
</tr>
</table>
<br>
</header>
<!-- ��� ������ �κ� -->
<div id="content">
<aside>
	<table>
	<tr>
		<th>
			<form action="">
				<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="ȸ������">
			</form>
		</th>
	</tr>
	<tr>
		<th>
			<form action="">
				<input style="width: 300px; height: 50px; font-size: 1.2em; margin-left: 10px" type="submit" value="�����Խ���">
			</form>
		</th> 
	</tr>
	</table>
</aside>
</div>
</body>
</html>