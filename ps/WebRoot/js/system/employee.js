var jobnum="";
$(function() {
	$("#dept_div").panel('close');
	$("#add_dept_div").panel('close');
	$("#upd_dept_div").panel('close');
	createTable();
	loadData(path+'/employeeAction!queryPages.action',
			'emp_list_tab', null);
	
	$('#name').keyup(function(){
		var param = {
				'map.name' : $('#name').val(),
			}
		loadData(path+'/employeeAction!queryPages.action',
				'emp_list_tab', param);
	});
	
	$('#deptName').keyup(function(){
		var param = {
				'map.deptName' : $('#deptName').val(),
			}
		loadData(path+'/departmentaction!execute.action',
				'dept_tab', param);
	});
	$('#add_deptName').keyup(function(){
		var param = {
				'map.deptName' : $('#add_deptName').val(),
			}
		loadData(path+'/departmentaction!execute.action',
				'add_dept_tab', param);
	});
	
	$('#upd_deptName').keyup(function(){
		var param = {
				'map.deptName' : $('#upd_deptName').val(),
			}
		loadData(path+'/departmentaction!execute.action',
				'upd_dept_tab', param);
	});
	
	$('#jobnum').keyup(function(){
		var param = {
				'map.jobnum' : $('#jobnum').val(),
			}
		loadData(path+'/employeeAction!queryPages.action',
				'emp_list_tab', param);
	});
	$.post(path+'/roleaction!findRoleList.action',{'':''},function(data){
		if (data != null) {
			var ids=['roleCode','add_roleCode','upd_roleCode'];
			for(var j=0;j<ids.length;j++){	
				$('#'+ids[j]).empty();
				var ops = '<option value="">不限</option>';
				for ( var i = 0; i < data.length; i++) {
					ops += '<option value="' + data[i].roleCode + '">'
							+ data[i].text + '</option>';
				}
				$('#'+ids[j]).append(ops);
			}
			}
	},'json');
	
	
	
	
});
function createTable() {
	$('#emp_list_tab').datagrid( {
		collapsible : false,
		remoteSort : false,
		idField : 'jobnum',
		rownumbers : true,
		singleSelect : true,
		title : '员工信息',
		pagination : true,
		pageSize : 10,
		fitColumns : true,
		pageList : [ 10, 20,50],
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		hideColumn : [ [ {
			field : 'jobnum',
			title : '工号',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns : [ [ {
			field : 'jobnum',
			title : '工号',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'name',
			title : '姓名',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'department',
			title : '科室',
			width : 350,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'roleName',
			title : '角色',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'title',
			title : '职称',
			width : 200,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'position',
			title : '职务',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'contactNumber',
			title : '联系电话',
			width : 200,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'mobilePhone',
			title : '手机',
			width : 100,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'status',
			title : '状态',
			width : 80,
			align : 'left',
			formatter : function(val, rec) {
			switch (val){
				case 0:
					return '<font color="red">停用</font>'
					break;
				case 1:
					return '<font color="green">正常</font>'
					break;
			}
		}
		},{
			field : 'unitCode',
			title : '院区',
			width : 200,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		}] ],
		toolbar : [{
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
			emp_add_open();
			}
		},{
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
			var rows = $('#emp_list_tab').datagrid('getSelections');
			if (rows == null || rows.length == 0) {
				$.messager.alert('提示', '请选中需要修改的项!', 'info');
				return false;	
			}else{
				update_emp(rows)
			 }
			}
		}],onLoadSuccess:function(index,row){
		
	}
	});	
}
function emp_search() {
	var dept_code="";
	if($('#deptName').val()==""){
		dept_code="";
	}else{
		dept_code=$('#deptCode').val();
	}
	var param = {
			'map.jobnum' :$('#jobnum').val(),
			'map.name' : $('#name').val(),
			'map.deptCode' : dept_code,
			'map.roleCode' :$('#roleCode').val(),
			'map.status' : $('#status').combobox(
			'getValue'),
			'map.mobilePhone':$('#mobilePhone').val(),
			'map.contactNumber':$('#contactNumber').val(),
			'map.title':$('#title').val()
		}
	loadData(path+'/employeeAction!queryPages.action',
			'emp_list_tab', param);
}
function emp_add_open(){
	var param = {
			'map.deptName' : '',
		}
	loadData(path+'/departmentaction!execute.action',
			'add_dept_tab', param);
	$("#emp_manager").window("open");
	clear('add');
}
function emp_add_close(){
	$("#emp_manager").window("close");
	clear('add');
}


function emp_upd_close(){
	$("#upd_manager").window("close");
	clear('upd');
	
}

function add_emp(){
	if($('#add_form').form('validate')){
		var pam={
				'jobnum':$('#add_jobnum').val(),
				'name':$('#add_name').val(),
				'deptCode' : $('#add_deptCode').val(),
				'unitCode' : $('#add_unitCode').val(),
				'roleCode':$('#add_roleCode').val(),
				'mobilePhone':$('#add_mobilePhone').val(),
				'title':$('#add_title').val(),
				'position':$('#add_position').val(),
				'contactNumber':$('#add_contactNumber').val(),
				'status':$('#add_status').combobox(
				'getValue')
		}
		$.post(path+'/employeeAction!addEmp.action',pam,function(data){
			if(data.ok=='1'){
					$.messager.alert('提示', '操作成功!', 'info');
					emp_add_close();
					emp_search();
					clear('add')
					$('#emp_list_tab').datagrid("clearSelections");
			}
		},'json');
	}
}
function upd_emp(){
	if($('#upd_form').form('validate')){
		var pam={
				'jobnum':$('#upd_jobnum').val(),
				'name':$('#upd_name').val(),
				'deptCode' : $('#upd_deptCode').val(),
				'roleCode':$('#upd_roleCode').val(),
				'mobilePhone':$('#upd_mobilePhone').val(),
				'title':$('#upd_title').val(),
				'position':$('#upd_position').val(),
				'contactNumber':$('#upd_contactNumber').val(),
				'status':$('#upd_status').combobox(
				'getValue')
		}
		$.post(path+'/employeeAction!updEmp.action',pam,function(data){
			if(data.ok=='1'){
					$.messager.alert('提示', '操作成功!', 'info');
					emp_upd_close();
					
					/****
					 * 修改后定位具体的页数
					 */
					var options = $('#emp_list_tab').datagrid('getPager').data("pagination").options;  
					var curr = options.pageNumber;  
					
					var dept_code="";
					if($('#deptName').val()==""){
						dept_code="";
					}else{
						dept_code=$('#deptCode').val();
					}
					var param = {
							'map.jobnum' :$('#jobnum').val(),
							'map.name' : $('#name').val(),
							'map.deptCode' : dept_code,
							'map.roleCode' :$('#roleCode').val(),
							'map.status' : $('#status').combobox('getValue'),
							'map.mobilePhone':$('#mobilePhone').val(),
							'map.contactNumber':$('#contactNumber').val(),
							'map.title':$('#title').val(),
							'page.pageNo':curr
						}
					loadData(path+'/employeeAction!queryPages.action',
							'emp_list_tab', param);
					clear('upd')
					$('#emp_list_tab').datagrid("clearSelections");
			}
		},'json');
	}
	
}

function update_emp(rows){
	$('#upd_jobnum').val(rows[0].jobnum);
	$('#upd_name').val(rows[0].name);
	$('#upd_deptCode').val(rows[0].deptCode);
	$('#upd_deptName').val(rows[0].department);
	$('#upd_roleCode').val(rows[0].roleCode);
	$('#upd_mobilePhone').val(rows[0].mobilePhone);
	$('#upd_title').val(rows[0].title);
	$('#upd_position').val(rows[0].position);
	$('#upd_contactNumber').val(rows[0].contactNumber);
	$('#upd_status').combobox('setValue', rows[0].status)
	$("#upd_manager").window("open");
	var param = {
				'map.deptName' : $('#upd_deptName').val(),
			}
	loadData(path+'/departmentaction!execute.action',
				'upd_dept_tab', param);
}
function openDeptTable(id){
	if(id=="deptName"){
	var param = {
				'map.deptName' : '',
		}
	loadData(path+'/departmentaction!execute.action',
				'dept_tab', param);	
	$("#dept_div").panel('open');
	createDeptTable1("dept_tab","deptCode","deptName","dept_div");
	 var position = $("#deptName").offset();
		$("#dept_div").offset( {
			top : position.top + 20,
			left : position.left
		});
	}else if(id=="add_deptName"){
	 $("#add_dept_div").panel('open');
		createDeptTable("add_dept_tab","add_deptCode","add_deptName","add_dept_div");
		var position = $("#add_deptName").offset();
		    $("#add_dept_div").offset( {
				top : position.top + 20,
				left : position.left
			});
	}else if(id=="upd_deptName"){
		 $("#upd_dept_div").panel('open');
			createDeptTable("upd_dept_tab","upd_deptCode","upd_deptName","upd_dept_div");
			var position = $("#upd_deptName").offset();
			    $("#upd_dept_div").offset( {
					top : position.top + 20,
					left : position.left
				});
		}
}
function createDeptTable1(tab,id0,id1,panel){
	$('#'+tab).datagrid({
		collapsible : false,
		remoteSort : false,
		idField : 'deptCode',
		singleSelect : false,
		pageSize : 10,
		fitColumns : true,
		singleSelect: true,
		frozenColumns : [ [ 
//		                    {
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
	loadData(path+'/departmentaction!execute.action',
			tab, null);
}


var timer=null;
$("#deptName").blur(function (){
	clearInterval(timer);
	if(!$("#dept_div").hasClass("hover")){
		timer=setTimeout(function (){
			$('#dept_div').panel('close');
		}, 300);
	}
});

$("#deptName").focus(function (){
	clearInterval(timer);
	setTimeout(function (){
		$('#dept_div').panel('open');
	}, 300);
});

$("#dept_div").hover(function(){
	clearInterval(timer);
	$(this).addClass("hover");
	},function(){ 
		$(this).removeClass("hover");
		if(document.activeElement.id!='deptName'){
			$('#dept_div').panel('close');
		}
});

function keyMove(e){
	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
	  var odiv=document.getElementById('dept_div');
	  var left =odiv.getBoundingClientRect().left;
	  var top = odiv.getBoundingClientRect().top;
	  
	  var odiv1=document.getElementById('upd_dept_div');
	  var left1 =odiv1.getBoundingClientRect().left;
	  var top1 = odiv1.getBoundingClientRect().top;
	  
	  var odiv2=document.getElementById('add_dept_div');
	  var left2 =odiv2.getBoundingClientRect().left;
	  var top2 = odiv2.getBoundingClientRect().top;
	 if(x<left||x>(left+300)){
		  $("#dept_div").panel('close');
	}else if(y<(top-20)||y>(top+100)){
		$("#dept_div").panel('close');
	}
	 if(x<left1||x>(left1+300)){
		  $("#upd_dept_div").panel('close');
	}else if(y<(top1-20)||y>(top1+100)){
		$("#upd_dept_div").panel('close');
	}
	 if(x<left2||x>(left2+300)){
		  $("#add_dept_div").panel('close');
	}else if(y<(top2-20)||y>(top2+100)){
		$("#add_dept_div").panel('close');
	}
	 
	 
	 
};
function clear(type){
	$('#'+type+'_name').val('');
	$('#'+type+'_mobilePhone').val('');
	$('#'+type+'_deptName').val();
	$('#'+type+'_deptCode').val();
	$('#'+type+'_title').val('');
	$('#'+type+'_position').val('');
	$('#'+type+'_contactNumber').val('');
	$('#'+type+'_jobnum').val('');
	$("#emp_list_tab").datagrid("clearSelections");
}



function createDeptTable(tab,id0,id1,panel){
	$('#'+tab).datagrid({
		collapsible : false,
		remoteSort : false,
		idField : 'deptCode',
		pageSize : 10,
		fitColumns : true,
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
				var unitCode=[];
				var south=0;
				var north=0;
				for(var i=0;i<rows.length;i++){
					deptCode.push(rows[i].deptCode);
					deptName.push(rows[i].deptName);
					//判断科室是属于南院还是北院，已存在的则不再添加
					if(south<1 && rows[i].unitCode=='2'){
						unitCode.push(rows[i].unitCode);
						south++;
					}
					if(north<1 && rows[i].unitCode=='1'){
						unitCode.push(rows[i].unitCode);
						north++;
					}
				}
				$("#"+id0).val(deptCode.toString());
				$("#"+id1).val(deptName.toString());
				$("#add_unitCode").val(unitCode.toString());
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