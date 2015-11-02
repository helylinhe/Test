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
				<script type="text/javascript"
					src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
				<script type="text/javascript"
					src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
				<!--
				<script type="text/javascript" src="<%=path%>/js/flupMaintain/suifangzlzskwh.js"></script>
				  -->
				<script type="text/javascript"> var path='<%=path%>';</script>
				<script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
				<!--  
				<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/suifanglist.js"></script>
				-->
				<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/doctoractive.js"></script>
				<script>
	function loadPageToId(divId, url) {
		$("#" + divId).html(createFrame(url));
	}
	function createFrame(url) {
		 var s = '<iframe name="mainFrame"  scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
		return s;
	}
	$(function() {
		loadPageToId("doctor_xxsf", "<%=path%>/jsp/flupTaskExecution/smsfollow.jsp");
		
		loadWindow();
		$('#doctorWork').tabs(
				{
					onSelect : function(title, index) {
						if (title == "电话随访任务") {
							loadPageToId("doctor_sfrwgl",
									"<%=path%>/jsp/flupTaskExecution/suifanglist.jsp");
						}
						if (title == "病例基本信息") {
							loadPageToId("doctor_bljbxx",
									"<%=path%>/jsp/flupTaskExecution/addbinli.jsp");
						}
						if (title == "电话随访任务") {
							loadPageToId("doctor_dhsf",
									"<%=path%>/jsp/flupTaskExecution/phonefollow.jsp");
						}
						if (title == "短信随访任务") {
							loadPageToId("doctor_xxsf",
									"<%=path%>/jsp/flupTaskExecution/smsfollow.jsp");
						}
						if (title == "随访属性信息") {
							loadPageToId("doctor_sfsxxx",
									"<%=path%>/jsp/flupTaskExecution/suifangproperty.jsp");
						}
						if (title == "患者咨询") {
							loadPageToId("doctor_sfsxxx",
									"../page/consultinfo.html");
						}
					}
				});
	});
</script>
	</head>
  
 <body>
		<!-- Content Layout -->
		
			<!-- 单个修改隐藏flupTask的id -->
			<input type="hidden" id="id">
			<!-- (随访执行)病人编号 和住院号 -->
			<input type="hidden" id="inpatiSerialNumber">
			<input type="hidden" id="patiSerial"/>
			<input type="hidden" id="inpatiNumber"/>
			<input type="hidden" id="flupPlanDate"/>
			<input type="hidden" id="flupTimes"/>
			<input type="hidden" id="medicalInsuranceCode"/>
			
			
			<!-- (随访调度)病人编号 和住院号 -->
			<input type="hidden" id="dispatch_patiSerial"/>
			<input type="hidden" id="dispatch_inpatiNumber"/>
			<input type="hidden" id="dispatch_inpatiSerialNumber"/>
			<!-- 带到子参数的属性 -->
			<input type="hidden" id="sbillingCode"/>
			<input type="hidden" id="hbillingCode"/>
			<input type="hidden" id="wflupWay"/>
			<input type="hidden" id="flupType"/>
			<input type="hidden" id="flupObject"/>
			<input type="hidden" id="flupPeriod"/>
			<input type="hidden" id="wflupStatus"/>
			<input type="hidden" id="flupPlanDate"/>
			<input type="hidden" id="flupMobile"/>
			<input type="hidden" id="id"/>
			<input type="hidden" id="flupName"/>
			<input type="hidden" id="flupTableNameId"/>
			<input type="hidden" id="name"/>
			<input type="hidden" id="flupDoctor"/>
			
			
			
			
			<!-- 隐藏值,便于病史信息页面 -->
			<input type="hidden" id="mh_patiSerial"/>
			<input type="hidden" id="mh_inpatiNumber"/>
			<input type="hidden" id="mh_inpatiSerialNumber"/>
			<input type="hidden" id="mh_name"/>
			<input type="hidden" id="iframe_location">
			
			
			
			
			
			
		<div class="easyui-tabs" style="1024px; height:700px;" id="doctorWork">
			<!--随访任务开始--->
			 <div title="短信随访任务" style="padding: 10px;" id="message">
				<div id="doctor_xxsf" style="width:96%;height:100%"></div>
			</div>
			<div title="电话随访任务" style="padding: 10px">
				<div id="doctor_sfrwgl" style="width:95%;height:100%"></div>
			</div>
			<!--随访任务结束，--->
 
			<div title="病例基本信息" style="padding: 3px">
				<div id="doctor_bljbxx" style="width:100%;height:100%"></div>
			</div>
			
			<!--<div title="随访属性信息" style="padding: 10px">
				<div id="doctor_sfsxxx" style="width:96%;height:100%"></div>
			</div>
			--><!-- 
			<div title="电话随访" style="padding: 10px;" id="phone">
				<div id="doctor_dhsf" style="width:96%;height:100%"></div>
			</div>
			
			 -->
			
		</div>
	</body>
</html>
