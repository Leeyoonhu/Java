<!DOCTYPE html>
<html lang="en">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<script type="text/javascript"
src="https://code.jquery.com/jquery-3.6.1.js">
</script>
<script type="text/javascript" src="/resources/js/reply.js"></script>
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
<script type="text/javascript">
$(document).ready(function(){
	let operForm = $('#operForm');
	$('button').on('click', function(e){
		e.preventDefault();
		let operation = $(this).data('oper');
	/* button의 data-oper값이 modify인 애를 클릭시에 action="/board/modify" */
		if(operation === 'modify'){
			operForm.attr('action', '/board/modify');
		}
	/* button의 data-oper값이 list인 애를 클릭시에
	id="bno"를 form에서 삭제 하고(bno 파라미터 값이 필요없기때문에)
	action="/board/list"  */
		else if(operation === 'list'){
			operForm.find('#bno').remove();
			operForm.attr('action', '/board/list');
		}
		operForm.submit();
	})
	let bnoValue = '<c:out value="${board.bno}"/>';
	replyService.add(
		{reply: "JS Test", replyer:"tester", bno:bnoValue}, 
		function(result) {
			alert("RESULT: " + result);
		}
	);
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
                            		<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>'>
                            	</div>
                            	<button data-oper="modify" class="btn btn-default">Modify</button>
                            	<button data-oper="list" class="btn btn-default">list</button>
                            	<form id="operForm" action="/board/modify" method="get">
                            		<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'/>
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
