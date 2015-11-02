var rowindex = undefined;
$(function(){	 
     setpos();
	  zyzz_zsk_div_close();
	  $.ajax({
	        type: "post",
	        url: path+'/diagKnowledgeAction!loadCombobox.action',
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
	        	  serach();
	        }
	   });
	
	  $("#add_sfzsk_html").window("close");
	  $("#zyzz_key_div").panel('close');
			 $('#sfzlzsk_tab').datagrid( {
				    method:'get',
					pageSize : 10,
					pageList : [ 10, 20, 30],
					idField : 'knowledgeCode',
				    title:'随访诊疗问题',
					collapsible : false,
					remoteSort : false,
					rownumbers : true,
					queryParams : '',
					singleSelect : false,
					pagination : true,
					width:'100%',
					frozenColumns:[[
						{
						    field : 'ck',
						    checkbox : true
						  } ,
						{
						field : 'deptName',
						title : '所属科室',
						width : 100,
						align : 'center',
					}, {
						field : 'diagName',
						title : '主要诊断',
					    width : 150,
						align : 'center'
					},
					  ]],
					columns : [[{
						field : 'bodyPartName',
						title : '症状部位',
					    width : 70,
						align : 'center'
					}, 
					{
						field : 'knowledgeCode',
						title : 'id',
					    width : 70,
						align : 'center',
						hidden:true
					},
					{
						field : 'deptCode',
						title : '科室编码',
					    width : 150,
						align : 'center',
						hidden:true
					}
					, 
					{
						field : 'id',
						title : '科室id',
					    width : 150,
						align : 'center',
						hidden: true
					},{
						field : 'mainSymptom',
						title : '主要症状',
					    width : 70,
						align : 'center'
					},{
						field : 'auditsState',
						title : '状态',
					    width : 50,
						align : 'center',
						formatter:function(value,row,index){
							if(value=='1'){return '审核';}
							if(value=='2'){return '未审核';}
							if(value=='3'){return '未通过';}
						}
					},{
						field : 'symptomDesc',
						title : '症状描述',
					    width : 280,
						align : 'center'
					}
					, {
						field : 'symptomAnalyze',
						title : '症状分析',
					    width : 280,
						align : 'center'
					}, {
						field : 'advise',
						title : '意见建议',
						width : 280,
						align : 'center'
					},{
						field : 'logDate',
						title : '操作日期',
						width : 100,
						align : 'center'
					},{
						field : 'logEmpolyeeCode',
						title : '操作医生',
						width : 80,
						align : 'center'
					}
					]], toolbar:[
						 {
							 text:'新增',
							 iconCls:'icon-add',
							 handler:function(){
								 $.messager.confirm('确认','您确认想要将上面的信息导入随访诊疗问题吗(请填写以上所有的输入框)？',function(r){   
										if (r){    
											 $("#type").val("新增");
											 submit();
									    } 
									});
							}
                         },'-',
					     {
							 text:'修改',
							 iconCls:'icon-edit',
							 handler:function(){
								 var rows = $('#sfzlzsk_tab').datagrid('getSelections');
								// console.info(rows);
									 if(rows.length==0){
											    $.messager.alert('提示', '请选择需要修改的项!', 'info');
											}else if(rows.length>1){
												$.messager.alert('提示', '请选择修改的一项进行修改!', 'info');
											} else {
												    clearTxt();
													$("#deptCode").combogrid('setValue',rows[0].deptCode);
													$("#symptomAnalyze").val(rows[0].symptomAnalyze);
													$("#symptomDesc").val(rows[0].symptomDesc);
													$('#bodyPartNameClass').combobox('setValue',rows[0].bodyPartName);
													$("#advise").val(rows[0].advise);
													$("#type").val("update");
													$("#knowledgeCode").val(rows[0].knowledgeCode);
													$("#diagName").val(rows[0].diagName);
													$("#diagCode").val(rows[0].diagCode);
													serachMS(rows[0].bodyPartName,rows[0].dictId);
													$("#mainSymptom").val(rows[0].mainSymptom);
								 }
							 }
                        },'-',
                        {
							 text:'保存',
							 iconCls:'icon-save',
							 handler:function(){
								 submit();
								 serach();
							 }
                       },'-',
                        {
							 text:'审核',
							 iconCls:'icon-ok',
							 handler:function(){
								 var rows = $('#sfzlzsk_tab').datagrid('getSelections');
								 if(rows.length==0){
									 $.messager.alert('提示', '请选择需要审核的项!', 'info'); 
								 }else{
									var bool = "2";
									$.each( rows, function(i, n){
										if(n.auditsState=="1"){
										$.messager.alert('提示', '选中项中包含审核过的项目，请勿重复审核！', 'info'); 
										bool = "1";
										}
									});
									 if(bool=="2"){
										 $("#add_sfzsk_html").window("open"); 
									 }
									
								 }
							 }
                        },'-',
						{
							 text:'清除文本框',
							 iconCls:'icon-remove',
							 handler:function(){clearTxt();}
                         }
					]
             }); 
//			 loadData(path+'/diagKnowledgeAction!loadDG.action','sfzlzsk_tab',null);
			 $.ajax({
		            type: "post",
		            dataType : "json",
		            url: path+'/diagKnowledgeAction!loadDict.action',
		            success: function(data){
		            	 var a =document.getElementById("dictSpan").innerHTML;
		    			 for ( var i = 0; i < data[0].dict.length; i++) {
		    				 a += "<span style=margin-right:20px;><a class='bodyPartNameClass' id= '"+data[0].dict[i].name+"' href=javascript:serachMS('"+data[0].dict[i].name+"',"+data[0].dict[i].id+"); rel='专病'>"+data[0].dict[i].name+"</a></span>";
		    			}
		    			 document.getElementById("dictSpan").innerHTML=a;
		            },
		        });
});
	        function clearTxt(){
	                        $("#deptCode").val("");
                            $("#symptomAnalyze").val("");
                            $("#symptomDesc").val("");
                            $("#bodyPartName").val("");
							$("#mainSymptom").val("");
							$("#advise").val("");
							$("#logDate").val("");
							$("#logEmpolyeeCode").val("");
							$("#status").val("");
							$(".bodyPartNameClass").css({ color: "#0000ff" });
							$("#bodyPartName").val("");
				        	$("#placeCode").val("");
				        	$('#diagCode').val("");
				        	$('#diagName').val("");
				        	$("#knowledgeCode").val("");
				        	
	           }
	        //查找的方法
	        function serach(){
	        	  if($.trim($("#diagName").val()).length==0){
	  	        	$("#diagCode").val("");
	  	        }
	        	var param={'map.deptCode':$("#deptCode").combogrid("getValue"),'map.mainSymptom': $('#mainSymptom').val(),
	        			'map.diagCode': $('#diagCode').val(),
	        			'map.bodyPartName':$("#bodyPartName").val()};
	        	 loadData(path+'/diagKnowledgeAction!loadDG.action','sfzlzsk_tab',param);
			  }
	        //新增的方法
	        function submit(){
	        	if($("#deptCode").combogrid("getValue")==''||$("#symptomAnalyze").val()==''||$("#symptomDesc").val()==''
	        		||$("#mainSymptom").val()==''||$("#bodyPartName").val()==''||$("#advise").val()==''){
	        		$.messager.alert('提示', '请将上面信息填写完整！', 'info');
	        		return;
	        	}
	        	$.ajax({
		            type: "post",
		            url: path+'/diagKnowledgeAction!insertOrUpdateDiagKnowledge.action',
		            dataType : "json",
		            data:{"type":$("#type").val(),"diagKnowledge.deptCode":$("#deptCode").combogrid("getValue"),"diagKnowledge.symptomAnalyze":$("#symptomAnalyze").val(),"diagKnowledge.symptomDesc":$("#symptomDesc").val(),
		            	"diagKnowledge.mainSymptom":$("#mainSymptom").val(),"diagKnowledge.bodyPartName":$("#bodyPartName").val(),
		            	"diagKnowledge.advise":$("#advise").val(),"diagKnowledge.diagName":$("#diagName").val(),"diagKnowledge.diagCode":$("#diagCode").val(),"diagKnowledge.logEmpolyeeCode":"","diagKnowledge.knowledgeCode":$("#knowledgeCode").val()},
		            success: function(data){
		            	$.messager.alert('提示', data[0].message, 'info');
		            	//loadData(path+'/diagKnowledgeAction!loadDG.action','sfzlzsk_tab',null);
		            	serach();
		            	if(data[0].success==true){
		            		add_sfzsk_winclose();
		            		
		            	}
		            },
		        });
	        	clearTxt();
			  }
	       //点击主要症状的时候调用的方法 
	        function serachMS(r,n){
	        	$("#mainSymptom").val("");
	        	$("#bodyPartName").val(r);
	        	$("#placeCode").val(n);
	        	$(".bodyPartNameClass").css({ color: "#0000ff" });
	        	$("#"+r).css({ color: "#ff0011" });
	        	$.ajax({
		            type: "post",
		            url: path+'/diagKnowledgeAction!findSymptomDictByDcitId.action',
		            dataType : "json",
		            data:{"dictId":n},
		            success: function(data){
		            	$('#zyzz_zsk').datagrid({    
		            	    columns:[[   
		            	        {field:'symptomCode',title:'编号',width:50},    
		            	        {field:'symptomName',title:'症状名',width:200,
		            	        	editor : {
										type : 'validatebox',
										options : {
											required : true
										}
									}	
		            	        }  
		            	    ]],
		            	    toolbar:[
		    						 {
		    							 text:'新增',
		    							 iconCls:'icon-add',
		    							 handler:function(){
		    								 if(rowindex==undefined){
		    								 $('#zyzz_zsk').datagrid('insertRow', {
		    										index : 0,
		    										row : {
		    											symptomCode : '无需手动输入',
		    											symptomName : '请输入症状名'
		    										}
		    									});
		    									 $('#zyzz_zsk').datagrid('beginEdit', 0);
		    									 rowindex= 0;
		    								 }
		    							 }
		                             },{
		    							 text:'保存',
		    							 iconCls:'icon-save',
		    							 handler:function(){
		    								 $('#zyzz_zsk').datagrid('endEdit', rowindex);
		    								 rowindex=undefined;
		    							 }
		                             }],
		            	//单击事件
		                onClickRow:function(index,row){
						    $("#mainSymptom").val(row.symptomName);
							zyzz_zsk_div_close();
						},
						//右键菜单
						onRowContextMenu : function(e, rowIndex, rowData) {
							e.preventDefault();
							$(this).datagrid('unselectAll');
							$(this).datagrid('selectRow', rowIndex);
							$('#mm').menu('show', {
								left : e.pageX,
								top : e.pageY
							});
						},
						//完成修改之后触发的事件
		            	onAfterEdit : function(rowIndex, rowData, changes) {
		        			var inserted = $('#zyzz_zsk').datagrid('getChanges', 'inserted');
		        			var updated = $('#zyzz_zsk').datagrid('getChanges', 'updated');
		        			if (inserted.length > 0) {
		        				//console.info(inserted);
		        				$.ajax({
			    		            type: "post",
			    		            url: path+'/diagKnowledgeAction!insertSymptomdict.action',
			    		            dataType : "json",
			    		            data:{"symptomDict.symptomName":rowData.symptomName,"symptomDict.placeCode":$("#placeCode").val()
			    		            	},
			    		            success: function(data){
			    		            	$.messager.alert('提示', data[0].message, 'info');
			    		            	$.ajax({
			    				            type: "post",
			    				            url: path+'/diagKnowledgeAction!findSymptomDictByDcitId.action',
			    				            dataType : "json",
			    				            data:{"dictId":$("#placeCode").val()},
			    		            		success: function(data){
			    		            			$('#zyzz_zsk').datagrid('loadData', data[0].rows);
			    		            	     }
			    				            });
			    		            },
			    		        });
		        			}
		        			if (updated.length > 0) {
		        				//console.info(updated);
		        				$.ajax({
			    		            type: "post",
			    		            url: path+'/diagKnowledgeAction!updateSymptomdict.action',
			    		            dataType : "json",
			    		            data:{"symptomDict.symptomName":rowData.symptomName,"symptomDict.symptomCode":rowData.symptomCode},
			    		            success: function(data){
			    		            	$.messager.alert('提示', data[0].message, 'info');
			    		            	$.ajax({
			    				            type: "post",
			    				            url: path+'/diagKnowledgeAction!findSymptomDictByDcitId.action',
			    				            dataType : "json",
			    				            data:{"dictId":$("#placeCode").val()},
			    		            		success: function(data){
			    		            			$('#zyzz_zsk').datagrid('loadData', data[0].rows);
			    		            	     }
			    				            });
			    		            },
			    		        });
		        			}
		        			rowedit = undefined;
		            	}
		            	});
		            	$('#zyzz_zsk').datagrid('loadData', data[0].rows);
		            }
		        });
	        }
	        //修改方法
	        updateSymptomDict=function(){
	        	var rows = $('#zyzz_zsk').datagrid('getSelections');
	        	var index = $('#zyzz_zsk').datagrid('getRowIndex', rows[0]);
	        	if (rowindex != undefined) {
	        		$('#zyzz_zsk').datagrid('endEdit', rowindex);
	        		rowindex = undefined;
	        	}else{
	        		$('#zyzz_zsk').datagrid('beginEdit', index);
	        		rowindex =index;
	        	}
	        };
	        //保存方法
	        saveSymptomDict= function(){
	        	var rows = $('#zyzz_zsk').datagrid('getSelections');
	        	var index = $('#zyzz_zsk').datagrid('getRowIndex', rows[0]);
	        	if (rowindex != undefined) {
	        		$('#zyzz_zsk').datagrid('endEdit', rowindex);
	        		rowindex = undefined;
	        	}else{
	        		$('#zyzz_zsk').datagrid('beginEdit', index);
	        		rowindex =index;
	        	}
	        };
	        //关闭审核window
	        function add_sfzsk_winclose(){
				  $("#add_sfzsk_html").window("close");
		     }
	        //点击审核保存的方法
	        function updateAuditsState(){
	        	 var rows = $('#sfzlzsk_tab').datagrid('getSelections');
	        	 if(rows.length==0){
					    $.messager.alert('提示', '请选择需要审核的项!', 'info');
	        	 }else{
	        		 if($('#auditsState').combobox("getValue")!="3"||$('#diagRemark').val()!=''){
	        		    var knowledgeCode = "";
						for ( var i = 0; i < rows.length; i++) {
							knowledgeCode += rows[i].knowledgeCode + ',';
						}
		        	$.ajax({
			            type: "post",
			            url: path+'/diagKnowledgeAction!updatdiagKnowledge.action',
			            dataType : "json",
			            data:{"allKnowledgeCode":knowledgeCode,"diagKnowledge.auditsState":$('#auditsState').combobox('getValue'),"diagKnowledge.diagRemark":$('#diagRemark').val()},
			            success: function(data){
			            	$.messager.alert('提示', data[0].message, 'info');
			            	if(data[0].success==true){
			            		serach();
			            		$("#add_sfzsk_html").window("close");
			            	}
			            },
			        });
	        	  }else{
	        		  $.messager.alert('提示', '请填写备注', 'info');
	        	  }
	        	 }
		     }
	        //打开主要症状window
		    function zyzz_zsk_div_open(){
		    	if($("#bodyPartName").val()!=""){
				   $("#zyzz_zsk_div").panel('open');
		    	}else{
		    		$.messager.alert('提示', '请选择症状部位', 'info');
		    	}
		   }
		    //关闭主要症状window
		    function zyzz_zsk_div_close(){
				  $("#zyzz_zsk_div").panel('close');
				  }
		    //监听键盘按键
		    function keyDown(r){
		    	$("#zyzz_key_div").panel('open');
		    	$.ajax({
		            type: "post",
		            url: path+'/diagKnowledgeAction!findDiagnosisDict.action',
		            dataType : "json",
		            data:{"keyInfo":r.value+"%"},
		            success: function(data){
		            	$('#zyzz_key').datagrid({    
		            	   // url:'datagrid_data.json',    
		            	    columns:[[    
		            	        {field:'diagnosisCode',title:'',hidden:true},    
		            	        {field:'diagnosisName',title:'',width:210}    
		            	    ]],
		            	    onClickRow:function(index,row){
							    $("#diagName").val(row.diagnosisName);
							    $("#diagCode").val(row.diagnosisCode);
							    $("#zyzz_key_div").panel('close');
							},    
		            	}); 
		           $('#zyzz_key').datagrid('loadData', data[0].rows);
		           
		        }
		    });
		  }

		    function setpos() {
		    	var one = $("#diagName").offset();
		    	var one1 = $("#mainSymptom").offset();
		    	$("#zyzz_key_div").offset( {
		    		top : one.top + 20,
		    		left : one.left
		    	});
		    	$("#zyzz_zsk_div").offset( {
		    		top : one1.top + 20,
		    		left : one1.left
		    	});
		    }

