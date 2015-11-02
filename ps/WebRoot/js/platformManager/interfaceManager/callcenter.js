$(function (){
	
	/*****
	 * 
	 * 日期处理
	 */
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
	
	/***************************************************************************
	 * 表格显示数据
	 */
	$('#manager_list_tab').datagrid( {
		method:'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : true,
	    title:'呼叫中心日志',
		pagination : true,
		pageSize:10,
        pageList:[10,20],
		columns : [[{
			field : 'ID',
			title : 'id',
			width : 80,
			align : 'center',
			hidden:true,
			formatter : function(val, rec) {
				return val;
			}
		},{
				field : 'EXTENSION',
				title : '坐席名称 ',
				width : 150,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			}, {
				field : 'RECEIVETYPE',
				title : '接入方式',
			    width : 80,
				align : 'center',
				formatter : function(value,row,index) {
					return value;
				}
			}, {
			field : 'STARTTIME',
			title : '通话开始时间',
		    width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'ENDTIME',
			title : '通话结束时间',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'SERVICENO',
			title : '服务工号',
			width : 100,
			align : 'center',
			formatter: function(value){
				return value;
			}
		},{
			field : 'TELEPHONE',
			title : '电话号码',
			width : 100,
			align : 'center',
			formatter: function(value){
				return value;
			}
		},{
			field : 'DEPTNAME',
			title : '所属科室	',
			width : 200,
			align : 'center',
			formatter : function(val,rec) {
				return val;
			}
		},{
			field : 'UNITCODE',
			title : '所属院区	',
			width : 100,
			align : 'center',
			formatter: function(value,row,index){
			return value;
		}
		
		}]]
	});
	/***************************************************************************
	 * 加载数据
	 */
	loadData(path+'/platformTradelogaction!pageCallCenter.action','manager_list_tab',null);
});

function searchLog(){
	
	var param={'map.startDate':$("#flupDateStart").val(),'map.endDate':$("#flupDateEnd").val()};
	 loadData(path+'/platformTradelogaction!pageCallCenter.action','manager_list_tab',param);
}



