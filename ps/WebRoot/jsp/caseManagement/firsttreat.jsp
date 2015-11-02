<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'firsttreat.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		
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
			src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
		<script type="text/javascript"> var path='<%=path%>';</script>
		<script type="text/javascript"
			src="<%=path%>/js/caseManagement/firsttreat.js"></script>

	</head>

	<body>
		<div style="border: 0px; font-size: 12px;">
			<div
				style="width: 96%; height: auto; margin-left: 10px; margin-top: 15px;"
				id="firsttreat">
				<fieldset
					style="border: 1px solid #6293BB; width: 90%; height: auto;">
					<legend>
						病人信息查询条件
					</legend>
					<table width="100%" style="margin-bottom: 5px">
						<tr >
							<td nowrap="nowrap" style="width:15%">
								&nbsp;所属院区：
								<select id="unitCode" style="width: 100px">
									
								</select>
							</td>
							<td nowrap="nowrap"style="width:15%">
								&nbsp;住&nbsp;院&nbsp;号：
								<input type="text" style="width: 124px; border: 1px solid #999;" id="inpatiNumber" />
							</td>
							<td nowrap="nowrap" style="width:15%">
								&nbsp;医保编号：
								<input type="text"  style="width: 124px; border: 1px solid #999;" id="medicalInsuranceCode" />
								
							</td>
							<td nowrap="nowrap" style="width:15%">
								&nbsp;姓名：
								<input type="text"  style="width: 124px; border: 1px solid #999;" id="serachname" />
							</td>
							
							<td nowrap="nowrap" style="width:40%">
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search" onclick="javascript:searchInfo()">查询</a>
								<a href="javascript:void(0);" class="easyui-linkbutton"  onclick="javascript:saveInfo()">保存</a>
								<a href="javascript:void(0);" class="easyui-linkbutton"  onclick="javascript:printInfo()">打印</a>
							</td>
						</tr>
					</table>
				</fieldset>
				<div style="width: 98%;height:auto;" id="divprint" >
					<div style="width: 96%;height:200px; margin-left: 10px; margin-top: 5px;clear: right;">
						<table style="width: 80%;" align=left >
							<tr>
								<td nowrap="nowrap" align="right">
									住院号：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="inpati_number" value="">
										
								</td>
								<td nowrap="nowrap" align="right">
									病人编号：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="pati_serial" value="">
								</td>
								<td nowrap="nowrap" align="right">
									付款方式：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="billing_name" value="" >
								</td>
							</tr>
							<tr>
								<td nowrap="nowrap" align="right">
									姓名：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="name" value="">
								</td>
								<td align="right">
									性别：
	
								</td>
								<td>
									<input type="radio" name="gender" value="男">
									男
									<input type="radio" name="gender" value="女">
									女
								</td>
								<td nowrap="nowrap" align="right">
									出生日期：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="birth_date" value="">
								</td>
							</tr>
							<tr>
								<td nowrap="nowrap" align="right">
									籍贯：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="county" value="">
								</td>
								<td nowrap="nowrap" align="right">
									电话：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="mobile_phone" value="">
								</td>
								
								<td nowrap="nowrap" align="right">
									末次经治医生：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="attend_doctor" value="">
								</td>
							</tr>
							<tr>
								
								<td nowrap="nowrap" align="right">
									入院日期：
	
								</td>
								<td>
									<input type="text" style="width: 120px; border: 1px solid #999;"
										id="in_hospital_date" value="">
								</td>
								<td nowrap="nowrap" align="right">
									婚姻状况：
	
								</td>
								<td colspan="3">
									<input type="radio" name="married" value="未婚">未婚
			                    	<input type="radio" name="married" value="已婚">已婚
			                    	<input type="radio" name="married" value="丧偶">丧偶
			                    	<input type="radio" name="married" value="丧偶">离婚
			                    	<input type="radio" name="married" value="其他">其他
								</td>
								
							</tr>
							<!--<tr>
								<td nowrap="nowrap" align="right">
									通信地址：
	
								</td>
								<td colspan="5">
									<input type="text" style="width: 423px; border: 1px solid #999;"
										id="address" value="">
								</td>
							</tr>
							<tr>
								<td nowrap="nowrap" align="right">
									入院诊断：
	
								</td>
								<td colspan="5">
									<input type="text" style="width: 423px; border: 1px solid #999;"
										id="in_hosp_diag">
								</td>
							</tr>
							<tr>
									<td nowrap="nowrap" align="right">肿瘤大小：</td>
									<td><input type="text" style="width: 120px; border: 1px solid #999;" id="tumor_size"></td>
									<td nowrap="nowrap" align="right">肿瘤位置：</td>
									<td><input type="text" style="width: 120px; border: 1px solid #999;" id="tumor_location"></td>
									<td nowrap="nowrap" align="right">是否转移：</td>
									<td>
										<input type="text" style="width: 120px; border: 1px solid #999;" id="tumor_change">
									</td>
								</tr>
								<tr>
									<td nowrap="nowrap" align="right">病理结果：</td>
									<td colspan="5">
										<textarea rows="5" cols="80" id="result"></textarea>
									</td>
								</tr>
						--></table>
					</div>
					<div style="width: 96%;height:auto; margin-left: 10px; margin-top: 5px;clear: right;" >
					 	<table  width="95%;" border="1px solid black;"  cellspacing="0">
					 		<thead>
					 			<tr>
					 				<td colspan="4"  align="center">手术信息</td>
					 			</tr>
					 		</thead>
					 		<tbody id="operation">
					 			<tr>
					 				<td align="left">诊断信息</td>
					 				<td colspan="3" align="center" id="preOperationDiagName"></td>
					 			</tr>
					 			<tr>
					 				<td align="left">手术名称</td>
					 				<td colspan="3" align="center" id="operationName"></td>
					 			</tr>
					 			<tr>
					 				<td align="left">手术时间</td>
					 				<td colspan="3" align="center" id="operationTime"></td>
					 			</tr>
					 			<tr>
					 				<td align="left">术中描述</td>
					 				<td colspan="3"  align="center" id="operationDesc"></td>
					 			</tr>
					 		</tbody>	
					 	</table>
					</div>
					<div style="width: 96%;height:auto; margin-left: 10px; margin-top: 5px;clear: right;" >
					 	<table  width="95%;" border="1px solid black;"  cellspacing="0">
					 		<thead>
					 			<tr>
					 				<td>项目名称</td>
					 				<td>申请日期</td>
					 				<td>检查结果</td>
					 			</tr>
					 		</thead>
					 		<tbody id="check_grid">
					 		</tbody>
					 	</table>
					</div>
					<div style="width: 96%; margin-left: 10px; margin-top: 5px;">
					 	<table  width="95%;" border="1px solid black;"  cellspacing="0">
					 		<thead>
					 			<tr>
					 				<td>检验名称</td>
					 				<td>项目名称</td>
					 				<td>检验结果</td>
					 				<td>参考范围</td>
					 				<td>检验日期</td>
					 			</tr>
					 		</thead>
					 		<tbody id="inspect_grid" >
					 		</tbody>
					 	</table>
					</div>
				</div>
			</div>
			<!-- 弹出层 -->
			<div class="easyui-window" title="模板" style="height: 450px;" 
			closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" id="show_pati_html">
				<table style="width: 850px;" id="tab_pati">
				</table>
			</div>
		</div>
	</body>
</html>
