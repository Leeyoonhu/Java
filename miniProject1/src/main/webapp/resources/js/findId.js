$(document).ready(function(){
    let pNCheck = /^[0-9]{9,11}$/;
	 let check = false;
	 let check1 = false;
	 let check2 = false;
    $('#firstName').focusout(function(){
        if($(this).val() == ""){
            $('#checks').text('성을 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
        }
        else {	
			$('#checks').text('');
			check = true;
	     }  
    })
	
	$('#lastName').focusout(function(){
		if($(this).val() == ""){
			$('#checks').text('이름을 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
        }
        else {	
			$('#checks').text('');
			check1 = true;
	     }  
	})
	
	$('#phoneNo').focusout(function(){
		if($(this).val() == ""){
			$('#checks').text('전화번호를 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
        }
        else if(!pNCheck.test($(this).val())){
			$("#checks").text("형식에 맞지 않는 번호입니다.(-제외)")
			$("#checks").css("color", "red");
		}
        else {	
			$('#checks').text('');
			check2 = true;
	     }  
	})
	$('button[name="searchingId"]').on('click', function(){
		if(check == true
			&& check1 == true
			&& check2 == true){
				$.ajax({
					type : 'POST',
					url : 'findIdProc',
					data : {firstName: $('#firstName').val(), lastName: $('#lastName').val(), phoneNo: $('#phoneNo').val()},
					dataType : 'text',
					success : function(result){
						if(result != 'null'){
							$('#checks').text('');
							alert("회원님의 아이디는 " + result + " 입니다.");
						}
						else {
							
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
})