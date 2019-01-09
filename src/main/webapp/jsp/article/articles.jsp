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


	<div class="container" >
		<div class="row">
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
			<div class="col-xs-2 col-sm-7 col-md-8 col-lg-7 blog-main">
				<!-- 搜索条件框 -->
				<form id="articleSearchFrom" action="/Zblog/findArticles/page1"
					method="post">
					<div class="row">
						<div class="col-xs-4">
							<label>标题</label>
						</div>
						<div class="col-xs-4">
							<label>用户id</label>
						</div>
						<div class="col-xs-4">
							<label>创建日期</label>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-4">
							<input type="text" class="form-control" id="title" name="title"
								value="${searchFrom.title }" placeholder="标题" />
						</div>
						<div class="col-xs-4">
							<input type="text" class="form-control" id="userId" name="userId"
								value="${searchFrom.userId }" placeholder="用户id" />
						</div>
						<div class="col-xs-4">
							 <input class="form-control" type="date" id="datetimepicker"
								name="createTime" value="<fmt:formatDate value="${searchFrom.createTime }"
										pattern="yyyy-MM-dd" />"
								placeholder="创建日期"  autocomplete="off" /> 
						</div>
					</div>
					<div class="row">
						<div class="col-xs-4">
							<label> 按评论数排序: <c:choose>
									<c:when test="${searchFrom.commentNumOrder }">
										<input type="checkbox" id="commentNumOrder"
											name="commentNumOrder" value="true" checked="checked" /></label>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="commentNumOrder"
									name="commentNumOrder" value="true" />
							</c:otherwise>
							</c:choose>
							</label>
						</div>
						<div class="col-xs-4">
							<label> 按浏览数排序: <c:choose>
									<c:when test="${searchFrom.viewsNumOrder }">
										<input type="checkbox" id="viewsNumOrder" name="viewsNumOrder"
											value="true" checked="checked" />
									</c:when>
									<c:otherwise>
										<input type="checkbox" id="viewsNumOrder" name="viewsNumOrder"
											value="true" />
									</c:otherwise>
								</c:choose>
							</label>
						</div>
						<div class="col-xs-4" style="text-align: right; margin-top: 9px;">
							<button type="submit" class="btn btn-default">提交</button>
						</div>
					</div>

				</form>
<!-- 分页导航 -->
		<div class="row" style="padding: 0px;">
			<div class="col-xs-1"></div>
			<div class="col-xs-10">
			
			<nav aria-label="...">
			  <ul class="pager">
			    <li class="previous"><a onclick="pageChange(${page.getPrev()})"><span aria-hidden="true">&larr;</span>上一页</a></li>
			    <li class="next"><a onclick="pageChange(${page.getNext()})">下一页 <span aria-hidden="true">&rarr;</span></a></li>
			  </ul>
			</nav>
				<%-- <ul class="pagination" style="margin: 0px;">
					<c:if test="${page.getPageNo() >1 }">
						<li><a href="#">&laquo;上一页</a></li>
					</c:if>
					<c:if test="${page.getPageNo() <3 }">
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
					</c:if>

					<li><a
						href="http://localhost:9999/Zblog/getUsersArticleList/3/page1">
							&raquo;下一页 </a></li>
				</ul> --%>

			</div>

		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="panel-group" id="accordion">
					<c:forEach items="${page.results }" var="i" varStatus="index">
					
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne${index.count }">
							<div class="panel">
								<div class="panel-heading" style="background: #202020;color: #9d9d9d;">
									<h4 class="panel-title">
										<span class="panel-title">${i.title }&nbsp;</span> <span
											style="float: right; font-size: 5px;"> <fmt:formatDate
												value="${i.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
										</span>
									</h4>
									<div class="article-info" style="text-align: right;">
									浏览:${i.views }
									评论:${i.commentNum }
									
									</div>
									
								</div>

								<div id="collapseOne${index.count }" class="panel-collapse collapse">
									<div class="panel-body">
										<a href="/Zblog/getArticle/aid${i.id }"> 查看详情页 </a>
										<div id="${index.count }" class="article_details">${i.details }</div>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
			</div>
			<div class="col-xs-3 col-sm-4 col-md-3 col-lg-3 blog-sidebar">
				<jsp:include page="/jsp/baseFrame/SideBar.jsp"></jsp:include>
			</div>
		</div>
		
		

	</div>


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