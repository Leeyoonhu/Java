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
Servlet - 인터페이스

GenericServlet - 인터페이스 상속받은 클래스

		1. Servlet 매핑
	servlet 을 실행시키려면 WEB-INF -> web.xml에 가서 URL 매핑 해줘야함
	1. servlet 태그로 servlet 클래스의 위치와 이름 지정
	2. servlet-mapping 태그로 servlet 이름에 url-pattern 부여
	http://서버주소: 포트번호 / 웹 애플리케이션 이름을 생략한 root '/'
	ex) url-pattern => /hello
	
	url 패턴을 실행하면 생성한 Servlet에서 정의된 메서드 들이 실행하게끔 매핑(key-value)
	매핑하는 이유는 직접적인 폴더 위치를 노출시키지 않기 위해서
	
	
		2. @ (annotation)
	직접 web.xml에 매핑하지 않고, Servlet내에서 mapping(key-value)
	소스 안에 @ 기호와 함께 사용
	@WebServlet(접근 시 사용할 URI 지정)
	@SuppressWarnings => 컴파일러 경고 무시
	
	initParams = > web.xml에 context.param 추가한것과 동일
-->
</body>
</html>