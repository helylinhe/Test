$(function (){
	
	/****
	 * 加载厂家名称
	 */
	$.ajax({
        type: "post",
        url: path+'/platformTradelogaction!factoryList.action',
        dataType : "json",
        success: function(data){
			var html="<option value=''>全部</option>";
			for(var i=0;i<data.length;i++){
				html+="<option value='"+data[i].factoryNo+"'>"
				html+=data[i].factoryName
				html+="</option>";
			}
			$("#factoryno").html(html);
        }
    });
	
	/****
	 * 新增
	 */
	$.ajax({
		type: "post",
		url: path+'/platformTradelogaction!factoryList.action',
		dataType : "json",
		success: function(data){
		var html="<option value=''>全部</option>";
		for(var i=0;i<data.length;i++){
			html+="<option value='"+data[i].id+"'>"
			html+=data[i].factoryName
			html+="</option>";
		}
		$("#wfactory").html(html);
	}
	});
	
	/*****
	 * 修改
	 */
	$.ajax({
		type: "post",
		url: path+'/platformTradelogaction!factoryList.action',
		dataType : "json",
		success: function(data){
		var html="<option value=''>全部</option>";
		for(var i=0;i<data.length;i++){
			html+="<option value='"+data[i].id+"'>"
			html+=data[i].factoryName
			html+="</option>";
		}
		$("#updateWfactory").html(html);
	}
	});
	
	/***
	 * 加载业务名称
	 */
	$.ajax({
		type: "post",
		url: path+'/platformTradelogaction!busiList.action',
		dataType : "json",
		success: function(data){
		var html="<option value=''>全部</option>";
		for(var i=0;i<data.length;i++){
			html+="<option value='"+data[i].busiNo+"'>"
			html+=data[i].busiName
			html+="</option>";
		}
		$("#busino").html(html);
	}
	});
	
	
	/****
	 * 表格显示数据
	 */
	 var currentIndex=-1;
	$('#interfaces').datagrid( {
		method:'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : true,
	    title:'接口业务信息',
		pagination : true,
		pageSize:10,
        pageList:[10,20],
		columns : [[  
				{
					field : 'id',
					title : '业务id',
					width : 80,
					align : 'center',
					hidden:true
				},
				{
					field : 'factoryId',
					title : '厂家id',
					width : 80,
					align : 'center',
					hidden:true
				},
			{
				field : 'factoryName',
				title : '厂家名称',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			}, {
				field : 'busiNo',
				title : '业务编号',
			    width : 200,
				align : 'center',
				formatter : function(value,row,index) {
					return value;
				}
			}, {
			field : 'busiName',
			title : '业务名称',
		    width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'callNum',
			title : '日峰值',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'abnormalNum',
			title : '异常数',
			width : 100,
			align : 'center',
			formatter: function(value){
				return value;
			}
		},{
			field : 'busiState',
			title : '状态',
			width : 50,
			align : 'center',
			formatter : function(val,rec) {
				return val=='1' ? "<b style='color:blue'>可用</b>" : "<b style='color:red'>不可用</b>";
			}
		},{
			field : 'state',
			title : '操作',
			width : 100,
			align : 'center',
			formatter: function(value,row,index){
			return value=='1' ?  "<input type='button' value='关闭' onclick='updateState("+row.id+",0)'/>" : "<input type='button' value='开启' onclick='updateState("+row.id+",1)'/>";
			}
		}
		]],toolbar:[
					 {
						 text:'新增',
						 iconCls:'icon-add',
						 handler:function()
						 {
							 //新增随访记录
						 	$("#add_sftable_html").window("open");
						 	
						 }
                     },'-',{
                    	 
    						 text:'修改',
    						 iconCls:'icon-add',
    						 handler:function(){
                    	 	var rows = $("#interfaces").datagrid("getSelections");
                    	 	if(rows.length==0){
                    	 		$.messager.alert('提示', '请选择需要修改的项!', 'info');
								return false;
                    	 	}else{
                    	 		$("#update_sftable_html").window("open");
								var rows = $("#interfaces").datagrid("getSelections");
								$("#updateInteBusiId").val(rows[0].id);
								$("#updateBusiName").val(rows[0].busiName);
								$("#updateBusiNo").val(rows[0].busiNo);
								$("#updateCallNum").val(rows[0].callNum);
								$("#updateWfactory option[value='"+rows[0].factoryId+"']").attr("selected", "selected");
								$("#updateAbnormalNum").val(rows[0].abnormalNum);
                    	 	}
					        /*if(currentIndex==-1)
					        {
								$.messager.alert('提示', '请选择需要修改的项!', 'info');
								return false;
							} else 
							{
								$("#update_sftable_html").window("open");
								var rows = $("#interfaces").datagrid("getSelections");
								console.info(rows);
							}*/
		 }
                         
                     }],
		onClickRow : function(rowIndex, rowData) {
			if($("#flupType").combobox('getValue')=='0'){
				var rows = $("#keshisuifangratetable").datagrid("getRows");
				createHighcharts(rows, rowData.itemName, "全院");
			}else{
				var row = $("#keshisuifangratetable").datagrid("getSelected");
				$.ajax({
					type : "post",
					url : path + '/employeeAction!getDeptHigtChart.action',
					dataType : "json",
					data : {    
						        'map.flupTableNameId':$("#flupName").combogrid('getValue'),'map.deptCode': rowData.deptCode,
								'map.flupDateStart':$("#flupDateStart").datebox("getValue"),'map.flupDateEnd':$("#flupDateEnd").datebox("getValue"),
								'flupType':$("#flupType").combobox("getValue")
					},
					success : function(data) {
						
						createHighcharts(data[0].rows,row.deptName+'随访率统计' , row.deptName);
					}
				});
				
			}
		}
 }); 
	/****
	 * 加载数据
	 */
	loadData(path+'/platformTradelogaction!pageList.action','interfaces',null);
});

