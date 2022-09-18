<!DOCTYPE html>
<html lang="en">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<script type="text/javascript"
src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<!-- remove, list로 가기위해 js로 function() 구현 -->
<script type="text/javascript">
	$(document).ready(function(){
		let formObj = $('form');
		$('button').on('click', function(e) {
			e.preventDefault();
			// button 태그의 data-oper인 애들의 값을 operation에 정의
			let operation = $(this).data('oper');
			console.log(operation);
			// 누른 button 태그의 data-oper가 remove일 경우
			if(operation === 'remove'){
				/* form 의 action="/board/remove"로 변경 */
				formObj.attr('action', '/board/remove');
			}
			// 누른 button 태그의 data-oper가 list일 경우
			else if(operation === 'list'){
				/* form 의 action="/board/list"로 변경 */
				formObj.attr('action', '/board/list');
				formObj.attr('method', 'get');
			}
			/* action 실행 */
			formObj.submit();
		})
	})
</script>
<jsp:include page="../includes/header.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board register</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시글 조회
                            <!-- 조회는 get방식 -->
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form role="form" action="/board/modify" method="post">
                        	
                            	<div class="form-group">
                            		<label>Bno</label>
                            		<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly"/>
                            	</div>
                            	<div class="form-group">
                            		<label>Title</label>
                            		<input class="form-control" name="title" value='<c:out value="${board.title}"/>'/>
                            	</div>
                            	<div class="form-group">
                            		<label>Content</label>
                            		<textarea class="form-control" rows="3" name="content"><c:out value="${board.content}"/></textarea>
                            	</div>
                            	<div class="form-group">
                            		<label>Writer</label>
                            		<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly="readonly">
                            	</div>
                            	<div class="form-group">
                            		<label>RegDate</label>
                            		<input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regDate}"/>' readonly="readonly">
                            	</div>
                            	<div class="form-group">
                            		<label>Update Date</label>
                            		<input class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>' readonly="readonly">
                            	</div>
                            	<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
                            	<button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
                            	<button type="submit" data-oper="list" class="btn btn-info" onclick="location.href='/board/list'">list</button>
                        </form>
                        </div>
                        <!-- end panel-body -->
                    </div>
                    <!-- end panel-body -->
                </div>
                <!-- end panel -->
        	</div>
        <!-- /.row -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>

</html>
