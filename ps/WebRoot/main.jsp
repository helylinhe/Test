<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>患者服务统一平台</title>
		<script type="text/javascript">var path='<%=path%>';</script>
        <link href="<%=path%>/css/main/jquery-ui-1.8.24.custom.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/main/main.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/main/themesetting.css" rel="stylesheet"  type="text/css" >
		<link href="<%=path%>/css/main/skins/black.css" rel="stylesheet" />
		<link href="<%=path%>/css/main/powerFloat.css" rel="stylesheet" type="text/css"/>	
		<link href="<%=path%>/css/main/smartMenu.css" rel="stylesheet"  type="text/css" />
        <link href="<%=path%>/css/main/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">var path="<%=path%>"</script>
        <script type="text/javascript" src="<%=path%>/js/main/jquery-1.8.2.min.js" ></script>
		<script type="text/javascript" src="<%=path%>/js/main/jquery-powerFloat-min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/main/jquery-smartMenu-min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/main/jquery-class.js"></script>
		<script type="text/javascript" src="<%=path%>/js/main/artDialog.js"></script>
		<script type="text/javascript" src="<%=path%>/js/main/iframeTools.js"></script>
        <script type="text/javascript" src="<%=path%>/js/main/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="<%=path%>/js/main/interface.js"></script>
		<script type="text/javascript" src="<%=path%>/js/main/data.js"></script>
		<script type="text/javascript" src="<%=path%>/js/main/bsv1.3-core.js"></script>
        <script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="<%=path%>/js/comment/comment.js"></script>
	</head>
	<jsp:include page="/jsp/comment/loginValidate.jsp"></jsp:include>
	<body style="padding:0px;">
		<div id="themeSetting_wrap" style="display:none;">
			<div id="themeSetting_head" class="themeSetting_head">		
				<div id="themeSetting_tabTheme" class="themeSetting_tab current" style="display: block;">系统主题</div>		
			</div>					
			<div id="themeSetting_body" class="themeSetting_body">	
				<div id="themeSetting_area"  class="themeSetting_area" style="display: block;">						 
				<a href="###" themeid="theme_blue" class="themeSetting_settingButton" id="themeSetting_theme_blue"/>
					<div style="background: url(images/theme_blue.jpg) no-repeat;" class="themeSetting_settingButton_icon"></div>
					<div class="themeSetting_settingButton_text">梦幻光影</div>
				</a>   
				<a href="###" themeid="theme_pinky_night" class="themeSetting_settingButton" id="themeSetting_theme_pinky_night">
					<div style="background: url(images/theme_pinky_night.jpg) no-repeat;" class="themeSetting_settingButton_icon"></div>
					<div class="themeSetting_settingButton_text">粉红之夜</div>
				</a>      
				<a href="###" themeid="theme_green" class="themeSetting_settingButton" id="themeSetting_theme_green">
					<div style="background: url(images/theme_green.jpg) no-repeat;" class="themeSetting_settingButton_icon"></div>
					<div class="themeSetting_settingButton_text">青青世界</div>
				</a>  
				<a href="###" themeid="theme_wood1" class="themeSetting_settingButton" id="themeSetting_theme_wood1">
					<div style="background: url(images/theme_wood1.jpg) no-repeat;" class="themeSetting_settingButton_icon"></div>
					<div class="themeSetting_settingButton_text">温馨木纹</div>
				</a>         
				<a href="###" themeid="theme_wood2" class="themeSetting_settingButton" id="themeSetting_theme_wood2">
					<div style="background: url(images/theme_wood2.jpg) no-repeat;" class="themeSetting_settingButton_icon"></div>
					<div class="themeSetting_settingButton_text">黑色木纹</div>
				</a>              
				</div>						
				<div id="themeSetting_wallpaper" class="themeSetting_wallpaper" style="display: none;"></div>			
			</div>
		</div>
		<div id="zoomWallpaperGrid" class="zoomWallpaperGrid" style="position: absolute; z-index: -10; left: 0pt; top: 0pt; overflow: hidden; height: 381px; width: 1440px;">
			<img id="zoomWallpaper" class="zoomWallpaper" style="position: absolute; top: 0pt; left: 0pt; height: 381px; width: 1440px;" src="images/blue_glow.jpg">
		</div>
		<div class="taskbar_start_menu_container" id="startMenuContainer" _olddisplay="block" style="display: black">  
			<div class="startMenuImg taskbar_start_menu_body" id="taskbar_start_menu_body">          
			    <div uin="0" class="taskbar_start_menu_selfinfo" id="startMenuSelfInfo">       
				    <div class="taskbar_start_menu_nick" id="startMenuSelfNick">请&nbsp;<a href="#">登录</a></div>    
				    <a title="反馈" href="###" class="startMenuImg startMenuTopControl_support" cmd="support">&nbsp;</a>    
				    <a title="锁定" href="###" class="startMenuImg startMenuTopControl_lock" cmd="lock">&nbsp;</a>     
			    </div>              
			    <ul class="taskbar_start_menu">
				    <li cmd="favorite">
					    <a title="添加到收藏夹" href="###">添加到收藏夹</a>
				    </li>
				    <li cmd="shortcut">
				    <a title="保存桌面快捷方式" target="_blank" href="###">保存桌面快捷方式</a></li>
				    <li cmd="download">
					    <a title="下载客户端" href="###">下载客户端</a></li>
					    <li title="关于Q+ Web" cmd="about" id="taskbar_helpButton">
					    <a href="###">关于Q+ Web</a>
				    </li>
				    <li cmd="helper">
					    <a title="新手指导" href="###">新手指导</a>
				    </li>
                </ul>    
				<a class="startMenuImg logout_botton" title="注销当前用户" cmd="logout" href="###"></a>
		    </div>
		</div>
        <div style="text-align:center;clear:both">
        </div>
        <div style="background:url('images/top_bg.png'); width:476px; height:36px; text-align:center; color:white; font-weight:bold; font-size:20px; margin:0px auto;">患者服务统一平台</div>
	</body>
</html>