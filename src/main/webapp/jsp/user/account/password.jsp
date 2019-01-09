<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- head部分 -->
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>

</head>
<body>
	<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>
	<div class="container">
		<div class="panel panel-default stacked">
			<div class="panel-heading">
				<ul class="nav nav-pills account-tab">
					<li><a href="profile">基本信息</a></li>
					<li class="active"><a href="password">修改密码</a></li>
					<li class="disabled"><a href="">修改头像</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<c:if test="${msg!=null&&msg.size()!=0 }">
					<div id="message">${msg }</div>
				</c:if>
				<div class="tab-pane active" id="passwd">
					<form id="pw" action="/Zblog/update" method="post"
						class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-lg-3" for="password">当前密码</label>
							<div class="col-lg-4">
								<input type="password" class="form-control" name="pwd"
									placeholder="请输入当前密码" data-required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-3" for="password">新密码</label>
							<div class="col-lg-4">
								<input type="password" class="form-control" id="newPwd"
									name="newPwd" placeholder="请输入新密码" data-required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-3" for="confirm_password">确认密码</label>
							<div class="col-lg-4">
								<input type="password" class="form-control" data-required
									placeholder="请再输入一遍新密码"
									data-conditional="confirm" data-describedby="message"
									data-description="passwd" name="confirm_password">
							</div>
						</div>
						<div class="form-group">
							<div class="text-center">
								<button type="submit" class="btn btn-primary">提交</button>
							</div>
						</div>
						<!-- /form-actions -->
					</form>
				</div>
			</div>
			<!-- /panel-content -->
		</div>
		<!-- /panel -->
	</div>

</body>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
$(function() {
	$('#pw').validate(
		{
			onKeyup : true,
			onChange : true,
			rules: {
			      pwd: {
			        required: true,
			        minlength: 5
			      },
			      newPwd:{
		    	 	required: true,
			      	minlength: 5
			      },
			      confirm_password: {
			        required: true,
			        minlength: 5,
			        equalTo: "#newPwd"
			      }
			},
			eachValidField : function() {
				$(this).closest('div').removeClass(
						'has-error')
						.addClass('has-success');
			},
			eachInvalidField : function() {
				$(this).closest('div').removeClass(
						'has-success')
						.addClass('has-error');
			},
			conditional : {
				confirm : function() {
					return $(this).val() == $('#pwd')
							.val();
				}
			},
			description : {
				passwd : {
					conditional : '<div class="alert alert-danger">两次输入的密码不一致</div>'
				}
			}
		});
});
</script>


</html>

