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
		<script type="text/javascript" src="<%=path%>/js/flupMaintain/dynamicFlupName.js"></script>

  </head>
  
  <body>
    	<div style="border: 0px; font-size: 12px;">
			<div
				style="width: 96%; height: 80px; margin-left: 10px; margin-top: 15px; min-width:1100px">
				<fieldset style="border: 1px solid #6293BB">
					<legend>
						动态报表查询条件
					</legend>
					<table width="100%">
						<tr>
							<td nowrap="nowrap" align="center">
								&nbsp;报表名称：
								 <input type="text" style="border: 1px solid #999; width: 150px;" id='reportName'/>
							</td>
							<td nowrap="nowrap" >
								&nbsp;所属科室：
								<select id="inDept" class="easyui-combobox" style="width:150px;"></select>
							</td>
							<td nowrap="nowrap">
								<a href="javascript:void(0);"  class="easyui-linkbutton" style="height: 24px;" icon="icon-search" id='query'>查询</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div
				style="width: 96%; height: 400px; margin-left: 10px; margin-top: 5px; min-width:1100px">
				<div id="data_grid"></div>
			</div>
			<div id="add_report" style="width:530px; height: 240px; model: true;"
				closed="true" draggable="true" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false" class="easyui-window"
				title="添加动态报表信息">
				<form id="add_fm" method="post">
				<input type="hidden" name="reportName1.status" value="1">
				<input type="hidden" name="reportName1.menuName" id="reportMenuName" value="">
				<table style="width: 490px; margin-left: 10px; margin-top: 10px;">
					<tr>
						<td>
							报表名称：
							<input class="easyui-validatebox" required="true" missingMessage="不能为空！" type="text" name="reportName1.reportName" style="width: 150px;">
						</td>
						<td>
							所属科室：
							<select id="inDept1" name="reportName1.deptCode" class="easyui-combobox" style="width:150px;"></select>
						</td>
					</tr>
					<tr>
						<td>
							所属院区：
							<select id="unitCode1" class="easyui-combobox"  name="reportName1.unitCode" style="width: 154px;">
								<option value="1" selected="selected">北院</option>
								<option value="2">南院</option>
							</select>
						</td>
						<td>
							状　　态：
							<select class="easyui-combobox" id="mumeName" name="reportName1.menuNo" style="width: 154px;">
								<option value="1" selected="selected">动态报表</option>
								<option value="9d648601-4cf0-480a-a16c-eb83858525d6">首次治疗情况</option>
							</select>
							<input id="opreateDate1" type="hidden" name="reportName1.opreateDate" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-save" id='add_report' onclick="javascript:add_rpt()">添加</a>
							<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-cancel" 
							onclick="javascript:$('#add_report').window('close');">取消</a>
						</td>
					</tr>
				</table>
				</form>
			</div>
			<div id="edit_report" style="width: 530px; height: 240px; model: true;"
				closed="true" draggable="true" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false" class="easyui-window"
				title="修改动态报表信息">
				<form id="edit_fm" method="post">
				<table style="width: 490px; margin-left: 10px; margin-top: 10px;">
					<tr>
						<td>
							报表名称：
							<input class="easyui-validatebox" required="true" missingMessage="不能为空！"  type="text" name="reportName2.reportName" id="reportName2" style="width: 150px;">
							<input type="hidden" name="reportName2.id" id="id2"/>
						</td>
						<td>
							所属科室：
							<select id="inDept2" name="reportName2.deptCode" class="easyui-combobox" style="width:150px;"></select>
						</td>
					</tr>
					<tr>
						<td>
							所属院区：
							<select class="easyui-combobox"  name="reportName2.unitCode" id="unitCode2" style="width: 154px;">
								<option value="1" >北院</option>
								<option value="2">南院</option>
							</select>
						</td>
						<td>
							状　　态：
							<select class="easyui-combobox" id="mumeName" name="reportName2.menuNo" style="width: 154px;">
								<option value="1" selected="selected">动态报表</option>
								<option value="9d648601-4cf0-480a-a16c-eb83858525d6">首次治疗情况</option>
							</select>
							<input id="opreateDate2" type="hidden" name="reportName2.opreateDate" style="width: 150px;"/>
							
						</td>
						
					</tr>
					<tr>
						<td align="center" colspan="2">
							<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-save" id='edit_report' onclick="javascript:edit_rpt();">保存</a>
							<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-cancel"
								onclick="javascript:$('#edit_report').window('close');">取消</a>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		
  </body>
</html>