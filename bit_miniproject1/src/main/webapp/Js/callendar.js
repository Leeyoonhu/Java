$(document).ready(function () {
  let today = new Date();
  let year = today.getFullYear(); 
  let month = today.getMonth() + 1; 
  if (month < 10) {
    month = "0" + month;
  }
  let date = today.getDate(); 
  let total = year + "-" + month + "-" + date;

  $("#calendar").fullCalendar({
    header: {
      right: "custom2 prevYear,prev,next,nextYear",
    },

    customButtons: {
      custom2: {
        text: "출석체크하기",
        id: "check",
        click: function () {
			$('td[class=*today]').css(
				color = "red"
			)
          $.ajax({
            type: "POST",
            url: "./calendarController.do",
            data: {
              userId: $("#userId").val(),
              attDate: total,
            },
            dataType: "text",
            success: function (result) {
              if (result == "checked") {
                alert("오늘은 이미 출석하셨습니다.");
              } else {
                alert("출석 했드아");
              }
            },
          });
        },
      },
    },
  });
});
