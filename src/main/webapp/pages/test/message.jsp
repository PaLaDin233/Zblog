<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<link href="/Zblog/pages/error/error.css" rel="stylesheet">
<meta http-equiv="refresh" content="3;URL=/Zblog${jumpadd}">
</head>
<body class="texture">
	<div class="wrapper">
		<div class="page-error">
			
			<h2 class="description text-center">${msg }</h2>
			<h3 class="text-center">
				<a href="/Zblog${jumpadd}">进行跳转</a>
			</h3>
		</div>
	</div>
		<div class="footer">
			<script type="text/javascript">$(".footer").load("/Zblog/pages/base/footer.html");</script>
		</div>
</body>
</html>