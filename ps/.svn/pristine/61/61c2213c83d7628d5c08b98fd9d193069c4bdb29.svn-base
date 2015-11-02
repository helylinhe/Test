<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>院后随访系统</title>
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
			<script type="text/javascript">var path="<%=path%>"</script>
			<script type="text/javascript"
				src="<%=path%>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
			<script type="text/javascript">
			
				/***
				*** 出始加载
				*/
				$(function(){
					var url="";
					 $('#tabs').tabs('add', {
                       title: '患者信息查询',
                       content: createFrame("<%=path%>/jsp/custormRelationManager/informationSerach/patiInformate.jsp"),
                       closable: true,
                   });
				});
				
			/*****
				创建Fragme对象
				*/
			function createFrame(url) {
               	var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
               	return s;
           }
           
           function leftmenu_click(obj,url){
		         var tabTitle= $(obj).text();   //get title
				
				  $("#tabs").show();  
		          $("#body_contend_iframe").hide(); 
				  addTab(tabTitle, url);
				
		   }
		  function addTab(subtitle, url) {
		        if (!$('#tabs').tabs('exists', subtitle)) {
                   $('#tabs').tabs('add', {
                       title: subtitle,
                       content: createFrame(url),
                       closable: true,
                       width: $('#mainPanle').width() - 10,
                       height: $('#mainPanle').height() - 26
                   });
               } else {
                   $('#tabs').tabs('select', subtitle);
              }
           }
           //退出系统
            function logout(){
	 		$.messager.confirm('提示', "您确定要退出系统？",function(isok){
	 				if(isok)
 					{
	 					 $.ajax({
	 	                    type: "POST",
	 	                    loading: '正在注销...',
	 	                    url: "<%=path%>/employeeAction!logout.action",
	 	                    dataType: "json",
	 	                    complete: function () {
	 	                        //HideWaitMessageDialog(jWaitDialog);
	 	                    },
	 	                    success: function (result) {
	 	                        if (result.success) {
	 	                        	window.top.location.href = result.url;
	 	                        } 
	 	                    },
	 	                    error: function () {
	 	                        HideWaitMessageDialog(jWaitDialog);
	 	                        $.messager.alert('提示', '发送系统错误,请与系统管理员联系!', 'error');
	 	                    }
	 	                });
 					}
	 				
	 			});
	       }
	       
	       function  loadBingDetail(patiSerial,inpatiNumber,inpatiSerialNumber){
    	  $("#patiSerial").val(patiSerial);
		  $("#inpatiNumber").val(inpatiNumber);
		  $("#inpatiSerialNumber").val(inpatiSerialNumber);
		  var url="/jsp/custormRelationManager/informationSerach/patiInformateDetail.jsp";
		  $('#inpatiSerialNumber').val(inpatiSerialNumber);
    		  if ($('#tabs').tabs('exists', "患者详情")) {
    			  $("#tabs").tabs('close','患者详情');   			  
                  $('#tabs').tabs('add', {
                      title: "患者详情",
                      content: createFrame(path+url),
                      closable: true
                  });
              }else{
    			  $('#tabs').tabs('add', {
                      title: "患者详情",
                      content: createFrame(path+url),
                      closable: true
                  });
            		$("#tabs").tabs("select","患者详情");}
       }
           
			</script>
	</head>
  
 <!--<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include> -->
  <body class="easyui-layout" >
  		  			 <input type="hidden" id="patiSerial"/>
					 <input type="hidden" id="inpatiNumber"/>
					 <input type="hidden" id="inpatiSerialNumber">
		  <div  data-options="region:'north'" class="bgcolor" split="false" border="false"
			style="height: 70px; padding-left: 10px; padding-top: 15px; background-color: #043d84;">
			<table width="100%" cellpadding="0" cellspacing="0"> 
				<tr>
					<td style="width: 45px;">
						<img src="<%=path%>/images/logo.png" width="45px" alt="林康科技" />
					</td>
					<td>
						<span id="index-title"
							style="font-size: 26px; margin-left: 15px; color: white">客户关系管理系统</span>
					</td>
					<td
						style="text-align: right; color: White; font-weight: bold; vertical-align: bottom; padding-bottom: 5px;">
						<img src="<%=path%>/images/user.gif" />
						&nbsp;您好（${sessionScope.employee.name }）&nbsp;&nbsp;&nbsp;&nbsp; [&nbsp;
						<a href="javascript:void(0);" style="color: #ffffff;" onclick="logout();">注销</a>&nbsp;]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			</div>   
			<div region="west" split="true" style="width: 150px;">
			<div id="menuDiv" class="easyui-accordion bgcolor" border="false"
				fit="true" animate="false" style="overflow: hidden">
			   <div title="信息查询" style="overflow: auto;">
	                 <ul class="easyui-tree">
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/informationSerach/patiInformate.jsp')">患者信息查询</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/informationSerach/medicinalFee.jsp')">药品、诊疗费用查询</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/informationSerach/departExper.jsp')">科室、专家开诊查询</a></li>
			       </ul> 
				</div>
			   <div title="投诉管理" style="overflow: auto;">
	                 <ul class="easyui-tree">
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/complaintManager/complaintReg.jsp')">投诉登记</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/complaintManager/complaintManager.jsp')">投诉信息维护</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/complaintManager/complaintDeal.jsp')">投诉处理</a></li>
			       </ul> 
				</div>
			   <div title="咨询管理" style="overflow: auto;">
	                 <ul class="easyui-tree">
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/consulteManager/consulteKnowledgeManager.jsp')">咨询知识库管理</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/consulteManager/consulteReg.jsp')">咨询录入</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/consulteManager/consulteReply.jsp')">咨询回复</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/consulteManager/consulteInformationManager.jsp')">咨询信息维护</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/consulteManager/consulteCount.jsp')">咨询统计</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/consulteManager/consulteReturnManager.jsp')">咨询回访管理</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/consulteManager/consulteMaintenance.jsp')">咨询回访维护</a></li>
			       </ul> 
				</div>
			   <div title="满意度管理" style="overflow: auto;">
	                 <ul class="easyui-tree">
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionManager/satisfactionQuestionManager.jsp')">满意度问题管理</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionManager/satisfactionAnswerManager.jsp')">满意度答案管理</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionManager/satisfactionOutpatientReg.jsp')">门诊满意度录入</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionManager/satisfactionInpatientReg.jsp')">住院满意度录入</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionManager/satisfactionHosPatiReg.jsp')">住院患者满意度</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionManager/satisfacionSearch.jsp')">满意度查询</a></li>
			       </ul> 
				</div>
			   <div title="满意度统计报表" style="overflow: auto;">
	                 <ul class="easyui-tree">
	                 	<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionReport/InpatiDoctor.jsp')">住院医生满意度统计</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionReport/OutpatiDoctor.jsp')">门诊医生满意度统计</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionReport/InpatiNurse.jsp')">住院护士满意度统计</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionReport/OutpatiNurse.jsp')">门诊护士满意度统计</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionReport/emergencyDoctor.jsp')">急诊医生满意度统计</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionReport/emergencyNurse.jsp')">急诊护士满意度统计</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionReport/OutpatiMeTeDepart.jsp')">门诊医技科室满意度统计</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/custormRelationManager/satisfactionReport/InPatiMeTeDepart.jsp')">住院医技科室满意度统计</a></li>
			       </ul> 
				</div>
			</div>
		</div>
		<!-- Content Layout -->
		<div region="center" id="body_content">
            <div id='tabs' class='easyui-tabs' fit='true'></div>
           
        </div>
     </body>
</html>
