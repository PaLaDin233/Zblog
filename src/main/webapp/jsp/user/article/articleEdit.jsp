<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="xyz.zhhg.zblog.web.pojo.Paging"%>
<%@ page import="xyz.zhhg.zblog.web.pojo.Article"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8">
<title>Z.Blog！</title>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<script src='/Zblog/assets/js/request.js'></script>
<script src='/Zblog/assets/js/marked.js'></script>
<script type="text/javascript" src="/Zblog/assets/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/Zblog/assets/ueditor/ueditor.all.js"></script>
<link
	href="http://cdn.bootcss.com/highlight.js/8.0/styles/monokai_sublime.min.css"
	rel="stylesheet">
<script src="http://cdn.bootcss.com/highlight.js/8.0/highlight.min.js"></script>
<script>
	hljs.initHighlightingOnLoad();
</script>
<style type="text/css">
</style>
<body>
	<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="article-content col-xs-12">
			<form id="actionform" method="post" action="/Zblog/saveArticle">
				<input name="id" type="hidden" value="${article.id }" />
				<div class="article-title">
				 博文标题:<input type="text" name="title" value="${article.title }" />       
				</div>
				博文内容：
				<div id="artile-datails">
						<textarea id="details" style="width: 100%" name="details"></textarea>
						   
						<button class="btn btn-default" id="submit">提交</button>     
					</form>
				</div>
			</div>

		</div>
	</div>

</body>

<script>
	var ue = UE.getEditor('details');
	$("#actionform").submit(function() {
		var html = ue.getContent();
		//获取纯文本内容，返回: hello
		var txt = ue.getContentTxt();
		ue.execCommand('serverparam', {
			'titls' : 'a',
			'details' : html
		});
	});
	$("#submit").onclick(function (){
		
		alert("a");
	})
</script>
</html>