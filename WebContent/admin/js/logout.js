$(document).ready(function(){
		//给登录按钮添加事件
	$("#tuichu_li").click(function()
	{
		var isConfirm = window.confirm("确认退出吗？");
		if(!isConfirm){
			// 阻止默认事件，阻止链接
			event.preventDefault();
			return false;
		}
		$.ajax({
				url:"logout",
				type:"post",
				timeout:3000,
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
							window.location.href=data.url;
							break;
						}
					}
			});
	});
	
	$("#tuichu").click(function(){
		var isConfirm = window.confirm("确认退出吗？");
		if(!isConfirm){
			// 阻止默认事件，阻止链接
			event.preventDefault();
			return false;
		}
		$.ajax({
				url:"logout",
				type:"post",
				timeout:3000,
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
							window.location.href=data.url;
							break;
						}
					}
			});
	});
});