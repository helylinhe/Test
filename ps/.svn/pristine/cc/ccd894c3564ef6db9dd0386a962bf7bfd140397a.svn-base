<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title> 病例新增 </title>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta http-equiv="Access-Control-Allow-Origin" content="*">
        <link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/apssysframe.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/content.css" />
		<script type="text/javascript"
			src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
			<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>  
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"> var path='<%=path%>';</script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
		<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/addbinli.js"></script>
    <style>
  	     select{
		   width:100px;
		 }
    </style>
  </head>
  <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
  <!--新增-->
 <body  topmargin="0" leftmargin="0"> 
        <%--<div style="width:70%;height:40px;margin-left:10px;float:left;margin-top:10px">
            <a  class="easyui-linkbutton" icon="icon-save" id="add" onclick="add();">保&nbsp;&nbsp;存&nbsp;</a>
        </div>
       --%><div  style="height:auto;font-size:12px;width:85%; padding:5px; border:0;margin-left:10px;float:left;" id="addbinli_content" >
          <div style="height:auto;font-size:12px;width:95%;float:left;">
          <fieldset style="border:1px solid #6293BB;height:50%;">
                 <legend>病例基本信息</legend>
                 <form id="addForm">
                 <table style="width:95%;margin-left:5px;height:33%;" id="addbinli_content_binlidiv_table" cellspacing="0" cellpadding="0">
                 	<tr>
                    	<td align="right">住&nbsp;院&nbsp;号：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="inpati_number" readonly="readonly"></td>
                        <td align="right">手机号码：</td>
                        <td colspan="1"><input type="text" style="width:100px;border: 1px solid #999;" id="mobile_number" readonly="readonly"></td>
                        <td align="right">住院流水号：</td>
                      	<td><input type="text" style="width:110px;border: 1px solid #999;" id="inpati_serial_number" readonly="readonly"/></td>
                        <td align="right">所属院区：</td>
                        <td>
                        	<input  type="text"style="width:100px;border: 1px solid #999;" id="unit_code" readonly="readonly"/>
                        </td>
                        <td align="right">主治医生：</td>
                      	<td>
                      	 <input type="text" style="width:100px;border: 1px solid #999;" id="attend_doctor" readonly="readonly"/>
                        </td>
                    </tr>
                    <tr>
                    	<td align="right">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="name" readonly="readonly"></td>
                    	 <td align="right">家庭号码：</td>
                        <td colspan="1"><input type="text" style="width:100px;border: 1px solid #999;" id="family_number" readonly="readonly"></td>
                    	<td align="right">病人编号：</td>
                        <td><input type="text" style="width:110px;border: 1px solid #999;" id="pati_serial" readonly="readonly"></td>
                    	<td align="right">所属科室：</td>
                        <td>
                        	<input type="text" style="width:100px;border: 1px solid #999;" id="in_dept" readonly="readonly"/>
                        </td>
                        <td align="right">住院医生：</td>
                      	<td>
                      	<input type="text" style="width:100px;border: 1px solid #999;" id="inpati_doctor" readonly="readonly"/>
                        </td> 
                    </tr>
                     <tr>
                        <td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
                    	<td><input type="text" style="width:100px;border: 1px solid #999;" id="age" readonly="readonly"></td>
                       <td align="right">联系人姓名：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="relation_name" readonly="readonly"/></td> 
                          <td align="right">医保编号：</td>
                        <td><input type="text" style="width:110px;border: 1px solid #999;" id="medical_insurance_code" readonly="readonly"></td>
                        <td align="right">所属病区：</td>
                      	<td>
                      	<input  type="text" style="width:100px;border: 1px solid #999;" id="out_ward" readonly="readonly"/>
                        </td>
                     
                     	<td align="right">诊治情况：</td>
                      	<td>
                           <input type="text" style="width:100px;border: 1px solid #999;" id="diag_situation" readonly="readonly">
                        </td>
                    </tr>
                     <tr>
                       <td align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                        <td>
	                        <input type="radio" name="gender" value="1">男
	                        <input type="radio" name="gender" value="2">女
                        </td>
                        <td align="right">联系人关系：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="relation" readonly="readonly"></td>
                        <td align="right">付款方式：</td>
                    	<td>
                        	<input  id="billing_name" style="width:110px;border: 1px solid #999;" readonly="readonly">   
                        </td>
                        <td align="right">入院日期：</td>
                      	<td><input  type="text"  style="width:100px;border: 1px solid #999;" id="in_hospital_date" readonly="readonly"/> </td>
                      	<td align="right">医疗总费：</td>
                      	<td>
                      	<input  type="text" style="width:100px;border: 1px solid #999;" id="totalMoney" readonly="readonly"/>
                        </td>
                    </tr>
                    <tr>
                    	<td align="right">民&nbsp;&nbsp;&nbsp;&nbsp;族：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="race" readonly="readonly"></td>
                      	<td align="right">联系人电话：</td>
                       <td><input type="text" style="width:100px;border: 1px solid #999;" id="relation_mobile_number" readonly="readonly"></td>
                        <td align="right">随访电话：</td>
                      	<td><input  type="text"style="width:110px;border: 1px solid #999;" id="flup_mobile" readonly="readonly"/> </td>
                        <td align="right">出院日期：</td>
                      	<td><input  type="text"  style="width:100px;border: 1px solid #999;" id="out_hospital_date" readonly="readonly"/> </td>
                        <td align="right">慈善基金：</td>
                      	<td><input  type="text"  style="width:100px;border: 1px solid #999;" id="charityDidMoney" readonly="readonly"/> </td>
                    </tr>
                     <tr>
                        <td align="right">证件号码：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="certificate_type" readonly="readonly">
                        </td>
                        <td colspan="2"><input type="text" style="width:160px;border: 1px solid #999;" id="certificate_number" readonly="readonly"></td>
                      	<td></td>
                      	<td></td>
                    </tr>
                    <tr>
                    	<td align="right">现住地址：</td>
                        <td colspan="9"><input type="text" style="width:337px;border: 1px solid #999;" id="current_addr" readonly="readonly"/></td>
                    </tr>
                    <!--
                    <tr><td colspan="6"><HR style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)" width="100%" color=#6293BB SIZE=1></td></tr>
                     <tr>
                    	  <td align="right" nowrap>同户住院号：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="same_family_inpat_number" readonly="readonly"/></td>
                    </tr> -->
                    <!-- <tr>
                        <td align="right" nowrap>国&nbsp;&nbsp;籍&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="country" readonly="readonly"></td>
                    </tr> --> 
                   <!-- <tr>
                    	<td align="right" nowrap>职&nbsp;&nbsp;业&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="profession_title" readonly="readonly"></td>
                    </tr> 
                    <tr>
                    	<td align="right">社会关系：</td>
                        <td>
                            <input type="text" style="width:100px;border: 1px solid #999;" id="relation" readonly="readonly">
                        </td>
                        <td colspan="2"><input type="text" style="width:160px;border: 1px solid #999;" id="relation_mobile_number" readonly="readonly"></td>
                    </tr> 
                    <tr>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>新生儿标志：</td>
                        <td colspan="2"> <input type="radio" name="birth_state" value="0">成人<input type="radio" name="birth_state" value="1">新生儿</td>
                        <td align="right" nowrap>新生儿出生体重：</td>  
                        <td colspan="2"><input type="text" style="width:100px;border: 1px solid #999;" id="birth_weight" readonly="readonly">克</td>                      
                    </tr>
                    <tr>
                    	<td align="right" nowrap>出生地址：</td>
                        <td colspan="2"><input type="text" style="width:177px;border: 1px solid #999;" id="birth_addr" readonly="readonly"></td>
                        <td align="right" nowrap>新生儿入院体重：</td>
                        <td colspan="2"><input type="text" style="width:100px;border: 1px solid #999;" id="in_hospital_weight" readonly="readonly">克</td>
                    </tr>
                    <tr>
                        <td align="right" nowrap>婚&nbsp;&nbsp;姻&nbsp;：</td>                        
                    	<td colspan="3">
                    	<input type="radio" name="married" value="未婚">未婚
                    	<input type="radio" name="married" value="已婚">已婚
                    	<input type="radio" name="married" value="丧偶">丧偶
                    	<input type="radio" name="married" value="丧偶">离婚
                    	<input type="radio" name="married" value="其他">其他
                    	</td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>邮&nbsp;&nbsp;编&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="current_postcode" readonly="readonly"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>户口地址：</td>
                        <td colspan="3"><input type="text" style="width:342px;border: 1px solid #999;" id="account_addr" readonly="readonly"/></td>
                    	<td align="right" nowrap>邮&nbsp;&nbsp;编&nbsp;：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="account_postcode" readonly="readonly"></td>
                    </tr>
                    <tr>
                    </tr>-->
                    </table>
                 </form>
                  <div style="width:45%;height:150px;float: left;margin-right:10px;margin-left: 20px;">
		           <table  id="zd_grid"  style="height:150px;">
		           </table>
	             </div>
	           <div style="width:51%;height:150px;float: left;">
		          <table id="oper_grid" style="height:150px;" >
		          </table>
		       </div>
	        	<!--<div title="诊断信息" data-options="" style="padding-top:10px;">
	           <div title="手术信息" data-options="" style="padding:10px;">
		        -->
	         <!-- 折叠信息 -->
	        <div class="easyui-accordion" style="min-width:1095px;height:auto;max-width:1110px;">
		        <!-- 
		        <div title="检验信息" data-options="" style="padding:10px;overflow:auto">
		             <div title="检验" style="height:auto;width:98%;">
		                        <table id="inspect_grid">
		                        </table>
		             </div>
		        </div>
		         -->
		         <div title="检验信息" data-options="" style="padding:10px;overflow:auto;">
		             <div style="width: 39%;height: 365px; margin-left: 10px; margin-top: 5px; float: left;">
						<div id="jyDiv"  style="height:350px" >
						</div>
					</div>
					<div style="width: 58%; height: 365px;  margin-left: 10px; margin-top: 5px;float: left; ">
						<div id="jyDivDetail" style="height:350px" >
						</div>
					</div>
		        </div>
	        	<div title="检查信息" data-options="" style="padding:20px;">
	                    <!--检查--->
	                <div title="检查" style="height:auto;width:100%;">
	                        <table id="check_grid">
	                        </table>
	                </div>
	        	</div>
	        	<div title="就诊信息" data-options="" style="overflow:auto;padding:20px;">
			            <div style="width:100%;height:auto;float:left;">
			        		<table id="inpati_grid"></table>
			       		</div>
		        </div>
	        	<div title="历史随访信息" data-options="" style="padding:20px;">
	                    <!--检查--->
	                <div title="随访信息" style="height:auto;width:100%;">
	                        <table id="history_grid">
	                        </table>
	                </div>
	        	</div>
   		   </div>  
   </fieldset>
       <!-- 调阅弹出层 -->
      <div class="easyui-window" title="模板" style="height: auto;width: 600px;" closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false"
				id="history_template">
				<table style="width: auto; float: left;" id="sfjl_tab_1"
					cellspacing="0" cellpadding="0">
					<tr style="height: 16px;">
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr style="height: 55px;">
						<td rowspan="2">
							辅助检查
						</td>
						<td>
							空腹血 糖值
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							其它检查
						</td>
						<td></td>
					</tr>
					<tr style="height: 16px;">
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr style="height: 55px;">
						<td rowspan="2">
							辅助检查
						</td>
						<td>
							空腹血 糖值
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							其它检查
						</td>
						<td></td>
					</tr>
				</table>
			</div>
    </div>
    </div>         
 </body>
</html>
