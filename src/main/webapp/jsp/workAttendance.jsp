<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	function updateit(id, truename, one, two, three) {
		$('#win').window('open');
		$('#cc1').combobox({
			editable : false,
			url : '/stcrm/workAttendanceController/getWa.do',
			valueField : 'id',
			textField : 'name'
		});
		$('#cc2').combobox({
			editable : false,
			url : '/stcrm/workAttendanceController/getWa.do',
			valueField : 'id',
			textField : 'name'
		});
		$('#cc3').combobox({
			editable : false,
			url : '/stcrm/workAttendanceController/getWa.do',
			valueField : 'id',
			textField : 'name'
		});
		if (one != "null") {
			$('#cc1').combobox("setValue", one);
		}
		if (two != "null")
			$('#cc2').combobox("setValue", two);
		if (three != "null")
			$('#cc3').combobox("setValue", three);
		$("#stuname").textbox("setValue", truename);
		$("#ppp").html("<a onclick='refer(" + id + ")'>确认修改</a>")
	}
	var ff = function(value, row, index) {
		return "<a id='a" + row.id + "' onclick='javascript:updateit(" + row.id
				+ ",\"" + row.truename + "\"" + ",\""
				+ row.workAttendanceModel.oneCheck + "\"" + ",\""
				+ row.workAttendanceModel.twoCheck + "\"" + ",\""
				+ row.workAttendanceModel.threeCheck + "\"" + ");'>修改</a>";
	}
	function refer(id) {
		if ($('#cc1').combobox("getValue") == ""
				|| $('#cc1').combobox("getValue") == ""
				|| $('#cc1').combobox("getValue") == "") {
			$.messager.alert('警告', "表单未填写完成");
			return;
		}
		$.ajax({
			url : "/stcrm/workAttendanceController/insertWa.do",
			type : "POST",
			data : "auserid=" + id + "&time=" + $("#dd").datebox("getValue")
					+ "&oneCheck=" + $('#cc1').combobox("getValue")
					+ "&twoCheck=" + $("#cc2").combobox("getValue")
					+ "&threeCheck=" + $("#cc3").combobox("getValue"),
			dataType : "text",
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',//防止乱码
			success : function(data) {
				$("#table").datagrid("reload");
				$("#win").window("close");
			}
		});
	}
	function searchit() {
		$("#table").datagrid(
				{
					url : '/stcrm/userController/getStu.do?timeT='
							+ $("#dd").datebox("getValue"),
				});
	}
	function referbatch(auserid) {
		if ($('#cc1').combobox("getValue") == ""
				|| $('#cc1').combobox("getValue") == ""
				|| $('#cc1').combobox("getValue") == "") {
			$.messager.alert('警告', "表单未填写完成");
			return;
		}
		$.ajax({
			url : "/stcrm/workAttendanceController/insertbatchWa.do",
			type : "POST",
			data : "auserid=" + auserid + "&time="
					+ $("#dd").datebox("getValue") + "&oneCheck="
					+ $('#cc1').combobox("getValue") + "&twoCheck="
					+ $("#cc2").combobox("getValue") + "&threeCheck="
					+ $("#cc3").combobox("getValue"),
			dataType : "text",
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',//防止乱码
			success : function(data) {
				$("#table").datagrid("reload");
				$("#win").window("close");
			}
		});
	}
	$(function() {
		$('#dd').datebox({
			editable : false,
			required : true,
		});
		var curr_time = new Date();
		var strDate = curr_time.getFullYear() + "-";
		strDate += curr_time.getMonth() + 1 + "-";
		strDate += curr_time.getDate() + "-";
		strDate += curr_time.getHours() + ":";
		strDate += curr_time.getMinutes() + ":";
		strDate += curr_time.getSeconds();
		$("#dd").datebox("setValue", strDate);
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
		});
	})
	function updatebatch() {
		var c = $("#table").datagrid("getChecked");
		if (c.length == 0) {
			$.messager.alert('提示', '请选中列表记录后再修改');
			return;
		}
		var auserid = "";
		for (var i = 0; i < c.length; i++) {
			auserid += "," + c[i].id;
		}
		$("#ppp").html('<a onclick="referbatch(\'' + auserid + '\')">确认修改</a>');
		$('#win').window('open');
		$('#cc1').combobox({
			editable : false,
			url : '/stcrm/workAttendanceController/getWa.do',
			valueField : 'id',
			textField : 'name'
		});
		$('#cc2').combobox({
			editable : false,
			url : '/stcrm/workAttendanceController/getWa.do',
			valueField : 'id',
			textField : 'name'
		});
		$('#cc3').combobox({
			editable : false,
			url : '/stcrm/workAttendanceController/getWa.do',
			valueField : 'id',
			textField : 'name'
		});
		$("#stuname").textbox("setValue", "选中的记录");

	}
</script>
</head>
<body>
	<h2 style="text-align: center;">学生考勤管理</h2>
	<div id="tb">
		当前班级： 选择日期：<input id="dd" type="text"></input><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="updatebatch()">批量修改</a> <a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="searchit()">查询</a>
	</div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/userController/getStu.do',
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
				<th data-options="field:'cb',checkbox:'true'"></th>
				<th data-options="field:'truename',width:20">姓名</th>
				<th
					data-options="field:'oneCheck',width:20,formatter: function(value,row){
					if(row.workAttendanceModel){
						if(row.workAttendanceModel.oneCheck==1){
							return '正常出勤';
						}
						if(row.workAttendanceModel.oneCheck==2){
							return '迟到';
						}
						if(row.workAttendanceModel.oneCheck==3){
							return '请假';
						}
						if(row.workAttendanceModel.oneCheck==4){
							return '早退';
						}
						if(row.workAttendanceModel.oneCheck==5){
							return '旷课';
						}
					}else{
					return '-';
					}
				}">早晨考勤</th>
				<th
					data-options="field:'twoCheck',width:20,formatter: function(value,row){
					if(row.workAttendanceModel){
						if(row.workAttendanceModel.twoCheck==1){
							return '正常出勤';
						}
						if(row.workAttendanceModel.twoCheck==2){
							return '迟到';
						}
						if(row.workAttendanceModel.twoCheck==3){
							return '请假';
						}
						if(row.workAttendanceModel.twoCheck==4){
							return '早退';
						}
						if(row.workAttendanceModel.twoCheck==5){
							return '旷课';
						}
					}else{
					return '-';
					}
				}">中午考勤</th>
				<th
					data-options="field:'threeCheck',width:20,formatter: function(value,row){
					if(row.workAttendanceModel){
						if(row.workAttendanceModel.threeCheck==1){
							return '正常出勤';
						}
						if(row.workAttendanceModel.threeCheck==2){
							return '迟到';
						}
						if(row.workAttendanceModel.threeCheck==3){
							return '请假';
						}
						if(row.workAttendanceModel.threeCheck==4){
							return '早退';
						}
						if(row.workAttendanceModel.threeCheck==5){
							return '旷课';
						}
					}else{
					return '-';
					}
				}">晚上考勤</th>
				<th data-options="field:'h',width:20,formatter: ff">操作</th>
			</tr>
		</thead>
	</table>
	<div id="win">
		<p>
			学生姓名： <input class="easyui-textbox" id="stuname" data-options=" editable:false"> 早晨考勤：<input id="cc1" name="dept" value="">
		</p>
		<p>
			中午考勤：<input id="cc2" name="dept" value=""> 晚上考勤：<input id="cc3" name="dept" value="">
		</p>
		<p style="text-align: center; font-size: 22px;" id="ppp"></p>
	</div>

</body>
</html>