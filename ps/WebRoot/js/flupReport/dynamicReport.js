  $(function(){
	  
	  /*$("#flupItems").window('close');
	
	  $('#flupTables').combobox({    
		  panelWidth:200,    
		  valueField:'flupNameId',    
  	      textField:'flupName'
	  });*/
	  
	  
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
	  

	      	$.post(path+'/flupnamedictaction!loadCombobox.action',function (data){
	      	  /***************************************************************
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
	       		       ]],
	       		    onClickRow: function(rowIndex, rowData){
						$('#deptCode').attr("lang",rowData.deptCode);
					}
	      	  });
	        
	      	//$('#deptCode').combogrid('setValue',data[0].department[0].deptName);
	      	$('#deptCode').attr("lang",data[0].department[0].deptCode);
	      	/****
			  * 加载数据
			  */
			 //searchData();
	      	
	      	
	     	},'json');
	      	
	    
	  
	      	/*******************************************************************
			 * 报表加载数据
			 */
			 $('#reportTable').datagrid( {
					method:'get',
					unselectAll:true,
					collapsible : false,
					remoteSort : false,
					idField : 'id',
					rownumbers : true,
					queryParams : '',
					singleSelect : true,
				    title:'报表项统计',
					pagination : true,
					pageSize:10,
                    pageList:[10],
					onClickRow: function(rowIndex, rowData){
					
					}
			 });  
			
			 
		
			 
  });
  
  /***************************************************************************
	 * 随访项信息调阅
	 */
  function showFlupItems(){
	  $("#flupItems").window('open');
	  var row = $('#ketiTable').datagrid('getSelected');
	  
	  
  }
  
  
  /***************************************************************************
	 * 查询
	 */
  function searchData(){
	  var reportInpatiNumberValue=$("#reportInpatiNumber").val();
	  var startDateValue=$("#startDate").val();
	  var endDateValue=$("#endDate").val();
	  var nameValue=$("#name").val();
	  var deptCode = $('#deptCode').attr("lang");
	  $('#reportTable').datagrid('loadData',{"total":0,"rows":""});
	  var param={"map.inpatiNumber":reportInpatiNumberValue,"map.startDate":startDateValue,
			    "map.endDate":endDateValue,"map.name":nameValue,"map.pageSize":10,"map.pageNo":1,"map.statu":"","map.deptCode":deptCode};
	  dynamicReport(param);
	  
	
  }
  
  
  /****
   * 动态加载
   */
  function dynamicReport(param){
	  $.messager.progress({title:"数据加载中...",text:""}); 
	  $.post(path+'/dynamicReportaction!reportTitle.action',param,function (data){
			var options = $("#reportTable").datagrid("options"); 
			options.frozenColumns=eval(data.frozenColumns);
			 options.columns = eval(data.columns); 
			 $("#reportTable").datagrid(options);   
			 $.post(path+'/dynamicReportaction!reportData.action',param,function (data){
				 $.messager.progress('close');
				 $('#reportTable').datagrid('loadData',{"total":data.total,"rows":data.rows});
			 },'json');
			 var p = $('#reportTable').datagrid('getPager'); 
			 $(p).pagination({
				 onSelectPage:function (pageNumber, pageSize){	
				 $.post(path+'/dynamicReportaction!reportData.action',{'map.pageSize':pageSize,'map.pageNo':pageNumber,"map.statu":"statu","map.deptCode":$('#deptCode').attr("lang")},function (data){
					 $('#reportTable').datagrid('loadData',{"total":data.total,"rows":data.rows});
				 },'json');			
			 	}
			 });
			
	 },'json');
  }
  
  
  /***************************************************************************
	 * 报表导出JS
	 */
  function reportDate(){
	  $('#reportStartDate').val($("#startDate").val());
	  $('#reportEndDate').val($("#endDate").val());
	  $("#patiName").val($("#name").val());
	  $("#reportDataInpatiNumber").val($("#reportInpatiNumber").val());
	  $("#reportDeptCode").val($('#deptCode').attr("lang"));
	  var url=path+"/dynamicReportaction!exportInspectData.action";
	  var downloadForm = $('#downloadForm');
  		downloadForm.attr('action',url);
		downloadForm.submit();
	 /* var reportInpatiNumberValue=$("#reportInpatiNumber").val();
	  var startDateValue=$("#startDate").val();
	  var endDateValue=$("#endDate").val();
	  var nameValue=$("#name").val();
	  var deptCode = $('#deptCode').attr("lang");
	  var param={"map.inpatiNumber":reportInpatiNumberValue,"map.startDate":startDateValue,
			    "map.endDate":endDateValue,"map.name":nameValue,"map.deptCode":deptCode};
	  $.post(path+"/dynamicReportaction!exportInspectData.action",param,function (data){
		  
	  },'contentType:"application/json"')*/
 
	  
  }

             