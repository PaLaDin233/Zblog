<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="xyz.zhhg.zblog.web.pojo.Paging"%>
<%@ page import="xyz.zhhg.zblog.web.pojo.Article"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8">
<!-- TemplateBeginEditable name="doctitle" -->
<title>Z.Blog！</title>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<script src='/Zblog/assets/epiceditor/js/epiceditor.min.js'></script>
<script src='/Zblog/assets/js/request.js'></script>
<script src='/Zblog/assets/js/marked.js'></script>
<script type="text/javascript">
	function submit() {
		//获取编辑器内容
		var details = editor.getElement('editor').body.innerHTML;
		//提交到服务器
		//ajax提交
		//$.post("../hi.do",{"str":details});

		//普通提交
		post("../saveArticle.do", {
			"details" : details,
			"title" : "测试标题",
			"userId" : "3"
		});

	}
</script>
<body>
<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>
	<div class="content">

		<c:forEach items="${page.results }" var="i">
			<div class="article_id">
				博文id：<c:out value="${i.id }"/>
			</div>
			<div class="article_title">
				博文标题<c:out value="${i.title }" />
			</div>
			博文内容：
			<div id="${i.id }" class="article_details" onshow="fun()">
				${i.details }<%-- <c:out value="${i.details }" /> --%>
			</div>
			<button onclick="fun(${i.id })"></button>
		</c:forEach>
	</div>

</body>

<script>
function fun(a){
	var text=document.getElementById(a).innerHTML;
	//'# Marked in browser\n\nRendeedBy **marked**.`'
	document.getElementById(a).innerHTML=marked(text);
	/* var markdown=$("#content").html;
	$("#1").html(marked("#aasd  ")); */
}
	/*  $(".article_details").onload */
	/*$(document).ready(function(){
		alert($(".article_details").html);
	}); */
</script>
</html>