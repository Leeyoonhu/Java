<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward-a-b-o</title>
</head>
<body>
	<h3>Forward Tag Example</h3>
	<form action="./forwardRequest.jsp" method = "post">
	<p>당신의 혈액형은?</p>
	<input type="radio" name="bloodType" value="a"> A형 <br>
	<input type="radio" name="bloodType" value="b"> B형 <br>
	<input type="radio" name="bloodType" value="o"> O형 <br>
	<input type="radio" name="bloodType" value="ab"> AB형 <br>
	<input type="submit" value="보내기">
	</form>
</body>
</html>