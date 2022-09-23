<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.1.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<nav aria-label="...">
		<ul class="pagination">
			<li class="page-item disabled"><a class="page-link" href="#"
				tabindex="-1">Previous</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item active"><a class="page-link" href="#">2
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>


		<table class="table talbe-striped"
			style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr style="height: 52px">
					<th
						style="background-color: #C8E6A8; text-align: center; width: 80px">글번호</th>
					<th
						style="background-color: #C8E6A8; text-align: center; width: 80px">
						<img alt=""
						src="https://i.ibb.co/yQ8yXZM/icons8-noticeboard-48.png"
						width="24px" height="24px">
					</th>
					<th
						style="background-color: #C8E6A8; text-align: center; width: 700px">제목</th>
					<th
						style="background-color: #C8E6A8; text-align: center; width: 200px">닉네임</th>
					<th
						style="background-color: #C8E6A8; text-align: center; width: 200px">등록일</th>
					<th
						style="background-color: #C8E6A8; text-align: center; width: 100px">조회</th>
					<th
						style="background-color: #C8E6A8; text-align: center; width: 100px">추천</th>
				</tr>
			</thead>

			<%!int count = 0;%>
BLIST : ${bList}
			<c:forEach var="item" items="${bList}">
				<tr style="text-align: center; height: 52px" class="boardElement">
					<td>${item.number}</td>

					<td>${item.title}</td>
					<td> ${item.writer}</td>
					<td><fmt:formatDate value="${item.regDate}"
							pattern="yyyy-MM-dd" /></td>
					<td>${item.views}</td>
					<td>${item.recommends}</td>
				</tr>
			</c:forEach>
		</table>

		<!-- //active 처리 -->
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="page-item"><a class="page-link"
					href="${pageMaker.startPage-1}">Previous</a></li>
			</c:if>
			<c:forEach var="num" begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }">
				<li class="page-item ${pageMaker.cri.pageNum==num?"active":"" }"><a
					class="page-link" href="${num}">${num}</a></li>
			</c:forEach>
			<c:if test="${pageMaker.next}">
				<li class="page-item"><a class="page-link"
					href="${pageMaker.endPage+1 }">Next</a></li>
			</c:if>
		</ul>

		<form id='actionForm' action="/board/test" method='get'>
			<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
			<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
		</form>


	</nav>
	<script>
$(document).ready(function(){
	var actionForm = $("#actionForm");
	$(".page-item a").on("click", function(e) {
	   e.preventDefault();
	   console.log('click');
	   actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	actionForm.submit();
	});

});

</script>
</body>
</html>