
/**
 * 
 */
 $(document).ready(function(){
 let idCheck = /^[a-zA-z0-9]{6,12}$/;
 let check11 = false;
 let check12 = false;
 let check13 = false;

		$("#fwdBtn").on("click", function(){
			console.log(check11)
			console.log(check12)
			console.log(check13)	
			if(check11 == true
			&& check12 == true
			&& check13 == true){
				$.ajax({
					type : 'POST',
					url : 'findPwdProc',
					data : {userId: $('#fPwd_userId').val(), pwdHint: $('#fPwd_pwdHint').val()},
					dataType : 'text',
					success : function(result){
						if(result != 'null'){
							$('#checks').text('');
							alert("회원님의 비밀번호는 " + result + " 입니다.");
						}
						if(result == 'null'){
							$('#checks').text('정보가 일치하지 않습니다.')	
							$('#checks').css('color', 'red');
						}	
					}
				})
				$('#checks').text('');
			}
			else {
				$('#checks').text('형식을 확인해 주세요.')	
				$('#checks').css('color', 'red');
			}
		})


  		$('#fPwd_userId').focusout(function(){
	     $.ajax({
			type : 'POST',
			url : 'idToPwdHintQ',
			data : {userId : $(this).val()},
			dataType : 'text',
			success : function(result){
				if(result != 'null'){
                    check11 = true;
                	$("#fPwd_pwdHintQ").val(result);
				}			
            }
		})
		
		
	     if($(this).val() == ""){
	   		$('#checks').text('아이디를 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     } else if($(this).val().length < 6 || $(this).val().length > 12 || !idCheck.test($(this).val())){
  			$('#checks').text('6~12의 영문 대소문자, 숫자만 사용가능합니다');
  			$('#checks').css('color', 'red');
	     }
	     else {	
			$('#checks').text('');
			check12 = true;
	     }  
	    });
  	     
  		$("#fPwd_pwdHint").focusout(function(){
	     if($(this).val() == ""){
	   		$('#checks').text('비밀번호 찾기 답변을 입력해주세요');
	   	  	$('#checks').css('color', 'red');
	     }
	     else {
			$('#checks').text('');
			check13 = true;
		}	
	    });

		
});
