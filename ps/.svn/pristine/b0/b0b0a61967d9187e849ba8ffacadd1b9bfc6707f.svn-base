<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
		<!--  
		<link href="<%=path%>/js/jquery-easyui-1.3.5/themes/gray/easyui.css" rel="stylesheet" type="text/css" />
		-->
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
		<script type="text/javascript" src="<%=path%>/js/system/employeeConfig.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
		<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>
	</head>
	  <jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body>
		<div style="border: 0px; font-size: 12px; margin: 0px auto ; margin-left: 20%; margin-top: 60px"  >
			<div style="width: 90%; text-align: center; margin: 0px auto; text-align: inherit;">
			<table style="width: 90%;margin:auto;" align="center">
				<tr style="margin-top: 20px;">
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名：</td>
				<td><input type="text" style="width: 150px" value="${sessionScope.employee.name}" disabled="disabled"></td>
				</tr>
				<tr style="margin-top: 20px;">
				<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工号：</td>
				<td><input type="text" style="width: 150px" value="${sessionScope.employee.jobnum}" disabled="disabled"></td>
				</tr>
				<tr style="margin-top: 20px;">
				<td style="width: 15px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前密码：</td>
				<td><input type="password" style="width: 150px;"  id="pwdNow" class="easyui-validatebox" required="true"> </td>
				</tr>
				<tr style="margin-top: 20px;">
				<td style="width: 150px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新密码：</td>
				<td>
				<input style="width: 150px;" id="password" name="password" validType="length[4,12]" class="easyui-validatebox" required="true" type="password" value=""/>
				</td>
				</tr>
				<tr style="margin-top: 20px;">
				<td style="width: 150px">再次输入新密码：</td>
				<td>
				<input type="password" style="width: 150px;" name="repassword" id="repassword" required="true" class="easyui-validatebox"  validType="equalTo['#password']" invalidMessage="两次输入密码不匹配"/>
				</td>
				</tr>
				<tr style="margin-top: 20px;">
				<td> </td>
				<td> 
				<a href="#" class="easyui-linkbutton" icon="icon-save" style="margin-left: 20px; margin-top: 30px" onclick="javascript:submit()">修改</a>
				
				 </td>
				</tr>
			</table>
			</div>		
        </div>
	</body>
</html>
