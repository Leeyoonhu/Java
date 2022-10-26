$(document).ready(function(){
var current_fs = null;
var next_fs = null;
var previous_fs = null; 
var left, opacity, scale; 
var animating; 
let pNCheck = /^[0-9]{9,11}$/;
let check = false;
let check1 = false;
let check2 = false;
let nexts = $(".next")

$('#name').focusout(function(){
    if($(this).val() == ""){
        $('#checks').text('이름을 입력해주세요.');
   	  	$('#checks').css('color', 'red');
    }
    else {	
		$('#checks').text('');
		check = true;
     }  
})

$('#nickName').focusout(function(){
	$.ajax({
        type : 'POST',
        url : '/member/nickNameAjax',
        data : {nickName : $("#nickName").val()},
        dataType : "text",
        success : function(result){
			console.log("nickName result : " + result)
			if(result == 'true'){
            	$("#checks").text("이미 사용중인 닉네임입니다.");
                $("#checks").css("color", "red");
                check1 = false;
			}
        }
    });
    if($(this).val() == ""){
        $("#checks").text("닉네임을 입력해 주세요.");
        $("#checks").css("color", "red");
        check1 = false;
    }
    else {
    	$("#checks").text("");
    	check1 = true;
    }
})

$('#phoneNo').focusout(function(){
	$.ajax({
		type : "POST",
		url : "/member/phoneNoAjax",
		data : {phoneNo : $(this).val()},
		dataType : "text",
		success : function(result){
			console.log("phoneNo result : " + result)
			if(result == 'true'){
				$("#checks").text("이미 사용중인 전화번호입니다.");
                $("#checks").css("color", "red");
                check2 = false;
			}
		}
	})
	if($(this).val() == ""){
		$("#checks").text("전화번호를 입력해 주세요.");
		$("#checks").css("color", "red");
		check2 = false;
	}
	else if(!pNCheck.test($(this).val())){
		$("#checks").text("형식에 맞지 않는 번호입니다.(-제외)")
		$("#checks").css("color", "red");
		check2 = false;
	}
	else {
		$("#checks").text("");
		check2 = true;
	} 
})

// 1번째
$("#next1").on('click', function () {
  if (animating) return false;
  animating = true;
  
  current_fs = $(this).parent();
  next_fs = $(this).parent().next();

  if($("fieldset").index(next_fs) == 1){
	  current_fs = $(this).parent();
  	  next_fs = $(this).parent().next();
	 $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
	  next_fs.show();
	  current_fs.animate(
	    { opacity: 0 },
	    {
		    step: function (now, mx) {
	        scale = 1 - (1 - now) * 0.2;
	        left = now * 50 + "%";
	        opacity = 1 - now;
	        current_fs.css({
	          transform: "scale(" + scale + ")",
	          position: "absolute",
	        });
	        next_fs.css({'left': left, 'opacity': opacity });
	      },
	      duration: 800,
	      complete: function () {
	        current_fs.hide();
	        animating = false;
	      },
	    }
	  );
  	}
});


// 2번째
$("#next2").on('click', function () {
  	console.log("check : " + check);
  	console.log("check1 : " + check1);
  	console.log("check2 : " + check2);
  	if(check && check1 && check2){
		if (animating) {
		 return false;			
		}
	  	animating = true;
	  	
	  current_fs = $(this).parent();
  	  next_fs = $(this).parent().next();
	 $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
	  next_fs.show();
	  current_fs.animate(
	    { opacity: 0 },
	    {
		    step: function (now, mx) {
	        scale = 1 - (1 - now) * 0.2;
	        left = now * 50 + "%";
	        opacity = 1 - now;
	        current_fs.css({
	          transform: "scale(" + scale + ")",
	          position: "absolute",
	        });
	        next_fs.css({'left': left, 'opacity': opacity });
	      },
	      duration: 800,
	      complete: function () {
	        current_fs.hide();
	        animating = false;
	      },
	    }
	  );
  	}
  	
  	else {
		$('#checks').text('형식을 확인해 주세요.')	
		$('#checks').css('color', 'red');
	}
 });

$("#prev2").on('click', function () {
  if (animating) return false;
  animating = true;

  current_fs = $(this).parent();
  previous_fs = $(this).parent().prev();
  console.log("previous_fs = " + $("fieldset").index(current_fs))
  $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
  previous_fs.show();
  current_fs.animate(
    { opacity: 0 },
    {
        step: function (now, mx) {
        scale = 0.8 + (1 - now) * 0.2;
        left = (1 - now) * 50 + "%";
        opacity = 1 - now;
        current_fs.css({ 'left': left });
        previous_fs.css({
          'transform': "scale(" + scale + ")",
          'opacity': opacity,
        });
      },
      duration: 800,
      complete: function () {
        current_fs.hide();
        animating = false;
      },
    }
  );
});

$("#prev3").on('click', function () {
  if($('#name').val() != null || $("#nickName").val() != null || $("#phoneNo").val() != null){
	  $('#name').val('');
	  $('#nickName').val('');
	  $('#phoneNo').val('');
	  $('#sex').val('남자');
	  check = false; check1 = false; check2 = false;
  } 
  if (animating) return false;
  animating = true;

  current_fs = $(this).parent();
  previous_fs = $(this).parent().prev();
  console.log("previous_fs = " + $("fieldset").index(current_fs))
  $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
  previous_fs.show();
  current_fs.animate(
    { opacity: 0 },
    {
        step: function (now, mx) {
        scale = 0.8 + (1 - now) * 0.2;
        left = (1 - now) * 50 + "%";
        opacity = 1 - now;
        current_fs.css({ 'left': left });
        previous_fs.css({
          'transform': "scale(" + scale + ")",
          'opacity': opacity,
        });
      },
      duration: 800,
      complete: function () {
        current_fs.hide();
        animating = false;
      },
    }
  );
});

$(".submit").click(function () {
  return false;
});
})