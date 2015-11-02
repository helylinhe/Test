$(function() {
	setpos();
	$("#sfzskwh_sfb_div").panel('close');
	$("#confast_div").panel('close');
	$("#doctorconfast_div").panel('close');
	$("#sfzskwh_sfb_div1").panel('close');
	$("#confast_div1").panel('close');
	$("#doctorconfast_div1").panel('close');
	//加载所有的combobox数据
	$.ajax({
        type: "post",
        url: path+'/dataImportRuleAction!loadFlupNameDict.action',
        dataType : "json",
        success: function(data){
        	$('#flupWay').combobox({    
        	    valueField:'code',    
        	    textField:'name'   
        	}); 
        	//新增
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
        	    onHidePanel: function(){
	      	    	$.ajax({
	      	    	  type: "post",
	      	          dataType : "json",
	      	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
	      	          data:{"department.deptCode":$('#deptCode').combogrid("getValue"),
	      	        	"type":"inEmployee"} ,
	      	          success: function(data){
	      	        	$('#doctorconfast_tab').datagrid({ 
	      	        	method:'get',
	      	      		idField : 'jobnum',
	      	      		rownumbers : false,
	      	      		width:'100%',
	      	      		queryParams : '',
	      	      		columns : [ [ {
	      	      			field : 'ck',
	      	      			checkbox : true
	      	      		},
	      	            	        {field:'jobnum',title:'',hidden:true},    
	      	            	        {field:'name',title:'医生姓名',width:170}
	      	            	    ]],
	      	            	  toolbar : [ {
	      	        			text : '增加',
	      	        			iconCls : 'icon-add',
	      	        			handler : function() {
	      	        				var rows = $('#doctorconfast_tab').datagrid('getSelections');
	      	        				if(rows.length==0){
	      	        					$.messager.alert('提示', '请选择要选中的项!', 'info');
	      	        				}else{
	      	        				var info ="";
	      	        				var code ="";
	      	        				$.each( rows, function(i, n){
	      	        					info += n.name +",";
	      	        					code += n.jobnum +",";
									});
	      	        				$("#flupDoctorCode").val(info.substring(0, info.length-1));
	      	        				$("#hflupDoctorCode").val(code.substring(0, code.length-1));
	      	        				$("#flupDoctorCode")[0].focus() ;
	      	        				$('#doctorconfast_tab').datagrid('unselectAll');
	      	        				$("#doctorconfast_div").panel('close');
	      	        				}
								}
	      	        		}],
	      		      	});
	      	        	$('#doctorconfast_tab').datagrid('loadData', data[0].rows);
	      	          }
	      	    	});
	      	  }
        	});
        	
        	/*$('#flupType').combobox({    
        	    valueField:'code',    
        	    textField:'name'   
        	});*/
        	$('#flupObject').combobox({    
        	    valueField:'code',    
        	    textField:'name'   
        	});
        	$('#flupStatus').combobox({    
        	    valueField:'code',    
        	    textField:'name'   
        	});
        	$('#flupName').combogrid({    
        	    panelWidth:200,    
        	    idField:'flupNameId',    
        	    textField:'flupName',
        	    data:data[0].flupNameDictVO,
        	    columns:[[    
              	        {field:'flupName',title:'随访名称',width:180},    
              	        {field:'flupNameId',title:'flupNameId',width:100,hidden:true},    
              	    ]],
              	    singleSelect : true,
              	    onClickRow:function(index,row){
              	    	$('#flupName').val(row.flupName);
              	    	$('#flupNameId').val(row.flupNameId);
              	    	$.post(path+'/dataImportRuleAction!loadDiagCode.action',{'map.flupNameId':row.flupNameId},function (data){
              	    		if(data[0]!=null){
              	    			$("#diagName").val(data[0].DIAGNAME);
              	    			$("#diagCode").val(data[0].DIAGCODE);
              	    			var type = data[0].FLUPTYPE;
              	    			if(type=="1"){
              	    			   $("#flupType").val("专科");
              	    			}else{
              	    				$("#flupType").val("专病");
              	    			}
              	    		}else{
              	    			$("#diagName").val("");
              	    			$("#diagCode").val("");
              	    			$("#flupType").val("");
              	    		}
              	    		 
              	    	},'json');
      				} 
        	});  

        	
        	//默认加载医生的里面的面板的信息
        	$.ajax({
    	    	  type: "post",
    	          dataType : "json",
    	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
    	          data:{"department.deptCode":$('#deptCode').combogrid("getValue"),"type":"inEmployee"} ,
    	          success: function(data){
    	        	$('#doctorconfast_tab').datagrid({ 
    	        	method:'get',
    	      		idField : 'jobnum',
    	      		rownumbers : false,
    	      		width:'100%',
    	      		queryParams : '',
    	      		columns : [ [ {
    	      			field : 'ck',
    	      			checkbox : true
    	      		},
    	            	        {field:'jobnum',title:'',hidden:true},    
    	            	        {field:'name',title:'医生姓名',width:170}
    	            	    ]],
    	            	  toolbar : [ {
    	        			text : '增加',
    	        			iconCls : 'icon-add',
    	        			handler : function() {
    	        				var rows = $('#doctorconfast_tab').datagrid('getSelections');
    	        				if(rows.length==0){
    	        					$.messager.alert('提示', '请选择要选中的项!', 'info');
    	        				}else{
    	        				var info ="";
    	        				var code ="";
    	        				$.each( rows, function(i, n){
    	        					info += n.name +",";
    	        					code += n.jobnum +",";
								});
    	        				$("#flupDoctorCode").val(info.substring(0, info.length-1));
    	        				$("#hflupDoctorCode").val(code.substring(0, code.length-1));
    	        				$("#flupDoctorCode")[0].focus() ;
    	        				$('#doctorconfast_tab').datagrid('unselectAll');
    	        				$("#doctorconfast_div").panel('close');
    	        				}
							}
    	        		}],
    		      	});
    	        	$('#doctorconfast_tab').datagrid('loadData', data[0].rows);
    	          }
    	    	});
        	
        	
        	$('#flupObject').combobox('loadData', data[0].flupObject);
        	$('#flupObject').combobox('select', data[0].flupObject[0].code);
        	//$('#flupType').combobox('loadData', data[0].flupType);
        	//$('#flupType').combobox('select', data[0].flupType[0].code);
        	$('#flupWay').combobox('loadData', data[0].flupWay);
        	$('#flupWay').combobox('select', data[0].flupWay[0].code);
        	$('#flupStatus').combobox('loadData', data[0].flupStatus);
        	$('#flupStatus').combobox('select', data[0].flupStatus[0].code);
        	$('#sfzskwh_sfb').datagrid('loadData', data[0].rows);
        	$('#doctorconfast_tab').datagrid('loadData', data[0].row);
        	serach();
        	$('#flupWay1').combobox({    
        	    valueField:'code',    
        	    textField:'name'   
        	}); 
        	//新增
        	$('#deptCode1').combogrid({    
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
        	    onHidePanel: function(){
	      	    	$.ajax({
	      	    	  type: "post",
	      	          dataType : "json",
	      	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
	      	          data:{"department.deptCode":$('#deptCode1').combogrid("getValue"),
	      	        	"type":"inEmployee"} ,
	      	          success: function(data){
	      	        	$('#doctorconfast_tab1').datagrid({ 
	      	        	method:'get',
	      	      		idField : 'jobnum',
	      	      		rownumbers : false,
	      	      		width:'100%',
	      	      		queryParams : '',
	      	      		columns : [ [ {
	      	      			field : 'ck',
	      	      			checkbox : true
	      	      		},
	      	            	        {field:'jobnum',title:'',hidden:true},    
	      	            	        {field:'name',title:'医生姓名',width:170}
	      	            	    ]],
	      	            	  toolbar : [ {
	      	        			text : '增加',
	      	        			iconCls : 'icon-add',
	      	        			handler : function() {
	      	        				var rows = $('#doctorconfast_tab1').datagrid('getSelections');
	      	        				if(rows.length==0){
	      	        					$.messager.alert('提示', '请选择要选中的项!', 'info');
	      	        				}else{
	      	        				var info ="";
	      	        				var code ="";
	      	        				$.each( rows, function(i, n){
	      	        					info += n.name +",";
	      	        					code += n.jobnum +",";
									});
	      	        				$("#flupDoctorCode1").val(info.substring(0, info.length-1));
	      	        				$("#hflupDoctorCode1").val(code.substring(0, code.length-1));
	      	        				$("#flupDoctorCode1")[0].focus() ;
	      	        				$('#doctorconfast_tab1').datagrid('unselectAll');
	      	        				$("#doctorconfast_div1").panel('close');
	      	        				}
								}
	      	        		}],
	      		      	});
	      	        	$('#doctorconfast_tab1').datagrid('loadData', data[0].rows);
	      	          }
	      	    	});
	      	  }
        	});
        	
        	/*$('#flupType').combobox({    
        	    valueField:'code',    
        	    textField:'name'   
        	});*/
        	$('#flupObject1').combobox({    
        	    valueField:'code',    
        	    textField:'name'   
        	});
        	$('#flupStatus1').combobox({    
        	    valueField:'code',    
        	    textField:'name'   
        	});
        	$('#flupName1').combogrid({    
        	    panelWidth:200,    
        	    idField:'flupNameId',    
        	    textField:'flupName',
        	    data:data[0].flupNameDictVO,
        	    columns:[[    
              	        {field:'flupName',title:'随访名称',width:180},    
              	        {field:'flupNameId',title:'flupNameId',width:100,hidden:true},    
              	    ]],
              	    singleSelect : true,
              	    onClickRow:function(index,row){
              	    	$('#flupName1').val(row.flupName);
              	    	$('#flupNameId1').val(row.flupNameId);
              	    	$.post(path+'/dataImportRuleAction!loadDiagCode.action',{'map.flupNameId':row.flupNameId},function (data){
              	    		if(data[0]!=null){
              	    			$("#diagName1").val(data[0].DIAGNAME);
              	    			$("#diagCode1").val(data[0].DIAGCODE);
              	    			var type = data[0].FLUPTYPE;
              	    			if(type=="1"){
              	    			   $("#flupType1").val("专科");
              	    			}else{
              	    				$("#flupType1").val("专病");
              	    			}
              	    		}else{
              	    			$("#diagName1").val("");
              	    			$("#diagCode1").val("");
              	    			$("#flupType1").val("");
              	    		}
              	    		 
              	    	},'json');
      				} 
        	});  

        	
        	//默认加载医生的里面的面板的信息
        	$.ajax({
    	    	  type: "post",
    	          dataType : "json",
    	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
    	          data:{"department.deptCode":$('#deptCode1').combogrid("getValue"),"type":"inEmployee"} ,
    	          success: function(data){
    	        	$('#doctorconfast_tab1').datagrid({ 
    	        	method:'get',
    	      		idField : 'jobnum',
    	      		rownumbers : false,
    	      		width:'100%',
    	      		queryParams : '',
    	      		columns : [ [ {
    	      			field : 'ck',
    	      			checkbox : true
    	      		},
    	            	        {field:'jobnum',title:'',hidden:true},    
    	            	        {field:'name',title:'医生姓名',width:170}
    	            	    ]],
    	            	  toolbar : [ {
    	        			text : '增加',
    	        			iconCls : 'icon-add',
    	        			handler : function() {
    	        				var rows = $('#doctorconfast_tab1').datagrid('getSelections');
    	        				if(rows.length==0){
    	        					$.messager.alert('提示', '请选择要选中的项!', 'info');
    	        				}else{
    	        				var info ="";
    	        				var code ="";
    	        				$.each( rows, function(i, n){
    	        					info += n.name +",";
    	        					code += n.jobnum +",";
								});
    	        				$("#flupDoctorCode1").val(info.substring(0, info.length-1));
    	        				$("#hflupDoctorCode1").val(code.substring(0, code.length-1));
    	        				$("#flupDoctorCode1")[0].focus() ;
    	        				$('#doctorconfast_tab1').datagrid('unselectAll');
    	        				$("#doctorconfast_div1").panel('close');
    	        				}
							}
    	        		}],
    		      	});
    	        	$('#doctorconfast_tab1').datagrid('loadData', data[0].rows);
    	          }
    	    	});
        	
        	
        	$('#flupObject1').combobox('loadData', data[0].flupObject);
        	$('#flupObject1').combobox('select', data[0].flupObject[0].code);
        	//$('#flupType').combobox('loadData', data[0].flupType);
        	//$('#flupType').combobox('select', data[0].flupType[0].code);
        	$('#flupWay1').combobox('loadData', data[0].flupWay);
        	$('#flupWay1').combobox('select', data[0].flupWay[0].code);
        	//$('#deptCode').combobox('loadData', data[0].department);
        	//$('#deptCode').combobox('select', data[0].department[0].deptCode);
        	$('#flupStatus1').combobox('loadData', data[0].flupStatus);
        	$('#flupStatus1').combobox('select', data[0].flupStatus[0].code);
        	$('#sfzskwh_sfb1').datagrid('loadData', data[0].rows);
        	$('#doctorconfast_tab1').datagrid('loadData', data[0].row);
        	/*新增窗体*/

        	
        	/*结束新增窗体*/
        },
    });
	$('#config_list_tab').datagrid( {
		method:'get',
		pagination : true,
		pageNumber:1,
		pageSize : 10,
		pageList : [ 10, 20, 30],
		idField : 'id',
		rownumbers : false,
	    title:'导入规则配置',
	    singleSelect : true,
		width:'100%',
		queryParams : '',
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'flupType',
			title : '随访分类',
			width : 80,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='1'){return '专科';}
				if(value=='2'){return '专病';}
			}
		},{
			field : 'id',
			title : 'id',
			width : 150,
			align : 'center',
			hidden:true
		},{
			field : 'flupName',
			title : '随访表名',
			width : 200,
			align : 'center'
		}, 
		{
			field : 'deptName',
			title : '所属科室',
			width : 150,
			align : 'center',
		}, 
		{
			field : 'flupDoctorName',
			title : '随访医生',
			width : 100,
			align : 'center',
			formatter : function(value,row,index) {
				if(value==''){
					return "住院医生";
				}else{
					return value;
				}
			}
		}, {
			field : 'flupWay',
			title : '随访方式',
			width : 60,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='1'){return '电话';}
				if(value=='2'){return '短信';}
				if(value=='3'){return '微信';}
				if(value=='4'){return '门诊';}
				if(value=='5'){return '上门';}
			}
		}, {
			field : 'diagName',
			title : '病组名称',
			width : 200,
			align : 'center',
		}, {
			field : 'flupObject',
			title : '随访对象',
			width : 80,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='1'){return '本人';}
				if(value=='2'){return '联系人';}
			}
		}, {
			field : 'flupStatus',
			title : '随访状态',
			width : 100,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='1'){return '随访期';}
				if(value=='2'){return '随访结束';}
				if(value=='3'){return '失访';}
				if(value=='4'){return '黑名单';}
				if(value=='5'){return '病故';}
			}
		}, {
			field : 'flupPeonum',
			title : '随访人数',
			width : 60,
			align : 'center',
		}, {
			field : 'flupDateFlag',
			title : '起始方式',
			width : 70,
			align : 'center',
			formatter : function(value,row,index) {
				if($.trim(value)=='2'){
					return '手术日期';
				}else{
					return '出院日期';
				}
			}
		} ] ],
		toolbar : [ {
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				$("#type").val("");
				/*$.messager.confirm('确认','您确认想要将配置规则设置导入到规则配置吗(请填写以上所有的下拉列表)？',function(r){   
					if (r){    
						submit();
				    } 
				}); */
				clean();
			$("#dataInfo").window("open");
			$("#dataInfo").panel({title:"新增数据导入配置"});
			}
		}, "-", {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				var rows = $('#config_list_tab').datagrid('getSelections');
				if (rows == null || rows.length == 0) {
					$.messager.alert('提示', '请选中需要修改的项!', 'info');
					return false;
				} else {
					if(rows.length>1){
						$.messager.alert('提示', '请选中一项在进行修改!', 'info');
					}else{
						$('#type').val("update");
						$("#dataInfo").window("open");
						$("#dataInfo").panel({title:"修改数据导入配置"});
						
						$('#id1').val(rows[0].id);
						$('#deptCode1').combogrid('setValue',rows[0].deptCode);
						$('#flupWay1').combobox('setValue',rows[0].flupWay);
						var type = rows[0].flupType == "1" ? "专科" : "专病";
						$("#flupType1").val(type);
						$("#flupObject1").combobox('setValue',rows[0].flupObject);
						$("#flupTotNum1").combobox('setValue',rows[0].flupTotNum);
						$("#flupStatus1").combobox('setValue',rows[0].flupStatus);
						if(rows[0].autoGeneration=="0"){
							$("#flupPeonum1").combobox('setValue','否');
						}else{
							$("#flupPeonum1").combobox('setValue','是');
						}
						
						$("#diagName1").val(rows[0].diagName);
						$("#diagCode1").val(rows[0].diagCode);
						$('#flupNameId1').val(rows[0].flupNameId);
						$('#flupName1').combogrid("setValue",rows[0].flupName);
						if(rows[0].flupDoctorName==''){
						  $('#flupDoctorCode1').val('住院医生');
						  $('#hflupDoctorCode1').val(rows[0].flupDoctorCode);
						}else{
							$('#flupDoctorCode1').val(rows[0].flupDoctorName);
							$('#hflupDoctorCode1').val(rows[0].flupDoctorCode);
						}
						getPanelInfo();
						$.ajax({
			      	    	  type: "post",
			      	          dataType : "json",
			      	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
			      	          data:{"department.deptCode":rows[0].deptCode,"type":"inEmployee"} ,
			      	          success: function(data){
			      	        	$('#doctorconfast_tab1').datagrid({ 
			      	        	method:'get',
			      	      		idField : 'jobnum',
			      	      		rownumbers : false,
			      	      		width:'100%',
			      	      		queryParams : '',
			      	      		columns : [ [ {
			      	      			field : 'ck',
			      	      			checkbox : true
			      	      		},
			      	            	        {field:'jobnum',title:'',hidden:true},    
			      	            	        {field:'name',title:'医生姓名',width:210}
			      	            	    ]],
			      	            	  toolbar : [ {
			      	        			text : '增加',
			      	        			iconCls : 'icon-add',
			      	        			handler : function() {
			      	        				var rows = $('#doctorconfast_tab1').datagrid('getSelections');
			      	        				var info ="";
			      	        				var code ="";
			      	        				$.each( rows, function(i, n){
			      	        					info += n.name +",";
			      	        					code += n.jobnum +",";
											});
			      	        				$("#flupDoctorCode1").val(info.substring(0, info.length-1));
			      	        				$("#hflupDoctorCode1").val(code.substring(0, code.length-1));
			      	        				$("#doctorconfast_div1").panel('close');
										}
			      	        		}],
			      		      	});
			      	        	$('#doctorconfast_tab1').datagrid('loadData', data[0].rows);
			      	          }
			      	    	});
					}
				}
			}
		} 
		/*, "-",{
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				if($('#type').val()!=""&&$('#type').val()!=null){
					submit();
				}else{
					$.messager.alert('提示', '请选择需要修改的项!', 'info');
				}
			}
		}*/
		, "-",{
			text : '删除',
			iconCls : 'icon-cut',
			handler : function() {
				var rows = $('#config_list_tab').datagrid('getSelections');
				if(rows.length>=1){
					var id = "";
					for ( var i = 0; i < rows.length; i++) {
						id += rows[i].id + ',';
					}
					$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
					    if (r){  
					    	$.ajax({
								type: "post",
					            url: path+'/dataImportRuleAction!updatedataImportRule.action',
					            dataType : "json",
					            data:{"dataImportRuleId":id ,"dataImportRule.delState":1},
					            success: function(data){
					            	$.messager.alert('提示', data[0].message, 'info');
									clean();
									var param={'map.delState': "0"};
									loadData(path+'/dataImportRuleAction!loadDG.action','config_list_tab',param);
					            },
							});
					    }    
					}); 
				}else{
					$.messager.alert('提示', "请选择一行", 'info');
				}
			}
		}
		],
	});
});
$(function(){
	$("#btnSaveData").live('click',function(){
		submit();
	});
	$("#btnExit").live('click',function(){
		$("#dataInfo").window('close');
	});
});
function opfast() {
	$('#confast_div').panel('open');
}

