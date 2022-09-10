<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#freeBoardWrite {
	display: inline-block;
	float: right;
	width: 1400px;
	height: 1400px;
	margin-top: 200px;
	text-align: center;
}
</style>
</head>
<body>
<!-- multipart/form-data를 상요해 파일 정보를 넘겨서 업로딩 할 예정 -->
<!-- 반드시 관련 파일들 import 해주어야 함, javax.servel-->
<%
String writer = (String)session.getAttribute("nickName");
%>
<jsp:include page="./header2.jsp"></jsp:include>
<div id="content">
<div id="freeBoardWrite">
<form action="./boardwrite.do?" method="post" enctype="multipart/form-data">
 		<h2 style="float: left; margin-left: 300px">제목 : </h2><input type="text" style="width: 700px; height: 30px; margin-right: 280px; margin-top: 4px" name="title" autofocus="autofocus" maxlength="50">
 		<input type="text" style="display: none;" name="writer" readonly="readonly" value=<%=writer%>>
 		<span style="margin-left: 600px; margin-bottom: 5px; border: 0; font: bold; font-size: 16px;"><%=writer%></span>
 		<textarea rows="" cols="" style="width: 1040px; height: 600px" name="content" placeholder="글꼴 | 크기"></textarea> <br>
 		<input type="button" style="margin-left: 80px; margin-top: 10px" value="이미지 첨부" onclick="document.getElementById('imageFileName').click();" />
		<input type="file" style="display:none;" id="imageFileName" name="imageFileName" accept="image/*"/>
<!-- 	<input type="button" style="margin-left: 10px; margin-top: 10px" value="파일 첨부" onclick="document.getElementById('fileName').click();" />
		<input type="file" style="display:none;"id="fileName" name="fileName"> <br> -->
		<input style="margin-left: 750px; width: 100px; height: 30px" type="submit" value="작성 완료">
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>