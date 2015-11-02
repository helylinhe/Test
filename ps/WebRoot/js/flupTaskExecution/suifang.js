var planNum = 0;
var planSize = 0;
//随访历史记录数据
$(function(){
	 setpos();
	 $("#confast_div").panel('close');
	 $("#sfzskwh_sfb_div").panel('close');
	 $("#add_sfzsk_html").window('close');
	 $.ajax({
         type: "post",
         dataType : "json",
         url: 'flupTaskAction!loadCombobox.action',
         success: function(data){
        	 $('#flupWay').combobox({    
         	    valueField:'code',    
         	    textField:'name',
         	    data:data[0].flupWay
         	});
        	 $('#flupWay').combobox('select', data[0].flupWay[0].code);
        	 $('#inDept').combogrid({    
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
	       	$('#flupStatus').combobox({    
	      	    valueField:'code',    
	      	    textField:'name' ,
	      	    data:data[0].flupStatus
	      	});
	       	$('#flupStatus').combobox('select', data[0].flupStatus[0].code);
        	$('#wflupStatus').combobox({    
	      	    valueField:'code',    
	      	    textField:'name',
	      	    data:data[0].wflupStatus
	      	});
	       	$('#wflupStatus').combobox('select', data[0].wflupStatus[0].code);
	       	$('#wflupWay').combobox({    
	      	    valueField:'code',    
	      	    textField:'name',
	      	    data:data[0].wflupWay	
	      	});
        	$('#wflupWay').combobox('select', data[0].wflupWay[0].code);
	       	$('#flupType').combobox({    
	      	    valueField:'code',    
	      	    textField:'name'   
	      	});
	    	$('#flupObject').combobox({    
	      	    valueField:'code',    
	      	    textField:'name' ,
	      	    onHidePanel: function(){
	      	    	var rows = $('#blxx_tab').datagrid('getSelected');  
	      	    	$.ajax({
	      	    	  type: "post",
	      	          dataType : "json",
	      	          url: 'flupTaskAction!getPhoneByType.action',
	      	          data:{"phone.type":$('#flupObject').combobox("getValue"),"phone.inpatiNumber":rows.inpatiNumber,"phone.patiSerial":rows.patiSerial} ,
	      	          success: function(data){
	      	        	 if(data[0].phone[0].type==""){
		      	        	 $('#sflupMobile').combobox({
		      	        	   editable :true
		      	        	 });
		      	        	 }else{
		      	        		$('#sflupMobile').combobox({    
			      		      	    valueField:'type',    
			      		      	    textField:'mobileNumber',
			      		      	    data:data[0].phone,
			      		      	    editable :false
			      		      	});
			      	        	$('#sflupMobile').combobox('select', data[0].phone[0].type);
		      	        	 }
	      	          }
	      	    	});
	      	  }
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
              	    	
              	    	/****
              	    	 * 异步加载随访表的方式
              	    	 * @return {TypeName} 
              	    	 */
              	    	$.post(path+'/flupTaskAction!loadFlupNameType.action',{"map.flupNameId":row.flupNameId},function (d){
              	    		
              	    			$("#flupWayName").attr("rel",d);
              	    			if($.trim(d)=="1"){
              	    				$("#flupWayName").val("专病");
              	    			}else if($.trim(d)=="2"){
              	    				$("#flupWayName").val("专科");
              	    			}else{
              	    				$("#flupWayName").val("专病细类");
              	    			}
              	    	},'json');
              	    	
      				} 
        	});     	
        	$('#flupWay').combobox('loadData', data[0].flupWay);
         	//$('#inDept').combobox('loadData', data[0].department);
         	$('#flupStatus').combobox('loadData', data[0].flupStatus);
        	$('#flupType').combobox('loadData', data[0].flupType);
        	$('#flupType').combobox('select', data[0].flupType[0].code);
        	$('#flupObject').combobox('loadData', data[0].flupObject);
        	$('#flupObject').combobox('select', data[0].flupObject[0].code);
        	 serach();
         }
});
   $('#blxx_tab').datagrid( {
					method:'get',
					collapsible : false,
					remoteSort : false,
					idField : 'id',
					rownumbers : true,
					queryParams : '',
					singleSelect : true,
				    title:'病例信息',
					pagination : true,
					width:'100%',
					pageSize:10,
                    pageList:[10,20],
                    toolbar: [
							'-',{    text:'属性修改',
								     iconCls:'icon-edit',
									 handler:function() {
											var rows = $('#blxx_tab').datagrid('getSelections');
											if (rows == null || rows.length == 0) {
												$.messager.alert('提示', '请选中需要修改的项!', 'info');
												return false;
											} else {
												if(rows.length>1){
													$.messager.alert('提示', '请选中一项在进行修改!', 'info');
												}else{
													/****
													 * 设置隐藏值
													 * @param {Object} data
													 */
													$("#hiddenPatiSerial").val(rows[0].patiSerial);
													$("#edit_suifang_html").panel('open');
													$("#sbillingCode").val(rows[0].billingCode);
													$("#hbillingCode").val(rows[0].billingCode);
													$('#wflupWay').combobox('setValue',rows[0].flupWay);
													//$("#flupType").combobox('setValue',rows[0].flupType);
													$("#flupWayName").attr("rel",rows[0].flupType);
													var typeValue; 
													if(rows[0].flupType=="1"){
														typeValue="专科"
													}else if(rows[0].flupType=="2"){
														typeValue="专病"
													}else{
														typeValue="专病细类"
													}
													$("#flupWayName").val(typeValue);
													$("#flupObject").combobox('setValue',rows[0].flupObject);
													$("#wflupStatus").combobox('setValue',rows[0].flupStatus);
													$('#flupPlanDate').datebox('setValue', rows[0].flupPlanDate.substring(0,10).replace(/\-/g,"/"));	// 设置日期输入框的值
													$("#flupMobile").val(rows[0].flupMobile);
													$("#id").val(rows[0].id);
													$("#flupDoctorCode").combobox("setValue",rows[0].flupDoctor);
													$('#flupNameId').val(rows[0].flupTableNameId);
													$('#flupName').combogrid("setValue",rows[0].flupName);
									      	    	$.ajax({
									      	    	  type: "post",
									      	          dataType : "json",
									      	          url: path+'/flupTaskAction!getPhoneByType.action',
									      	          data:{"phone.type":rows[0].flupObject,"phone.inpatiNumber":rows[0].inpatiNumber,"phone.patiSerial":rows[0].patiSerial} ,
									      	          success: function(data){
									      	        	 if(data[0].phone[0].type==""){
									      	        	 $('#sflupMobile').combobox({
									      	        	   editable :true
									      	        	 });
									      	        	 }else{
									      	        	$('#sflupMobile').combobox({    
									      		      	    valueField:'type',    
									      		      	    textField:'mobileNumber',
									      		      	    data:data[0].phone,
									      		      	    editable :true
									      		      	});
									      	        	$('#sflupMobile').combobox('select', data[0].phone[0].type);
									      	        	 }
									      	          }
									      	    	});
												}
											}
										}
						},'-',{text:'计划调整',
						     iconCls:'icon-edit',
							 handler:function() {
								 var rows = $('#blxx_tab').datagrid('getSelections');
									if (rows == null || rows.length == 0) {
										$.messager.alert('提示', '请选中需要修改的项!', 'info');
										return false;
									} else {
										if(rows.length>1){
											$.messager.alert('提示', '请选中一项在进行修改!', 'info');
										}else{
											 
											 $.ajax({
											        type: "post",
											        url: path+'/flupTaskAction!findPlan.action',
											        dataType : "json",
											        data:{'flupTask.inpatiSerialNumber':rows[0].inpatiSerialNumber,'flupTask.inpatiNumber': rows[0].inpatiNumber,},
											        success: function(data){
											        	if(data[0].plan.length>0){
											        		$("#add_sfzsk_data").window('open');
											        		var text = "";
												        	var hidden ="";
												        	var str = "num";
												        	$("#num").val(data[0].plan.length);
												        	$.each(data[0].plan, function(i, n){
												        		text += "第"+(n.flupTimes)+"次随访时间:<select style='width:120px; border: 1px solid #999;margin-top: 3px' class='easyui-datebox'  id ='"+(i+1)+"'></select></br>" ;
												        		hidden +="<input type='hidden' id ='"+(str+(i+1))+"' />";
												        	});
												        	$("#flupCycleinfo").html(text+hidden);
												        	$("#rad1").attr("checked",true);
												        	$.each(data[0].plan, function(i, n){
												        		if(n.taskOpen==1){
												        			$('#'+(i+1)).datebox({"disabled":true});  
												        		}else{
												        			$('#'+(i+1)).datebox({});  
												        		}
												        		$('#'+(i+1)).datebox("setValue",n.flupPlanDate.substring(0, 10));
												        		$('#'+(str+(i+1))).val(n.flupTimes);
												        	});
											        	}else{
											        		$("#add_sfzsk_plan").window('open');
											        	}
											        }
											    }); 
											
											}
										}	 
						    }
				        }
			        ],
			        frozenColumns:[[ 
									{
								    field : 'ck',
								    checkbox : true
								  	} ,
								  	{
										field : 'outHospitalDate',
										title : '出院日期',
										width : 100,
										align : 'center',
									},
									 {
									field : 'patiSerial',
									title : '病人编号',
									width : 100,
									align : 'center'
								}, {
									field : 'inpatiNumber',
									title : '住院号',
								    width : 80,
									align : 'center',
								}, 
									
								{
									field : 'name',
									title : '姓名',
								    width : 80,
									align : 'center',
								}
								]],
								columns : [ [ {
									field : 'gender',
									title : '性别',
								    width : 40,
									align : 'center',
									formatter:function(value,row,index){
										if(value=="1"){return '男';}
										if(value=="2"){return '女';}
									}
								}
								, {
									field : 'age',
									title : '年龄',
								    width : 40,
									align : 'center',
									formatter : function(val, rec) {
										return val;
									}
								},{
									field : 'outHospitalDiag',
									title : '出院诊断',
									width : 180,
									align : 'center',
									formatter : function(val, rec) {
										return val;
									}
								},
								 {
									field : 'operateTime',
									title : '手术时间',
									width : 100,
									align : 'center',
								},{
									field : 'billingCode',
									title : '付费方式',
									width : 80,
									align : 'center',
								},
								{
									field : 'chiefDoctor',
									title : '主任医生',
									width : 80,
									align : 'center',
								},
								{
									field : 'attendDoctor',
									title : '主治医生',
									width : 80,
									align : 'center',
								}
								,
								{
									field : 'flupWay',
									title : '随访方式',
									width : 70,
									align : 'center',
									formatter : function(value,row,index) {
										if(value=='1'){return '电话';}
										if(value=='2'){return '短信';}
										if(value=='3'){return '微信';}
										if(value=='4'){return '门诊';}
										if(value=='5'){return '上门';}
									}
								},
								{
									field : 'flupMobile',
									title : '随访电话',
									width : 120,
									align : 'center',
								},{
									field : 'flupStatus',
									title : '随访状态',
									width : 80,
									align : 'center',
									formatter:function(value,row,index){
										if(value=='1'){return '随访期';}
										if(value=='2'){return '随访结束';}
										if(value=='3'){return '失访';}
										if(value=='4'){return '黑名单';}
										if(value=='5'){return '病故';}
									}
								},{
									field : 'flupType',
									title : '随访分类',
									width : 70,
									align : 'center',
									formatter : function(value,row,index) {
										if(value=='1'){return '专科';}
										if(value=='2'){return '专病';}
									}
								},{
									field : 'deptName',
									title : '所属科室',
									width : 120,
									align : 'center',
									formatter : function(val, rec) {
										return val;
									}
								}
//								,
//								{
//									field : 'flupPlanDate',
//									title : '计划随访日期',
//									width : 90,
//									align : 'center',
//								},{
//									field : 'flupDoctorCode',
//									title : '计划随访医生',
//									width : 80,
//									align : 'center',
//								},
//								{
//									field : 'flupDate',
//									title : '随访日期',
//									width : 90,
//									align : 'center',
//								},{
//									field : 'actualDoctorName',
//									title : '随访医生',
//									width : 80,
//									align : 'center',
//								},{
//									field : 'option',
//									title : '操作',
//									width : 100,
//									align : 'center',
//									formatter : function(value,row,index) {
//										return "<a onclick='serachInfo()' style='color: red;'>随访记录</a>";
//									}
//								}
								]], 
						onClickRow:function()
									{
									},
//								 onDblClickRow: function (index, row) {
//									 $("#suifanggginfo").window('open');
//									 $('#sflsjl_tab').datagrid('unselectAll');
//									 $.ajax({
//									        type: "post",
//									        url: 'flupTaskAction!findFlupTaskInfo.action',
//									        dataType : "json",
//									        data:{"flupTask.inpatiNumber":row.inpatiNumber,"flupTask.inpatiSerialNumber":row.inpatiSerialNumber},
//									        success: function(data){
//									        	 $('#sflsjl_tab').datagrid('loadData', data[0].rows);
//									        },
//									    });		 
//                             }
					 
       });      
	 $('#sflsjl_tab').datagrid( {
					method:'get',
					collapsible : false,
					remoteSort : false,
					idField : 'id',
					rownumbers : true,
					queryParams : '',
					title:'随访记录',
					singleSelect : false,
					frozenColumns:[[
						{
							field : 'name',
							title : '姓名',
							width : 80,
							align : 'center',
						},
						{
						field : 'patiSerial',
						title : '病人编号',
						width : 100,
						align : 'center',
					}, {
						field : 'flupDate',
						title : '随访日期',
					    width : 80,
						align : 'center',
					}
					]],
					columns : [[ {
						field : 'flupWay',
						title : '随访方式',
					    width : 80,
						align : 'center',
						formatter : function(value,row,index) {
							if(value=='1'){return '电话';}
							if(value=='2'){return '短信';}
							if(value=='3'){return '微信';}
							if(value=='4'){return '门诊';}
							if(value=='5'){return '上门';}
						}
					}
					, {
						field : 'flupPeriod',
						title : '随访周期',
					    width : 80,
						align : 'center',
					}, {
						field : 'flupType',
						title : '随访类型',
						width : 80,
						align : 'center',
						formatter : function(value,row,index) {
							if(value=='1'){return '专科';}
							if(value=='2'){return '专病';}
						}
					},{
						field : 'actualDoctorName',
						title : '随访医生',
						width : 80,
						align : 'center',
					},{
						field : 'flupEvaluate',
						title : '随访评价',
						width : 140,
						align : 'center',
					}
					]],
       });               		
	$('#div_toolbar').appendTo('.datagrid-toolbar');
	  $('#setdate').click(function(){
			WdatePicker({
			  minDate: '{%y-5}-%M-%d',
			  readOnly: true
			});
	  });
 });
function serach(){
	 if($.trim($("#inHospDiag").val()).length==0){
	    	$("#diagCode").val("");
	    }
	$('#blxx_tab').datagrid('unselectAll');
	var param={'map.patiSerial':$("#patiSerial").val(),'map.inpatiNumber':$("#inpatiNumber").val(),
			'map.name': $("#name").val(),'map.outHospDiag': $("#diagCode").val(),
			'map.deptCode': $("#inDept").combogrid("getValue"),'map.flupStatus': $("#flupStatus").combobox("getValue"),
			'map.flupWay': "%"+$("#flupWay").combobox("getValue")+"%",'map.Yesterday': "",'map.Today': "",'map.Tomorrow': ""};
	 loadData('flupTaskAction!loadPlanDatagrid.action','blxx_tab',param);
}

function keyDown(r){
    $("#confast_div").panel('open');
	$.ajax({
        type: "post",
        url: path+'/diagKnowledgeAction!findDiagnosisDict.action',
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#confast_tab').datagrid({    
        	    columns:[[    
        	        {field:'diagnosisCode',title:'',hidden:true},    
        	        {field:'diagnosisName',title:'',width:200}
        	        
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#inHospDiag").val(row.diagnosisName);
				    $("#diagCode").val(row.diagnosisCode);
				    $("#confast_div").panel('close');
				},    
        	}); 
       $('#confast_tab').datagrid('loadData', data[0].rows);
    }
});
}
//属性修改保存
function submit(){
	if(isNaN($("#sflupMobile").combobox("getText"))){
		$.messager.alert('提示', '请填写正确的电话号码！', 'info');
		return;
		}
	if($("#wflupStatus").combobox("getValue")=='4'){
		$("#add_sfzsk_html").window('open');
		return;
	}
	if($("#wflupStatus").combobox("getValue")==''||$("#wflupWay").combobox("getValue")==''
		||$("#flupObject").combobox("getValue")==''){
		$.messager.alert('提示', '请讲上面信息填写完整！', 'info');
		return;
	}
	var rows = $('#blxx_tab').datagrid('getSelections');
	$.ajax({
        type: "post",
        url: path+'/flupTaskAction!updatePlanRuleTask.action',
        dataType : "json",
        data:{"flupTask.addReasons":$("#addReasons").val(),
        	"flupTask.flupStatus":$("#wflupStatus").combobox('getValue'),
        	"flupTask.flupWay":$("#wflupWay").combobox('getValue'),
        	"flupTask.flupType":$("#flupWayName").attr("rel"),
        	"flupTask.flupObject":$("#flupObject").combobox('getValue'),
        	"flupTask.flupMobile":$("#sflupMobile").combobox("getText"),
        	"flupTask.inpatiNumber":rows[0].inpatiNumber,
        	"flupTask.inpatiSerialNumber":rows[0].inpatiSerialNumber,
        	"flupTask.flupTableNameId":$("#flupNameId").val(),
        	"flupTask.patiSerial":$("#hiddenPatiSerial").val()
        	  },
        success: function(data){
        	$.messager.alert('提示', data[0].message, 'info');
        		edit_suifang_winclose();
        		serach();
        },
    });
  }
