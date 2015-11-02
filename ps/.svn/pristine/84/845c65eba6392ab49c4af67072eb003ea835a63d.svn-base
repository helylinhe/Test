$(function(){
	//$("#sfzskwh_sfb_div").panel('close');
	$("#sfzskwh_sfb_div").panel('close');
	 $("#add_sfzsk_html").window('close');
	 $.ajax({
         type: "post",
         dataType : "json",
         url: 'flupTaskAction!loadCombobox.action',
         success: function(data){
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
        	//$('#inDept').combobox('select', data[0].department[0].deptCode);
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
	      	    textField:'name',
	      	    onHidePanel: function(){
		      	   	$.ajax({
		      	      type: "post",
		      	       dataType : "json",
		      	        url: 'flupTaskAction!getPhoneByType.action',
		      	        data:{"phone.type":$('#flupObject').combobox("getValue"),"phone.inpatiNumber":$("#inpatiNumber").val()} ,
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
	    	
	      	//combogrid数据的加载
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
              	    	$('#flupTableNameId').val(row.flupNameId);
      				} 
        	}); 
	    	
            /**datagrid显示随访表的方式
	    	$('#sfzskwh_sfb').datagrid({    
        	    columns:[[    
        	        {field:'flupName',title:'随访名称',width:100},    
        	        {field:'flupNameId',title:'flupNameId',width:100,hidden:true},    
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
        	    	$('#flupName').val(row.flupName);
        	    	$('#flupTableNameId').val(row.flupNameId);
        	    	$("#sfzskwh_sfb_div").panel('close');
				},
        	});
	    	$('#sfzskwh_sfb').datagrid('loadData', data[0].rows);
	    	 */	
  //       	$('#inDept').combobox('loadData', data[0].department);
        	//window隐藏面板combobox加载
//        	$('#billingCode').combobox('loadData', data[0].billingCode);
//         	alert("a");
        	$('#flupType').combobox('loadData', data[0].flupType);
        	$('#flupType').combobox('select', data[0].flupType[0].code);
        	$('#flupObject').combobox('loadData', data[0].flupObject);
        	$('#flupObject').combobox('select', data[0].flupObject[0].code);
        	$('#flupDoctorCode').combobox({    
	      	    valueField:'jobnum',    
	      	    textField:'name',
	      	    data:data[0].flupDoctorCode
	      	});
        	$('#flupDoctorCode').combobox('select', data[0].flupDoctorCode[0].jobnum);
//        	$('#billingCode').combobox('setValue',rows[0].billingCode);
        	$("#sbillingCode").val($($('#sbillingCode', parent.document)).val());
//        	alert($($('#sbillingCode', parent.document)).val());
        	$("#hbillingCode").val($($('#sbillingCode', parent.document)).val());
//        	alert($($('#wflupWay', parent.document)).val());
        	$('#wflupWay').combobox('setValue',$($('#wflupWay', parent.document)).val());
//        	alert($($('#flupType', parent.document)).val());
        	$("#flupType").combobox('setValue',$($('#flupType', parent.document)).val());
//            alert($($('#flupObject', parent.document)).val());
        	$("#flupObject").combobox('setValue',$($('#flupObject', parent.document)).val());
//        	alert($($('#flupPeriod', parent.document)).val());
        	$("#wflupStatus").combobox("setValue",$($('#wflupStatus', parent.document)).val());
//        	alert($($('#flupPlanDate', parent.document)).val());
        	$('#flupPlanDate').datebox('setValue', $($('#flupPlanDate', parent.document)).val().substring(0,10).replace(/\-/g,"/"));	// 设置日期输入框的值
//        	alert($($('#flupMobile', parent.document)).val());
        	$("#flupMobile").val($($('#flupMobile', parent.document)).val());
//        	alert($($('#id', parent.document)).val());
        	$("#id").val($($('#id', parent.document)).val());
//       	alert($($('#id', parent.document)).val());
//        	alert($($('#flupName', parent.document)).val());
        	$('#flupName').combogrid("setValue",($('#flupName', parent.document)).val());
        	$("#flupTableNameId").val($($('#flupTableNameId', parent.document)).val());
        	$("#patiSerial").val($($('#dispatch_patiSerial', parent.document)).val());
 //       	alert($($('#dispatch_patiSerial', parent.document)).val());
        	$("#inpatiNumber").val($($('#dispatch_inpatiNumber', parent.document)).val());
        	$("#inpatiSerialNumber").val($($('#dispatch_inpatiSerialNumber', parent.document)).val());
        	$("#name").val($($('#name', parent.document)).val());
        	$('#flupDoctorCode').combobox("setValue",$($('#flupDoctor', parent.document)).val());
        	
        	
        	/***
        	 * 加载数据
        	 */
        	//var patiSerialValue=$($('#dispatch_patiSerial', parent.document)).val();
        	var inpatiNumberValue=$($('#dispatch_inpatiNumber', parent.document)).val();
        	var param={"map.inpatiNumber":inpatiNumberValue};
        	
        	
        	loadData(path+'/patiflupruleaction!pageList.action','prop_list_tab',param);
        	
        	
        	
        	
        	$.ajax({
	      	      type: "post",
	      	       dataType : "json",
	      	        url: 'flupTaskAction!getPhoneByType.action',
	      	        data:{"phone.type":$('#flupObject').combobox("getValue"),"phone.inpatiNumber":$("#inpatiNumber").val()} ,
	      	         success: function(data){
	      	      	 if(data[0].phone[0].type==""){
	      	        	 $('#sflupMobile').combobox({
	      	        	   editable :true
	      	        	 });
	      	        	 }else{ 
	      	        	 
	      	       	$('#sflupMobile').combobox({    
	      		      	    valueField:'type',    
	      		      	    textField:'mobileNumber',
	      		      	    data:data[0].phone	,
	      		      	    editable :false
	      		      	});
	      	        	$('#sflupMobile').combobox('select', data[0].phone[0].type);
	      	          }
	      	      	 }
	      	});
         }
});
	
	
	

	
	
	
	$('#prop_list_tab').datagrid( {
		url : '',
		method : 'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : true,
		title : '历史随访信息',
		pagination : true,
		pageSize : 10,
		fitColumns : true,
		pageList : [ 10,20,30,40 ],
		hideColumn:[[{
			field : 'flupPeriod',
			title : '随访周期',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'flupType',
			title : '随访类型',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'flupPlanDate',
			title : '计划随访日期',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}]],
		columns : [ [ 
		{
			field : 'inpatiNumber',
			title : '住院号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'patiSerial',
			title : '住院流水号',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'name',
			title : '姓名',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'age',
			title : '年龄',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'flupMobile',
			title : '随访电话',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'deptCode',
			title : '所属科室',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'outHospDiag',
			title : '出院诊断',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'flupObject',
			title : '随访对象',
			width : 150,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='1'){return '本人';}
				if(value=='2'){return '联系人';}
			}
		}, {
			field : 'flupWay',
			title : '随访方式',
			width : 100,
			align : 'center',
			formatter : function(value,row,index) {
				if(value=='1'){return '电话';}
				if(value=='2'){return '短信';}
				if(value=='3'){return '微信';}
				if(value=='4'){return '门诊';}
				if(value=='5'){return '上门';}
			}
		}, {
			field : 'flupDate',
			title : '随访日期',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'flupDoctorCode',
			title : '随访医生',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
	});
});



//修改方法
function submitInfo(){
//	var rows = $('#prop_list_tab').datagrid('getSelections');
//	alert($($('#flupTableNameId', parent.document)).val());
//	alert($("#id").val());
//	alert($("#wflupStatus").combobox('getValue'));
//	alert($("#wflupWay").combobox('getValue'));
//	alert($("#flupType").combobox('getValue'));
//	alert($("#flupPeriod").combobox('getValue'));
//	alert($("#flupPlanDate").datebox('getValue'));
//	alert($("#flupObject").combobox('getValue'));
//	alert($("#flupMobile").val());
//	alert($("#flupDoctorCode").combobox('getValue'));
//	alert($("#inpatiNumber").val());
//	alert($("#inpatiSerialNumber").val());
	
	if(isNaN($("#sflupMobile").combobox("getText"))){
		$.messager.alert('提示', '请填写正确的电话号码！', 'info');
		return;
		}
	
	if($("#wflupStatus").combobox("getValue")=='4'){
		setpos();
	//	alert("aaa");
		$("#add_sfzsk_html").window('open');
		return;
	}
	if($("#wflupStatus").combobox("getValue")==''||$("#wflupWay").combobox("getValue")==''||$("#flupType").combobox("getValue")==''||
		$("#flupPlanDate").datebox("getValue")==''||$("#flupObject").combobox("getValue")==''||$("#flupDoctorCode").combobox("getValue")==''){
		$.messager.alert('提示', '请讲上面信息填写完整！', 'info');
		return;
	}
	$.ajax({
        type: "post",
        url: 'flupTaskAction!updateFlupTask.action',
        dataType : "json",
        data:{"flupTask.addReasons":$("#addReasons").val(),"flupTask.patiSerial":$("#patiSerial").val(),"flupTask.flupTableNameId":$("#flupTableNameId").val(),"flupTask.id":$("#id").val(),"flupTask.flupStatus":$("#wflupStatus").combobox('getValue'),"flupTask.flupWay":$("#wflupWay").combobox('getValue'),
        	"flupTask.flupType":$("#flupType").combobox('getValue'),"flupTask.flupPlanDate":$("#flupPlanDate").datebox('getValue'),
        	"flupTask.flupObject":$("#flupObject").combobox('getValue'),"flupTask.flupMobile":$("#sflupMobile").combobox("getText"),"flupTask.flupDoctorCode":$("#flupDoctorCode").combobox('getValue'),
        	"flupTask.inpatiNumber":$("#inpatiNumber").val(),"flupTask.inpatiSerialNumber":$("#inpatiSerialNumber").val(),"flupTask.id":$("#id").val()},
        success: function(data){
        	$.messager.alert('提示', data[0].message, 'info');
        	var inpatiNumberValue=$($('#dispatch_inpatiNumber', parent.document)).val();
        	var param={"map.inpatiNumber":inpatiNumberValue};
        	loadData(path+'/patiflupruleaction!pageList.action','prop_list_tab',param);
        },
    });
  }

function updateAuditsState(){
	if(isNaN($("#sflupMobile").combobox("getText"))){
		$.messager.alert('提示', '请填写正确的电话号码！', 'info');
		return;
		}
	if($("#addReasons").validatebox("isValid")){
		$("#add_sfzsk_html").window('close');
		//var rows = $('#prop_list_tab').datagrid('getSelections');
		if($("#wflupStatus").combobox("getValue")==''||$("#wflupWay").combobox("getValue")==''||$("#flupType").combobox("getValue")==''||
				$("#flupPlanDate").datebox("getValue")==''||$("#flupObject").combobox("getText")==''||$("#flupDoctorCode").combobox("getValue")==''){
				$.messager.alert('提示', '请讲上面信息填写完整！', 'info');
				return;
			}
			$.ajax({
		        type: "post",
		        url: 'flupTaskAction!updateFlupTask.action',
		        dataType : "json",
		        data:{"flupTask.addReasons":$("#addReasons").val(),"flupTask.patiSerial":$("#patiSerial").val(),"flupTask.flupTableNameId":$("#flupTableNameId").val(),"flupTask.id":$("#id").val(),"flupTask.flupStatus":$("#wflupStatus").combobox('getValue'),"flupTask.flupWay":$("#wflupWay").combobox('getValue'),
		        	"flupTask.flupType":$("#flupType").combobox('getValue'),"flupTask.flupPlanDate":$("#flupPlanDate").datebox('getValue'),
		        	"flupTask.flupObject":$("#flupObject").combobox('getValue'),"flupTask.flupMobile":$("#sflupMobile").combobox("getText"),"flupTask.flupDoctorCode":$("#flupDoctorCode").combobox('getValue'),
		        	"flupTask.inpatiNumber":$("#inpatiNumber").val(),"flupTask.inpatiSerialNumber":$("#inpatiSerialNumber").val(),"flupTask.id":$("#id").val()},
		        success: function(data){
		        	$.messager.alert('提示', data[0].message, 'info');
		        	$("#addReasons").val('');
		        	if(data[0].success){
		        		var inpatiNumberValue=$($('#dispatch_inpatiNumber', parent.document)).val();
		            	var param={"map.inpatiNumber":inpatiNumberValue};
		            	loadData(path+'/patiflupruleaction!pageList.action','prop_list_tab',param);
		        	}
		        },
		    });
	}
}

function setpos() {
	var left =  document.body.clientWidth;
//	var top = document.body.clientHeight;
	$("#add_sfzsk_html").window("move", {
		top : 200,
		left : left/2-200
	});
}
function suifanggginfo_winclose() {
	$("#add_sfzsk_html").window("close");
}
