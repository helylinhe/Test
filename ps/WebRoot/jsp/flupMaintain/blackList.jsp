<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>上海市区域医疗行为监管平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/apssysframe.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/content.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script>var path='<%=path%>';</script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>	
		<script type="text/javascript" src="<%=path%>/js/flupMaintain/blackList.js"></script>

		<script>
	//打开修改窗体
	function edit_editbinli_winopen() {

		$("#edit_editbinli_html").window("open");
	}
	//关闭修改窗体
	function edit_editbinli_winclose() {
		$("#edit_editbinli_html").window("close");
	}
</script>
	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body>
		<script>
	
</script>
		<!-- Content Layout -->
		<div style="border: 0px; font-size: 12px;">
			<div
				style="width: 96%; height: 80px; margin-left: 10px; margin-top: 15px; min-width:1100px">
				<fieldset style="border: 1px solid #6293BB">
					<legend>
						黑名单查询条件
					</legend>
					<table width="100%">
						<tr>
							<td nowrap="nowrap">
								&nbsp;病人编号：
								 <input type="text" style="border: 1px solid #999; width: 150px;" id='patiSerial'/>
							</td>
							
							<td nowrap="nowrap">
								&nbsp;住院号：
								<input type="text" style="border: 1px solid #999; width: 150px;" id='inpatiNumber' />
							</td>
						
							<td nowrap="nowrap">
								&nbsp;医保编号：
								<input type="text" style="border: 1px solid #999; width: 150px;" id='medicalInsuranceCode'/>
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
								<input type="text" style="border: 1px solid #999; width: 150px;" id='name'/>
							</td>
							
							<td nowrap="nowrap">
								&nbsp;状态：
								<span style="margin-right: 20px;"> <a href="javascript:void(0);" rel="0" onclick="changecolor(this);">正常</a> </span>
								<span style="margin-right: 20px;"> <a href="javascript:void(0);" rel="1" onclick="changecolor(this);">黑名单</a> </span>
							</td>
							

							<td nowrap="nowrap">
								<a href="#" onclick=;;;;;;;;;;; class="easyui-linkbutton" style="height: 24px;" icon="icon-search" id='query'>查询</a>
							</td>
						

						</tr>
					</table>
				</fieldset>
			</div>
			<div
				style="width: 96%; height: 400px; margin-left: 10px; margin-top: 5px; min-width:1100px">
				<div id="data_grid"></div>

			</div>
			<!--窗体
			<div class="easyui-window" id="edit_editbinli_html" title="黑名单编辑"
				style="width: 680px; height: 550px; line-height: 460px; overflow: auto;"
				closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">
				<iframe src="../page/editBlackliskInfo.html" align="center"
					frameborder="0" marginheight="0" marginwidth="0" name="relnews"
					id="newframe" scrolling="no" style="width: 100%; height: 100%;"></iframe>
			</div>
--->

			<div id="add_black" style="width: 520px; height: 150px; model: true;"
				closed="true" draggable="true" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false" class="easyui-window"
				title="录入黑名单原因">
				<table style="width: 490px; margin-left: 10px; margin-top: 10px;">
					<tr>
						<td>
							原因：
							<input style="border: 1px solid #999; width: 440px;" id='content'/>
						</td>
					</tr>
					<tr>
						<td align="center">
							<a href="#" class="easyui-linkbutton" icon="icon-save" id='sava'>保存</a>
							<a href="#" class="easyui-linkbutton" icon="icon-cancel"
								onclick="javascript:$('#add_black').window('close');">取消</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>

