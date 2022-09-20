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
            height : 100vh;
            background : url("https://i.ibb.co/r38wVRd/login.webp") no-repeat center;
            background-size: cover;
        }
/*         .bodyshower::before{ */
/*             content:""; */
/*             position: absolute; z-index: 1; */
/*             top:0; right:0; bottom:0; left:0; */
/*             background-color: rgba(0,0,0,.7); */
        }
        .login-form {
            position: relative;
            z-index: 2;
        }
        .login-form h1 {
            font-size: 32px;
            color:black;
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
            border-bottom: 1px solid black;
            font-size: 18px;
            color : black;
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
    </head>
    <jsp:include page="./header.jsp"></jsp:include>
<body>
<section class="bodyshower">
    <section class="login-form">
        <h1 style="color : black; font-weight:bold">로그인</h1>
        <form action="./loginProcess.jsp" name="loginForm">
            <div class="int-area">
                <input placeholder="USER NAME" type="text" name="userId" id="loginUserId" autocomplete="off" required>
                <label for="id"></label>
            <div class="int-area">
                <input style="color:black" placeholder="PASSWORD" type="password" name="userPwd" id="loginUserPwd" autocomplete="off" required>
                <label for="pw" style="color:black"></label>
            </div>
            <div class="btn-area">
                <button id ="tryLogin" type="button">LOGIN</button>
            </div>
        </form>
        <div class="caption">
            <a href="./findIdForm.jsp" style="color: white; text-decoration: none">아이디 찾기</a> | 
            <a href="./findPwdForm.jsp" style="color: white; text-decoration: none">비밀번호 찾기</a> | 
            <a href="./mainForm.jsp" style="color: white; text-decoration: none">메인으로</a> 
        </div> 
        </section>
    </section>
    <script type="text/javascript" src="../Js/loginCheck.js"></script>
        <jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>