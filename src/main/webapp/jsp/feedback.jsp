<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建问卷</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>

<style type="text/css">
.wenjuan {
	width: 100%;
	margin-top: 20px;
	float: left;
}

a {
	cursor: pointer;
}

.wenjuan>div {
	float: left;
	margin-left: 10%;
}
</style>
<script type="text/javascript">
	var ff = function(value, row, index) {
		return "<a onclick='answer(" + row.id + ")'>回答问卷问题</a>"
	}
	function answer(id) {
		$.ajax({
			type : "POST",
			url : "/stcrm/questionController/getQuestion.do?id=" + id,
			dataType : "json",
			success : function(data) {
				show(data, id);
			}
		});
	}
	function show(data, id) {
		var length = data.length;
		if (length == 0) {
			$.messager.alert('提示', '该问卷暂时没有添加题目!');
			return;
		}
		var arrays = new Array();
		var s = "";
		for (var i = 0; i < length; i++) {
			arrays[i] = data[i].answer;
			s += "<div class='wenjuan'><p>问题："
					+ data[i].question
					+ "</p><p><div><p>A:"
					+ data[i].optionA
					+ "</p><P><div style='width:30px;height:20px;background:lightgreen' onclick='choose(1"
					+ i
					+ ")'><input type='radio' hidden name='radio"+i+"' id='radio1"+i+"' value='A'></div></P></div><div><p>B:"
					+ data[i].optionB
					+ "</p><P><div style='width:30px;height:20px;background:lightgreen' onclick='choose(2"
					+ i
					+ ")'><input type='radio' hidden name='radio"+i+"' id='radio2"+i+"' value='B'></div></P></div><div><p>C:"
					+ data[i].optionC
					+ "</p><P><div style='width:30px;height:20px;background:lightgreen' onclick='choose(3"
					+ i
					+ ")'><input type='radio' hidden name='radio"+i+"' id='radio3"+i+"' value='C'></div></P></div><div><p>D:"
					+ data[i].optionD
					+ "</p><P><div style='width:30px;height:20px;background:lightgreen' onclick='choose(4"
					+ i
					+ ")'><input type='radio' hidden name='radio"+i+"' id='radio4"+i+"' value='D'></div></P></div></p></div>";
		}
		s += "<div><a onclick='submitanswer(" + i + "," + id
				+ ")'>提交</a>   <a onclick='closeit()'>取消</a</div>"
		$("#form").html(s);
		radioinit(length, arrays);
		$("#win").window("open");
	}
	function radioinit(length, arrays) {
		for (var i = 0; i < arrays.length; i++) {
			if (arrays[i] == "A") {
				$("#radio1" + i).prop("checked", "checked");
			} else if (arrays[i] == "B") {
				$("#radio2" + i).prop("checked", "checked");
			} else if (arrays[i] == "C") {
				$("#radio3" + i).prop("checked", "checked");
			} else if (arrays[i] == "D") {
				$("#radio4" + i).prop("checked", "checked");
			}
		}
		$(":radio").each(function() {
			if ($(this).is(":checked")) {
				$(this).parent().css("background", "red");
			} else {
				$(this).parent().css("background", "lightgreen");
			}
		})
	}
	function submitanswer(i, cqid) {
		var a = "";
		var b = 0;
		$(":radio").each(function() {
			if ($(this).is(":checked")) {
				a = a + "," + $(this).val();
				b = b + 1;
			}
		})
		if (b != i) {
			$.messager.alert('提示', '每个题目都必须回答!', "error");
			return;
		}
		$.ajax({
			type : "POST",
			url : "/stcrm/questionController/answer1.do?creatQuestionid="
					+ cqid + "&answers=" + a,
			dataType : "text",
			success : function(data) {
				$("#table").datagrid("reload");
				$("#win").window("close");
			}
		});

	}
	function choose(a) {
		var radio = $("#radio" + a);
		radio.prop("checked", radio.is(":checked") ? false : true);
		$(":radio").each(function() {
			if ($(this).is(":checked")) {
				$(this).parent().css("background", "red");
			} else {
				$(this).parent().css("background", "lightgreen");
			}
		})
	}
	function closeit() {
		$("#win").window("close");
	}
	$(function() {
		$('#win').window({
			width : 400,
			height : 400,
			title : "问卷",
			closed : true,
			cache : false,
			modal : true,
			doSize : true,
			border : 'thin',
			collapsible : false,
			minimizable : false,
			maximizable : false,
			yIndex : 100,
			onClose : function() {
			}
		});
	})
</script>
</head>
<body>
	<h2 style="text-align: center;">问卷反馈</h2>
	<table id="table" class="easyui-datagrid" style="width: 100%"
		data-options="url:'/stcrm/questionController/allCQ.do',
				method:'post',
				border:false,
				fit:true,
				striped:true,
				checkOnSelect:false,
				fitColumns:true,
				toolbar:'#tb',
				rownumbers:true,
				">
		<thead>
			<tr>
				<th data-options="field:'questionName',width:20,align:'center'">问卷表名称</th>
				<th data-options="field:'cz',width:20,align:'center',formatter:ff">操作</th>
			</tr>
		</thead>
	</table>

	<div id="win">
		<form id="form" method="post"></form>
	</div>

</body>
</html>