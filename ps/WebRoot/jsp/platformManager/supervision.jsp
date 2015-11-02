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
                       title: '接口交易动态',
                       content: createFrame("<%=path%>/jsp/platformManager/interfaceManager/manager.jsp"),
                       closable: true,
                   });
                   
                   
                  /**
                  *
                  *弹出异常信息
                  *
                  */
                  $.post('<%=path%>/platformTradelogaction!ExceptionMessage.action',function(data){
                  	 var url="<ul>";
                  	 var count=1;
                  	 	if(data.length>0){
                  	 		for(var i=0;i<data.length;i++){
                  	 			url+="<li style='font-size: 12px;color: red;line-height: 20px;'>";
                  	 			url+=count+"> "+data[i].busiName
                  	 			url+=":";
                  	 			url+=data[i].exceptionExplain;
                  	 			url+="</li>";
                  	 			count++;
                  	 		}
                  	 		url+="</ul>";
                  	 	}else{
                  	 		url+="<li>没有异常信息</li></ul>";
                  	 	}
                  	  $.messager.show({
		        		title:'异常消息提示',
		        		msg:''+url+'',
		        		timeout:100000,
		        		showType:'slide',
		        		width:400,
		        		height:280
		        	});
                   
                  },'json'); 
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
           
           
           
  function  loadTableDetail(val,unitCode){
    	  $("#tableName").val(val);
		  $("#tableUnitCode").val(unitCode); 
		  var url="/jsp/platformManager/platformReport/tablesreportDetail.jsp";
    		  if ($('#tabs').tabs('exists', "表详情")) {
    			  $("#tabs").tabs('close','表详情');   			  
                  $('#tabs').tabs('add', {
                      title: "表详情",
                      content: createFrame(path+url),
                      closable: true
                  });
              }else{
    			  $('#tabs').tabs('add', {
                      title: "表详情",
                      content: createFrame(path+url),
                      closable: true
                  });
            		$("#tabs").tabs("select","表详情");}
       }
			</script>
	</head>
  
 <!--<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include> -->
 
  <body class="easyui-layout" >
		  <div  data-options="region:'north'" class="bgcolor" split="false" border="false"
			style="height: 70px; padding-left: 10px; padding-top: 15px; background-color: #043d84;">
			<table width="100%" cellpadding="0" cellspacing="0"> 
				<tr>
					<td style="width: 45px;">
						<img src="<%=path%>/images/logo.png" width="45px" alt="林康科技" />
					</td>
					<td>
						<span id="index-title"
							style="font-size: 26px; margin-left: 15px; color: white;">平台管理系统</span>
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
			   <div title="统一平台管理" style="overflow: auto;">
	                 <ul class="easyui-tree">
	                 	<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/interfaceManager/interfaceGHWCompany.jsp')">挂号网APP动态<img src='<%=path%>/images/green.png'/></a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/interfaceManager/interfaceQMCompany.jsp')">齐脉微信动态<img src='<%=path%>/images/yellow.png'/></a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/interfaceManager/callcenter.jsp')">呼叫中心动态<img src='<%=path%>/images/yellow.png'/></a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/interfaceManager/manager.jsp')">接口交易动态</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/interfaceManager/interface.jsp')">接口业务设置</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/platformReport/tablesreport.jsp')">平台接入表字典</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/interfaceManager/Premachinemanage.jsp')">前置机管理</a></li>
			       </ul> 
				</div><!--
			   <div title="患者管理" style="overflow: auto;">
	                 <ul class="easyui-tree">
						<li><a onclick="leftmenu_click(this,'<%=basePath%>/jsp/system/manager.jsp')">移动应用患者互动</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/interface.jsp')">患者预约查询</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>/jsp/system/manager.jsp')">患者投诉查询</a></li>
						<li><a onclick="leftmenu_click(this,'<%=basePath%>jsp/platformManager/interface.jsp')">患者咨询查询</a></li>
					
			       </ul> 
				</div>
			   -->
			  	<div title="设备监控(II期)" style="overflow: auto;">
	                 <ul class="easyui-tree">
						<li><a>数据库监控</a></li>
						<li><a>服务器监控</a></li>
						<li><a>网络监控</a></li>
			       </ul> 
				</div>
			</div>
		</div>
		<!-- Content Layout -->
		<div region="center" id="body_content">
            <div id='tabs' class='easyui-tabs' fit='true'></div>
           
        </div>
        
        <!-- 隐藏值 -->
        <input type="hidden" id="tableName">
        <input type="hidden" id="tableUnitCode">
     </body>
</html>
