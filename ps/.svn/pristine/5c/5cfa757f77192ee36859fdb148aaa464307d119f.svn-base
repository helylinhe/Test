<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>角色权限</title>
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
		<script type="text/javascript"> var path='<%=path%>';</script>
		<script type="text/javascript" src="<%=path%>/js/system/rolePerm.js"></script>
		
  </head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
  <body>
    <div style="width: 96%; height: 500px;">
			<div
				style="width: 20%; float: left; margin-left: 10px; margin-top: 10px;">
				<fieldset style="border: 1px solid #6293BB; height: auto;">
					<legend>
						角色名称
					</legend>
					<ul class="easyui-tree" data-options="method:'get',animate:true," id="rolelist">
					</ul>
					<input type="button" value="添加角色" id="addRole" onclick="add_role_winopen()"/>
					<!--<div style="margin-top: 370px; margin-left: 5px;">
						<input type="button" value="添加角色" id="addRole" onclick="add_role_winopen()"/>
					</div>
				--></fieldset>
			</div>
			<div
				style="width: 20%; float: left; margin-left: 10px; margin-top: 10px;">
				<fieldset style="border: 1px solid #6293BB; height: auto;">
					<legend>
						菜单权限
					</legend>
					<ul class="easyui-tree" data-options="method:'get',animate:true,checkbox:true"  id="menuroles">
					</ul>
						<input type="button" value="添加菜单" id="addMenu" onclick="menuItemOpen();"/>
				</fieldset>

			</div>
		</div>
		<div
			style="width: 60%; height: 50px; margin-left: 10px; margin-top: 20px;">
			<table style="width: 100%; height: 50px;">
				<tr>
					<td align="center">
						<input type="button" value="确定" onclick="saveRolePriv()" />
						&nbsp;&nbsp;
						<input type="button"  value="取消">
					</td>
				</tr>
			</table>
		</div>

		<!-- 角色添加弹出层 -->
		<div id="add_role" style="width: 520px; height: 120px; model: true;"
			closed="true" draggable="true" collapsible="false"
			maximizable="false" shadow="true" model="true" inline="false"
			resizable="false" minimizable="false" class="easyui-window"
			title="角色添加">
			<table style="width: 490px; margin-left: 10px;margin-top: 10px;">
				<tr>
					<td>
						角色名称：
						<input style="width: 120px; border: 1px solid #999;" id="roleName" />
					</td>
					<td>
						描&nbsp;&nbsp;&nbsp;&nbsp;述：
						<input style="width: 120px; border: 1px solid #999;" id="memo" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-save"
							onclick="saveRole();">保存</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-cancel"
							onclick="add_role_winclose();">取消</a>
					</td>
				</tr>
			</table>
		</div>
		
		<!-- 菜单项添加 -->
		<div id="addMenuItem" style="width: 520px; height: 200px; model: true;"
			closed="true" draggable="true" collapsible="false"
			maximizable="false" shadow="true" model="true" inline="false"
			resizable="false" minimizable="false" class="easyui-window"
			title="菜单项添加">
			<table style="width: 500px; margin-left: 10px;margin-top: 10px;">
				<tr>
					<td>
						父菜单名称：
						<select id="parentMenu"></select>
					</td>
					<td>
						菜单名称：
						<input style="width: 120px; border: 1px solid #999;" id="menuName" />
					</td>
				</tr>
				<tr>
					<td>
						子菜单路径：
						<input style="width: 120px; border: 1px solid #999;" id="urlAddress" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-save" onclick="saveMenuItemName();">保存</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-cancel" onclick="closeMenuWindow()">取消</a>
						
					</td>
				</tr>
			</table>
		</div>
		
	</body>
</html>
