<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.ai.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
request.setCharacterEncoding("utf-8");
Book book = (Book)request.getAttribute("book");
%> --%>
<!-- 가급적이면 화면단에서는 태그를 쓸것 -->
<h2>book ID : ${book.bookId } </h2><br>
<h2>title : ${book.bookName }  </h2><br>
<h2>publisher : ${book.publisher }  </h2><br>
<h2>price : ${book.price }  </h2>
</body>
</html>