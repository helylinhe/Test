<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript"> var path='<%=path%>';</script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
	var hkey_root, hkey_path, hkey_key
	hkey_root = "HKEY_CURRENT_USER"
	hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
	//设置网页打印的页眉页脚为空
	function pagesetup_null() {
		try {
			var RegWsh = new ActiveXObject("WScript.Shell")
			hkey_key = "header"
			RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
			hkey_key = "footer"
			RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
		} catch (e) {
		}
	}
	//设置网页打印的页眉页脚为默认值
	function pagesetup_default() {
		try {
			var RegWsh = new ActiveXObject("WScript.Shell")
			hkey_key = "header"
			RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "&w&b页码，&p/&P")
			hkey_key = "footer"
			RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "&u&b&d")
		} catch (e) {
		}
	}
</script>
<script type="text/javascript">
	$(function() {
		var obj = window.opener.document.getElementById("divprint");
		$("#printhtml").html($(obj).html());
		pagesetup_null();
		window.print();
	});
</script>
	</head>

	<body>
		<div id="printhtml"></div>
		<div id="sffwjl_tab_div"></div>
	</body>
</html>
