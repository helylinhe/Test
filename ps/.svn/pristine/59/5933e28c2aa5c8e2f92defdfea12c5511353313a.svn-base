$(function() {
	setpos();
	$("#doctorconfast_div").panel('close');
	$("#add_sfzsk_html").window('close');
	$("#confast_div").window('close');
	$("#rnotifyWay").combobox({
	onHidePanel: function(){
		$("#ckBox").attr("checked",false);
		if($("#rnotifyWay").combobox("getValue")!="电话"){
			$("#ckBox").attr("checked",true);
		}
		if($("#ckBox").attr("checked")!='checked'){
			$("#returnMessage").val("");
		}
		$("#ckBox").attr("checked")!='checked'?$("#returnMessage").attr("disabled", "disabled"):$("#returnMessage").removeAttr("disabled");
		}
	});
	
	$.ajax({
        type: "post",
        url: path+'/returnTaskAction!loadCombobox.action',
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
        	    onHidePanel: function(){
	      	    	$.ajax({
	      	    	  type: "post",
	      	          dataType : "json",
	      	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
	      	          data:{"department.deptCode":$('#deptCode').combogrid("getValue")} ,
	      	          success: function(data){
	      	        	$('#doctorconfast_tab').datagrid({ 
	      	        	method:'get',
	      	      		idField : 'jobnum',
	      	      		rownumbers : false,
	      	      		width:'100%',
	      	      		queryParams : '',
	      	      		columns : [ [ 
	      	            	        {field:'jobnum',title:'',hidden:true},    
	      	            	        {field:'name',title:'医生姓名',width:100}
	      	            	    ]],
	      	        	onClickRow: function(rowIndex, rowData){
	      	        		$("#retmDoctorName").val(rowData.name);
 	        				$("#retmDoctorCode").val(rowData.jobnum);
 	        				$('#doctorconfast_tab').datagrid('unselectAll');
	        				$("#doctorconfast_div").panel('close');
	      	        		
	      	        	}
	      		      	});
	      	        	$('#doctorconfast_tab').datagrid('loadData', data[0].rows);
	      	          }
	      	    	});
	      	  }
        	});
        	//$('#deptCode').combobox('loadData', data[0].department);
        	//$('#deptCode').combobox('select', data[0].department[0].deptCode);
        	serach();
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
		width:'100%',
		queryParams : '',
		frozenColumns:[[ 
						{
					    field : 'ck',
					    checkbox : true
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
						align : 'center'
					}, {
						field : 'name',
						title : '姓名',
					    width : 80,
						align : 'center'
					}
					]],
		columns : [ [  {
			field : 'id',
			title : '任务id',
			width : 80,
			align : 'center',
			hidden:true
		}, {
			field : 'gender',
			title : '性别',
			width : 50,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='1'){return '男';}
				if(value=='2'){return '女';}
			}
		},
		{
			field : 'age',
			title : '年龄',
			width : 50,
			align : 'center',
		},{
			field : 'outHospDiagCode',
			title : '诊断代码',
			width : 100,
			align : 'center',
			hidden:true
		} ,{
			field : 'outHospDiag',
			title : '出院诊断',
			width : 100,
			align : 'center',
		},{
			field : 'operationName',
			title : '手术名称',
			width : 200,
			align : 'center',
		},{
			field : 'retplanDate',
			title : '复诊日期',
			width : 100,
			align : 'center',
		}
		, {
			field : 'retplanDeptCode',
			title : '复诊科室代码',
			width : 100,
			align : 'center',
			hidden:true
		},{
			field : 'retplanDeptName',
			title : '复诊科室',
			width : 100,
			align : 'center',
		},{
			field : 'retmDoctorCode',
			title : '复诊医生',
			width : 100,
			align : 'center',
		},
		{
			field : 'returnContent',
			title : '复诊内容',
			width : 200,
			align : 'center',
		},{
			field : 'returnConfirm',
			title : '复诊通知',
			width : 200,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='0'){return '未通知';}
				if(value=='1'){return '已通知';}
			}
		},{
			field : 'flupMobile',
			title : '联系电话',
			width : 100,
			align : 'center',
		}, {
			field : 'notifyWay',
			title : '通知方式',
			width : 80,
			align : 'center',
		}, {
			field : 'returnComplete',
			title : '是否复诊',
			width : 100,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='0'){return '未复诊';}
				if(value=='1'){return '已复诊';}
			}
		}
		] ],
		toolbar : [ {
			text : '通知复诊',
			iconCls : 'icon-add',
			handler : function() {
				var rows = $("#config_list_tab").datagrid("getSelections");
				if(rows.length==0){
					$.messager.alert('提示', '请选中需要通知的项!', 'info');
					return;
				}
				for ( var int = 0; int < rows.length; int++) {
					if(rows[int].flupMobile.length!=11){
						$.messager.alert('提示', '请确认随访电话都是手机号码!', 'info');
						return;
					}
				}
				
				openWindow(rows);
			}
		}],
	});
});
function opfast() {
	$('#confast_div').panel('open');
}

