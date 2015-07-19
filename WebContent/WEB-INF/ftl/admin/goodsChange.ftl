<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改</title>
<#assign url=request.contextPath>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function change()
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

	var entity={id:${goods.id},name:name,price:price,info:info,description:description,praise:praise};
	$.ajax({
			url:"goodsChangeDo",
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


function uploadCallback1(img)
{
	if(img=="")
	{
		alert("不允许为空");
		return;
	}
		$("#deleteUrl1").attr("value",img);
		$("#imgshow1").attr("src", "${url}"+img); 
}
function uploadCallback2(img)
{
	if(img=="")
	{
		alert("不允许为空");
		return;
	}
		$("#deleteUrl2").attr("value",img);
		$("#imgshow2").attr("src", "${url}"+img); 
}
function uploadCallback3(img)
{
	if(img=="")
	{
		alert("不允许为空");
		return;
	}
		$("#deleteUrl3").attr("value",img);
		$("#imgshow3").attr("src", "${url}"+img); 
}
function uploadCallback4(img)
{
	if(img=="")
	{
		alert("不允许为空");
		return;
	}
		$("#deleteUrl4").attr("value",img);
		$("#imgshow4").attr("src", "${url}"+img); 
}
function uploadCallback5(img)
{
	if(img=="")
	{
		alert("不允许为空");
		return;
	}
		$("#deleteUrl5").attr("value",img);
		$("#imgshow5").attr("src", "${url}"+img); 
}
</script>
</head>
<body>

图片信息<br/>

<iframe id="hidden_frame" name="hidden_frame" style="display:none"></iframe>

图片1

<img width="50"  id="imgshow1" src="${url}${goods.imageurl1!}"/>

<form  action="GoodsImgUpload" method="post" enctype ="multipart/form-data" target="hidden_frame" >
<input type="file" name="file"  accept="image/*">
<input type="submit" value="修改图片1" />

<input name="deleteUrl" id="deleteUrl1" type="text" value="${goods.imageurl1!}" style="display:none">

<input name="returnFunction" value="uploadCallback1" style="display:none"/>
<input name="id" value="${goods.id}" style="display:none"/>
<input name="num" value="1" style="display:none"/>
</form>

<br/>
图片2

<img width="50"  id="imgshow2" src="${url}${goods.imageurl2!}"/>

<form  action="GoodsImgUpload" method="post" enctype ="multipart/form-data" target="hidden_frame" >
<input type="file" name="file"  accept="image/*">
<input type="submit" value="修改图片2" />

<input name="deleteUrl" id="deleteUrl2" type="text" value="${goods.imageurl2!}" style="display:none">

<input name="returnFunction" value="uploadCallback2" style="display:none"/>
<input name="id" value="${goods.id}" style="display:none"/>
<input name="num" value="2" style="display:none"/>
</form>

<br/>
图片3

<img width="50"  id="imgshow3" src="${url}${goods.imageurl3!}"/>

<form  action="GoodsImgUpload" method="post" enctype ="multipart/form-data" target="hidden_frame" >
<input type="file" name="file"  accept="image/*">
<input type="submit" value="修改图片3" />

<input name="deleteUrl" id="deleteUrl3" type="text" value="${goods.imageurl3!}" style="display:none">

<input name="returnFunction" value="uploadCallback3" style="display:none"/>
<input name="id" value="${goods.id}" style="display:none"/>
<input name="num" value="3" style="display:none"/>
</form>

<br/>
图片4

<img width="50"  id="imgshow4" src="${url}${goods.imageurl4!}"/>

<form  action="GoodsImgUpload" method="post" enctype ="multipart/form-data" target="hidden_frame" >
<input type="file" name="file"  accept="image/*">
<input type="submit" value="修改图片4" />

<input name="deleteUrl" id="deleteUrl4" type="text" value="${goods.imageurl4!}" style="display:none">

<input name="returnFunction" value="uploadCallback4" style="display:none"/>
<input name="id" value="${goods.id}" style="display:none"/>
<input name="num" value="4" style="display:none"/>
</form>

<br/>
图片5

<img width="50"  id="imgshow5" src="${url}${goods.imageurl5!}"/>

<form  action="GoodsImgUpload" method="post" enctype ="multipart/form-data" target="hidden_frame" >
<input type="file" name="file"  accept="image/*">
<input type="submit" value="修改图片5" />

<input name="deleteUrl" id="deleteUrl5" type="text" value="${goods.imageurl5!}" style="display:none">

<input name="returnFunction" value="uploadCallback5" style="display:none"/>
<input name="id" value="${goods.id}" style="display:none"/>
<input name="num" value="5" style="display:none"/>
</form>


<br/><br/><br/>
参数信息
<br/>



name:<input id="name" type="text" value="${goods.name}"><br/>
price:<input id="price" type="text" value="${goods.price}"><br/>
info:<input id="info" type="text" value="${goods.info}"><br/>
description:<input id="description" type="text" value="${goods.description}"><br/>
praise:<input id="praise" type="text" value="${goods.praise}"><br/>
<input onclick="change()" type="button" value="确认修改" ><input onclick="cancel()" type="button" value="取消" >

</body>
</html>
