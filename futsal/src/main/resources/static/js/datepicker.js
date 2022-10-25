$(document).ready(function(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	
	document.cookie = "year = " + year
	document.cookie = "month = " + month
	document.cookie = "day = " + day
	console.log(year)
	console.log(month)
	console.log(day)
	$("#futsalDate").datepicker({
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
	    showAnim: "slide",
	    
		onSelect:function(d){
	        console.log(d+" 선택되었습니다");
	        
	        var arr=d.split("/");
	        month=arr[0];
	        day=arr[1];
	        year=arr[2];
	       document.cookie = "year = " + year
		   document.cookie = "month = " + month
		   document.cookie = "day = " + day
	       console.log("선택된 년도 : "+ year)
	       console.log("선택된 달 : " +month)
	       console.log("선택된 일 : " +day)
	    }
	});
  	
})
