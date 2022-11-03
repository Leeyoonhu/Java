$(document).ready(function(){
	var fName = $("#fName").text()
	var fPrice = $("#fPrice").text()
	var fDate = $("#fDate").text()
	var fTime = $("#fTime").text()
	var fPhoneNo = $("#fPhoneNo").text()
	var rState = "A"
	var nickName1 =$("#nickName1").text()
	var tName1 = $("#tName1").text()
	var rDate1 = new Date(+ new Date() + 3240 * 10000).toISOString().replace('T', ' ').replace(/\..*/, '');
	var nickName2 = "null"
	var tName2 = "null"
	var rDate2 = "null"
	
	$("#tryReserve").on("click", function(){
		var type = $('input[name=reserveType]:checked').val();
		$.ajax({
			type : "POST",
			url : "/reserveTo/checkAjax",
			data : {field : fName, fTime : fTime, fDate : fDate},
			dataType : "text",
			success : function(result){
				console.log("예약 정보 : " + result)
				if(result == "null"){ 
					if(type == "all"){
						nickName2 = $("#nickName1").text()
						tName2 = $("#tName1").text()
						rDate2 = rDate1
					}					
					$.ajax({
						type : "POST",
						url : "/reserveTo/insert",
						data :{
							fName : fName, fPrice : fPrice, fDate : fDate, fTime : fTime, fPhoneNo : fPhoneNo, 
							type : type, rState : rState, nickName1 : nickName1, tName1 : tName1, rDate1 : rDate1,
							nickName2 : nickName2, tName2 : tName2, rDate2 : rDate2
						},
						success: function(){
							alert("예약이 완료되었습니다.")
							location.href = "/main"
						}
					})
				}
				if(result == "A"){
					// save로 보내야함
					nickName2 = $("#nickName2").text()
					tName2 = $("#tName2").text()
					rDate2 = rDate1,
					$.ajax({
						type : "POST",
						url : "/reserveTo/save",
						data :{
							field : fName, fTime : fTime, fDate : fDate, nickName2 : nickName2, tName2 : tName2, rDate2 : rDate2
						},
						success: function(){
							alert("예약이 완료되었습니다.")
							location.href = "/main"
						}
					})
					
				}
			},
			error: function(result){
				console.log("reserve Ajax Error : " + result)
			}
		})	
	});
})