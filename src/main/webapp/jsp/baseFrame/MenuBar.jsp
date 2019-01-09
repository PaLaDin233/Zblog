<%@page import="java.util.List"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.user!=null }">
<div class="row clearfix top-menu">
	<div class="col-md-12 column">
		<nav class="navbar navbar-default navbar-static-top navbar-inverse" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">切换导航</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/Zblog">ZBlog</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
				<li ><a href='/Zblog/home'>主页</a></li>
				<c:forEach items="${menus }" var="menu">
					<c:choose>
						<c:when test="${menu.childList.size()!=0 }">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> ${menu.name } <b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<c:forEach items="${menu.childList}" var="childMenu" varStatus="i">
								<li><a href="${childMenu.url }">${childMenu.name }</a></li>
								<c:if test="${i.index<menu.childList.size()-1 }">
								<li class="divider"></li>
								</c:if>
								</c:forEach>
							</ul>
							</li>
						</c:when>
						<c:otherwise>
							<li><a href="${menu.url }">${menu.name }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
					<%-- 
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> 文章 <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="/Zblog/getUsersArticleList/${user.id}/page0">我的文章</a></li>
							<li class="divider"></li>
							<li><a href="/Zblog/getUsersArticleList/0/page0">文章列表</a></li>
							<li class="divider"></li>
							<li><a href="/Zblog/saveArticle">发布文章</a></li>
						</ul></li> --%>
				</ul>
				
				<form class="navbar-form navbar-left" role="search" 
				action="/Zblog/findArticles/page1" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="title"/>
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a>您好！${user.name }</a></li>
					<c:if test="${user.type==1 }">
						<li><a href="/Zblog/admin">管理中心</a></li>
					</c:if>
					<!-- <li class="dropdown">
						<a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> 系统设置 <b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li><a href="/Zblog/userCenter">个人中心</a></li>
							<li class="divider"></li>
							<li hidden="hidden"><a href="#">系统中心</a></li>
						</ul>
					</li> -->
					<li>
						<a href="/Zblog/logout" >注销 </a>
					</li>
					
				</ul>
				
				
			</div>

		</nav>
	</div>
</div>
</c:if>
<c:if test="${sessionScope.user==null }">
<div class="row clearfix top-menu">
	<div class="col-md-12 column">
		<nav class="navbar navbar-default navbar-static-top navbar-inverse" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">切换导航</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">ZBlog</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li ><a href='/Zblog/home'>主页</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> 文章 <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="/Zblog/getUsersArticleList/0/page1">文章列表</a></li>
						</ul>
					</li>
				</ul>
				
				<form id="globle" class="navbar-form navbar-left" 
				role="search" action="/Zblog/findArticles/page1"  method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="title"/>
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="/Zblog/login">登陆</a>
					</li>
					<li>
						<a href="/Zblog/reg"  style="text-align: center;">注册</a>
					</li>
				</ul>
				
				
			</div>

		</nav>
	</div>
</div>
</c:if>