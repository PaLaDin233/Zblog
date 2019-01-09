<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<!-- head部分 -->
<head>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<style type="text/css">
#Idcheckbox >*{
	display: none;
}
</style>
</head>
<body>
	<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>
	<div class="container">

		<div class="row">
			<div class="col-xs-9 col-sm-8 col-md-9 col-lg-9 blog-main">
				<jsp:include page="/jsp/article/articlelist.jsp"></jsp:include>
			</div>

			<div class="col-xs-3 col-sm-4 col-md-3 col-lg-3 blog-sidebar">
				<jsp:include page="/jsp/baseFrame/SideBar.jsp"></jsp:include>
			</div>
			</div>
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
	<jsp:include page="jsp/baseFrame/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	 //设置第一篇文章展开
	$("#collapseOne1").attr("class","panel-collapse collapse in");
	function pageChange(a){
		var newUrl = '/Zblog/findArticles/page'+a;    //设置新提交地址
        $("#articleSearchFrom").attr('action',newUrl);    //通过jquery为action属性赋值
        $("#articleSearchFrom").submit();    //提交ID为myform的表单
	};
	/*
	$('#datetimepicker').datetimepicker({
		format : 'yyyy-MM-dd',
		autoclose : true,
		language : 'zh-CN',
	}); */
</script>
</html>