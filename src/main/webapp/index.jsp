<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<html>
<!-- head部分 -->
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<body>
	<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>
	<div class="container">

		<div class="row clear-fix">
			<div class="col-xs-9 col-sm-8 col-md-9 col-lg-9 blog-main"></div>

			<div class="col-xs-3 col-sm-4 col-md-3 col-lg-3 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset hidden-xs">
					<h4>关于</h4>
					<p>欢迎来到Zblog!</p>
				</div>
				<div class="sidebar-module">
					<h4>归档</h4>
					<ol class="list-unstyled">
						<li><a href="#">March 2014</a></li>
						<li><a href="#">February 2014</a></li>
						<li><a href="#">January 2014</a></li>
						<li><a href="#">December 2013</a></li>
						<li><a href="#">November 2013</a></li>
						<li><a href="#">October 2013</a></li>
						<li><a href="#">September 2013</a></li>
						<li><a href="#">August 2013</a></li>
						<li><a href="#">July 2013</a></li>
						<li><a href="#">June 2013</a></li>
						<li><a href="#">May 2013</a></li>
						<li><a href="#">April 2013</a></li>
					</ol>
				</div>
				<div class="sidebar-module">
					<h4>Elsewhere</h4>
					<ol class="list-unstyled">
						<li><a href="#">GitHub</a></li>
						<li><a href="#">QQ</a></li>
						<li><a href="#">sina</a></li>
					</ol>
				</div>
			</div>
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
	<jsp:include page="jsp/baseFrame/footer.jsp"></jsp:include>
</body>
</html>