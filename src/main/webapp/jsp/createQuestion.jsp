<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
<style type="text/css">
a {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	function submitForm() {
		$('#form').form({
			url : "/stcrm/questionController/insertCQ.do?id=${user.id}",
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

		return "<a onclick='insertQQA("
				+ row.id
				+ ")'>添加/修改问卷问题</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='updateit("
				+ row.id
				+ ")'>修改问卷名称</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='lookit("
				+ row.id + ")'>查看详情</a>"
	}
	function lookit(id) {
		window.location.href = "/stcrm/questionController/toLookit.do?id=" + id;
	}
	function updateit(id) {
		$("#form").form("load",
				"/stcrm/questionController/getOneCQ.do?id=" + id);
		$("#win").window("open");
	}
	function insertQQA(id) {
		$("#form2").form("load",
				"/stcrm/questionController/getOneCQ.do?id=" + id);
		$("#ppp")
				.html(
						"<a style='margin-left: 35%' id='btn'  onclick='closeit()'>取消</a> <b style='margin-left: 10px' class='easyui-linkbutton' onclick='submitit("
								+ id + ")'>提交</b>")
		$("#win2").window("open")
	}
	$(function() {
		$('#win').window({
			width : 300,
			height : 250,
			title : "问卷",
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
		$('#dl').datalist({
			url : '/stcrm/questionController/allQQA.do',
			checkbox : true,
			lines : true,
			singleSelect : false,
			valueField : 'id',
			textField : 'question'
		});
		$('#win2').window({
			width : 300,
			title : "选择问卷问题",
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
	function newCq() {
		$("#win").window("open");
	}
	function closeit() {
		$("#win").window("close");
		$("#win2").window("close");
	}
	function submitit(id) {
		var c = $("#dl").datalist("getChecked");
		if (c.length == 0) {
			$.messager.alert('提示', '请选中列表记录后再添加');
			return;
		}
		var qqaid = "";
		for (var i = 0; i < c.length; i++) {
			qqaid += "," + c[i].id;
		}
		$('#form2').form({
			url : "/stcrm/questionController/insertCQ2.do",
			onSubmit : function() {
				$("#qqaid").val(qqaid);
				var temp = $(this).form('validate');
				if (!temp) {
					alert($("#qqaid").val());
					$.messager.alert('提示', '请填写完整!', "error");
				}
				return temp;
			},
			success : function(data) {
				$("#table").datagrid("reload");
				$("#win2").window("close");
			}
		});
		$('#form2').submit();
	}
</script>
</head>
<body>
	<h2 style="text-align: center;">问卷管理</h2>
	<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="newCq()"> 新建问卷</a>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/questionController/allCQ.do',
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
				<th data-options="field:'questionName',width:20,align:'center'">问卷表名称</th>
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
				问卷表名称：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" style="width: 175px; height: 50px;" name="questionName">
			</p>
			<p id="">
				<a style='margin-left: 35%' id='btn' class='easyui-linkbutton' onclick='closeit()'>取消</a> <b style='margin-left: 10px' class='easyui-linkbutton' onclick='submitForm()'>提交</b>
			</p>
		</form>
	</div>
	<div id="win2">
		<form id="form2">
			<p hidden="true">
				<input name="qqaid" id="qqaid"> <input name="id">
			</p>
			<p>
				问卷名称:<input class="easyui-textbox" data-options="editable:false" name="questionName">
			</p>
			选择一下问题作为该问卷的题目：
			<div id="dl"></div>
			<p id="ppp"></p>
		</form>
	</div>

</body>
</html>