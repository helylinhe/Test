$(function() {
	setpos();
	$("#confast_div").panel('close');
	 $.ajax({
         type: "post",
         dataType : "json",
         url: 'flupTaskAction!loadCombobox.action',
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
        	$('#flupWay').combobox('loadData', data[0].flupWay);
         	$('#flupWay').combobox('select', data[0].flupWay[0].code);
         	//$('#inDept').combobox('loadData', data[0].department);
        	//$('#inDept').combobox('select', data[0].department[0].deptCode);
        	serachToday();
         },
     });
	$('#blxx_list_tab').datagrid( {
		method:'get',
		pageSize : 10,
		pageList : [ 10, 20],
		idField : 'id',
	    title:'随访列表',
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
		width : 80,
		align : 'center',
		formatter : function(val, rec) {
			return val;
		}
	}] ],
		frozenColumns:[[ 
						{
					    field : 'ck',
					    checkbox : true
					  	} ,
					  	{
							field : 'outHospitalDate',
							title : '出院日期',
							width : 90,
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
						width : 60,
						align : 'center',
					},
					{
						field : 'chiefDoctor',
						title : '住院医生',
						width : 70,
						align : 'center',
					},
					{
						field : 'attendDoctor',
						title : '主治医生',
						width : 70,
						align : 'center',
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
						width : 100,
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
						width : 60,
						align : 'center',
						formatter : function(value,row,index) {
							if(value=='1'){return '专科';}
							if(value=='2'){return '专病';}
						}
					},{
						field : 'deptName',
						title : '所属科室',
						width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						
						field : 'flupPlanDate',
						title : '计划随访日期',
						width : 90,
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
						width : 90,
						align : 'center',
					},{
						field : 'actualDoctorName',
						title : '随访医生',
						width : 80,
						align : 'center',
					}
					]], 
					onDblClickRow : function(index, row) {
						$("#showDetail").show();
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
	$('#blxx_tab').datagrid('unselectAll');
	if($.trim($("#inHospDiag").val()).length==0){
    	$("#diagCode").val("");
    }
	var param={'map.flupComplete':$("#flupComplete").combobox("getValue"),'map.patiSerial':$("#patiSerial").val(),'map.inpatiNumber':$("#inpatiNumber").val(),
			'map.name': $("#name").val(),'map.outHospDiag': $("#diagCode").val(),
			'map.inDept': $("#inDept").combogrid("getValue"),'map.flupWay': "%"+$("#flupWay").combobox("getValue")+"%",
			'map.outHospitalDateStart': $("#outHospitalDateStart").val(),'map.outHospitalDateEnd': $("#outHospitalDateEnd").val()
			,'map.flupDoctorCode':$("#flupDoctorCode").val(),'map.flupDateStart': $("#flupDateStart").val(),'map.flupDateEnd': $("#flupDateEnd").val()
			,'map.Yesterday': "",'map.Today': "",'map.Tomorrow': ""	};
	
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function serachYesterday(){
	$("#serachYesterday").linkbutton({text:"<span style='color:#FF34B3'>昨日随访任务</span> "});
	$("#serachToday").linkbutton({text:"<span style='color:black'>今日随访任务</span> "});
	$("#serachTomorrow").linkbutton({text:"<span style='color:black'>明日随访任务</span> "});
	$('#blxx_tab').datagrid('unselectAll');
	var param={'map.Yesterday': "Yesterday",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept':"",'map.flupWay': "",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Today': "",'map.Tomorrow': ""	};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function serachToday(){
	$("#serachYesterday").linkbutton({text:"<span style='color:black'>昨日随访任务</span> "});
	$("#serachToday").linkbutton({text:"<span style='color:#FF34B3'>今日随访任务</span> "});
	$("#serachTomorrow").linkbutton({text:"<span style='color:black'>明日随访任务</span> "});
	$('#blxx_tab').datagrid('unselectAll');
	var param={'map.Today': "Today",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept': "",'map.flupWay': "",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Yesterday': "",'map.Tomorrow': ""	};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}
function serachTomorrow(){
	$("#serachYesterday").linkbutton({text:"<span style='color:black'>昨日随访任务</span> "});
	$("#serachToday").linkbutton({text:"<span style='color:black'>今日随访任务</span> "});
	$("#serachTomorrow").linkbutton({text:"<span style='color:#FF34B3'>明日随访任务</span> "});
	$('#blxx_tab').datagrid('unselectAll');
	var param={'map.Tomorrow': "Tomorrow",'map.patiSerial':"",'map.inpatiNumber': "",
			'map.name': "",'map.outHospDiag': "",'map.inDept':"",'map.flupWay': "",'map.outHospitalDateStart': "",'map.outHospitalDateEnd':""
			,'map.flupDateStart':"",'map.flupDateEnd': "",'map.Yesterday': "",'map.Today': ""};
	loadData('flupTaskAction!loadDG.action','blxx_list_tab',param);
}

function setpos() {
	var one = $("#inHospDiag").offset();
	$("#confast_div").offset( {
		top : one.top + 20,
		left : one.left
	});
}

//window.setInterval(checkOnkeydown, 1000);
//function checkOnkeydown(){
//    if(document.activeElement.id!='inHospDiag'){
//    	 $("#confast_div").panel('close');
//    }
//    
//}	

function keyMove(e){
	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
	  var odiv=document.getElementById('confast_div');
	  var left =odiv.getBoundingClientRect().left;
	  var top = odiv.getBoundingClientRect().top;
	  //console.info($("#doctorconfast_div").panel('close'));
	  if(x<left||x>(left+220)){
		  $("#confast_div").panel('close');
	  }else if(y<(top-20)||y>(top+100)){
		//alert("上下");
		$("#confast_div").panel('close');
	  }
};

