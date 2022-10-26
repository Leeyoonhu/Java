$(document).ready(function(){
	var date = new Date();
	date = date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate();
	console.log(date)
	document.cookie = "date = " + date

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
	    showMonthAfterYear:true, 
	    dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
	    monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    minDate: "0",
	    maxDate: "+1M",
	    showAnimation: 'slider',
	    
		onSelect:function(d){
	        console.log(d+" 선택되었습니다");
	        date = d
	        document.cookie = "date = " + date
	        
	    }
	});
  	
})