function opfastTable() {
	$('#sfzskwh_sfb_div').panel('open');
}



function serach(){
	if($("#flupName").combogrid("getValue")==''||$.trim($("#flupName").combogrid("getValue")).length==0||$("#flupName").combogrid("getValue")==null){
		$("#flupNameId").val("");
	}
	$('#config_list_tab').datagrid('unselectAll');
	var param={'map.flupNameId':$("#flupNameId").val(),'map.flupType': $("#flupType").val(),
			'map.deptCode': $("#deptCode").combogrid("getValue"),'map.flupWay': $("#flupWay").combobox("getValue"),
			'map.flupDateFlag':$("#flupDateFlag").combobox("getValue")};
	 loadData(path+'/dataImportRuleAction!loadDG.action','config_list_tab',param);
  }

//监听键盘按键
/****function keyDown(r){
    $("#confast_div").panel('open');
	$.ajax({
        type: "post",
        url: path+'/diagGroupAction!findDiagnosisDict.action',
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#confast_tab').datagrid({    
        	    url:'datagrid_data.json',            	    columns:[[    
        	        {field:'diagnosisCode',title:'',hidden:true},    
        	        {field:'diagnosisName',title:'',width:210}
        	        
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#diagName").val(row.diagnosisName);
				    $("#diagCode").val(row.diagnosisCode);
				    $("#confast_div").panel('close');
				},    
        	}); 
       $('#confast_tab').datagrid('loadData', data[0].rows);
    }
});
}*/

