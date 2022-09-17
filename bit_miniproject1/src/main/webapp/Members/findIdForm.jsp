<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<jsp:include page="./header.jsp"></jsp:include>
  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
<div class="content">
<div class="bodywash">
	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
            
			<h2 class="card-title" style="color:#f58b34;"><img src="https://i.ibb.co/Xbr9XFs/binocular.png"  width="60px" height="60px"/>아이디 찾기</h2>
		</div>
		<div class="card-body">
      <form action="./findIdProcess.jsp" class="form-signin" method="POST">
  		 <p class="text2"> ${findid2}</p>
        <input type="text" name="firstName" id="firstname" class="form-control" placeholder="성" required autofocus><BR>
        <input type="text" name="lastName" id="lastname" class="form-control" placeholder="이름" required autofocus><BR>
        <input type="text" name="phoneNo" id="phoneNumber" class="form-control" placeholder="전화번호" required><br>
        <button  style = "background-color : #f58b34" id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">아이디 조회하기</button>
        <button style = "background-color : rgb(158, 158, 158)" id="btn-Yes" class="btn btn-lg btn-primary btn-block" onclick="document.getElementById('goToMainForm').click()">메인으로</button> 
       	<button  style = "background-color : rgb(158, 158, 158)" style= "margin-top: 8px"   id="btn-Yes" class="btn btn-lg btn-primary btn-block" onclick="document.getElementById('findPwdForm').click()">비밀번호 찾기</button>
        <a href="./mainForm.jsp" style="display: none" id="goToMainForm"></a>
       	<a href="./findPwdForm.jsp" style="display: none" id="findPwdForm"></a>
     </form>  
     </div>
      </div>
      </div>
      </div>
      <br>
        <br>
        <br>
      <jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>