//终止随访原因保存事件
function updateAuditsState(){
	if(isNaN($("#sflupMobile").combobox("getText"))){
		$.messager.alert('提示', '请填写正确的电话号码！', 'info');
		return;
		}
	if($("#addReasons").validatebox("isValid")){
		$("#add_sfzsk_html").window('close');
		
		var rows = $('#blxx_tab').datagrid('getSelections');
		
		if($("#wflupStatus").combobox("getValue")==''||$("#wflupWay").combobox("getValue")==''||$("#flupType").combobox("getValue")==''
			||$("#flupObject").combobox("getValue")==''){
			$.messager.alert('提示', '请讲上面信息填写完整！', 'info');
			return;
		}
			$.ajax({
		        type: "post",
		        url: path+'/flupTaskAction!updateFlupTask2.action',
		        dataType : "json",
		        data:{"flupTask.addReasons":$("#addReasons").val(),
		        	"flupTask.flupStatus":$("#wflupStatus").combobox('getValue'),
		        	"flupTask.flupWay":$("#wflupWay").combobox('getValue'),
		        	"flupTask.flupType":$("#flupType").combobox('getValue'),
		        	"flupTask.flupObject":$("#flupObject").combobox('getValue'),
		        	"flupTask.flupMobile":$("#sflupMobile").combobox("getText"),
		        	"flupTask.inpatiNumber":rows[0].inpatiNumber,
		        	"flupTask.inpatiSerialNumber":rows[0].inpatiSerialNumber,
		        	"flupTask.patiSerial":rows[0].patiSerial,
		        	"flupTask.flupTableNameId":$("#flupName").combogrid("getValue")},
		        success: function(data){
		        	$.messager.alert('提示', data[0].message, 'info');
		        	$("#addReasons").val('');
		        	if(data[0].success){
		        		edit_suifang_winclose();
		        		serach();
		        	}
		        },
		    });
	}
}

