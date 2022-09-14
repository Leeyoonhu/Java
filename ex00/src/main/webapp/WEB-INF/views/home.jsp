<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- HomeController.java에서 넘겨준 serverTime 을 EL tag로 소환 -->
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
