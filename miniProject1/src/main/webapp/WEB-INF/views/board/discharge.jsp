<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전역일 계산기</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<style type="text/css">
.discharge {
	display: inline-block;
	float: right;
	width: 1300px;
	height: 1200px;
	margin-top: 150px;
	text-align: center;
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
	<!-- aside -->
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
<!-- start body-->
<div class="discharge">
<h1 class="p-3 mb-3 bg-info text-light text-center">전군시 전역 계산기</h1>
    <div class="container">
        <ul class="list-group">
            <li class="list-group-item"><div class="li-div"><span>입영 날짜</span></div><input id="start-day" type="text" placeholder="ex) 2022-09-01" style="text-align: center"></li>
            <li class="list-group-item"><div class="li-div"><span>전역 날짜</span></div><span id="end-day" class="font-weight-bold" style="color: #ff4e1f;"></span></li>
            <li class="list-group-item"><div class="li-div"><span>복무 형태
            <select name = "soldier">
            	<option>육군</option>
            	<option>해군</option>
            	<option>공군</option>
            	<option>해병대</option>
            	<option>의무경찰</option>
            	<option>해양의무경찰</option>
            	<option>의무소방</option>
            	<option>사회복무요원</option>
            </select></span></div>
            </li>
            <li class="list-group-item"><div class="li-div"><button class="dischargeCalc" style="background: black; color: white">계산</button></div></li>
            <li class="list-group-item"><div class="li-div"><span>오늘 날짜</span></div><span id="now-day" class="font-weight-bold"></span></li>
            <li class="list-group-item"><div class="li-div"><span>총 복무일</span></div><span id="total-day" class="font-weight-bold"></span></li>
            <li class="list-group-item"><div class="li-div"><span>남은 시간</span></div><span id="rem-time" class="font-weight-bold"></span></li>
            <li class="list-group-item"><div class="li-div"><span>전역일까지</span></div><span id="rem-day" class="font-weight-bold"></span></li>
            <li class="list-group-item"><div class="li-div"><span>남은 복무 주일</span></div><span id="rem-week" class="font-weight-bold"></span></li>
            <li class="list-group-item">
                <div class="progress">
                    <div id="day-progress" class="progress-bar progress-bar-striped progress-bar-animated bg-info" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
            </li>
            <li class="list-group-item"><div class="li-div"><span>진도율 </span></div><span id="per" class="font-weight-bold"></span></li>
        </ul>
    </div>
    <script type="text/javascript" src="/resources/js/discharge.js"></script>
	<!-- end body-->
</div>
</div>
<%@ include file="../includes/footer.jsp" %>
<!-- end footer -->
</body>
</html>