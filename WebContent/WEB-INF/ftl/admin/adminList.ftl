<!DOCTYPE HTML>
}
function changeAdmin(id)
function addAdmin()
</script>
</head>
<body>
	Admin<input onclick="addAdmin()" type="button" value="添加" >
	<table border="1">
			<td>truename</td>
          </tr>
          <tr>
	<td>${admin.truename}</td>
	
         <td>
			<input onclick="deleteAdmin('${admin.id!}')" type="button" value="删除" >
	</tr>
	</#list>
	</table>

</body>
</html>