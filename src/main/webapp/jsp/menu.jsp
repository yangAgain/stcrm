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
		return "<a onclick='javascript:changePermission(" + row.id
				+ ");'>修改角色权限</a>";
	}
	$(function() {
		$('#win').window({
			title : '修改角色权限',
			width : 300,
			height : 410,
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
	function changePermission(id) {
		$.ajax({
			url : '/stcrm/menuController/getPermission.do?roleid=' + id,
			success : function(data) {
				show(data);
			}
		});
		$("#ppp").html("<a onclick='submitit(" + id + ")'>保存</a>")
		$("#win").window("open");
	}
	function show(data) {
		var json1length = data.list.length;
		var bigjson = "";
		for (var i = 0; i < json1length; i++) {
			var json = "";
			var json1 = {
				id : data.list[i].id,
				text : data.list[i].permissionName,
				state : 'open',
			};
			json += JSON.stringify(json1);
			json = json.replace(/}/, '');
			json = json.replace(/{/, '');
			var json2length = data.list[i].children.length
			var childrenstr = "";
			for (var j = 0; j < json2length; j++) {
				var childrenjson = {
					id : data.list[i].children[j].id,
					text : data.list[i].children[j].permissionName,
					checked : data.list[i].children[j].checked,
					"iconCls" : "icon-ok",
				};
				childrenstr += JSON.stringify(childrenjson);
				childrenstr = childrenstr.replace(/}{/, '},{');
			}
			var jsontemp = $.parseJSON("[{" + json + ",\"children\":" + "["
					+ childrenstr + "]}]");
			bigjson += JSON.stringify(jsontemp);
		}
		var dddd = bigjson.replace(/\]\[/, ',').replace(/\]\[/, ',');
		$('#tt').tree({
			
			checkbox : true,
			data : $.parseJSON(dddd)
		});
	}
	function submitit(roleid) {
		var c = $("#tt").tree("getChecked");
		var allid = $('#tt').tree('getChecked', [ 'checked', 'indeterminate' ]);
		var perid = "";
		for (var i = 0; i < allid.length; i++) {
			perid += "," + allid[i].id;
		}
		$.ajax({
			url : '/stcrm/menuController/changeRolePermission.do?roleid='
					+ roleid + "&permissionid=" + perid,
			success : function(data) {
				$.messager.alert('提示', data);
			}
		});

	}
</script>
</head>
<body>
	<h2 style="text-align: center;">管理用户权限</h2>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/menuController/getRole.do',
				method:'post',
				border:false,
				fit:true,
				striped:true,
				fitColumns:true,
				">
		<thead>
			<tr>
				<th data-options="field:'rolename',width:20,align:'center'">角色</th>
				<th data-options="field:'cz',width:20,align:'center',formatter: ff">操作</th>
			</tr>
		</thead>
	</table>
	<div id="win">
		<form id="form">
			<ul id="tt"></ul>
			<h3 id="ppp"></h3>
		</form>
	</div>
</body>
</html>