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
	list-style: none;
	text-decoration: none;
}
</style>
<style type="text/css">
.wenjuan {
	width: 100%;
	margin-top: 20px;
	float: left;
}

.wenjuan>div {
	float: left;
	margin-left: 10%;
}
</style>
<script type="text/javascript">
	function show2(data) {
		var s = "";
		for (var i = 0; i < data.length; i++) {
			var m = i + 1;
			s += "<p><div sytle='float:left;'>第" + m + "题:" + data[i].question
					+ "</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选项A:"
					+ data[i].optionA + "B:" + data[i].optionB + "C:"
					+ data[i].optionC + "D:" + data[i].optionD + "</p>"
		}
		$("#wj").html(s);
	}
	$(function() {
		$
				.ajax({
					type : "POST",
					url : "/stcrm/questionController/getQuestion.do?id=${creatQuestion.id}",
					dataType : "json",
					success : function(data) {
						show2(data);
					}
				});
		$('#win').window({
			title : '查看问卷回答详情',
			width : 400,
			height : 400,
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
		$('#lol').click(function() {//点击a标签  
			if ($('#wj').is(':hidden')) {//如果当前隐藏  
				$('#wj').show();//那么就显示div  
			} else {//否则  
				$('#wj').hide();//就隐藏div  
			}
		})
	})
</script>
</head>
<body>
	<h2 style="text-align: center;">问卷反馈详情</h2>
	<p>
		<a href="javascript:void(0);" id="lol">></a> 当前问卷名称：${creatQuestion.questionName}&nbsp;&nbsp;&nbsp;<b id="bbb"></b>
	</p>
	<div id="wj" style="font-size: 5px;" hidden="true"></div>
	<p>学生回答情况</p>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/questionController/getStudentAnswer.do',
				method:'post',
				border:false,
				fit:true,
				striped:true,
				checkOnSelect:false,
				fitColumns:true,
				rownumbers:true,
				toolbar:'#tb'
				">
		<thead>
			<tr>
				<th data-options="field:'truename',width:10,align:'center'">姓名</th>
				<th data-options="field:'classname',width:15,align:'center'">所在班级</th>
				<th data-options="field:'answer',width:20,align:'center'">学生的答案选项</th>
			</tr>
		</thead>
	</table>
	<div id="win">
		<form id="form"></form>
	</div>

</body>
</html>