$(function() {
	
	/****
	 * 隐藏弹出层
	 */
	$("#dept_div").panel('close');
	
	/*****
	 * 科室文本框鼠标丢失事件
	 */
	$("#deptName").blur(function (event){
		// console.info($(event.target));
	});
	
	
	loadData(path+'/departmentaction.action','depart_list_tab',{'map.deptCode':'','map.deptName':''});
	$('#queryInfo').click(function(){
		$("#depart_list_tab").datagrid("unselectAll");
		var deptCode = $('#deptCode').val();
		var deptName = $('#deptName').val();
		var findUnitCode = $('#findUnitCode').combobox("getValue");
		var param = {'map.deptCode':deptCode,'map.deptName':deptName,'map.unitCode' : findUnitCode};
		loadData(path+'/departmentaction.action','depart_list_tab',param);
	});
	$('#sava').click(function(){
		var deptCode =  $('#adeptCode').val();
		var deptName = $('#adeptName').val();
		var deptStatus = $('#adeptStatus').combobox("getValue");
		var medicalInsuranceCode = $('#amedicalInsuranceCode').val();
		var medicalInsuranceName = $('#amedicalInsuranceName').val();
		var deptSameCode = $('#adeptSameCode').val();
		var unitCode = $('#aunitCode').combobox("getValue");
		var deptSummary = $('#deptSummary').val();
		var expertDept = $("#expertDept").combobox("getValue");
		var flupDept = $("#flupDept").combobox("getValue");
		if(deptCode==null || deptCode.length==0 || deptCode.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','科室编码不能为空！','error');
				return;
			}
		if(deptName==null || deptName.length==0 || deptName.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','科室名称不能为空！','error');
				return;
			}
		if(deptStatus==null || deptStatus.length==0 || deptStatus.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','科室状态不能为空！','error');
				return;
			}
		if(medicalInsuranceCode==null || medicalInsuranceCode.length==0 || medicalInsuranceCode.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','医保代码不能为空！','error');
				return;
			}
		if(medicalInsuranceName==null || medicalInsuranceName.length==0 || medicalInsuranceName.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','医保名称不能为空！','error');
				return;
			}
		if(deptSameCode==null || deptSameCode.length==0 || deptSameCode.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','同一科室代码不能为空！','error');
				return;
			}
		if(unitCode==null || unitCode.length==0 || unitCode.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','院区代码不能为空！','error');
				return;
			}
		$.messager.confirm("提示","确认添加",function(r){
			if(r){
				$.post(
							path+"/departmentaction!addDepartment.action",
							{
									deptCode : deptCode,
									deptName : deptName,
									deptStatus : deptStatus,
									medicalInsuranceCode : medicalInsuranceCode,
									medicalInsuranceName : medicalInsuranceName,
									deptSameCode : deptSameCode,
									unitCode : unitCode,
									deptSummary:deptSummary,
									expertDept:expertDept,
									flupDept:flupDept
							},
							function(data){
										if(data == 'success'){
											$.messager.alert('消息','添加成功','info');
											$('#add_blackList_html').dialog('close')
											$("#depart_list_tab").datagrid("unselectAll");
											var deptCode = $('#deptCode').val();
											var deptName = $('#deptName').val();
											var findUnitCode = $('#findUnitCode').combobox("getValue");
											var param = {'map.deptCode':deptCode,'map.deptName':deptName,'map.unitCode' : findUnitCode};
											loadData(path+'/departmentaction.action','depart_list_tab',param);
										}else{
											$.messager.alert('消息','不能添加重复的科室信息','error');
										}
							},'text'
				);
			}
		});
		
		
		
		
	});
	$('#update').click(function(){
		var udeptCode =  $('#udeptCode').val();
		var udeptName = $('#udeptName').val();
		var udeptStatus = $('#udeptStatus').combobox("getValue");
		var umedicalInsuranceCode = $('#umedicalInsuranceCode').val();
		var umedicalInsuranceName = $('#umedicalInsuranceName').val();
		var udeptSameCode = $('#udeptSameCode').val();
		var uunitCode = $('#uunitCode').combobox("getValue");
		var udeptSummary = $('#udeptSummary').val();
		var uexpertDept = $("#uexpertDept").combobox("getValue");
		var uflupDept = $("#uflupDept").combobox("getValue");
		$.messager.confirm("提示","确认修改?",function(r){
			if(r){
				$.post(
					path+"/departmentaction!updateDepartment.action",
					{
						deptCode : udeptCode,
						deptName : udeptName,
						deptStatus : udeptStatus,
						medicalInsuranceCode : umedicalInsuranceCode,
						medicalInsuranceName : umedicalInsuranceName,
						deptSameCode : udeptSameCode,
						unitCode : uunitCode,
						deptSummary:udeptSummary,
						expertDept:uexpertDept,
						flupDept:uflupDept
					},
					function(data){
						if(data == 'success'){
								$.messager.alert('消息','修改成功','info');
								$('#update_blackList_html').dialog('close')
								$("#depart_list_tab").datagrid("unselectAll");
								var deptCode = $('#deptCode').val();
								var deptName = $('#deptName').val();
								var findUnitCode = $('#findUnitCode').combobox("getValue");
								
								/****
								 * 修改后定位具体的页数
								 */
								var options = $('#depart_list_tab').datagrid('getPager').data("pagination").options;  
								var curr = options.pageNumber;  

								var param = {'map.deptCode':deptCode,'map.deptName':deptName,'map.unitCode' : findUnitCode,'page.pageNo':curr};
								loadData(path+'/departmentaction.action','depart_list_tab',param);
							}else{
								$.messager.alert('消息','修改失败','error');
							}
					},'text'
				);
			}
		
		});
		
	});
	
	$('#depart_list_tab').datagrid( {
		collapsible : false,
		remoteSort : false,
		idField : 'deptCode',
		rownumbers : true,
		singleSelect : true,
		title : '科室信息',
		pagination : true,
		pageSize : 10,
		fitColumns : true,
		pageList : [ 10, 20 ],
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'deptCode',
			title : '科室编码',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'deptSmpName',
			title : '科室简称',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'deptName',
			title : '科室名称',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}
		, {
			field : 'deptStatus',
			title : '科室状态',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val=='1' ? '停用' : '正常';
			}
		}
		
		
		, {
			field : 'clinicAttrName',
			title : '临床科室属性名称',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}
		
		, {
			field : 'outpOrInpName',
			title : '门诊住院科室名称',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'flupDept',
			title : '随访科室',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val=='1' ? '随访科室' : '非随访科室';
			}
		}, {
			field : 'expertDept',
			title : '专家科室',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val=='1' ? '专家科室' : '非专家科室';
			}
		}
		
		
