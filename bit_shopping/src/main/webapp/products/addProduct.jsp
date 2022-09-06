<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="./menu.jsp" %>	 <!-- 헤드 배너 -->
<div class="jumbotron">	<!-- 회색배경 -->
	<div class="container">
		<h1 class="display-3">상품 목록</h1>		
	</div>
</div>
<div class="container">
	<form name="newProduct" action="./addProductProc.do" class="form-horizontal" method="POST" enctype="multipart/form-data">
		<div>
			<label class="col-sm2">상품 코드</label>
			<div class="col-sm3">
				<input type="text" id="proId" name="proId" class="form-control">
			</div>
		</div>
		<div>
			<label class="col-sm2">상품 명</label>
			<div class="col-sm3">
				<input type="text" id="proName" name="proName" class="form-control">
			</div>
		</div>
		<div>
			<label class="col-sm2">상품 가격</label>
			<div class="col-sm3">
				<input type="text" id="unitPrice" name="unitPrice" class="form-control">
			</div>
		</div>
		<div>
			<label class="col-sm2">상품 설명</label>
			<div class="col-sm3">
				<textarea rows="" cols="" style="width: 1110px" name="description" id="description"></textarea>
			</div>
		</div>
		<div>
			<label class="col-sm2">제조사</label>
			<div class="col-sm3">
				<input type="text" id="manufacturer" name="manufacturer" class="form-control">
			</div>
		</div>	
		<div>
			<label class="col-sm2">종류</label>
			<div class="col-sm3">
				<input type="text" id="category" name="category" class="form-control">
			</div>
		</div>
		<div>
			<label class="col-sm2">재고수</label>
			<div class="col-sm3">
				<input type="text" id="noOfStock" name="noOfStock" class="form-control">
			</div>
		</div>
		<div>
			<div class="form-group row">
				<label class="col-sm2">이미지</label>
				<div class="col-sm-5">
				<input type="file" id="fileName" name="fileName" class="form-control">
				</div>
			</div>
		</div>
		<br>
		<div class="form-group row">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-primary" value="등록">
			</div>
		</div>
	</form>
</div>
</body>
</html>