function opfastTable() {
	$('#sfzskwh_sfb_div').panel('open');
}

function setpos() {
	var one = $("#inHospDiag").offset();
//	var one1 = $("#flupName").offset();
	$("#confast_div").offset( {
		top : one.top + 20,
		left : one.left
	});
//	$("#sfzskwh_sfb_div").offset( {
//		top : one1.top + 130,
//		left : one1.left
//	});
}


function keyMove(e){
	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
	  var odiv=document.getElementById('confast_div');
	  var left =odiv.getBoundingClientRect().left;
	  var top = odiv.getBoundingClientRect().top;
	
	  var rdiv=document.getElementById('sfzskwh_sfb_div');
	  var rleft =rdiv.getBoundingClientRect().left;
	  var rtop = rdiv.getBoundingClientRect().top;
	  //console.info($("#doctorconfast_div").panel('close'));
	  if(x<left||x>(left+210)){
		  $("#confast_div").panel('close');
	  }else if(y<(top-20)||y>(top+100)){
  		//alert("上下");
  		$("#confast_div").panel('close');
	  }
	  if(x<rleft||x>(rleft+190)){
		  $("#sfzskwh_sfb_div").panel('close');
	  }else if(y<(rtop-20)||y>(rtop+100)){
		  $("#sfzskwh_sfb_div").panel('close');
	  }
};

