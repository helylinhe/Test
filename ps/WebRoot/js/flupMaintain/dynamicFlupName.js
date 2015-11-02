var type = '1';
$(function() {
	
	loadDept();
	//初始化动态报表列表数据
	loadGridDate();
	load();
	//查询按钮
	$('#query').click(function(){
		loadGridDate();
	});
	
});

//添加动态报表信息
function add_rpt(){
	if(document.getElementsByName("reportName1.reportName")[0].value ==''){
		$.messager.alert('消息','报表名称不能为空！','error');
		return ;
	}
	if($("#inDept1").combobox("getValue")==''){

		$.messager.alert('消息','请选择所属科室！','error');
		return ;
	}
	
	$.post(path+'/dynamicReportaction!toSearchname.action',{'reportName.reportName' :document.getElementsByName("reportName1.reportName")[0].value,
		'reportName.deptCode':document.getElementsByName("reportName1.deptCode")[0].value,
		'reportName.unitCode':document.getElementsByName("reportName1.unitCode")[0].value,
		'reportName.menuNo':document.getElementsByName("reportName1.menuNo")[0].value,
	},function(data) {
		var json=JSON.parse(data);
		if(json[0].rows==""){
			var value = $("#mumeName").combobox('getText');
			$("#reportMenuName").val(value);
			$('#add_fm').form('submit',{
				url:path+'/dynamicReportaction!addReport.action',
				onSubmit : function(){
					return $(this).form('validate');
				},
				success : function(){
					$('#add_report').window('close');
					loadGridDate();
					$.messager.show({
						title:'提示',
						msg:"添加动态报表信息成功！"
							
					})
					
				}
			});
			
		}else{
			
			$.messager.alert('提示','报表名称已存在，不能重复添加！','error');
		}
	});
	
	
	
}

//修改动态报表信息
function edit_rpt(){
	if(document.getElementsByName("reportName2.reportName")[0].value ==''){
		$.messager.alert('消息','报表名称不能为空！','error');
		return ;
	}
	if($("#inDept2").combobox("getValue")==''){
		$.messager.alert('消息','请选择所属科室！','error');
		return ;
	}
	$.post(path+'/dynamicReportaction!toSearchname.action',{'reportName.reportName' :document.getElementsByName("reportName2.reportName")[0].value,
		'reportName.deptCode':document.getElementsByName("reportName2.deptCode")[0].value,
		'reportName.unitCode':document.getElementsByName("reportName2.unitCode")[0].value,
		'reportName.menuNo':document.getElementsByName("reportName2.menuNo")[0].value,
	},function(data) {
		var json=JSON.parse(data);
		if(json[0].rows==""){
				$('#edit_fm').form('submit',{
					url:path+'/dynamicReportaction!editReport.action',
					onSubmit : function(){
						return $(this).form('validate');
					},
					success : function(){
						$('#edit_report').window('close');
						$('#data_grid').datagrid('clearSelections');//清楚datagrid选中的行
						loadGridDate();
						loadData(path+'/dynamicReportaction!pageReport.action','data_grid',null);
						$.messager.show({
							title:'提示',
							msg:"修改动态报表信息成功！"
						})
					}
				});
		}else{
			
			$.messager.alert('提示','报表名称已存在，不能重复添加','error');
		}
	});
}

function loadGridDate(){
	var param  = {'map.reportName' : $('#reportName').val(),'map.deptCode' : $('#inDept').combobox('getValue')};
	loadData(path+'/dynamicReportaction!pageReport.action','data_grid',param); 
	$("#data_grid").datagrid("unselectAll");
}

//加载所属科室下拉菜单
/**----------------------------------------------------------------------------------------------------*/
function loadDept(){
	 $.ajax({
         type: "post",
         dataType : "json",
         url: 'flupTaskAction!loadDoctorCombobox.action',
         success: function(data){
        	 $('#inDept,#inDept1').combogrid({    
        		 panelWidth:200,    
         	     idField:'deptCode',    
         	     textField:'deptName',
         	     data:data[0].department,
        		 columns:[[    
        		           {field:'deptCode',title:'科室编码',width:60,hidden:true},    
        		           {field:'deptName',title:'科室名称',width:120},    
        		           {field:'unitCode',title:'院区',width:50,
        		        	   formatter : function(value,row,index) {
        		   				if(value=='1'){return '北院';}
        		   				if(value=='2'){return '南院';}
        		   			     }
        		        	 },    
        		       ]] , 
          	});
         }
	 });
}

/*
修改状态
*/

function updateState(id,value){
	
	$.messager.confirm('info','确认修改状态？',function(r){
		if(r){
			$.post(path+"/dynamicReportaction!updateStatus.action",{"reportName2.status":value,"reportName2.id":id},function(data) {
					$.messager.show({
						title:'提示',
						msg:"修改动态报表状态成功！"
					});
					loadGridDate();
				});
		}
			
	});
}

