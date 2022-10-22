$(document).ready(function(){
var markers = []
var fNames = []
var clickedOverlay = 0;
var customOverlays = [];
var fNList = document.getElementById('fNList').value;
fNList = fNList.split(",")
var latList = document.getElementById('latList').value;
latList = latList.split(",")
var lonList = document.getElementById('lonList').value;
lonList = lonList.split(",")
var nowlat = document.getElementById('latitude').value; // 위도
var nowlon = document.getElementById('longitude').value; // 경도
var nowfName = document.getElementById('fName').value;
var mapContainer = document.getElementById('map_n'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(nowlat, nowlon), // 지도의 중심좌표
    level: 4 // 지도의 확대 레벨 
}; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
var locPosition = new kakao.maps.LatLng(nowlat, nowlon)
// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
//kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
displayMarker(locPosition);

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition) {
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	var imageSrc2 = "https://i.ibb.co/ky1DywQ/Kakao-Talk-20221019-214448571.png"
	var imageSize = new kakao.maps.Size(24, 35); 
	var imageSize2 = new kakao.maps.Size(44, 44);
	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize)
	var markerImage2 = new kakao.maps.MarkerImage(imageSrc2, imageSize2)
    // 첫 마커를 생성합니다
    var marker = new kakao.maps.Marker({  
        map: map, 
        position: locPosition,
        image : markerImage
    }); 
   	
    
    for(var i = 0; i < lonList.length; i++){
		var fName = fNList[i].replace("[","")
		fName = fName.replace("]","")
		fName = fName.trim();
    	var lat2 = latList[i].replace("[","");
    	lat2 = lat2.replace("]","")
    	lat2 = parseFloat(lat2)// 위도
       	var lon2 = lonList[i].replace("[",""); 
       	lon2 = lon2.replace("]","")
       	lon2 = parseFloat(lon2)// 경도
        var locPosition2 = new kakao.maps.LatLng(lat2, lon2);
    	if(nowlat != lat2 && nowlon != lon2){
				var marker2 = new kakao.maps.Marker({
				map: map,
				position: locPosition2,
				image: markerImage2,
				text: fName
			})
			markers[i] = marker2.getPosition().getLat().toString() + ", " + marker2.getPosition().getLng().toString()
			fNames[i] = fName
		
			kakao.maps.event.addListener(marker2, 'mouseover', showInfo(marker2, map));	
	 		kakao.maps.event.addListener(map, 'zoom_changed', function(){
				for(var j = 0; j < customOverlays.length; j++){
					customOverlays.pop().setMap(null)
				}
			});
		}
    }
	
    map.setCenter(locPosition);
}

function showInfo(marker, map){
	return function(){
		var str = marker.getPosition().getLat().toString() + ", " + marker.getPosition().getLng().toString()
		var content = '<div class="overlaybox"><ul>'
		for(var k = 0; k < markers.length; k++){
			if(markers[k] == str){
				if(content == ""){
					content = '<li class="up"><a href="/field/click?fName=' + fNames[k] + '"><span class="title">' + fNames[k] + '</span></a></li>'
				}
				else {
					content = content +'<li class="up"><a href="/field/click?fName=' + fNames[k] + '"><span class="title">' + fNames[k] + '</span></a></li>'
				}
			}
		}
		content = content + "</ul></div>"
		var locPosition3 = new kakao.maps.LatLng(marker.getPosition().getLat(), marker.getPosition().getLng())
		var customOverlay = new kakao.maps.CustomOverlay({
   			position: locPosition3,
   			content: content,
   			zIndex: 1,
   			clickable: false
		}); 
		if(map.getLevel() < 9){
        	customOverlay.setMap(map, marker);
        }
        if(customOverlays.length < 1){
        	customOverlays.push(customOverlay)
		}
		else {
			for(var i = 0; i < customOverlays.length; i++){
				customOverlays.pop().setMap(null)
			}
			customOverlays.push(customOverlay)
		}
		console.log(customOverlays.length)
		return customOverlays
	}
}	

})