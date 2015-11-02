<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>短信随访</title>
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
		<script type="text/javascript" src="<%=path%>/js/flupTaskExecution/consultinfo.js"></script>
        <script>
			//随访编辑
			function help_winopen() {
				$("#help_html").window("open");
			}
			function doctor_winclose() {
				$("#help_html").window("close");
			}
			
		</script>
  </head>
  
  <body  leftmargin="0" topmargin="0">
		<!-- Content Layout -->
		<div  style="border: 0px;font-size:12px">
			<div style="width: 96%; height: auto; margin-left: 10px; margin-top: 15px;">
				<table style="width: 95%; height: auto;" cellspacing="0" cellpadding="0">
					<tr>
						<td nowrap>&nbsp;住院号：</td>
                        <td><input type="text"/></td>
                        <td nowrap>&nbsp;姓名：</td>
                        <td><input type="text"/></td>
                        <td nowrap>&nbsp;咨询号码：</td>
                        <td><input type="text"/></td>
                        <td nowrap>&nbsp;身份证号：</td>
                        <td><input type="text"/></td>
                        <tr>
                        	<td nowrap>&nbsp;咨询状态：</td>
                            <td>
                                <select class="easyui-combobox" id="consult_status" style=" width:154px">
                                    <option value="完成">完成</option>
                                    <option value="未完成">未完成</option>
                                </select>
                            </td>
                        	<td nowrap>&nbsp;患者状态：</td>
                            <td>
                                <select class="easyui-combobox" id="consult_status" style=" width:154px">
                                    <option value="正常">正常</option>
                                    <option value="黑名单">黑名单</option>
                                </select>
                            </td>
                            <td colspan="3" align="right"></td>
                            <td>
                            	<a href="javascript:void(0);" onclick="" class="easyui-linkbutton"  style="height:24px;" icon="icon-search">查询</a>
                            </td>
                        </tr>
                        <tr><td colspan="8">&nbsp;</td></tr>
                        <tr>
                        	<td nowrap>&nbsp;症状咨询内容：</td>
                            <td colspan="7"><input type="text" style="width:99%" /></td>
                        </tr>
                        <tr>
                        	<td nowrap>&nbsp;意见建议：</td>
                            <td colspan="7"><input type="text"  style="width:99%"/></td>
                        </tr>
                        <tr>
                        	<td nowrap>&nbsp;诊疗知识检索：</td>
                            <td colspan="7"><input type="text"  style="width:99%"/></td>
                        </tr>
                        <tr>
                            <td colspan="8" align="center">
                                <a href="javascript:void(0);" onclick="help_winopen()" class="easyui-linkbutton"  style="height:24px;" icon="icon-help">协助申请</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="javascript:void(0);" onclick="" class="easyui-linkbutton"  style="height:24px;" icon="icon-save">咨询完成</a><a>
                            </td>
                        </tr>
					
				</table>
			</div>
			<div style="width: 96%; margin-left: 10px; margin-top: 5px;">
				<div id="consult_tab"></div>
			</div>
            
            <div id="help_html" iconCls="icon-add"
				style="width: 510px; height: 300px; model: true;" closed="true"
				draggable="true" collapsible="false" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="协助申请">
				<table style="width: 490px; margin-left: 5px;">
					<tr>
						<td>
							协助医生：
						</td>
						<td><input id="doctor_name" type="text" style="width:302px;" placeholder="双击选择协助医生！" onDblClick="opfast()" /></td>
					</tr>
                    <tr>
                    	<td>问题内容：</td>
                        <td>
                        	<textarea id="question" style="width:300px;height:100px;">
                            
                            </textarea>
                        </td>
                    </tr>
					<tr>
						<td colspan="4" align="center">
							<a id="confirm" href="javascript:void(0);" class="easyui-linkbutton" icon="icon-save" onclick=
                                doctor_winclose();
                            >确认</a>
							<a href="javascript:void(0);" class="easyui-linkbutton" icon="icon-cancel"
								onclick=
                                doctor_winclose();
                            >取消</a>
						</td>
					</tr>
				</table>
			</div>
            
            <div id="consultinfo_div" style=" margin-left: 10px; margin-top:10px" class="easyui-panel">
				<div id="consultinfo" class="easyui-datagrid"></div>
			</div>
            
		</div>
        <!-- 医生信息弹出datagrid -->
        <div style="width:400px;position: absolute; top:40%; left: 40%; model:true; z-index:10000;"
            class="easyui-panel" id="doctor_div">
            <div id="doctor_grid" class="easyui-datagrid"></div>
        </div>
	</body>
</html>
