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
<script type="text/javascript">
	var ff = function(value, row, index) {
		return "<a onclick='updateit(" + row.id + ")'>修改</a>";
	}
	function closeit() {
		$('#win').window('close');
	}
	$(function() {
		$('#win').window({
			title : '新增项目',
			width : 300,
			height : 300,
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
	function updateit(id) {
		$("#id").textbox("setValue", id);
		$("#form").form("load",
				"/stcrm/projectController/selectOne.do?id=" + id)
		$("#win").window("open");
	}
	function insertit() {
		$("#studentid").textbox("setValue", 2);
		$('#win').window("open");
	}
	function submitForm() {
		$('#form')
				.form(
						{
							url : "/stcrm/projectController/insertProject.do?studentid=${user.id}",
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
</script>
</head>
<body>
	<h2 style="text-align: center;">个人项目管理</h2>
	<div id="tb">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="insertit()">新增项目</a>
	</div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/projectController/getMyProject.do',
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
				<th data-options="field:'projectName',align:'center',width:20">项目名称</th>
				<th data-options="field:'allSorce',align:'center',width:20">综合评分</th>
				<th data-options="field:'studentSorce',align:'center',width:20">自我评分</th>
				<th data-options="field:'teacherSorce',align:'center',width:20">教师评分</th>
				<th data-options="field:'grade',align:'center',width:20">教师评价</th>
				<th data-options="field:'cz',align:'center',width:20,formatter:ff">操作</th>
			</tr>
		</thead>
	</table>
	<div id="win">
		<form id="form" method="post">
			<p hidden="true">
				<input class="easyui-textbox" id="id" name="id"> <input class="easyui-textbox" id="" name="allSorce"> <input class="easyui-textbox" id="" name="teacherSorce"><input
					class="easyui-textbox" id="" name="grade">

			</p>
			<p>
				&nbsp;&nbsp;项目名称：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" id="" name="projectName">
			</p>
			<p>
				&nbsp;&nbsp;自我评分：<input class="easyui-numberbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" id="studentSorce" name="studentSorce">
			</p>
			<p>
				<a style="margin-left: 35%" id="btn" class="easyui-linkbutton" data-options="iconCls:''" onclick="closeit()">取消</a> <b style="margin-left: 10px" class="easyui-linkbutton" data-options="iconCls:''"
					onclick="submitForm()">提交</b>
			</p>
		</form>
	</div>
</body>
</html>