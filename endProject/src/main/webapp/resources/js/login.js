$(document).ready(function(){
	
	$("#kakao").on('click', function(){
		document.cookie = "platform = kakao";
		location.href = "https://kauth.kakao.com/oauth/authorize?client_id=d23a3184f03474573dded85b7450aa27&redirect_uri=http://localhost:8080/login&response_type=code";
	})
	
	$("#naver").on('click', function(){
		document.cookie = "platform = naver";
		location.href = $("#naverURL").val();
	})
	
})