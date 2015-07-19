<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加</title>
<#assign url=request.contextPath>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

function add()
{
	var name=$("#name").attr("value");
	var price=$("#price").attr("value");
	var info=$("#info").attr("value");
	var description=$("#description").attr("value");
	var praise=$("#praise").attr("value");
	
	if(name==""||price==""||info==""||description==""||praise=="")

	{
		alert("不能为空;");
		return;
	}
	var entity={name:name,price:price,info:info,description:description,praise:praise};
	
	$.ajax({
			url:"goodsAddDo",
			type:"post",
			data:entity,
			error: function (xmlHttpRequest, error) {
	                    alert("超时，请确认服务器正常");
	                    top.location.reload();
	            },
			success:function(data){
				switch(data.state)
				{
				case 0:
					alert(data.msg);
					break;
				case 1:
					alert(data.msg)
					window.location.href=data.url;
					break;
				}
			}
		});	
}
function cancel()
{
	window.location.href="goodsList";
}

</script>
</head>
<body>                      
name:<input id="name" type="text"><br/>
price:<input id="price" type="text"><br/>
info:<input id="info" type="text"><br/>
description:<input id="description" type="text"><br/>
praise:<input id="praise" type="text"><br/>

<input onclick="add()" type="button" value="确认添加" ><input onclick="cancel()" type="button" value="取消" >


</body>
</html>
