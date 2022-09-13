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
      let request;
      function sendInfo() {
        let v = document.vinform.t1.value;
        // form = "vinform"의 name="t1"요소 값 == v
        let url = "index.jsp?val=" + v;
        if (window.XMLHttpRequest) {
          request = new XMLHttpRequest();
        }
        try {
          request.onreadystatechange = getInfo;
          /* url일때의 값을 method="get" */
          request.open("get", url, true);
          request.send();
        } catch (e) {
          alert("Unable to connect to server(서버에 연결할 수 없음)");
        }
      }
      function getInfo() {
        if (request.readyState == 4) {
          let val = request.responseText;
          // 가져온 텍스트값
          document.getElementById("info").innerHTML = val;
          // id="info"태그의 HTML에 inner
        }
      }
    </script>
    <marquee behavior="" direction="">
      <h1>This is an example of Ajax</h1>
    </marquee>
    <form action="" name="vinform">
      <input type="text" name="t1" />
      <input type="button" value="ShowTable" onclick="sendInfo()" />
    </form>
    <span id="info"></span>
</body>
</html>