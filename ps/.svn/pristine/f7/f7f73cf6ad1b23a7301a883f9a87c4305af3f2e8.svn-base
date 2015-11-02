<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title> 随访表打印 </title>
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
		<!-- <script type="text/javascript" src="<%=path%>/js/caseManagement/addbinli.js"></script> -->
    <style>
  	     select{
		   width:100px;
		 }
		 
    </style>
  </head>
  <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
  <!--新增-->
 <body  topmargin="0" leftmargin="0"> 
      <div  style="height:auto;font-size:12px;width:85%; padding:5px; border:0;margin-left:10px;float:left;" id="addbinli_content" >
          <div style="height:auto;font-size:12px;width:94%;float:left;">
          <fieldset style="border:1px solid #6293BB;height:78%;">
                 
                 <form id="addForm">
                 <table style="width:95%;margin-left:5px;height:40%;" id="addbinli_content_binlidiv_table" cellspacing="0" cellpadding="0">
                 	<tr>
                    	<td align="right">住&nbsp;院&nbsp;号：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="inpati_number" readonly="readonly"></td>
                        <td align="right">手机号码：</td>
                        <td colspan="1"><input type="text" style="width:100px;border: 1px solid #999;" id="mobile_number" readonly="readonly"></td>
                        <td align="right">住院流水号：</td>
                      	<td><input type="text" style="width:110px;border: 1px solid #999;" id="inpati_serial_number" readonly="readonly"/></td>
                     </tr>
                     <tr>
                        <td align="right">所属院区：</td>
                        <td>
                        	<input  type="text"style="width:100px;border: 1px solid #999;" id="unit_code" readonly="readonly"/>
                        </td>
                        <td align="right">主治医生：</td>
                      	<td>
                      	 <input type="text" style="width:100px;border: 1px solid #999;" id="attend_doctor" readonly="readonly"/>
                        </td>
                    	<td align="right">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="name" readonly="readonly"></td>
                    </tr>
                    <tr>
                    	 <td align="right">家庭号码：</td>
                        <td colspan="1"><input type="text" style="width:100px;border: 1px solid #999;" id="family_number" readonly="readonly"></td>
                    	<td align="right">病人编号：</td>
                        <td><input type="text" style="width:110px;border: 1px solid #999;" id="pati_serial" readonly="readonly"></td>
                    	<td align="right">所属科室：</td>
                        <td>
                        	<input type="text" style="width:100px;border: 1px solid #999;" id="in_dept" readonly="readonly"/>
                        </td>
                       </tr>
                    <tr>
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
                       </tr>
                    <tr> 
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
                       </tr>
                    <tr> 
                        <td align="right">联系人关系：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="relation" readonly="readonly"></td>
                        <td align="right">付款方式：</td>
                    	<td>
                        	<input  id="billing_name" style="width:110px;border: 1px solid #999;" readonly="readonly">   
                        </td>
                        <td align="right">入院日期：</td>
                      	<td><input  type="text"  style="width:100px;border: 1px solid #999;" id="in_hospital_date" readonly="readonly"/> </td>
                      </tr>
                    <tr>	
                      	<td align="right">医疗总费：</td>
                      	<td>
                      	<input  type="text" style="width:100px;border: 1px solid #999;" id="totalMoney" readonly="readonly"/>
                        </td>
                    	<td align="right">民&nbsp;&nbsp;&nbsp;&nbsp;族：</td>
                        <td><input type="text" style="width:100px;border: 1px solid #999;" id="race" readonly="readonly"></td>
                      	<td align="right">联系人电话：</td>
                       <td><input type="text" style="width:100px;border: 1px solid #999;" id="relation_mobile_number" readonly="readonly"></td>
                      </tr>
                    <tr> 
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
                    </table>
                 </form>
                 <div style="height:auto;width:100%;margin-top: 10px;">
                 	<div style="width:45%;height:150px;float: left;margin-right:10px;margin-left: 20px;">
					           <table  id="zd_grid"  style="height:150px;">
					           </table>
	           		</div>
		           <div style="width:51%;height:150px;float: left;">
					          <table id="oper_grid" style="height:150px;" >
					          </table>
			       </div>
		       </div>
   </fieldset>
  </div>
  </div>  
      
 </body>
</html>
