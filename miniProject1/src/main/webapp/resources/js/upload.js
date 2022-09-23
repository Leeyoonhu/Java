$(document).ready(function(){
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	let maxSize = 5242880;
	
	// 모든 조건 통과
	function checkExtension(fileName, fileSize){
		if(fileSize >= maxSize){
			alert("파일 사이즈가 초과하였습니다.(업로드 제한 5MB)");
			return false;
		}
		// 정규식에 맞지 않을 경우
		if(regex.test(fileName)){
			alert("이미지 종류 파일만 업로드 할 수 있습니다.");
			return false;
		}
		return true;
	}
	
	$("#uploadBtn").on("click", function(e){
		let formData = new FormData();
		let writer = $("input[name='writer']").val();
		let title = $("input[name='title']").val();
		let content = $("textarea[name='content']").val();
		let inputFile = $("input[name='uploadFile']");
		let files = inputFile[0].files;
		let boardTitle = $("input[name='boardTitle']").val();
		if(!checkExtension(files.name, files.size)){
			return false;
		}
		formData.append("writer", writer)
		formData.append("title", title)
		formData.append("content", content)
		formData.append("boardTitle", boardTitle)
		if(files[0] != null){
			formData.append("uploadFile", files[0])
				$.ajax({
				url: "../board/uploadAjax",
				type: "POST",
				data: formData,
				processData: false,
				contentType: false,
				success: function(result){
					alert("글을 등록하였습니다");
					location.href = "../board/" + boardTitle;
				}
			})
		}
		else {
				$.ajax({
				url: "../board/uploadAjax2",
				type: "POST",
				data: formData,
				processData: false,
				contentType: false,
				success: function(result){
					alert("글을 등록하였습니다");
					location.href = "../board/" + boardTitle;
				}
			})
		}
		
		
		
	})
	
})