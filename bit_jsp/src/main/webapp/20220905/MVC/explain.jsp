<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 패턴 구성 요소 (mvc)
	Model
	view 
	controller

	여태 만들었던 JSP는 모델1이 될 수 있음
	장점 : 구조가 단순하여 구현 용이
	개발 초기에 복잡한 설정 필요x
	
	단점 : 출력을 위한 view, logic처리를 위한 java(controller)가 섞여있어 분업이 어려움
	코드가 복잡하여 유지 보수가 어려움
	
	MVC 모델1 
	예제)
	body 라인에서 작성하던 내용들을 head에 몰아서 body 라인에는 출력만 담당하게 함
	이럴 경우 head에 controller, body에는 view 가 있는 것
	
	MVC 모델2
	예제)
	Servlet이 controller(Process 역할)을 하고, view 를 jsp가 맡아 담당
	장점 : 모델1보다 간결,
	view, model 분업 처리에 용이
	기능에 따라 분리가 되어있어서 유지 보스가 상대적 용이
	확장이 용이
	
	단점 : 구조가 복잡하여 습득이 어려움
	개발 초기에 설정 부분이 많아서 실질적인 작업을 시작하기까지 시간이 걸림
	코드가 분리됨으로써 관리해야할 파일이 많아짐
 -->
</body>
</html>