//继续随访下页面保存事件
function saveNum(){
	
	if($("#rad1").attr("checked")!='checked'){
		$("#add_sfzsk_Info").window("open");
		return;
	}
	
	var arr = $("#num").val();
	var date = "";
	var num = "";
	var str = "num";
	for ( var i = 0; i < arr; i++) {
		date += $('#'+(i+1)).datebox("getValue") +",";
		num += $('#'+(str+(i+1))).val() +",";
	}
	var rows = $('#blxx_tab').datagrid('getSelections');
	$.ajax({
        type: "post",
        url: path+'/flupTaskAction!updatePlan.action',
        dataType : "json",
        data:{'flupTask.inpatiSerialNumber':rows[0].inpatiSerialNumber,'flupTask.inpatiNumber': rows[0].inpatiNumber,
        	'flupTask.flupTimes':num,'flupTask.flupPlanDate': date
        	},
        success: function(data){
        	$.messager.alert('提示', data[0].message, 'info');
        	$('#add_sfzsk_data').window('close');
        	$("#flupCycleinfo").html("");
        },
    });
	
}


//终止原因保存
function savePlan(){
	var rows = $('#blxx_tab').datagrid('getSelections');
	$.ajax({
        type: "post",
        url: path+'/flupTaskAction!stopPlan.action',
        dataType : "json",
        data:{'flupTask.inpatiSerialNumber':rows[0].inpatiSerialNumber,'flupTask.inpatiNumber': rows[0].inpatiNumber
        	,'flupTask.flupName': $("#MessageInfo").val()
        },
        success: function(data){
        	$.messager.alert('提示', data[0].message, 'info');
        	$('#add_sfzsk_data').window('close');
        	$("#flupCycleinfo").html("");
        	$('#add_sfzsk_Info').window('close')
        },
    });
}

