<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page autoFlush="false"%>
<html>
<head>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<link rel="stylesheet" href="/Zblog/assets/css/login.css">
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
</head>
<body>
	<!-- 注册框开始 -->
	<div id="registPanel" class="Panel">
		<img src="/Zblog/assets/img/icon.png" height="72" width="72">
		<h1>注册新的账号</h1>
		<hr>
		<form class="userFrom" action="/Zblog/reg" method="post">
			<label for="id_email" hidden="">用户名:</label>
			<div id="id_email">
				<input name="name" class="form-control border" placeholder="用户名"
					type="text" data-required>
			</div>
			<label for="id_password" hidden="">密码:</label>
			<div id="id_password">
				<input id="pwd" name="pwd" class="form-control border" placeholder="密码"
					type="password" data-required>
			</div>
			<label for="id_conform_password" hidden="">确认密码:</label>
			<div id="id_conform_password">
				<input name="confirm_password" class="form-control border" placeholder="确认密码"
					type="password" data-required>
			</div>

			<div style="margin-top: 15px;">
				<input type="submit" class="btn btn-success border" value="注册!">
			</div>
		</form>
	<a href="/Zblog">回到主页</a>
	</div>
	<!-- 注册框结束 -->
</body>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/Zblog/assets/js/login.js"></script>
<script type="text/javascript">

</script>
</html>
