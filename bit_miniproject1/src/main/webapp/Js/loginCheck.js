$(document).ready(function(){
	let form = document.loginForm;
	$('#tryLogin').on('click', function(){
		$.ajax({
			type : "POST",
			url : "./loginCheck.do",
			data : {userId: $('#loginUserId').val(), userPwd: $('#loginUserPwd').val()},
			dataType : "text",
			success : function(result){
				if(result != "null"){
					alert(result + "님 어서오세요!");
					form.submit();
				}
				else {
					alert("아이디와 비밀번호가 맞지 않습니다.");
				}
			}
		})
	})
	
})