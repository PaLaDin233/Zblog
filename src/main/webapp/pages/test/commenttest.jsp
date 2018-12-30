<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/jsp/baseFrame/head.jsp"></jsp:include>
</head>
<body>
	<form id="form1">
		评论1:<input type="text" name="details"/>
	</form>
	<button onclick="submit(1)">a</button>
	<form id="form2">
			<input type="hidden" name="suprior">
		评论2:<input type="text" name="details"/>
	</form>
	<button onclick="submit(2)">a</button>
	<form id="form3">
		评论3:<input type="text" name="details"/>
	</form>
	<button onclick="submit(3)">a</button>
	<form id="form4">
		评论4:<input type="text" name="details"/>
	</form>
	<button onclick="submit(4)">a</button>
	<form id="form5">
		评论5:<input type="text" name="details"/>
	</form>
	<button onclick="submit(5)">a</button>
</body>
<script type="text/javascript">
function submit(id) {
    $.ajax({
        type: "POST",//方法类型
        url: "/Zblog/discuss/19" ,//url
        data: $('#form'+id).serialize(),
        success: function (result) {
        	alert(result);
            if (result.resultCode == 200) {
                alert("SUCCESS");
            }
            ;
        },
        error : function() {
        	alert(data);
        }
    });
}
</script>

</script>
</html>