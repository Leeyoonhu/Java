<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<%@ page buffer="1kb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out Test</title>
</head>
<body>
<!-- 버퍼 확인하기 -->
<%
	int total = out.getBufferSize();
	out.print("첫번째 텍스트임");
	out.clearBuffer(); // 버퍼의 내용 지움
	out.print("출력 버퍼 크기 : " + total);
	out.print("<br>사용되지 않은 버퍼의 크기 : " +out.getRemaining());
	out.flush();	// 버퍼의 내용 강제 전송
	out.print("<br>flush 후 버퍼의 크기 : " +out.getRemaining());
%>
<h3>out.print()메소드</h3>
<%
	out.print(10);
	out.print(true);
	out.print("aaa");
	out.print('가');
	out.print(new File("/"));
	out.print("버퍼의 크기:" + out.getRemaining());
%>
</body>
</html>