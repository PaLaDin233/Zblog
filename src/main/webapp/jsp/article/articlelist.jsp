<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row">
	<div class="col-xs-10">
		<div class="panel-group" id="accordion">
			
				<c:forEach items="${page.results }" var="i" varStatus="index">
					<div class="row">
					<div class="col-xs-1" id="Idcheckbox">
						<c:if test="${user.id==i.userId }">
							<input type="checkbox" name="idList" value="${i.id }" id="idList${i.id }">
						</c:if>
					</div>
					<div class="col-xs-11">
						<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne${index.count }">
						<div class="panel" style="margin-bottom: 15px;">
							<div class="panel-heading"
								style="background: #202020; color: #9d9d9d;">
								<h4 class="panel-title">
									<span class="panel-title">${i.title }&nbsp;</span> <span
										style="float: right; font-size: 5px;"> <fmt:formatDate
											value="${i.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
									</span>
								</h4>
								<div class="article-info" style="text-align: right;">
									浏览:${i.views } 评论:${i.commentNum }</div>
							</div>
							<div id="collapseOne${index.count }"
								class="panel-collapse collapse">
								<div class="panel-body">
									<a href="/Zblog/getArticle/aid${i.id }"> 查看详情页 </a>
									<div id="${index.count }" class="article_details">${i.details }</div>
								</div>
							</div>
						</div>
					</a>
					</div>
					</div>
				</c:forEach>
			
			
		</div>
	</div>
</div>