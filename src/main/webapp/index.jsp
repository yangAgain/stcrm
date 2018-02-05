<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客户关系管理系统主页</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		openTab('', 'menu.jsp', 'icon-khxxgl');
	})
	function openTab(text, url, iconCls) {
		if ($("#tabs").tabs("exists", text)) {
			$("#tabs").tabs("select", text);
		} else {
			var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/jsp/"
					+ url + "'></iframe>";
			$("#tabs").tabs("add", {
				title : text,
				iconCls : iconCls,
				closable : true,
				content : content
			});
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 78px; background-color: #E0ECFF">
		<table style="padding: 5px" width="100%">
			<tr>
				<td width="50%"><img src="./image/logo.png" /></td>
				<td valign="bottom" align="right" width="50%"><font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${user.truename}</font></td>
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
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="学生信息管理" data-options="iconCls:'icon-yxgl'" style="padding: 10px">
				<a href="javascript:openTab('个人考勤信息','myWa.jsp','icon-yxjhgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px;">个人考勤信息</a> <a
					href="javascript:openTab('作业完成状况','work.jsp','icon-yxjhgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px;">作业完成状况</a> <a
					href="javascript:openTab('我的请假申请','myLeave.jsp','icon-yxjhgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px;">我的请假申请</a> <a
					href="javascript:openTab('个人项目管理','project.jsp','icon-yxjhgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px;">个人项目管理</a><a
					href="javascript:openTab('我的问卷反馈','feedback.jsp','icon-yxjhgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px;">我的问卷反馈</a>
			</div>
			<div title="教学信息管理" data-options="selected:true,iconCls:'icon-khgl'" style="padding: 10px;">
				<a href="javascript:openTab('学生考勤管理','workAttendance.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">学生考勤管理</a> <a
					href="javascript:openTab('学生请假管理','leave.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">学生请假管理</a> <a
					href="javascript:openTab('学生作业管理','assignment.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">学生作业管理</a><a
					href="javascript:openTab('学生项目管理','stuProject.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">学生项目管理</a>
			</div>
			<div title="教务信息管理" data-options="iconCls:'icon-khgl'" style="padding: 10px;">
				<a href="javascript:openTab('讲师管理','allTeacher.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">讲师管理</a> <a
					href="javascript:openTab('学生管理','allStudent.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">学生管理</a> <a
					href="javascript:openTab('班级管理','allClass.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">班级管理</a> <a
					href="javascript:openTab('问卷管理','createQuestion.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">问卷管理</a> <a
					href="javascript:openTab('问卷题目管理','questionQa.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">问卷题目管理</a><a
					href="javascript:openTab('用户权限管理','menu.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">用户权限管理</a>
			</div>
		</div>
		<div region="south" style="height: 25px; padding: 5px;" align="center">
			版权所有 java知识分享网 <a href="http://www.java1234.com" target="_blank">http://www.java1234.com</a> (2013-2015)
		</div>
		<div id="dlg-buttons">
			<a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a> <a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
		</div>
</body>
</html>