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
	cursor: pointer;
}
</style>
<script type="text/javascript">
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
		$("#table")
				.datagrid(
						{
							url : '/stcrm/projectController/getStuProject2.do?studentid=${studentid}',
							fitColumns : true,
							columns : [ [ {
								field : 'stuName',
								title : '学生姓名',
								width : 100
							}, {
								field : 'projectName',
								title : '项目名称',
								width : 100
							}, {
								field : 'allSorce',
								title : '综合评分',
								width : 100
							}, {
								field : 'studentSorce',
								title : '学生评分',
								width : 100,
								align : 'center'
							}, {
								field : 'teacherSorce',
								title : '教师评分',
								width : 100,
								align : 'center'
							}, {
								field : 'grade',
								title : '教师评价',
								width : 100,
								align : 'center'
							}, {
								field : 'cz',
								title : '操作',
								width : 100,
								align : 'center',
								formatter : ff
							} ] ]
						})
	})

	var ff = function(value, row, index) {
		return "<a onclick='updateit(" + row.id + ")'>修改</a>";
	}
	function updateit(id) {
		$("form")
				.form("load", "/stcrm/projectController/selectOne.do?id=" + id)
		$("#win").window("open");
	}
	function submitForm() {
		$('#form').form({
			url : "/stcrm/projectController/insertProject.do",
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
	<h2 style="text-align: center;">学生项目详情</h2>
	<table id="table"></table>
	<div id="win">
		<form id="form" method="post">
			<p hidden="true">
				<input class="easyui-textbox" id="id" name="id"> <input class="easyui-textbox" id="studentSorce" name="studentSorce"> <input class="easyui-textbox" id="" name="projectName">
			</p>
			<p>
				&nbsp;&nbsp;综合评分：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" id="" name="allSorce">
			</p>
			<p>
				&nbsp;&nbsp;教师评分：<input class="easyui-numberbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" id="" name="teacherSorce">
			</p>
			<p>
				&nbsp;&nbsp;教师评价：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" id="" name="grade">
			</p>
			<p>
				<a style="margin-left: 35%" id="btn" class="easyui-linkbutton" data-options="iconCls:''" onclick="closeit()">取消</a> <b style="margin-left: 10px" class="easyui-linkbutton" data-options="iconCls:''"
					onclick="submitForm()">提交</b>
			</p>
		</form>
	</div>
</body>
</html>