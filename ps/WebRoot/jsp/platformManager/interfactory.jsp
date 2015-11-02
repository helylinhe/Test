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
			
			<script type="text/javascript" src="<%=path%>/js/platformManager/interface.js"></script>
			<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
				<script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>

  </head>
  
    <body class="easyui-layout">
		<div region="center" style="border:0px;">
						<!--全局95%;margin-left:20---> 
						<div style="width:95%;height:100px;margin-left:10px;margin-top:15px;">

						       <fieldset style="border:1px solid#6293BB;">
							      <legend>厂家信息查询</legend>
										<table cellspacing="0" cellpadding="0" margin="0" style="width:100%;height:80px;">
													  <tr>	
															
															<td  nowrap="nowrap" style="width: 115px">厂家名称：</td>
															<td style="width: 280px">
															  	<select>
															  		<option>全部</option>
															  		<option>挂号网</option>
															  		<option>齐脉</option>
															  		<option>心衰平台</option>
															  	</select>
															</td>
															<td  nowrap="nowrap" style="width: 115px">业务名称：</td>
															<td style="width: 280px">
															  	<select>
															  		<option>医院信息</option>
															  		<option>医院科室</option>
															  		<option>齐脉</option>
															  		<option>心衰平台</option>
															  	</select>
															</td>
															
															<td><a href="javascript:search();" class="easyui-linkbutton" icon="icon-search">查询</a></td>
													</tr>
												</table>
									</fieldset>
									</div>
								   <div style="width:95%;margin-left:10px;margin-top:5px;">    
									 <table id="interfaces"></table>
								   </div><!--
								     <div id="p" class="easyui-panel" title="分析图表"     
						           style="width: 1200px; height: 300px; margin-left: 10px;"   
						        data-options="iconCls:'',closable:false, border : false,    
						                collapsible:true,minimizable:false,maximizable:false">   
						   				 <div id="container"  style="width: 950px; height: 270px"   >
											
										</div>  
								--></div>
			  </div>
  </body>
</html>
