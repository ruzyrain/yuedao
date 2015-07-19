<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/tab_public.js"></script>
<script type="text/javascript" src="js/logout.js"></script>
</head>
<body>
<div class="box">
  <div class="Login_tubiao yincang"><img src="images/loader.gif" width="86" height="83"></div>
  <!------------------------------------top开始------------------------------------>
  <div class="top_baifen">
    <div class="top_guding">
      <div class="logo_bj">
        <div class="logo_bj_l floatl"></div>
        <div class="logo_bj_c floatl"><img src="images/logo.png" height="63"></div>
        <div class="logo_bj_r floatl"></div>
      </div>
      <div class="guanli floatl">您好，${admin.truename!}</div>
      <div class="pre_login floatl">上次登录：<span>${admin.lastLoginTime!}</span>&nbsp;&nbsp;IP：<span>${admin.lastIp!}</span></div>
      <div class="tuichu floatr"><input id="tuichu" border="0" type="button"></div>  
    </div>
  </div>
  <!------------------------------------top2开始------------------------------------>
  <div class="top_two">
    <div class="top_two_l floatl"></div>
    <div class="top_two_c floatl">
      <div class="dangqian_tubiao floatl"></div>
      <div class="dangqian floatl">您当前的位置：管理菜单&nbsp;-&nbsp;<span id="weizhi0">管理首页</span></div>
    </div>
  </div>    
  <!----------------------------------center开始---------------------------------->
  <div class="center"><!--center开始-->
    <div class="center_l_xiushi">管&nbsp;理&nbsp;菜&nbsp;单</div>
    <!-------------center左侧导航开始---------------->
    <div class="center_l floatl">
      <div class="left_a">
        <div class="biaoti_da">test</div>
        <div class="xiushi"></div>
        <ul class="ul_a">
          <li class="biaoti_li"><a  target='content' href="goodsList">test</a></li>
        </ul>
      </div>
     
      
      <div class="left_a"><!--帐号设置开始-->
        <div class="biaoti_da">帐号设置</div>
        <div class="xiushi yincang"></div>
        <ul class="ul_a yincang">
       	<li class="biaoti_li"><a target='content' href="adminList">管理员账号管理</a></li>
          <li class="biaoti_li"><a target='content' href="passwordXiugai">修改密码</a></li>
          <li class="biaoti_li" id="tuichu_li">退出登录</li>
        </ul>
      </div><!--帐号设置结束-->
      <div class="center_l_bottom"></div>
    </div>
    <!-------------center左侧导航结束---------------->
    <div class="center_dianji" id="center_dianji" ok="0"></div>
    <!--center右侧开始-->
    <div class="center_main" id="center_main">
   	<iframe name="content" src="images/index.jpg" frameborder="0" width="99%" height="99%"></iframe>
    </div>
	
    <!--center右侧结束-->
    <div class="clear"></div>
  </div><!--center结束-->
  <!----------------------------------bottom开始---------------------------------->
  <div class="bottom_baifen">
    <div class="bottom_guding">
      <div class="bottom_xinxi floatl">后台管理系统</div>
    </div>
  </div>
</div>
</body>
</html>
