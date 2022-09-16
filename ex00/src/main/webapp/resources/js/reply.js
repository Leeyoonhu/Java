/**
 * 모듈화 준비 (p399, 406)
 * get.jsp 에서 쓸거임
 */
 let replyService=(function(){
	// ajax처리 후 동작해야 하는 함수 add
	// ajax로 ReplyController 호출
	function add(reply, callback, error){
		console.log("reply...");
		$.ajax({
			type:'post',
			url:'/replies/new',
			data: JSON.stringify(reply),
			contentType: 'application/json; charset=utf-8',
			success: function(result, status, xhr){
				if(callback){
					callback(result);
				}	
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})
	}
	// module pattern으로 외부에 노출하는 정보
	return {
		add: add
	};
})();

 