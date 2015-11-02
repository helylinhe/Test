<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>病史</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<link rel="stylesheet" type="text/css"
					href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
				<link rel="stylesheet" type="text/css"
					href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/apssysframe.css" />
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/content.css" />
				<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
				<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
				<script type="text/javascript"
					src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
				<script type="text/javascript"
					src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
				<!--
				<script type="text/javascript" src="<%=path%>/js/flupMaintain/suifangzlzskwh.js"></script>
				  -->
				<script type="text/javascript"> var path='<%=path%>';</script>
				<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/medicalhistory.js"></script>

	</head>

	<body>
		<div style="padding-left:2%;">
			<div>
				<span style="font-size: 18px; font-weight: bold; padding-left: 2%">病史</span>
				<hr />
				<ul style="list-style-type: none">
					<li style="height: 30px">
						<span>病史：</span><span>发病时间:<input type="text" name="" id="attackYearmon" value="" style="width: 10%"  style="width: 120px;border:1px solid #999;" readonly="readonly" />（流程<input type="text" name=""
							 id="mhisyMnum"	style="width: 3%" value="" />月）</span>
					</li>
					<li style="height: 30px">
						<span>首发症状：</span>
						<span id="firSymptom"><input type="checkbox" value="尿量减少" />尿量减少 <input
								type="checkbox" value="夜尿多" />夜尿多<input type="checkbox" value="尿中泡沫增多" />尿中泡沫增多<input
								type="checkbox" value="尿色发红" />尿色发红<input type="checkbox" value="水肿" />水肿
							<input type="checkbox" value="腰痛" />腰痛 <input type="checkbox"
								value="乏力" />乏力<input type="checkbox" value="头疼" />头疼<input
								type="checkbox" value="消化道症状" />消化道症状 </span>
					</li>
					<li>

						<span style="padding-left: 7%;">具体说明 <input type="text" value=""
								id="firSymptomDepict" style="width: 40%;" />
						</span>
					</li>
					<li style="height: 30px">
						<span>肾脏原发性诊断:</span>
						<span> <select style="width: 12%;" id="origDiagCode">
								<option value="0">
									不限
								</option>
								<option>
									aa
								</option>
								<option>
									bb
								</option>
							</select> 具体说明:<input type="text" name="" id="origDiagDepict" value="" style="width: 36%;" />
						</span>
					</li>
					<li style="height: 30px">
						<span>功能诊断:</span><span>CKD分期：
							<select id="ckdPeriod">
								<option value="0">
									未设定 
								</option>
								<option value="1">
									1
								</option>
								<option value="2">
									2
								</option>
								<option value="3">
									3
								</option>
								<option value="4">
									4
								</option>
								<option value="5">
									5
								</option>
							</select> 
						</span>
						<span>诊断日期:<input id="diagDate" type="text" name="" value="" />
						</span>
					</li>
				</ul>
			</div>
			<div>
				<span style="font-size: 18px; font-weight: bold; padding-left: 2%">既往史：</span>
				<hr />
				<div style="padding-left:3%;">
					<table>
						<tr>
							<td width="15%">
								系统
							</td>
							<td colspan="2" width="50%">
								病史
							</td>
							<td width="35%">
								目前病情是否稳定
							</td>
						</tr>
						<tr>
							<td width="15%">
								呼吸系统
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option value="无">无</option>
									<option value="有">有</option>
									<option value="未填写">未填写</option>
									<option value="未检查">未检查</option>
								</select>
							</td>
							<td width="45%">
								<input type="text" name="" style="width:100%;" value="" />
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option value="是">是</option>
									<option value="否">否</option>
									
								</select>
							</td>
						</tr>
						<tr>
							<td width="15%">
								循环系统
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option value="无">无</option>
									<option value="有">有</option>
									<option value="未填写">未填写</option>
									<option value="未检查">未检查</option>
								</select>
							</td>
							<td width="45%">
								<input type="text" name="" style="width:100%;" value="" />
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option>是</option>
									<option>否</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="15%">
								消化系统
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option value="无">无</option>
									<option value="有">有</option>
									<option value="未填写">未填写</option>
									<option value="未检查">未检查</option>
								</select>
							</td>
							<td width="45%">
								<input type="text" name="" style="width:100%;" value="" />
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option>是</option>
									<option>否</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="15%">
								骨骼肌系统
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option value="无">无</option>
									<option value="有">有</option>
									<option value="未填写">未填写</option>
									<option value="未检查">未检查</option>
								</select>
							</td>
							<td width="45%">
								<input type="text" name="" style="width:100%;" value="" />
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option>是</option>
									<option>否</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="15%">
								内分泌系统
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option>为填写</option>
									<option>有</option>
									<option>无</option>
								</select>
							</td>
							<td width="45%">
								<input type="text" name="" style="width:100%;" value="" />
							</td>
							<td width="20%">
								<select style="width:100%;">
									<option>是</option>
									<option>否</option>
								</select>
							</td>
						</tr>
					</table> 
				</div>
			</div>
			<div style="clear: right;width: 100%;">
				<div style="float: left;width:7%;">
					<span style="font-size: 18px; font-weight: bold; padding-left: 2%">家族史</span>
					<span> <select id="famHistState">
							<option value="无">无</option>
							<option value="有">有</option>
							</select> 
					</span>
				</div>
				<div style="float: left;padding-top:2%;width:50%;">
					<dl>
						<dt id="famEntityName">
							<input type="checkbox" value="糖尿病" />糖尿病
							<input type="checkbox" value="高血压" />高血压
							<input type="checkbox" value="冠心病" />冠心病
							<input type="checkbox" value="肾脏疾病" />肾脏疾病
							<input type="checkbox" value="肿瘤" />肿瘤
						</dt>
						<dt>
							<span>具体诊断名称:</span>
							<select style="width:20%;" id="famDiagName">
								<option>
									daf
								</option>
								<option>
									afa
								</option>
								<option>
									fda
								</option>
								<option>
									fda
								</option>
							</select>

						</dt>
						<dt>
							 具体说明:
							<input type="text" id="famHistDepict" value="" style="width:50%;"/>
						</dt>
					</dl>
				</div>
			</div>
			<div style="clear: left;">
				<span style="font-size: 18px; font-weight: bold; padding-left: 2%">其他</span>
				<br />
				<hr/>
				<table>
					<tr>
						<td>
							药物过敏史
						</td>
						<td>
							<select id="allergyState">
								<option value="无">无</option>
								<option value="有">有</option>
								<option value="未填写">未填写</option>
								<option value="未检查">未检查</option>
							</select>
						</td>
						<td colspan="2">
							<input type="text" id="allergyDepict" name="" value="" style="width:96%" />
						</td>

					</tr>
					<tr>
						<td>
							手术外伤史
						</td>
						<td>
							<select id="opsState">
								<option value="无">无</option>
								<option value="有">有</option>
								<option value="未填写">未填写</option>
								<option value="未检查">未检查</option>
							</select>
						</td>
						<td colspan="2">
							<input id="opsDepict" type="text" name="" value="" style="width:96%"/>
						</td>

					</tr>
					<tr>
						<td>
							吸烟史
						</td>
						<td>
							<select id="smokingState">
								<option value="无">无</option>
								<option value="有">有</option>
								<option value="未填写">未填写</option>
								<option value="未检查">未检查</option>
							</select>
						</td>
						<td>
							吸烟
							<input type="text" id="smokingYearnum" name="" value="" />年
							<input type="text" id="smokingNum" name="" />支/天
						</td>
						<td>
							戒烟年龄
							<input type="text" id="quiteSmokingYear" name="" value="" />岁
						</td>

					</tr>
					<tr>
						<td>
							饮酒史
						</td>
						<td>
							<select id="wineState">
								<option value="无">无</option>
								<option value="有">有</option>
								<option value="未填写">未填写</option>
								<option value="未检查">未检查</option>
							</select>
						</td>
						<td>
							饮酒
							<input type="text" id="wineYearnum" name="" value="" />年
							<input type="text" id="wineNum" name="" />两/天
						</td>
						<td>
							戒酒年龄
							<input type="text" id="quiteWineYear" name="" value="" />岁
						</td>

					</tr>
					<tr>
						<td>
							传染病史
						</td>
						<td>
							<select id="infectState">
								<option value="无">无</option>
								<option value="有">有</option>
								<option value="未填写">未填写</option>
								<option value="未检查">未检查</option>
							</select>
						</td>
						<td colspan="2">
							<input type="text" id="infectDepict" name="" value="" style="width:96%;" />
						</td>

					</tr>
				</table>
			</div> 
				<span><input type="button" style="width:6%;" onclick="saveMedicalHistory();" value="保存"></span>
		</div>
	</body>
</html>
