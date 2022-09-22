$(document).ready(function () {
  let today = new Date();
  let year = today.getFullYear();
  let month = today.getMonth() + 1;
  if (month < 10) {
    month = "0" + month;
  }
  let date = today.getDate();
  let total = year + "-" + month + "-" + date;
  let attDate = "";
  attDate = $("#attDate").val();
  attDate = attDate.substring(0, 10);
  	$('#attend').on('click', function(){
		if(attDate === total){
			alert("오늘은 이미 출석하셨습니다.");
		}
		else {
			alert("출석체크!");
			$.ajax({
		        type: "POST",
		        url: "../members/attend",
		        data: {
		          userId: $("#loginedId").val(),
		        },
		        dataType: "text",
		        success: function () {
		        	location.reload();
		        },
		        
      		});
		}
	})
  	$('#attend1').on('click', function(){
		if(attDate === total){
			alert("오늘은 이미 출석하셨습니다.");
		}
		else {
			alert("출석체크!");
			$.ajax({
		        type: "POST",
		        url: "../members/attend",
		        data: {
		          userId: $("#loginedId").val(),
		        },
		        dataType: "text",
		        success: function () {
		        	location.reload();
		        },
		        
      		});
		}
	})
  	$('#attend2').on('click', function(){
		if(attDate === total){
			alert("오늘은 이미 출석하셨습니다.");
		}
		else {
			alert("출석체크!");
			$.ajax({
		        type: "POST",
		        url: "../members/attend",
		        data: {
		          userId: $("#loginedId").val(),
		        },
		        dataType: "text",
		        success: function () {
		        	location.reload();
		        },
		        
      		});
		}
	})
  	$('#attend3').on('click', function(){
		if(attDate === total){
			alert("오늘은 이미 출석하셨습니다.");
		}
		else {
			alert("출석체크!");
			$.ajax({
		        type: "POST",
		        url: "../members/attend",
		        data: {
		          userId: $("#loginedId").val(),
		        },
		        dataType: "text",
		        success: function () {
		        	location.reload();
		        },
		        
      		});
		}
	})
});
