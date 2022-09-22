<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
<style>
 
        .bodyshower{
           display : flex;
            justify-content: center;
            align-items: center;
            height : 68vh;
            width : 1950px;
            background : url("https://i.ibb.co/84Hg9bq/back.png") no-repeat center;                    
            background-size: cover;
            
        }
        .bodyshower::before{ 
           content:""; 
          position: absolute; z-index: 1; 
          top:290px; right:0; bottom:0; left:0; 
          background-color: rgba(0,0,0,.8);
          width: 1950px; 
        }
        .login-form {
            position: relative;
            z-index: 2;
        }
        .login-form h1 {
            font-size: 32px;
            color:#999;
            text-align: center;
        }
        .int-area{width: 400px; position: relative;
        margin-top: 20px;}
        .int-area:first-child{
            margin-top: 0;
        }
        .int-area input {
            width : 100%;
            padding: 20px 10px 10px;
            background-color: transparent;
            border: none;
            border-bottom: 1px solid #999;
            font-size: 18px;
            color : white;
            outline: none;
            margin-bottom: 60px;
        }
        .int-area label {
            position: absolute;
            left : 10px;
            top : 15px;
            font-size: 18px;
            color : #999;
            transition: all .5s ease;
        }

        .int-area label.warning {
            color : red !important;
            animation: warning .3s ease;
            animation-iteration-count: 3;
        }
        @keyframes warning{
            0%{transform: translateX(-8px);}
            25%{transform: translateX(8px);}
            50%{transform: translateX(-8px);}
            75%{transform: translateX(8px);}
        }
/*         .int-area input :focus + label, */
/*         .int-area input :valid + label { */
/*             top: 0; */
/*             font-size: 13px; */
/*             color : #166cea; */
        }
        .btn-area{
            margin-top: 30px;
        }
        .btn-area button{
            width: 100%;
            height: 50px;
            background: #166cea;
            font-size: 20px;
            border:none;
            border-radius: 25px;
            cursor: pointer;
        }
        .caption{
            margin-top: 20px;
            text-align: center;
        }
        .caption a {
            font-size: 15px;
            color: #fff;
            text-decoration: none;
        }

    </style>	
<!--     <script type="text/javascript" src="../Js/loginCheck.js"></script>
 -->    </head>
 	<%@ include file="../includes/header.jsp" %>
<body>
<section class="bodyshower">
    <section class="login-form">
        <h1 style="color : white; font-weight:bold">로그인</h1>
        <form name="loginForm" action="loginProc" method="post">
            <div class="int-area">
                <input placeholder="USER NAME" type="text" name="userId" id="loginUserId" autocomplete="off" required autofocus="autofocus">
                <label for="id"></label>
            </div>
            <div class="int-area">
                <input placeholder="PASSWORD" onkeypress="if(event.keyCode==13){document.getElementById('tryLogin').click()}" type="password"  name="userPwd" id="loginUserPwd" autocomplete="off" required>
                <label for="pw" style="color:black"></label>
            </div>
            <div class="btn-area">
                <button id ="tryLogin" type="submit">LOGIN</button>
            </div>
        </form>
        <div class="caption">
            <a href="findId" style="color: white; text-decoration: none">아이디 찾기</a> | 
            <a href="findPwd" style="color: white; text-decoration: none">비밀번호 찾기</a> | 
            <a href="../board/main" style="color: white; text-decoration: none">메인으로</a> 
        </div> 
        </section>
    </section>
       <%@ include file="../includes/footer.jsp" %>
</body>
</html>