function opfastTable() {
	$('#sfzskwh_sfb_div').panel('open');
}



function serach(){
	if($("#retmDoctorName").val()==""){
		$("#retmDoctorCode").val("");
	}
	var param={'map.patiSerial':"%"+$("#patiSerial").val()+"%",
			 'map.inpatiNumber':"%"+$("#inpatiNumber").val()+"%",
			 'map.name': "%"+$("#name").val()+"%",
			 'map.retplanDateStart':$("#retplanDateStart").datebox("getValue"),
			 'map.retplanDateEnd':$("#retplanDateEnd").datebox("getValue") ,
			 'map.returnConfirm': $("#returnConfirm").combobox("getValue"),
			 'map.returnComplete': $("#returnComplete").combobox("getValue"),
			 'map.retmDoctorCode': $("#retmDoctorCode").val(),
			 'map.retplanDeptCode': $("#deptCode").combogrid("getValue")
			};
	 loadData(path+'/returnTaskAction!loadDataGird.action','config_list_tab',param);
  }



function clean(){
	$('#id').val("");
	$("#diagName").val("");
	$("#diagCode").val("");
	$("#gpdiagName").val("");
	$('#gpdiagCode').val("");
	$('#returnDeptName').val("");
	$('#returnDeptCode').val("");
	$('#flupDoctorCode').val("");
	$('#hflupDoctorCode').val("");
	$('#flupCycle').val("");
	$('#returnDay').val("");
	$('#returnInfo').val("");
	$('#num').val("2");
}

function setpos() {
	var one = $("#retmDoctorName").offset();
	var one1 = $("#returnDeptName").offset();
	var one2 = $("#returnMessage").offset();
	$("#doctorconfast_div").offset( {
		top : one.top + 20,
		left : one.left	
		});
	$("#confast_divDept").offset( {
		top : one1.top + 20,
		left : one1.left
	});
	$("#confast_div").offset( {
		top : one2.top + 20,
		left : one2.left
	});
}



//获取医生的方法
function getDoctor(){
	  $("#doctorconfast_div").panel('open');
}


function radio_click(obj){
    obj.value=='1'?$("#gpdiagName").attr("disabled","disabled"):$("#diagName").attr("disabled","disabled");
    obj.value=='2'?$("#gpdiagName").removeAttr("disabled","disabled"):$("#diagName").removeAttr("disabled","disabled");
   
}

function openWindow(rows){
	$("#add_sfzsk_html").window('open');
	if(rows.length>1){
		var date = "";
		var returnKs = "";
		$("#returnDeptName").val("");
		$("#returnDeptCode").val("");
		for ( var int = 0; int < rows.length; int++) {
			date += rows[int].retplanDate+",";
			returnKs += rows[int].retplanDeptName+",";
		}
	   $("#retplanDate").datebox({
	       disabled: true
	    });
		$('#returnDeptName').attr("disabled","disabled");
		$("#returnInfo").attr("disabled", "disabled");
		$("#hReturnDate").val(date);
		$("#hReturnCode").val(returnKs);
		$("#returnInfo").val("");
		}else{
			 $("#retplanDate").datebox({
		            disabled: false
		        });
		$('#returnDeptName').removeAttr("disabled");
		$("#returnInfo").removeAttr("disabled");	
		$("#ckBox").attr("checked",false);
		$('#retplanDate').datebox('setValue', rows[0].retplanDate.substring(0,10).replace(/\-/g,"/"));
		$("#rnotifyWay").combobox('select',rows[0].notifyWay);
		$("#returnDeptName").val(rows[0].retplanDeptName);
		$("#returnDeptCode").val(rows[0].retplanDeptCode);
		$("#returnInfo").val(rows[0].returnContent);
		$("#returnMessage").val(rows[0].sendContent);
		if(rows[0].notifyWay!="电话"){
			$("#ckBox").attr("checked",true);
		}
		if($("#ckBox").attr("checked")!='checked'){
			$("#returnMessage").val("");
		}
		$("#ckBox").attr("checked")!='checked'?$("#returnMessage").attr("disabled", "disabled"):$("#returnMessage").removeAttr("disabled");
	}	
}

