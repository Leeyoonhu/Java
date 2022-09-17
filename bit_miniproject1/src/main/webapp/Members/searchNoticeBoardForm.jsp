<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function checkContent(){
		let form = document.searchForm;
		if(form.content.value == ""){
			alert("검색하실 내용을 입력해주세요.");
		}
		else {
			form.submit();
		}
	}
</script>
<div style="height: 36px">
<form action="./searchNoticeBoard.do" method="post" style="text-align: center;" name = "searchForm">
<select name="searchTitle" style="padding-left: 5px; width: 120px; height: 38px;  box-sizing: border-box; border: 1px solid #ccc;">
	<option selected="selected">제목</option>
	<option>닉네임</option>
</select>
<input type="text" name="content" style="padding: 0px 5px; width: 400px; height: 38px; box-sizing: border-box; border: 1px solid #ccc; padding-left: 6px">
<button type="button" style=" 
	width: 60px;
    height: 38px;
    border: 1px solid #ccc;
    box-sizing: border-box;
    background: url(https://i.ibb.co/q1QvKRf/image.png) no-repeat;
    background-position:center;
    cursor: pointer;
    padding: 0px 6px;
    "
    onclick="checkContent()">&nbsp;</button>
</form>
</div>
</body>
</html>