function radio_click(obj){
	var arr = $("#num").val();
	if(obj.value=="2"){
	for (var i = 0; i < arr; i++) {
		$('#'+(i+1)).datebox({    
			disabled:true   
		});  
	}
	}else{
		for (var i = 0; i < arr; i++) {
			$('#'+(i+1)).datebox({    
				disabled:false   
			});  
		}
	}
	
}

function addNum(){
	var rows = $('#blxx_tab').datagrid('getSelections');
	planNum++;
	var str = "plan";
	var times ="";
	var date ="";
	 $.ajax({
	        type: "post",
	        url: path+'/flupTaskAction!findPlan2.action',
	        dataType : "json",
	        data:{'flupTask.inpatiSerialNumber':rows[0].inpatiSerialNumber,'flupTask.inpatiNumber': rows[0].inpatiNumber,},
	        success: function(data){
	         var aaaa = data[0].plan.length;
	         
	         planSize = data[0].plan.length;
	        	for ( var i = 0; i < (planNum-1); i++) {
	        		times += (planSize+(i+1)) + ",";
	        	}
	        	for ( var i = 0; i < (planNum-1); i++) {
	        		date += $("#"+(planSize+(i+1))).datebox("getValue") + ",";
	        	}
	        	var text ="";
	        	var hidden = "";
	        	for ( var i = 0; i < planNum; i++) {
	        		text += "第"+(planSize+(i+1))+"次随访时间:<select style='width:120px; border: 1px solid #999;margin-top: 3px' class='easyui-datebox'  id ='"+(planSize+(i+1))+"'></select></br>" ;
	        		hidden +="<input type='hidden' id ='"+(str+(planSize+(i+1)))+"' />";
	        	}
	        	$("#planInfo").html(text+hidden);
	        	for ( var i = 0; i < planNum; i++) {
	        		$('#'+(planSize+(i+1))).datebox({    
	        		});  
	        	}
	        	var days= new Array();
	        	days = date.split(",");
	        	var texts= new Array();
	        	texts = times.split(",");
	        	for ( var i = 0; i < days.length; i++) {
	        		$("#"+(planSize+(i+1))).datebox('setValue',days[i]) ;
	        	}
	        	for ( var i = 0; i < texts.length; i++) {
	        		$("#"+(str+(planSize+(i+1)))).val(texts[i]) ;
	        	}
	        }
	 });
	
}


