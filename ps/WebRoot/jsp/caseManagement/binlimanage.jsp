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

		<title>上海市区域医疗行为监管平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<script type="text/javascript">var path='<%=path%>';</script>
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
		<script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>
		<script type="text/javascript" src="<%=path%>/js/caseManagement/binlimanage.js"></script>
		<script language="javascript" type="text/javascript"
				src="<%=path%>/js/Highcharts-3.0.9/js/highcharts.js"></script>	
				<script language="javascript" type="text/javascript"
				src="<%=path%>/js/Highcharts-3.0.9/js/modules/exporting.js"></script>	

	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body>
		<!-- Content Layout -->
		<div style="border: 0px; font-size: 12px;width:100%;">
			<div
				style="width: 95%; height: 100px; margin-left: 5px; margin-top: 15px;"
				id="blm_querycondition">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						病例查询条件
					</legend>
					<table style="width: 100%;">
					
						<tr>
							<td nowrap="nowrap">
								&nbsp;所属院区：
								<select id="unitCode" style="width: 120px">
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp;&nbsp;住院号：
								<input type="text" style="border: 1px solid #999; width: 120px;"
									id="search_inpati_number" />
							</td>
							<td nowrap="nowrap">
								&nbsp;&nbsp;&nbsp;&nbsp;姓名：
								<input type="text" style="width: 120px; border: 1px solid #999;"
									id="search_name" />
							</td>
							<td></td>
						</tr>
						<tr>
						<td nowrap="nowrap">
								&nbsp;所属科室：
								<input type="text" style="width: 120px; border: 1px solid #999;" onclick="openDeptTable()" id="search_dept_name"> 
								<input id="search_dept_code"  type="hidden"/>
						</td>
						<td nowrap="nowrap">
								病人编号：
								<input type="text" style="width: 120px; border: 1px solid #999;" id="search_pati_serial" >
							</td>
						<td nowrap="nowrap">
								随访状态：
								<select class="easyui-combobox" style="width: 124px;"
									id="search_flup_status">
									<option value="">不限</option>
									<option value="1">随访期</option>
									<option value="2">非随访期</option>
									<option value="4">黑名单</option>
									<option value="3">失访</option>
									<option value="5">病故</option>
								</select>
							</td>
						 </tr>
						 <tr>
						 <td nowrap="nowrap">
								&nbsp;出院日期：
								<input type="text" id="outHospitalDateStart" style="width: 120px;border:1px solid #999;" />
								-
								<input type="text" id="outHospitalDateEnd" style="width: 120px;border:1px solid #999;" />
							</td>
						<td nowrap="nowrap">
							<a class="easyui-linkbutton" style="height: 24px;"
									icon="icon-search" id="search">查询</a>
				    	</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div
				style="width: 95%; height: 370px; margin-left: 5px; margin-top: 5px;min-width:1100px">
				<div id="blm_grid"></div>
			</div>
			<div
				style="width: 220px; height: 100px; position: absolute; top: 65px; left: 500px;"
				class="easyui-panel" id="dept_div">
				<table id="dept_tab" class="easyui-datagrid"></table>
			</div>
			<div id="binli_manager"
				style="width: 960px; height: 480px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="病例信息">
				<form id="addForm">
                 <table style="width:99%;margin-top:5px;height:95%;" id="addbinli_content_binlidiv_table" cellspacing="0" cellpadding="0">
                 	<tr>
                    	<td align="right" nowrap>住&nbsp;院&nbsp;号：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="inpati_number" class="easyui-validatebox" required="true" ></td>
                        <td align="right" nowrap >病人编号：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="pati_serial" class="easyui-validatebox" validType="checkPati"></td>
                        <td align="right" nowrap>医保编号：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="medical_insurance_code" class="easyui-validatebox" ></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>同户住院号：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="same_family_inpat_number"/></td>
                    	<td align="right">付款方式：</td>
                    	<td >
                        	<select  id="billing_name" style="width:100px;border: 1px solid #999;">   
                            
                            </select>
                        </td>
                    	<td align="right">随访电话：</td>
                      	<td>
                        	<input type="text" style="width:100px;border: 1px solid #999;" id="flup_mobile" class="easyui-numberbox" validType="phone"/>
                        </td>
                    </tr>
                    
                    <tr>
                    	<td align="right" nowrap>姓&nbsp;&nbsp;名&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="name"></td>
                        <td align="right">性&nbsp;&nbsp;别&nbsp;：</td>
                        <td>
                        <input type="radio" name="gender" value="1" checked="checked">男
                        <input type="radio" name="gender" value="2">女
                        </td>
                        <td align="right" nowrap>出生日期：</td>
                        <td><input  type="text"  style="width:100px;border: 1px solid #999;" id="birth_date" /></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>年&nbsp;&nbsp;龄&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="age" class="easyui-numberbox"></td>
                        <td align="right" nowrap>国&nbsp;&nbsp;籍&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="country"></td>
                        <td align="right" nowrap>民&nbsp;&nbsp;族&nbsp;：</td>
                        <td><select  id="race" style="width:100px;border: 1px solid #999;" >
                        <option value="">请选择</option>  
                        </select>
                        </td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>职&nbsp;&nbsp;业&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="profession_title"></td>
                    	<td align="right" nowrap>&nbsp;证件号码：</td>
                        <td><select  class="easyui-combobox" id="certificate_type" style="width:100px">   
                                 <option value="身份证">身份证</option>
                                 <option value="护照">护照</option> 
                                 <option value="驾照">驾照</option>
                                 <option value="军官证">军官证</option>
                              </select>
                        </td>
                        <td colspan="2"><input type="text" style="width:160px;border: 1px solid #999;" id="certificate_number" placeholder="请输入身份证！"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>联系人姓名：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="relation_name"/></td>
                    	<td align="right">社会关系：</td>
                        <td ><select class="easyui-combobox" id="relation" style="width:100px">
                              <option value="1">配偶</option>
                              <option value="2">子</option>
                              <option value="3">女</option>
                              <option value="4">孙子</option>
                              <option value="5">孙女</option>
                              <option value="6">外孙子</option>
                              <option value="7">外孙女</option>
                              <option value="8">父母</option>
                              <option value="9">祖父母</option>
                              <option value="10">外祖父</option>
                              <option value="11">兄</option>
                              <option value="12">弟</option>
                              <option value="13">姐</option>
                              <option value="14">妹</option>
                              <option value="15">其他</option>
                            </select>
                        </td>
                        <td colspan="2"><input type="text" style="width:160px;border: 1px solid #999;" id="relation_mobile_number" class="easyui-validatebox" validType="phone" placeholder="请输入电话号码！"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>&nbsp;手机号码：</td>
                        <td colspan="2"><input type="text" style="width:177px;border: 1px solid #999;" id="mobile_number" class="easyui-validatebox" validType="phone"></td>
                        <td align="right" nowrap>家庭号码：</td>
                        <td colspan="2"><input type="text" style="width:100px;border: 1px solid #999;" id="family_number" class="easyui-validatebox" validType="tel"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>新生儿标志：</td>
                        <td colspan="2"> <input type="radio" name="birth_state" value="0" checked="checked">成人<input type="radio" name="birth_state" value="1">新生儿</td>
                        <td align="right" nowrap>新生儿出生体重：</td>  
                        <td colspan="2"><input type="text" style="width:100px;border: 1px solid #999;" id="birth_weight" class="easyui-numberbox">克</td>                      
                    </tr>
                    <tr>
                    	<td align="right" nowrap>出生地址：</td>
                        <td colspan="2"><input type="text" style="width:177px;border: 1px solid #999;" id="birth_addr"></td>
                        <td align="right" nowrap>新生儿入院体重：</td>
                        <td colspan="2"><input type="text" style="width:100px;border: 1px solid #999;" id="in_hospital_weight" class="easyui-numberbox">克</td>
                    </tr>
                    <tr>
                    	
                        <td align="right" nowrap>婚&nbsp;&nbsp;姻&nbsp;：</td>                        
                    	<td colspan="3">
                    	<input type="radio" name="married" value="未婚" checked="checked">未婚
                    	<input type="radio" name="married" value="已婚">已婚
                    	<input type="radio" name="married" value="丧偶">丧偶
                    	<input type="radio" name="married" value="丧偶">离婚
                    	<input type="radio" name="married" value="其他">其他
                    	</td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>现住地址：</td>
                        <td  colspan="3" nowrap><input type="text" style="width:342px;border: 1px solid #999;" id="current_addr"/></td>
                    	<td align="right" nowrap>邮&nbsp;&nbsp;编&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="current_postcode" class="easyui-numberbox" validType="zip"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>户口地址：</td>
                        <td colspan="3"><input type="text" style="width:342px;border: 1px solid #999;" id="account_addr"/></td>
                    	<td align="right" nowrap>邮&nbsp;&nbsp;编&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="account_postcode" class="easyui-numberbox" validType="zip"></td>
                    </tr>
                    <tr>
                    	<td align="right">住院流水号：</td>
                      	<td><input type="text" style="width:100px;border: 1px solid #999;" id="current_inpati_serial"/></td>
                        <td align="right">&nbsp;所属院区：</td>
                      	<td><select class="easyui-combobox" id="unit_code" style="width:100px">
                            	<option value="2">南院</option>
                                <option value="1">北院</option>
                            </select></td>
                        <td align="right">住院次数：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="inpati_times" class="easyui-numberbox"/></td>
                    </tr> 
                    <tr><td colspan="6" align="center"><a  class="easyui-linkbutton" icon="icon-save"
									id="add_emp" onclick="add()";>保存</a>
								<a class="easyui-linkbutton" icon="icon-cancel"
									onclick="add_close()";>取消</a></td></tr>  
                 </table>
               </form>
               </div>
               
              <div id="binli_update"
				style="width: 960px; height: 250px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="病例修改">
				<form id="updForm">
				<table style="width:99%;margin-top:5px;height:95%;" id="content_binlidiv_table" cellspacing="0" cellpadding="0">
                    <tr>
                    	<td align="right" nowrap>随访电话：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="upd_flup_mobile" class="easyui-validatebox" validType="phone"></td>
                    	<td align="right" nowrap>&nbsp;证件号码：</td>
                        <td><select  class="easyui-combobox" id="upd_certificate_type" style="width:100px">   
                                 <option value="sfz">身份证</option>  
                                 <option value="jz">驾照</option>
                                 <option value="hz">护照</option> 
                                 <option value="jgz">军官证</option>
                              </select>
                        </td>
                        <td colspan="2"><input type="text" style="width:160px;border: 1px solid #999;" id="upd_certificate_number" class="easyui-validatebox" placeholder="请输入身份证！"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>联系人姓名：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="upd_relation_name"/></td>
                    	<td align="right">联系人电话：</td>
                        <td ><select class="easyui-combobox" id="upd_relation" style="width:100px">
                              <option value="1">配偶</option>
                              <option value="2">子</option>
                              <option value="3">女</option>
                              <option value="4">孙子</option>
                              <option value="5">孙女</option>
                              <option value="6">外孙子</option>
                              <option value="7">外孙女</option>
                              <option value="8">父母</option>
                              <option value="9">祖父母</option>
                              <option value="10">外祖父</option>
                              <option value="11">兄</option>
                              <option value="12">弟</option>
                              <option value="13">姐</option>
                              <option value="14">妹</option>
                              <option value="15">其他</option>
                            </select>
                        </td>
                        <td colspan="2"><input type="text" style="width:160px;border: 1px solid #999;" id="upd_relation_mobile_number" class="easyui-validatebox" validType="phone" placeholder="请输入手机号码！"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>&nbsp;手机号码：</td>
                        <td colspan="2"><input type="text" style="width:177px;border: 1px solid #999;" id="upd_mobile_number" class="easyui-validatebox"  validType="phone"></td>
                        <td align="right" nowrap>家庭号码：</td>
                        <td colspan="2"><input type="text" style="width:100px;border: 1px solid #999;" id="upd_family_number" class="easyui-validatebox" validType="phone"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>现住地址：</td>
                        <td  colspan="2" nowrap><input type="text" style="width:342px;border: 1px solid #999;" id="upd_current_addr"/></td>
                    	<td align="right" nowrap>邮&nbsp;&nbsp;编&nbsp;：</td>
                        <td colspan="2"><input type="text" style="width:100px;border: 1px solid #999;" id="upd_current_postcode"  class="easyui-validatebox" validType="zip"></td>
                    </tr>
                    <tr><td colspan="6" align="center"><a  class="easyui-linkbutton" icon="icon-save"
									 onclick="updatePati()";>保存</a>
								<a class="easyui-linkbutton" icon="icon-cancel"
									onclick="upd_close()";>取消</a></td></tr>  
                 </table>
                 </form>
			</div>
		</div>
		 <div id="jc_html"
				style="width: 1100px; height: 450px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="检查信息" >
				<table style="width:90%; height: 50px; margin-left: 5%;"
						cellspacing="0" cellpadding="0">
					<tr>
					<td style="width: 20%">住院号:<br/><label id="cinpatiNumber"></label></td>
					<td style="width: 20%">&nbsp;&nbsp;&nbsp;&nbsp;姓名:<br/>&nbsp;&nbsp;&nbsp;&nbsp;<label id="cname"></label></td>
					<td style="width: 20%">病人编号:<br/><label id="cpatiSerial"></label></td>
					<td style="width: 20%">住院流水号:<br/><label id="cinpatiSerialNumber"></label></td>
					</tr>	
				</table>
				<div id="jcDiv" style="height: auto;  width:1050px;margin-left: 10px">
				</div>
			</div>
			<!-- 调阅检验 -->
		 <div id="jy_html"
				style="width: 1020px; height: 500px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="检验信息" >
				<table style="width:90%; height: 40px;"
						cellspacing="0" cellpadding="0">
					<tr>
					<td style="width: 20%">住院号:<br/><label id="yinpatiNumber"></label></td>
					<td style="width: 20%">&nbsp;&nbsp;&nbsp;&nbsp;姓名:<br/>&nbsp;&nbsp;&nbsp;&nbsp;<label id="yname"></label></td>
					<td style="width: 20%">病人编号:<br/><label id="ypatiSerial"></label></td>
					<td style="width: 20%">住院流水号:<br/><label id="yinpatiSerialNumber"></label></td>
					</tr>	
				</table>
				<div style="width: 34%;height: 365px; margin-left: 10px; margin-top: 5px; float: left;">
					<div id="jyDiv"  style="height:350px" >
					</div>
				</div>
				<div style="width: 60%; height: 365px;  margin-left: 10px; margin-top: 5px;float: left; ">
					<div id="jyDivDetail" style="height:350px" >
					</div>
				</div>
				<hr></hr>
		   <div id="p" title="分析图表"     
	           style="width: 980px; height: 300px; margin-left: 10px;"   
	        data-options="iconCls:'',closable:false, border : false,    
	                collapsible:true,minimizable:false,maximizable:false">   
	   				<div id="container"  style="width: 950px; height: 270px"   >
					</div>
			</div> 
	</div>	
			 <div id="bl_html"
				style="width: 804px; height: 450px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="病历管理" >
				<table style="width:90%; height: 50px; margin-left: 5%;"
						cellspacing="0" cellpadding="0">
					<tr>
					<td style="width: 20%">住院号:<br/><label id="binpatiNumber"></label></td>
					<td style="width: 20%">&nbsp;&nbsp;&nbsp;&nbsp;姓名:<br/>&nbsp;&nbsp;&nbsp;&nbsp;<label id="bname"></label></td>
					<td style="width: 20%">病人编号:<br/><label id="bpatiSerial"></label></td>
					<td style="width: 20%">住院流水号:<br/><label id="binpatiSerialNumber"></label></td>
					</tr>	
				</table>
				<div id="bl_Div" style="height: auto;  width: 790px;margin-left: 10px">
				</div>
			</div> 
		 <div id="dy_html"
				style="width: 600px; height: 450px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="打印随访表" >
				<table style="width:80%; height: 50px; margin-left: 5%;"
						cellspacing="0" cellpadding="0">
					<tr>
					<td style="width: 15%">住院号:<br/><label id="dinpatiNumber"></label></td>
					<td style="width: 15%">&nbsp;&nbsp;&nbsp;&nbsp;姓名:<br/>&nbsp;&nbsp;&nbsp;&nbsp;<label id="dname"></label></td>
					<td style="width: 15%">病人编号:<br/><label id="dpatiSerial"></label></td>
					<td style="width: 15%">住院流水号:<br/><label id="dinpatiSerialNumber"></label></td>
					</tr>	
				</table>
				<div id="dy_Div" style="height: auto;  width: 500px;margin-left: 10px">
				</div>
			</div>
			<!--隐藏的id-->
			<input type="hidden" name="toPatientname" id="toPatientname"/>
			<input type="hidden" name="togender" id="togender"/>
			<input type="hidden" name="toage" id="toage"/>
			<input type="hidden" name="topatiSerial" id="topatiSerial"/>
			<input type="hidden" name="tofamilyNumber" id="tofamilyNumber"/>
			<input type="hidden" name="torelationMobileNumber" id="torelationMobileNumber"/>
			<input type="hidden" name="todepartment" id="todepartment"/>
			<form action="<%=path%>/flupitemresponseaction!exportWord.action" id="exportFlupName">
				<input type="hidden" name="flupNameId" id="flupNameId" value=""/>
				<input type="hidden" name="flupNames" id="flupnames" value=""/>
				<input type="hidden" name="Patientname" id="Patientname" value=""/>
				<input type="hidden" name="Patgender" id="Patgender" value=""/>
				<input type="hidden" name="Patage" id="Patage" value=""/>
				<input type="hidden" name="PatpatiSerial" id="PatpatiSerial" value=""/>
				<input type="hidden" name="PatfamilyNumber" id="PatfamilyNumber" value=""/>
				<input type="hidden" name="PatrelationMobileNumber" id="PatrelationMobileNumber" value=""/>
				<input type="hidden" name="Patdepartment" id="Patdepartment" value=""/>
				<input type="hidden" name="showButton" id="showButton" value=""/>
			</form>
	</body>
</html>
