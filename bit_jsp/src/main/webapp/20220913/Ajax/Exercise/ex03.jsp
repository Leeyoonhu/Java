<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- book table에 있는 도서검색 프로그램 작성 -->
<!-- Keyup event를 활용하여 아이디를 입력하면 바로 화면에 검사 결과 출력 -->
<!-- db조회해서 출력문 가져옴 -->
	<script>
        let request;
        function sendInfo(){
            let bookId = document.bookForm.bookId.value;
            let url = "book.jsp?bookId=" + bookId;
            if(window.XMLHttpRequest){
                request = new XMLHttpRequest();
            }
            try {
                request.onreadystatechange = getInfo;
                request.open("get", url, true);
                request.send();
            } catch(e){
                alert("서버에 연결 할 수 없음");
            }
        }
        function getInfo(){
            if(request.readyState == 4){
                let bookInfo = request.responseText;
                document.getElementById("info").innerHTML = bookInfo;
            }
        }
    </script>
	<marquee>
      <h1>This is an example of Ajax</h1>
    </marquee>
    <form name="bookForm">
      book ID : <input type="text" name="bookId" onkeyup="sendInfo()"/>
    </form>
    <hr>
    <span id="info"></span>
</body>
</html>