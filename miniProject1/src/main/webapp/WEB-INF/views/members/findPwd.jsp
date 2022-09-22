<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/resources/js/findPwd.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>비밀번호 찾기</title>
    <style>
        @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
    </style>
  </head>
   <!-- header -->
<body>
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/header.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="../includes/header2.jsp" %>
	</c:otherwise>
</c:choose>
<div class="content">
<div class="bodywash">
	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
            
			<h2 class="card-title" style="color:#f58b34;"><img src="https://i.ibb.co/mGCzCtg/soldier.png" width="60px" height="60px"/>비밀번호 찾기</h2>
		</div>
        
		<div class="card-body">
      <form action="" class="form-signin" method="POST">
        <input type="text" name="userId" id="fPwd_userId" class="form-control" placeholder="아이디" required autofocus="autofocus"><br>
        <input type="text" name="pwdHintQ" id="fPwd_pwdHintQ" class="form-control" readonly="readonly" tabindex="-1" required><br>
        <input type="text" name="pwdHint" id="fPwd_pwdHint" class="form-control" placeholder="비밀번호 찾기 답변" required><br>
        <p class="checks" id="checks"></p>
        <input type="button" id="fwdBtn" class="btn btn-lg btn-primary btn-block" style="background: #f58b34;" value="비밀번호 찾기" name="fwdBtn">
       </form>
		</div>
        <div class="links">
            <a style="color : black" href="findId">아이디 찾기</a> | <a style="color : black" href="login">로그인</a> | <a style="color : black" href="join">회원가입</a>
        </div>
	</div>
	</div>
	</div>
	<br>
	<br>
	<br>
<!-- footer -->
<%@ include file="../includes/footer.jsp" %>
  </body>
</html>