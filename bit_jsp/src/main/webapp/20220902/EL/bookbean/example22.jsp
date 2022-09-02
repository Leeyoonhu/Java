<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page import="org.ai.beans.*" %>
<!-- 자바 빈즈 사용할것임(jsp 문법으로) -->
<jsp:useBean class="org.ai.beans.Bookbean" id="book"></jsp:useBean>	<!-- Bookbean book = new BookBean() -->
<!-- book.title = null; book.author = null; book.publisher = null; -->
<jsp:setProperty property="*" name="book" />	<!-- book객체의 모든 속성 가져옴 -->
<!-- book.setTitle(title), book.setAuthor(author), book.setPublisher(publisher) 상태임 -->
<!-- book.title = "입력값"; book.author = "입력값"; book.publisher = "입력값";  -->
<%
	request.setAttribute("book", book);	/* attribute에 book객체의 속성들 set */
	/* HttpServletRequest에 "book"이 set됨  */
%>
<jsp:forward page="./bookOutput.jsp"></jsp:forward>	<!-- 그 후에 bookOutput.jsp에 보냄 -->
</body>
</html>