function search(){
	var busiNoValue=$("#busino").find("option:selected").val();
	var factoryNoValue=$("#factoryno").find("option:selected").val();
	var param={'map.busiNo':busiNoValue,'map.factoryNo':factoryNoValue};
	 loadData(path+'/platformTradelogaction!pageList.action','interfaces',param);
}



/*****
 * 保存业务信息
 * @param src
 * @param pos
 * @return
 */

function saveIntebusi(){
	var factoryId=$("#wfactory").find("option:selected").val();
	var busiNo=$("#busiNo").val();
	var busiName=$("#busiName").val();
	var callNum=$("#callNum").val();
	var abnormalNum=$("#abnormalNum").val();
	if(factoryId == null || factoryId==""){
		 $.messager.alert('警告！','厂家名称不能为空','error');
		return;
	}
	if(busiNo == null || busiNo==""){
		$.messager.alert('警告！','业务编号不能为空','error');
		return;
	}
	if(busiName == null || busiName==""){
		$.messager.alert('警告！','业务名称不能为空','error');
		return;
	}
	if(callNum == null || callNum==""){
		$.messager.alert('警告！','日峰值不能为空','error');
		return;
	}
	if(abnormalNum == null || abnormalNum==""){
		$.messager.alert('警告！','异常次数不能为空','error');
		return;
	}
	var param={'map.factoryId':factoryId,'map.busiNo':busiNo,'map.busiName':busiName,'map.callNum':callNum,'map.abnormalNum':abnormalNum};
	$.post(path+'/platformTradelogaction!addIntentBusi.action',param,function (data){
		if(data=="1"){
			$("#add_sftable_html").window("close");
			$.messager.alert('提示', '添加成功', 'info');
			loadData(path+'/platformTradelogaction!pageList.action','interfaces',null);
		}else{
			$.messager.alert('提示', '添加失败', 'error');
			loadData(path+'/platformTradelogaction!pageList.action','interfaces',null);
		}
		
	},'text');
}

