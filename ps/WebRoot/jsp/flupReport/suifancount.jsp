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
			<script type="text/javascript" src="<%=path%>/js/flupReport/suifangcount.js"></script>
		 <style>
		 
		 </style>

  </head>
  <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
    <body class="easyui-layout">
		<div region="center" style="border:0px;">
						<!--全局95%;margin-left:20---> 
						<div style="width:94%;height:100px;margin-left:10px;margin-top:15px;">

						       <fieldset style="border:1px solid#6293BB;">
							      <legend>统计随访查询</legend>
							      		<form id="downloadForm" name="downloadForm">
							      		<input type="hidden" name="flupNameId" id="flupNameId">
							      		<input type="hidden" name="flupTableName" id="flupTableName">
							      		<input type="hidden" name="startDate" id="reportStartDate"/>
							      		<input type="hidden" name="endDate" id="reportEndDate"/>
							      		 <input type="hidden" name="name" id="patiName"/> 
							      		 <input type="hidden" name="flupItem" id="flupItem">
							      		<input type="hidden" name="inpatiNumber" id="reportDataInpatiNumber"/>
							      		<input type="hidden" name="flupComplete" id="flupComplete"/>
							      		<input type="hidden" name="deptCode" id="flupDeptCode"/>
										<table cellspacing="0" cellpadding="0" margin="0" style="width:95%;height:40px;">
													 <tr>	
															<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;住院号：</td>
															<td><input id="reportInpatiNumber" type="text" style="width:170px"></td>
															<td align="right">&nbsp;姓名：</td>
															<td><input type="text" id="name" style="width:170px"></td>
															<td align="right">随访日期范围：</td>
															 
															<td colspan="2">
															    <input type="text" id="startDate"> 
															    -
																<input type="text" id="endDate"> 
														   </td>
															
													 </tr>
													  <tr>	
															<td align="right">&nbsp;所属科室：</td>
															<td>
																	<select style="width: 170px;" class="easyui-combobox" id="deptCode" >
																	</select>	
															</td>
															<td align="right">&nbsp;随访表名：</td>
															<td style="border-right-style:none">
																	<select style="width: 170px;" class="easyui-combobox" id="flupTables" >	
																	</select>
															</td>
															<td>&nbsp;是否随访：&nbsp;</td>
															<td>
																
																<select style="width: 120px;" class="easyui-combobox" id="flupCompletes">
																	<option selected="selected" value="1">已随访</option>
																	<option  value="0">未随访</option>
																</select>
															</td>
															<td>
																<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search" onclick="searchData()">查询</a>
																<a href="javascript:void(0);" class="easyui-linkbutton" onclick="reportDate()">导出EXCEL</a>
															</td>
														</tr>
												</table>
											</form>
									</fieldset>
									</div>
								   <div style="width:94%;margin-left:10px;margin-top:5px;">    
									 <table id="keshisuifangcxtable"></table>
								   </div>
				                
			  </div>
			  
			  <div class="easyui-window" title="随访项内容" style="height: auto;width:400px;" closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false" id="flupItems">
					sDFDAAFAD
				</div>
			  
  </body>
</html>
