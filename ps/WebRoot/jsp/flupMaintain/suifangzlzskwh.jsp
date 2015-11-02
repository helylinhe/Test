<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>上海市区域医疗行为监管平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv=”Access-Control-Allow-Origin” content=”*.ttlsa.com”>
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
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"> var path='<%=path%>';</script>
		<script type="text/javascript" src="<%=path%>/js/flupMaintain/suifangzlzskwh.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
 			<script>
			 </script>
    </head>
    <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body>
		<!-- Content Layout -->
		<div style="border:0px;font-size:12px;" onmouseup="keyMove(event)">
		                <div style="width:96%;margin-top:15px;margin-left:10px;min-width:1100px">
						  <fieldset style="border:1px solid #6293BB;">
						   <legend>随访知识库查询条件</legend>
				          <table width="100%">
						       <tr>
									   <td nowrap="nowrap">&nbsp;<span style="color: #FF34B3;">所属科室：</span></td>
									   <td>
									   <select style="width: 150px;" class="easyui-combobox" id="deptCode" >
										
									   </select>
									   </td>
									   <td nowrap="nowrap">&nbsp;<span style="color: #FF34B3;">症状部位：</span></td>
									   <td colspan="4" id ="dictSpan">
									   
									   </td>
							   </tr>
							   <tr>
									   <td nowrap="nowrap">&nbsp;<span style="color: #FF34B3;">主要诊断：</span></td>
									   <td>
									   <input id="diagName" style="width:150px; border: 1px solid #999;" onkeyup="keyDown(this)"  >
									   </td>
									   <td nowrap="nowrap">&nbsp;<span style="color: #FF34B3;">主要症状：</span></td>
									   <td colspan="3" style=" line-height: 30px"><input type="text" style="width:150px; border: 1px solid #999;" id="mainSymptom" readonly="readonly" onclick="zyzz_zsk_div_open()"></td>
									   <td colspan="3">
											<a href="#" class="easyui-linkbutton" icon="icon-search" style=""  id ="search" onclick="javascript:serach()">查询</a>
									  		<div style="float: right; margin-right: 360px; margin-top: 5px"><span style="font-size: 12px">(红色标签为查询条件)</span></div>
									   </td>
									   
								 </tr> 
							    <tr>
									   <td nowrap="nowrap">&nbsp;症状描述：</td>
									   <td colspan="7"><input type="text" style="width:99%; border: 1px solid #999;" id="symptomDesc" ></td>
								 </tr> 
							    <tr>
									   <td nowrap="nowrap">&nbsp;症状分析：</td>
									   <td colspan="7"><input type="text" style="width:99%; border: 1px solid #999;" id="symptomAnalyze" ></td>
							   </tr> 
							    <tr>
								        <td nowrap="nowrap">&nbsp;意见建议：</td>
									   <td colspan="7"><input type="text" style="width:99%; border: 1px solid #999;" id="advise" >
									   <input id="type" type="hidden">
									   <input id="bodyPartName" type="hidden">
									   <input id="placeCode" type="hidden">
									   <input id="knowledgeCode" type="hidden">
									   <input id="diagCode" type="hidden">
									   </td>
							   </tr>
							 </table>
							 </fieldset>
                            </div>
				           <div style="width:96%;margin-left:10px;margin-top:5px; min-width:1100px">    
						     <table id="sfzlzsk_tab" ></table>
                           </div>
                      <div style="width:260px;height:204px;position:absolute"  class="easyui-panel" id="zyzz_zsk_div">
                                 <table  id="zyzz_zsk" style=" width: 256px; height: 200px">
                                 </table> 
                      </div>
                   
                      <div id="mm" class="easyui-menu" style="width:120px; display: none">
							<div onclick="updateSymptomDict()" iconCls="icon-add">修改</div>
							<div onclick="saveSymptomDict()" iconCls="icon-edit">保存</div>
					  </div>
                      <div id="add_sfzsk_html" class="easyui-window" style="width:350px;height:200px;model:true; text-align: center; " iconCls="icon-add" title="随访知识库审核" closed="true" draggable="false" collapsible="false" maximizable="false" shadow="true" model="true" inline="false" resizable="false" minimizable="false">
		                   <div style="width: 300px; height: 50px ;margin-top: 20px">                                 
		                                                    状态:<select id="auditsState" class="easyui-combobox" name="dept" style="width:200px;">   
								    <option value="1">审核</option>   
								    <option value="2">未审核</option>   
								    <option value="3">未通过</option>   
							 </select>
						   </div>
						   <div style="width: 300px; height: 30px ;">                                 
		                   			   备注:<input type="text" id="diagRemark" style="width: 200px">
						   </div>
						   <div>
                                   <a href="#" class="easyui-linkbutton"   onclick="updateAuditsState()" icon="icon-save">保存</a>
                                   <a href="#" class="easyui-linkbutton"   onclick="add_sfzsk_winclose()" icon="icon-cancel">取消</a>
						   </div>	  
                      </div> 
                         <div style="width:220px;height:100px;position:absolute"  class="easyui-panel" id="zyzz_key_div">
                           <table   id="zyzz_key">
                           </table> 
                      </div> 
				</div>
	</body>
</html>


 