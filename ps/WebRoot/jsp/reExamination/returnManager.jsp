<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>上海市区域医疗行为监管平台</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/apssysframe.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/content.css" />
		<script type="text/javascript"
			src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"> var path='<%=path%>';</script>
		<script type="text/javascript" src="<%=path%>/js/reExamination/returnManager.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
		<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>
	</head>
	<!--  
	 <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	 -->
	<body>
		<div style="border: 0px; font-size: 12px;"  onmouseup="keyMove(event)">
			<div
				style="width: 96%; height: 120px; margin-left: 10px; margin-top: 15px; min-width:1100px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						查询条件
					</legend>
					<table width="100%">
						<tr>
							<td nowrap="nowrap" style="width: 10%">
								&nbsp;病人编号：
								<input type="text" style="width: 120px;border:1px solid #999;" id="patiSerial" />
							</td>
							<td nowrap="nowrap" style="width: 10%">
								&nbsp;住&nbsp;院&nbsp;号：
								<input type="text" style="width: 120px;border:1px solid #999;" id="inpatiNumber" />
							</td>
							<td nowrap="nowrap" style="width: 20%">
							&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
								<input type="text" style="width: 120px;border:1px solid #999;" id="name" />
							</td>
							<td nowrap="nowrap" style="width: 20%">
								
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;所属科室：
								<select style="width: 120px;" class="easyui-combobox" id="deptCode">
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp;管理医生：&nbsp;<input style="width: 120px;border:1px solid #999;" type="text" id="retmDoctorName" onfocus="getDoctor()">
										<input  style="width: 120px;" type="hidden" id="retmDoctorCode">
							</td>
							<td nowrap="nowrap">
								&nbsp;复诊通知：&nbsp;<select style="width: 120px;" class="easyui-combobox" id="returnConfirm">
								<option value="">不限</option>
								<option value="0">未通知</option>
								<option value="1">已通知</option>
								</select>
							</td>
							<td nowrap="nowrap">
								
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;复诊日期：
								<input type="text" id="retplanDateStart"  class="easyui-datebox" style="width: 120px;border:1px solid #999;" />
								-
								<input type="text" id="retplanDateEnd"  class="easyui-datebox" style="width: 120px;border:1px solid #999;" />
							</td>
							<td nowrap="nowrap">
								&nbsp;是否复诊：&nbsp;<select style="width: 120px;border:1px solid #999;" class="easyui-combobox" id="returnComplete">
								<option value="">不限</option>
								<option value="0">未复诊</option>
								<option value="1">已复诊</option>
								</select>
							</td>
							<td nowrap="nowrap">
							<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search" onclick="javascript:serach()">查询</a>
							</td>
							<td nowrap="nowrap">
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td colspan="3">
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			
			<div style="width: 96%; min-width:1100px; margin-left: 10px; margin-top: 15px;">
				<div id="config_list_tab"></div>
			</div>
			
			<div
				style="width: 120px; height: 200px; position: absolute; top: 85px; left: 110px;"
				class="easyui-panel" id="doctorconfast_div">
				<div id="doctorconfast_tab" class="easyui-datagrid"></div>
			</div>
			</div>
			
			<div id="add_sfzsk_html" class="easyui-window" style="width:580px;height:320px; text-align: center; " data-options="iconCls:'icon-save',modal:true"  iconCls="icon-add" title="详细信息" closed="true" draggable="false" collapsible="false" maximizable="false" shadow="true" model="true" inline="false" resizable="false" minimizable="false" onmouseup="keyMove(event)">
		    <div style="width: 555px;margin-left: 10px; margin-top: 8px ; height: auto;" id="flupCycleinfo">  
			<table width="100%" >
						<tr>
							<td nowrap="nowrap" style="width: 10%">
								&nbsp;&nbsp;&nbsp;&nbsp;复诊日期：
							</td>
							<td nowrap="nowrap" style="width: 10%">
							<input type="text" id="retplanDate"  class="easyui-datebox" style="width: 120px;border:1px solid #999;" />
							<input type="hidden" id="hReturnDate">
							<input type="hidden" id="hReturnCode">
							</td>
							<td nowrap="nowrap" style="width: 10%">
							&nbsp;&nbsp;复诊科室：
							</td>
							<td nowrap="nowrap" style="width: 20%">
							<input type="text" style="width: 120px;border:1px solid #999;" id="returnDeptName"  onkeyup="keyDownDept(this)"/>
							<input type="hidden" style="width: 120px;border:1px solid #999;" id="returnDeptCode" />
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;&nbsp;&nbsp;&nbsp;复诊方式：
							</td>
							<td nowrap="nowrap" colspan="3">
							<select class="easyui-combobox" style="width: 120px;border:1px solid #999;" id="rnotifyWay" >
							<option value="电话">电话</option>
							<option value="短信">短信</option>
							<option value="微信">微信</option>
							</select>
							</td>
							<td nowrap="nowrap">
							</td>
							<td nowrap="nowrap">
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;&nbsp;&nbsp;&nbsp;复诊内容：
							</td>
							<td nowrap="nowrap" colspan="3">
							<textarea rows="3" cols="50" id="returnInfo" ></textarea>
							</td>
							<td nowrap="nowrap">
							</td>
							<td nowrap="nowrap">
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap" >
							&nbsp;&nbsp;<input type="checkbox" id="ckBox" onclick="clickBox()" >信息通知：
							</td>
							<td nowrap="nowrap" colspan="3">
							<textarea rows="3" cols="50" id="returnMessage"  onfocus="getMessageInfo()"></textarea>
							</td>
							<td nowrap="nowrap">
							</td>
							<td nowrap="nowrap">
							</td>
						</tr>
					</table>
			<div
				style="width: 220px; height: 150px; position: absolute; top: 42px; left: 360px;"
				class="easyui-panel" id="confast_divDept">
				<div style="width: 217px; height: 147px;" id="confast_tabDept" class="easyui-datagrid"></div>
			</div>
			<!-- 信息显示 -->
			<div
				style="width: 320px; height: 150px; position: absolute; top: 180px; left: 137px;"
				class="easyui-panel" id="confast_div">
				<div style="width: 317px; height: 147px;" id="confast_tab" class="easyui-datagrid"></div>
			</div>
			</div >	
			<div>
			 <a href="#" class="easyui-linkbutton" id="mes" icon="icon-add" onclick="javascript:addMessage()">通知</a>
			 <a href="#" class="easyui-linkbutton" id="exit"icon="icon-cut" onclick="javascript:minusNum()">退出</a>
			</div>
         </div>
	</body>
</html>
