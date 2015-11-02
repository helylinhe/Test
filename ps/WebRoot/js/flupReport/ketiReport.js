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
	  
	  
	  
	        
			 $('#ketiTable').datagrid( {
					method:'get',
					collapsible : false,
					remoteSort : false,
					idField : 'id',
					rownumbers : true,
					queryParams : '',
					singleSelect : true,
				    title:'随访结果统计',
					pagination : true,
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
	        				align : 'left',
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
					}, {
						field : 'inHospitalDate',
						title : '入院日期',
						width : 160,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'outHospitalDate',
						title : '出院日期',
						width : 160,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'column1',
						title : 'ALT',
						width : 160,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column2',
						title : 'AST',
						width : 70,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column3',
						title : 'r-GT',
						width : 70,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column4',
						title : '碱性磷酸酶',
						width : 70,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column5',
						title : '白蛋白',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column6',
						title : '前白蛋白',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column7',
						title : '肌酐',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column8',
						title : 'c',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column9',
						title : '尿酸',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column10',
						title : '视黄醇蛋白',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column11',
						title : '胱抑素C',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column12',
						title : '甘油三脂',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column13',
						title : '总胆固醇',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column14',
						title : 'LDL',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column15',
						title : 'HDL',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column16',
						title : '脂蛋白a',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column17',
						title : '钾',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column18',
						title : '钠',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column19',
						title : '钙',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column20',
						title : '磷',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column21',
						title : '镁',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column22',
						title : '空腹血糖',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column23',
						title : '餐后2h血糖',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column24',
						title : '空腹胰岛素',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column25',
						title : '餐后2h胰岛素',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column26',
						title : '空腹c肽',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column27',
						title : '餐后2hc肽',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column28',
						title : 'HBA1C',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column29',
						title : '果糖胺',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column30',
						title : 'IAA',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column31',
						title : 'ICA',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column32',
						title : 'GAD-Ab',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column33',
						title : '空腹胰岛素',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column34',
						title : '2分钟胰岛素',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column35',
						title : '4分钟胰岛素',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column36',
						title : '6分钟胰岛素',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column37',
						title : '8分钟胰岛素',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column38',
						title : '空腹c肽',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column39',
						title : '2分钟c肽',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column40',
						title : '4分钟c肽',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column41',
						title : '6分钟c肽',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column42',
						title : '8分钟c肽',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column43',
						title : '尿微量白蛋白',
						width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column44',
						title : '24h尿蛋白定量',
						width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column45',
						title : 'TT3',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column46',
						title : 'TT4',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column47',
						title : 'FT3',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column48',
						title : 'FT4',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column49',
						title : 'TSH',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column50',
						title : 'Tg-Ab',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column51',
						title : 'TPO-Ab',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column52',
						title : 'TR-Ab',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column53',
						title : 'Tg',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column54',
						title : 'PTH',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column55',
						title : '骨钙素N端中分子片段（N-MID）',
						width : 130,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column56',
						title : 'B-胶原降解产物',
						width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column57',
						title : '25羟基VitD',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column58',
						title : 'I型胶原氨基末端肽',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column59',
						title : '降钙素CT2',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column60',
						title : 'AFP',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column61',
						title : 'CEA',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column62',
						title : 'CA-199',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column63',
						title : 'CA-242',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column64',
						title : 'CA-50',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column65',
						title : 'NSE',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column66',
						title : 'PSA',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column67',
						title : 'FPSA',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'column68',
						title : 'fPSA',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					]],
					onClickRow: function(rowIndex, rowData){
					
				}

			 });  
			 
  });
  
  /******
   * 随访项信息调阅
   */
  function showFlupItems(){
	  $("#flupItems").window('open');
	  var row = $('#ketiTable').datagrid('getSelected');
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
	 /* var flupDeptCode=$('#deptCode').combogrid('getValue');
	  if(flupDeptCode!="" &&flupDeptCode!="不限"){
		  flupDeptCode=$('#deptCode').combogrid('getValue');
	  }else{
		  flupDeptCode="";
	  }*/
	  var param={"map.inpatiNumber":reportInpatiNumberValue,"map.startDate":startDateValue,
			    "map.endDate":endDateValue,"map.name":nameValue};
	 loadData(path+'/ketiReportaction!pageList.action','ketiTable',param); 
	
  }
  
  
  /*****
   * 报表导出JS
   */
  function reportDate(){
	  $('#reportStartDate').val($("#startDate").val());
	  $('#reportEndDate').val($("#endDate").val());
	  $("#patiName").val($("#name").val());
	  $("#reportDataInpatiNumber").val($("#reportInpatiNumber").val());
	  var url=path+"/ketiReportaction!exportData.action";
	  var downloadForm = $('#downloadForm');
  		downloadForm.attr('action',url);
		downloadForm.submit();
 
	  
  }

             