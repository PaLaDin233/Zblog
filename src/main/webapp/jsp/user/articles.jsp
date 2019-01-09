<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<meta charset="utf-8">
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>

<script type="text/javascript"
	src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>

<!-- 引用 daterangepicker 相关文件-->
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
<script type="text/javascript"
	src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="/Zblog/assets/css/datetimepicker.min.css" rel="stylesheet" />
<script type="text/javascript" src="/Zblog/assets/js/datetimepicker.js"></script>
<script type="text/javascript"
	src="/Zblog/assets/js/datetimepicker.zh-CN.js"></script>


<script type="text/javascript">
	
</script>
<style type="text/css">
/* .panel-heading {
	background: #fffff2;
} */
.panel-title {
	/* 	color: #0c0c0c;*/
	font-size: 20px;
	font-weight: bold;
	font-family: "楷体";
}

#accordion .panel {
	margin-bottom: 15px;
}
</style>
<body>
	<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>
	<div class="container">
		<div class="col-xs-9 col-sm-8 col-md-9 col-lg-9 blog-main">
					<button id="selectAll">全选</button>
			<button id="deleteBtn">删除</button>
			<c:if
				test="${page.getPrev()!=1||page.getNext()!=page.getPageNo()||page.getPageNo()!=1}">
					<div class="col-xs-1"></div>
					<a href="/Zblog/myArticle/page${page.getPrev()}"> <span
						aria-hidden="true">&larr;</span>上一页
					</a> <a href="/Zblog/myArticle/page${page.getNext()}">下一页 <span
						aria-hidden="true">&rarr;</span>
					</a>
			</c:if>
			
			<form id="deleteArticleForm" action="/Zblog/deleteArticle"
				method="post">
				<jsp:include page="/jsp/article/articlelist.jsp"></jsp:include>
			</form>
			<script type="text/javascript">
				var articles = document.getElementsByName("idList");
				var flag=false;
					$("#selectAll").click(function(){
						flag=!flag;
						for (var i = 0; i < articles.length; i++) {
							articles[i].checked = flag;
						}
					});
					$("#deleteBtn").click(function(){
						if(confirm("确定删除吗")){
							$("#deleteArticleForm").submit();
						}
					})
				</script>
		</div>
		<div class="col-xs-3 col-sm-4 col-md-3 col-lg-3 blog-sidebar">
			<jsp:include page="/jsp/baseFrame/SideBar.jsp"></jsp:include>
		</div>


	</div>
</body>
</html>