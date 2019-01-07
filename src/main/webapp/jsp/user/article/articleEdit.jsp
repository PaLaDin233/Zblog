<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8">
<title>Z.Blog！</title>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<script src='/Zblog/assets/js/request.js'></script>
<script src='/Zblog/assets/js/marked.js'></script>
<script type="text/javascript"
	src="/Zblog/assets/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="/Zblog/assets/ueditor/ueditor.all.js"></script>
<link
	href="http://cdn.bootcss.com/highlight.js/8.0/styles/monokai_sublime.min.css"
	rel="stylesheet">
<script src="http://cdn.bootcss.com/highlight.js/8.0/highlight.min.js"></script>
<style type="text/css">
</style>
<body>
	<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="article-content col-xs-12">
				<form id="actionform" method="post"
					action="/Zblog/editArticle${article.id }">
					<div class="form-group">
					<div class="article-title">
					<label for="title" class="control-label">博文标题:</label>
						<input id="title" class="form-control" type="text" name="title" value="${article.title }" /> 
						     
					</div>
					<label for="title" class="control-label">博文内容：</label>
					
					<div id="artile-datails">
						<textarea id="view_content" name="details" rows="5" data-required
							data-describedby="message" data-description="content">${article.details }</textarea>
						<button class="btn btn-default" id="submit">提交</button>
						     

					</div>
					</div>
				</form>
			</div>

		</div>
	</div>


	<script type="text/javascript">
		function setContent(content) {
			if (content != null && content.length > 0) {
				if (mblog.browser.ios || mblog.browser.android) {
					$('#view_content').text(content);
				} else {
					UE.getEditor('view_content').setContent(content);
				}
			}
		}

		$(function() {
			var ueditor = UE.getEditor('view_content', {
				fastUpload : "/Zblog/aj_um_upload.json",
				fastFileName : 'upfile',
				fastUrlPrefix : '/Zblog',
				wordCount : true,
				maximumWords : 2000,
				initialFrameWidth : '100%',
				initialFrameHeight : 300
			});
		})
	</script>



</body>

<script>
</script>
</html>