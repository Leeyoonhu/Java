<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#freeBoardUpdate {
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
<%
request.setCharacterEncoding("utf-8");
String title = (String)session.getAttribute("title");
String content = (String)session.getAttribute("content");
String imageFileName = (String)session.getAttribute("imageFileName");
Integer number = (Integer)session.getAttribute("number");
request.setAttribute("number", number);
request.setAttribute("imageFileName", imageFileName);
/* String fileName = null; */
String path = request.getServletContext().getContextPath()+"/upload/";
String writer = (String)session.getAttribute("nickName");
String boardTitle = "freeBoard";
%>
<jsp:include page="./header2.jsp"></jsp:include>
<div id="content">
<div id="freeBoardUpdate">
<form action="./boardUpdate.do?number=${number}" method="post" enctype="multipart/form-data">
 		<h2 style="float: left; margin-left: 300px">제목 : </h2><input type="text" style="width: 700px; height: 30px; margin-right: 280px; margin-top: 4px" name="title" autofocus="autofocus" maxlength="50" value="<%=title %>">
 		<input type="text" style="display: none;" name="writer" readonly="readonly" value=<%=writer%>>
 		<span style="margin-left: 600px; margin-bottom: 5px; border: 0; font: bold; font-size: 16px;"><%=writer%></span>
 		<textarea rows="" cols="" style="width: 1040px; height: 600px" name="content" placeholder="글꼴 | 크기"><%=content%></textarea> <br>
 		<input type="button" style="margin-left: 80px; margin-top: 10px" value="이미지 첨부" onclick="document.getElementById('imageFileName').click();" />
		<input type="file" style="display:none;" id="imageFileName" name="imageFileName" accept="image/*"/>
<!-- 	<input type="button" style="margin-left: 10px; margin-top: 10px" value="파일 첨부" onclick="document.getElementById('fileName').click();" />
		<input type="file" style="display:none;"id="fileName" name="fileName"> <br> -->
		<input style="margin-left: 750px; width: 100px; height: 30px" type="submit" value="작성 완료">
		<input type="text" style="display: none;" name="boardTitle" value=<%=boardTitle%>>
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>