/*****
 * 修改业务信息
 * @return
 */
function updateIntebusi(){
	var factoryId=$("#updateWfactory").find("option:selected").val();
	var busiNo=$("#updateBusiNo").val();
	var busiName=$("#updateBusiName").val();
	var callNum=$("#updateCallNum").val();
	var abnormalNum=$("#updateAbnormalNum").val();
	var inteId=$("#updateInteBusiId").val();
	if(factoryId == null || factoryId==""){
		 $.messager.alert('警告！','厂家名称不能为空','error');
		return;
	}
	if(busiNo == null || busiNo==""){
		$.messager.alert('警告！','业务编号不能为空','error');
		return;
	}
	if(busiName == null || busiName==""){
		$.messager.alert('警告！','业务名称不能为空','error');
		return;
	}
	if(callNum == null || callNum==""){
		$.messager.alert('警告！','日峰值不能为空','error');
		return;
	}
	if(abnormalNum == null || abnormalNum==""){
		$.messager.alert('警告！','异常次数不能为空','error');
		return;
	}
	var param={'map.factoryId':factoryId,'map.busiNo':busiNo,'map.busiName':busiName,'map.callNum':callNum,'map.abnormalNum':abnormalNum,'map.id':inteId};
	$.post(path+'/platformTradelogaction!updateIntBusi.action',param,function (data){
		if(data=="1"){
			$("#update_sftable_html").window("close");
			$.messager.alert('提示', '修改成功', 'info');
			loadData(path+'/platformTradelogaction!pageList.action','interfaces',null);
		}else{
			$.messager.alert('提示', '修改失败', 'error');
			loadData(path+'/platformTradelogaction!pageList.action','interfaces',null);
		}
		
	},'text');
}


/****
 * 操作修改
 * @param src
 * @param pos
 * @return
 */
function  updateState(id,statue){
	$.messager.confirm('info','确认修改状态？',function(r){
		if(r){
			$.post(
			path+"/platformTradelogaction!updateIntState.action",
			{
				"map.busiState" : statue,
				"map.id" : id 
			},
			function(data){
				
				$.messager.alert('消息',"修改成功",'info');
				loadData(path+'/platformTradelogaction!pageList.action','interfaces',null);
				
			},'text'
			);
		}
	});
}


function formatFloat(src, pos)
{
    return Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);
}


function createHighcharts(data, title, name) {
	console.info(data);
	var categories = new Array();
	var seriesDate = new Array();
	var text = '';
	var titleText = '';
	if (data.length == 0) {
		categories.push('');
		seriesDate.push('');
		text = '无图像';
		titleText = '';
	} else {
		text = '';
		titleText = data[0].resultUnit;
		for ( var int = 0; int < data.length; int++) {
			if(name=="全院"){
			categories.push(data[int].deptName);
			}else{
			categories.push(data[int].flupName);
			}
			seriesDate.push(parseFloat(formatFloat(data[int].complateCountUnum*100/data[int].totalCountNum,2)));
		}
	}

	$('#container').highcharts({
		chart : {
			type : 'spline'
		},
		title : {
			text : title
		},
		subtitle : {
			text : text
		},
		xAxis : {
			categories : categories,
			labels : {
				step : 1
			},
			tickInterval : 1
		},
		yAxis : {
			title : {
				text : '随访率(%)'
			},
			labels : {
				formatter : function() {
					return this.value;
				}
			}
		},
		tooltip : {
			crosshairs : true,
			shared : true
		},
		plotOptions : {
			spline : {
				marker : {
					radius : 4,
					lineColor : '#666666',
					lineWidth : 1
				}
			}
		},
		series : [ {
			name : name,
			data : seriesDate
		} ]
	});

}