//新增方法
function submit(){
	
	var num = $("#flupTotNum1").combobox("getValue");
	if(num==0){
		num=6;
	}
	var text = "";
	for ( var i = 0; i < num; i++) {
		if($("#"+(i+1)).val()!=null){
			 text += $("#"+(i+1)).val() + ",";
		  }else{
			$.messager.alert('提示', '请将随访周期信息填写完整！', 'info');
	             return;
		  }
	}
	
	if($("#flupType1").val()!="专病"){
			if($("#flupName1").combogrid("getValue")==''||$("#flupType1").val()==''||
					$("#deptCode1").combogrid("getValue")==''||
					$("#flupWay1").combobox("getValue")==''||
					$("#flupDateFlag1").combobox("getValue")=='' ||
					$("#flupCycle1").val()==''||!$("#flupDoctorCode1").validatebox("isValid")){
					$.messager.alert('提示', '请将上面信息填写完整！', 'info');
					return;
		}
	}else{
			if($("#flupName1").combogrid("getValue")==''||$("#flupType1").val()==''||$("#deptCode1").combogrid("getValue")==''||$("#flupWay1").combobox("getValue")==''||
					$("#flupDateFlag1").combobox("getValue")=='' ||
					$("#flupCycle1").val()==''||!$("#flupDoctorCode1").validatebox("isValid")){
					$.messager.alert('提示', '请将上面信息填写完整！', 'info');
					return;
			}
		
	}
	var flupType = $("#flupType1").val() == "专科" ? "1" : "2"
	$.ajax({
        type: "post",
        url: path+'/dataImportRuleAction!insertOrupdateDataImportRule.action',
        //随访对象源代码"dataImportRule.flupObject":$("#flupObject1").combobox('getValue')
        //"dataImportRule.autoGeneration":$("#flupPeonum1").combobox('getValue')
        //"dataImportRule.flupStatus":$("#flupStatus1").combobox('getValue')
        dataType : "json",
        data:{"dataImportRule.flupNumDate":text,"dataImportRule.id":$("#id1").val(),"type":$("#type").val(),"dataImportRule.deptCode":$("#deptCode1").combogrid('getValue'),"dataImportRule.flupNameId":$("#flupNameId1").val(),"dataImportRule.flupType":flupType,
        	"dataImportRule.flupWay":$("#flupWay1").combobox('getValue'),"dataImportRule.flupObject":1,"dataImportRule.flupCycle":$("#flupCycle1").val(),
        	"dataImportRule.flupTotNum":$("#flupTotNum1").combobox('getValue'),"dataImportRule.flupFirstDay":"","dataImportRule.flupStatus":1,
        	"dataImportRule.flupDept":"","dataImportRule.flupDoctorCode":$("#hflupDoctorCode1").val(),"dataImportRule.flupPeonum":'1000',
        	"dataImportRule.diagName":$("#diagName1").val(),"dataImportRule.diagCode":$("#diagCode1").val(),
    		"dataImportRule.flupDateFlag":$("#flupDateFlag1").combobox('getValue'),
    		"dataImportRule.autoGeneration":0},
        success: function(data){
        	$.messager.alert('提示', data[0].message, 'info');
        	$("#type").val("");
        	serach();
        	if(data=="修改规则成功！" || data!="新增失败,专科只能有一条规则！"){
        		$("#dataInfo").window('close');
        	}
        },
    });
	clean();
	
  }

