$(function() {
	setpos();
	$("#confast_div").panel('close');
	$("#confast_div_group").panel('close');
	 $.ajax({
         type: "post",
         dataType : "json",
         url: 'flupTaskAction!loadDoctorCombobox.action',
         success: function(data){
        	 $('#flupWay').combobox({    
         	    valueField:'code',    
         	    textField:'name'  ,
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
         	$('#flupStatus').combobox('loadData', data[0].flupStatus);
         	$('#flupStatus').combobox('select', data[0].flupStatus[0].code);
         	/***
         	 * 定位查询
         	 * @param {Object} val
         	 * @param {Object} rec
         	 * @return {TypeName} 
         	 */
           var val = $($('#iframe_location', parent.document)).val();
           if(val=="" || val=="serachToday"){
        		serachToday();
        	}else{
        		if(val=="serachTomorrow"){
        			serachTomorrow();
        		}else{
        			serachYesterday();
        		}
        	}
         }
     });
	$('#blxx_list_tab').datagrid( {
			method:'get',
			pageSize : 10,
			pageList : [ 10, 20],
			idField : 'id',
		    title:'随访任务列表',
			collapsible : false,
			remoteSort : false,
			rownumbers : true,
			queryParams : '',
			singleSelect : true,
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
		toolbar : [ 

		{
			id : 'btnsearch',
			type : 'menubutton',
			text : '记录本随访',
			iconCls : '',
		handler : function() {
			var rows = $('#blxx_list_tab').datagrid('getSelected');
			var  rel = $("#suifanglist").find("td").last().find("a.high").attr("rel");
			if (rows == null || rows.length == 0) {
				$.messager.alert('提示', '请选中需要随访的病人!', 'info');
				return false;
			} else {
				if(rows.flupMobile==''){
				$.messager.confirm('确认','该病人没有随访电话，是否仍然经行随访？',function(r){    
				    if (r){  
				    	parent.loadWindow(rows.patiSerial,rows.inpatiNumber,rows.inpatiSerialNumber,rows.flupWay,rows.id,rows.flupPlanDate,rows.flupTimes,rows.medicalInsuranceCode,rel);
				    	parent.getPatiInfo(rows.patiSerial,rows.inpatiNumber,rows.inpatiSerialNumber);
				    }    
				});  
			}else if(rows.flupMobile.length<=6){
				$.messager.confirm('确认','该病人随访电话可能不正确，是否仍然经行随访？',function(r){    
				    if (r){  
				    	parent.loadWindow(rows.patiSerial,rows.inpatiNumber,rows.inpatiSerialNumber,rows.flupWay,rows.id,rows.flupPlanDate,rows.flupTimes,rows.medicalInsuranceCode,rel);
				    	parent.getPatiInfo(rows.patiSerial,rows.inpatiNumber,rows.inpatiSerialNumber);
				    }    
				});  
			}else{
				parent.loadWindow(rows.patiSerial,rows.inpatiNumber,rows.inpatiSerialNumber,rows.flupWay,rows.id,rows.flupPlanDate,rows.flupTimes,rows.medicalInsuranceCode,rel);
				parent.getPatiInfo(rows.patiSerial,rows.inpatiNumber,rows.inpatiSerialNumber);
			}
			}
		}
		}, "-",{
			id : 'btnsearch1',
			text : '取消随访',
			iconCls : '',
			handler : function() {
				var rows = $('#blxx_list_tab').datagrid('getSelected');
				if (rows == null || rows.length == 0) {
					$.messager.alert('提示', '请选中需要调度的项!', 'info');
					return false;
				} else {
					$.messager.confirm('确认','您确认想要取消随访吗？',function(r){    
					    if (r){    
					    	$.ajax({
						        type: "post",
						        url: 'flupTaskAction!stopTask.action',
						        dataType : "json",
						        data:{"flupTask.id":rows.id},
						        success: function(data){
						        	$.messager.alert('提示', data[0].message, 'info');
						        	serach();
						        }
						});  
					    }    
					});  
				}
			}
			
		}],
		frozenColumns:[[ 
						{
					    field : 'ck',
					    checkbox : true
					  	} ,
					  	{
							field : 'outHospitalDate',
							title : '出院日期',
							width : 80,
							align : 'center'
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
						align : 'center'
					},{
						field : 'medicalInsuranceCode',
						title : '医保编号',
					    width : 80,
						align : 'center',
						hidden:true
					},{
						field : 'name',
						title : '姓名',
					    width : 80,
						align : 'center'
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
						align : 'center'
					},{
						field : 'billingCode',
						title : '付费方式',
						width : 80,
						align : 'center',
//						formatter:function(value,row,index){
//							if(value=="10"){return '本地普通';}
//							if(value=="11"){return '外地普通';}
//							if(value=="22"){return '离休干部';}
//							if(value=="30"){return '普通医保';}
//							if(value=="31"){return '医保大病';}
//							if(value=="32"){return '居民医保';}
//						}
					},{
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
					}
					,
					{
						field : 'flupMobile',
						title : '随访电话',
						width : 80,
						align : 'center'
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
					}
					,
					{
						field : 'chiefDoctor',
						title : '住院医生',
						width : 80,
						align : 'center'
					},
					{
						field : 'attendDoctor',
						title : '主治医生',
						width : 80,
						align : 'center'
					},{
						field : 'deptName',
						title : '所属科室',
						width : 120,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'flupPlanDate',
						title : '计划随访日期',
						width : 90,
						align : 'center'
					},{
						field : 'flupDoctorCode',
						title : '计划随访医生',
						width : 80,
						align : 'center'
					},{
						field : 'flupDate',
						title : '随访日期',
						width : 90,
						align : 'center'
					},{
						field : 'actualDoctorName',
						title : '随访医生',
						width : 80,
						align : 'center'
					}
					]], 
		onDblClickRow : function(index, rows) {
			parent.windowInfo(rows.patiSerial,rows.inpatiNumber,rows.inpatiSerialNumber,rows.billingCode,rows.billingCode,rows.flupWay
			,rows.flupType,rows.flupObject,rows.flupPeriod,rows.flupStatus,rows.flupPlanDate.substring(0,10).replace(/\-/g,"/")
			,rows.flupMobile,rows.id,rows.flupName,rows.flupTableNameId,rows.name,rows.flupDoctor,rows.medicalInsuranceCode
			);
		}
	});

	$('#outHospitalDateStart').val("");
	//$('#outHospitalDateStart').val(getNowFormatDate());
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
        	   // url:'datagrid_data.json',    
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
			$("#btnsearch").linkbutton("enable"); 
			$("#btnsearch1").linkbutton("enable"); 
		}else {
			$("#btnsearch").linkbutton("disable"); 
			$("#btnsearch1").linkbutton("disable"); 
		}
		if($.trim($("#inHospDiag").val()).length==0){
	    	$("#diagCode").val("");
	    }
		if($.trim($("#diagName").val()).length==0){
	    	$("#gdiagCode").val("");
	    }
	$('#blxx_tab').datagrid('unselectAll');
	var flupWay = $("#flupWay").combobox("getValue")==''?'doctor':$("#flupWay").combobox("getValue");
	var param={'map.diagGroupCode':$("#gdiagCode").val(),'map.flupComplete':$("#flupComplete").combobox("getValue"),'map.patiSerial':$("#patiSerial").val(),
				'map.inpatiNumber': $("#inpatiNumber").val(),
				'map.name': $("#name").val(),'map.outHospDiag': $("#diagCode").val(),
				'map.inDept': $("#inDept").combogrid("getValue"),'map.flupWay': "%"+flupWay+"%",
				'map.outHospitalDateStart': $("#outHospitalDateStart").val(),'map.outHospitalDateEnd': $("#outHospitalDateEnd").val(),
				'map.flupDateStart': $("#flupDateStart").val(),'map.flupDateEnd': $("#flupDateEnd").val(),
				'map.Yesterday': "",'map.Today': "",'map.Tomorrow': "",'map.History': "",'map.flupStatus':$("#flupStatus").combobox("getValue")	};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function serachYesterday(){
	/***
	 * 通过样式进行区分
	 */
	$("#serachYesterday").siblings().removeClass("high");
	$("#serachYesterday").addClass("high");
	$("#serachYesterday").linkbutton({text:"<span style='color:#FF34B3'>昨日随访任务</span> "});
	$("#serachToday").linkbutton({text:"<span style='color:black'>今日随访任务</span> "});
	$("#serachTomorrow").linkbutton({text:"<span style='color:black'>明日随访任务</span> "});
	$("#serachHistory").linkbutton({text:"<span style='color:black'>历史随访任务</span> "});
	$("#btnsearch").linkbutton("enable"); 
	$("#btnsearch1").linkbutton("enable"); 
	$('#blxx_tab').datagrid('unselectAll');
	var flupWay = $("#flupWay").combobox("getValue")==''?'doctor':$("#flupWay").combobox("getValue");
	var param={'map.flupComplete':"",'map.Yesterday': "Yesterday",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept':"",'map.flupWay': "%"+flupWay+"%",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Today': "",'map.Tomorrow': "",'map.History': "",'map.flupStatus': "1"};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function serachToday(){
	/***
	 * 通过样式进行区分
	 */
	$("#serachToday").siblings().removeClass("high");
	$("#serachToday").addClass("high");
	$("#serachYesterday").linkbutton({text:"<span style='color:black'>昨日随访任务</span> "});
	$("#serachToday").linkbutton({text:"<span style='color:#FF34B3'>今日随访任务</span> "});
	$("#serachTomorrow").linkbutton({text:"<span style='color:black'>明日随访任务</span> "});
	$("#serachHistory").linkbutton({text:"<span style='color:black'>历史随访任务</span> "});
	$("#btnsearch").linkbutton("enable"); 
	$("#btnsearch1").linkbutton("enable"); 
	$('#blxx_tab').datagrid('unselectAll');
	var flupWay = $("#flupWay").combobox("getValue")==''?'doctor':$("#flupWay").combobox("getValue");
	var param={'map.flupComplete':"",'map.Today': "Today",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept':"",'map.flupWay': "%"+flupWay+"%",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Yesterday': "",'map.Tomorrow': "",'map.History': "",'map.flupStatus': "1"};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}
function serachTomorrow(){
	/***
	 * 通过样式进行区分
	 */
	$("#serachTomorrow").siblings().removeClass("high");
	$("#serachTomorrow").addClass("high");
	$("#serachYesterday").linkbutton({text:"<span style='color:black'>昨日随访任务</span> "});
	$("#serachToday").linkbutton({text:"<span style='color:black'>今日随访任务</span> "});
	$("#serachTomorrow").linkbutton({text:"<span style='color:#FF34B3'>明日随访任务</span> "});
	$("#serachHistory").linkbutton({text:"<span style='color:black'>历史随访任务</span> "});
	$("#btnsearch").linkbutton("enable"); 
	$("#btnsearch1").linkbutton("enable"); 
	$('#blxx_tab').datagrid('unselectAll');
	var flupWay = $("#flupWay").combobox("getValue")==''?'doctor':$("#flupWay").combobox("getValue");
	var param={'map.flupComplete':"",'map.Tomorrow': "Tomorrow",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept': "",'map.flupWay': "%"+flupWay+"%",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Yesterday': "",'map.Today': "",'map.History': "",'map.flupStatus': "1"};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function serachHistory(){
	$("#serachYesterday").linkbutton({text:"<span style='color:black'>昨日随访任务</span> "});
	$("#serachToday").linkbutton({text:"<span style='color:black'>今日随访任务</span> "});
	$("#serachTomorrow").linkbutton({text:"<span style='color:black'>明日随访任务</span> "});
	$("#serachHistory").linkbutton({text:"<span style='color:#FF34B3'>历史随访任务</span> "});
	$("#btnsearch").linkbutton("disable"); 
	$("#btnsearch1").linkbutton("disable"); 
	$('#blxx_tab').datagrid('unselectAll');
	var flupWay = $("#flupWay").combobox("getValue")==''?'doctor':$("#flupWay").combobox("getValue");
	var param={'map.flupComplete':"",'map.Tomorrow': "Tomorrow",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept': "",'map.flupWay': "%"+flupWay+"%",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Tomorrow': "",'map.Yesterday': "",'map.Today': "",'map.History': "History",'map.flupStatus': "1"};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}






function setpos() {
	var one1 = $("#diagName").offset();
	$("#confast_div_group").offset( {
		top : one1.top + 20,
		left : one1.left
	});
	
	var one = $("#inHospDiag").offset();
	$("#confast_div").offset( {
		top : one.top + 20,
		left : one.left
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
};
  
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