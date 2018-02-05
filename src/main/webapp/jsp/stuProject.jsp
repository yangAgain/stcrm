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
		return "<a href='/stcrm/projectController/toStuPro.do?studentid="
				+ row.id + "'>查看详情</a>";
	}
</script>
</head>
<body>
	<h2 style="text-align: center;">学生项目管理</h2>
	<div id="tb"></div>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/userController/getStudent.do',
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
				<th data-options="field:'projectNumber',align:'center',width:20">已完成项目数量</th>
				<th data-options="field:'cz',width:20,align:'center',formatter:ff">操作</th>
			</tr>
		</thead>
	</table>
</body>
</html>