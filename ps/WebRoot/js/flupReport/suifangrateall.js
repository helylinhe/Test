$(function (){
	load_date();
	load_dataGrid();
    search();
    

 });
	//初始化查询的年月为当前年和前一月
function load_date(){
	var myDate = new Date();
	var years=myDate.getFullYear();    //获取完整的年份(4位,1970-????)
	var month=myDate.getMonth();       //获取当前月份(0-11,0代表1月)
	if(month==0){
		month=12;
	}else if(month.length==1){
		month='0'+month;
	}
	$("#years").combobox("setValue",years);
	$("#month").combobox("setValue",month);
}
//加载院区随访率表格
	function load_dataGrid(){
		$('#hospital_dataGrid').datagrid( {
			method:'get',
			fitColumns:true,
			collapsible : false,
			remoteSort : false,
			idField : 'id',
			rownumbers : true,
			queryParams : '',
			singleSelect : true,
		    title:'院区随访率统计',
			pagination : true,
			pageSize:10,
	        pageList:[10,20],
			columns : [[  
				{
					field : 'unitCode',
					title : '院区名称',
					width : 80,
					align : 'center',
					formatter : function(val, rec) {
    					return (val=='1')?'北院':'南院';
    				}
				},{
				field : 'flupComplete',
				title : '随访率',
				width : 100,
				align : 'center',
				formatter: function(value,row,index){
						return value;
				}
			}
			]],
			onClickRow : function(rowIndex, rowData) {
				var row = $("#hospital_dataGrid").datagrid("getSelected");
				//加载科室随访统计列表
				load_Department(row.unitCode==1?'北院':'南院');
				//根据条件加载科室随访统计数据
				var flupDate=$("#years").combobox("getValue")+'-'+$("#month").combobox("getValue");
				var param={'map.flupDate':flupDate,'map.unitCode':row.unitCode};
				 loadData(path+'/flupTaskAction!findDepat.action','department_dataGrid',param);
			},
			onLoadSuccess:function(data){
				load_hospital_Chart(data)
			}
	 });  
	}
