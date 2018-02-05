<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
<style type="text/css">
a {
	cursor: pointer;
}
</style>
<style type="text/css">
.wenjuan {
	width: 100%;
	margin-top: 20px;
	float: left;
}

.wenjuan>div {
	float: left;
	margin-left: 10%;
}
</style>
<script type="text/javascript">
	var ff = function(value, row, index) {
		return "<a onclick='lookit(" + row.id + ")'>修改</a>";
	}
	function lookit(id) {
		$("#form").form("load", "/stcrm/userController/getOneUser.do?id=" + id);
		$("#win").window("open");
	}
	function insertUser() {
		$("#username").textbox({
			editable : true,
		});
		$("#win").window("open");
	}
	function submitIt() {
		$("#roleid").val(2);
		$('#form').form({
			url : "/stcrm/userController/insertUser.do",
			onSubmit : function() {
				var temp = $(this).form('validate');
				if (!temp) {
					$.messager.alert('提示', '请填写完整!', "error");
				}
				return temp;
			},
			success : function(data) {
				$("#table").datagrid("reload");
				$("#win").window("close");
			}
		});
		$('#form').submit();
	}
	$(function() {
		$('#win').window({
			title : '修改用户信息',
			width : 400,
			height : 200,
			closed : true,//初始时是关闭状态
			cache : false,
			modal : true,
			doSize : true,
			border : 'thin',
			collapsible : false,
			minimizable : false,
			maximizable : false,
			yIndex : 300,
			onClose : function() {
				$("#form").form("clear");
			}
		});
	})
</script>
</head>
<body>
	<h2 style="text-align: center;">讲师管理</h2>
	<div id="tb">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="insertUser()">添加讲师</a>
	</div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/userController/getAllUser.do?roleid=2',
				method:'post',
				border:false,
				fit:true,
				striped:true,
				checkOnSelect:false,
				fitColumns:true,
				toolbar:'#tb'
				">
		<thead>
			<tr>
				<th data-options="field:'truename',width:20,align:'center'">姓名</th>
				<th data-options="field:'username',width:20,align:'center'">登录账户</th>
				<th data-options="field:'classname',width:20,align:'center'">备注</th>
				<th data-options="field:'cz',width:20,align:'center',formatter:ff">操作</th>
			</tr>
		</thead>
	</table>
	<div id="win">
		<form id="form">
			<table>
				<tr>
					<td>用户账号: <input name="id" hidden="true"><input name="roleid" id="roleid" hidden="true"></td>
					<td><input class="easyui-textbox" data-options="prompt:'请输入用户账号',required:true,editable:false" id="username" name="username"></td>
				</tr>
				<tr>
					<td>登录密码:</td>
					<td><input class="easyui-passwordbox" data-options="required:true,missingMessage:'必填'" name="password"></td>
				</tr>
				<tr>
					<td>真实姓名:</td>
					<td><input class="easyui-validatebox textbox" data-options="prompt:'请输入商品价格.',required:true" name="truename"></td>
				</tr>
				<tr>
					<td></td>
					<td><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submitIt()">提交</a></td>
				</tr>
			</table>

		</form>
	</div>

</body>
</html>