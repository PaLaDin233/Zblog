<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" role="form" action="/Zblog/insertMenu" method="post">
			<div class="form-group">
				<label for="name" class="control-label">菜单名称</label>
				<div>
					<input type="text" class="form-control" id="name"
						name="name" placeholder="请输入菜单名称" >
				</div>
			</div>
			<div class="form-group">
				<label for="superiorId" class="control-label">上级菜单id</label>
				<div>
					<input type="text" class="form-control" id="superiorId"
						name="superiorId" placeholder="请输入上级菜单">
				</div>
			</div>
			<div class="form-group">
				<label for="url" class="control-label">菜单url</label>
				<div>
					<input type="text" class="form-control" id="url"
						name="url" placeholder="请输入菜单url">
				</div>
			</div>
			<div class="form-group">
				<label for="status" class="control-label">菜单状态</label>
				<div>
					<input type="text" class="form-control" id="status"
						name="status" placeholder="请输入菜单状态" value="0">
				</div>
			</div>
			<div class="form-group">
				<label for="usertype" class="control-label">访问用户类型</label>
				<div>
					<input type="text" class="form-control" id="usertype"
						name="usertype" placeholder="请输入访问用户类型" value="0">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">提交</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>