<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
	<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>平台访问监控统计</title>
			<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/apssysframe.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/content.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
			<script type="text/javascript"> var path='<%=path%>';</script>
			<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
        	<script type="text/javascript" src="<%=path%>/js/platformManager/interfaceManager/premachinemanage.js"></script>
        	<script>
			</script>
	</head>

	<body>
		<div style="border: 0px; font-size: 12px;" >
			<div style="width: 96%; height: 90px; margin-left: 10px; margin-top: 15px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						信息查询
					</legend>
					<table width="80%">
						<tr>
							<td nowrap="nowrap">
								&nbsp;前置机名称：
								<input type="text" style="border: 1px solid #999; width: 120px;"
									id="machine" />
							</td>
							<td nowrap="nowrap">
								&nbsp;前置机地址：
								<input type="text" style="border: 1px solid #999; width: 120px;"
									id="ipAddress" />
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;前置机状态：
								<input type="radio" name="state" value="1"/>
								可用
								<input type="radio" name="state" value="0"/>
								停用
							</td>
							<td  align="center">
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search" onclick="searchInfo()">查询</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="width: 95%; margin-left: 10px; margin-top: 5px;">
				<table id="manager_list_tab" width="100%"></table>
			</div>
			<!-- 新增 -->
			<div id="add_preable_html" class="easyui-window"
				style="width: 510px; height: 200px; model: true;" title="前置机新增"
				closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">
				<table style="width: 480px; margin-left: 5px" id='tableData'>
					<tr></tr>
					<tr>
							<td nowrap="nowrap">
								&nbsp;前置机名称：
								<input type="text" style="border: 1px solid #999; width: 120px;" id="addmachine" />
							</td>
							<td nowrap="nowrap">
								&nbsp;前置机地址：
								<input type="text" style="border: 1px solid #999; width: 120px;" id="addipAddress" />
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;前置机端口：
								<input type="text" style="border: 1px solid #999; width: 120px;" id="addport" />
							</td>
							<td nowrap="nowrap">
								&nbsp;状态设定：
								<input type="radio" name="addstate" value="1"/>
								可用
								<input type="radio" name="addstate" value="0"/>
								停用
							</td>
						</tr>
						<tr>
							<td></td>
							<td  align="center">
								<a href="javascript:void(0);" class="easyui-linkbutton" onclick="add()">增加</a>
								<a href="javascript:void(0);" class="easyui-linkbutton" onclick="$('#add_preable_html').window('close')"
								icon="icon-cancel">退出</a>
							</td>
						</tr>
				
				
			</table>
			</div>
			<!--修改 -->
			<div id="update_preable_html" class="easyui-window"
				style="width: 510px; height: 200px; model: true;" title="前置机修改"
				closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">
				<table style="width: 480px; margin-left: 5px" id='tableData'>
					<tr></tr>
					<tr>
							<td nowrap="nowrap">
								&nbsp;前置机名称：
								<input type="text" style="border: 1px solid #999; width: 120px;" id="updatemachine" />
							</td>
							<td nowrap="nowrap">
								&nbsp;前置机地址：
								<input type="text" style="border: 1px solid #999; width: 120px;" id="updateipAddress" />
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;前置机端口：
								<input type="text" style="border: 1px solid #999; width: 120px;" id="updateport" />
							</td>
							<td nowrap="nowrap">
								&nbsp;状态设定：
								<input type="radio" name="updatestate" id="updatestate1" value="1"/>
								可用
								<input type="radio" name="updatestate" id="updatestate2" value="0"/>
								停用
							</td>
						</tr>
						<tr>
							<td><input type="hidden" id="updateid"/></td>
							<td  align="center">
								<a href="javascript:void(0);" class="easyui-linkbutton" onclick="updatepre()">修改</a>
								<a href="javascript:void(0);" class="easyui-linkbutton" onclick="$('#update_preable_html').window('close')"
								icon="icon-cancel">退出</a>
							</td>
						</tr>
				
				
			</table>
			</div>
		</div>
	</body>
</html>