function clean(){
	$('#id1').val("");
	$('#flupWay1').combobox('setValue',"");
	$("#flupType1").val("");
	$("#flupObject1").combobox('setValue',"");
	$("#flupStatus1").combobox('setValue',"");
	$("#delState1").combobox('setValue',"0");
	$("#diagName1").val("");
	$("#diagCode1").val("");
	$("#flupCycle1").val("");
	$('#flupNameId1').val("");
	$('#flupDoctorCode1').val("");
	$('#hflupDoctorCode1').val("");
	$('#flupPeonum1').combobox('setValue',"0");
	$("#flupTotNum1").combobox('setValue',"0");
	$('#flupName1').combogrid("setValue","");
}
function closeWindow(){
	$("#sfzskwh_sfb_div").panel('close');
}

function setpos() {
	var one = $("#flupDoctorCode").offset();
	var one1 = $("#diagName").offset();
	$("#doctorconfast_div").offset( {
		top : one.top + 20,
		left : one.left	});
	$("#confast_div").offset( {
		top : one1.top + 20,
		left : one1.left
	});
}



//获取医生的方法
function getDoctor(){
	if($("#deptCode").combogrid("getValue")==''){
		$.messager.alert('提示', "请先选择科室!", 'info');
		return;
	}
	  $("#doctorconfast_div").panel('open');
}
function getDoctor1(){
	if($("#deptCode1").combogrid("getValue")==''){
		$.messager.alert('提示', "请先选择科室!", 'info');
		return;
	}
	  $("#doctorconfast_div1").panel('open');
}