//动态报表信息列表
function load(){
	var param=[];
	var ids = [];
	var value;
	$('#data_grid').datagrid( {
		method : 'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : param,
		singleSelect : true,
		title : '动态报表信息列表',
		striped : true,
		pagination : true,
		pageSize : 10,
		fitColumns:true,
		pageList : [ 10, 20 ],
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},
		{
			field : 'id',
			hidden:true
		} 
		] ],
		columns : [ [  {
			hidden:true,
			field : 'ID',
			title : 'ID',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'REPORTNAME',
			title : '名称',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'MENUNAME',
			title : '菜单名称',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			hidden:true,
			field : 'DEPTCODE',
			title : '所属科室编码',
			width : 40,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'DEPTNAME',
			title : '所属科室',
			width : 40,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'EMPLOYEENO',
			title : '操作医生',	
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'OPREATEDATE',
			title : '操作日期',
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'STATUS',
			title : '状态',
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
				value=val.replace(/\s+/g,"");
				return val.replace(/\s+/g,"")=='1' ? "<b style='color:blue'>正常</b>" : "<b style='color:red'>关闭</b>";
			}
		}  , {
			hidden:true,
			field : 'UNITCODE',
			title : '所属院区',
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'operation',
			title : '操作',
			width : 50,
			align : 'center',
			formatter : function(val,row, index) {
				return value=='1' ?  "<input type='button' value='关闭' onclick='updateState("+row.ID+",0)'/>" : "<input type='button' value='开启' onclick='updateState("+row.ID+",1)'/>";
			}
		} ] ],
		toolbar : [{
			id : 'btnsearchTwo',
			text : '添加',
			type : 'menubutton',
			iconCls : 'icon-add',
			menu : '#mm',
			handler : function() {
				var nowDate = new Date();
				var year=nowDate.getFullYear();
				var month=nowDate.getMonth()+1;
				var day=nowDate.getDate();
				var date=year+"-"+month+"-"+day;
				$('#opreateDate1').val(date);
				$("#inDept1").combobox('setText','不限');
				$("#unitCode1").combobox('setValue',1);
				$("#mumeName").combobox('setValue',1);
				$("#add_report").window("open");	
				$(".easyui-validatebox").val("");
				
				
			}
		},{
			id : 'btnsearchTwo',
			text : '修改',
			type : 'menubutton',
			iconCls : 'icon-edit',
			menu : '#mm',
			handler : function() {
				
				var row = $('#data_grid').datagrid('getSelected');
				if(!row){
					$.messager.alert('消息','请选择需要需要修改的动态报表','error');
					return;
				}else{
					$.ajax({
				         type: "post",
				         dataType : "json",
				         url: 'flupTaskAction!loadDoctorCombobox.action',
				         success: function(data){
				        	 $('#inDept2').combogrid({    
				        		 panelWidth:200,    
				         	     idField:'deptCode',    
				         	     textField:'deptName',
				         	     data:data[0].department,
				         	     value:row.DEPTCODE,
				        		 columns:[[    
				        		           {field:'deptCode',title:'科室编码',width:60,hidden:true},    
				        		           {field:'deptName',title:'科室名称',width:120},    
				        		           {field:'unitCode',title:'院区',width:50,
				        		        	   formatter : function(value,row,index) {
				        		   				if(value=='1'){return '北院';}
				        		   				if(value=='2'){return '南院';}
				        		   			     }
				        		        	 },    
				        		       ]] , 
				          	});
				         }
					 });
					var nowDate = new Date();
					var year=nowDate.getFullYear();
					var month=nowDate.getMonth()+1;
					var day=nowDate.getDate();
					var date=year+"-"+month+"-"+day;
					$('#opreateDate2').val(date);
					
					$('#id2').val(row.ID);
					$('#reportName2').val(row.REPORTNAME);
//					$('#inDept2').combobox('setValue',row.DEPTCODE);
					$('#unitCode2').combobox('setValue', (row.UNITCODE) .replace(/\s+/g,""));
					//$('#opreateDate2').datebox('setValue',row.OPREATEDATE);
					$('#status2').val(row.STATUS);
					$("#edit_report").window("open");	
				}
			}
		}],
		onLoadSuccess : function(data) {
			if (data) {
				$.each(data.rows, function(index, item) {
					if (item.checked) {
						ids.push(index);
					}
				});
			}
		}
		});
		
}

////点击按钮变颜色	
//var o='';
//function changecolor(obj){
//		if(o!=obj && o!=''){	
//			o.style.border='';
//			o.style.color='black';
//		}
//		obj.style.border='1px solid #cccccc';
//		obj.style.color='red';
//		o=obj;
//		type = $(obj).attr("rel");
//		
//	}