//	    window.setInterval(checkOnkeydown, 1000);
//	    function checkOnkeydown(){
//	        if(document.activeElement.id!='diagName'){
//	        	$("#zyzz_key_div").panel('close');
//	        }
//	        if(document.activeElement.id!='mainSymptom'){
//	        	 $("#zyzz_zsk_div").panel('close');
//	        }
//	      
//	    }	    
		    function keyMove(e){
		  	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
		  	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
		  	  var odiv=document.getElementById('zyzz_key_div');
		  	  var left =odiv.getBoundingClientRect().left;
		  	  var top = odiv.getBoundingClientRect().top;
		  	
		  	  var rdiv=document.getElementById('zyzz_zsk_div');
		  	  var rleft =rdiv.getBoundingClientRect().left;
		  	  var rtop = rdiv.getBoundingClientRect().top;
		  	  //console.info($("#doctorconfast_div").panel('close'));
		  	  if(x<left||x>(left+220)){
		  		  $("#zyzz_key_div").panel('close');
		  	  }else if(y<(top-20)||y>(top+100)){
		    		//alert("上下");
		    		$("#zyzz_key_div").panel('close');
		  	  }
		  	  if(x<rleft||x>(rleft+260)){
		  		  $("#zyzz_zsk_div").panel('close');
		  	  }else if(y<(rtop-20)||y>(rtop+200)){
		  		  $("#zyzz_zsk_div").panel('close');
		  	  }
		  };		    
		    
		    

