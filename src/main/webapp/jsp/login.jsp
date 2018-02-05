<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	function login() {
		$('#form').form({
			url : "/stcrm/userController/login.do",
			onSubmit : function() {
				var temp = $(this).form('validate');
				if (!temp) {
					$.messager.alert('提示', '用户名或密码未输入!', "error");
				}
				return temp;
			},
			success : function(data) {
				if (data == "loginsuccess") {
					window.location.href = '/stcrm/main.jsp'
				}
				if (data == "loginfail") {
					$.messager.alert('提示', '用户名或密码错误!', "error");
					setTimeout(function() {
						$(".messager-body").window('close');
						$("#form").form("clear");
					}, 1000);
				}
			}
		});
		$('#form').submit();
	}
	
</script>

</head>
<body>
	
	<form id="form">
		<div style="margin: 0 auto; width: 400px; margin-top: 10%">
			<div style="margin: 20px 0; margin: 0 auto;"></div>
			<div class="easyui-panel" title="登录" style="width: 100%; max-width: 400px; padding: 30px 60px;">
				<div style="margin-bottom: 10px">
					<input class="easyui-textbox" style="width: 100%; height: 40px; padding: 12px" data-options="prompt:'请输入账户名',required:true,missingMessage:'必填',iconCls:'icon-man',iconWidth:38" id="email"
						name="username">
				</div>
				<div style="margin-bottom: 20px">
					<input class="easyui-textbox" type="password" style="width: 100%; height: 40px; padding: 12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38,required:true,missingMessage:'必填'"
						name="password">
				</div>
				<div>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding: 5px 0px; width: 100%;" onclick="login()"> <span style="font-size: 14px;">登录</span></a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>