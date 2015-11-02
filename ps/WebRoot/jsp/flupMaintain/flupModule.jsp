<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>信息随访模板维护</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/apssysframe.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/content.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script>var path='<%=path%>';</script>
		<script type="text/javascript" src="<%=path%>/js/flupMaintain/flupModule.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
		
	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body>
		<!-- Content Layout -->
		<div style="border: 0px; font-size: 12px;">
			<div
				style="width: 96%; height: 120px; margin-left: 10px; margin-top: 15px;min-width:1100px">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						信息随访模板维护
					</legend>
					<table width="80%">
						<tr>
							<td nowrap="nowrap">
								&nbsp;维护科室：
								<select style="width: 120px;"  id="deptCode">
								</select>
							</td>
							<td nowrap="nowrap">
								&nbsp;信息归属：
								<select style="width: 120px;"  id="one4">
									<option value='' selected="selected">不限</option>
									<option value='个人'>个人</option>
									<option value='科室'>科室</option>
									<option value=''>全院</option>
								</select>
							</td>
							<td nowrap="nowrap" rowspan="3">
								<a href="#" class="easyui-linkbutton" icon="icon-search" id='queryInfo'>查询</a>
							</td>

						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;信息名称：
								<input type="text" style="width: 118px;border:1px solid #999;" id="one1">
							</td>
							<td nowrap="nowrap">
								&nbsp;信息类别：
								<select style="width: 120px;"  id="one5">
								<option value='' selected="selected">不限</option>
								<c:forEach items="${sessionScope.tb_dict }" var="list">
									<c:if test="${list.codeType=='信息类别'}">
										<option value="${list.name }">${list.name }</option>
									</c:if>
								</c:forEach>
							</select>
								
								
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap" colspan="2">
								&nbsp;信息内容：
								<input type="text" style="width: 755px;" style="border:1px solid #999;"  id="one2"/>
								
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="width: 96%; margin-left: 10px; margin-top: 5px; min-width:1100px">
				<div id="flupModule_table"></div>
			</div>
		</div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
<!-- 修改 -->		
				<div id="update_sftable_html" class="easyui-window"
				style="width: 510px; height: 250px; model: true;" 
				title="信息随访模板修改" closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">
<form id="fm" method="post" novalidate>
				<table style="width: 480px; margin-left: 5px">

					<tr>
						
                        <td nowrap="nowrap">
							信息编号 <input type="text" id='uid' name="id"  style="display: none;" /> 
						</td>
						<td>
							 <input type="text" id='uinfoCode' name="infoCode" disabled="disabled"/> 
						</td>
						 
						 <td nowrap="nowrap" >
								信息名称
						</td>
						<td>
							<input type="text" id='uinfoName' name='infoName'/>
						</td>
					</tr>
					<tr>
						 <td nowrap="nowrap">
								信息内容
						</td>
						<td colspan="3">
							<!-- <input type="text" id='uinfoContent' name='infoContent' style="width:390px"/>  -->
							<textarea rows="3" cols="53" id='uinfoContent' name='infoContent'></textarea>
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap">
							所属科室
						</td>
						<td>
							<select style="width: 155px;"  id="udeptCode" name='maintainDept'>
							</select>
						</td>
						<td nowrap="nowrap">
							信息归属
						</td>
						<td nowrap="nowrap">
							<select style="width: 155px;"  id="uinfoBeyone" name='infoBeyone'>
									<option value='个人'>个人</option>
									<option value='科室'>科室</option>
									<option value='全院'>全院</option>
							</select>
						</td>
					</tr>
					<tr>
							<td nowrap="nowrap">
								信息类别
							</td>
							<td>
								<select style="width: 155px;"  id="uinfoBelong" name='infoBelong'>
									<c:forEach items="${sessionScope.tb_dict }" var="list">
									<c:if test="${list.codeType=='信息类别'}">
										<option value="${list.name }">${list.name }</option>
									</c:if>
								</c:forEach>
								</select>
							</td>
							<td nowrap="nowrap">
								操作人员
							</td>
							<td>
								<input type='text' value='${sessionScope.employee.name }' readonly="readonly"/>
							</td>
					</tr>
					
						
						<tr>
							<td colspan="4" nowrap="nowrap" align="center">
								<a href="#" class="easyui-linkbutton"  icon="icon-save" id='update'>保存</a>  
								<a href="#" class="easyui-linkbutton" onclick="javascript:$('#update_sftable_html').window('close');" icon="icon-cancel">取消</a>
									
							</td>
						</tr>

				</table>
</form>
			</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
<!-- 新增 -->			
			
				<div id="add_sftable_html" class="easyui-window"
				style="width: 510px; height: 250px; model: true;" 
				title="信息随访模板新增" closed="true" draggable="false" collapsible="false"
				maximizable="false" shadow="true" model="true" inline="false"
				resizable="false" minimizable="false">

				<table style="width: 480px; margin-left: 5px">

					<tr>
						<!-- 
                        <td nowrap="nowrap">
							信息编号 
						</td>
						<td>
							 <input type="text" id='infoCode' name="infoCode" /> 
						</td>
						-->
						 <td nowrap="nowrap">
								信息名称
						</td>
						 
						<td colspan="3">
							<input type="text" id='infoName' name='infoName' style="width: 390px"/>
						</td>
					</tr>
					<tr>
						 <td nowrap="nowrap">
								信息内容
						</td>
						<td colspan="3">
						<!-- 	<input type="text" id='infoContent' name='infoContent' style="width:390px"/>  -->
							<textarea rows="3" cols="53" id='infoContent' name='infoContent'></textarea>
							
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap">
							所属科室
						</td>
						<td>
							<select style="width: 155px;"  id="wdeptCode" name='maintainDept'>
									
							</select>
						</td>
						<td nowrap="nowrap">
							信息归属
						</td>
						<td nowrap="nowrap">
							<select style="width: 155px;"  id="infoBeyone" name='infoBeyone'>
									<option value='个人'>个人</option>
									<option value='科室'>科室</option>
									<option value='全院'>全院</option>
							</select>
						</td>
					</tr>
					<tr>
							<td nowrap="nowrap">
								信息类别
							</td>
							<td>
								<select style="width: 155px;"  id="infoBelong" name='infoBelong'>
								<c:forEach items="${sessionScope.tb_dict }" var="list">
									<c:if test="${list.codeType=='信息类别'}">
										<option value="${list.name }">${list.name }</option>
									</c:if>
								</c:forEach>
								</select>
							</td>
							<td nowrap="nowrap">
								操作人员
							</td>
							<td>
								<input type='text' value='${sessionScope.employee.name }' readonly="readonly"/>
							</td>
					</tr>
					
						
						<tr>
							<td colspan="4" nowrap="nowrap" align="center">
								<a href="#" class="easyui-linkbutton"  icon="icon-save" id='add'>保存</a>  
								<a href="#" class="easyui-linkbutton" onclick="javascript:$('#add_sftable_html').window('close');" icon="icon-cancel">取消</a>
									
							</td>
						</tr>

				</table>

			</div>
			
			
	</body>
</html>