<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
		file upload 
web browser에서 server로 file을 전송하여 server에 저장

ㅁ 서버로 업로드 할 수 있는 파일
- text, bin, img, 문서...etc

ㅁ web > server로 파일 전송위해 jsp에 form태그를 사용 >> 반드시 method= post

ㅁ 오픈 라이브러리를 이용 >> cos.jar
- http://www.servlets.com/cos/ 
- lib안에 cos.jar를 복사해서 WEB-INF안의 lib에 jar파일 삽입
- 해당 jar파일 안에 MultipartRequest 클래스가 있음

ㅁ MultipartRequest
- multipart/form-data 유형 // post 방식의 요청 파라미터를 분석 후 일반데이터인지 파일데이터인지 구분하여 파일데이터로 접근
form.. enctype="multipart/form-data" method = "post"
- 장점 : 한글 인코딩 값을 얻기 쉽고, 서버의 파일 저장 폴더에 동일 파일명 있으면 파일명을 자동으로 변경해 줌

getFileSystemNames(str) ==> 서버에 실제로 업로드 된 파일명을 반환
getOriginalFileName(str) ==> 업로드 한 실제 파일명

-->
</body>
</html>