$(function(){	 
     setpos();
	  $("#add_flup_item").window('close');
	  $("#upd_flup_item").window('close');
	  $("#add_group_item").window('close');
	  $("#update_group_item").window('close');
	  //加载所属科室下拉菜单
	  $.ajax({
	         type: "post",
	         dataType : "json",
	         url: 'diagGroupAction!loadCombox.action',
	         success: function(data){
	        	 $('#diagGroup').combobox({    
	         	    valueField:'groupCode',    
	         	    textField:'groupName'   
	         	});
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
	        	 $('#hdeptCode').combogrid({    
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
	        	$('#diagGroup').combobox('loadData', data[0].diagGroup);
	        	
	        	  serach();
	        	if(data[0].rows!='' && data[0].rows!=[]){
	        		$('#diagGroup').combobox('select', data[0].diagGroup[0].groupCode);
	        	}
	         }
	     });
	
			 $('#flupitem_table').datagrid( {
				    method:'get',
					pageSize : 10,
					pageList : [ 10, 20, 30],
					idField : 'groupCode',
				    title:'患者分组信息',
					collapsible : false,
					remoteSort : false,
					rownumbers : true,
					queryParams : '',
					singleSelect : true,
					pagination : true,
					width:'95%',
					columns:[[{
					    field : 'ck',
					    checkbox : true
					  	} ,
					          {
							   field : 'groupCode',
								title : '分组编号',
								width : 50,
								align : 'center'
							},{
								field : 'groupName',
								title : '分组名称',
								width : 170,
								align : 'center'
							},
							{
								field : 'groupType',
								title : '分组类型',
								width : 100,
								align : 'center',
								formatter : function(val,rec) {
									return val=='1' ? "诊断分组" : "手术分组";
								}
							},
							{
								field : 'deptName',
								title : '科室名称',
								width : 150,
								align : 'center'
							},
							{
								field : 'unitCode',
								title : '院区',
								width : 100,
								align : 'center',
								formatter : function(val,rec) {
									return val=='1' ? "北院" : "南院";
								}
							}
					]], toolbar:[
						 {
							 text:'新增分组',
							 iconCls:'icon-add',
							 handler:function(){
								 $("#add_group_item").window('open'); 
								 $("#confast_div").panel('close');
							}
                         },'-',{
							 text:'修改分组',
							 iconCls:'icon-edit',
							 handler:function(){
								 var row = $('#flupitem_table').datagrid('getSelected');
								 if(row==null){
									 $.messager.alert('提示', "请选中一行在修改", 'info');
									 return ;
								 }
								 $("#ugroupName").val(row.groupName);
								 $('#udeptCode').combogrid('setValue', row.deptCode);
								 $('#ugroupType').combobox('setValue', row.groupType);
								 $("#update_group_item").window('open'); 
								 $("#confast_div").panel('close');
								 
							}
                         },'-',{
    						 text:'删除',
    						 iconCls:'icon-cut',
    						 handler:function(){
    							 var rows = $('#flupitem_table').datagrid('getSelections');
    							 if(rows.length=='0'){
    								 $.messager.alert('提示', "请选中一行在删除", 'info');
    								 return ;
    							 }
    							 $.messager.confirm('确认','确定删除吗？',function(r){   
 									if (r){    
 										 var id = "";
 										 for (var i = 0; i < rows.length; i++) {
 											id += rows[i].groupCode +",";
 										 }
 											$.ajax({
 										        type: "post",
 										        url: path+'/diagGroupAction!deleteGroup.action',
 										        dataType : "json",
 										        data:{"diagGroup.id":id},
 										        success: function(data){
 										        	$.messager.alert('提示', data[0].message, 'info');
 										        	serach();
 										        	serachInfo();
 										        	$('#flupitem_table').datagrid('unselectAll');
 										        }
 										  });
 								    } 
 								}); 
    					 }
                       }
					],
			 onDblClickRow :function(rowIndex,rowData){
				 $("#groupType3").val(rowData.groupType);
				 $("#lab_groupName").text($("#groupType3").val()=='1'?'诊断名称':'手术名称');
				 $("#flupitem_table2").datagrid({title:rowData.groupName+'—'+(rowData.groupType=='1'?'诊断分组':'手术分组')+"详细信息"});  
				 var param ={'map.groupCode':rowData.groupCode,'map.groupType':rowData.groupType};
				 loadData(path+'/diagGroupAction!loadDataGridIcd.action','flupitem_table2',param);
			 }
             }); 
			 
			 
			 $('#flupitem_table2').datagrid( {
				    method:'get',
					pageSize : 10,
					pageList : [ 10, 20, 30],
					idField : 'id',
				    title:'分组详细信息',
					collapsible : false,
					remoteSort : false,
					rownumbers : true,
					queryParams : '',
					singleSelect : true,
					pagination : true,
					width:'100%',
					columns:[[{
					    field : 'ck',
					    checkbox : true
					  	} ,
					  	 {
							field : 'id',
							title : 'id',
							width : 150,
							align : 'center',
							hidden:true
								},
					        {
								field : 'diagnosisName',
								title : '主要诊断/手术名称',
								width : 150,
								align : 'center'
							},
					          {
								field : 'diagnosisCode',
								title : '主要诊断/手术代码',
								width : 150,
								align : 'center'
							}
					]], toolbar:[
					  {
						 text:'新增',
						 iconCls:'icon-add',
						 handler:function(){
							var row = $('#flupitem_table').datagrid('getSelected');
							if(row==''||row==null){
							 $.messager.alert('提示', "请选择诊断组，在添加对应诊断！", 'info');
							 return;
							}
							$("#add_flup_item").window({title:(row.groupType=='1'?'新增诊断':'新增手术')+'信息'});
						  $("#add_flup_item").window('open');
						  $("#confast_div").panel('close');
	 			       }
                       },'-',{
						 text:'删除',
						 iconCls:'icon-cut',
						 handler:function(){
							 var rows = $('#flupitem_table2').datagrid('getSelections');
							 if(rows.length=='0'){
								 $.messager.alert('提示', "请选中一行在删除", 'info');
								 return ;
							 }
							 $.messager.confirm('确认','确定删除吗？',function(r){   
									if (r){    
										 var id = "";
										 for (var i = 0; i < rows.length; i++) {
											id += rows[i].id +",";
										 }
											$.ajax({
										        type: "post",
										        url: path+'/diagGroupAction!deleteIcd.action',
										        dataType : "json",
										        data:{"diagGroup.id":id},
										        success: function(data){
										        	$.messager.alert('提示', data[0].message, 'info');
										        	serachInfo();
										        	$('#flupitem_table2').datagrid('unselectAll');
										        }
										  });
								    } 
								});
							}
                      }
					]
          }); 
}); 
	        //查找的方法
	        function serach(){
	        	var param={'map.groupName':$("#groupName").val(),
	        			'map.deptCode':$("#deptCode").combogrid("getValue")
	        	};
	        	 loadData(path+'/diagGroupAction!loadDG.action','flupitem_table',param);
	        	 $('#flupitem_table2').datagrid('loadData',{ total: 0, rows: [] });
			  }

		    function setpos() {
		    	var one = $("#udiagName").offset();
		    	var one1 = $("#idiagName").offset();
		    	$("#uconfast_div").offset( {
		    		top : one.top + 65,
		    		left : one.left+80
		    	});
		    	$("#confast_div").offset( {
		    		top : one1.top + 65,
		    		left : one1.left+80
		    	});
		    }
		    function keyMove(e){
		    	
		  	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
		  	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
		  	  var odiv=document.getElementById('confast_div');
		  	  var left =odiv.getBoundingClientRect().left;
		  	  var top = odiv.getBoundingClientRect().top;
		  	
		  	  var rdiv=document.getElementById('uconfast_div');
		  	  var rleft =rdiv.getBoundingClientRect().left;
		  	  var rtop = rdiv.getBoundingClientRect().top;
		  	  //console.info($("#doctorconfast_div").panel('close'));
		  	  if(x<left||x>(left+210)){
		  		  $("#confast_div").panel('close');
		  	  }else if(y<(top-20)||y>(top+100)){
		    		//alert("上下");
		    		$("#confast_div").panel('close');
		  	  }
		  	  if(x<rleft||x>(rleft+210)){
		  		  $("#uconfast_div").panel('close');
		  	  }else if(y<(rtop-20)||y>(rtop+100)){
		  		  $("#uconfast_div").panel('close');
		  	  }
		  };
		  
		  //新增
			function add(){
//				lab_groupName
//				add_flup_item	新增弹出窗口id
				if($("#idiagCode").val()==''||$("#idiagName").val()==''){
					$.messager.alert('提示', "请选择！", 'info');
					return;
				}
				
				var row = $('#flupitem_table').datagrid('getSelected');
				$.ajax({
			        type: "post",
			        url: path+'/diagGroupAction!insert.action',
			        dataType : "json",
			        data:{"diagGroup.groupName":row.groupName,"diagGroup.groupCode":row.groupCode,"diagGroup.diagnosisName":$("#idiagName").val(),"diagGroup.diagnosisCode":$("#idiagCode").val()},

			        error: function(data){
			        	$.messager.alert('提示', "数据库异常,请勿重复添加数据！", 'info');
			        },
			        success: function(data){
			        	$.messager.alert('提示', data[0].info, 'info');
			        	$("#idiagName").val('');
			        	$("#idiagCode").val('');
			        	//$("#add_flup_item").window('close');
			        	serachInfo();
			        	$('#flupitem_table2').datagrid('unselectAll');
			        }
			    });
				
			};  
			
			  //新增诊断组
			function addGroup(){
				if($.trim($("#ggroupName").val())==''){
					$.messager.alert('提示', "诊断组名称不能为空！", 'info');
					return;
				}
				if($.trim($("#hdeptCode").combogrid("getValue"))==''){
					$.messager.alert('提示', "请选择科室！", 'info');
					return;
				}
				if($.trim($("#groupType").combogrid("getValue"))=='0'){
					$.messager.alert('提示', "请选择分组类型！", 'info');
					return;
				}
				
				$.ajax({
			        type: "post",
			        url: path+'/diagGroupAction!insertGroup.action',
			        dataType : "json",
			        data:{"diagGroup.groupName":$("#ggroupName").val(),
			        	"diagGroup.deptCode":$("#hdeptCode").combogrid("getValue"),
			        	"diagGroup.groupType":$("#groupType").combogrid("getValue")
			        },
			        error: function(data){
			        	$.messager.alert('提示', "数据库异常,请勿重复添加数据！", 'info');
			        },
			        success: function(data){
			        	 $.messager.alert('提示', "添加成功!", 'info');
			        	  serach();
			        	  $("#ggroupName").val('');
			        	  $("#add_group_item").window('close');
			        	  $('#flupitem_table').datagrid('unselectAll');
			        }
			    });
				
			}; 
			  //修改诊断组
			function updateGroup(){
				 var row = $('#flupitem_table').datagrid('getSelected');
				 $.messager.confirm('确认','若修改分组类型该分组类型下的分组详细信息将会被清空，确定要修改吗？',function(r){   
						if (r){    
							$.ajax({
								type: "post",
								url: path+'/diagGroupAction!updateGroup.action',
								dataType : "json",
								data:{"diagGroup.id":row.groupType,
									"diagGroup.groupName":$("#ugroupName").val(),
									"diagGroup.groupCode":row.groupCode,
									"diagGroup.deptCode":$("#udeptCode").combogrid("getValue"),
									"diagGroup.groupType":$("#ugroupType").combogrid("getValue")},
									error: function(data){
										$.messager.alert('提示', "数据库异常,分组名重复！", 'info');
									},
									success: function(data){
										$.messager.alert('提示', "修改成功!", 'info');
										$.ajax({
											type: "post",
											dataType : "json",
											url: 'diagGroupAction!loadCombox.action',
											success: function(data){
												$('#diagGroup').combobox({    
													valueField:'groupCode',    
													textField:'groupName'   
												});
												$('#diagGroup').combobox('loadData', data[0].diagGroup);
												$('#diagGroup').combobox('select', data[0].diagGroup[0].groupCode);
											}
										});
										var grid = $('#flupitem_table');  
										var options = grid.datagrid('getPager').data("pagination").options;  
										var no = options.pageNumber;  
										var size = options.pageSize;  
										var param={'map.groupName':"%"+$("#groupName").val()+"%",
												'map.deptCode':$("#deptCode").combogrid("getValue"),
												'page.pageNo':no,'page.pageSize':size
										};
										loadData(path+'/diagGroupAction!loadDG.action','flupitem_table',param);
										serachInfo();
										$("#update_group_item").window('close');
										$('#flupitem_table').datagrid('unselectAll');
										var param={'map.groupName':'',
												'map.deptCode':''
										};
									}
							});
					    } 
					}); 
				 
				 
				
			}; 
			
			
			
			
			function keyDown(r){
				$("#confast_div").panel('open');
				var row = $('#flupitem_table').datagrid('getSelected');
				$.ajax({
			        type: "post",
			        url: 'diagKnowledgeAction!findDiagnosisDict.action',
			        dataType : "json",
			        data:{"keyInfo":r.value+"%","groupType":row.groupType},
			        success: function(data){
			        	$('#confast_tab').datagrid({    
			        	    columns:[[  
			        	        {field:'diagnosisName',title:(row.groupType=='1'?'诊断':'手术')+'名称',width:170,center:true},
			        	        {field:'diagnosisCode',title:(row.groupType=='1'?'诊断':'手术')+'编码',width:110,center:true},    
			        	       
			        	    ]],
			        	    singleSelect : true,
			        	    onClickRow:function(index,row){
			        	    		 $("#idiagName").val(row.diagnosisName);
			        	    		 $("#idiagCode").val(row.diagnosisCode);
			        	    		 $('#zyzz_key').datagrid('unselectAll');
			        	    		 $("#confast_div").panel('close');
			        	    	}
			        	}); 
			       $('#confast_tab').datagrid('loadData', data[0].rows);
			    }
			});
}
			
			
			function ukeyDown(r){
			    $("#uconfast_div").panel('open');
				$.ajax({
			        type: "post",
			        url: 'diagKnowledgeAction!findDiagnosisDict.action',
			        dataType : "json",
			        data:{"keyInfo":r.value+"%"},
			        success: function(data){
			        	$('#uconfast_tab').datagrid({    
			        	   // url:'datagrid_data.json',    
			        	    columns:[[    
			        	        {field:'diagnosisCode',title:'',hidden:true},    
			        	        {field:'diagnosisName',title:'',width:200}
			        	        
			        	    ]],
			        	    singleSelect : true,
			        	    onClickRow:function(index,row){
							    $("#udiagName").val(row.diagnosisName);
							    $("#udiagCode").val(row.diagnosisCode);
							    $("#uconfast_div").panel('close');
							},    
			        	}); 
			       $('#uconfast_tab').datagrid('loadData', data[0].rows);
			    }
			});
			}
			
 function serachInfo(){
	 var row = $('#flupitem_table').datagrid('getSelected');
	 var param ={'map.groupCode':row.groupCode};
	 loadData(path+'/diagGroupAction!loadDataGridIcd.action','flupitem_table2',param);
 }			
