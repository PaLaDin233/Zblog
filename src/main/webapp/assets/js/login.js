/*$("#login-btn").click(function() {
	$("#loginPanel").show();
	$("#registPanel").hide();
	$('#registPanel')[0].reset();
});
$("#regist-btn").click(function() {
	$("#registPanel").show();
	$("#loginPanel").hide();
	$('#loginPanel')[0].reset();
});*/

//$(".Panel").mouseenter(function() {
//	$(".Panel").animate({opacity: .8 }, 100, function() {});  
//});
//$(".Panel").mouseleave(function() {
//	$(".Panel").animate({opacity: .2 }, 1000, function() {});  
//});

$().ready(function() {
	  $(".userFrom").validate({
	    rules: {
	      firstname: "required",
	      lastname: "required",
	      name: {
	        required: true,
	        minlength: 2
	      },
	      pwd: {
	        required: true,
	        minlength: 5
	      },
	      confirm_password: {
	        required: true,
	        minlength: 5,
	        equalTo: "#pwd"
	      },
	      email: {
	        required: true,
	        email: true
	      },
	      topic: {
	        required: "#newsletter:checked",
	        minlength: 2
	      },
	      agree: "required"
	    },
	    messages: {
	      name: {
	        required: "请输入用户名",
	        minlength: "用户名必需由两个字母组成"
	      },
	      pwd: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母"
	      },
	      confirm_password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母",
	        equalTo: "两次密码输入不一致"
	      },
	      email: "请输入一个正确的邮箱",
	     }
	    })
	});



