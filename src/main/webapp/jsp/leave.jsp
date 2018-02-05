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

a{
cursor: pointer;
}
</style>

<script type="text/javascript">
	var ff = function(value, row, index) {
		return "<a style='color:red;' onclick='javascript:zcps(" + row.id + "," + row.userid
				+ ");'>做出批示</a>";
	}
	function zcps(id, userid) {
		$("#ppp")
				.html(
						'<a class="easyui-linkbutton" onclick="updateit(7,'
								+ id
								+ ','
								+ userid
								+ ')">同意申请</a><a class="easyui-linkbutton" onclick="updateit(8,'
								+ id + ',' + userid + ')">驳回申请</a>')
		$('#win').window("open");
	}
	$(function() {
		$('#win').window({
			title : '修改',
			width : 200,
			height : 200,
			closed : true,//初始时是关闭状态
			cache : false,
			modal : true,
			doSize : true,
			border : 'thin',
			collapsible : false,
			minimizable : false,
			maximizable : false,
			yIndex : 200,
		});
	})
	function updateit(a, id, userid) {
		$.ajax({
			url : "/stcrm/leaveController/updateLeave.do",
			type : "POST",
			data : "id=" + id + "&userid=" + userid + "&status=" + a,
			dataType : "text",
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',//防止乱码
			success : function(data) {
				$.messager.alert('提示', data);
				setTimeout(function() {
					$(".messager-body").window('close');
				}, 1500);
				$("#table").datagrid("reload");
				$("#win").window("close");
			}
		});
	}
</script>
</head>
<body>
	<h2 style="text-align: center;">学生请假管理</h2>

	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/leaveController/getAllLeave.do',
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
				<th data-options="field:'truename',width:10,align:'center',formatter: function(value,row){
					if(row.userModel){
						return row.userModel.truename;
					}
				}">学生</th>
				<th data-options="field:'why',width:30,align:'center'">事由</th>
				<th data-options="field:'time',width:20,align:'center'">申请时间</th>
				<th data-options="field:'beginTime',width:20,align:'center'">开始时间</th>
				<th data-options="field:'endTime',width:20,align:'center'">结束时间</th>
				<th
					data-options="field:'status',width:20,align:'center',formatter: function(value,row){
					if(row){
						if(row.status==6){
							return '还未审批';
						}
						if(row.status==7){
							return '审批通过';
						}
						if(row.status==8){
							return '审批驳回';
						}
					}
				}">状态</th>
				<th data-options="field:'cz',width:20,align:'center',formatter: ff">操作</th>
			</tr>
		</thead>
	</table>


	<div id="win">
		<p id="ppp"></p>
	</div>
</body>
</html>