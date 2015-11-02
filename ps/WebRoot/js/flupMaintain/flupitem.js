$(function() {
	
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
	
	
	
	// 制表
	createTable();
	$("#upd_group_div").panel('close');
	$("#add_group_div").panel('close');
		/*$('#item_name').keyup(function(){
			var param = {'map.itemName':$('#item_name').val()}
			loadData(
					path+'/flupgroupaction!queryPages.action',
					'flupitem_table', param);
		});*/
		/*$('#group_one').keyup(function(){
			var param = {'map.searchType':$('#group_one').val()}
			loadData(path+'/flupgroupaction!queryPages.action','flupitem_table', param);
		});*/
	$('#add_group_one').keyup(function(){
		var param = {'map.searchType':$('#add_group_one').val()}
			loadData(path+'/flupgroupaction!queryGroupOne.action','add_group_tab', param);
	});
	$('#upd_group_one').keyup(function(){
		var param = {'map.searchType':$('#upd_group_one').val()}
			loadData(path+'/flupgroupaction!queryGroupOne.action','upd_group_tab', param);
	});
	$('#item_search').click(function() {
		var param = {
			'map.itemName' : $('#item_name').val(),
			'map.recordType' : $('#record_type').combobox('getValue'),
		    'map.dataType' : $('#data_type').combobox('getValue'),
			'map.searchType' : $('#group_one').val()
		}
		loadData(path+'/flupgroupaction!queryPages.action','flupitem_table', param);
	});
	// 添加项目
	$('#add_item').click(function(){
		var deptCode = $('#deptCode').combobox('getValue');
		if(deptCode==null || deptCode.length==0 || deptCode.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','所属科室不能为空！','error');
				return;
			}
		if($('#add_item_form').form('validate')){
			$.post(path+'/flupgroupaction!addGroup.action',{
				'flupGroup.itemName':$('#add_item_name').val(),
				'flupGroup.recordType':$('#add_record_type').combobox('getValue'),
				'flupGroup.dataType':$('#add_data_type').combobox('getValue'),
				'flupGroup.groupOne':$('#add_group_one').val(),
				'flupGroup.groupTwo':$('#add_group_two').val(),
				'flupGroup.groupThree':"",
				'flupGroup.itemPosi':$('#add_item_posi').combobox('getValue'),
				'flupGroup.itemRequired':$('#add_item_require').combobox('getValue'),
				'flupGroup.deptCode':deptCode
			},function(data){
				if(data.ok=='1'){
					$.messager.alert('提示', '操作成功!', 'info');
					clear('add');
					loadData(path+'/flupgroupaction!queryPages.action',
							'flupitem_table', null);
					$("#flupitem_table").datagrid("clearSelections");
					$("#add_flup_item").window("close");
				}else{
					$.messager.alert('提示', '此项随访项已经存在!', 'info');
					clear('add');
					loadData(path+'/flupgroupaction!queryPages.action',
							'flupitem_table', null);
					$("#flupitem_table").datagrid("clearSelections");
					//$("#add_flup_item").window("close");
				}
				
			},'json');
		}
	});
	
	
	$('#upd_item').click(function(){
		var rows=$('#flupitem_table').datagrid('getSelections');
		var deptCodeValue = $('#updateDeptCode').combobox('getValue');
		var obj = $('#updateDeptCode').combobox('getText');
		if(deptCodeValue==null || deptCodeValue.length==0 || deptCodeValue.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','所属科室不能为空！','error');
				return;
			}
		if($('#upd_item_form').form('validate')){
			$.post(path+'/flupgroupaction!updGroup.action',{
				'flupGroup.flupGroupId':rows[0].flupGroupId,
				'flupGroup.itemName':$('#upd_item_name').val(),
				'flupGroup.recordType':$('#upd_record_type').combobox('getValue'),
				'flupGroup.dataType':$('#upd_data_type').combobox('getValue'),
				'flupGroup.groupOne':$('#upd_group_one').val(),
				'flupGroup.groupTwo':$('#upd_group_two').val(),
				'flupGroup.groupThree':"",
				'flupGroup.itemPosi':$('#upd_item_posi').combobox('getValue'),
				'flupGroup.itemRequired':$('#upd_item_require').combobox('getValue'),
				'flupGroup.deptCode':$("#deptCodeId").val()
			},function(data){
				if(data.ok=='1'){
					$.messager.alert('提示', '操作成功!', 'info');
					clear('upd');
					loadData(path+'/flupgroupaction!queryPages.action',
							'flupitem_table', null);
					$("#flupitem_table").datagrid("clearSelections");
					$("#upd_flup_item").window("close");
				}else{
					$.messager.alert('提示', '此随访项已经存在!!', 'info');
					clear('upd');
					/****
					 * 修改后定位具体的页数
					 */
					var options = $('#flupitem_table').datagrid('getPager').data("pagination").options;  
					var curr = options.pageNumber; 
					loadData(path+'/flupgroupaction!queryPages.action',
							'flupitem_table', {'page.pageNo':curr});
					$("#flupitem_table").datagrid("clearSelections");
					$("#upd_flup_item").window("close");
				}
			},'json')
		}
	});
});
// 创建表格
function createTable() {
	$('#flupitem_table').datagrid(
					{
						collapsible : false,
						remoteSort : false,
						idField : 'flupGroupId',
						rownumbers : true,
						singleSelect : true,
						title : '随访信息',
						pagination : true,
						pageSize : 10,
						fitColumns : true,
						pageList : [ 10, 20],
						hideColumn : [ [ {
							field : 'flupGroupId',
							title : '编号',
							width : 100,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						},{
							field : 'deptCode',
							title : '科室编码',
							width : 100,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						},{
							field : 'itemRequired',
							title : '文本情况',
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
							width : 320,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						} ] ],
						columns : [ [  {
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
							width : 180,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						},{
							field : 'recordType',
							title : '记录方式',
							width : 80,
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
							     case "ts":
							    	return '提示';
							    	break;
							    }
							}
						}, {
							field : 'dataType',
							title : '数据类型',
							width : 50,
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
							field : 'department',
							title : '所属科室',
							width : 80,
							align : 'left',
							formatter : function(val, rec) {
							    return val;
							}
						}, {
							field : 'logDate',
							title : '操作日期',
							width : 80,
							align : 'left',
							formatter : function(val, rec) {
								return val.substring(0,10);
							}
						},{
							field : 'itemRequired',
							title : '是否必填',
							width : 80,
							align : 'left',
							formatter : function(val, rec) {
								if(val=="1"){
									return "必填项";
								}else{
									return "非必填项";
								}
							}
						}, {
							field : 'employeeCode',
							title : '操作医生',
							width : 80,
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
									var rows = $('#flupitem_table').datagrid('getSelections');
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
									var rows = $('#flupitem_table').datagrid('getSelections');
									if (rows == null || rows.length == 0) {
										$.messager.alert('提示', '请选中需要删除的项!', 'info');
										return false;
									} else {
										$.messager.confirm('提示', '您确定要进行删除操作吗?', function(r) {
											if (r) {
												deleteItem(rows[0].flupGroupId);
											}
										});
									  }
									}
								} ]
					});
	loadData(path+'/flupgroupaction!queryPages.action',
			'flupitem_table', null);
}
// 添加窗口打开
function add_item_winopen() {
	$("#add_flup_item").window("open");
}
function update_item_winopen(rows){
	$("#upd_flup_item").window("open");
	$('#upd_item_name').val(rows[0].itemName);
	$('#upd_group_one').val(rows[0].groupOne);
	$('#upd_group_two').val(rows[0].groupTwo);
	$('#upd_group_three').val(rows[0].groupThree);
	$('#upd_record_type').combobox('setValue', rows[0].recordType);
	$('#upd_groupshowno').val(rows[0].groupShowNo);
	$('#upd_data_type').combobox('setValue', rows[0].dataType);
	$('#upd_item_posi').combobox('setValue', rows[0].itemPosi);
	$('#upd_item_require').combobox('setValue', rows[0].itemRequired);
	$('#updateDeptCode').combobox('setValue', rows[0].department);
	$("#deptCodeId").val(rows[0].deptCode);
}
// 添加窗口关闭
function add_item_winclose() {
	$("#add_flup_item").window("close");
	clear('add');
}
function upd_item_winclose() {
	$("#upd_flup_item").window("close");
	clear('upd');
}

