<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex11-12/12</title>
</head>
<body>
	<p>클라이언트 IP:</p><%=request.getRemoteAddr()%>
	<p>요청 정보 길이</p><%=request.getContentLength() %>
	<p>요청 정보 인코딩</p><%=request.getCharacterEncoding() %>
	<p>요청 정보 콘텐츠 유형</p><%=request.getContentType() %>
	<p>요청 정보 프로토콜</p><%=request.getProtocol() %>
	<p>요청 정보 전송방식</p><%=request.getMethod() %>
	<p>요청 URI</p><%=request.getRequestURI() %>
	<p>콘텍스트 경로</p><%=request.getContextPath() %>
	<p>서버이름</p><%=request.getServerName() %>
	<p>서버포트</p><%=request.getServerPort() %>
	<p>쿼리문</p><%=request.getQueryString() %>
</body>
</html>