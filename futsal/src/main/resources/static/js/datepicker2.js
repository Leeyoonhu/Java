$(document).ready(function() {
	var fName = $("#fName").val();
	var time;
	var type;
	function getCookie(name) {
		var nameOfCookie = name + "=";
		var x = 0;
		while (x <= document.cookie.length) {
			var y = (x + nameOfCookie.length);
			if (document.cookie.substring(x, y) == nameOfCookie) {
				if ((endOfCookie = document.cookie.indexOf(";", y)) == -1)
					endOfCookie = document.cookie.length;
				return unescape(document.cookie.substring(y, endOfCookie));
			}
			x = document.cookie.indexOf(" ", x) + 1;
			if (x == 0) {
				break;
			}
		}
		return "";
	}
	
	console.log(getCookie('date'))
	var date = getCookie('date');
	var today = new Date();
	
	$("#futsalDate").datepicker({
		dateFormat: "yy-mm-dd",
		showOn: "both",
		buttonImage: "button.png",
		buttonImageOnly: true,
		changeMonth: false,
		changeYear: false,
		nextText: "다음 달",
		prevText: "이전 달",
		yearSuffix: "년",
		showMonthAfterYear: true,
		dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		minDate: "0",
		maxDate: "+1M",
		showAnimation: 'slider',
		onSelect:function(d){
	        console.log(d+" 선택되었습니다");
	        date = d
	        document.cookie = "date = " + date + '; path=/;'
	        $.ajax({
				type : "POST",
				url : "/field/" + $("#fieldId").val(),
				success : function(res){
					$("#timeTables").replaceWith(res.substring(res.indexOf('<div id="timeTables">'), res.indexOf('<table>')));
					$(".btn-gradient.green").on('click', function(e){
						var btns = document.querySelectorAll(".btn-gradient");
						btns.forEach(function(btn, i) {
							if(e.currentTarget == btn) {
								btn.classList.add("active");
							}
							else {
								btn.classList.remove("active");
							}
						});
						console.log("선택 시간 : " + e.currentTarget.value);
						time = e.currentTarget.value
						type = "green"
					})
					
					$(".btn-gradient.yellow").on('click', function(e){
						var btns = document.querySelectorAll(".btn-gradient");
						btns.forEach(function(btn, i) {
							if(e.currentTarget == btn) {
								btn.classList.add("active");
							}
							else {
								btn.classList.remove("active");
							}
						});
						console.log("선택 시간 : " + e.currentTarget.value);
						time = e.currentTarget.value
						type = "yellow"
					})
				}
			})
	    }
	}).datepicker('setDate', date);
	$(".btn-gradient.green").on('click', function(e){
		var btns = document.querySelectorAll(".btn-gradient");
		btns.forEach(function(btn, i) {
			if(e.currentTarget == btn) {
				btn.classList.add("active");
			}
			else {
				btn.classList.remove("active");
			}
		});
		console.log("선택 시간 : " + e.currentTarget.value);
		time = e.currentTarget.value
		type = "green"
	})
	
	$(".btn-gradient.yellow").on('click', function(e){
		var btns = document.querySelectorAll(".btn-gradient");
		btns.forEach(function(btn, i) {
			if(e.currentTarget == btn) {
				btn.classList.add("active");
			}
			else {
				btn.classList.remove("active");
			}
		});
		console.log("선택 시간 : " + e.currentTarget.value);
		time = e.currentTarget.value
		type = "yellow"
	})
	$("#goReserve").on('click', function(){
		if($(".btn-gradient.yellow.active").val() == null && $(".btn-gradient.green.active").val() == null){
			alert("예약 시간을 선택해주세요")
		}
		else {
			location.href = "/reserve/" + fName + "/" + time + "/" + type;
		}
	})
})