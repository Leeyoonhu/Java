$(document).ready(function(){
	$("#deleteImage").on("click", function(){
		if(confirm("댓글을 삭제하시겠습니까?")){
			$.ajax({
				type : "POST",
				url : "./deleteComment.do",
				data : {cNumber : $("#deletecNumber").val()},
				dataType : "text",
				success : function(result){
					console.log(result);
					if(result == 1){
						alert("삭제되었습니다.");
						location.reload();
					}
					
				}
			})
		}
		
	})
})