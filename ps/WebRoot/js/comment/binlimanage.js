$(function() {
	setposition();
	$("#dept_div").panel('close');
	createDeptTable();
	$('#search').click(function() {
		var dept_code="";
		if($('#dept_name').val()==""){
			dept_code="";
		}else{
			dept_code=$('#dept_code').val();
		}
		var param = {
			"map.flupStatus" : $('#flup_status').combobox(
			'getValue'),
			"map.deptCode" : dept_code,
			"map.name" : $('#name').val(),
			"map.inpatiNumber" : $('#inpati_number').val(),
			"map.outHospitalDate" : $('#out_hospital_date').val()
		}
		loadData(path + '/patiAction!queryPages.action', 'blm_grid', param);
	});
	$('#out_hospital_date').click(function() {
		WdatePicker( {
			maxDate : '%y-%M-%d'
		});
	});
	$('#dept_name').keyup(function(){
		var param = {
				'map.deptName' : $('#dept_name').val(),
			}
		loadData(path+'/departmentaction!execute.action',
				'dept_tab', param);
	});
	createTable();
});

function createTable() {
	$('#blm_grid').datagrid( {
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		singleSelect : true,
		title : '病例管理',
        width:'100%',
		pagination : true,
		pageSize : 20,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'inpatiNumber',
			title : '住院号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'name',
			title : '姓名',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns : [ [ {
			field : 'gender',
			title : '性别',
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
			alert(val);
				switch (val) {
				case "1":
					return '男';
					break;
				case "2":
					return '女';
					break;
				case "3":
					return '未知'
					break;
				}
			}
		}, {
			field : 'age',
			title : '年龄',
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'department',
			title : '所属科室',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'diag',
			title : '主要诊断',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'billingCode',
			title : '付费方式',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'flupStatus',
			title : '随访状态',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'flupWay',
			title : '随访方式',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'outHospitalDate',
			title : '出院日期',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		toolbar : [ {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				var rows = $('#blm_grid').datagrid('getSelections');
				var ids = [];
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
				}
				if (ids == null || ids.length == 0) {
					$.messager.alert('提示', '请选中需要删除的项!', 'info');
				} else {
					$.messager.confirm('提示', '您确定要进行删除操作吗?', function(r) {
						if (r) {
							$.post(path + '/patiAction!delPati.action', {
								'ids' : ids.toString()
							}, function(data) {
								if (data.ok > 0) {
									$.messager.alert('提示', '删除成功!', 'info');
									// 清空选中项
									$('#blm_grid').datagrid('clearSelections');
									loadData(path + '/patiAction!queryPages.action', 'blm_grid', null);
								}

							}, 'json');
						}
					});
				}
			}
		}, '-', {
			text : '导入',
			iconCls : 'icon-save',
			handler : function() {

			}
		} ]
	});
	loadData(path + '/patiAction!queryPages.action', 'blm_grid', null);
}
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
function setposition() {
	var position = $("#dept_name").offset();
	$("#dept_div").offset( {
		top : position.top + 20,
		left : position.left
	});
}
function openDeptTable(){
	$("#dept_div").panel('open');
}
function createDeptTable(){
	$('#dept_tab').datagrid({
		collapsible : false,
		remoteSort : false,
		idField : 'deptCode',
		singleSelect : true,
		pageSize : 20,
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
		}]],
		onClickRow : function(index, row) {
			$("#dept_code").val(row.deptCode);
			$("#dept_name").val(row.deptName);
			$("#dept_div").panel('close');
		}
	});
	loadData(path+'/departmentaction!execute.action',
			'dept_tab', null);
}