$(document).ready(function(){
	let title = $("#boardTitle").val()
	$("#deleteBoard").on('click', function(){
		if(confirm("정말 삭제하시겠습니까?")){
			alert("삭제 되었습니다.");
			$.ajax({
				type : "post",
				url : "../board/delete",
				data : {number : $("#boardNumber").val(), boardTitle : $("#boardTitle").val()},
				dataType : "text",
				success : function(){
					url = "../board/" + title;
					location.href = url;
				}
			})		
		}
	})
})