//监听科室键盘按键
function keyDownDept(r){
    $("#confast_divDept").panel('open');
	$.ajax({
        type: "post",
        url: path+"/patiReturnRuleAction!getDepartmentInfo.action",
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#confast_tabDept').datagrid({    
        	    columns:[[    
        	        {field:'deptCode',title:'',hidden:true},  
        	        {field:'deptName',title:'科室名称',width:100}, 
        	        {field:'unitCode',title:'院区',width:100,
        	        formatter : function(value,row,index) {
        				if(value=='1'){return '北院';}
        				if(value=='2'){return '南院';}
        			}
        	        }
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#returnDeptName").val(row.deptName);
				    $("#returnDeptCode").val(row.deptCode);
				    $("#confast_divDept").panel('close');
				},    
        	}); 
       $('#confast_tabDept').datagrid('loadData', data[0].rows);
    }
});
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
	  
	  var ddiv=document.getElementById("confast_divDept");
	  var dleft =ddiv.getBoundingClientRect().left;
	  var dtop = ddiv.getBoundingClientRect().top;
	  
	  if(x<left||x>(left+220)){
		  $("#doctorconfast_div").panel('close');
	  }else if(y<(top-20)||y>(top+200)){
		//alert("上下");
		$("#doctorconfast_div").panel('close');
	  }
	  if(x<rleft||x>(rleft+320)){
		  $("#confast_div").panel('close');
		  $("#exit").show();
		  $("#mes").show();
	  }else if(y<(rtop-50)||y>(rtop+150)){
		  $("#confast_div").panel('close');
		  $("#exit").show();
		  $("#mes").show();
		//  $("#mes").linkbutton({text:"通知",iconCls:"icon-add"});  
		//  $('#mes').bind('click', addMessage()); 
		//  $("#exit").linkbutton({text:"退出",iconCls:"icon-cut"});
		//  $('#exit').bind('click', minusNum()); 
	  }
	  if(x<dleft||x>(dleft+220)){
		  $("#confast_divDept").panel('close');
	  }else if(y<(dtop-20)||y>(dtop+150)){
		  $("#confast_divDept").panel('close');
	  }
};

function getMessageInfo(){
//	$("#mes").linkbutton({text:"",iconCls:""});  
//	$("#exit").linkbutton({text:"",iconCls:""}); 
	$("#exit").hide();
	$("#mes").hide();
	$.ajax({
    	  type: "post",
          dataType : "json",
          url:  path+'/returnTaskAction!getMessageInfo.action',
          success: function(data){
        	$("#confast_div").window("open"); 
        	$('#confast_tab').datagrid({    
        	    columns:[[    
        	        {field:'infoContent',title:'信息内容',width:310}
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#returnMessage").val(row.infoContent);
				    $("#confast_div").window('close');
				    $("#exit").show();
					$("#mes").show();
				},    
        	}); 
        	$('#confast_tab').datagrid('loadData', data[0].rows);
          }
    	});
}


function addMessage(){
	var rows = $("#config_list_tab").datagrid("getSelections");
	var id = "";
	var phone = "";
	var date = "";
	for ( var int = 0; int < rows.length; int++) {
		id += rows[int].id+",";
		phone += rows[int].flupMobile+",";
	}
	if(rows.length==1){
		date=$("#retplanDate").datebox("getValue");
		$("#hReturnCode").val($("#returnDeptName").val());
	}else{
		date=$("#hReturnDate").val();
	}
	$.ajax({
  	  type: "post",
        dataType : "json",
        url:  path+'/returnTaskAction!updateMessage.action',
        data:{"returnMessage.id":id,
        	"returnMessage.returnDate":date,
        	"returnMessage.confirm":$("#returnInfo").val(),
        	"returnMessage.message":$("#returnMessage").val(),
        	"returnMessage.type":$("#rnotifyWay").combobox("getValue"),
        	"returnMessage.deptCode":$("#returnDeptCode").val(),
        	"returnMessage.phone":phone,
        	"returnMessage.returnType":$("#hReturnCode").val()
        },
        success: function(data){
        	$.messager.alert('提示', data[0].message, 'info');
        	$("#add_sfzsk_html").window('close');
        	$("#config_list_tab").datagrid("uncheckAll");
        	serach();
        }
  	});
}

function clickBox(){
	if($("#rnotifyWay").combobox("getValue")!="电话"){
		$("#ckBox").attr("checked",true);
	}
	if($("#ckBox").attr("checked")!='checked'){
		$("#returnMessage").val("");
	}
	$("#ckBox").attr("checked")!='checked'?$("#returnMessage").attr("disabled", "disabled"):$("#returnMessage").removeAttr("disabled");
}

function minusNum(){
	$("#add_sfzsk_html").window("close");
}


