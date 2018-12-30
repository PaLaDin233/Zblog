<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
<style type="text/css">
.container .row {
	background: #fffff2;
}

.user-name {
	font-weight: bold;
	font-size: 15px;
	margin-right: 10px;
}

.comment-list li {
	border-bottom: thin;
	border-bottom-width: 2px;
	border-bottom-style: dotted;
}

.user-icon {
	width: 100px;
	height: 100px;
	text-align: center;
	display: inline-block;
}

.comment-textarea {
	width: 100%;
	height: 100px;
	resize: none;
	display: inline-block;
	border-radius:30px;
	padding: 20px;
}
.comment-textarea :FOCUS{
	width: 100%;
	height: 100px;
	resize: none;
	display: inline-block;
	border-radius:30px;
}

#views-num{
	float: right;
}
#article-title{
	font-size:35px;
	font-weight:bold;
	text-align:center;
	border-bottom: thin;
	font-family:"楷体";
}
#article-info > *{
	font-size:10px;
	font-style: inherit;
	font-family:"仿宋";
	margin-left:30px;
	margin-right: 30px; 
}
.panel{
	border-top-left-radius:30px;
	border-top-right-radius:30px;
}
.panel-heading{
	border-top-left-radius:30px;
	border-top-right-radius:30px;
	background: #f2fff2;
}
#head{
	border-top-left-radius:30px;
	border-top-right-radius:30px;
}
#body{
	border-bottom-left-radius:30px;
	border-bottom-right-radius:30px;
	margin-bottom: 15px;
}
#comment-area{
	border-top-left-radius:30px;
	border-top-right-radius:30px;
	margin-bottom: 100px;
}

</style>
<body>
	<jsp:include page="/jsp/baseFrame/MenuBar.jsp"></jsp:include>

	<div class="historyback"
		style="width: 20px; float: right;  position: fixed;"
		onClick="window.history.back(-1);">返回上一页</div>
		<a href="" 
		style="width: 20px; float: right; position: fixed;top: 300px;color: white;"
		>回到顶部
		</a>

	<div class="container">
		<div id="head" class="row">
			<div id="article-title">
				${article.title }		
			</div>
			<div id="article-info">
				<span id="article_createdate" align="right"></span> 
				<span id="views-num">阅读数:${article.views }</span>
			</div>
		</div>
		
		<div id="body" class="row">
			<div class="content col-xs-12">
				<div class="article_details">${article.details }</div>

			</div>
		</div>
		<!-- 评论区 -->
		<div id="comment-area" class="row">
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title">${sessionScope.user.name }:</h3>
				</div>
				<div class="panel-body">
					<form id="commentForm">
						<input type="hidden" name="superior" value="0"/>
						<input type="hidden" name="ancestor" value="0"/>
						<textarea class="comment-textarea" name="details"></textarea>
					</form>
					<button id="discuss_button" class="comment-submit">添加评论</button>
				</div>
			</div>
			<div class="col-xs-12 comment_area">
				<ul class="list-group comment-list">
					<c:forEach items="${article.comments}" var="comment">
						<li class="list-group-item"
							><span class="user-name">${comment.uname }</span><br>
							<span class="comment-details">${comment.details }</span>
							<br>
							${comment.cdate }
						</li>
					</c:forEach>
				</ul>

			</div>
		</div>
	</div>
	
	<%-- <jsp:include page="/jsp/baseFrame/footer.jsp"></jsp:include> --%>

</body>


<script type="text/javascript">
$("#discuss_button").click(function(){
	 $.ajax({
        type: "POST",//方法类型
        url: "/Zblog/discuss/${article.id}" ,//url
        data: $('#commentForm').serialize(),
        success: function (result) {
        	alert(result);
            if (result.resultCode == 200) {
                alert("SUCCESS");
            }
            ;
        },
        error : function() {
        	alert(result);
        }
    });
});

	Date.prototype.format = function(fmt) {
		var o = {
			"M+" : this.getMonth() + 1, // 月份
			"d+" : this.getDate(), //日
			"H+" : this.getHours(), //24小时制
			"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //12小时制  
			"m+" : this.getMinutes(), //分
			"s+" : this.getSeconds(), //秒
			"q+" : Math.floor((this.getMonth() + 3) / 3), //季度
			"S" : this.getMilliseconds()
		//毫秒
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	}
	$("#article_createdate").text(
			new Date("${article.createTime}").format("yyyy年MM月dd日HH时mm分ss秒"));
</script>

</script>
</html>