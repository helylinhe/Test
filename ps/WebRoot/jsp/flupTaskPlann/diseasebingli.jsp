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
				src="<%=path%>/js/jquery-easyui-1.3.5/src/datagrid-groupview.js"></script>
			<script type="text/javascript"
				src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
			<script type="text/javascript"
				src="<%=path%>/js/jquery-easyui-1.3.5/src/datagrid-detailview.js"></script>
			  <script type="text/javascript" src="<%=path%>/js/flupTaskExecution/diseasebingli.js"></script>
			<script>var path='<%=path%>';</script>
			<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>


  </head>
  <body>
   <!-- Content Layout -->
   <!-- 隐藏值 -->
   		<input type="hidden" id="diseasePatiSerial"/>
   		<input type="hidden" id="diseaseInpatiNumber"/>
   		<input type="hidden" id="diseaseInpatiSerialNumber"/>
   		<input type="hidden" id="diseaseMedicalInsuranceCode"/>
   		<input type="hidden" id="diseasePatiName">
   		<input type="hidden" id="diseaseDeptCode">
   		<input type="hidden" id="diseaseDepartment">
   		<input type="hidden" id="diseaseUnitCode">
   		<input type="hidden" id="diseaseInHospitalDate">
   		<input type="hidden" id="diseaseOutHospitalDate">
   		<input type="hidden" id="diseaseGender">
   		<input type="hidden" id="diseaseAge">
   		<input type="hidden" id="diseaseDiseaseNameId">
   		<input type="hidden" id="detailId"/>
		<div style="border: 0px; font-size: 12px;" >
			<div
				style="width: 90%; height: 60px; margin-left: 10px; margin-top: 15px;min-width:1100px">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						随访信息查询
					</legend>
					<table width="100%" style="margin-bottom: 5px">
						<tr >
							<td nowrap="nowrap" style="width:20%">
								&nbsp;所属院区：
								<select id="unitCode" style="width: 100px">
									
								</select>
							</td>
							<td nowrap="nowrap"style="width:20%">
								&nbsp;住&nbsp;院&nbsp;号：
								<input type="text" style="width: 124px; border: 1px solid #999;" id="inpatiNumber" />
							</td>
							<td nowrap="nowrap" style="width:20%">
								&nbsp;医保编号：
								<input type="text"  style="width: 124px; border: 1px solid #999;" id="medicalInsuranceCode" />
								
							</td>
							<td nowrap="nowrap" style="width:20%">
								&nbsp;姓名：
								<input type="text"  style="width: 124px; border: 1px solid #999;" id="name" />
							</td>
							
							<td>
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search" onclick="javascript:serach()">查询</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div
				style="width: 90%; height: auto; margin-left: 10px; margin-top: 15px;min-width:1100px ";
				id="tdll">
				<fieldset style="border: 1px solid #6293BB;">
					
					<table width="100%" style="margin-bottom: 5px">
						<tr>
								<td nowrap="nowrap">
								姓名：
									<input type="text" style="border:0px; width:110px;"  id="name2" disabled="disabled" />
								</td>
								<td nowrap="nowrap">
								医保编号：
								<input type="text" style="border:0px; width:110px;"  id="medicalInsuranceCode2" disabled="disabled" /><input style="width:5px;"  type="hidden" id="inpatiSerialNumber2">
								</td>
								<td nowrap="nowrap">
								住&nbsp;院&nbsp;号：
								<input type="text" style="border:0px; width:110px;"  id="inpatiNumber2" disabled="disabled" />
								</td>
								<td nowrap="nowrap">
								年龄：
								<input type="text" style="border:0px; width:110px;"  id="age2" disabled="disabled" />
								</td>
						</tr>
						<tr>
								<td nowrap="nowrap">
								性别：
								<input type="text" style="border:0px; width:110px;"  id="gender2" disabled="disabled" />
								</td>
								<td nowrap="nowrap">
								住院日期：
								<input type="text" style="border:0px; width:110px;"  id="inHospitalDate2" disabled="disabled" />
								</td>
								<td nowrap="nowrap">
								出院日期：
								<input type="text" style="border:0px; width:110px;"  id="outHospitalDate2" disabled="disabled" />
								</td>
								<td nowrap="nowrap">
								科室：
								<input type="text" style="border:0px; width:110px;"  id="department2" disabled="disabled" />
								</td>
						</tr>
						<tr>
								<td nowrap="nowrap">
								院区：
								<input type="text" style="border:0px; width:110px;"  id="unitCode2" disabled="disabled" />
								</td>
								
						</tr>
					
					</table>
				</fieldset>
			</div>
			
			<!-- 病人列表 -->
			<div class="easyui-window" title="模板" style="height: 450px;z-index: 2" 
			closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" id="inpati_diag_list">
				<table style="width: 850px;" id="inpati_diag">
					
				</table>
			</div>
			
			<div style="width: 90%; margin-left: 10px; margin-top: 5px; ">
				<div id="blxx_tab"></div>
			</div>
			
			<div id="add_bingli_html"
				style="width: 300px; height: 180px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="患者疾病指标模板新增" >
				<table style="width: 280px; margin-left: 5px; margin-top: 20px">
					<tr>
						<td align="center">
							<select style="width: 124px; border: 1px solid #999;" id="diseaseName"></select>
						</td>
					</tr>
					<tr>
						<td align="center">
							<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-save"
								onclick="submit()">保存</a>
							<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-cancel"
								onclick="add_bingli_html()" >取消</a>
						</td>
					</tr>
				</table>
			</div>
			
			
			<!--startprint-->
			<div class="easyui-window" title="疾病指标" style="height: auto;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				 model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" id="edit_bingli_html">
				
				<table style="width: 400px; float: left;" id="sfjl_tab"
					cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="2">
							随访日期
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2">
							随访方式
						</td>
						<td>
							1门诊 2家庭 3电话
						</td>
					</tr>
					<tr>
						<td rowspan="9">
							症状
						</td>
						<td style="border-bottom: 0px;">
							1无症状
						</td>
						<td>
							<input type="checkbox">
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px;">
							2多饮
						</td>
						<td style="border-bottom: 0px;">
							其它
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							3多食
						</td>
						<td rowspan="7" style="border-top: 0px;"></td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							4多尿
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							5视力模糊
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							6感染
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							7手脚麻木
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							8下肢浮肿
						</td>
					</tr>
					<tr>
						<td style="border-top: 0px;">
							9体重明显下降
						</td>
					</tr>
					<tr>
						<td rowspan="5">
							体征
						</td>
						<td>
							血压(mmHg)
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							体重(kg)
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							体质指数
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							足背动脉搏动
						</td>
						<td>
							1未触及 2触及
						</td>
					</tr>
					<tr>
						<td>
							其它
						</td>
						<td></td>
					</tr>
					<tr>
						<td rowspan="7">
							生活方式指导
						</td>
						<td>
							日吸烟量
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							日饮酒量
						</td>
						<td></td>
					</tr>
					<tr>
						<td rowspan="2">
							运动
						</td>
						<td>
							次/周
						</td>
					</tr>
					<tr>
						<td>
							次/周
						</td>
					</tr>
					<tr>
						<td>
							主食
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							心理调整
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							遵医行为
						</td>
						<td></td>
					</tr>
				</table>
				<table style="width: 400px; float: left;" id="sfjl_tab"
					cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="2">
							随访日期
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2">
							随访方式
						</td>
						<td>
							1门诊 2家庭 3电话
						</td>
					</tr>
					<tr>
						<td rowspan="9">
							症状
						</td>
						<td style="border-bottom: 0px;">
							1无症状
						</td>
						<td>
							<input type="checkbox">
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px;">
							2多饮
						</td>
						<td style="border-bottom: 0px;">
							其它
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							3多食
						</td>
						<td rowspan="7" style="border-top: 0px;"></td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							4多尿
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							5视力模糊
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							6感染
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							7手脚麻木
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0px; border-top: 0px;">
							8下肢浮肿
						</td>
					</tr>
					<tr>
						<td style="border-top: 0px;">
							9体重明显下降
						</td>
					</tr>
					<tr>
						<td rowspan="5">
							体征
						</td>
						<td>
							血压(mmHg)
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							体重(kg)
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							体质指数
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							足背动脉搏动
						</td>
						<td>
							1未触及 2触及
						</td>
					</tr>
					<tr>
						<td>
							其它
						</td>
						<td></td>
					</tr>
					<tr>
						<td rowspan="7">
							生活方式指导
						</td>
						<td>
							日吸烟量
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							日饮酒量
						</td>
						<td></td>
					</tr>
					<tr>
						<td rowspan="2">
							运动
						</td>
						<td>
							次/周
						</td>
					</tr>
					<tr>
						<td>
							次/周
						</td>
					</tr>
					<tr>
						<td>
							主食
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							心理调整
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							遵医行为
						</td>
						<td></td>
					</tr>
				</table>
			</div>
			<!--endprint-->
			
			<div id="date_bingli_html"
				style="width: 200px; height: 200px; model: true; text-align: center;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="选择时间" >
				<select class="easyui-combobox"  style="width: 124px; border: 1px solid #999; margin-top: 20px;" id = "dictdate"></select>
				<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search"
								onclick="searchinfo()">查询</a>
			</div>
			
		<!-- 历史化疗记录信息 -->
		<div style="width: 90%; margin-left: 10px;margin-top:20px; min-width:1100px;">
				<div id="history_disease"></div>
			</div>
		</div>
		
		<!-- 导出化疗信息 -->
		<form action="<%=path%>/patidiseasedetailaction!exportHistoryDiseaseInfo.action" id="formDisease">
			<input type="hidden" name="diseaseName" id="diseasename">
			<input type="hidden" name="content" id="content">
		</form>
	</body>
</html>