//根据日期加载院区随访统计列表数据
function search(){
	var flupDate=$("#years").combobox("getValue")+'-'+$("#month").combobox("getValue");
	var param={'map.flupDate':flupDate};
	 loadData(path+'/flupTaskAction!findHospital.action','hospital_dataGrid',param);
}
//院区随访率饼图
function load_hospital_Chart(data){
//	var data = $('#hospital_dataGrid').datagrid('getData');
  var count = data.total;
  var rows = data.rows;
  var lineAll = [];
  var sum=0;
  //计算总和
  for(var i=0;i<count;i++){
	  var num=parseFloat(rows[i].flupComplete.replace('%', ''));
	  sum+=num;
  }
  //计算院区之间的随访的比例
  for(var i=0;i<count;i++){
	  var proportion=[];
	  var name=rows[i].unitCode==1?"北院":"南院";
	  var num1=parseFloat(rows[i].flupComplete.replace('%', ''));
	  proportion.push(name);
	  proportion.push(num1/sum*100);
	  lineAll.push(proportion);
  }
	$('#hospital_chart').highcharts({
		chart : {
			type :'pie'
		},
		title : {
			text : '院区随访率比例'
		},
		 tooltip: {
	        	pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	        	pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                  enabled: true,
	                  format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                  style: {
	                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                  }
	                }
	              }
	        },
		series : [ {
			name : '院区间随访比例',
			data :lineAll
		}]
	});
}
//科室随访率统计表格
function load_Department(hospitalName){
	$('#department_dataGrid').datagrid( {
		fitColumns:true,
		method:'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : true,
	    title:hospitalName+'科室随访率统计',
		pagination : true,
		pageSize:10,
        pageList:[10,20],
		columns : [[  
			{
				field : 'unitCode',
				title : '所属院区编码',
				width : 80,
				align : 'center',
				hidden:true
			},{
				field : 'flupPlanDate',
				title : '计划随访时间',
				width : 80,
				align : 'center',
				hidden:true
			},{
				field : 'deptCode',
				title : '科室编码',
				width : 80,
				align : 'center',
				hidden:true
			},{
				field : 'deptName',
				title : '科室名称',
				width : 80,
				align : 'center',
			},{
			field : 'flupComplete',
			title : '随访率',
			width : 100,
			align : 'center',
			formatter: function(value,row,index){
				return value;
			}
		}
		]],
		onClickRow : function(rowIndex, rowData) {
			var row = $("#department_dataGrid").datagrid("getSelected")
			//加载随访详细信息列表
			load_info_dataGrid(row.deptName);
			var param={'map.flupPlanDate':row.flupPlanDate,'map.unitCode':row.unitCode,'map.deptCode':row.deptCode};
			 loadData(path+'/flupTaskAction!findInfo.action','info_dataGrid',param);
		},
		onLoadSuccess:function(data){
			var row = $("#hospital_dataGrid").datagrid("getSelected");
			load_Department_Chart(data,row.unitCode==1?'北院':'南院')
		}
	})
}
//科室随访率饼图
function load_Department_Chart(data,hospitalName){
//	var data = $('#hospital_dataGrid').datagrid('getData');
  var count = data.total;
  var rows = data.rows;
  var lineAll = [];
  var sum=0;
  //计算总和
  for(var i=0;i<count;i++){
	  var num=parseFloat(rows[i].flupComplete.replace('%', ''));
	  sum+=num;
  }
  //计算院区之间的随访的比例
  for(var i=0;i<count;i++){
	  var proportion=[];
	  var name=rows[i].deptName;
	  var num1=parseFloat(rows[i].flupComplete.replace('%', ''));
	  proportion.push(name);
	  proportion.push(num1/sum*100);
	  lineAll.push(proportion);
  }
	$('#department_chart').highcharts({
		chart : {
			type :'pie'
		},
		title : {
			text : hospitalName+'科室随访率比例'
		},
		 tooltip: {
	        	pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	        	pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                  enabled: true,
	                  format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                  style: {
	                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                  }
	                }
	              }
	        },
		series : [ {
			name : '科室间随访比例',
			data :lineAll
		}]
	});
}
//随访详细信息列表
function load_info_dataGrid(name){
	 $('#info_dataGrid').datagrid( {
		 	fitColumns:true,
			method:'get',
			collapsible : false,
			remoteSort : false,
			idField : 'id',
			rownumbers : true,
			nowrap:false,
			queryParams : '',
			singleSelect : true,
		    title:name+'随访结果统计',
			pagination : true,
			pageSize:10,
         pageList:[10,20],
         hideColumn:[[
             {
 				field : 'id',
 				title : '任务编号',
 				width : 150,
 				align : 'left',
 				formatter : function(val, rec) {
 					return val;
 				}
             },{
 				field : 'flupTableNameId',
 				title : '随访表编号',
 				width : 150,
 				align : 'left',
 				formatter : function(val, rec) {
 					return val;
 				}
             },{
 				field : 'inpatiSerialNumber',
 				title : '住院流水号',
 				width : 150,
 				align : 'left',
 				formatter : function(val, rec) {
 					return val;
 				}
             },{
 				field : 'patiSerial',
 				title : '病人编号',
 				width : 150,
 				align : 'left',
 				formatter : function(val, rec) {
 					return val;
 				}
             },{
 				field : 'inpatiNumber',
 				title : '住院号',
 				width : 150,
 				align : 'left',
 				formatter : function(val, rec) {
 					return val;
 				}
             }
             ]],
			frozenColumns:[[
				{
				field : 'flupPlanDate',
				title : '随访日期',
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
			}, {
				field : 'gender',
				title : '性别',
			    width : 40,
				align : 'center',
				formatter : function(val, rec) {
					 return val == '1' ? '男' : '女';
				}
			}
			]],
			columns : [[ {
				field : 'age',
				title : '年龄',
			    width : 50,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			}, {
				field : 'outHospDiag',
				title : '出院诊断',
				width : 160,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},{
				field : 'operationName',
				title : '手术名称',
				width : 150,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},{
				field : 'operationDoctorCode',
				title : '主刀医生',
				width : 70,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},{
				field : 'operationPrognosis',
				title : '手术预后',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},{
				field : 'totalMoney',
				title : '总费用',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},{
				field : 'charityAidMoney',
				title : '慈善救助',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},{
				field : 'flupResult',
				title : '随访结果',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},{
				field : 'doctorName',
				title : '随访医生',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			},{
				field : 'flupFailre',
				title : '随访说明',
				width : 80,
				align : 'center',
				formatter : function(val, rec) {
					return val;
				}
			}
			]],
			onClickRow: function(rowIndex, rowData){
			
			}
	 });  
}
