  $(function(){
	  
	  $("#flupItems").window('close');
	
	  $('#flupTables').combobox({    
		  panelWidth:200,    
		  valueField:'flupNameId',    
  	      textField:'flupName'
	  });
	  

	      	$.post(path+'/flupnamedictaction!loadCombobox.action',function (data){
	      	  /****
	             * 加载所属科室
	             */
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
	        	searchData();
	        	
	     	},'json');
	      	
	      	$.post(path+'/reportdataaction!loadFlupNameDict.action',function (data){
	      		$('#flupTables').combobox('loadData', data[0].rows);
	      		$('#flupTables').combobox('select',data[0].rows[0].flupName);
	      	},'json');
	      	
	  
	  
	  $('#startDate').val("");
		//$('#outHospitalDateStart').val(getNowFormatDate());
		$('#startDate').click(function() {
			WdatePicker( {
				minDate : '{%y-80}-%M-%d',
				readOnly : true
			});
		});

		$('#endDate').val("");
		$('#endDate').click(function() {
			WdatePicker( {
				minDate : '{%y-80}-%M-%d',
				readOnly : true
			});
		});
	  
	  
	  
	         var currentIndex=-1;
			 $('#keshisuifangcxtable').datagrid( {
					method:'get',
					collapsible : false,
					remoteSort : false,
					idField : 'id',
					rownumbers : true,
					queryParams : '',
					singleSelect : true,
				    title:'随访结果统计',
					pagination : true,
					nowrap:false,
					pageSize:10,
                    pageList:[10,20],
                    hideColumn:[[
                        {
	        				field : 'id',
	        				title : '任务编号',
	        				width : 150,
	        				align : 'left',
	        				formatter : function(val, rec) {
	        					return val;
	        				}
                        },{
	        				field : 'flupTableNameId',
	        				title : '随访表编号',
	        				width : 150,
	        				align : 'left',
	        				formatter : function(val, rec) {
	        					return val;
	        				}
                        },{
	        				field : 'inpatiSerialNumber',
	        				title : '住院流水号',
	        				width : 150,
	        				align : 'left',
	        				formatter : function(val, rec) {
	        					return val;
	        				}
                        },{
	        				field : 'patiSerial',
	        				title : '病人编号',
	        				width : 150,
	        				align : 'left',
	        				formatter : function(val, rec) {
	        					return val;
	        				}
                        }
                        ]],
					frozenColumns:[[
						{
	        				field : 'inpatiNumber',
	        				title : '住院号',
	        				width : 100,
	        				align : 'center',
	        				formatter : function(val, rec) {
	        					return val;
	        				}
                        },{
						field : 'flupDate',
						title : '随访日期',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'name',
						title : '姓名',
					    width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'gender',
						title : '性别',
					    width : 40,
						align : 'center',
						formatter : function(val, rec) {
							 return val == '1' ? '男' : '女';
						}
					}
					]],
					columns : [[ {
						field : 'age',
						title : '年龄',
					    width : 50,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'outHospDiag',
						title : '出院诊断',
						width : 160,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'operationName',
						title : '手术名称',
						width : 150,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'operationDoctorCode',
						title : '主刀医生',
						width : 70,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'operationPrognosis',
						title : '手术预后',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'totalMoney',
						title : '总费用',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'charityAidMoney',
						title : '慈善救助',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'flupResult',
						title : '随访结果',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'doctorName',
						title : '随访医生',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'flupFailre',
						title : '随访说明',
						width : 350,
						align : 'left',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'fluptimes',
						title : '随访次数',
						width : 80,
						align : 'left',
						formatter : function(val, rec) {
							return val;
					}
					}
					]],
					onClickRow: function(rowIndex, rowData){
				 		$("#flupItem").val("flupItem");
						$("#reportInpatiNumber").val(rowData.inpatiNumber);
				}

			 });  
    	    	
  });
  
  /******
   * 随访项信息调阅
   */
  function showFlupItems(){
	  $("#flupItems").window('open');
	  var row = $('#keshisuifangcxtable').datagrid('getSelected');
	  alert(row);
	  
  }
  
  
  /******
   * 查询
   */
  function searchData(){
	  var reportInpatiNumberValue=$("#reportInpatiNumber").val();
	  var startDateValue=$("#startDate").val();
	  var endDateValue=$("#endDate").val();
	  var nameValue=$("#name").val();
	  var flupNameIdValue=$('#flupTables').combobox('getValue');
	  var flupDeptCode=$('#deptCode').combogrid('getValue');
	  var flupComplete=$("#flupCompletes").combobox('getValue');
	  if(flupNameIdValue!="" &&flupNameIdValue!="不限"){
		  flupNameIdValue=$('#flupTables').combobox('getValue')
	  }else{
		  flupNameIdValue="";
	  }
	  if(flupDeptCode!="" &&flupDeptCode!="不限"){
		  flupDeptCode=$('#deptCode').combogrid('getValue');
	  }else{
		  flupDeptCode="";
	  }
	  var doctorValue=$("#doctorName option:selected").val();
	  var param={"map.inpatiNumber":reportInpatiNumberValue,"map.startDate":startDateValue,
		  		"map.flupComplete":flupComplete,
			    "map.endDate":endDateValue,"map.name":nameValue,"map.doctorCode":doctorValue,"map.flupNameId":flupNameIdValue,"map.deptCode":flupDeptCode};
	 loadData(path+'/reportdataaction!pageList.action','keshisuifangcxtable',param); 
	
  }
  
  
  /*****
   * 报表导出JS
   */
  function reportDate(){
	  var value=$('#flupTables').combobox('getValue');
	  if(value!="" && value!="不限"){
		  $("#flupNameId").val($('#flupTables').combobox('getValue'));
	  }else{
		  $("#flupNameId").val("");
	  }
	  var flupDeptCode=$('#deptCode').combogrid('getValue');
	  if(flupDeptCode!="" &&flupDeptCode!="不限"){
		  flupDeptCode=$('#deptCode').combogrid('getValue');
	  }else{
		  flupDeptCode="";
	  }
	  $("#flupComplete").val($('#flupCompletes').combobox('getValue'));
	  $("#reportDataInpatiNumber").val($("#reportInpatiNumber").val());
	  $('#flupTableName').val($('#flupTables').combobox('getText'));
	  $('#reportStartDate').val($("#startDate").val());
	  $('#reportEndDate').val($("#endDate").val());
	  $("#patiName").val($("#name").val());
	  $("#reportDataInpatiNumber").val($("#reportInpatiNumber").val());
	  $("#flupDeptCode").val(flupDeptCode);
	  var url=path+"/reportdataaction.action";
	  var downloadForm = $('#downloadForm');
  		downloadForm.attr('action',url);
		downloadForm.submit();
 
	  
  }

             