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
		<title>上海市区域医疗行为监管平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/apssysframe.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/content.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
			<script>var path='<%=path%>';</script>
			<script type="text/javascript" src="<%=path%>/js/suifangProjectMaintain.js"></script>
			<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
			<script type="text/javascript" src="<%=path%>/js/flupMaintain/flupNameDict.js"></script>
			
			
			<style>
</style>

	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body class="easyui-layout">
	
		<!-- Content Layout -->
		<div region="center" style="border: 0px;">
			<div
				style="width: 95%; height: 80px; margin-left: 10px; margin-top: 15px; min-width:1100px">
				<fieldset style="border: 1px solid #6293BB">

					<legend>
						随访表查询条件
					</legend>
					<table cellspacing="0" cellpadding="0" margin="0"
						style="width: 100%; height: 50px;">
						<tr>
							<td nowrap="nowrap">
								&nbsp随访表名：
								
								<input type="text" style="width: 118px; border: 1px solid #999;" id="one1">
							</td>
							<td nowrap="nowrap">
								&nbsp随访类别：
								<select style="width: 120px;" class="easyui-combobox" id="flupWay" >
								</select>
							</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp所属科室：
								<!--  
								<input type="text" style="width: 150px;" id="one4"  onclick="javascript:$('#ssks_div').panel('open');" placeholder="选择科室" />
								-->		
							    <select style="width: 120px;" class="easyui-combobox" id="deptCode" >
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp诊断组名：
								<input style="width: 118px; border: 1px solid #999;" id="diagName"  onkeyup="keyDown(this)">
								<input type="hidden" id='diagCode' name='diagName'/>
								
								<!-- 
								<input type="text" style="width: 150px;" id="one5"
									onClick="javascript:$('#zyzd_div').panel('open');" placeholder="选择诊断名称" />
									 -->
							</td>
							<td></td>
							<td></td>
							<td nowrap="nowrap">
								<a href="javascript:void(0)" onclick="javascript:query()" class="easyui-linkbutton" icon="icon-search" >查询</a>
								
								
						</tr>
						<tr style="height: 10px;">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="width: 95%; margin-left: 10px; margin-top: 5px; min-width:1100px;">
				 <table id="flupNameDict_table"></table>
			</div>






















			<!-- 
			<div
				style="width: 300px; height: 100px; position: absolute; top: 65px; left: 75px;"
				class="easyui-panel" id="ssks_div">
				<div id="ssks_tab" class="easyui-datagrid"></div>
			</div>
			 -->
			<div
				style="width: 210px; height: 100px; position: absolute; top: 75px; left: 700px;"
				class="easyui-panel" id="zyzd_div">
				<div id="zyzd_tab" class="easyui-datagrid" style="width: 200px;height: 92px"></div>
			</div>
			
		

			<div id="add_sftable_html" class="easyui-window"
				style="width: 510px; height: 200px; model: true;" 
				title="随访表新增" closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">
				<table style="width: 480px; margin-left: 5px" id='tableData'>

					<tr>
						
                        <td nowrap="nowrap">
							随访表名
						</td>
						<td>
							<!-- <input type="text" id='flupName' name="flupNameDict.flupName">  -->
							 <input type="text" id='wflupName' name="flupNameDict.flupName"> 
						</td>
						 <td nowrap="nowrap">
								诊断组名
							</td>
							<td>
							<!--  
								<input type="text" id='diagName' name='flupNameDict.diagName'>
							-->	
							<input style="width: 120px; border: 1px solid #999;" id="wdiagName"  onkeyup="wkeyDown(this)">
							<input type="hidden" id='wdiagCode' name='wdiagName'/>
							</td>
					</tr>
					<tr>
						<td nowrap="nowrap">
							随访类别
						</td>
						<td>
							<select id="wflupType"  style="width: 156px;" name='wflupType' class="easyui-combobox"/>
								<option value="1">专科</option>
								<option value="2">专病</option>
								<option value="3">专病细类</option>

							</select>
						</td>
						<td nowrap="nowrap">
								操作医生
							</td>
							<td>
								<input type="text" style="width: 120px; border: 1px solid #999;" readonly="readonly" id='employeeCode' value="${sessionScope.employee.name }" name='flupNameDict.employeeCode'>
							</td>
						<!-- 
                        <td nowrap="nowrap">
							随访周期
						</td>
						<td>
							<select class="easyui-combobox" style="width: 156px;">
								<option value="1月">不限</option>
								<option value="1月">1月</option>
								<option value="3月">3月</option>
								<option value="6月">6月</option>
								<option value="12月">12月</option>
								<option value="12月">24月</option>
							</select>
						</td>
						 -->
						   
					</tr>
					<tr>
						<td nowrap="nowrap">
							所属科室
						</td>
						<td>
							<select style="width: 156px;" class="easyui-combobox" id="wdeptCode" >
								
							</select>
						</td>
                            
					</tr>
					
						
						<tr>
							<td colspan="4" nowrap="nowrap" align="center">
								<a href="#" class="easyui-linkbutton"  icon="icon-save" id='sava'>保存</a>  
								<a href="#" class="easyui-linkbutton" onclick="javascript:$('#add_sftable_html').window('close');" icon="icon-cancel">退出</a>
									
							</td>
						</tr>
				</table>
				
				<div
				style="width: 210px; height: 100px; position: absolute; top: 50px; left: 300px; "
				class="easyui-panel" id="wzyzd_div">
				<div id="wzyzd_tab" class="easyui-datagrid" style="width: 200px;height: 92px"></div>
				</div>
			</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<div id="update_sftable_html" class="easyui-window"
				style="width: 510px; height: 200px; model: true;" 
				title="随访表修改" closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">
