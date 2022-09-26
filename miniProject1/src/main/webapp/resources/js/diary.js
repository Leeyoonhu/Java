$(document).ready(function(){
	$("#uploadBtn2").on('click', function(){
		let title = $("input[name='title']").val();
		let content = $("textarea[name='content']").val();
		let writer = $("input[name='writer']").val();
		if(title == ""){
			alert("제목을 입력하세요")
			return false;
		}
		if(content == ""){
			alert("내용을 입력하세요")
			return false;
		}
		if(confirm("일기를 작성하시겠습니까?")){
			$.ajax({
			url: "../board/diaryWrite",
			type: "POST",
			data: {title: title, content: content, writer: writer},
			dataType: "text",
			success: function(){
				alert("글을 등록하였습니다");
				location.href = "../board/diary";
				}
			})
		}
		
	})
})