<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.*, com.oreilly.servlet.multipart.*, java.util.*, java.io.*" %>
<!-- 서블릿, 멀티파트, 유틸, io, import하기 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String path = application.getRealPath("/upload");	/* 파일이 저장될 위치(path) 설정.. /은 절대경로임, root 파일에 만들어주어야함 */
	/* 실제 저장 위치 C:/Users/BIT/Desktop/Workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/bit_jsp/upload */
	int size = 1024 * 1024 * 10; /* 10M */
	try {
		MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		/* DefaultFileRenamePolicy() 파일 이름이 중복될 경우 어떻게 할지 정하라(Rename) */
/* 		out.println("사용자의 메시지 : " +request.getParameter("msg")+"<br>"); */
		out.println("사용자의 메시지 : " +multi.getParameter("msg")+"<br>");
		/* MultipartRequest는 request를 녹인 클래스이기 때문에 import 이후 request속성 사용 불가능함 */
		Enumeration en = multi.getFileNames();
		String name = (String)en.nextElement();
		String file = multi.getFilesystemName(name);	/* 시스템 파일 이름 */
		long fileSize = multi.getFile("file").length();
		
		String orgFile = multi.getOriginalFileName(name);	/* 오리지널 파일 이름 */
		String type = multi.getContentType(name);	
		
		out.println("파일명: " + file + "<br>");
		out.println("파일크기: " + fileSize + "<br>");
		out.println("원본파일명: " + orgFile + "<br>");
		out.println("컨텐츠 유형: " + type + "<br>");
	
	} catch (Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>