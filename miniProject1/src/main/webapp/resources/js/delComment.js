$(document).ready(function(){
	$("#deleteImage").on("click", function(){
		let url = "../board/view?number="+$("#boardNumber").val();
		if(confirm("댓글을 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			console.log($("#deletecNumber").val());
			$.ajax({
				type : "POST",
				url : "../comment/delete",
				data : {comNumber : $("#deletecNumber").val()},
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