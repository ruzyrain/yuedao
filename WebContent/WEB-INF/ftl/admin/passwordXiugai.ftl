<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北京华博天下后台管理系统_修改密码</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function changePassword()
	{
		var password = $("#sourcePassword").attr("value");
		var newpassword = $("#newPassword").attr("value");
		var newpasswordagain = $("#newPasswordAgain").attr("value");

		var user = {PassWord:password, NewPassWord:newpassword, NewPassWordAgain:newpasswordagain};
		$.ajax({
				url:"passwordXiugaiDo",
				type:"post",
				data:user,
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
						alert(data.msg)
						window.location.href=data.url;
						break;
					}
				}
			});	
	}
</script>

</head>
<body>                                            
      <div class="jibenshezhi_box">
        <div class="guding" style="width:500px;">
          <div class="guding_list">
            <div class="guding_list_div fl">
              <div class="box_input">
                <div class="input_biaoti fl">输入旧密码：</div>
                <div class="div_input_290 fl"><input class="input_zi" id="sourcePassword" type="password" border="0"></div>
              </div>
              <div class="box_beizhu fl"><span>*</span>请输入6-16位的字母及数字,不支持特殊字符</div>
              <div class="cl"></div>
            </div>
            <div class="cl"></div>      
          </div>  
          <div class="guding_list">
            <div class="guding_list_div fl">
              <div class="box_input">
                <div class="input_biaoti fl">输入新密码：</div>
                <div class="div_input_290 fl"><input id="newPassword" class="input_zi" type="password" border="0"></div>
              </div>
              <div class="box_beizhu fl"><span>*</span>请输入6-16位的字母及数字,不支持特殊字符</div>
              <div class="cl"></div>
            </div>
            <div class="cl"></div>      
          </div>
          <div class="guding_list">
            <div class="guding_list_div fl">
              <div class="box_input">
                <div class="input_biaoti fl">重复新密码：</div>
                <div class="div_input_290 fl"><input id="newPasswordAgain" class="input_zi" type="password" border="0"></div>
              </div>
              <div class="box_beizhu fl"><span>*</span>请输入6-16位的字母及数字,不支持特殊字符</div>
              <div class="cl"></div>
            </div>
            <div class="cl"></div>      
          </div>
          <div class="btn_baocun"><input onclick="changePassword()" type="button" value="确认保存" ></div>
        </div>
      </div>                   
  
</body>
</html>