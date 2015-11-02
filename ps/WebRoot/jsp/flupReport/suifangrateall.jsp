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
			
			<script type="text/javascript" src="<%=path%>/js/flupReport/suifangrateall.js"></script>
			<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
				<script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>

  </head>
  <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
    <body class="easyui-layout">
		<div region="center" style="border:0px;">
			<!--全局95%;margin-left:20---> 
			<div style="width:80%;height:100px;margin-left:5px;margin-top:15px;">
			       <fieldset style="border:1px solid#6293BB;">
				      <legend>随访统计</legend>
							<table cellspacing="0" cellpadding="0" margin="0" style="width:100%;height:40px;">
								  <tr>	
										<td  nowrap="nowrap" style="width: 150px" align="right">计划随访日期：</td>
										<td style="width: 380px" nowrap="nowrap" >
										<select id="years" class="easyui-combobox" style="width:80;">
											<option value="2014">2014</option>
											<option value="2015">2015</option>
											<option value="2016">2016</option>
											<option value="2017">2017</option>
											<option value="2018">2018</option>
											<option value="2019">2019</option>
											<option value="2020">2020</option>
										</select>年<select id="month" class="easyui-combobox" style="width:50;">
											<option value="01">1</option>
											<option value="02">2</option>
											<option value="03">3</option>
											<option value="04">4</option>
											<option value="05">5</option>
											<option value="06">6</option>
											<option value="07">7</option>
											<option value="08">8</option>
											<option value="09">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
										</select>月
										
										<!--  <input type="text" id="flupDateStart" class="easyui-datebox" style="width: 120px;border:1px solid #999;"  />
										-
										<input type="text" id="flupDateEnd" class="easyui-datebox" style="width: 120px;border:1px solid #999;" />
										-->
										</td>
										<td ><a href="javascript:search();" class="easyui-linkbutton" icon="icon-search">查询</a></td>
								</tr>
							</table>
						</fieldset>
						</div>
						<div id="p" class="easyui-panel" title="院区随访率统计图表"     
			           style="width: 1000px; height: 310px; margin-left: 10px;"   
			        data-options="iconCls:'',closable:false, border : false,    
			                collapsible:true,minimizable:false,maximizable:false">   
			   				   <table style="width:80%;" align="center">
			   				   		<tr>
										<td >
											<div id="hospital_chart"  style="width: 350px; height: 270px;"   >
											</div>
										</td>
										<td>
										   <div id="hospital_dataGrid" style="height:240px;width:400px;margin-left:10px;margin-top:5px;">    
										   </div>
										</td>
									</tr>
			   				   </table>
					</div>
					<div id="p" class="easyui-panel" title="科室随访率统计图表"     
			           style="width: 1000px; height: 350px; margin-left: 10px;"   
			        data-options="iconCls:'',closable:false, border : false,    
			                collapsible:true,minimizable:false,maximizable:false">   
			   				   <table style="width:100%;" align="center">
			   				   		<tr>
										<td >
											<div id="department_chart"  style="width: 350px; height: 270px;"   >
											</div>
										</td>
										<td>
										   <div id="department_dataGrid" style="height:300px;width:400px;margin-left:10px;margin-top:5px;">    
										   </div>
										</td>
									</tr>
			   				   </table>
					</div>
					<div id="p" class="easyui-panel" title="随访结果统计表格"     
			           style="width: 1000px; height: 400px; margin-left: 10px;"   
			        data-options="iconCls:'',closable:false, border : false,    
			                collapsible:true,minimizable:false,maximizable:false">   
			                <div>&nbsp;</div>
			   				   <div id="info_dataGrid" style="height:350px;width:980px;">    
							   </div>
					</div>
			  </div>
  </body>
</html>
