<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
#joinForm {
	display: inline-block;
	float: right;
	width: 1400px;
	height: 1800px;
	margin-top: 200px;
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
    margin: 0px 0px 30px 0px;
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
    margin : 150px 0px 0px 0px;
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

<!-- 비밀번호와 확인비번이 같은지 -->
<script type="text/javascript">
	function checkJoin() {
		let form = document.joinForm;
		if(form.userId.value.length < 4 || form.userId.value.length > 12 || form.userId.value == ""){
			alert("아이디는 4~12자 사이로 입력해주세요");
			return false;
		}
		if(form.userPwd.value.length < 8 || form.userPwd.value.length > 16 || form.userPwd.value == ""){
			alert("비밀번호는 8~16자 사이로 입력해주세요");
			return false;
		}
		if(form.user.checkPwd.value.length < 8 || form.user.checkPwd.value.length > 16 || form.userPwd.valueform.user.checkPwd.value == ""){
			alert("비밀번호 확인은 8~16자 사이로 입력해주세요");
			return false;
		}
		if(form.userPwd.value != form.user.checkPwd.value){
			alert("입력하신 비밀번호와 비밀번호 확인이 다릅니다.");
			return false;
		}
		form.submit();
	}
</script>
<%if(session.getAttribute("userId") != null){ %>
<jsp:include page="./header2.jsp"></jsp:include>
<%} 
else {%>
<jsp:include page="./header.jsp"></jsp:include>
<%}%>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="joinForm">
<form action="./joinProcess.jsp" method="post" name="joinForm">
<div id="wrapper">
<div id="top">
    <ul><h2>가입 정보 입력</h2></ul>
    <ul>가입 정보를 입력하세요.</ul>
</div>
</div>
<div id="content">
    <form class = "form_design">
        <hr/>
        <ul>
            <li>아이디</li>
            <li><input type="text" name="userId" autofocus="autofocus"></li> 
             
        </ul>
        <ul>
            <li>비밀번호</li> 
            <li><input type="password" name="userPwd"></li>
        </ul>
        <ul>
            <li>비밀번호 확인</li>
            <li><input type="password" name="checkPwd"></li>
        </ul>
        <ul>
            <li>닉네임</li>
            <li><input type="text" name="nickName"></li>
        </ul>
        <ul>
            <li>성</li>
            <li><input type="text" name="firstName"></li>
        </ul>
        <ul> 
            <li>이름</li>
            <li><input type="text" name="lastName"></li>          
        </ul>
        <ul>
            <li>전화번호</li>
            <li><input type="tel" name="phoneNo" ></li>
        </ul>
        <ul>
            <li>비밀번호 찾기 질문</li> 
            <li><select name="pwdHintQ"></li>
                <option>내가 태어난 곳은?</option>
	            <option>내가 졸업한 초등학교는?</option>
	            <option>내가 사는 지역은?</option>
	            <option>나의 별명은?</option>
	            <option>나의 보물 1호는?</option>
	            </select>
        </ul>
        <ul>
            <li>비밀번호 찾기 답변</li>
            <li><input type="text" name="pwdHint"></li>
        </ul>
        <ul>
            <li>직업</li>
            <input type="radio" name="userJob" id="soldier" value="soldier" checked="checked"><label for="soldier">군인</label>
            <input type="radio" name="userJob" id="family" value="family"><label for="family">가족</label>
                
                <input type="radio" name="userJob" id="normal" value="normal">
                <label for="normal">일반인</label>
                <input type="radio" name="userJob" id="girlfriend" value="girlfriend">
                <label for="girlfriend">여자친구</label>
        </ul>
        <ul>
            <li>성별</li>
                <input type="radio" name="gender" id="male" value="male" checked="checked">
                <label for="male">남자</label>
                <input type="radio" name="gender" id="female" value="female"> 
                <label for="female">여자</label>
            </ul>
        <hr/>
    </form>
    <ul id="btn_line">
    	<a href="./mainForm.jsp" style="display: none" id="gotomainform"></a>
       <input type="button" value="이전으로" onclick="document.getElementById('gotomainform').click()"> <input type="button" value="회원가입" onclick="checkJoin()">
    </ul>
</div>	
</form>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>