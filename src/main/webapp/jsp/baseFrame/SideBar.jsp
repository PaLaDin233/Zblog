<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="sidebar-module sidebar-module-inset hidden-xs">
					<h4>关于</h4>
					<p>欢迎来到Zblog!</p>
				</div>
				<c:if test="${pigeonholeDates!=null&&pigeonholeDates.size()!=0 }">
					<div class="sidebar-module">
						<h4>归档</h4>
						<ol class="list-unstyled">
							<c:forEach var="d" items="${pigeonholeDates }" varStatus="s">
								<li>
								<form action="/Zblog/findArticles/page0" id="f${s.index }" method="post">
									<input type="text" value="<fmt:formatDate value="${d }"
										pattern="yyyy-MM-dd" />" name="createTime" hidden=""/>
									
								</form>
									<a onclick="document.getElementById('f${s.index}').submit();"><fmt:formatDate value="${d }"
										pattern="yyyy-MM-dd" /></a>
								</li>							
							</c:forEach>
							
						</ol>
					</div>				
				</c:if>
				<div class="sidebar-module">
					<h4>个人</h4>
					<ol class="list-unstyled">
						<li><a href="//github.com/PaLaDin233">GitHub</a></li>
						<li hidden=""><a href="#">QQ</a></li>
						<li hidden=""><a href="#">sina</a></li>
					</ol>
				</div>