<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/resources/js/upload.js"></script>
<title>글 쓰기</title>
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
<%-- <%
request.setCharacterEncoding("utf-8");
String writer = (String)session.getAttribute("nickName");
String boardTitle = request.getParameter("boardTitle");
%> --%>
<!-- header -->
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/header.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="../includes/header2.jsp" %>
	</c:otherwise>
</c:choose>
<div id="content">
<div id="freeBoardWrite">
<h1 style="position: relative;
    margin-top: 20px;
    margin-bottom: 50px;
    padding-bottom: 50px;
    border-bottom: 1px solid #323232;
    ">ROK ARMY 글쓰기</h1>
   <!-- db에 어느 보드에서 작성됬는지 알려줘야해 -->
	<input type="text" style="display: none;" name="writer" readonly="readonly" value="${userInfo.nickName}">
	<span style="margin-left: 940px; border: 0; font: bold; font-size: 18px; margin-bottom: 10px">${userInfo.nickName}</span>
	<input class="table_input" placeholder="제목을 입력 하세요." type="text" 
	style="width: 1040px; height: 30px; margin-right: 280px; margin-top: 4px; position:relative; right: -180px;" 
	name="title" autofocus="autofocus" maxlength="50"><br>
	<textarea class="table_input" rows="" cols="" style="width: 1040px; height: 600px; position:relative; right: -180px;" name="content" placeholder="글꼴"></textarea> <br>
	<input type="file" style="display:none;" id="addImage" name="uploadFile" accept="image/*"/>
	<input type="button" class="imageUploaded" value="이미지 첨부" onclick="document.getElementById('addImage').click();" />
	<input type="text" style="display: none;" name="boardTitle" value="${boardTitle}">
	<input class="endWrite" type="button" id="uploadBtn" value="작성 완료">

</div>
</div>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
</body>
</html>