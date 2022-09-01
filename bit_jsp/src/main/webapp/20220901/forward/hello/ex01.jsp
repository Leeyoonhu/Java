<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-02</title>
</head>
<body>
<form action="./ex01.jsp" method="post">
<!-- 입력 양식을 통해 전달받은 요청 페이지로 forward하여 이동 -->
이동하고 싶은 페이지 <input type="text" name="go">
<input type="submit" value="이동">
</form>
</body>
</html>