//		, {
//			field : 'medicalInsuranceCode',
//			title : '医保代码',
//			width : 150,
//			align : 'center',
//			formatter : function(val, rec) {
//				return val;
//			}
//		}
		, {
			field : 'medicalInsuranceName',
			title : '医保名称',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}
			, {
			field : 'deptSameCode',
			title : '同一科室代码',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}
			, {
			field : 'unitCode',
			title : '院区代码',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val.length!=0 ? (val=='1' ? '北院' : '南院') : val;
			}
		}
		 ] ],
		toolbar : [ {
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				$('#add_blackList_html').dialog('open');
			}
		}, "-", {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				//var rows = $('#depart_list_tab').datagrid('getSelections');
				var rows = $('#depart_list_tab').datagrid('getSelected');
				if (rows == null || rows.length == 0) {
					$.messager.alert('提示', '请选中需要修改的项!', 'info');
					return false;
				} else {
				/*
						$('#update_blackList_html').dialog('open').dialog('setTitle');
						$('#fm').form('load',rows);
					*/		
						$("#update_blackList_html").window("open");
						var rows = $("#depart_list_tab").datagrid("getSelections");
						
						$("#udeptCode").val(rows[0].deptCode);
						$("#udeptName").val(rows[0].deptName);
						$("#udeptSameCode").val(rows[0].deptSameCode);
						$("#umedicalInsuranceCode").val(rows[0].medicalInsuranceCode);
						$("#umedicalInsuranceName").val(rows[0].medicalInsuranceName);
						$("#uunitCode").combobox("setValue",rows[0].unitCode);
						$("#udeptStatus").combobox("setValue",rows[0].deptStatus);
						$("#uexpertDept").combobox("setValue",rows[0].expertDept);
						$("#uflupDept").combobox("setValue",rows[0].flupDept);
						$("#udeptSummary").html(rows[0].deptSummary);
													
				}
			}
		} ],
		onClickRow : function(index, row) {
			/*
			$("#one3").combobox('setValue', row.one3);
			$("#one4").combobox('setValue', row.one4);
			$("#one5").combobox('setValue', row.one5);
			$("#one1").val(row.one1);
			$("#one2").val(row.one2);
			*/
			
		}
	});
});


