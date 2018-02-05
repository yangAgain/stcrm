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
	
</script>
</head>
<body>
	<div id="tb"></div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/workAttendanceController/getMyWa.do',
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
				<th data-options="field:'time',width:20">日期</th>
				<th
					data-options="field:'oneCheck',width:20,formatter: function(value,row){
					if(row){
						if(row.oneCheck==1){
							return '正常出勤';
						}
						if(row.oneCheck==2){
							return '迟到';
						}
						if(row.oneCheck==3){
							return '请假';
						}
						if(row.oneCheck==4){
							return '早退';
						}
						if(row.oneCheck==5){
							return '旷课';
						}
					}else{
					return '-';
					}
				}">早晨考勤</th>
				<th
					data-options="field:'twoCheck',width:20,formatter: function(value,row){
					if(row){
						if(row.oneCheck==1){
							return '正常出勤';
						}
						if(row.oneCheck==2){
							return '迟到';
						}
						if(row.oneCheck==3){
							return '请假';
						}
						if(row.oneCheck==4){
							return '早退';
						}
						if(row.oneCheck==5){
							return '旷课';
						}
					}else{
					return '-';
					}
				}">中午考勤</th>
				<th
					data-options="field:'threeCheck',width:20,formatter: function(value,row){
					if(row){
						if(row.oneCheck==1){
							return '正常出勤';
						}
						if(row.oneCheck==2){
							return '迟到';
						}
						if(row.oneCheck==3){
							return '请假';
						}
						if(row.oneCheck==4){
							return '早退';
						}
						if(row.oneCheck==5){
							return '旷课';
						}
					}else{
					return '-';
					}
				}">晚上考勤</th>
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