$(function() {
	
	/****
	 * 加载科室
	 */
	$.ajax({
        type: "post",
        url: 'flupnamedictaction!loadCombobox.action',
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
        	$('#updateDeptCode').combogrid({    
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
        }
	
	});
	
	
	$('#add_list_value_td').hide();
	$('#upd_list_value_td').hide();
	// 制表
	createTable();
	$("#upd_group_div").panel('close');
	$("#add_group_div").panel('close');
	$("#add_dept_div").panel('close');
	$("#upd_dept_div").panel('close');
		/*$('#item_name').keyup(function(){
			var param = {'map.itemName':$('#item_name').val()}
			loadData(path+'/diseaseItemAction!queryPages.action','diseaseitem_table', param);
		  });
		  $('#group_one').keyup(function(){
			var param = {'map.groupOne':$('#group_one').val()}
			loadData(path+'/diseaseItemAction!queryPages.action','diseaseitem_table', param);
		  });*/
	    $('#add_group_one').keyup(function(){
		var param = {'map.oneSearchType':$('#add_group_one').val()}
			loadData(path+'/diseaseItemAction!queryGroupOne.action','add_group_tab', param);
	   });
	   $('#upd_group_one').keyup(function(){
		var param = {'map.oneSearchType':$('#upd_group_one').val()}
			loadData(path+'/diseaseItemAction!queryGroupOne.action','upd_group_tab', param);
	   });
	   
	   $('#add_dept_name').keyup(function(){
			var param = {
					'map.deptName' : $('#add_dept_name').val(),
				}
			loadData(path+'/departmentaction!execute.action',
					'add_dept_tab', param);
		});
	   
	   $('#upd_dept_name').keyup(function(){
			var param = {
					'map.deptName' : $('#upd_dept_name').val(),
				}
			loadData(path+'/departmentaction!execute.action',
					'upd_dept_tab', param);
		});
	   
	$('#item_search').click(function() {
		var param = {
			'map.itemName' : $('#item_name').val(),
			'map.recordType' : $('#record_type').combobox('getValue'),
		    'map.dataType' : $('#data_type').combobox('getValue'),
			'map.groupOne' : $('#group_one').val()
		}
		loadData(path+'/diseaseItemAction!queryPages.action','diseaseitem_table', param);
	});
	// 添加项目
	$('#add_item').click(function(){
		var deptCode = $('#deptCode').combobox('getValue');
		if(deptCode==null || deptCode.length==0 || deptCode.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','所属科室不能为空！','error');
				return;
			}
		if($('#add_item_form').form('validate')){
			$.post(path+'/diseaseItemAction!addDis.action',{
				'diseaseItem.itemName':$('#add_item_name').val(),
				'diseaseItem.groupShowNo':$('#add_groupshowno').val(),
				'diseaseItem.recordType':$('#add_record_type').val(),
				'diseaseItem.dataType':$('#add_data_type').combobox('getValue'),
				'diseaseItem.groupOne':$('#add_group_one').val(),
				'diseaseItem.deptCode':deptCode,
				'diseaseItem.groupTwo':$('#add_group_two').val(),
				'diseaseItem.listValue':$('#add_list_value').val(),
				'diseaseItem.itemPosi':$('#add_item_posi').combobox('getValue')
			},function(data){
				if(data.ok=='1'){
					$.messager.alert('提示', '添加成功!', 'info');
					clear('add');
					$("#diseaseitem_table").datagrid("clearSelections");
					$("#add_dis_item").window("close");
					loadData(path+'/diseaseItemAction!queryPages.action','diseaseitem_table',null);
				}else{
					$.messager.alert('提示', '此项疾病项已经存在', 'info');
					clear('add');
					$("#diseaseitem_table").datagrid("clearSelections");
					$("#add_dis_item").window("close");
					loadData(path+'/diseaseItemAction!queryPages.action','diseaseitem_table',null);
				}
			},'json')
		}
	});
	$('#add_record_type').change(function(){
		if($('#add_record_type').val()=='xlk'){
			$('#add_list_value_td').show();
		}else{
			$('#add_list_value_td').hide();
		}
	});
	$('#upd_record_type').change(function(){
		if($('#upd_record_type').val()=='xlk'){
			$('#upd_list_value_td').show();
		}else{
			$('#upd_list_value_td').hide();
		}
	});
	$('#upd_item').click(function(){
		var rows=$('#diseaseitem_table').datagrid('getSelections');
		var deptCodeValue = $('#updateDeptCode').combobox('getValue');
		var obj = $('#updateDeptCode').combobox('getText');
		if(deptCodeValue==null || deptCodeValue.length==0 || deptCodeValue.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','所属科室不能为空！','error');
				return;
			}
		var listValue="";
		if($('#upd_record_type').val()!=null && $('#upd_record_type').val()=="xlk"){
			listValue = $('#upd_list_value').val();
		}
		var options = $('#diseaseitem_table').datagrid('getPager').data("pagination").options;  
		var curr = options.pageNumber; 
		if($('#upd_item_form').form('validate')){
			$.post(path+'/diseaseItemAction!updDis.action',{
				'diseaseItem.diseaseGroupId':rows[0].diseaseGroupId,
				'diseaseItem.itemName':$('#upd_item_name').val(),
				'diseaseItem.groupShowNo':$('#upd_groupshowno').val(),
				'diseaseItem.recordType':$('#upd_record_type').val(),
				'diseaseItem.dataType':$('#upd_data_type').combobox('getValue'),
				'diseaseItem.deptCode':deptCodeValue,
				'diseaseItem.groupOne':$('#upd_group_one').val(),
				'diseaseItem.groupTwo':$('#upd_group_two').val(),
				'diseaseItem.listValue':listValue,
				'diseaseItem.itemPosi':$('#upd_item_posi').combobox('getValue')
			},function(data){
				if(data.ok=='1'){
					
					$.messager.alert('提示', '修改成功!', 'info');
					clear('upd');
					$("#diseaseitem_table").datagrid("clearSelections");
					$("#upd_dis_item").window("close");
					loadData(path+'/diseaseItemAction!queryPages.action','diseaseitem_table', {'page.pageNo':curr});
				}else{
					$.messager.alert('提示', '此项随访项已经存在!', 'error');
					clear('upd');
					loadData(path+'/diseaseItemAction!queryPages.action','diseaseitem_table',null);
					$("#diseaseitem_table").datagrid("clearSelections");
					//$("#add_flup_item").window("close");
				}
			},'json')
		}
	});
});
// 创建表格
function createTable() {
	$('#diseaseitem_table').datagrid(
					{
						collapsible : false,
						remoteSort : false,
						idField : 'diseaseGroupId',
						rownumbers : true,
						singleSelect : true,
						title : '患者指标信息',
						pagination : true,
						pageSize : 10,
						fitColumns : true,
						pageList : [ 10, 20,50],
						hideColumn : [ [ {
							field : 'diseaseGroupId',
							title : '编号',
							width : 100,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						} ] ],
						frozenColumns : [ [ {
							field : 'ck',
							checkbox : true
						} ,{
							field : 'itemName',
							title : '项目名称',
							width : 150,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						},{
							field : 'deptName',
							title : '所属科室',
							width : 100,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						} ] ],
						columns : [ [  {
							field : 'groupOne',
							title : 'I级',
							width : 80,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'groupTwo',
							title : 'II级',
							width : 100,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'recordType',
							title : '记录方式',
							width : 60,
							align : 'left',
							formatter : function(val, rec) {
							 switch(val){
							    case "fx":
							    	return '复选';
							    	break;
							    case "dx":
							    	return '单选';
							    	break;
							    case "wb":
							    	return '文本';
							    	break;
							    case "xlk":
							    	return '下拉框';
							    	break;
							    }
							}
						}, {
							field : 'listValue',
							title : '下拉框值',
							width : 250,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						} ,{
							field : 'dataType',
							title : '数据类型',
							width : 60,
							align : 'left',
							formatter : function(val, rec) {
							    switch(val){
							    case "zf":
							    	return '字符';
							    	break;
							    case "zs":
							    	return '整数';
							    	break;
							    case "xs":
							    	return '小数';
							    	break;
							    case "rq":
							    	return '日期';
							    	break;
							    case "be":
							    	return '布尔';
							    	break;
							    }
							}
						}, {
							field : 'logDate',
							title : '操作日期',
							width : 70,
							align : 'left',
							formatter : function(val, rec) {
								return val.substring(0,10);
							}
						}, {
							field : 'employeeCode',
							title : '操作医生',
							width : 70,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						} ] ],
						toolbar : [
								{
									text : '新增',
									iconCls : 'icon-add',
									handler : function() {
										add_item_winopen();
									}
								},
								'-',
								{
									text : '修改',
									iconCls : 'icon-edit',
									handler : function() {
									var rows = $('#diseaseitem_table').datagrid('getSelections');
									if (rows == null || rows.length == 0) {
										$.messager.alert('提示', '请选中需要修改的项!', 'info');
										return false;	
									}else{
										update_item_winopen(rows);
									}
									}
								},
								'-',
								{
									text : '删除',
									iconCls : 'icon-cut',
									handler : function() {
									var rows = $('#diseaseitem_table').datagrid('getSelections');
									if (rows == null || rows.length == 0) {
										$.messager.alert('提示', '请选中需要删除的项!', 'info');
										return false;
									} else {
										$.messager.confirm('提示', '您确定要进行删除操作吗?', function(r) {
											if (r) {
												deleteItem(rows[0].diseaseGroupId);
											}
										});
									  }
									}
								} ]
					});
	loadData(path+'/diseaseItemAction!queryPages.action',
			'diseaseitem_table', null);
}
// 添加窗口打开
function add_item_winopen() {
	$("#add_dis_item").window("open");
}
function update_item_winopen(rows){
	$("#upd_dis_item").window("open");
	if(rows[0].recordType=='xlk'){
		$('#upd_list_value_td').show();
	}
	$('#upd_item_name').val(rows[0].itemName);
	$('#upd_group_one').val(rows[0].groupOne);
	$('#upd_group_two').val(rows[0].groupTwo);
	$('#upd_list_value').val(rows[0].listValue);
	$('#upd_dept_code').val(rows[0].deptCode);
	$('#upd_dept_name').val(rows[0].deptName);
	$('#upd_record_type').val(rows[0].recordType);
	$('#upd_groupshowno').val(rows[0].groupShowNo);
	$('#upd_data_type').combobox('setValue', rows[0].dataType);
	$('#upd_item_posi').combobox('setValue', rows[0].itemPosi);
}
// 添加窗口关闭
function add_item_winclose() {
	$("#add_dis_item").window("close");
	clear('add');
}
function upd_item_winclose() {
	$("#upd_dis_item").window("close");
	clear('upd');
}

// 删除项目
function deleteItem(diseaseGroupId){
	$.post(path+'/diseaseItemAction!delDis.action',{'diseaseItem.diseaseGroupId':diseaseGroupId},function(data){
		//if(data.ok=='1'){
			$.messager.alert('提示', '删除成功!', 'info');
			$('#diseaseitem_table').datagrid('clearSelections');
			loadData(path+'/diseaseItemAction!queryPages.action',
					'diseaseitem_table', null);
			clear('add');
		//}
	});
}
function clear(type){
	$('#'+type+'_item_name').val('');
	$('#'+type+'_groupshowno').val('');
	$('#'+type+'_group_one').val('');
	$('#'+type+'_group_two').val('');
	$('#'+type+'_list_value').val('');
	$('#'+type+'_dept_code').val('');
	$('#'+type+'_dept_name').val('');
	$('#diseaseitem_table').datagrid('clearSelections');
}



function openGroupTable(type){
     $('#'+type+'_group_div').panel('open');
     createGroupTable(type)
	 var position =$('#'+type+'_group_one').offset();
	 $('#'+type+'_group_div').offset( {
			top : position.top + 20,
			left : position.left
	 });
	
}

function createGroupTable(type){
	$('#'+type+'_group_tab').datagrid({
		collapsible : false,
		remoteSort : false,
		idField : 'groupOne',
		singleSelect : true,
		pageSize : 10,
		fitColumns : true,
		columns:[[{
			field : 'groupOne',
			title : 'I级',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'groupTwo',
			title : 'II级',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'groupThree',
			title : 'III级',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}]],
		onClickRow : function(index, row) {
			$('#'+type+'_group_one').val(row.groupOne);
			$('#'+type+'_group_two').val(row.groupTwo);
			$('#'+type+'_group_div').panel('close');
		}
	});
	loadData(path+'/diseaseItemAction!queryGroupOne.action',
			type+'_group_tab', null);
}
function openDeptTable(type){
	$('#'+type+'_dept_div').panel('open');
	createDeptTable(type)
	 var position =$('#'+type+'_dept_name').offset();
	 $('#'+type+'_dept_div').offset( {
			top : position.top + 20,
			left : position.left
	 });
	
	
	
}

function createDeptTable(type){
	$('#'+type+'_dept_tab').datagrid({
		collapsible : false,
		remoteSort : false,
		idField : 'deptCode',
		singleSelect : true,
		pageSize : 10,
		fitColumns : true,
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
		onClickRow : function(index, row) {
		$('#'+type+'_dept_code').val(row.deptCode);
		$('#'+type+'_dept_name').val(row.deptName);
		$('#'+type+'_dept_div').panel('close');
		}
	});
	loadData(path+'/departmentaction!execute.action',
			type+'_dept_tab', null);
}




window.setInterval(closePanel, 1000);
function closePanel(){
    if(document.activeElement.id!='add_group_one'){
    	$('#add_group_div').panel('close');
    }
    if(document.activeElement.id!='upd_group_one'){
    	$('#upd_group_div').panel('close');
    }
    if(document.activeElement.id!='add_dept_name'){
    	$('#add_dept_div').panel('close');
    }
    if(document.activeElement.id!='upd_dept_name'){
    	$('#upd_dept_div').panel('close');
    }
}