function deleteNum(){
	var rows = $('#blxx_tab').datagrid('getSelections');
	planNum--;
	var str = "plan";
	var times ="";
	var date ="";
	 $.ajax({
	        type: "post",
	        url: path+'/flupTaskAction!findPlan2.action',
	        dataType : "json",
	        data:{'flupTask.inpatiSerialNumber':rows[0].inpatiSerialNumber,'flupTask.inpatiNumber': rows[0].inpatiNumber,},
	        success: function(data){
	        	planSize = data[0].plan.length;
	        	var text ="";
	        	var hidden = "";
	        	for ( var i = 0; i < planNum; i++) {
	        		text += "第"+(planSize+(i+1))+"次随访时间:<select style='width:120px; border: 1px solid #999;margin-top: 3px' class='easyui-datebox'  id ='"+(planSize+(i+1))+"'></select></br>" ;
	        		hidden +="<input type='hidden' id ='"+(str+(planSize+(i+1)))+"' />";
	        	}
	        	
	        	for ( var i = 0; i < planNum; i++) {
	        		date += $("#"+(planSize+(i+1))).datebox("getValue") + ",";
	        	}
	        	
	        	$("#planInfo").html(text+hidden);
	        	for ( var i = 0; i < planNum; i++) {
	        		$('#'+(planSize+(i+1))).datebox({    
	        		});  
	        		$("#"+(str+(planSize+(i+1)))).val((planSize+(i+1))) ;
	        	}
	        	
	        	for ( var i = 0; i < planNum; i++) {
	        		times += $("#"+(str+(planSize+(i+1)))).val() + ",";
	        	}
	        	 $("#hplantimes").val(times);
	        	 $("#hplanDate").val(date);
	        	var days= new Array();
	        	days = date.split(",");
	        	var texts= new Array();
	        	texts = times.split(",");
	        	for ( var i = 0; i < days.length; i++) {
	        		$("#"+(planSize+(i+1))).datebox('setValue',days[i]) ;
	        	}
	        	for ( var i = 0; i < texts.length; i++) {
	        		$("#"+(str+(planSize+(i+1)))).val(texts[i]) ;
	        	}
	        }
	 });
	
}

