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
			url : "/stcrm/leaveController/submitLeave.do?userid=${user.id}",
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
			title : '修改',
			width : 300,
			height : 250,
			title : "学生请假申请",
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
	function allLeave() {
		$("#table").datagrid({
			url : '/stcrm/leaveController/getMyLeave.do',
		})
		$("#table").datagrid("reload");
	}
	function spz() {
		$("#table").datagrid({
			url : '/stcrm/leaveController/getMyLeave.do?status=6',
		})
		$("#table").datagrid("reload");
	}
	function spbh() {
		$("#table").datagrid({
			url : '/stcrm/leaveController/getMyLeave.do?status=8',
		})
		$("#table").datagrid("reload");
	}
	function sptg() {
		$("#table").datagrid({
			url : '/stcrm/leaveController/getMyLeave.do?status=7',
		})
		$("#table").datagrid("reload");
	}
</script>
</head>
<body>
	<h2 style="text-align: center;">请假申请</h2>

	<div id="tb">
		<a data-options="iconCls:''" class="easyui-linkbutton" onclick="allLeave()">我的申请</a> <a class="easyui-linkbutton" data-options="iconCls:''" onclick="spz()">审批中</a> <a class="easyui-linkbutton"
			data-options="iconCls:''" onclick="spbh()">审批驳回</a><a class="easyui-linkbutton" data-options="iconCls:''" onclick="sptg()">审批通过</a> <a class="easyui-linkbutton" data-options="iconCls:'icon-add'"
			onclick="newAp()">新的申请</a>
	</div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/leaveController/getMyLeave.do',
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
				<th data-options="field:'truename',width:20,align:'center',formatter: function(value,row){
					if(row.userModel){
						return row.userModel.truename;
					}
				}">学生</th>
				<th data-options="field:'why',width:20,align:'center'">事由</th>
				<th data-options="field:'time',width:20,align:'center'">申请时间</th>
				<th data-options="field:'beginTime',width:20,align:'center'">开始时间</th>
				<th data-options="field:'endTime',width:20,align:'center'">结束时间</th>
				<th
					data-options="field:'status',width:20,align:'center',formatter: function(value,row){
					if(row){
						if(row.status==6){
							return '审批中';
						}
						if(row.status==7){
							return '审批通过';
						}
						if(row.status==8){
							return '审批驳回';
						}
					}
				}">状态</th>
			</tr>
		</thead>
	</table>


	<div id="win">
		<form id="form" method="post">

			<p>
				开始日期：<input id="dd1" type="text" class="easyui-datebox" required="required" name="beginTime">
			</p>
			<p>
				结束日期：<input id="dd2" type="text" class="easyui-datebox" required="required" name="endTime">
			</p>
			<p>
				请假事由：<input class="easyui-textbox" data-options="multiline:true,iconCls:'',prompt:'请输入请假事由.',required:true" style="width: 175px; height: 50px;" id="why" name="why">
			</p>
			<p>
				<a style="margin-left: 35%" id="btn" class="easyui-linkbutton" data-options="iconCls:''" onclick="closeit()">取消</a> <b style="margin-left: 10px" class="easyui-linkbutton" data-options="iconCls:''"
					onclick="submitForm()">提交</b>
			</p>
		</form>
	</div>
</body>
</html>