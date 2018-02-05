<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户关系管理系统登录</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>

<STYLE type=text/css>
BODY {
	TEXT-ALIGN: center;
	PADDING-BOTTOM: 0px;
	BACKGROUND-COLOR: #ddeef2;
	MARGIN: 0px;
	PADDING-LEFT: 0px;
	PADDING-RIGHT: 0px;
	PADDING-TOP: 0px
}

A:link {
	COLOR: #000000;
	TEXT-DECORATION: none
}

A:visited {
	COLOR: #000000;
	TEXT-DECORATION: none
}

A:hover {
	COLOR: #ff0000;
	TEXT-DECORATION: underline
}

A:active {
	TEXT-DECORATION: none
}

.input {
	BORDER-BOTTOM: #ccc 1px solid;
	BORDER-LEFT: #ccc 1px solid;
	LINE-HEIGHT: 20px;
	WIDTH: 182px;
	HEIGHT: 20px;
	BORDER-TOP: #ccc 1px solid;
	BORDER-RIGHT: #ccc 1px solid
}

.input1 {
	BORDER-BOTTOM: #ccc 1px solid;
	BORDER-LEFT: #ccc 1px solid;
	LINE-HEIGHT: 20px;
	WIDTH: 120px;
	HEIGHT: 20px;
	BORDER-TOP: #ccc 1px solid;
	BORDER-RIGHT: #ccc 1px solid;
}
</STYLE>
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
	<FORM id=form>
		<DIV></DIV>
		<TABLE style="MARGIN: auto; WIDTH: 100%; HEIGHT: 100%" border=0 cellSpacing=0 cellPadding=0>
			<TBODY>
				<TR>
					<TD height=150>&nbsp;</TD>
				</TR>
				<TR style="HEIGHT: 254px">
					<TD>
						<DIV style="MARGIN: 0px auto; WIDTH: 936px">
							<IMG style="DISPLAY: block" src="/stcrm/images/body_03.jpg">
						</DIV>
						<DIV style="BACKGROUND-COLOR: #278296">
							<DIV style="MARGIN: 0px auto; WIDTH: 936px">
								<DIV style="BACKGROUND: url(/stcrm/images/body_05.jpg) no-repeat; HEIGHT: 155px">
									<DIV style="TEXT-ALIGN: left; WIDTH: 265px; FLOAT: right; HEIGHT: 125px; _height: 95px">
										<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%">
											<TBODY>
												<TR>
													<TD style="HEIGHT: 45px"><input class="easyui-textbox" style="width: 80%; height: 30px; padding: 12px"
														data-options="prompt:'请输入账户名',required:true,missingMessage:'必填',iconCls:'icon-man',iconWidth:38" id="email" name="username"></TD>
												</TR>
												<TR>
													<TD><input class="easyui-textbox" type="password" style="width: 80%; height: 30px; padding: 12px"
														data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38,required:true,missingMessage:'必填'" name="password"></TD>
												</TR>
												<TR>
												</TR>
											</TBODY>
										</TABLE>
									</DIV>
									<DIV style="HEIGHT: 1px; CLEAR: both"></DIV>
									<DIV style="WIDTH: 380px; FLOAT: right; CLEAR: both">
										<TABLE border=0 cellSpacing=0 cellPadding=0 width=300>
											<TBODY>

												<TR>
													<TD width=100 align=right><a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding: 5px 0px; background: #e7e5e6; width: 124%; margin-left: 5px"
														onclick="login()"> <span style="font-size: 12px;">登录</span>
													</a></TD>
												</TR>
											</TBODY>
										</TABLE>
									</DIV>
								</DIV>
							</DIV>
						</DIV>
						<DIV style="MARGIN: 0px auto; WIDTH: 936px">
							<IMG src="/stcrm/images/body_06.jpg">
						</DIV>
					</TD>
				</TR>
				<TR style="HEIGHT: 30%">
					<TD>&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</body>
</html>
