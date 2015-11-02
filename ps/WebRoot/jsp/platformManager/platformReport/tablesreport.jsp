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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>平台访问监控统计</title>
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="../../css/index.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/apssysframe.css" />
		<link rel="stylesheet" type="text/css" href="../../css/content.css" />
		<script type="text/javascript"
			src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/plugin/makePy.min.js"></script>
		
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"> var path='<%=path%>'</script>
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
		<script src="<%=path%>/js/Highcharts-3.0.9/js/highcharts.js"></script>
        <script src="<%=path%>/js/Highcharts-3.0.9/js/modules/exporting.js"></script>
        <script type="text/javascript" src="<%=path%>/js/platformManager/platformReport/tablesreport.js"></script>
	</head>

	<body class="easyui-layout">
		<div region="center" style="border: 0px;">
			<!--<div style="width: 95%; height: 100px; margin-left: 10px; margin-top: 15px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						配置条件
					</legend>
					<table width="80%">
						<tr>
							<td nowrap="nowrap">
								&nbsp;接口厂家:
								<select style="width: 120px;"  id="factoryno">
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp;访问日期：
								<input type="text" id="flupDateStart" style="width: 120px;border:1px solid #999;"/>
								-
								<input type="text" id="flupDateEnd" style="width: 120px;border:1px solid #999;"/>
							</td>
							<td  align="center">
								<a  class="easyui-linkbutton" icon="icon-save" id="upd_emp" onclick="loadGrid()">查询</a>
							</td>
						</tr>
					</table>
				</fieldset>
				</div>
				--><div style="width: 95%; margin-left: 10px; margin-top: 5px;">
					<table id="report_list_tab"></table>
				</div>
			</div>
	</body>
</html>