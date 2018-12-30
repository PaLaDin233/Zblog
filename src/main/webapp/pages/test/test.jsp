<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", basePath);
%>
<html>
<head>
<jsp:include page="/jsp/baseFrame/head.jsp" />
<script type="text/javascript" src="/Zblog/assets/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/Zblog/assets/ueditor/ueditor.all.js"></script>

</head>
<body>
	<div>       
		<form id="actionform" method="post" action="/Zblog/test">    
			<input type="text" name="articleTitle"/>       
			<textarea id="details" style="width: 100%"></textarea> 
   			<button class="" id="test">测试</button>  
			<input type="submit" value="提交"/>       
		</form> 
		
		<!-- 查询文章条件测试表单 -->
		<form id="f1" action="/Zblog/findArticles/page1" method="post">
			<input type="text" name="title"/>
			<input type="text" name="userId" /> 	
			<input type="submit" value="查询"/>
		</form>
	</div>
</body>

<script>
    var ue=UE.getEditor('details');
    $("#actionform").submit(function(){
    	var html = ue.getContent();
        //获取纯文本内容，返回: hello
        var txt = ue.getContentTxt();
        ue.execCommand('serverparam', {
        	'titls':'a',
            'details': html
        });
    });
</script>
</html>
