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
        window.onload = function (){
            let request = new XMLHttpRequest();
            request.onreadystatechange = function(){
                if(request.readyState == 4 & request.status == 200){
                    let parser = new DOMParser(); // XML을 읽어오는 객체
                    let xml = parser.parseFromString(request.responseText, 'application/xml');
                    // 가져올 속성 배열로 저장
                    let banNotes = xml.getElementsByTagName("banNote");
                    let countryNames = xml.getElementsByTagName("countryName");
                    let imgUrls = xml.getElementsByTagName("imgUrl");
                    for(let i = 0; i < banNotes.length; i++){
                        // 배열에서 요소들 저장 후 출력
                        let banNote = banNotes[i].textContent;
                        let countryName = countryNames[i].textContent;
                        let imgUrl = imgUrls[i].textContent;
                        document.body.innerHTML += "<p>" + banNote + "&nbsp&nbsp&nbsp&nbsp" + countryName;
                        document.body.innerHTML += '<img src="'+imgUrl+'" alt ="해당 국가 이미지 없음" width="100"/></p>'
                    }
                }
            }
            request.open("get","https://apis.data.go.kr/1262000/TravelBanService/getTravelBanList?serviceKey=4jFXJ6t7FNyEQ5xKvZ6OQR19jVuK5Z0%2BC1SWjoJhRVLKIo4ZkyFT5Eox%2BCqB%2BvsKPCwk%2F94qUum0poAaUAH0kQ%3D%3D&numOfRows=10&pageNo=1", true);
            request.send();
        };
    </script>
</body>
</html>