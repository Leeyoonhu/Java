$(document).ready(function() {
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
	        document.cookie = "date = " + date
	    }
	}).datepicker('setDate', date);
	
	var getDate = ($('#futsalDate').datepicker('getDate'))
	var today = new Date();
	var hours;
	if((today.getFullYear() == getDate.getFullYear()) && (today.getMonth() == getDate.getMonth()) && (today.getDate() == getDate.getDate())){
		console.log("선택날짜가 오늘과 동일함")
		hours = today.getHours();
		if(hours < 10){
			hours = "0" + hours
		}
		console.log("현재 시 : " + hours)
	}
})