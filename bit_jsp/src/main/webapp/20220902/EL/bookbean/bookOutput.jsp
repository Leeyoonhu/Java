<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이전에 book이라는 속성에 set했기때문에 book에 있는 속성으로 가져올 예정임 -->

책 제목 : ${book.title}<br>
<%-- <%=((Bookbean)request.getAttribute(title)%> --%>
책 저자 : ${book.author}<br>
출판사 : ${book.publisher}
</body>
</html>