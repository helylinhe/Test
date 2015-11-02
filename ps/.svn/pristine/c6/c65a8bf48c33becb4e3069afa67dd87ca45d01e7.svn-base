
var type = '';
//query
$(function(){
//div定位
var one = $("#diagName").offset();
  	$("#zyzd_div").offset( {
  		top : one.top + 20,
  		left : one.left,
  	});
    	
    	
	$("#zyzd_div").panel('close');
	$("#wzyzd_div").panel('close');
	$("#uzyzd_div").panel('close');
	$.ajax({
        type: "post",
        url: 'flupnamedictaction!loadCombobox.action',
        dataType : "json",
        success: function(data){
        	$('#deptCode').combogrid({    
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
        	$('#wdeptCode').combogrid({    
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
        	$('#udeptCode').combogrid({    
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
        	$('#flupWay').combobox({    
        	    valueField:'code',    
        	    textField:'name',
        	    data : data[0].flupType
        	});
        	$('#flupWay').combobox('select', data[0].flupType[0].code);
        	 loadData(path+'/flupnamedictaction.action','flupNameDict_table',{'map.deptCode': $('#deptCode').combogrid("getValue")});
        	}
        	
	
        });
	//loadData(path+'/flupnamedictaction.action','flupNameDict_table',null);
	//查询数据触发按钮
	
	

	//表格显示数据
	  var currentIndex=-1;
			 $('#flupNameDict_table').datagrid( {
					method:'get',
					idField : 'flupNameId',
					rownumbers : true,
					title:'随访表信息',
					queryParams : '',
					singleSelect : true,
				    pagination : true,
					pageSize:10,
					height:400,
                    pageList:[10,20],
					frozenColumns:[[
						{
						field : 'flupNameId',
						title : '随访表代码',
						width : 80,
						align : 'center',
						hidden: true,
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'flupName',
						title : '随访表名',
					    width : 220,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}]],
					columns : [[ {
						field : 'flupType',
						title : '随访类别',
					    width : 80,
						align : 'center',
						formatter : function(value,row,index) {
							if(value=='1'){
								return '专科';
							}else if(value=='2'){
								return '专病';
							}else{
								return '专病细类';
							}
						}

					}
					, {
						field : 'deptName',
						title : '所属科室',
						width : 150,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'diagName',
						title : '主要诊断',
						width : 300,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'operateDate',
						title : '操作日期',
						width : 100,
						align : 'center',
						formatter : function(val, rec) {
							//return val.length!=0 ? val.substr(0,val.length-2) : val;
							return val;
						}
					},{
						field : 'employeeCode',
						title : '操作医生',
						width : 70,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					,{
						field : 'unitCode',
						title : '院区',
						width : 50,
						align : 'center',
						formatter : function(val,rec) {
							return val=='1' ? "北院" : "南院";
						}
					}
					,{
						field : 'useState',
						title : '状态',
						width : 50,
						align : 'center',
						formatter : function(val,rec) {
							return val=='1' ? "<b style='color:blue'>可用</b>" : "<b style='color:red'>不可用</b>";
						}
					}	
					,{
						field : 'buttonUseState',
						title : '操作',
						width : 70,
						align : 'center',
						formatter : function(value,row,index) {
							return value=='1' ?  "<input type='button' value='关闭' onclick='updateState("+row.flupNameId+",0)'/>" : "<input type='button' value='开启' onclick='updateState("+row.flupNameId+",1)'/>";
							
						}
					}				
					]], toolbar:[
						 {
							 text:'新增',
							 iconCls:'icon-add',
							 handler:function()
							 {
								 //新增随访记录
							 	$("#add_sftable_html").window("open");
							 	
							 }
                         },'-',	
					     {
							 text:'修改',
							 iconCls:'icon-edit',
							 handler:function(){
										        if(currentIndex==-1)
										        {
													$.messager.alert('提示', '请选择需要修改的项!', 'info');
													return false;
												} else 
												{
													$("#update_sftable_html").window("open");
													var rows = $("#flupNameDict_table").datagrid("getSelections");
													$("#uflupName").val(rows[0].flupName);
													$("#udiagName").val(rows[0].diagName);
													$("#udiagCode").val(rows[0].diagCode);
													$("#uflupNameId").val(rows[0].flupNameId);
													$("#uflupType").combobox("setValue",rows[0].flupType);
													$("#udeptCode").combogrid("setValue",rows[0].deptCode);
												}
							 }
                        }/*,'-',
						{
							 text:'清除文本框',
							 iconCls:'icon-remove',
							 handler:function()
							 {
							 	//清除文本值
							 	$("#one1").val("");
							 	$("#diagName").val("");
							 	//$("#one5").val("");
							 	//$("#diagCode").val("");
							 }
                         }*/
					],onDblClickRow: function (index, row){
					
					       
					},onClickRow:function(index,row){
						/*$("#one1").val(row.flupName);
						$("#flupWay").combobox('setValue',row.flupType);
						$("#deptCode").combobox('setValue',row.deptCode);
						$("#diagName").val(row.diagName);*/
						//$('#one5').combobox('setValue', row.diagName);
					   currentIndex=index;
					}
             });   
        
			            
			            
			            
//div显示
	          $('#ssks_tab').datagrid( {
					collapsible : true,
					remoteSort : false,
					rownumbers : false,
					queryParams : '',
					singleSelect :true,
				    pagination : false,
					pageSize:5,
                    pageList:[20,40],
					columns : [[{
						field : 'one',
						title : '科室编号',
						width : 55,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'one1',
						title : '科室名称',
					    width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					]],
                    onDblClickRow: function (index, row) {
				                        $("#one4").val(row.one1);
										$('#ssks_div').panel('close');
                    },onLoadSuccess:function(){
					   $('#ssks_div').panel('close');
					}
				
             });  
           var ssks_name={"total":40,"rows":[{"one":"000","one1":"心内科"},
                     	{"one":"001","one1":"外科"},{"one":"002","one1":"内科"},{"one":"003","one1":"骨科"},]}
			            $('#ssks_tab').datagrid('loadData', ssks_name);

		//添加随访表信息
		$('#sava').click(function(){
		
			var flupName = $('#wflupName').val();
			var flupType =  $("#wflupType").combobox("getValue");
			var diagName = $('#wdiagName').val();
			var diagCode = $('#wdiagCode').val();
			var deptCode = $('#wdeptCode').combogrid("getValue");
			if(flupName == null || flupName.length == 0 || flupName.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','随访表名不能为空！','error');
				return;
			}
			if(flupType==null || flupType.length==0 || flupType.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','随访类别不能为空！','error');
				return;
			}
			//alert($("#wflupType").combobox("getValue"));
			if($("#wflupType").combobox("getValue")=="2" || $("#uflupType").combobox("getValue")=="2"){
			if(diagName==null || diagName.length==0 || diagName.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','专病诊断组名不能为空！','error');
				return;
			}
			}
			if($("#uflupType").combobox("getValue")=="2"){
				if(udiagName==null || udiagName.length==0 || udiagName.replace(/\s/g,"").length==0){
					 $.messager.alert('警告！','专病诊断组名不能为空！','error');
					return;
				}
				}
			if(deptCode==null || deptCode.length==0 || deptCode.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','所属科室不能为空！','error');
				return;
			}
			
			
			
			$.messager.confirm('添加随访表记录','确认添加？',function(r){
				if(r)
				{
					$.post(
						path+"/flupnamedictaction!addFlupNameDict.action",
						{
							flupName : flupName,
							flupType : flupType,
							diagName : diagName,
							deptCode : deptCode,
							diagCode : diagCode
							//employeeCode : $('#employeeCode').val(),
						},
						function(data)
						{
							if(data=='success'){
								$.messager.alert('消息','添加成功','info');
								//$('#add_sftable_html').dialog('close')
								$("#wflupName").val(""); //清空随访表明
								$("#wdiagName").val(""); //清空随访诊断
								//window.location.reload();
								
								//关闭层
								$('#add_sftable_html').window('close');
								//重新加载数据
								query();
								
								
							}else{
								$.messager.alert('消息','此随访表名已存在','error');
							}
						},"text"
						);
					
				}
			});

			
		});
		//修改随访表信息
		$("#update").click(function(){
			
			var flupName = $('#uflupName').val();
			var flupType = $("#uflupType").combobox("getValue");
			var diagName = $('#udiagName').val();
			var diagCode = $('#udiagCode').val();
			var deptCode = $('#udeptCode').combogrid("getValue");
			if($("#uflupType").combobox("getValue")=="2"){
				if(diagName==null || diagName.length==0 || diagName.replace(/\s/g,"").length==0){
					 $.messager.alert('警告！','专病诊断组名不能为空！','error');
					return;
				}
				}
//			if(uflupName == null || uflupName.length == 0 || uflupName.replace(/\s/g,"").length==0){
//				 $.messager.alert('警告！','随访表名不能为空！','error');
//				return;
//			}
//			if(uflupType==null || uflupType.length==0 || uflupType.replace(/\s/g,"").length==0){
//				 $.messager.alert('警告！','随访类别不能为空！','error');
//				return;
//			}
//			if(udiagName==null || udiagName.length==0 || udiagName.replace(/\s/g,"").length==0){
//				 $.messager.alert('警告！','主要诊断不能为空！','error');
//				return;
//			}
//			if(udeptCode==null || udeptCode.length==0 || udeptCode.replace(/\s/g,"").length==0){
//				 $.messager.alert('警告！','所属科室不能为空！','error');
//				return;
//			}
			
			/****
			 * 修改后定位具体的页数
			 */
			var options = $('#flupNameDict_table').datagrid('getPager').data("pagination").options;  
			var curr = options.pageNumber; 
			$.messager.confirm('修改随访表记录','确认修改？',function(r){
				if(r){
					$.post(
						path+"/flupnamedictaction!updateFlupNameDict.action",
						{
							 flupName : flupName,
							 flupType :flupType,
							 diagName : diagName,
							 diagCode : diagCode,
						     deptCode :deptCode,
							 uflupNameId : $('#uflupNameId').val()
							 
						},
						function(data){
							if(data == 'success'){
								$.messager.alert('消息','修改成功','info');
								$('#update_sftable_html').dialog('close')
								loadData(path+'/flupnamedictaction.action','flupNameDict_table',{'page.pageNo':curr});
							}else{
								$.messager.alert('消息','修改失败','error');
							}
							
						},"text"
						
					);
				}
			
			});
			
		});
});

	
	
//点击按钮变颜色	
var o='';
function changecolor(obj){
		if(o!=obj && o!=''){	
			o.style.border='';
			o.style.color='black';
		}
		obj.style.border='1px solid #cccccc';
		obj.style.color='red';
		o=obj;
		type = $(obj).attr("rel");
		
	}


//监听键盘按键
function keyDown(r){
    $("#zyzd_div").panel('open');
	$.ajax({
        type: "post",
        url: path+'/diagGroupAction!findDiagnosisDict.action',
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#zyzd_tab').datagrid({    
        	   // url:'datagrid_data.json',    
        	    columns:[[    
        	        {field:'diagnosisCode',title:'',hidden:true},    
        	        {field:'diagnosisName',title:'',width:200}
        	        
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#diagName").val(row.diagnosisName);
				    $("#diagCode").val(row.diagnosisCode);
				    $("#zyzd_div").panel('close');
				},    
        	}); 
       $('#zyzd_tab').datagrid('loadData', data[0].rows);
    }
});
}


//监听键盘按键
function wkeyDown(r){
    $("#wzyzd_div").panel('open');
	$.ajax({
        type: "post",
        url: path+'/diagGroupAction!findDiagnosisDict.action',
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#wzyzd_tab').datagrid({    
        	   // url:'datagrid_data.json',    
        	    columns:[[    
        	        {field:'diagnosisCode',title:'',hidden:true},    
        	        {field:'diagnosisName',title:'',width:200}
        	        
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#wdiagName").val(row.diagnosisName);
				    $("#wdiagCode").val(row.diagnosisCode);
				    $("#wzyzd_div").panel('close');
				},    
        	}); 
       $('#wzyzd_tab').datagrid('loadData', data[0].rows);
    }
});
}

//监听键盘按键
function ukeyDown(r){
    $("#uzyzd_div").panel('open');
	$.ajax({
        type: "post",
        url: path+'/diagGroupAction!findDiagnosisDict.action',
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#uzyzd_tab').datagrid({    
        	   // url:'datagrid_data.json',    
        	    columns:[[    
        	        {field:'diagnosisCode',title:'',hidden:true},    
        	        {field:'diagnosisName',title:'',width:200}
        	        
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#udiagName").val(row.diagnosisName);
				    $("#udiagCode").val(row.diagnosisCode);
				    $("#uzyzd_div").panel('close');
				},    
        	}); 
       $('#uzyzd_tab').datagrid('loadData', data[0].rows);
    }
});
}

 window.setInterval(checkOnkeydown, 1000);
	    function checkOnkeydown(){
	        if(document.activeElement.id!='diagName'){
	        	$("#zyzd_div").panel('close');
	        }
	        if(document.activeElement.id!='wdiagName'){
	        	 $("#wzyzd_div").panel('close');
	        }
	         if(document.activeElement.id!='udiagName'){
	        	 $("#uzyzd_div").panel('close');	
	        }
	    }	  

/*
  修改状态
*/
function updateState(id,value){
	
	$.messager.confirm('info','确认修改状态？',function(r){
		if(r){
			$.post(
			path+"/flupnamedictaction!updateState.action",
			{
				"map.useState" : value,
				"map.flupNameId" : id 
			},
			function(data){
				//alert(data);
				$.messager.alert('消息',data,'info');
				query();
			},'text'
			);
		}
	});
	
}

function query(){
	 var param = {'map.flupName':$('#one1').val(),'map.deptCode':$('#deptCode').combogrid("getValue"),'map.diagName':($('#diagName').val()=="" ? "" : $('#diagName').val()),
	    		'map.flupType':$("#flupWay").combobox("getValue")};
	    			
		loadData(path+'/flupnamedictaction.action','flupNameDict_table',param);
}