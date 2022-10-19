$(document).ready(function(){
var lat = document.getElementById('latitude').value; // 위도
var lon = document.getElementById('longitude').value; // 경도

console.log(lat)
console.log(lon)		
	var mapContainer = document.getElementById('map_n'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(parseFloat(lat), parseFloat(lon)), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨 
    }; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
    
    var locPosition = new kakao.maps.LatLng(parseFloat(lat), parseFloat(lon));
    displayMarker(locPosition);


// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition) {

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + locPosition + '</div>');
        infowindow.open(map, marker);
    });
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}    
	
})