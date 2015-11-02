<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
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
			<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
			<script type="text/javascript"> var path='<%=path%>';</script>
			<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
			<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/prop.js"></script>
  </head>
    <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
 <body>
		<!-- Content Layout -->
		<div style="border: 0px; font-size: 12px;">
			<div style="width: 96%; height: 30px; margin-left: 10px; margin-top: 15px;">
			<span style="font-size:16px;">住院号：<input type="text" readonly="readonly" style="border: 1px solid #999;" id="inpatiNumber"/></span> &nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:16px;">姓名：<input type="text" style="border: 1px solid #999;" readonly="readonly" id="name"/></span>
			</div>
			<div
				style="width: 96%; height: 120px; margin-left: 10px; margin-top: 15px;">
				<fieldset style="border: 1px solid #6293BB; height: 100px;">
					<legend>
						随访信息修改
					</legend>
					<table style="width: 80%;">
						<tr>
							<td>
							&nbsp;付款方式：
							 <input type="text" style="width: 120px; border: 1px solid #999;"  id="sbillingCode" readonly="readonly">
							 <input type="hidden" style="width: 120px; border: 1px solid #999;"  id="hsbillingCode" >
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;随访状态：
								<select style="width: 120px;" id="wflupStatus">
							
								</select>
							</td>
							<td>
								随访方式：
									<select style="width: 120px;" id="wflupWay">
							</select>
							</td>
							<td>
								随访表名:&nbsp;
								<input id="flupName" name="flupName" style="width: 120px; height:20px;border: 1px solid #999;"  />  
								<input type="hidden" id ="flupTableNameId"/>
								<input type="hidden" id ="inpatiNumber"/>
								<input type="hidden" id ="inpatiSerialNumber"/>
								<input type="hidden" id ="medicalInsuranceCode"/>
								<input type="hidden" id ="id"/>
								<input type="hidden" id ="patiSerial"/>
							</td>
						</tr>
						<tr>
							<td>
							&nbsp;随访分类：
								<select style="width: 120px;"  id="flupType">
							    </select>
							</td>
							<td>
								计划随访日期：
								<input type="text" style="width: 120px; border: 1px solid #999;"  id="flupPlanDate" class="easyui-datebox">
							</td>
							<td>
								随访对象：
								<select style="width: 120px;" id="flupObject">
								</select>
							</td>
							<td>
								随访电话：
								<input type="hidden" style="width: 120px; border: 1px solid #999;" id="flupMobile">
								<select style="width: 120px;"  id="sflupMobile" >
								</select>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;随访医生：
								<select style="width: 120px;"  id="flupDoctorCode">
								</select>
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;操作医生：
							<input type="text" style="width: 120px; border: 1px solid #999;"  value="${sessionScope.employee.name }" readonly="readonly"  id="flupDoctorCode2">
							</td>
							<td>
							
							</td>
							<td>
								  <a href="javascript:submitInfo();" class="easyui-linkbutton" icon="icon-save" >保存</a> 
							</td>
						</tr>
					</table>
					<!-- 
					<div
						style="width: 150px; height: 100px; position: absolute;"
						class="easyui-panel" id="sfzskwh_sfb_div">
						<div id="sfzskwh_sfb" class="easyui-datagrid">
						</div>
					</div>
					 -->
				</fieldset>
			
				
			</div>
			
			<div style="width: 96%; margin-left: 10px; margin-top: 5px;">
			<div id="prop_list_tab" style="width:1200px;"></div>
			</div>
			</div>

			<div id="add_sfzsk_html" class="easyui-window" style="width:350px;height:200px; text-align: center; margin-left: 1px ; margin-top: 1px "  iconCls="icon-add" title="加入黑名单" closed="true" draggable="false" collapsible="false" maximizable="false" shadow="true" model="true" inline="false" resizable="false" minimizable="false" >
						   <div style="width: 300px; height: 30px ; margin-top: 30px">                                 
		                   			   原因:<input type="text" class="easyui-validatebox"  required="required" id="addReasons" style="width: 200px">
						   </div>
						   <div>
                                   <a href="javascript:updateAuditsState()" class="easyui-linkbutton"   icon="icon-save">保存</a>
                                   <a href="javascript:suifanggginfo_winclose()" class="easyui-linkbutton"  icon="icon-cancel">取消</a>
						   </div>	  
            </div>

	</body>
</html>
