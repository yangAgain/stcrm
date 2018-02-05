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
	$(function() {
		$
				.ajax({
					url : '/stcrm/menuController/getRolePermission.do?roleid=${user.roleid}',
					success : function(data) {
						show(data);
					}
				});
		if ("${user.id}" == "") {
			window.location.href = "/stcrm/login.jsp";
		}
	})
	function openTab(text, url) {
		if ($("#tabs").tabs("exists", text)) {
			$("#tabs").tabs("select", text);
		} else {
			var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/jsp/"
					+ url + "'></iframe>";
			$("#tabs").tabs("add", {
				title : text,
				closable : true,
				content : content
			});
		}
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
					"iconCls" : "icon-ok",
					attributes : {
						url : data.list[i].children[j].url
					}
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
			data : $.parseJSON(dddd),
			onClick : function(node) {
				if (node.attributes.url) {
					openTab(node.text, node.attributes.url);
				}
			}
		});
	}
	function logout() {
		window.location.href = "/stcrm/login.jsp";
	}
</script>
<style type="text/css">
a {
	cursor: pointer;
}
</style>
</head>

<body class="easyui-layout">

	<div region="north" style="height: 84px; background-color: #E0ECFF">

		<table style="padding: 5px; width: 100%">
			<tr>
				<td width="50%"><img src="./image/logo.png" /><font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${user.truename}</font> <font size="3">&nbsp;&nbsp;<a onclick="logout()">退出登录</a></font></td>
				<td valign="bottom" align="right" width="50%"></td>
			</tr>
		</table>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" data-options="iconCls:'icon-home'">
				<div align="center" style="padding-top: 100px">
					<font color="red" size="7">欢迎使用</font>
				</div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 200px" title="导航菜单" split="true">
		<ul id="tt"></ul>
	</div>
	<div region="south" style="height: 25px; padding: 5px;" align="center">
		版权所有 java知识分享网 <a href="http://www.java1234.com" target="_blank">http://www.java1234.com</a> (2013-2015)
	</div>
	<div id="dlg-buttons">
		<a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a> <a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>