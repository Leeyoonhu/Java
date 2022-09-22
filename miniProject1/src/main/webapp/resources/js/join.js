$(document).ready(function(){
    let idCheck = /^[a-zA-z0-9]{6,12}$/;
    let pwdCheck = /^[a-zA-z0-9]{8,16}$/;
    let pNCheck = /^[0-9]{9,11}$/;
	let joinForm = document.joinForm;
	let nickName = $("#join_nickName").val();
	let check = false;
	let check1 = false;
	let check2 = false;
	let check3 = false;
	let check4 = false;
	let check5 = false;
	let check6 = false;
	let check7 = false;
	$("#join_userId").focusout(function(){
		$.ajax({
            type : 'POST',
            url : 'idCheck',
            data : {userId : $("#join_userId").val()},
            dataType : "text",
            success : function(result){
				if(result != "null") {
                	$("#join_userId_check").text("이미 사용중인 아이디입니다.");
                    $("#join_userId_check").css("color", "red");
                    check = false;
				}
            },
          	error : function(result){
				conlose.log("idCheck error : " + result);
			}
        });
        if($(this).val() == ""){
            $("#join_userId_check").text("아이디를 입력해 주세요.");
            $("#join_userId_check").css("color", "red");
            check = false;
        }
        else if($(this).val().length < 6 || $(this).val().length > 12 || !idCheck.test($(this).val())){
            $("#join_userId_check").text("6~12의 영문 대소문자, 숫자만 사용가능합니다");
            $("#join_userId_check").css("color", "red");
            check = false;
        }
        else {
            $("#join_userId_check").text(""); 
            check = true;
        }
    });

    $("#join_userPwd").focusout(function(){
        if($(this).val() == ""){
            $("#join_userPwd_check").text("비밀번호를 입력해 주세요.");
            $("#join_userPwd_check").css("color", "red");
            check1 = false;
        }
        else if($(this).val().length < 8 || $(this).val().length > 16 || !pwdCheck.test($(this).val())){
            $("#join_userPwd_check").text("8~16의 영문 대소문자, 숫자만 사용가능합니다");
            $("#join_userPwd_check").css("color", "red");
            check1 = false;
        }
        else {
            $("#join_userPwd_check").text("");
            check1 = true;
        }
    });

    $("#join_checkPwd").focusout(function(){
        if($(this).val() == ""){
            $("#join_checkPwd_check").text("비밀번호 확인을 입력해 주세요.");
            $("#join_checkPwd_check").css("color", "red");
            check2 = false;
        }
        else if($(this).val() != $('#join_userPwd').val()){
            $("#join_checkPwd_check").text("비밀번호가 일치하지 않습니다.");
            $("#join_checkPwd_check").css("color", "red");
            check2 = false;
        }
        else {
        	$("#join_checkPwd_check").text("");
        	check2 = true;
        }
    });
    
    $("#join_nickName").focusout(function(){
    	$.ajax({
            type : 'POST',
            url : 'nickCheck',
            data : {nickName : $("#join_nickName").val()},
            dataType : "text",
            success : function(result){
				if(result != 'null'){
                	$("#join_nickName_check").text("이미 사용중인 닉네임입니다.");
                    $("#join_nickName_check").css("color", "red");
                    check3 = false;
				}
            }
        });
        if($(this).val() == ""){
            $("#join_nickName_check").text("닉네임을 입력해 주세요.");
            $("#join_nickName_check").css("color", "red");
            check3 = false;
        }
        else {
        	$("#join_nickName_check").text("");
        	check3 = true;
        }
    });
    
    $("#join_firstName").focusout(function() {
		if($(this).val() == ""){
			$("#join_firstName_check").text("성을 입력해 주세요.");
			$("#join_firstName_check").css("color", "red");
			check4 = false;
		}
		else {
			$("#join_firstName_check").text("");
			check4 = true;
		}
	});
    
    $("#join_lastName").focusout(function() {
		if($(this).val() == ""){
			$("#join_lastName_check").text("이름을 입력해 주세요.");
			$("#join_lastName_check").css("color", "red");
			check5 = false;
		}
		else {
			$("#join_lastName_check").text("");
			check5 = true;
		}
	});
    
    $("#join_phoneNo").focusout(function() {
		$.ajax({
			type : "POST",
			url : "pNCheck",
			data : {phoneNo : $(this).val()},
			dataType : "text",
			success : function(result){
				if(result != 'null'){
					$("#join_phoneNo_check").text("이미 사용중인 전화번호입니다.");
                    $("#join_phoneNo_check").css("color", "red");
                    check6 = false;
				}
			}
		})
    	if($(this).val() == ""){
    		$("#join_phoneNo_check").text("전화번호를 입력해 주세요.");
    		$("#join_phoneNo_check").css("color", "red");
    		check6 = false;
    	}
    	else if(!pNCheck.test($(this).val())){
			$("#join_phoneNo_check").text("형식에 맞지 않는 번호입니다.(-제외)")
			$("#join_phoneNo_check").css("color", "red");
			check6 = false;
		}
		else {
			$("#join_phoneNo_check").text("");
			check6 = true;
		}
	});
    $("#join_pwdHint").focusout(function(){
		if($(this).val() == ""){
			$("#join_pwdHint_check").text("비밀번호 찾기 답변을 입력해주세요");
			$("#join_pwdHint_check").css("color", "red");
			check7 = false;
		}
		else {
			$("#join_pwdHint_check").text("");
			check7 = true;
		}
		if(
		check == true
		&& check1 == true
		&& check2 == true
		&& check3 == true
		&& check4 == true
		&& check5 == true
		&& check6 == true
		&& check7 == true
		){	
			$("#tryJoin_check").text("")
		} else {
			$("#tryJoin_check").text("형식을 확인해 주세요.")	
			$("#tryJoin_check").css("color", "red");
		}
		
	})
    $('#tryJoin').on('click', function() {
        if(
		check == true
		&& check1 == true
		&& check2 == true
		&& check3 == true
		&& check4 == true
		&& check5 == true
		&& check6 == true
		&& check7 == true
		){	
			alert("회원 가입을 축하드립니다!");
			joinForm.submit();
		} else {
			$("#tryJoin_check").text("형식을 확인해 주세요.")
			$("#tryJoin_check").css("color", "red");
		}
    });
});