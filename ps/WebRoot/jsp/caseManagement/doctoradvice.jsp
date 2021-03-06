<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<base href="<%=basePath%>">
    <head>
    <title>上海市区域医疗行为监管平台</title>
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
		<script type="text/javascript" src="<%=path%>/js/caseManagement/doctoradvice.js"></script>

	</head>

	<body>
		<div style="border: 0px; font-size: 12px;">
			<div
				style="width: 96%; height: auto; margin-left: 10px; margin-top: 15px;"
				id="firsttreat">
				<fieldset
					style="border: 1px solid #6293BB; width: 90%; height: auto;">
					<legend>
						病人信息查询条件
					</legend>
					<table width="100%" style="margin-bottom: 5px">
						<tr>
							<td nowrap="nowrap">
								&nbsp;所属院区：
								<select id="unitCode" style="width: 100px">
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp;住&nbsp;院&nbsp;号：
								<input type="text" style="width: 124px; border: 1px solid #999;" id="inpatiNumber" />
							</td>
							<td nowrap="nowrap">
								&nbsp;医保编号：
								<input type="text"  style="width: 124px; border: 1px solid #999;" id="medicalInsuranceCode" />
							</td>
							<td nowrap="nowrap">
								&nbsp;姓名：
								<input type="text"  style="width: 124px; border: 1px solid #999;" id="serachname" />
							</td>
							<td nowrap="nowrap" style="width:40%" >
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search" onclick="javascript:searchInfo()">查询</a>
							</td>
						</tr>
						
					</table>
				</fieldset>
				
			</div>
			</div>
			<div
				style="width: 96%; height: auto; margin-left: 10px; margin-top: 15px;"
				id="tdll">
				<fieldset
					style="border: 1px solid #6293BB; width: 90%; height: auto;">
					<legend>
						医嘱查询
					</legend>
					<table width="90%" style="margin-bottom: 5px">
						<tr>
								<td nowrap="nowrap">
								&nbsp;&nbsp;&nbsp;&nbsp;姓名：
									<input type="text" style="border:0px; width:110px;"  id="serachname2" disabled="disabled" />
								</td>
								<td nowrap="nowrap">
								医保编号：
								<input type="text" style="border:0px; width:110px;"  id="patiSerial2" disabled="disabled" /><input style="width:5px;"  type="hidden" id="inpatiSerialNumber2">
								</td>
								<td nowrap="nowrap">
								住&nbsp;院&nbsp;号：
								<input type="text" style="border:0px; width:110px;"  id="inpatiNumber2" disabled="disabled" />
								</td>
								<td nowrap="nowrap">
								住院流水号：
								<input type="text" style="border:0px; width:110px;"  id="medicalInsuranceCode2" disabled="disabled" />
								</td>
								 
						</tr>
						<tr>
								<td nowrap="nowrap">
								住院日期：
								<input type="text" style="border:0px; width:110px;"  id="inHospitalDate2" disabled="disabled" />
								</td>
								<td nowrap="nowrap">
								出院日期：
								<input type="text" style="border:0px; width:110px;"  id="outHospitalDate2" disabled="disabled" />
								</td>
						</tr>
						<tr>
								<td nowrap="nowrap">
								医嘱周期：&nbsp;<select style="width: 110px;" class="easyui-combobox" id="repeatIndicator">
									<option selected="selected" value="">不限</option>
									<option value="1">长期</option>
									<option value="0">临时</option>
									</select>
								</td>
								<td  nowrap="nowrap">
									下达时间：
									<input type="text" id="startDateTime" style="width: 110px;border:1px solid #999;" />
									-
									<input type="text" id="stopDateTime" style="width: 110px;border:1px solid #999;" />
								</td>
								<td nowrap="nowrap" style="width:40%" >
									<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search" onclick="javascript:searchDoctor()">查询</a>
								</td>
						</tr>
					
					</table>
				</fieldset>
			</div>
			
			<div
				style="width: 95%; height: 500px; margin-left: 5px; margin-top: 5px;min-width:1100px">
				<div id="doctoradvice_show">
				
				</div>
			
			<!-- 弹出层 -->
			<div class="easyui-window" title="患者姓名查询" style="height: 375px;" 
			closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" id="show_pati_html">
				<table style="width: 850px;" id="tab_pati">
					
				</table>
			</div>
			
		</div>
	</body>
</html>
