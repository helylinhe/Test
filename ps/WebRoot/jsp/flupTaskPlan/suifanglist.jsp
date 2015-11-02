<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
			<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/suifanglist.js"></script>

  </head>
  
  <body>
		<!-- Content Layout -->
		<div style="border: 0px; font-size: 12px;">
			<div
				style="width: 98%; height: 150px; margin-left: 10px; margin-top: 15px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						随访病例信息查询
					</legend>
					<table width="100%">
						<tr>
							<td nowrap="nowrap" style="width: 10%">
								&nbsp;病人编号：
								<input type="text" style="width: 120px;border:1px solid #999;" />
							</td>
							<td nowrap="nowrap" style="width: 10%">
								&nbsp;住&nbsp;院&nbsp;号：
								<input type="text" style="width: 120px;border:1px solid #999;" />
							</td>
							<td nowrap="nowrap" style="width: 20%">
								&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
								<input type="text" style="width: 120px;border:1px solid #999;" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;所属科室：
								<select style="width: 120px;" class="easyui-combobox">
									<option>不限</option>
									<option>骨科</option>
									<option>心脏内科</option>
									<option>外科</option>
									<option>五官科</option>
									<option>儿科</option>
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp;随访日期：
								<input type="text" id="startDate" style="width: 120px;border:1px solid #999;" />
								-
								<input type="text" id="endDate" style="width: 120px;border:1px solid #999;" />
							</td>
							<td nowrap="nowrap">
								&nbsp;随访方式：
								<span style="margin-right: 20px;"> <a class=""
									href="javascript:void(0);" rel="专病">不限</a> </span>
								<span style="margin-right: 20px;"> <a class=""
									href="javascript:void(0);" rel="专病">电话</a> </span>
								<span style="margin-right: 20px;"> <a class=""
									href="javascript:void(0);" rel="专病">微信</a> </span>
								<span style="margin-right: 20px;"> <a class=""
									href="javascript:void(0);" rel="专病">短信</a> </span>
								<span style="margin-right: 20px;"> <a class=""
									href="javascript:void(0);" rel="专病">上门</a> </span>
									<span style="margin-right: 20px;"> <a class=""
									href="javascript:void(0);" rel="门诊">门诊</a> </span>
							</td>
							<td></td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;出院诊断：
								<select style="width: 120px;" class="easyui-combobox">
									<option>不限</option>
									<option>尿毒症</option>
									<option>心脏病</option>
									<option>高血压</option>
									<option>低血压</option>
									<option>肺癌</option>
								</select>

							</td>
							<td nowrap="nowrap">
								&nbsp;出院日期：
								<input type="text" id="startDate1" style="width: 120px;border:1px solid #999;" />
								-
								<input type="text" id="endDate1" style="width: 120px;border:1px solid #999;" />
							</td>
							<td></td>
							<td nowrap="nowrap">
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search">查询</a>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td colspan="3">
								<a href="javascript:void(0);" class="easyui-linkbutton">昨日随访任务</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:void(0);" class="easyui-linkbutton">今日随访任务</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:void(0);" class="easyui-linkbutton">明日随访任务</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="width: 98%; margin-left: 10px; margin-top: 5px;">
				<div id="blxx_list_tab"></div>
			</div>


		</div>
	</body>
</html>