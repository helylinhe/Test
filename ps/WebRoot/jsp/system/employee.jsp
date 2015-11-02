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
		<title>用户管理</title>
		<link rel="stylesheet" type="text/css"
			href="../../js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="../../js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="../../css/index.css" />
		<link rel="stylesheet" type="text/css"
			href="../../css/apssysframe.css" />
		<link rel="stylesheet" type="text/css" href="../../css/content.css" />
		<script type="text/javascript"
			src="../../js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../../js/plugin/makePy.min.js"></script>
		<script type="text/javascript"
			src="../../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="../../js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"> var path='<%=path%>'</script>
		<script type="text/javascript" src="../../js/comment/validate_common.js"></script>
		<script type="text/javascript" src="../../js/comment/comment.js"></script>
		<script type="text/javascript" src="../../js/system/employee.js"></script>
	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body onmouseup="keyMove(event)">
		<div style="border: 0px; font-size: 12px;" >
			<div
				style="width: 96%; height: 90px; margin-left: 10px; margin-top: 15px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						用户基本信息
					</legend>
					<table width="80%">
						<tr>
							<td nowrap="nowrap">
								&nbsp;工&nbsp;&nbsp;&nbsp;&nbsp;号：
								<input style="width: 120px; border: 1px solid #999;" id="jobnum" />
							</td>

							<td nowrap="nowrap">
								&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
								<input style="width: 120px; border: 1px solid #999;" id="name" />
							</td>

							<td nowrap="nowrap">
								&nbsp;所属科室：
								<input style="width: 120px; border: 1px solid #999;"
									id="deptName" onclick="openDeptTable('deptName')" />
								<input id="deptCode" type="hidden" />
							</td>
							<td nowrap="nowrap">
								&nbsp;职&nbsp;&nbsp;&nbsp;&nbsp;称：
								<input style="width: 120px; border: 1px solid #999;" id="title" />
							</td>
							<td rowspan="2">
								<a href="#" class="easyui-linkbutton" icon="icon-search"
									id="search" onclick=emp_search();>查询</a>
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;状&nbsp;&nbsp;&nbsp;&nbsp;态：
								<select style="width: 120px;" class="easyui-combobox"
									id="status">
									<option value="">不限</option>
									<option value="1">正常</option>
									<option value="0">停用</option>
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp;联系电话：
								<input style="width: 120px; border: 1px solid #999;"
									id="contactNumber" />
							</td>
							<td nowrap="nowrap">
								&nbsp;手&nbsp;&nbsp;&nbsp;&nbsp;机：
								<input style="width: 120px; border: 1px solid #999;"
									id="mobilePhone" />
							</td>
							<td nowrap="nowrap">
								&nbsp;所属角色：
								<select style="width: 125px; border: 1px solid #999;"
									id="roleCode">
									<option value="10">信息科</option>
									<option value="11">随访医生</option>
								</select>

							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="width: 96%; margin-left: 10px; margin-top: 5px;">
				<table id="emp_list_tab"></table>
				
				
			</div>

			<div id="emp_manager"
				style="width: 960px; height: 180px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="员工信息" onmouseup="keyMove(event)">
				<form method="post" id="add_form">
					<table width="95%;" style="margin-left: 10px; margin-top: 15px;">
						<tr>
							<td nowrap="nowrap">
								&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_name" class="easyui-validatebox" required="true" />
							</td>
							<td nowrap="nowrap">
								&nbsp;所属科室：
								<input style="width: 120px;border: 1px solid #999;" 
									id="add_deptName" onclick="openDeptTable('add_deptName')" placeholder="点击选择科室">
								<input id="add_deptCode" type="hidden" />
								<input id="add_unitCode" type="hidden"/>
							</td>
							
							<td>
								&nbsp;员工工号：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_jobnum"  class="easyui-validatebox" validType="checkJobnum"/>
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;职&nbsp;&nbsp;&nbsp;&nbsp;称：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_title" />
							</td>
							<td>
								&nbsp;职&nbsp;&nbsp;&nbsp;&nbsp;务：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_position" />
							</td>
							<td>
								&nbsp;所属角色：
								<select style="width: 120px; border: 1px solid #999;"
									id="add_roleCode">
									<option value="10">信息科</option>
									<option value="11">随访医生</option>
								</select>
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;联系电话：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_contactNumber" class="easyui-validatebox" validType="tel"/>
							</td>
							<td nowrap="nowrap">
								&nbsp;手&nbsp;&nbsp;&nbsp;&nbsp;机：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_mobilePhone" class="easyui-validatebox" validType="phone"/>
							</td>
							<td nowrap="nowrap">
							&nbsp;状&nbsp;&nbsp;&nbsp;&nbsp;态：
								<select style="width: 120px;" class="easyui-combobox"
									id="add_status">
									<option value="1">正常</option>
									<option value="0">停用</option>
								</select>
								
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a  class="easyui-linkbutton" icon="icon-save"
									id="add_emp" onclick=add_emp();>保存</a>
								<a class="easyui-linkbutton" icon="icon-cancel"
									onclick=emp_add_close();>取消</a>
							</td>
						</tr>
					</table>
				</form>
					<div
				style="width: 300px; height: 100px; position: absolute; top: 65px; left: 500px;"
				class="easyui-panel" id="add_dept_div">
				<table id="add_dept_tab" class="easyui-datagrid"></table>
			</div>
			</div>

			<div
				style="width: 300px; height: 100px; position: absolute; top: 65px; left: 500px;"
				class="easyui-panel" id="dept_div">
				<table id="dept_tab" class="easyui-datagrid"></table>
			</div>
			<div id="upd_manager"
				style="width: 960px; height: 180px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="员工信息">
				<form method="post" id="upd_form" onmouseup="keyMove(event)">
					<table width="95%;" style="margin-left: 10px; margin-top: 15px;">
						<tr>
							<td nowrap="nowrap">
								&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
								<input style="width: 120px; border: 1px solid #999;"
									id="upd_name" class="easyui-validatebox" required="true" />
							</td>
							<td nowrap="nowrap">
								&nbsp;所属科室：
								<input style="width: 120px;border: 1px solid #999;" 
									id="upd_deptName" onclick="openDeptTable('upd_deptName')" placeholder="点击选择科室">
								<input id="upd_deptCode" type="hidden" />
							</td>
							
							<td>
								&nbsp;员工工号：
								<input style="width: 120px; border: 1px solid #999;"
									id="upd_jobnum"  readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;职&nbsp;&nbsp;&nbsp;&nbsp;称：
								<input style="width: 120px; border: 1px solid #999;"
									id="upd_title" />
							</td>
							<td>
								&nbsp;职&nbsp;&nbsp;&nbsp;&nbsp;务：
								<input style="width: 120px; border: 1px solid #999;"
									id="upd_position" />
							</td>
							<td>
								&nbsp;所属角色：
								<select style="width: 120px; border: 1px solid #999;"
									id="upd_roleCode">
									<option value="10">信息科</option>
									<option value="11">随访医生</option>
								</select>
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;联系电话：
								<input style="width: 120px; border: 1px solid #999;"
									id="upd_contactNumber" class="easyui-validatebox" validType="tel"/>
							</td>
							<td nowrap="nowrap">
								&nbsp;手&nbsp;&nbsp;&nbsp;&nbsp;机：
								<input style="width: 120px; border: 1px solid #999;"
									id="upd_mobilePhone" class="easyui-validatebox" validType="phone"/>
							</td>
							<td nowrap="nowrap">
							&nbsp;状&nbsp;&nbsp;&nbsp;&nbsp;态：
								<select style="width: 120px;" class="easyui-combobox"
									id="upd_status">
									<option value="1">正常</option>
									<option value="0">停用</option>
								</select>
								
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a  class="easyui-linkbutton" icon="icon-save"
									id="upd_emp" onclick=upd_emp();>保存</a>
								<a class="easyui-linkbutton" icon="icon-cancel"
									onclick=emp_upd_close();
									>取消</a>
							</td>
						</tr>
					</table>
				</form>
					<div
				style="width: 300px; height: 100px; position: absolute; top: 65px; left: 500px;"
				class="easyui-panel" id="upd_dept_div">
				<table id="upd_dept_tab" class="easyui-datagrid"></table>
			</div>
			</div>
			
		</div>
	</body>
</html>