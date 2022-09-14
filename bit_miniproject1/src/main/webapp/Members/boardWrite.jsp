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
   height: 1200px;
   margin-top: 200px;
   text-align: center;
}
 .table_input {
        display: block;
        width: 1500px;
        min-height: 40px;
        padding: 11px 12px 10px;
        border: 1px solid #ebecef;
        box-sizing: border-box;
        overflow: hidden;
        word-break: break-all;
        font-size: 15px;
        letter-spacing: -.23px;
        line-height: 17px;
        outline: none;
        height: 40px;
        }
</style>
</head>
<body>
<!-- multipart/form-data를 상요해 파일 정보를 넘겨서 업로딩 할 예정 -->
<!-- 반드시 관련 파일들 import 해주어야 함-->
<!-- 
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;
 -->
<%
request.setCharacterEncoding("utf-8");
String writer = (String)session.getAttribute("nickName");
String boardTitle = request.getParameter("boardTitle");
%>
<jsp:include page="./header2.jsp"></jsp:include>
<div id="content">
<div id="freeBoardWrite">
<form action="./boardwrite.do?" method="post" enctype="multipart/form-data">
 		<input type="text" style="display: none;" name="writer" readonly="readonly" value=<%=writer%>>
 		<span style="margin-left: 920px; border: 0; font: bold; font-size: 16px;"><%=writer%></span>
 		<input class="table_input" placeholder="제목을 입력 하세요." type="text" 
 		style="width: 1040px; height: 30px; margin-right: 280px; margin-top: 4px; position:relative; right: -180px;" 
 		name="title" autofocus="autofocus" maxlength="50"><br>
		<textarea class="table_input" rows="" cols="" style="width: 1040px; height: 600px; position:relative; right: -180px;" name="content" placeholder="글꼴"></textarea> <br>
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