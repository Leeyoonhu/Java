$(document).ready(function(){
	let img = $("img[name='deleteImage']");
	let delNum = $("input[name='deletecNumber']");
	for(let i = 0; i < img.length; i++){
		$(img[i]).on("click", function(){
		let url = "../board/view?number=" + $("#boardNumber").val();
		if(confirm("댓글을 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			$.ajax({
				type : "POST",
				url : "../comment/delete",
				data : {comNumber : $(delNum[i]).val()},
				dataType : "text",
				success : function(){
					location.href = url;
				},
				error : function(){
					location.href = url;
				}
			})
		}
		
	})
	}
	
})