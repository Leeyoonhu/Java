<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <title>아이디 찾기</title>
    <style>
        @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
    </style>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <script type="text/javascript" src="/resources/js/findId.js"></script>
</head>
<!-- header -->
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/header.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="../includes/header2.jsp" %>
	</c:otherwise>
</c:choose>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
<div class="content">
<div class="bodywash">
	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
            
			<h2 class="card-title" style="color:#f58b34;"><img src="https://i.ibb.co/mGCzCtg/soldier.png"  width="60px" height="60px"/>아이디 찾기</h2>
		</div>
		<div class="card-body">
      <form class="form-signin" onSubmit="return false;">
  		 <p class="text2"> ${findid2}</p>
        <input type="text" name="firstName" id="firstName" class="form-control" placeholder="성" required autofocus><BR>
        <input type="text" name="lastName" id="lastName" class="form-control" placeholder="이름" required autofocus><BR>
        <input type="text" name="phoneNo" id="phoneNo" class="form-control" placeholder="전화번호" required onkeypress="if(event.keyCode==13){document.getElementById('tryfindId').click()}"><br>
        <p id="checks" class="checks"></p>
        <br>
        <button style = "background-color : #f58b34" id="tryfindId" class="btn btn-lg btn-primary btn-block" type="button" name="searchingId">아이디 조회하기</button>
        <button style = "background-color : rgb(158, 158, 158)" id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" onclick="document.getElementById('goToMainForm3').click()">메인으로</button> 
       	<button style = "background-color : rgb(158, 158, 158)" style= "margin-top: 8px"   id="btn-Yes" class="btn btn-lg btn-primary btn-block" onclick="document.getElementById('findPwdForm').click()">비밀번호 찾기</button>
        <a href="../board/main" style="display: none" id="goToMainForm3"></a>
       	<a href="../members/findPwd" style="display: none" id="findPwdForm"></a>
     </form>  
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