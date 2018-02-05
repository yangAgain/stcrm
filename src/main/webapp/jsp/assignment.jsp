<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>

<style type="text/css">
a {
	list-style: none;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	function newAp() {
		$('#win').window('open');
	}
	function closeit() {
		$('#win').window('close');
	}
	function submitForm() {
		$('#form')
				.form(
						{
							url : "/stcrm/assignmentController/insertAssignment.do?teacherid=${user.id}",
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

	var ff = function(value, row, index) {
		$('#win').window({
			title : '修改作业',
			width : 300,
			height : 320,
			title : "修改作业",
			closed : true,//初始时是关闭状态
			cache : false,
			modal : true,
			doSize : true,
			border : 'thin',
			collapsible : false,
			minimizable : false,
			maximizable : false,
			yIndex : 300,
		});
		return "<a onclick='updateit("
				+ row.id
				+ ",\""
				+ row.question
				+ "\",\""
				+ row.gradeStandard
				+ "\")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='/stcrm/assignmentController/toLook.do?asmid="
				+ row.id + "'>作业完成状态</a>";
	}
	function deleteit(id) {
		$.messager
				.confirm(
						'警告',
						'确认删除?',
						function(r) {
							if (r) {
								window.location.href = "/stcrm/assignmentController/deleteAssignment.do?id="
										+ id;
							}
						});
	}
	function updateit(id, question, gradeStandard) {
		$("#question").textbox("setValue", question);
		$("#id").textbox("setValue", id);
		$("#gradeStandard").textbox("setValue", gradeStandard);
		$('#win').window('open');
	}
	$(function() {
		$('#win').window({
			title : '新增作业',
			width : 300,
			height : 320,
			title : "新增作业",
			closed : true,//初始时是关闭状态
			cache : false,
			modal : true,
			doSize : true,
			border : 'thin',
			collapsible : false,
			minimizable : false,
			maximizable : false,
			yIndex : 300,
		});
	})
</script>
</head>
<body>
	<h2 style="text-align: center;">学生作业管理</h2>
	<div id="tb">
		<a class="easyui-linkbutton" data-options="iconCls:''" onclick="newAp()">发布作业</a>
	</div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/assignmentController/getMyAllAssignment.do',
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
				<th data-options="field:'time',width:20,align:'center'">日期</th>
				<th data-options="field:'question',width:20,align:'center'">作业题目</th>
				<th data-options="field:'gradeStandard',width:20,align:'center'">评分标准</th>
				<th data-options="field:'cz',width:20,align:'center',formatter:ff">操作</th>
			</tr>
		</thead>
	</table>


	<div id="win">
		<form id="form" method="post">
			<p hidden="true">
				<input class="easyui-textbox" data-options="" style="width: 175px; height: 50px;" id="id" name="id">
			</p>
			<p>
				题目内容：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" style="width: 175px; height: 50px;" id="question" name="question">
			</p>
			<p>
				评分标准：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" style="width: 175px; height: 120px;" id="gradeStandard" name="gradeStandard">
			</p>
			<p>
				<a style="margin-left: 35%" id="btn" class="easyui-linkbutton" data-options="iconCls:''" onclick="closeit()">取消</a> <b style="margin-left: 10px" class="easyui-linkbutton" data-options="iconCls:''"
					onclick="submitForm()">提交</b>
			</p>
		</form>
	</div>
</body>
</html>
