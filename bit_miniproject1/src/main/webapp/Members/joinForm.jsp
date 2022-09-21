<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*, java.util.*, org.ai.beans.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
#joinForm {
	display: inline-block;
	float: right;
	width: 1400px;
	height: 150px;
	margin-top: 100px;
	text-align: center;
}

html, body{
    padding : 0;
    margin : 0;
    font-family: "dotum";
    font-size: 0.95em;
}

ul, li{
    margin : 0;
    padding: 0;
    list-style: none;
}

input{border:1px solid #cecece;}

hr {
    border : 1px solid #e6e6e6;
    margin: 25px 0px 25px 0px;
}

#wrpper{
    display: table;
    width : auto;
    height: auto;
    margin: 0 auto;
}

#top{
    width: 100%;
    text-align: center;
    clear: both;
    margin: 0px 0px -1200px 0px;
}
.backcolor{
background-color : #80808021;
}

/* #content{ */
/*     width: 100%; */
/* } */

.form_design ul{
    width : 100%;
    height: 45px;
}

.form_design li{
    float : left;
}
.form_design li:first-child{
    width:150px;
    padding : 6px 0px 0px 0px;
}
.form_design li input{
    width : 300px;
    height: 30px;
}
.form_design li select, option{
    height:30px;
    border:1px solid #cecece
}
.form_design li .result{
    width:100px;
    margin: 0px 0px 0px 10px;
    background-color: #999999;
    color : #fff;
    clear : both;
}
#btn_line { 
    clear:both;
    width: 100%;
    margin : 60px 0px 0px 0px;
    text-align: center;
}
#btn_line li{
    float:left;
}
#btn_line li:first-child{
    width : 150px;
    padding : 15px 0px 0px 0px;
}
#btn_line input {
    border:1px solid #4d87ef;
    width : 180px;
    height:50px;
    background-color: #4d87ef;
    color:#fff;
}
</style>
</head>
<body>
<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./header2.jsp"></jsp:include>
<%} 
else {%>
<jsp:include page="./header.jsp"></jsp:include>
<%}%>
<div class="backcolor">
<div id="content">
<div id="joinForm">
<form action="./joinProcess.jsp" method="post" name="joinForm">
</div>
<br>
<br>
<br>
<br>
<br>
    <ul style="position:relative; right:-850px;"><h2>가입 정보 입력</h2></ul>
    <ul style="position:relative; right:-870px;">가입 정보를 입력하세요.</ul>
    
<div id="wrapper">
<div id="top">
</div>
</div>
    <form class = "form_design">
        <hr/>
        <br>
        <br>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;아이디</li> 
            <li><input style="width:300px; height:35px;" type="text" name="userId" id="join_userId" autocomplete="off" autofocus="autofocus">
            <p class="checks" id="join_userId_check"></li> 
        </ul>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;비밀번호</li> 
            <li><input style="width:300px; height:35px;" type="password" name="userPwd" id="join_userPwd" autocomplete="off">
            <p class="checks" id="join_userPwd_check"></li> 
        </ul>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;비밀번호 확인</li>
            <li><input style="width:300px; height:35px;" type="password" name="checkPwd" id="join_checkPwd" autocomplete="off">
            <p class="checks" id="join_checkPwd_check"></li>
        </ul >
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;닉네임</li>
            <li><input style="width:300px; height:35px;" type="text" name="nickName" id="join_nickName" autocomplete="off">
            <p class="checks" id="join_nickName_check"></li>
        </ul>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;성</li>
            <li><input style="width:300px; height:35px;" type="text" name="firstName" id="join_firstName" autocomplete="off">
            <p class="checks" id="join_firstName_check"></li>
        </ul>
        <ul style="position:relative; right:-800px;"> 
            <li>&nbsp;&nbsp;이름</li>
            <li><input style="width:300px; height:35px;" type="text" name="lastName" id="join_lastName" autocomplete="off">
            <p class="checks" id="join_lastName_check"></li>          
        </ul>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;전화번호</li>
            <li><input style="width:300px; height:35px;" type="tel" name="phoneNo" id="join_phoneNo" autocomplete="off">
            <p class="checks" id="join_phoneNo_check"></li>
        </ul>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;비밀번호 찾기 질문</li> 
            <li><select  style="width:300px;" name="pwdHintQ"></li>
                <option>내가 태어난 곳은?</option>
	            <option>내가 졸업한 초등학교는?</option>
	            <option>내가 사는 지역은?</option>
	            <option>나의 별명은?</option>
	            <option>나의 보물 1호는?</option>
	            </select>
        </ul>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;비밀번호 찾기 답변</li>
            <li><input style="width:300px; height:35px;" type="text" name="pwdHint" id="join_pwdHint" autocomplete="off">
            <p class="checks" id="join_pwdHint_check"></li>
        </ul>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;직업</li>
            <input type="radio" name="userJob" id="soldier" value="soldier" checked="checked"><label for="soldier">군인</label>
            <input type="radio" name="userJob" id="family" value="family"><label for="family">가족</label>
                
                <input type="radio" name="userJob" id="normal" value="normal">
                <label for="normal">일반인</label>
                <input type="radio" name="userJob" id="girlfriend" value="girlfriend">
                <label for="girlfriend">여자친구</label>
        </ul>
        <ul style="position:relative; right:-800px;">
            <li>&nbsp;&nbsp;성별</li>
                <input type="radio" name="gender" id="male" value="male" checked="checked">
                <label for="male">남자</label>
                <input type="radio" name="gender" id="female" value="female"> 
                <label for="female">여자</label>
            </ul>
        <hr/>
    </form>
    <ul id="btn_line">
    	<a href="./mainForm.jsp" style="display: none" id="gotomainform"></a>
       <input style="position:relative; right:-120px;" type="button" value="메인으로" onclick="document.getElementById('gotomainform').click()"> 
       &nbsp;&nbsp; <input style="position:relative; right:-120px;" type="button" value="회원가입" id="tryJoin"><br>
       <p class="checks" id="tryJoin_check"></p>
    </ul>
    </form>
</div>	
<jsp:include page="./footer.jsp"></jsp:include>
<script type="text/javascript" src="../Js/joinFormCheck.js">
</script>
</body>
</html>