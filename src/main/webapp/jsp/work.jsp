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

<script type="text/javascript">
	function newAp() {
		$('#win').window('open');
	}
	function closeit() {
		$('#win').window('close');
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

	var ff = function(value, row, index) {
		var workid = null;
		if (row.workModel != null) {
			workid = row.workModel.id;
		}
		return "<a onclick='insertit(" + row.id + "," + workid + ")'>自我评分</a>";
	}
	function insertit(id, workid) {

		$("#id").textbox("setValue", workid);
		$("#cc").combobox({
			url : "/stcrm/workController/getGradeStandard.do",
			editable : false,
			valueField : 'id',
			textField : 'name',
		});
		$("#assignmentid").textbox("setValue", id);
		$("#studentid").textbox("setValue", 2);
		$("#studentname").textbox("setValue", "${user.truename}");
		$("#form").form("load",
				"/stcrm/workController/selectOne.do?id=" + workid)
		$('#win').window("open");
	}
	$(function() {
		$('#win').window({
			title : '自我评价',
			width : 300,
			height : 250,
			title : "自我评价",
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
		$("#cc").combobox({
			url : "/stcrm/workController/getGradeStandard.do",
			editable : false,
			valueField : 'id',
			textField : 'name',
		});
	})
</script>
</head>
<body>
	<h2 style="text-align: center;">作业完成状况</h2>

	<div id="tb"></div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/workController/getMyAllAssignment.do',
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
				<th data-options="field:'time',width:10,align:'center'">日期</th>
				<th data-options="field:'question',width:30,align:'center'">作业题目</th>
				<th data-options="field:'gradeStandard',width:30,align:'center'">评分标准</th>
				<th data-options="field:'source',width:10,align:'center',formatter:function(value,row){
					if(row.workModel){
						return row.workModel.oneselfSorce;
						}
					
					}">自我评分</th>
				<th
					data-options="field:'grade',width:10,align:'center',formatter:function(value,row){
					if(row.workModel){
						if(row.workModel.oneselfGrade==9){ return '放弃未做'; } 
						if(row.workModel.oneselfGrade==10){ return '差距较大'; } 
						if(row.workModel.oneselfGrade==11){ return '一般状况'; } 
						if(row.workModel.oneselfGrade==12){ return'较好完成'; } 
						if(row.workModel.oneselfGrade==13){ return '全部完成'; } 
						if(row.workModel.oneselfGrade==14){ return '扩展掌握'; }
						}
					
					}">自我评级</th>
				<th data-options="field:'tsource',width:10,align:'center',formatter:function(value,row){
					if(row.workModel){
						return row.workModel.teacherSorce;
						}
					
					}">教师评分</th>
				<th
					data-options="field:'tgrade',width:10,align:'center',formatter:function(value,row){
					if(row.workModel){
						if(row.workModel.teacherGrade==9){ return '放弃未做'; } 
						if(row.workModel.teacherGrade==10){ return '差距较大'; } 
						if(row.workModel.teacherGrade==11){ return '一般状况'; } 
						if(row.workModel.teacherGrade==12){ return'较好完成'; } 
						if(row.workModel.teacherGrade==13){ return '全部完成'; } 
						if(row.workModel.teacherGrade==14){ return '扩展掌握'; }
						else{return '';}
					}
						
					}">教师评级</th>
				<th data-options="field:'cz',width:10,align:'center',formatter:ff">操作</th>
			</tr>
		</thead>
	</table>


	<div id="win">
		<form id="form" method="post">
			<p hidden="true">
				<input class="easyui-textbox" data-options="" style="width: 175px; height: 50px;" id="assignmentid" name="assignmentid">
			</p>
			<p hidden="true">
				<input class="easyui-textbox" id="studentid" name="studentid"> <input class="easyui-textbox" id="teacherGrade" name="teacherGrade"> <input class="easyui-textbox" id="teacherSorce"
					name="teacherSorce">
			</p>
			<p hidden="true">
				<input class="easyui-textbox" data-options="" style="width: 175px; height: 50px;" id="id" name="id">
			</p>
			<p>
				&nbsp;&nbsp;学生姓名：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'',required:true,editable:false" id="studentname" name="studentname">
			</p>
			<p>
				&nbsp;&nbsp;自我评分：<input class="easyui-numberbox" data-options="multiline:true,iconCls:'',prompt:'',required:true" id="oneselfSorce" name="oneselfSorce">
			</p>
			<p>
				&nbsp;&nbsp;自我评级：<input id="cc" name="oneselfGrade" style="width: 175px">
			</p>
			<p>
				<a style="margin-left: 35%" id="btn" class="easyui-linkbutton" data-options="iconCls:''" onclick="closeit()">取消</a> <b style="margin-left: 10px" class="easyui-linkbutton" data-options="iconCls:''"
					onclick="submitForm()">提交</b>
			</p>
		</form>
	</div>
</body>
</html>
