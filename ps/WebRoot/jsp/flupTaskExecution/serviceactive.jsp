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
		<meta http-equiv=”Access-Control-Allow-Origin” content=”*.ttlsa.com”>
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
			<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script><!--
             <script type="text/javascript" src="<%=path%>/js/flupMaintain/suifangzlzskwh.js"></script>-->
           <script type="text/javascript" src="<%=path%>/js/flupTaskExecution/serviceactive.js"></script>
	      
 			<script>
            function loadPageToId(divId,url){
			     $("#"+divId).html(createFrame(url));
			}
			function createFrame(url) {
				   var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
				   return s;
           }
		   $(function(){
		          loadPageToId("doctor_sfrwgl","<%=path%>/jsp/flupTaskExecution/ssuifanglist.jsp");
				 $('#doctorWork').tabs({
			          onSelect:function(title,index){
					      if(title=="随访任务列表"){
						    loadPageToId("doctor_sfrwgl","<%=path%>/jsp/flupTaskExecution/ssuifanglist.jsp"); 
						  }if(title=="病例基本信息"){
						    loadPageToId("doctor_bljbxx","<%=path%>/jsp/flupTaskExecution/addbinli.jsp"); 
						  }
//						   if(title=="电话随访"){
//						    loadPageToId("doctor_dhsf","<%=path%>/jsp/flupTaskExecution/phonefollow.jsp"); 
//						  }
						   
//						   if(title=="信息随访"){
//						    loadPageToId("doctor_xxsf","<%=path%>/jsp/flupTaskExecution/smsfollow.jsp"); 
//						  }
//						   if(title=="随访属性信息"){
//						    loadPageToId("doctor_sfsxxx","<%=path%>/jsp/flupTaskExecution/suifangproperty.jsp"); 
//						  } 
						   
						  if(title=="患者咨询"){
						    loadPageToId("doctor_hzzx","<%=path%>/jsp/flupTaskExecution/consultinfo.jsp"); 
						  }
					 }
			       });
		   
		   });
  		</script>
        
	</head>
  
  <body>
  
  	<input type="hidden" id="dispatch_patiSerial"/>
	<input type="hidden" id="dispatch_inpatiNumber"/>
	<input type="hidden" id="dispatch_inpatiSerialNumber"/>
    <!-- Content Layout -->
		<div class="easyui-tabs" style="1024px; height:700px;"
			id="doctorWork">
			<!--随访任务开始--->
			<div title="随访任务管理" style="padding: 10px">
				<div id="doctor_sfrwgl" style="width:95%;height:100%"></div>
			</div>
			<!--随访任务结束，--->
			<div title="病例基本信息" style="padding: 3px">
				<div id="doctor_bljbxx" style="width:100%;height:100%"></div>
			</div>
			<!--  
			<div title="随访属性信息" style="padding: 10px">
				<div id="doctor_sfsxxx" style="width:95%;height:100%"></div>
			</div>
			<div title="电话随访" style="padding: 10px">
				<div id="doctor_dhsf" style="width:95%;height:100%"></div>
			</div>
			<div title="信息随访" style="padding: 10px">
				<div id="doctor_xxsf" style="width:95%;height:100%"></div>
			</div>
			 -->
			<div title="患者咨询" style="padding: 10px">
				<div id="doctor_hzzx" style="width:95%;height:100%"></div>
			</div>
		</div>
	</body>
</html>