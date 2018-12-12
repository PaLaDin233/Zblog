<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<body>
	<h2>
		<form action="login.do" method="get">
			<input type="text" name="name" /> <input type="password"
				name="password" />
			<button type="submit">阿斯达斯</button>
		</form>
		<a action="" href="#">Hello World!</a>
	</h2>
</body>
</html>
