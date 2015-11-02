var type = '1';
var selected;
$(function() {
	//初始化加载数据
	loadData(path+'/blacklistaction.action','data_grid',null);
	//查询按钮
	$('#query').click(function(){
		if(type=='1'){
			$("#btnsearchTwo").linkbutton("enable"); //开启--加入黑名单
			$("#btnsearch").linkbutton("disable"); //关闭--撤销黑名单
		}else if(type=='0'){
			$("#btnsearch").linkbutton("enable"); //开启--加入黑名单
			$("#btnsearchTwo").linkbutton("disable"); //关闭--撤销黑名单
		}
		var patiSerial = $('#patiSerial').val();
		var inpatiNumber = $('#inpatiNumber').val();
		var medicalInsuranceCode = $('#medicalInsuranceCode').val();
		var name = $('#name').val();
		var state = type;
		var param  = {'map.patiSerial' : patiSerial,'map.inpatiNumber' : inpatiNumber,'map.medicalInsuranceCode' : medicalInsuranceCode,'map.name' : name,'map.state':state};
		loadData(path+'/blacklistaction.action','data_grid',param); 
	});
	//加入黑名单
	$('#sava').click(function(){
		var arr = "";//ID
		var pati_serial = "";//病人编号
		var inpati_number = "";//住院号
		for(var i=0;i<selected.length;i++){
			arr +=  i!=selected.length-1 ? selected[i].id+"," : selected[i].id;
			pati_serial += i!=selected.length-1 ? selected[i].patiSerial+"," : selected[i].patiSerial;
			inpati_number += i!=selected.length-1 ? selected[i].inpatiNumber+"," : selected[i].inpatiNumber;
		}
		var content = $('#content').val();
		if(content == null || content.length == 0 || content.replace(/\s/g,"").length==0){
			 $.messager.alert('警告！','原因不能为空！','error');
			return;
		}
		$.messager.confirm('提示','确认添加？',function(r){
			if(r){
				$.post(
					path+"/blacklistaction!addBlakList.action",
					{
						content : content,
						id : arr,
						patiSerial : pati_serial,
						inpatiNumber : inpati_number
					},
					function(data){
						if(data=='success')
						{
							$.messager.alert('消息','添加成功','info');
							window.location.reload();
						}else{
							$.messager.alert('消息','添加失败','error');
						}
					},'text'
				);
			}
		});
		
	});
	var ids = [];
	$('#data_grid').datagrid( {
		method : 'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		title : '黑名单管理',
		striped : true,
		pagination : true,
		pageSize : 10,
		fitColumns:true,
		pageList : [ 10, 20 ],
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},
		{
			field : 'id',
			hidden:true
		}, 
		{
			field : 'patiSerial',
			title : '病人编号',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, 
		{
			field : 'medicalInsuranceCode',
			title : '医保编号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}
		, {
			field : 'inpatiNumber',
			title : '住院号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns : [ [ {
			field : 'idNumber',
			title : '身份证号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'name',
			title : '姓名',
			width : 40,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'gender',
			title : '性别',	
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
				return val == '1' ? '男' : '女';
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
			field : 'addReasons',
			title : '加入黑名单原因',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				
				return val!=null && val!='' ? val : '---';
			}
		}, {
			field : 'state',
			title : '状态',
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
				return val!="" && val!=null  && val.length!=0 ? (val == 0 ? "正常" : "黑名单") : '正常';
			}
		} ] ],
		toolbar : [ {
			id : 'btnsearch',
			text : '加入黑名单',
			type : 'menubutton',
			iconCls : 'icon-edit',
			disabled : true,
			menu : '#mm',
			handler : function() {
			 	selected = $('#data_grid').datagrid('getSelections');
			 	if(selected.length!=0){
			 	
			 		for(var i=0;i<selected.length;i++){
			 			if(selected[i].state=='1'){
			 				$.messager.alert('消息','已经是黑名单的用户不能被加入','error');
			 				return false;
			 			}
			 		}
					$("#add_black").window("open");			 	
			 	}else{
			 		$.messager.alert('消息','请选择加入黑名单列','error');
			 	}
				
			}
		}, {
			id : 'btnsearchTwo',
			text : '撤销黑名单',
			type : 'menubutton',
			iconCls : 'icon-undo',
			menu : '#mm',
			handler : function() {
				selected = $('#data_grid').datagrid('getSelections');
				if(selected.length==0){
					$.messager.alert('消息','请选择撤销黑名单列','error');
					return;
				}else{
				
					for(var i=0;i<selected.length;i++){
			 			if(selected[i].state=='0'){
			 				$.messager.alert('消息','被选中的用户是正常状态，不能被撤销','error');
			 				return false;
			 			}
			 		}
				}
				var  arr="";
				var pati_serial = "";//病人编号
				var inpati_number = "";//住院号
				for(var i=0;i<selected.length;i++){
					arr +=  i!=selected.length-1 ? selected[i].id+"," : selected[i].id;
					pati_serial += i!=selected.length-1 ? selected[i].patiSerial+"," : selected[i].patiSerial;
					inpati_number += i!=selected.length-1 ? selected[i].inpatiNumber+"," : selected[i].inpatiNumber;
				}
				$.messager.confirm("提示","确认撤销黑名单？",function(r){
						if(r){
					
									$.post(
									path+"/blacklistaction!deleteBlackList.action",
									{
										id : arr,
										patiSerial : pati_serial,
										inpatiNumber : inpati_number
									},
									function(data){
										if(data=='success')
										{
											$.messager.alert('消息','撤销成功','info');
											window.location.reload();
										}else{
											$.messager.alert('消息','撤销失败','error');
										}
									},'text'
									);
									}
				});
				
			}
		} ],
		onLoadSuccess : function(data) {
			if (data) {
				$.each(data.rows, function(index, item) {
					if (item.checked) {
						ids.push(index);
					}
				});
			}
		}
			});
		
});










//点击按钮变颜色	
var o='';
function changecolor(obj){
		if(o!=obj && o!=''){	
			o.style.border='';
			o.style.color='black';
		}
		obj.style.border='1px solid #cccccc';
		obj.style.color='red';
		o=obj;
		type = $(obj).attr("rel");
		
	}