function openDeptTable(id){
	if(id=="deptName"){
	$("#dept_div").panel('open');
	 createDeptTable("dept_tab","deptCode","deptName","dept_div");
	 var position = $("#deptName").offset();
		$("#dept_div").offset( {
			top : position.top + 20,
			left : position.left-50
		});
	}
	
}

function createDeptTable(tab,id0,id1,panel){
	$('#'+tab).datagrid({
		collapsible : false,
		remoteSort : false,
		idField : 'deptCode',
		singleSelect : true,
		pageSize : 10,
		fitColumns : true,
		singleSelect: true,
		frozenColumns : [ [
//		                   {
//			field : 'ck',
//			checkbox : true
//		} 
		                   ] ],
		hideColumn : [ [ {
			field : 'deptCode',
			title : '部门编号',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns:[[{
			field : 'deptName',
			title : '部门名称',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'unitCode',
			title : '所属院区',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
			switch(val){
			case "2":
				return '南院区';
				break;
			case "1":
				return '北院区';
				break;
			default:
				return '无'
				break;
			}
				
			}
		}]],
//		toolbar : [{
//			text : '选择',
//			iconCls : 'icon-add',
//			handler : function() {
//			var rows =$('#'+tab).datagrid('getSelections');
//			if (rows == null || rows.length == 0) {
//				$.messager.alert('提示', '请选中需要添加的项!', 'info');
//				return false;	
//			}else{
//				var deptCode=[];
//				var deptName=[];
//				for(var i=0;i<rows.length;i++){
//					deptCode.push(rows[i].deptCode);
//					deptName.push(rows[i].deptName);
//				}
//				$("#"+id0).val(deptCode.toString());
//				$("#"+id1).val(deptName.toString());
//				$("#"+panel).panel('close');
//				$('#'+tab).datagrid("clearSelections");
//			 }
//			}
//		}],
		onDblClickRow : function(index, row) {
			$("#"+id0).val(row.deptCode);
			$("#"+id1).val(row.deptName);
			$("#"+panel).panel('close');
			$('#'+tab).datagrid("clearSelections");
		}
	});
	loadData(path+'/departmentaction!execute.action',tab, null);
}


function createDeptTable1(tab,id0,id1,panel){
	$('#'+tab).datagrid({
		collapsible : false,
		remoteSort : false,
		idField : 'deptCode',
		singleSelect : true,
		pageSize : 10,
		fitColumns : true,
		singleSelect: true,
		frozenColumns : [ [
		                   {
			field : 'ck',
			checkbox : true
		} 
		                   ] ],
		hideColumn : [ [ {
			field : 'deptCode',
			title : '部门编号',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns:[[{
			field : 'deptName',
			title : '部门名称',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'unitCode',
			title : '所属院区',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
			switch(val){
			case "2":
				return '南院区';
				break;
			case "1":
				return '北院区';
				break;
			default:
				return '无'
				break;
			}
				
			}
		}]],
		toolbar : [{
			text : '选择',
			iconCls : 'icon-add',
			handler : function() {
			var rows =$('#'+tab).datagrid('getSelections');
			if (rows == null || rows.length == 0) {
				$.messager.alert('提示', '请选中需要添加的项!', 'info');
				return false;	
			}else{
				var deptCode=[];
				var deptName=[];
				for(var i=0;i<rows.length;i++){
					deptCode.push(rows[i].deptCode);
					deptName.push(rows[i].deptName);
				}
				$("#"+id0).val(deptCode.toString());
				$("#"+id1).val(deptName.toString());
				$("#"+panel).panel('close');
				$('#'+tab).datagrid("clearSelections");
			 }
			}
		}],
//		onDblClickRow : function(index, row) {
//			$("#"+id0).val(row.deptCode);
//			$("#"+id1).val(row.deptName);
//			$("#"+panel).panel('close');
//			$('#'+tab).datagrid("clearSelections");
//		}
	});
	loadData(path+'/departmentaction!execute.action',tab, null);
}




