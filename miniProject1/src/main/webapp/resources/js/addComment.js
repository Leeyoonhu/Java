$(document).ready(function(){
	$("#addComment").on("click", function(){
		let comment = $("textarea[name='comment']").val();
		let number = $("#boardNumber").val();
		let writer = $("input[name='commentWriter']").val();
		
		if(comment == ""){
			alert("내용을 입력하세요");
		}
		else {
			alert("댓글 작성 완료")
			$.ajax({
				type : "POST",
				url : "../comment/insert",
				data : {number: number, writer : writer, comment: comment},
				dataType : "text",
				success : function(){
					location.href = "../board/view?number="+number;
				},
				error : function(){
					location.href = "../board/view?number="+number;
				}
			})
		}
	})
})