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
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/Highcharts-3.0.9/js/highcharts.js"></script>
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/Highcharts-3.0.9/js/modules/exporting.js"></script>
		<script type="text/javascript"> var path='<%=path%>';</script>
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>

		<script type="text/javascript"
			src="<%=path%>/js/platformManager/interface.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/comment/validate_common.js"></script>

	</head>

	<body class="easyui-layout">
		<div region="center" style="border: 0px;">
			<!--全局95%;margin-left:20--->
			<div
				style="width: 95%; height: 100px; margin-left: 10px; margin-top: 15px;">

				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						接口信息查询
					</legend>
					<table cellspacing="0" cellpadding="0" margin="0"
						style="width: 100%; height: 80px;">
						<tr>

							<td nowrap="nowrap" style="width: 115px">
								厂家名称：
							</td>
							<td style="width: 280px">
								<select id="factoryno">
									<option>
										全部
									</option>
									<option>
										挂号网
									</option>

									<option>
										心衰平台
									</option>
								</select>
							</td>
							<td nowrap="nowrap" style="width: 115px">
								业务名称：
							</td>
							<td style="width: 280px">
								<select id="busino">
									<option>
										医院信息
									</option>
									<option>
										医院科室
									</option>
									<option>
										齐脉
									</option>
									<option>
										心衰平台
									</option>
								</select>
							</td>

							<td>
								<a href="javascript:search();" class="easyui-linkbutton"
									icon="icon-search">查询</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="width: 95%; margin-left: 10px; margin-top: 5px;">
				<table id="interfaces"></table>
			</div>
			<!--
								     <div id="p" class="easyui-panel" title="分析图表"     
						           style="width: 1200px; height: 300px; margin-left: 10px;"   
						        data-options="iconCls:'',closable:false, border : false,    
						                collapsible:true,minimizable:false,maximizable:false">   
						   				 <div id="container"  style="width: 950px; height: 270px"   >
											
										</div>  
								</div>-->



			<!-- 新增 -->
			<div id="add_sftable_html" class="easyui-window"
				style="width: 510px; height: 200px; model: true;" title="随访表新增"
				closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">
				<table style="width: 480px; margin-left: 5px" id='tableData'>

					<tr>

						<td nowrap="nowrap">
							业务名称
						</td>
						<td>
							<input type="text" id='busiName' name="flupNameDict.flupName">
						</td>
						<td nowrap="nowrap">
							业务编号
						</td>
						<td>
							
							<input style="width: 120px; border: 1px solid #999;"
								id="busiNo">
							
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap">
							厂家名称 
						</td>
						<td>
							<select id="wfactory" style="width: 156px;" name='wflupType'>
								
								
							</select>
						</td>
						<td nowrap="nowrap">
							操作人员
						</td>
						<td>
							<input type="text" style="width: 120px; border: 1px solid #999;"
								readonly="readonly" id='employeeCode'
								value="${sessionScope.employee.name }"
								name='flupNameDict.employeeCode'>
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap">
							日峰值
						</td>
						<td>
							<input type='text' id="callNum" name=""/>
						</td>
						<td nowrap="nowrap">
							异常数
						</td>
						<td>
							<input type='text' id="abnormalNum" value="" name=""/>
						</td>

					</tr>

					<tr>
						<td colspan="4" nowrap="nowrap" align="center">
							<a href="javascript:void(0);" onclick="saveIntebusi()" class="easyui-linkbutton" icon="icon-save">保存</a>
							<a href="javascript:void(0);" class="easyui-linkbutton"
								onclick="$('#add_sftable_html').window('close')"
								icon="icon-cancel">退出</a>

						</td>
					</tr>
				</table>
			</div>
			<!-- 修改 -->
			<div id="update_sftable_html" class="easyui-window"
				style="width: 510px; height: 200px; model: true;" title="修改"
				closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">
				<table style="width: 480px; margin-left: 5px" id='tableData'>

					<tr>

						<td nowrap="nowrap">
							业务名称
						</td>
						<td>
							<input type="text" id='updateBusiName'>
							<input type="hidden" id="updateInteBusiId"/>
						</td>
						<td nowrap="nowrap">
							业务编号
						</td>
						<td>
							
							<input style="width: 120px; border: 1px solid #999;"
								id="updateBusiNo">
							
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap">
							厂家名称 
						</td>
						<td>
							<select id="updateWfactory" style="width: 156px;" name='wflupType'>
								
								
							</select>
						</td>
						<td nowrap="nowrap">
							操作人员
						</td>
						<td>
							<input type="text" style="width: 120px; border: 1px solid #999;"
								readonly="readonly" id='employeeCode'
								value="${sessionScope.employee.name }"
								name='flupNameDict.employeeCode'>
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap">
							日峰值
						</td>
						<td>
							<input type='text' id="updateCallNum" name=""/>
						</td>
						<td nowrap="nowrap">
							异常数
						</td>
						<td>
							<input type='text' id="updateAbnormalNum" value="" name=""/>
						</td>

					</tr>

					<tr>
						<td colspan="4" nowrap="nowrap" align="center">
							<a href="javascript:void(0);" onclick="updateIntebusi()" class="easyui-linkbutton" icon="icon-save">保存</a>
							<a href="javascript:void(0);" class="easyui-linkbutton"
								onclick="$('#update_sftable_html').window('close')"
								icon="icon-cancel">退出</a>

						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
