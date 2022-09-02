<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- MultipartRequest 예제 -->
<form action="uploadProc.jsp" method="post" enctype="multipart/form-data">
	<input type="text" name="msg"> <p></p>
	<input type="file" name="file"> <p></p>
	<input type="submit" value="파일 업로드">
</form>
</body>
</html>