<form id="fm" method="post" novalidate>
				<table style="width: 480px; margin-left: 5px">

					<tr>
						
                        <td nowrap="nowrap">
							随访表名
						</td>
						<td>
							<!-- <input type="text" id='flupName' name="flupNameDict.flupName">  -->
							 <input type="text" id='uflupName' name="flupName"/> 
						</td>
						 <td nowrap="nowrap">
								诊断组名
							</td>
							<td>
							<input style="width: 120px; border: 1px solid #999;" id="udiagName"  onkeyup="ukeyDown(this)">
							<input type="hidden" id='udiagCode' name='udiagName'/>
							</td>
					</tr>
					<tr>
						<td nowrap="nowrap">
							随访类别
						</td>
						<td>
							<select id="uflupType"  style="width: 156px;" name='uflupType' class="easyui-combobox"/>
								<option value="1">专科</option>
								<option value="2">专病</option>
								<option value="3">专病细类</option>
							</select>
						</td>
						<td nowrap="nowrap">
								操作医生
							</td>
							<td>
								<input type="text" style="width: 120px; border: 1px solid #999;" id='uemployeeCode' readonly="readonly" value="${sessionScope.employee.name }" name='employeeCode' />
							</td>
							<!-- 隐藏ID -->
						   		<input type="text" id='uflupNameId' name='flupNameId' style="display: none"/>
					</tr>
					<tr>
						<td nowrap="nowrap">
							所属科室
						</td>
						<td>
							<!-- 
							<input type="text" id='udeptCode'  name='deptCode' />
							 -->
							<select style="width: 156px;" class="easyui-combobox" id="udeptCode" >
								
							</select>
						</td>
                            
					</tr>
					
						
						<tr>
							<td colspan="4" nowrap="nowrap" align="center">
								<a href="javascript:void(0);" class="easyui-linkbutton"  icon="icon-save" id='update'>保存</a>  
								<a href="javascript:void(0);" class="easyui-linkbutton" onclick="javascript:$('#update_sftable_html').window('close');" icon="icon-cancel">退出</a>
									
							</td>
						</tr>

				</table>
				</form>
				<div
				style="width: 210px; height: 100px; position: absolute; top: 50px; left: 300px; "
				class="easyui-panel" id="uzyzd_div">
				<div id="uzyzd_tab" class="easyui-datagrid" style="width: 200px;height: 92px"></div>
				</div>
			</div>
		</div>
		
	</body>
</html>