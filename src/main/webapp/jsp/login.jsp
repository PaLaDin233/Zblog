<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page autoFlush="false"%>
<html>
<head>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<link rel="stylesheet" href="/Zblog/assets/css/login.css">
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
</head>

<body>
	<!-- 登陆框开始 -->
	<div id="loginPanel" class="Panel">
		<img src="/Zblog/assets/img/icon.png" height="72" width="72">
		<h1>登录你的账号</h1>
		<hr>
		<form class="userFrom" action="/Zblog/login" method="post">
			<div id="message">
			
				<%
					Object object = request.getAttribute("msg");
					if (object != null && !object.equals("")) {
						out.print("<div class='alert alert-danger'>");
						out.print(object.toString());
						out.print("</div>");
					}
				%>
			</div>
			<label for="id_email" hidden="">登录名:</label>
			<div id="id_email">
				<input name="name" class="form-control border" placeholder="用户名"
					type="text" data-required>
			</div>
			<label for="id_password" hidden="">密码:</label>
			<div id="id_password">
				<input name="pwd" class="form-control border" placeholder="密码"
					type="password" data-required>
			</div>

			<div style="margin-top: 15px;">
				<input type="submit" class="btn btn-success border"
					value="登录 Use it">

				<div class="forgot" hidden="">
					<a href="$base/reg"> 注册 </a> <a href="$base/forgot/apply"> 忘记密码
					</a>
				</div>
			</div>
		</form>
		没有账号?&nbsp;马上<a href="/Zblog/reg">注册</a><br>
		

		<!-- 第三方账号登陆，需要使用第三方对应的API,暂时未实现 -->
		<div style="display: none;">
			<div class="with-line">使用第三方帐号登录</div>
			<div class="buttons">
				<a href="" title="微博帐号登录"
					rel="nofollow" class="weibo"></a> <a
					href="" title="QQ帐号登录" rel="nofollow"
					class="qzone"></a> <a href=""
					title="豆瓣帐号登录" rel="nofollow" class="douban"></a>
			</div>
		</div>
		
		<a href="/Zblog">回到主页</a>
		<!-- 登陆框结束 -->
	</div>
</body>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/Zblog/assets/js/login.js"></script>
</html>
