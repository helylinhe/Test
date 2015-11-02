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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>诊断组维护</title>
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/apssysframe.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/content.css" />
		<script type="text/javascript"
			src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"> var path='<%=path%>'</script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
	    <script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/flupMaintain/diagGroup.js"></script>
	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body class="easyui-layout">
		<div region="center" style="border: 0px;" onmouseup="keyMove(event)">
			<!--全局95%;margin-left:20--->
			<div
				style="width: 90%; height: 80px; margin-left: 10px; margin-top: 15px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						诊断组查询
					</legend>
					<table id="tb23" cellspacing="0" cellpadding="0" margin="0"
						style="width: 100%; height: 50px;">
						<tr>
							<td nowrap="nowrap">
							&nbsp;&nbsp;&nbsp;所属科室：
							<select style="width: 120px; border: 1px solid #999;" class="easyui-combobox" id= "deptCode"></select>
							</td>
							<td nowrap="nowrap">
							&nbsp;&nbsp;&nbsp;分组名称：<input style="width: 120px; border: 1px solid #999;"
									id="groupName"  />
							</td>
							<td nowrap="nowrap">
							<a href="#" class="easyui-linkbutton" icon="icon-search"
									id="item_search" onclick="javascript:serach()">查询</a>
							</td>
							<td>
							</td>
							<td nowrap="nowrap">
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<!--随访项目table-->
			<div style="width: 40%; margin-left: 10px; margin-top: 5px; float: left;">
				<table id="flupitem_table" style="width: 100px"></table>
			</div>
			<div style="width: 40%; margin-left: 30px; margin-top: 5px;float: left; ">
				<table id="flupitem_table2" ></table>
			</div>
			
		<!--添加诊断组-->	
			<div id="add_group_item"
				style="width: 400px; height: 220px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="新增诊断组">
				<form method="post" id="add_item_form2">
					<table style="width: 96%; margin-left: 10px; margin-top: 10px;">
						<tr>
							<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所属科室：
								 <select style="width: 120px; border: 1px solid #999;" class="easyui-combobox"
											id="hdeptCode"></select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分组类型：
								<select style="width: 120px; border: 1px solid #999;" class="easyui-combobox"
									id="groupType">
										<option value="0" selected="selected">请选择</option>
										<option value="1">诊断分组</option>
										<option value="2">手术分组</option>
									</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分组名称：
								<input style="width: 120px; border: 1px solid #999;"
									id="ggroupName"  />
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="#" class="easyui-linkbutton" icon="icon-save"
									onclick="javascript:addGroup()">保存</a>
								<a href="#" class="easyui-linkbutton" icon="icon-cancel"
										onclick=
											 "$('#add_group_item').window('close')";
										>退出</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			
			<!--修改诊断组-->	
			<div id="update_group_item"
				style="width: 400px; height: 220px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="修改诊断组">
				<form method="post" id="add_item_form1">
					<table id="tb1" style="width: 96%; margin-left: 10px; margin-top: 10px;">
					<tr>
					<td colspan="2">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所属科室：
						 <select style="width: 120px; border: 1px solid #999;" class="easyui-combobox"
									id="udeptCode"></select>
					</td>
					</tr>
					<tr>
							<td colspan="2">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分组类型：
								<select style="width: 120px; border: 1px solid #999;" class="easyui-combobox"
									id="ugroupType">
										<option value="1">诊断分组</option>
										<option value="2">手术分组</option>
									</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分组名称：
								<input style="width: 120px; border: 1px solid #999;"
									id="ugroupName"  />
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="#" class="easyui-linkbutton" icon="icon-save"
									onclick="javascript:updateGroup()">保存</a>
								<a href="#" class="easyui-linkbutton" icon="icon-cancel"
										onclick=
											"$('#update_group_item').window('close')";
										>退出</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<!--新增--->
			<div id="add_flup_item"
				style="width: 400px; height: 200px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="新增">
				<form method="post" id="add_item_form" onmouseup="keyMove(event)">
					<table style="width: 96%; margin-left: 10px; margin-top: 10px;">
						<tr>
							<td colspan="2">
							</td>
							<td>&nbsp;<label id="lab_groupName"></label>：
								<input type="text" style="width: 200px; border: 1px solid #999;" id="idiagName" onkeyup="keyDown(this)" />
								<input type="hidden" id ="idiagCode"/>
								<input type="hidden" id ="groupType3"/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="#" class="easyui-linkbutton" icon="icon-save"
									onclick="javascript:add()">保存</a>
								<a href="#" class="easyui-linkbutton" icon="icon-cancel"
									onclick=
										"$('#add_flup_item').window('close')";
>退出</a>
							</td>
						</tr>
					</table>
				</form>
				<div
				style="width: 300px; height: 200px; position: absolute; "
				class="easyui-panel" id="confast_div">
				<div id="confast_tab" class="easyui-datagrid"></div>
				</div>
			</div>
			<!-- 
			<div id="add_flup_item"
				style="width: 400px; height: 200px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="新增手术详细信息">
				<form method="post" id="add_item_form" onmouseup="keyMove(event)">
					<table style="width: 96%; margin-left: 10px; margin-top: 10px;">
						<tr>
							<td colspan="2">
							</td>
							<td>&nbsp;手术名称：
								<input type="text" style="width: 200px; border: 1px solid #999;" id="icd9Name" onkeyup="keyDown(this)" />
								<input type="hidden" id ="idiagCode2"/>
								<input type="hidden" id="groupType3"/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="#" class="easyui-linkbutton" icon="icon-save"
									onclick="javascript:add()">保存</a>
								<a href="#" class="easyui-linkbutton" icon="icon-cancel"
									onclick=
										"$('#add_flup_item').window('close')";
>退出</a>
							</td>
						</tr>
					</table>
				</form>
				<div
				style="width: 210px; height: 200px; position: absolute; "
				class="easyui-panel" id="confast_div">
				<div id="confast_tab" class="easyui-datagrid"></div>
				</div>
			</div>
			 -->
		<!--修改--->
			<div id="upd_flup_item"
				style="width: 800px; height: 200px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="项目操作" onmouseup="keyMove(event)">

				<form method="post" id="upd_item_form">
					<table style="width: 96%; margin-left: 10px; margin-top: 10px;">
						<tr>
							<td colspan="2">
								诊断组名称：
								<input style="width: 120px; border: 1px solid #999;"
									id="uigroupName"   readonly="readonly"/>
							</td>
							<td>&nbsp;诊断名称：
								<input type="text" style="width: 400px; border: 1px solid #999;" id="udiagName" onkeyup="ukeyDown(this)" />
								<input type="hidden" id ="udiagCode"/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="#" class="easyui-linkbutton" icon="icon-save"
									onclick="javascript:updateItem()">保存</a>
								<a href="#" class="easyui-linkbutton" icon="icon-cancel"
									onclick="$('#upd_flup_item').window('close')";
									>退出</a>
							</td>
						</tr>
					</table>
				</form>
				<div
					style="width: 210px; height: 100px; position: absolute; "
						class="easyui-panel" id="uconfast_div">
							<div id="uconfast_tab" class="easyui-datagrid"></div>
				</div>
			</div>
		</div>
	</body>
</html>