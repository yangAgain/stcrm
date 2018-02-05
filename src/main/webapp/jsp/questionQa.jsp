<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建问卷</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	function submitForm() {
		$('#form').form({
			url : "/stcrm/questionController/insertQQA.do",
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
		return "<a onclick='updateit(" + row.id + ")'>修改</a>"
	}
	function updateit(id) {
		$("#form").form("load",
				"/stcrm/questionController/getOneQQA.do?id=" + id);
		$("#win").window("open");
	}
	$(function() {
		$('#win').window({
			title : '',
			width : 300,
			height : 400,
			title : "问卷题目",
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
	function newQQ() {
		$("#win").window("open");
	}
	function closeit() {
		$("#win").window("close");
	}
</script>
</head>
<body>
	<p style="text-align: center;">
		<a onclick="newQQ()"> 添加问卷题目</a>
	</p>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/questionController/allQQA.do',
				method:'post',
				border:false, 
				fit:true, 
				striped:true, 
				checkOnSelect:false, 
				fitColumns:true, 
				toolbar:'#tb',
				rownumbers:true
				">
		<thead>
			<tr>

				<th data-options="field:'question',width:20,align:'center'">问卷表名称</th>
				<th data-options="field:'optionA',width:20,align:'center'">选项A</th>
				<th data-options="field:'optionB',width:20,align:'center'">选项B</th>
				<th data-options="field:'optionC',width:20,align:'center'">选项C</th>
				<th data-options="field:'optionD',width:20,align:'center'">选项D</th>
				<th data-options="field:'cz',width:20,align:'center',formatter:ff">操作</th>
			</tr>
		</thead>
	</table>

	<div id="win">
		<form id="form" method="post">
			<p hidden="true">
				<input name="id">
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" style="width: 175px; height: 50px;" name="question">
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;选项A：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" style="width: 175px;" name="optionA">
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;选项B：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" style="width: 175px;" name="optionB">
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;选项C：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" style="width: 175px;" name="optionC">
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;选项D：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" style="width: 175px;" name="optionD">
			</p>
			<p>
				<a style="margin-left: 35%" id="btn" class="easyui-linkbutton" data-options="iconCls:''" onclick="closeit()">取消</a> <b style="margin-left: 10px" class="easyui-linkbutton" data-options="iconCls:''"
					onclick="submitForm()">提交</b>
			</p>
		</form>
	</div>
</body>
</html>