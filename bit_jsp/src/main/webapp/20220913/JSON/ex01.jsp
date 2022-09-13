<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 공공데이터 포탈(외교부_국가*지역별 여행경보) -->
<script>
      window.onload = function () {
        let request = new XMLHttpRequest();
        request.onreadystatechange = function () {
          if (request.readyState == 4 && request.status == 200) {
            let json = eval("(" + request.responseText + ")");
            let output = "";
            for (i = 0; i < json.data.length; i++) {
              let continent_name = json.data[i].continent_nm;
              let country_name = json.data[i].country_nm;
              let flag_url = json.data[i].flag_download_url;
              let map_url = json.data[i].map_download_url;
              output += "<div>";
              output += "<h2>" + continent_name + "</h2>";
              output += "<h3>" + country_name + "</h3>";
              output +=
                '<img src="' +
                flag_url +
                '"alt="해당 국가 이미지 없음" width="200"/>';
              output += "&nbsp; &nbsp;";
              output +=
                '<img src="' +
                map_url +
                '" alt="해당 국가 이미지 없음" width="200" border="1"/>';
              output += "</div>";
            }
            document.body.innerHTML += output;
          }
        };
        request.open(
          "get",
          "https://apis.data.go.kr/1262000/TravelAlarmService2/getTravelAlarmList2?serviceKey=4jFXJ6t7FNyEQ5xKvZ6OQR19jVuK5Z0%2BC1SWjoJhRVLKIo4ZkyFT5Eox%2BCqB%2BvsKPCwk%2F94qUum0poAaUAH0kQ%3D%3D&returnType=JSON&numOfRows=20&pageNo=1",
          true
        );
        request.send();
      };
    </script>
</body>
</html>