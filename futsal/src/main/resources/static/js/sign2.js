$(document).ready(function(){
var current_fs, next_fs, previous_fs; 
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
	if($(this).val() == ""){
		$('#checks').text('닉네임을 입력해주세요.');
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

// 이전에 있던 페이지 번호
$(nexts[0]).on('click', function () {
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


$(nexts[1]).on('click', function () {
  if (animating) return false;
  animating = true;
  
  current_fs = $(this).parent();
  next_fs = $(this).parent().next();

  	if(check && check1 && check2){
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



// 가고자 하는 번호로 감
$(".previous").on('click', function () {
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