// 删除项目
function deleteItem(flupGroupId){
	$.post(path+'/flupgroupaction!delGroup.action',{'flupGroup.flupGroupId':flupGroupId},function(data){
		//if(data.ok=='1'){
			$.messager.alert('提示', '删除成功!', 'info');
			$('#flupitem_table').datagrid('clearSelections');
			loadData(path+'/flupgroupaction!queryPages.action',
					'flupitem_table', null);
			clear('add');
		//}
	});
}
function clear(type){
	$('#'+type+'_item_name').val('');
	$('#'+type+'_groupshowno').val('');
	$('#'+type+'_group_one').val('');
	$('#'+type+'_group_two').val('');
	$('#'+type+'_group_three').val('');
	$('#flupitem_table').datagrid('clearSelections');
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
		}/*, {
			field : 'groupThree',
			title : 'III级',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}*/]],
		onClickRow : function(index, row) {
			$('#'+type+'_group_one').val(row.groupOne);
			$('#'+type+'_group_two').val(row.groupTwo);
			//$('#'+type+'_group_three').val(row.groupThree);
			$('#'+type+'_group_div').panel('close');
		}
	});
	loadData(path+'/flupgroupaction!queryGroupOne.action',
			type+'_group_tab', null);
}
window.setInterval(closePanel, 1000);
function closePanel(){
    if(document.activeElement.id!='add_group_one'){
    	$('#add_group_div').panel('close');
    }
    if(document.activeElement.id!='upd_group_one'){
    	$('#upd_group_div').panel('close');
    }
}


