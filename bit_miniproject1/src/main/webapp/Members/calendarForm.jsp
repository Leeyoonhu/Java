<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출석 체크</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js'></script>
<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css'rel='stylesheet'/>
<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.print.css' rel='stylesheet' media='print'/>
<script src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js'></script>
<style type="text/css">
#attendancForm {
	display: inline-block;
	float: right;
	width: 1400px;
	height: 1400px;
	margin-top: 200px;
	text-align: center;
}
</style>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	  $('#calendar').fullCalendar({
	    header: {
	      right: 'custom2 prevYear,prev,next,nextYear'
	    },
        // 출첵버튼
	    customButtons: { 
	        custom2: {
	          text: '출석체크하기',
	          id: 'check',
	          click: function() {	
	        	  	// ajax 통신으로 누가 클릭했는지 정보 보내기(누른날 비교해서 하루에 1번 가능하면 1번만)
                    // 클릭하면 calendarController.do 서블릿에 정보보내고, 서블릿에서 db처리
	          }
	        }
	    },
	    eventSources: [
	    	{
				// ajax 통신으로 달력 정보 가져오기 
               // db에서 출석체크 눌렀는지 안눌렀는지 보기 위함
				color: 'purple',   
			 	textColor: 'white' 
	    	}
	    ]
	  }); 
});
</script>
<jsp:include page="./header2.jsp"></jsp:include>
<div id="content">
<jsp:include page="./aside.jsp"></jsp:include>
<div id="attendancForm">
<div id="calendar" style="max-width:900px; margin:40px auto;"></div>
</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>