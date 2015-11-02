<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>患者服务平台-登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery.winResize.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery.form.js"></script>
		<script type="text/javascript"> var path='<%=path%>';</script>
		<script type="text/javascript" src="<%=path%>/js/login.js"></script>
		<!--<script type="text/javascript" src="resources/jquery/jquery.pager.js"></script>
		

--><style type="text/css">
.style1 {
	font-size: 32px;
	float: left;
	font-family: 楷体;
	padding-left: 200px;
	padding-top: 35px;
	color: Gray;
	color: #0066CC;
	width: 750px;
	padding-bottom: 5px;
}

.style2 {
	font-size: 14px;
	float: right;
	font-family: 楷体;
	width: 740px;
	margin-top: 25px;
	margin-left: 220px;
}

.style3 {
	font-size: 14px;
	float: left;
	font-family: 楷体;
	width: 960px;
	height: 52px;
	margin-top: 90px;
}

.btnLogin {
	background-image: url(<%=basePath%>/images/login_btn.gif);
	width: 124px;
	height: 25px;
}

#status {
	height: 35px;
}

.selectbox {
	width: 180px;
	height: 20px;
	line-height: 20px;
	color: #333;
	border: 1px solid #cacaca;
	background: #fff;
	padding: 0px;
	margin-right: 5px;
	display: inline;
	vertical-align: middle;
}
</style>
		
		<script>
			// 如果浏览器窗口大小改变，则更新窗口大小
			$(function() {
				//$('#content').css('margin-top', ($(window).height() - 380) / 2);
				
				//javascript禁用浏览器后退
				//window.history.go(-1);
			});

			$(window).wresize(
					function() {
						$('#content').css('margin-top',
								($(window).height() - 380) / 2);
					});
		</script>
		
</head>
<body id="cas" style="background-color: #0063b8; height: 100%;"
	class="login">
	<script language="JavaScript"> 
			javascript:window.history.forward(1); 
		</script> 
	<div id="content" style="margin-top: 200px;">
		<form id="login-form" method="post">
		<div id="ContainerNoBImg" style="background-color: #0063b8;">
			<table align="center">
				<tr>
					<td>
						<div id="Content">
							<div id="main">
								<div
									style="background: url(images/login_bg.jpg); width: 960px; height: 380px;">
									<div class="style1">
										<strong style="margin-left: 165px;">患者服务统一平台<strong
											style="font-size: 14px; margin-left: 20px;"></strong></strong>
									</div>
									<div class="style2">
										<table align="center" style="width: 320px; height: 100%;">


											<tr style="height: 70px;">
												<td style="width: 100px; text-align: right;"><label
													for="user.username">工号:</label></td>
												<td style="width: 220px; text-align: center;">
													<div class="row">
														<input id="txtJobnumber" name="employee.jobnum" tabindex="1"
															accesskey="n" type="text" value="" size="25"
															autocomplete="false" />
													</div>
												</td>
											</tr>


											<tr style="height: 50px;">
												<td style="width: 100px; text-align: right;"><label
													for="password">密码:</label></td>
												<td style="width: 220px; text-align: center;">
													<div class="row">
														<input id="txtPassword" name="employee.passwd" tabindex="2"
															accesskey="p" type="password" value="" size="25"
															autocomplete="off" />
													</div>
												</td>
											</tr>

											<tr style="height: 40px;">
												<td colspan="2" style="width: 300px;">
													<div class="row btn-row"
														style="margin-top: 20px; margin-left: 25px;">
														<input type="button" class="btnLogin" id="btnLogin" name="submit"
															accesskey="l" value="登录" tabindex="2" 
															style="float: left; color: White; border-style: None; font-family: Broadway; text-decoration: none;" />&nbsp;
														<input class="btnLogin" id="chongzhi" name="chongzhi"
															accesskey="c" value="重置" tabindex="5" type="reset"
															style="color: White; border-style: None; font-family: Broadway; text-decoration: none;" />
													</div>
												</td>
											</tr>

										</table>
									</div>
									<div class="style3" style="margin-top: 50px;">
										<table align="center" style="width: 560px;">
											<tr>
												<td><img src="images/LOGO.gif" width="174px;"
													height="33px" /></td>
												<td>Copyright © 2014-2017 LinkonWorks Inc.</td>
											</tr>
										</table>

									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		</form>
	</div>
</body>
</html>

