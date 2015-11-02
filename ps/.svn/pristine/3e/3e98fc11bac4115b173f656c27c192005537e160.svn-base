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
		<!--  
		<link href="<%=path%>/js/jquery-easyui-1.3.5/themes/gray/easyui.css" rel="stylesheet" type="text/css" />
		-->
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
		<script type="text/javascript" src="<%=path%>/js/system/config.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
		<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>
	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body>
		<div style="border: 0px; font-size: 12px;"  onmouseup="keyMove(event)">
			<div id="addconfiguration"
				style="width: 96%; height: 120px; margin-left: 10px; margin-top: 15px; min-width:1100px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend> 
						配置条件 
					</legend>
					<table width="80%">
						<tr>
							<td nowrap="nowrap">
								&nbsp;<span>所属科室:</span>
								<select style="width: 120px;" class="easyui-combobox" id="deptCode" >
								</select> 
							</td>
							<td nowrap="nowrap">
							&nbsp;<span>随访表名:</span>
							<input id="flupName" name="flupName" style="width: 120px; border: 1px solid #999;"  /> 
							</td>

							<td nowrap="nowrap">
							
								<!--<select style="width: 120px;" class="easyui-combobox" id="flupType" onfocus="closeWindow()">
								</select>
							-->
							
								&nbsp;<span>随访方式:</span>
								<select style="width: 120px;" class="easyui-combobox" id="flupWay">
								</select>
							</td>
							
							<td nowrap="nowrap">
								&nbsp;<span>起始方式:</span>
								<select style="width: 120px;" class="easyui-combobox" id="flupDateFlag">
								    <option value="">不限</option>
									<option value="1">出院日期</option>
									<option value="2">手术日期</option>
								</select>
							</td>
						</tr>
					 
						<tr style="display:none">
							<td nowrap="nowrap">
								&nbsp;<span style="color: #FF34B3;">病组名称:</span>
								<input style="width: 120px; border: 1px solid #999;" id="diagName" readonly="readonly">
								<!--  
								<input id="dept" name="flupName" class="easyui-combogrid" style="width: 120px; border: 1px solid #999;" onfocus="javascript:alert('aaa')"  onkeyup="keyDown(this)" />  
								-->
							</td>
							<td nowrap="nowrap">
							&nbsp;<span style="color: #FF34B3;">随访对象:</span>
								<select style="width: 120px;" class="easyui-combobox" id="flupObject">
								</select>
							</td>
							<td nowrap="nowrap">
							&nbsp;&nbsp;&nbsp;<span style="color: #FF34B3;">随访状态:</span>
								<select style="width: 120px;" class="easyui-combobox" id="flupStatus">
								</select>
							</td>
							<td nowrap="nowrap">
							xxx
							</td>
						</tr>
						<tr style="display:none">
						<td nowrap="nowrap">
								&nbsp;随访总数:
								<select style="width: 120px;" class="easyui-combobox" id="flupTotNum">
								<option value="0">不限</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								</select>
							</td>
						<td nowrap="nowrap">
								&nbsp;随访周期:
								<input style="width: 120px;   border: 1px solid #999;" id="flupCycle" placeholder="请填写详细周期" onfocus="getflupCycleinfo()">
							</td>
						<td nowrap="nowrap">
								&nbsp;&nbsp;&nbsp;随访医生:
								<input style="width: 120px;  border: 1px solid #999;" class="easyui-validatebox"  required="required"  id="flupDoctorCode"   readonly="readonly" onfocus="getDoctor()">
								<input type="hidden" style="width: 120px ;"   id="hflupDoctorCode" >
							</td>
							<td nowrap="nowrap">
							&nbsp;手动随访表:
								<select style="width: 120px;" class="easyui-combobox" id="flupPeonum">
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							<input type="hidden" id ="flupNameId"/>
							<input type="hidden" id ="diagCode"/>
							<input type="hidden" id ="type"/>
							<input type="hidden" id ="id"/>
							</td>
						</tr>
						
					</table>
					<div style="float: right; width: 100px; height: 30px ; margin-right:80px ;margin-top: -30px; " ><a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-search" onclick="javascript:serach()">查询</a></div>
				</fieldset>
			</div>
			<div style="width: 96%; min-width:1100px; margin-left: 10px; margin-top: 5px;">
				<div id="config_list_tab"></div>
			</div>
			<div
				style="width: 220px; height: 100px; position: absolute; top: 85px; left: 110px;"
				class="easyui-panel" id="confast_div">
				<div id="confast_tab" class="easyui-datagrid" style="width:218px;height: 98px;"></div>
			</div>
			<!-- 医生的显示 -->
			<div
				style="width: 220px; height: 200px; position: absolute; top: 85px; left: 110px;"
				class="easyui-panel" id="doctorconfast_div">
				<div id="doctorconfast_tab" class="easyui-datagrid"></div>
			</div>
			
			<div
				style="width: 190px; height: 100px; position: absolute; top: 55px; left: 110px;"
				class="easyui-panel" id="sfzskwh_sfb_div">
				<div id="sfzskwh_sfb" class="easyui-datagrid">
				
				</div>
			</div>
			
		</div>
		
		
		<div id="add_sfzsk_html" class="easyui-window" style="width:350px;height:300px; text-align: center; " data-options="iconCls:'icon-save',modal:true"  iconCls="icon-add" title="随访周期" closed="true" draggable="false" collapsible="false" maximizable="false" shadow="true" model="true" inline="false" resizable="false" minimizable="false">
		    <div style="width: 300px ;" id="flupCycleinfo">  
						   
						                                  
			</div >	
			
			 <div>
			 <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-save" onclick="javascript:saveNum()">保存</a>
			 <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-cancel" onclick="javascript:$('#add_sfzsk_html').window('close');">关闭</a>
			</div>
			 
         </div>

		<div class="easyui-window" title="新增数据导入配置" style="width:auto;height: auto;top: 120px;" closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false"
				id="dataInfo"  >
				
				<table width="80%" style="margin:30px" >
						<tr>
							<td nowrap="nowrap">
								&nbsp;<span>所属科室:</span>
								<select style="width: 120px;" class="easyui-combobox" id="deptCode1" >
								</select> 
							</td>
							<td nowrap="nowrap">
							&nbsp;<span>随访表名:</span>
							<input id="flupName1" name="flupName" style="width: 120px; border: 1px solid #999;"  /> 
							<input type="hidden" style="width: 120px; border: 1px solid #999;" id="flupType1" readonly="readonly">
								<input  type="hidden" style="width: 120px; border: 1px solid #999;" id="diagName1" readonly="readonly">
							</td>

							
							<td nowrap="nowrap">
								&nbsp;随访医生:
								<input style="width: 120px;  border: 1px solid #999;" class="easyui-validatebox"  required="required"  id="flupDoctorCode1"   readonly="readonly" onfocus="getDoctor1()">
								<input type="hidden" style="width: 120px ;"   id="hflupDoctorCode1" >
							</td>
							
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;随访总数:
								<select style="width: 120px;" class="easyui-combobox" id="flupTotNum1">
								<option value="0">不限</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								</select>
							</td>
						<td nowrap="nowrap">
								&nbsp;随访周期:
								<input style="width: 120px;   border: 1px solid #999;" id="flupCycle1" placeholder="请填写详细周期" onfocus="getflupCycleinfo()">
							</td>
							
							
							<td nowrap="nowrap">
							&nbsp;<span>起始方式:</span>
								<select style="width: 120px;" class="easyui-combobox" id="flupDateFlag1">
									<option value="1">出院日期</option>
									<option value="2">手术日期</option>
								</select>
							</td>
						</tr>
						<tr>
						<td nowrap="nowrap">
								&nbsp;<span>随访方式:</span>
								<select style="width: 120px;" class="easyui-combobox" id="flupWay1">
								</select>
							</td>
						
							<td nowrap="nowrap" style="display:none">
							&nbsp;手动随访表:
								<select style="width: 120px;" class="easyui-combobox" id="flupPeonum1">
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							<input type="hidden" id ="flupNameId1"/>
							<input type="hidden" id ="diagCode1"/>
							<input type="hidden" id ="type1"/>
							<input type="hidden" id ="id1"/>
							</td>
							<td nowrap="nowrap" style="display:none">
							&nbsp;<span style="color: #FF34B3;">随访状态:</span>
								<select style="width: 120px;" class="easyui-combobox" id="flupStatus1">
								</select>
							</td>
						</tr>
						
						<tr><td colspan="3" height="30px" align="center"><input type="button" value="保存" id="btnSaveData" />
						&nbsp;&nbsp;&nbsp;<input type="button" value="取消" id="btnExit" /></td></tr>
					</table>
					<div
				style="width: 160px; height: 115px; font-size:12px; position: absolute; top: 75px; left: 500px;z-index:20"
				class="easyui-panel" id="doctorconfast_div1">
				<div id="doctorconfast_tab1" class="easyui-datagrid"></div>
			</div>
				<div id="addPanel"></div>
				<div
				style="width: 190px; height: 115px;font-size:12px; position: absolute; top: 75px; left: 500px;"
				class="easyui-panel" id="confast_div1">
				<div id="confast_tab1" class="easyui-datagrid" style="width:190px;height: 98px;"></div>
			</div>
				
			<div
				style="width: 190px; height: 100px; position: absolute; top: 55px; left: 110px;"
				class="easyui-panel" id="sfzskwh_sfb_div1">
				<div id="sfzskwh_sfb1" class="easyui-datagrid">
				
				</div>
			</div>
				</div>
				<div style="display:none">
			<select style="width: 120px; display:none" class="easyui-combobox" id="flupObject1">
								</select></div>
	</body>
</html>
