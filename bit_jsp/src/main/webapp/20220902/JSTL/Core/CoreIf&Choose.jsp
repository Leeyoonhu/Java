<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- if 구문과 choose~when~otherwise 구문 -->
<c:set var="num" value="${95 }"></c:set>
점수 : <c:out value="${num }"></c:out>은	<!-- 변수 num에 저장된 값 출력 -->
<c:if test="${num>60}">합격입니다</c:if> <br>	<!-- num이 60이상이면 합격 -->
<c:choose>	
<c:when test="${num >=90 }"> A학점 입니다.</c:when>
<c:when test="${num >=80 }"> B학점 입니다.</c:when>
<c:when test="${num >=70 }"> C학점 입니다.</c:when>
<c:when test="${num >=60 }"> D학점 입니다.</c:when>
<c:otherwise>F학점 입니다.</c:otherwise>
</c:choose>
</body>
</html>