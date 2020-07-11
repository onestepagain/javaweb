<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
			
			$("#btn").click(function(){
				
					$.post("AjaxDemo","name=John&location=Boston",function(){
						 alert( "Data Saved: " );
					});
// 					$.ajax({
// 					   type: "POST",
// 					   url: "AjaxDemo",
// 					   data: "name=John&location=Boston",
// 					   success: function(msg){
// 					     alert( "Data Saved: " + msg );
// 					   }
// 					});
			});
			
			$("#btnGet").click(function(){
				//var json = {key:value,key2:value2,key3:value3}
				$.getJSON("AjaxDemo",{"name":"zhangsan","age":18},function(msg){
					alert("msg:"+msg.name);
				});
				
// 				$.get("AjaxDemo",{"name":"zhangsan","age":18},function(msg){
// 					alert("msg:"+msg.name);
// 				},"json");
				
// 				$.ajax({
// 					type:"get",
// 					url:"AjaxDemo",
// 					data:{"name":"zhangsan","age":18},
// 					dataType:"json",
// 					success:function(msg){
// 						alert("msg:"+msg.name);
// 					},
// 					error:function(){
// 						alert("error!!!");
// 					}
// 				});
				
			});
			
	});
</script>
</head>
<body>
	<button id="btn">click Post</button>
	<button id="btnGet">click Get</button>
</body>
</html>