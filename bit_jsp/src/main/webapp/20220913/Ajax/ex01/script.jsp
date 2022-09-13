<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
        function getFromServer(){
            let request;
            if(window.XMLHttpRequest){
                request = new XMLHttpRequest();
            }
			
            request.onreadystatechange = function(){
                if(request.readyState == 4 && request.status == 200){
                    document.getElementById("target").innerHTML = request.responseText;
                }
       
            }
            request.open("POST", "./data.html", false);
            request.send();
        }
    </script>
    <div id="target" style="width: 500px; height: 500px; border: solid;"></div>
    <button type="button" onclick="getFromServer()">GET DATA</button>
</body>
</html>