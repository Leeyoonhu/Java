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
    .loginasd{
    	   display: inline-block;
		   float: right;
		   width: 1400px;
		   height: 1200px;
		   margin-top: 200px;
		   text-align: center;
    }
    .bodywash {
        margin: 0;
          padding-top: 200px;
          padding-bottom: 40px;
          font-family: "Nanum Gothic", arial, helvetica, sans-serif;
          background-repeat: no-repeat;
    }
    
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
    }
    
    #btn-Yes{
        background-color: #e4932b;
        border: none;
    }
    
    .form-signin .form-control {
          position: relative;
          height: auto;
          -webkit-box-sizing: border-box;
         -moz-box-sizing: border-box;
             box-sizing: border-box;
          padding: 10px;
          font-size: 16px;
    }
    .card-title{
        margin-left: 30px;
    }
     .links{
        text-align: center;
        margin-bottom: 10px;
    }
    .text2{
        color : blue;
    }
    </style>
</head>
<jsp:include page="./header.jsp"></jsp:include>
  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
<div class="content">
<div class="bodywash">
	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
            
			<h2 class="card-title" style="color:black;"><img src="https://i.ibb.co/7vvTJzc/logo2.png"/>아이디 찾기</h2>
		</div>
        
		<div class="card-body">
      <form action="findId" class="form-signin" method="POST">
  		 <p class="text2"> ${findid2}</p>
        <input type="text" name="firstname" id="firstname" class="form-control" placeholder="성" required autofocus><BR>
        <input type="text" name="lastname" id="lastname" class="form-control" placeholder="이름" required autofocus><BR>
        <input type="email" name="phoneNumber" id="phoneNumber" class="form-control" placeholder="전화번호" required><br>
        	<p class="check" id="check">${check}</p><br/>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">아이디 조회하기</button>
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