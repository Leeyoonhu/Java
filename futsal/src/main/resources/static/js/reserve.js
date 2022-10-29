$(document).ready(function(){
	var fName = $("#fName").text()
	var fPrice = $("#fPrice").text()
	var fDate = $("#fDate").text()
	var fTime = $("#fTime").text()
	var fPhoneNo = $("#fPhoneNo").text()
	var rState = "A"
	var nickName1 =$("#nickName1").attr('placeholder') 
	var tName1 = $("#tName1").attr('placeholder')
	var rDate1 = new Date();
	rDate1 = rDate1.getFullYear() + '-' + (rDate1.getMonth()+1) + '-' + rDate1.getDate(); 
	var nickName2 = "null"
	var tName2 = "null"
	var rDate2 = "null"
	
	$("#tryReserve").on("click", function(){
		var type = $('input[name=reserveType]:checked').val();
		$.ajax({
			type : "POST",
			url : "/reserveTo/checkAjax",
			data : {name : fName, tName1 : tName1, fTime : fTime},
			dataType : "text",
			success : function(result){
				console.log("예약 정보 : " + result)
				if(result == "null"){ 
					if(type == "all"){
						nickName2 = $("#nickName1").attr('placeholder') 
						tName2 = $("#tName1").attr('placeholder')
						rDate2 = rDate1
					}					
					$.ajax({
						type : "POST",
						url : "/reserveTo/insertA",
						data :{
							fName : fName, fPrice : fPrice, fDate : fDate, fTime : fTime, fPhoneNo : fPhoneNo, 
							type : type, rState : rState, nickName1 : nickName1, tName1 : tName1, rDate1 : rDate1,
							nickName2 : nickName2, tName2 : tName2, rDate2 : rDate2
						},
						dataType : "text",
						success : function(){
							console.log("타입 : " + type + "예약 : A") 
							location.href = "/main"
						},
						error : function() {
							console.log("타입 : " + type + "예약 : A") 
							location.href = "/main"
						}
					})
				}
				if(result == "A"){ 
					console.log("b예약")
				}
			},
			error: function(result){
				console.log("reserve Ajax Error : " + result)
			}
		})
		
	
	});
})