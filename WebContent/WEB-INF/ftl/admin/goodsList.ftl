<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>列表</title>
<#assign url=request.contextPath>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function deleteGoods(id)
{
	var isConfirm = window.confirm("确认删除？");
	if(!isConfirm){
		return false;
	}
	var entity={id:id};
	$.ajax({
			url:"goodsDelete",
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
					alert(data.msg);
					window.location.href=data.url;
					break;
					}
				}
			});
}
function changeGoods(id)
{
	window.location.href="goodsChange?id="+id;
}
function addGoods()
{
	window.location.href="goodsAdd";
}
</script>
</head>
<body>
	Goods<input onclick="addGoods()" type="button" value="添加" >
	<table border="1">
          <tr>
          <td>id</td>
            <td>name</td>
	<td>price</td>
	<td>info</td>
	<td>description</td>
	<td>praise</td>
	<td>imageurl1</td>
	<td>imageurl2</td>
	<td>imageurl3</td>
	<td>imageurl4</td>
	<td>imageurl5</td>
	
          </tr>
          
          <#list goodsList! as goods>
          <tr>
            <td>${goods.id!}</td>
           <td>${goods.name}</td>
	<td>${goods.price}</td>
	<td>${goods.info}</td>
	<td>${goods.description}</td>
	<td>${goods.praise}</td>
		  <td width="5%"><img width="50"  src="${url}${goods.imageurl1!}"/></td>        <td width="5%"><img width="50"  src="${url}${goods.imageurl2!}"/></td>        <td width="5%"><img width="50"  src="${url}${goods.imageurl3!}"/></td>        <td width="5%"><img width="50"  src="${url}${goods.imageurl4!}"/></td>        <td width="5%"><img width="50"  src="${url}${goods.imageurl5!}"/></td>	
            <td>
		<input onclick="deleteGoods('${goods.id!}')" type="button" value="删除" >
		<input onclick="changeGoods('${goods.id!}')" type="button" value="修改" >
	      </td>    
	</tr>
	</#list>
	</table>

</body>
</html>