function keyMove(e){
	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
	  var odiv=document.getElementById('doctorconfast_div');
	  var left =odiv.getBoundingClientRect().left;
	  var top = odiv.getBoundingClientRect().top;
	
	  var rdiv=document.getElementById('confast_div');
	  var rleft =rdiv.getBoundingClientRect().left;
	  var rtop = rdiv.getBoundingClientRect().top;
	  if(x<left||x>(left+220)){
		  $("#doctorconfast_div").panel('close');
	  }else if(y<(top-20)||y>(top+200)){
  		//alert("上下");
  		$("#doctorconfast_div").panel('close');
	  }
	  if(x<rleft||x>(rleft+220)){
		  $("#confast_div").panel('close');
	  }else if(y<(rtop-20)||y>(rtop+100)){
		  $("#confast_div").panel('close');
	  }
};
function keyMove1(e){
	
	//alert($("#doctorconfast_div1").offset().top);
	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
	  var odiv=document.getElementById("doctorconfast_div1");
	  var left =odiv.getBoundingClientRect().left;
	  var top = odiv.getBoundingClientRect().top;
	  
	  var rdiv=$("#confast_div1");
	  var rleft =rdiv.getBoundingClientRect().left;
	  var rtop = rdiv.getBoundingClientRect().top;
	  if(x<left||x>(left+220)){
		  $("#doctorconfast_div1").panel('close');
	  }else if(y<(top-20)||y>(top+200)){
		//alert("上下");
		$("#doctorconfast_div1").panel('close');
	  }
	  if(x<rleft||x>(rleft+220)){
		  $("#confast_div1").panel('close');
	  }else if(y<(rtop-20)||y>(rtop+100)){
		  $("#confast_div1").panel('close');
	  }
};

