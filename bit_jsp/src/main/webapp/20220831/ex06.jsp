<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 Ex01</title>
</head>
<body>
<!-- 내장 객체의 종류 -->
<!-- out,config,exception,response, request ... -->
<!-- session ==> html 은 request -> response 를 거치면서 저장하지 않는데,  -->
<!-- login을 했음 같은 알고있어야 하는 사항이 있을경우는 세션(session)을 이용해서 -->
<!-- 저장하게끔 처리해줘야함 -->

<!-- 속성 처리 메소드의 종류 -->
<!-- setAttribute(String name, Object value) // 객체 이름 name, 속성값 value -->
<!-- getAttribute(String name) // 객체 이름(속성)이 name 속성값을 가져옴 -->
<!-- removeAttribute(String name) // 객체 이름 값이 name 인 애를 삭제 -->
<!-- getAttributeNames() // 모든 속성의 이름을 가져옴 -->

<!-- request 내장 객체 -->
<!-- form에서 가져오는 값들이 parameter이고, parameter는 name과 value를 함께 가져옴 -->
<!-- request 메소드 -->
<!-- 1. 이름을 알고 있을때 -->
<!-- getParameter(String name) // 요청 파라미터의 이름이 name인 값을 전달받음 -->
<!-- getParameterValues(String name) // 패러미터 이름이 name인 값을 배열형태로 전달 -->
<!-- 2. 이름을 조회할 때 -->


</body>
</html>