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
	var username=$("#username").attr("value");
	var truename=$("#truename").attr("value");
	
	if(username==""||truename=="")
	{
		alert("不能为空;");
		return;
	}
	var entity={username:username,truename:truename};
	
	$.ajax({
			url:"adminAddDo",
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
	window.location.href="adminList";
}

</script>
</head>
<body>                      
username:<input id="username" type="text"><br/>
truename:<input id="truename" type="text"><br/>

<input onclick="add()" type="button" value="确认添加" ><input onclick="cancel()" type="button" value="取消" >


</body>
</html>