//随访周期获取焦的方法
function getflupCycleinfo(){
	var num = $("#flupTotNum1").combobox("getValue");
	if(num==0){
		num = 6;
	}
	setDivHeight('add_sfzsk_html',parseFloat(num));
	$("#add_sfzsk_html").window('open');
	if($("#flupTotNum1").val()!=""){
		var text = "";
		for ( var i = 0; i < num; i++) {
			text += "第"+(i+1)+"次随访间隔天数:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(i+1)+"'></br>" ;
		}
		 $("#flupCycleinfo").html(text);
		var info = $("#flupCycle1").val();
		var strs= new Array();
		strs = info.split(",");
		for ( var i = 0; i < strs.length; i++) {
			$("#"+(i+1)).val(strs[i]) ;
		}
	}else{
	  getPanelInfo();
	}
}
//弹出层保存的方法
function saveNum(){
	var num = $($("#flupTotNum1"),parent.document).combobox("getValue");
	if(num==0){
		num = 6;
	}
	for (var i = 0; i < num; i++) {
		if(isNaN($("#"+(i+1)).val())){
			$.messager.alert('提示', '请填写有效数字,再保存!', 'info');
			return;
		}
		if($("#"+(i+1)).val()==''){
			$.messager.alert('提示', '请将填写完整,再保存!', 'info');
			return;
		}
	}
	
	var text = "";
	for ( var i = 0; i < num; i++) {
		text += $("#"+(i+1)).val() + ",";
	}
	$($("#flupCycle1"),parent.document).val(text.substring(0, text.length-1));
	$("#add_sfzsk_html").window('close');
}

//修改获取弹出层里面的数据
function getPanelInfo(){
	var num = $("#flupTotNum1").combobox("getValue");
	if(num==0){
		num =6;
	}
	var text = "";
	for ( var i = 0; i < num; i++) {
		text += "第"+(i+1)+"次随访间隔天数:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(i+1)+"'></br>" ;
	}
	 $("#flupCycleinfo1").html(text);
	if ($("#type").val()=='update') {
		var rows = $('#config_list_tab').datagrid('getSelections');
		$.ajax({
	        type: "post",
	        url: path+'/dataImportRuleAction!getDetailInfo.action',
	        dataType : "json",
	        data:{"type":$("#type").val(),"dataImportRule.id":rows[0].id},
	        success: function(data){
	        	var text = "";
	        	$.each( data[0].rows, function(i, n){
	        		  $("#"+(n.inpatiNumber)).val(n.inpatiSerialNumber);
	        		  text +=n.inpatiSerialNumber+",";
	        	});
	        	$("#flupCycle1").val(text.substring(0, text.length-1));
	        },
	    });
	}
}

function setDivHeight(divid,num){
	$('#'+divid).window({    
	    width:350,    
	    height:((num*30)+80),    
	    modal:true ,
	}); 
}


