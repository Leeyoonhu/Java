$(document).ready(function(){
	$("#deleteBoard").on('click', function(){
		let boardTitle = $("#boardTitle").val();
		url = boardTitle + "Form.jsp?pages=1";
		if(confirm("정말 삭제하시겠습니까?")){
			$.ajax({
				type : "post",
				url : "./deleteBoard.do",
				data : {number : $("#deleteNumber").val()},
				dataType : "text",
				success : function(result){
					if(result == "true"){
						alert("삭제 되었습니다.");
						location.href = url;
					}
				}
			})		
		}
	})
})