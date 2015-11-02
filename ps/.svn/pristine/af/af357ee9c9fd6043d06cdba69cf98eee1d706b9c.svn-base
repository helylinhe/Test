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
	<title>复诊管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		
	</head>
	<!--<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	--><body>
		<div style="border: 0px; font-size: 12px;">
			<div>
				<span style="padding-left:20%;">科室:<input type="text" value=""/></span>
				<span style="padding-left:20%;">复诊科室模板:<input type="text" value=""/></span>
			</div>
			<div style="width:20%;float: left;padding-left:4%;">
				<ul>
					<li><input type="checkbox" name="aa" checked="checked" value=""/>da</li>
					<li><input type="checkbox" name="aa" value=""/>da</li>
					<li><input type="checkbox" name="aa" value=""/>da</li>
					<li><input type="checkbox" name="aa" value=""/>da</li>
					<li><input type="checkbox" name="aa" value=""/>da</li>
					<li><input type="checkbox" name="aa" value=""/>da</li>
					<li><input type="checkbox" name="aa" value=""/>da</li>
				</ul>
			</div>
			<div style="width:60%;float: left;" id="fuzhen">
				<table>
					<tr>
						<td>第1次：</td>
						<td>复诊间隔</td>
						<td><input type="text" /></td>
						<td>复诊内容</td>
						<td><input type="text" /></td>
					</tr>
				</table>
				<table>
					<tr>
						<td>第2次：</td>
						<td>复诊间隔</td>
						<td><input type="text" /></td>
						<td>复诊内容</td>
						<td><input type="text" /></td>
					</tr>
				</table>
				<div>
					<input type="button" id="add" value="增加"/>
				</div>
			</div>
		</div>
		
		
		
	</body>
</html>

<script>
	$(function(){
	
		$("#add").click(function (){
			var html="";
			var size=$("#fuzhen").find("table").size();
			html+="<table>"
				+"<tr>"
				+"		<td>第"+(size+1)+"次：</td>"
				+"		<td>复诊间隔</td>"
				+"		<td><input type='text' /></td>"
				+"		<td>复诊内容</td>"
				+"		<td><input type='text' /></td>"
				+"	</tr>"
				+"</table>";
				
			$("#fuzhen").find("table").last().after(html);
				
		});
	});
</script>
