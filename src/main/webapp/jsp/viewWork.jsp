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
		var workid = null;
		var truename = row.truename;
		if (row.workModel != null) {
			workid = row.workModel.id;
		}
		return "<a onclick='updateit(" + row.id + ",\"" + truename + "\","
				+ workid + ")'>修改</a>";
	}
	function closeit() {
		$('#win').window('close');
	}
	$(function() {
		$("#cc").combobox({
			url : "/stcrm/workController/getGradeStandard.do",
			editable : false,
			valueField : 'id',
			textField : 'name',
		});
		$('#win').window({
			title : '修改',
			width : 600,
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
	function updateit(studentid, studentname, id) {
		$("#id").textbox("setValue", id);
		$("#studentname").textbox("setValue", studentname);
		$("#studentid").textbox("setValue", studentid);
		$("#assignmentid").textbox("setValue", "${asmid}");
		$("#form").form("load", "/stcrm/workController/selectOne.do?id=" + id)
		$("#win").window("open");
	}
	function submitForm() {
		$('#form').form({
			url : "/stcrm/workController/insertWork.do",
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
	<h2 style="text-align: center;">学生作业详情</h2>
	<div id="tb"></div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/userController/lookStuWork.do',
				method:'post',
				border:false,
				fit:true,
				striped:true,
				checkOnSelect:false,
				fitColumns:true,
				toolbar:'#tb',
				">
		<thead>
			<tr>
				<th data-options="field:'truename',align:'center',width:20">姓名</th>
				<th data-options="field:'ss',align:'center',width:20,formatter:function(value,row){
					if(row.workModel){
						return row.workModel.oneselfSorce;
						}
					
					}">学生评分</th>
				<th
					data-options="field:'sg',width:20,align:'center',formatter:function(value,row){
					if(row.workModel){
						if(row.workModel.oneselfGrade==9){ return '放弃未做'; } 
						if(row.workModel.oneselfGrade==10){ return '差距较大'; } 
						if(row.workModel.oneselfGrade==11){ return '一般状况'; } 
						if(row.workModel.oneselfGrade==12){ return'较好完成'; } 
						if(row.workModel.oneselfGrade==13){ return '全部完成'; } 
						if(row.workModel.oneselfGrade==14){ return '扩展掌握'; }
						}
					
					}">学生评级</th>
				<th data-options="field:'ts',width:20,align:'center',formatter:function(value,row){
					if(row.workModel){
						return row.workModel.teacherSorce;
						}
					
					}">评分</th>
				<th
					data-options="field:'tg',width:20,align:'center',formatter:function(value,row){
					if(row.workModel){
						if(row.workModel.teacherGrade==9){ return '放弃未做'; } 
						if(row.workModel.teacherGrade==10){ return '差距较大'; } 
						if(row.workModel.teacherGrade==11){ return '一般状况'; } 
						if(row.workModel.teacherGrade==12){ return'较好完成'; } 
						if(row.workModel.teacherGrade==13){ return '全部完成'; } 
						if(row.workModel.teacherGrade==14){ return '扩展掌握'; }
						}
					
					}">评级</th>
				<th data-options="field:'cz',width:20,align:'center',formatter:ff">操作</th>
			</tr>
		</thead>
	</table>
	<div id="win">
		<form id="form" method="post">
			<p hidden="true">
				<input class="easyui-textbox" id="assignmentid" name="assignmentid">
			</p>
			<p hidden="true">
				<input class="easyui-textbox" id="studentid" name="studentid">
			</p>
			<p hidden="true">
				<input class="easyui-textbox" id="id" name="id"> <input class="easyui-textbox" id="oneselfGrade" name="oneselfGrade"> <input class="easyui-textbox" id="oneselfSorce"
					name="oneselfSorce">
			</p>
			<p>
				&nbsp;&nbsp;姓名：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true,editable:false" id="studentname" name="studentname">
			</p>
			<p>
				&nbsp;&nbsp;评分：<input class="easyui-numberbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" id="teacherSorce" name="teacherSorce">
			</p>
			<p>
				&nbsp;&nbsp;评级：<input id="cc" name="teacherGrade" style="width: 175px">
			</p>
			<p>
				<a style="margin-left: 35%" id="btn" class="easyui-linkbutton" data-options="iconCls:''" onclick="closeit()">取消</a> <b style="margin-left: 10px" class="easyui-linkbutton" data-options="iconCls:''"
					onclick="submitForm()">提交</b>
			</p>
		</form>
	</div>
</body>
</html>