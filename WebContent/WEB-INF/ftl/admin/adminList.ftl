<!DOCTYPE HTML><html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"><title>删除</title><#assign url=request.contextPath><script type="text/javascript" src="js/jquery.js"></script><script type="text/javascript">function deleteAdmin(id){	var isConfirm = window.confirm("确认删除？");	if(!isConfirm){		return false;	}	var entity={id:id};	$.ajax({			url:"adminDelete",			type:"post",			data:entity,			error: function (xmlHttpRequest, error) {					alert("超时，请确认服务器正常");					top.location.reload();	          },			success:function(data){				switch(data.state)				{				case 0:					alert(data.msg);					break;				case 1:					alert(data.msg);					window.location.href=data.url;					break;					}				}			});
}
function changeAdmin(id){	window.location.href="adminChange?id="+id;}
function addAdmin(){	window.location.href="adminAdd";}
</script>
</head>
<body>
	Admin<input onclick="addAdmin()" type="button" value="添加" >
	<table border="1">          <tr>          <td>id</td>            <td>username</td>
			<td>truename</td>
          </tr>          <#list adminList! as admin>
          <tr>            <td>${admin.id!}</td>           <td>${admin.username}</td>
	<td>${admin.truename}</td>
	
         <td>
			<input onclick="deleteAdmin('${admin.id!}')" type="button" value="删除" >			<input onclick="changeAdmin('${admin.id!}')" type="button" value="修改" >	    </td>    
	</tr>
	</#list>
	</table>

</body>
</html>
