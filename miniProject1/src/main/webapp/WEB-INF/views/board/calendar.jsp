<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'/>
    <link href='/resources/css/calendar.css' rel='stylesheet' />
    <script src='/resources/js/calendar.js'></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <script>
    document.addEventListener("DOMContentLoaded", function () {
    	  let today = new Date();
    	  let year = today.getFullYear();
    	  let month = today.getMonth() + 1;
    	  if (month < 10) {
    	    month = "0" + month;
    	  }
    	  let date = today.getDate();
    	  let total = year + "-" + month + "-" + date;

    	  var calendarEl = document.getElementById("calendar");
    	  var calendar = new FullCalendar.Calendar(calendarEl, {
    	    customButtons: {
    	      myCustomButton: {
    	        text: "custom!",
    	        click: function () {
    	          alert("clicked the custom button!");
    	        },
    	      },
    	    },
    	  });
    	  calendar.render();
    	});

    </script>
    <script type="text/javascript" src="/resources/js/calendar2.js"></script>
    <style type="text/css">
	    #attendancForm {
			display: inline-block;
			float: right;
			width: 1400px;
			height: 1200px;	
			margin-top: 150px;
			text-align: center;
		}
	</style>
</head>
<body>
<!-- header -->
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/header.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="../includes/header2.jsp" %>
	</c:otherwise>
</c:choose>
	<div id="content">
<c:choose>
	<c:when test="${empty userInfo.userId}">
		<%@ include file="../includes/aside.jsp" %>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${userInfo.userJob eq 'soldier'}">
				<%@include file="../includes/aside3.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="../includes/aside2.jsp" %>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
  	<div id="attendancForm">
	<div id='calendar' style="width: 1000px; height: 800px;" >
	
	</div>
	</div>
	</div>
	<%@ include file="../includes/footer.jsp" %>
</body>
</html>