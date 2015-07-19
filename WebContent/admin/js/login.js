$(document).ready(function(){
		//给登录按钮添加事件
		if(top.location!=self.location){
			top.location = self.location;
		}
		
		$("#login").click(function(){
			var username=$("#username").attr("value");
			var password=$("#password").attr("value");
			var user={username:username,password:password};
			$.ajax({
				url:"login",
				type:"post",
				data:user,
				timeout:3000,
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
				},
                error: function (xmlHttpRequest, error) {
                     alert("超时，请确认服务器正常");
                     top.location.reload();
                 }
			});
		});	
	});