<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- head部分 -->
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>


</head>
<body>
<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>
<div class="container">
<div class="panel panel-default stacked">
	<div class="panel-heading">
		<ul class="nav nav-pills account-tab">
			<li class="active"><a href="/Zblog/profile">基本信息</a></li>
			<li><a href="/Zblog/password">修改密码</a></li>
			<li class="disabled"><a href="" >修改头像</a></li>
		</ul>
	</div>
	<div class="panel-body">
		<c:if test="${msg!=null&&msg.size()!=0 }">
			<div id="message">
				${msg }
			</div>		
		</c:if>
		<div class="tab-pane active" id="profile">
			<form id="pf" action="/Zblog/update" method="post" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-lg-3" for="name">用户名：</label>
					<div class="col-lg-4">
					<input class="form-control" type="text" disabled="disabled" name="name" value="${user.name }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-3" for="email">邮箱：</label>
					<div class="col-lg-4">
						<input class="form-control" type="text" name="email" value="${user.email}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-3" for="phone">手机：</label>
					<div class="col-lg-4">
						<input class="form-control" type="text" name="phone" value="${user.phone}"/>
					</div>
				</div>
				<div class="form-group">
					<div class="text-center">
					<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</div><!-- /form-actions -->
			</form>
		</div>
	</div><!-- /panel-content -->
</div><!-- /panel -->
</div>


<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script src="/Zblog/assets/js/additional-methods.js"></script>
<script type="text/javascript">
$(function () {
	$('#pf').validate({
		onKeyup : true,
		onChange : true,
		rules: {
			email: {
				email:true
	     	 },
	     	phone:{
	     		isPhoneNum:true
	     	}
		},
		eachValidField : function() {
			$(this).closest('div').removeClass('has-error').addClass('has-success');
		},
		eachInvalidField : function() {
			$(this).closest('div').removeClass('has-success').addClass('has-error');
		}
	});
});
</script>
	
</body>


</html>