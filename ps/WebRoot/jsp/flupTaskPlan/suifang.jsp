<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上海市区域医疗行为监管平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
			<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/suifang.js"></script>
			<style>
</style>
			<script>
	//随访编辑
	function edit_suifang_winopen() {
		$("#edit_suifang_html").window("open");
	}
	function edit_suifang_winclose() {
		$("#edit_suifang_html").window("close");
	}
	//随访变更信息
	function suifanggginfo_winopen() {
		$("#suifanggginfo").window("open");
	}
	function suifanggginfo_winclose() {
		$("#suifanggginfo").window("close");
	}
</script>


  </head>
  
  <body>
   <!-- Content Layout -->
		<div style="border: 0px; font-size: 12px;">
			<div
				style="width: 98%; height: 110px; margin-left: 10px; margin-top: 15px;">
				<fieldset style="border: 1px solid #6293BB;">
					<legend>
						随访信息查询
					</legend>
					<table width="100%">
						<tr>
							<td nowrap="nowrap" style="width:20%">
								&nbsp;病人编号：

								<input type="text" style="width: 120px;" />
							</td>
							<td nowrap="nowrap"style="width:20%">
								&nbsp;住&nbsp;院&nbsp;号：

								<input type="text" style="width: 120px;" />
							</td>
							<td nowrap="nowrap" style="width:40%">
								&nbsp;姓名：

								<input type="text" style="width: 120px;" />
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">
								&nbsp;诊&nbsp;&nbsp;&nbsp;&nbsp;断：

								<input type="text" style="width: 120px;" />
							</td>
							<td>
								&nbsp;所属科室：
								<select style="width: 124px;" class="easyui-combobox">
									<option>
										不限
									</option>
									<option>
										骨科
									</option>
									<option>
										胸科
									</option>
									<option>
										小儿科
									</option>

								</select>
							</td>
							<td>&nbsp;</td>
						</tr>
						<tr>

							<td nowrap="nowrap">
								&nbsp;随访状态：
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">随访期</a>
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">非随访期</a>
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">病故</a>
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">查无此人</a>
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">失访</a>
							</td>
							<td nowrap="nowrap">
								&nbsp;随访方式：
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">电话</a>
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">短信</a>
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">微信</a>
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">门诊</a>
								<a class=""
									style="font-size: 14px; color: black; text-decoration: none;"
									href="javascript:void(0);" rel="专病">上门</a>
							</td>
							<td>
								<a href="#" class="easyui-linkbutton" icon="icon-search">查询</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="width: 98%; margin-left: 10px; margin-top: 5px;">
				<div id="blxx_tab"></div>
			</div>

			<div id="edit_suifang_html"
				style="width: 510px; height: 300px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="随访任务更改">

				<table style="width: 490px; margin-left: 5px;">

					<tr>
						<td>
							付费方式：
						</td>
						<td>
							<select style="width: 156px;" class="easyui-combobox">
								<option>
									居保
								</option>
								<option>
									社保
								</option>
								<option>
									医保
								</option>
                                <option>
                                	干保
                                </option>
							</select>
						</td>
						<td>
							随访状态：
						</td>
						<td>
							<select style="width: 156px;" class="easyui-combobox">
								<option>
									不限
								</option>
								<option>
									随访期
								</option>
								<option>
									非随访期
								</option>
								<option>
									病故
								</option>
								<option>
									查无此人
								</option>
								<option>
									失访
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							随访方式：
						</td>
						<td>
							<select style="width: 156px;" class="easyui-combobox">
								<option>
									不限
								</option>
								<option>
									微信
								</option>
								<option>
									电话
								</option>
								<option>
									短信
								</option>
								<option>
									门诊
								</option>
								<option>
									上门
								</option>
								<option>
									邮件
								</option>
							</select>
						</td>
						<td>
							随访分类：
						</td>
						<td>
							<select style="width: 156px;" class="easyui-combobox">
								<option>
									专病
								</option>
								<option>
									专科
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<tr>
							<td>
								随访周期：
							</td>
							<td>
								<select style="width: 156px;" class="easyui-combobox">
									<option>
										1月
									</option>
									<option>
										3月
									</option>
									<option>
										6月
									</option>
									<option>
										12月
									</option>
									<option>
										24月
									</option>
								</select>
							</td>
							<td>
								计划随访日期：
							</td>
							<td>
								<input type="text">
							</td>
						</tr>
						<tr>
							<td>
								随访对象：
							</td>
							<td>
								<select style="width: 156px;" class="easyui-combobox">
									<option>
										本人
									</option>
									<option>
										子女
									</option>
									<option>
										朋友
									</option>
								</select>
							</td>
							<td>
								联系电话：
							</td>
							<td>
								<input type="text">
							</td>
						</tr>
						<tr>
							<td>
								随访医生：
							</td>
							<td>
								<select style="width: 156px;" class="easyui-combobox">
									<option>
										王宁
									</option>
									<option>
										张楚
									</option>
									<option>
										刘明
									</option>
									<option>
										胡博文
									</option>
								</select>
							</td>
							<td></td>
							<td></td>
						</tr>
					
					<tr>
						<td>
							操作医生：
						</td>
						<td>
							<input type="text">
						</td>
						<td>
							操作日期：
						</td>
						<td>
							<input type="text">
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<a href="#" class="easyui-linkbutton" icon="icon-save"
								onclick=
	edit_suifang_winclose();
>保存</a>
							<a href="#" class="easyui-linkbutton" icon="icon-cancel"
								onclick=
	edit_suifang_winclose();
>取消</a>
						</td>
					</tr>
				</table>

			</div>
			<div id="suifanggginfo"
				style="width: 600px; height: 500px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="随访记录">
				<div style="width: 95%; margin-left: 15px; margin-top: 5px;">
					<div id="sflsjl_tab"></div>

				</div>
				<div style="width: 95%; margin-left: 15px; margin-top: 5px;">
					<div id="ggjlinfo"></div>

				</div>
			</div>
		</div>

	</body>
</html>
