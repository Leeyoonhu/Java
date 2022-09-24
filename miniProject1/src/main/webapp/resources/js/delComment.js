$(document).ready(function(){
	$("img[name='deleteImage']").on("click", function(){
		let url = "../board/view?number=" + $("#boardNumber").val();
		if(confirm("댓글을 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			$.ajax({
				type : "POST",
				url : "../comment/delete",
				data : {comNumber : $("input[name='deletecNumber']").val()},
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
})