function saveNewPlan(){
	var rows = $('#blxx_tab').datagrid('getSelections');
	var str = "plan";
	var date ="";
	var time = "";
	for ( var i = 0; i < planNum; i++) {
		date += $("#"+(planSize+(i+1))).datebox("getValue") + ",";
		time +=$("#"+(str+(planSize+(i+1)))).val()+"," ;
	}
	var arr = new Array();
	arr = date.split(",");
	var myDate = new Date();
	var day = 0;
	myDate.toLocaleDateString(); 
	var mytime="";
	var month = 0;
	for ( var i = 0; i < (arr.length-1); i++) {
		if(myDate.getMonth()<9){
			month ="0"+(myDate.getMonth()+1);
		}
		if(myDate.getMonth() == 9){
			month =(myDate.getMonth()+1);
		}
		if(myDate.getDate()<10){
			day = "0" + myDate.getDate();
		}
		var mytime = myDate.getFullYear()+"-"+ month +"-"+ day;
		if(arr[i]!=''&&arr[i].replace(/\-/g,"")>mytime.replace(/\-/g,"")){
		}else{
		 	$.messager.alert('提示', "请填写今天之后的日期", 'info');
		 	return;
		}
		
	}
	$.ajax({
        type: "post",
        url: path+'/flupTaskAction!SavePlan.action',
        dataType : "json",
        data:{'flupTask.inpatiSerialNumber':rows[0].inpatiSerialNumber,
        	'flupTask.inpatiNumber': rows[0].inpatiNumber,
        	'flupTask.patiSerial': rows[0].patiSerial,
        	'flupTask.name': rows[0].name,
        	'flupTask.deptCode': rows[0].deptCode,
        	'flupTask.unitCode': rows[0].unitCode,
        	'flupTask.returnDate': date,
        	'flupTask.returnDeptCode': time,
        },
        success: function(data){
        	$.messager.alert('提示', data[0].message, 'info');
        	$('#add_sfzsk_plan').window('close');
        	$("#planInfo").html("");
        	planNum = 0;
        },
    });
}

