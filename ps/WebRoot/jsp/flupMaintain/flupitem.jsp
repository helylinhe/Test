<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>随访项维护</title>
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
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"> var path='<%=path%>'</script>
		<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
	    <script type="text/javascript" src="<%=path%>/js/comment/validate_common.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/flupMaintain/flupitem.js"></script>
	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body class="easyui-layout">
		<div region="center" style="border: 0px;">
			<!--全局95%;margin-left:20--->
			<div
				style="width: 95%; height: 80px; margin-left: 10px; margin-top: 15px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						随访项目查询
					</legend>
					<table cellspacing="0" cellpadding="0" margin="0"
						style="width: 80%; height: 50px;">
						<tr>
							<td nowrap="nowrap">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I级：
								<input type="text" style="width: 120px; border: 1px solid #999;"
									id="group_one">
							</td>
							<td nowrap="nowrap">
								&nbsp;项目名称：
								<input type="text" style="width: 120px; border: 1px solid #999;"
									id="item_name">
							</td>
							<td>&nbsp;</td>
							</tr>
							<tr>
							<td nowrap="nowrap">
								&nbsp;&nbsp;记录方式：
								<select id="record_type" class="easyui-combobox"
									style="width: 120px">
									<option value="">不限</option>
									<option value="dx">单选</option>
									<option value="fx">复选</option>
									<option value="wb">文本</option>
									<option value="ts">提示</option>
								</select>
							</td>
							<td>
								&nbsp;数据类型：
								<select id="data_type" class="easyui-combobox"
									style="width: 120px">
									<option value="">不限</option>
									<option value="zf">字符</option>
									<option value="zs">整数</option>
									<option value="xs">小数</option>
									<option value="rq">日期</option>
									<option value="be">布尔</option>
								</select>
							</td>
							<td nowrap="nowrap">
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-search"
									id="item_search">查询</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<!--随访项目table-->
			<div style="width: 95%; margin-left: 10px; margin-top: 5px;">
				<table id="flupitem_table"></table>
			</div>
			<!--新增--->
			<div id="add_flup_item"
				style="width: 800px; height: 220px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="新增项目">

				<form method="post" id="add_item_form">
					<table style="width: 96%; margin-left: 10px; margin-top: 10px;">
						<tr>
							<td colspan="2">
								项目名称：
								<input style="width: 380px; border: 1px solid #999;"
									id="add_item_name" class="easyui-validatebox" required="true" />
							</td>
							
							<td>&nbsp;是否必填：
							        <select id="add_item_require" class="easyui-combobox"
									style="width: 123px">
								    <option value="1">必填</option>
									<option value="0">非必填项</option>
							       </select>
							</td>
						</tr>
						<tr>
						<td>
							文本位置：
							        <select id="add_item_posi" class="easyui-combobox"
									style="width: 123px">
								    <option value="2">后面</option>
									<option value="1">前面</option>
							       </select>
							</td>
							<!--<td>
								显示编号：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_groupshowno" />
							</td>
							--><td>
								记录方式：
								<select id="add_record_type" class="easyui-combobox"
									style="width: 123px">
									<option value="dx">单选</option>
									<option value="fx">复选</option>
									<option value="wb">文本</option>
									<option value="ts">提示</option>
								</select>
							</td>
							<td>
								&nbsp;数据类型：
								<select id="add_data_type" class="easyui-combobox"
									style="width: 123px">
									<option value="zf">字符</option>
									<option value="zs">整数</option>
									<option value="xs">小数</option>
									<option value="rq">日期</option>
									<option value="be">布尔</option>
								</select>
							</td>

						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I级：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_group_one" onclick="openGroupTable('add')" placeholder="首拼检索"  class="easyui-validatebox" required="true" />
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;II级：
								<input style="width: 120px; border: 1px solid #999;"
									id="add_group_two"/>
							</td>
							<td>
								&nbsp;所属科室：
								<select style="width: 123px;" class="easyui-combobox" id="deptCode" >
								</select>
							</td>
						</tr>
						<tr>

						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-save"
									id="add_item">保存</a>
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-cancel"
									onclick=add_item_winclose();>退出</a>
							</td>
						</tr>
					</table>
				</form>
				<div
				style="width: 400px; height: 100px; position: absolute; top: 65px; left: 500px;"
				class="easyui-panel" id="add_group_div">
				<table id="add_group_tab" class="easyui-datagrid"></table>
			  </div>
			</div>
						<!--修改--->
			<div id="upd_flup_item"
				style="width: 800px; height: 220px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="修改">
				<input type="hidden" id="deptCodeId"/>
				<form method="post" id="upd_item_form">
					<table style="width: 96%; margin-left: 10px; margin-top: 10px;">
						<tr>
							<td colspan="2">
								项目名称：
								<input style="width: 380px; border: 1px solid #999;"
									id="upd_item_name" class="easyui-validatebox" required="true" />
							</td>
							
							<td>&nbsp;是否必填：
							        <select id="upd_item_require" class="easyui-combobox"
									style="width: 123px">
								    <option value="1">必填</option>
									<option value="0">非必填项</option>
							       </select>
							</td>
						</tr>
						<tr>
							<td>
								文本位置：
								<select id="upd_item_posi" class="easyui-combobox"
									style="width: 123px">
								    <option value="2">后面</option>
									<option value="1">前面</option>
								</select>
							</td>
							<td>
								记录方式：
								<select id="upd_record_type" class="easyui-combobox"
									style="width: 123px">
									<option value="dx">单选</option>
									<option value="fx">复选</option>
									<option value="wb">文本</option>
									<option value="ts">提示</option>
								</select>
							</td>
							<td>
								&nbsp;数据类型：
								<select id="upd_data_type" class="easyui-combobox"
									style="width: 123px">
									<option value="zf">字符</option>
									<option value="zs">整数</option>
									<option value="xs">小数</option>
									<option value="rq">日期</option>
									<option value="be">布尔</option>
								</select>
							</td>

						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I级：
								<input style="width: 120px; border: 1px solid #999;"
									id="upd_group_one" onclick="openGroupTable('upd')" class="easyui-validatebox" required="true" />
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;II级：
								<input style="width: 120px; border: 1px solid #999;"
									id="upd_group_two"  />
							</td>
							<td>&nbsp;所属科室：
								<select style="width: 123px;" class="easyui-combobox" id="updateDeptCode" >
								</select>
							</td>
						</tr>
						<tr>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-save"
									id="upd_item">保存</a>
								<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-cancel"
									onclick=upd_item_winclose();>退出</a>
							</td>
						</tr>
					</table>
				</form>
				<div
				style="width: 400px; height: 100px; position: absolute; top: 65px; left: 500px;"
				class="easyui-panel" id="upd_group_div">
				<table id="upd_group_tab" class="easyui-datagrid"></table>
			  </div>
			</div>
		</div>
	</body>
</html>