<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String type = request.getParameter("type");
	if(type == null){
		return;
	}
%>
<br>
<table border="1" bgcolor="#00cccc">
<tr>
	<td>타입</td>
	<td><b><%=type %></b></td>
</tr>
<tr>
	<td>특징</td>
	<td>
	<%
		if(type.equalsIgnoreCase("A")){%>
			강한 내구성 <% 
		}
		else if (type.equalsIgnoreCase("B")){
		%>	뛰어난 대처능력 <% 
		}%>
	</td>
</tr>
</table>
</body>
</html>