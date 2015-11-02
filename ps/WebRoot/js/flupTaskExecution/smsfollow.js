$(function() {
$("#zyzd_div2").panel('close');
$("#confast_div_group").panel('close');
//验证信息类别==‘复诊提示’ ?
$('#smsstyle').combobox({    
	 onHidePanel:function(){
	 	var value = $('#smsstyle').combobox("getValue");
	 	if(value!='复诊提示'){
	 		//$('#sendDate').attr('disabled','disabled');
	 		$('#sendDate').datebox({disabled:true});
	 		$('#unitCodeName').attr('disabled',true);
	 		
	 	}else{
		 	$('#sendDate').datebox({disabled:false});
		 	$('#unitCodeName').attr('disabled',false);
	 	}
	 }
   });
$('#smsfast_div').panel('close');
	setpos();
	$("#confast_div").panel('close'); //短信内容div加载的时候隐藏
	 $.ajax({
         type: "post",
         dataType : "json",
         url: 'flupTaskAction!loadInfoCombobox.action',
         success: function(data){
        	 $('#flupWay').combobox({    
         	    valueField:'code',    
         	    textField:'name'   
         	});
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
            	    textField:'name'   
            	});
        	$('#flupWay').combobox('loadData', data[0].flupWay);
         	$('#flupWay').combobox('select', data[0].flupWay[0].code);
//         	$('#inDept').combobox('loadData', data[0].department);
//        	$('#inDept').combobox('select', data[0].department[0].deptCode);
        	$('#flupStatus').combobox('loadData', data[0].flupStatus);
         	$('#flupStatus').combobox('select', data[0].flupStatus[0].code);
        	serach();
         },
     });
     
   
     
     
     
     
     
     
     
     
     
	$('#blxx_list_tab').datagrid( {
			method:'get',
			pageSize : 10,
			pageList : [ 10, 20],
			idField : 'id',
		    title:'信息随访',
			collapsible : false,
			remoteSort : false,
			rownumbers : true,
			queryParams : '',
			singleSelect : false,
			pagination : true,
			width:'100%',
			hideColumn : [ [ {
			field : 'one3',
			title : '身份证号',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}] ],
		toolbar : [ {
			text : '',
			text : '发送',
			iconCls : 'icon-save',
			handler : function() {
								
				var sendDate = $("#sendDate").datebox("getValue");
				var diagName = $("#unitCodeName2").val();
				var infoType = $('#smsstyle').combobox("getValue");
				var rows = $('#blxx_list_tab').datagrid('getSelections');
				var smscontent = $('#smscontent').val();
				if(infoType=='复诊提示')
				{
					if(sendDate==null || sendDate==''){
						$.messager.alert('提示', '请选择复诊时间!', 'info');	
						return;
					}
					if(diagName==null || diagName==''){
						$.messager.alert('提示', '请选择复诊科室!', 'info');	
						return;
					}
				}else{
					sendDate = "" ;
					diagName = "";
				}
				if (smscontent == "") {
					$.messager.alert('提示', '发送内容不能为空!', 'info');
				} else if (rows == null || rows.length == 0) {
					$.messager.alert('提示', '请选择发送的对象!', 'info');
				} else {
					$.messager.confirm('提示', '您确定要发送吗?', function(r) {
									if (r) {
										var patiSerial2 = "";
										var inpatiNumber2 = "";
										var inpatiSerialNumber2 = "";
										var flupWay2 = "";
										var id = "";
										var mobilePhone="";
										for ( var i = 0; i < rows.length; i++) {
											patiSerial2 +=  i!=rows.length-1 ? rows[i].patiSerial+"," : rows[i].patiSerial;
											inpatiNumber2 +=  i!=rows.length-1 ? rows[i].inpatiNumber+"," : rows[i].inpatiNumber;
											inpatiSerialNumber2 +=  i!=rows.length-1 ? rows[i].inpatiSerialNumber+"," : rows[i].inpatiSerialNumber;
											flupWay2 +=  i!=rows.length-1 ? rows[i].flupWay+"," : rows[i].flupWay;
											id +=  i!=rows.length-1 ? rows[i].id+"," : rows[i].id;
											
											if(rows[i].flupMobile.length!=11){
												$.messager.alert("提示","("+rows[i].name+")不是有效的手机号码，请检查..","error");
												return;
											}else{
												mobilePhone +=  i!=rows.length-1 ? rows[i].flupMobile+"," : rows[i].flupMobile;
											}
										}
										$.post(
											path+'/flupTaskAction!sendMessger.action',
											{
												diagName : diagName,
												sendDate : sendDate,
												patiSerial : patiSerial2,
												inpatiNumber : inpatiNumber2,
												inpatiSerialNumber : inpatiSerialNumber2,
												smscontent : smscontent,
												infoType : infoType,
												flupWay : flupWay2,
												id : id,
												mobilephone:mobilePhone
											},
											function(data){
												if(data=='success'){
													$.messager.alert("提示","发送成功","info");
												//	window.location.reload();
													serach();
												}else{
													$.messager.alert("提示","发送失败","error");
												}
												
											},'text'
										);
									}
					});

				}
			}
		},"-",{
			text : '慢病类型',
			iconCls : 'icon-save',
			handler:function (){
				var rows = $('#blxx_list_tab').datagrid('getSelected');
				if (rows == null || rows.length == 0) {
					$.messager.alert('提示', '请选中需要调度的项!', 'info');
					return false;
				} else {
					$("#chronic_disease").window('open');
				}
					
			}
		} ],
		frozenColumns:[[ 
						{
					    field : 'ck',
					    checkbox : true
					  	} ,
					  	{
							field : 'outHospitalDate',
							title : '出院日期',
							width : 80,
							align : 'center',
						},
						 {
						field : 'patiSerial',
						title : '病人编号',
						width : 80,
						align : 'center'
					}, {
						field : 'inpatiNumber',
						title : '住院号',
					    width : 80,
						align : 'center',
					}, 
						 {
						field : 'inpatiSerialNumber',
						title : '住院流水号',
					    width : 80,
						align : 'center',
						hidden : true
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
						width : 160,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'diagGroupName',
						title : '病组名称',
						width : 160,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'diagGroupCode',
						title : '病组代码',
						width : 160,
						align : 'center',
						hidden:true
					},
					 {
						field : 'operateTime',
						title : '手术时间',
						width : 80,
						align : 'center',
						formatter:function(value,row,index){
							if(value==""){return '';}
						}
					}
					,
					{
						field : 'tangniaobing',
						title : '糖尿病',
						width : 80,
						align : 'center',
						formatter:function(value,row,index){
							if(value==undefined){return '++';}
						}
					},
					{
						field : 'xiezhi',
						title : '血脂异常',
						width : 80,
						align : 'center',
						formatter:function(value,row,index){
							if(value==undefined){return '+';}
						}
					},
					{
						field : 'nao',
						title : '脑 卒中',
						width : 80,
						align : 'center',
						formatter:function(value,row,index){
							if(value=="undefined"){return '+';}
						}
					},
					{
						field : 'guanxinbing',
						title : '冠心病',
						width : 80,
						align : 'center',
						formatter:function(value,row,index){
							if(value==""){return '';}
						}
					},
					{
						field : 'tia',
						title : 'TIA',
						width : 80,
						align : 'center',
						formatter:function(value,row,index){
							if(value==""){return '';}
						}
					},
					 {
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
					}
					,
					 {
						field : 'flupComplete',
						title : '发送状态',
						width : 70,
						align : 'center',
						formatter:function(value,row,index){
							return value=='0' ? '未发送' : '已发送';
						}
					}
					,{
						field : 'billingCode',
						title : '付费方式',
						width : 80,
						align : 'center',
					},
					{
						field : 'flupMobile',
						title : '随访电话',
						width : 80,
						align : 'center',
					}
					,{
						field : 'flupStatus',
						title : '随访状态',
						width : 70,
						align : 'center',
						formatter:function(value,row,index){
							if(value=='1'){return '随访期';}
							if(value=='2'){return '随访结束';}
							if(value=='3'){return '失访';}
							if(value=='4'){return '黑名单';}
							if(value=='5'){return '病故';}
						}
					}
					,{
						field : 'flupType',
						title : '随访分类',
						width : 60,
						align : 'center',
						formatter : function(value,row,index) {
							if(value=='1'){return '专科';}
							if(value=='2'){return '专病';}
						}
					},
					{
						field : 'deptName',
						title : '所属科室',
						width : 120,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},
					{
						field : 'chiefDoctor',
						title : '住院医生',
						width : 80,
						align : 'center',
					},
					{
						field : 'attendDoctor',
						title : '主治医生',
						width : 80,
						align : 'center',
					}
					,{
						field : 'flupPlanDate',
						title : '计划随访日期',
						width : 100,
						align : 'center',
					},{
						field : 'flupDoctorCode',
						title : '计划随访医生',
						width : 80,
						align : 'center',
					},
					{
						field : 'flupDate',
						title : '随访日期',
						width : 100,
						align : 'center',
					},{
						field : 'actualDoctorName',
						title : '随访医生',
						width : 80,
						align : 'center',
					}
					]], 
		onDblClickRow : function(index, rows) {
			parent.windowInfo(rows.patiSerial,rows.inpatiNumber,rows.inpatiSerialNumber,rows.billingCode,rows.billingCode,rows.flupWay
			,rows.flupType,rows.flupObject,rows.flupPeriod,rows.flupStatus,rows.flupPlanDate.substring(0,10).replace(/\-/g,"/")
			,rows.flupMobile,rows.id,rows.flupName,rows.flupTableNameId,rows.name,rows.flupDoctor
			);
		}
	});

	$('#outHospitalDateStart').val("");
	$('#outHospitalDateStart').click(function() {
		WdatePicker( {
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});

	$('#outHospitalDateEnd').val("");
	$('#outHospitalDateEnd').click(function() {
		WdatePicker( {
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});

	$('#flupDateStart').val("");
	$('#flupDateStart').click(function() {
		WdatePicker( {
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});

	$('#flupDateEnd').val("");
	$('#flupDateEnd').click(function() {
		WdatePicker( {
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});

});
function getNowFormatDate() {
	var day = new Date();
	var Year = 0;
	var Month = 0;
	var Day = 0;
	var CurrentDate = "";
	Year = day.getFullYear();// 支持IE和火狐浏览器.
	Month = day.getMonth() + 1;
	Day = day.getDate();
	CurrentDate += Year + "-";
	if (Month >= 10) {
		CurrentDate += Month;
	} else {
		CurrentDate += "0" + Month + "-";
	}
	if (Day >= 10) {
		CurrentDate += Day;
	} else {
		CurrentDate += "0" + Day;
	}
	return CurrentDate;
}
function keyDown(r){
    $("#confast_div").panel('open');
	$.ajax({
        type: "post",
        url: 'diagKnowledgeAction!findDiagnosisDict.action',
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

function serach(){
	 var type =$("#flupComplete").combobox("getValue");
		if(type=='0'){
			$("#btnsearch").linkbutton("enable"); //关闭--撤销黑名单
		}else {
			$("#btnsearch").linkbutton("disable"); //开启--加入黑名单
		}
		if($.trim($("#inHospDiag").val()).length==0){
	    	$("#diagCode").val("");
	    }
		if($.trim($("#diagName").val()).length==0){
	    	$("#gdiagCode").val("");
	    }
	$('#blxx_tab').datagrid('unselectAll');
	var flupWay = $("#flupWay").combobox("getValue")==''?'info':$("#flupWay").combobox("getValue");
	var param={'map.diagGroupCode':$("#gdiagCode").val(),'map.flupComplete':$("#flupComplete").combobox("getValue"),'map.patiSerial':"%"+$("#patiSerial").val()+"%",'map.inpatiNumber': "%"+$("#inpatiNumber").val()+"%",
			'map.name': "%"+$("#name").val()+"%",'map.outHospDiag': "%"+$("#diagCode").val()+"%",
			'map.inDept': "%"+$("#inDept").combogrid("getValue")+"%",'map.flupWay': "%"+flupWay+"%",
			'map.outHospitalDateStart': $("#outHospitalDateStart").val(),'map.outHospitalDateEnd': $("#outHospitalDateEnd").val()
			,'map.flupDateStart': $("#flupDateStart").val(),'map.flupDateEnd': $("#flupDateEnd").val()
			,'map.Yesterday': "",'map.Today': "",'map.Tomorrow': "",'map.flupStatus':$("#flupStatus").combobox("getValue")	};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function serachYesterday(){
	$('#blxx_tab').datagrid('unselectAll');
	var param={'map.flupComplete':$("#flupComplete").combobox("getValue"),'map.Yesterday': "Yesterday",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept': "",'map.flupWay': "",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Today': "",'map.Tomorrow': "",'map.flupStatus': "1"	};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function serachToday(){
	$('#blxx_tab').datagrid('unselectAll');
	var param={'map.flupComplete':$("#flupComplete").combobox("getValue"),'map.Today': "Today",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept': "",'map.flupWay': "",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Yesterday': "",'map.Tomorrow': "",'map.flupStatus': "1"	};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}
function serachTomorrow(){
	$('#blxx_tab').datagrid('unselectAll');
	var param={'map.flupComplete':$("#flupComplete").combobox("getValue"),'map.Tomorrow': "Tomorrow",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept': "",'map.flupWay': "",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Yesterday': "",'map.Today': "",'map.flupStatus': "1"};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function setpos() {
	var one = $("#inHospDiag").offset();
	var one2 = $("#unitCodeName").offset();
	$("#confast_div").offset( {
		top : one.top + 20,
		left : one.left
	});
	$("#zyzd_div2").offset( {
		top : one2.top + 20,
		left : one2.left
	});
	
	var one1 = $("#diagName").offset();
	$("#confast_div_group").offset( {
		top : one1.top + 20,
		left : one1.left
	});
	
}

	    
//双击短信内容
function opfast() {
$('#smsfast_div').panel('open');
	     //加载短信内容
				$.ajax({
			        type: "post",
			        url: path+'/flupTaskAction!loadInfoContent.action',
			        dataType : "json",
			        data : {'smsstyle' : $('#smsstyle').combobox('getValue')},
			        success: function(data){
			        	$('#smsfast_tab').datagrid({    
			        	    columns:[[    
			        	        {field:'infoName'},    
			        	        {field:'infoContent',width:300}
			        	        
			        	    ]],
			        	    singleSelect : true,
			        	    onClickRow:function(index,row){
							    $("#smscontent").val(row.infoContent);
							    $("#smsfast_div").panel('close');
							},    
			        	}); 
			       $('#smsfast_tab').datagrid('loadData', data[0].rows);
			      // $('#smsfast_div').panel('close');
			    }
			});
			
	


			
}
  
//监听键盘按键
function keyDown2(r){
    $("#zyzd_div2").panel('open');
	$.ajax({
        type: "post",
        url: path+'/flupTaskAction!loadCodeName.action',
        dataType : "json",
        data:{"map.diagName":r.value,"map.diagCode":$('#unitCode').combobox("getValue")},
        success: function(data){
        	$('#zyzd_tab2').datagrid({    
        	    columns:[[    
        	        {field:'deptCode',title:'',hidden:true},    
        	        {field:'deptName',title:'',width:200}
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#unitCodeName").val(row.deptName);
				    $("#unitCodeName2").val(row.deptCode);
				    $("#zyzd_div2").panel('close');
				},    
        	}); 
       $('#zyzd_tab2').datagrid('loadData', data[0].rows);
    }
});
}

//监听键盘按键
function keyDownGroup(r){
    $("#confast_div_group").panel('open');
	$.ajax({
        type: "post",
        url: 'diagGroupAction!findDiagnosisDict.action',
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#confast_tab_group').datagrid({    
        	   // url:'datagrid_data.json',    
        	    columns:[[    
        	        {field:'diagnosisCode',title:'',hidden:true},    
        	        {field:'diagnosisName',title:'',width:210}
        	        
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#diagName").val(row.diagnosisName);
				    $("#gdiagCode").val(row.diagnosisCode);
				    $("#confast_div_group").panel('close');
				},    
        	}); 
       $('#confast_tab_group').datagrid('loadData', data[0].rows);
    }
});
}


function keyMove(e){
	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
	  var odiv=document.getElementById('confast_div');
	  var left =odiv.getBoundingClientRect().left;
	  var top = odiv.getBoundingClientRect().top;
	  
	  var odiv1=document.getElementById('confast_div_group');
	  var left1 =odiv1.getBoundingClientRect().left;
	  var top1 = odiv1.getBoundingClientRect().top;
	  
	  var odiv2=document.getElementById('zyzd_div2');
	  var left2 =odiv2.getBoundingClientRect().left;
	  var top2 = odiv2.getBoundingClientRect().top;
	  
	  var odiv3=document.getElementById('smsfast_div');
	  var left3 =odiv3.getBoundingClientRect().left;
	  var top3 = odiv3.getBoundingClientRect().top;
	  
	  //console.info($("#doctorconfast_div").panel('close'));
	  if(x<left||x>(left+220)){
		  $("#confast_div").panel('close');
	  }else if(y<(top-20)||y>(top+100)){
		//alert("上下");
		$("#confast_div").panel('close');
	  }
	  if(x<left1||x>(left1+220)){
		  $("#confast_div_group").panel('close');
	  }else if(y<(top1-20)||y>(top1+100)){
		//alert("上下");
		 $("#confast_div_group").panel('close');
	  }
	  if(x<left2||x>(left2+220)){
		  $("#zyzd_div2").panel('close');
	  }else if(y<(top2-20)||y>(top2+100)){
		//alert("上下");
		 $("#zyzd_div2").panel('close');
	  }
	  if(x<left3||x>(left3+220)){
		  $("#smsfast_div").panel('close');
	  }else if(y<(top3-20)||y>(top3+100)){
		//alert("上下");
		 $("#smsfast_div").panel('close');
	  }
};

//window.setInterval(checkOnkeydown, 1000);
//function checkOnkeydown(){
//    if(document.activeElement.id!='inHospDiag'){
//    	 $("#confast_div").panel('close');
//    }
//    if(document.activeElement.id!='unitCodeName'){
//    	 $("#zyzd_div2").panel('close');
//    }
//    if(document.activeElement.id!='smscontent'){
//   	 $("#smsfast_div").panel('close');
//   }
//    if(document.activeElement.id!='diagName'){
//      	 $("#confast_div_group").panel('close');
//      }
//}