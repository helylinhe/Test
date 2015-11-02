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

		<title>上海市区域医疗行为监管平台</title>

		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css"
			href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="http://www.jeasyui.com/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css"
			href="http://www.jeasyui.com/easyui/demo/demo.css">
		<script type="text/javascript"
			src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
		<script type="text/javascript"
			src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/comment/comment.js"></script>
		<script type="text/javascript">
	$(function() {
				/*$.post('http://localhost:8080/PS/useraction.action',function(data){
					var blm_datapatient_data={"total":data[0].totalRecord,"rows":data[0].rows};
					$('#blxx_tab').datagrid('loadData', blm_datapatient_data);
					 var p = $('#blxx_tab').datagrid('getPager'); 
					  $(p).pagination({
					  			beforePageText: '第',//页数文本框前显示的汉字 
        						afterPageText: '页    共 '+data[0].totalPage+' 页', 
        						displayMsg: '当前显示 {from} - {to} 条记录   共 '+data[0].totalRecord+'条记录',	
        						onSelectPage:function (pageNumber, pageSize){
        							$.post('http://localhost:8080/PS/useraction.action',{'page.pageNo':pageNumber,'page.pageSize':pageSize},function (d){
        								$('#blxx_tab').datagrid('loadData',{"total":d[0].totalRecord,"rows":d[0].rows});
        								$('#blxx_tab').datagrid('getPager').pagination({
        									beforePageText: '第',//页数文本框前显示的汉字 
        									afterPageText: '页    共 '+d[0].totalPage+' 页', 
        									displayMsg: '当前显示 {from} - {to} 条记录   共 '+d[0].totalRecord+'条记录'
        								});	
        							},'json')
        						}
					  });
				},'json')*/
	
		$('#blxx_tab').datagrid( {
			collapsible : false,
			remoteSort : false,
			idField : 'id',
			rownumbers : true,
			queryParams : '',
			singleSelect : false,
			showRefresh:false,
			title : '用户信息',
			pagination : true,
			width : '100%',
			pageNumber:1,
			pageSize : 3,
			pageList : [ 3, 6 ],
			toolbar : [ '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					edit_suifang_winopen();
				}
			} ],
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'userName',
				title : '用户名',
				width : 50,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			}, {
				field : 'password',
				title : '密码',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},

			{
				field : 'roles',
				title : '用户角色',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			} ] ],
			columns : [ [ {
				field : 'deleteFlag',
				title : '删除状态',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},  {
				field : 'userDate',
				title : '用户日期',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			} , {
				field : 'creeatDate',
				title : '创建日期',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			}] ],

			onClickRow : function() {
				
				
		},
		onDblClickRow : function(index, row) {
			
			//$('#sflsjl_tab').datagrid('loadData', sflljl_data);
			//$('#jzjlcx_tab').datagrid('loadData', jzxxcx_data)
		}

		});
		
		loadData('http://localhost:8080/PS/useraction.action','blxx_tab',null)
		
		
		$("#search").click(function (){
				/*var jsMap={};
					jsMap['map.creeatDate']='2014-05-07';*/
				var param={'map.creeatDate':'2014-05-07'};
				loadData('http://localhost:8080/PS/useraction.action','blxx_tab',param);
		});
		
	});
</script>
	</head>

	<body>
	
		<div  style="border:0px;font-size:12px;">
						<div style="width:96%;height:50px;margin-left:10px;margin-top:15px;" id="blm_querycondition">
						  <fieldset style="border:1px solid #6293BB;">
						     <legend>病例查询条件</legend>
							  <table style="width:100%;">
									<tr>
                                          <td nowrap="nowrap">&nbsp;随访状态：
                                          </td>
                                          <td nowrap="nowrap"><select class="easyui-combobox" style="width:124px;">
                                                      <option value ="随访期">不限</option> 
                                                      <option value ="随访期">随访期</option>
                                                      <option value ="非随访期">非随访期</option>
                                                      <option value ="失访">失访</option>
                                                      <option value ="查无此人">查无此人</option>
                                                      <option value ="病故">病故</option>
                                                </select></td>
                                         <td nowrap="nowrap">
                                            &nbsp;姓名：
                                         </td> 
                                         <td><input type="text" style="width:120px;" id="username"></td>
                                         <td nowrap="nowrap">
                                             &nbsp;住院号：
                                         </td>
                                         <td>
                                         <input type="text" style="border:1px solid #cccccc;width:120px;"/>
                                         </td>
                                          <td nowrap="nowrap">
                                             &nbsp;出院日期：
                                         </td>
                                         <td>
                                         <input type="text" style="border:1px solid #cccccc;width:120px;" id="chuDate"/>
                                         </td>
                                         <td nowrap="nowrap">
                                             <a href="javascript:void(0);"  class="easyui-linkbutton"  style="height:24px;" icon="icon-search" id="search">查询</a>
                                         </td>
									</tr>
						   </table>
						  </fieldset>
						  </div>
						   <div style="width:96%;height:400px;margin-left:10px;margin-top:5px;">
						  <table id="blxx_tab"></table>
							
						  </div>
			</div>
	</body>
</html>
