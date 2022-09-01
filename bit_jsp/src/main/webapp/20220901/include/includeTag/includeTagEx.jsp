<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- action 했을 때 지정한 위치의 jsp가 include하고있다면,
출력문에는 현재 jsp, action 후 jsp만 출력되지않고
action 후 jsp가 포함하고있는 내용들도 포함해서 출력된다 -->
	<form action="./includeTag.jsp" method="post">
		이름 : <input type="text" name="name">
		<p>
		<input type="submit" value="보내기">
	</form>
</body>
</html>