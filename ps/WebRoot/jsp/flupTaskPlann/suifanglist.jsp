<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>上海市区域医疗行为监管平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
			<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/fsuifanglist.js"></script>
			<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
  </head>
  <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
  <body>
		<!-- Content Layout -->
		<div style="border: 0px; font-size: 12px;width:100%;" onmouseup="keyMove(event)">
			<div
				style="width: 96%; height: 180px; margin-left: 5px; margin-top: 15px; min-width:1100px">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						随访病例信息查询
					</legend>
					<table width="100%">
						<tr>
							<td nowrap="nowrap" style="width: 10%">
								&nbsp;病人编号：
								<input type="text" style="width: 120px;border:1px solid #999;" id="patiSerial" />
							</td>
							<td nowrap="nowrap" style="width: 10%">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住&nbsp;院&nbsp;号：
								<input type="text" style="width: 120px;border:1px solid #999;" id="inpatiNumber" />
							</td>
							<td nowrap="nowrap" style="width: 20%">
								&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
								<input type="text" style="width: 120px;border:1px solid #999;" id="name" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;所属科室：
								<select style="width: 120px;" class="easyui-combobox" id="inDept">
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp;计划随访日期：
								<input type="text" id="flupDateStart" style="width: 120px;border:1px solid #999;" />
								-
								<input type="text" id="flupDateEnd" style="width: 120px;border:1px solid #999;" />
							</td>
							<td nowrap="nowrap">
								&nbsp;随访方式：&nbsp;<select style="width: 120px;" class="easyui-combobox" id="flupWay">
								                     </select>
							</td>
							<td nowrap="nowrap" style="width: 20%">
								&nbsp;计划随访医生：
								<input type="text" style="width: 120px;border:1px solid #999;" id="flupDoctorCode" />
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;出院诊断：
								<input type="text" style="width: 120px; border: 1px solid #999;" id="inHospDiag" onkeyup="keyDown(this)" />
								<input type="hidden" id ="diagCode"/>
							</td>
							<td nowrap="nowrap">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出院日期：
								<input type="text" id="outHospitalDateStart" style="width: 120px;border:1px solid #999;" />
								-
								<input type="text" id="outHospitalDateEnd" style="width: 120px;border:1px solid #999;" />
							</td>
							<td>&nbsp;随访状态：&nbsp;<select style="width: 120px;" class="easyui-combobox" id="flupComplete">
								<option value="">全部</option>
								<option selected="selected" value="0">未随访</option>
								<option value="1">已随访</option>
							</select></td>
							<td nowrap="nowrap">
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search" onclick="javascript:serach()">查询</a>
							</td>
							
						</tr>
						
						<tr>
						<td colspan="4"><hr/></td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td colspan="3">
								<a href="javascript:serachToday();" id="serachToday" class="easyui-linkbutton">今日随访任务</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:serachTomorrow();" id="serachTomorrow" class="easyui-linkbutton">明日随访任务</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:serachYesterday();" id="serachYesterday" class="easyui-linkbutton">昨日随访任务</a>
								
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="margin-left: 5px;marign-right:5px;width:96%;">
				<div id="blxx_list_tab"></div>
			</div>
			<div
				style="width: 220px; height: 100px; position: absolute; "
				class="easyui-panel" id="confast_div">
				<div id="confast_tab" class="easyui-datagrid"></div>
			</div>

		</div>
	</body>
</html>
