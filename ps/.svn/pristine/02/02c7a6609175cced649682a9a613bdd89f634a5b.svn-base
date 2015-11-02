$(function() {
	
	loadFactory();
	loadGrid();
	load_managerInfo();
	
});

function loadFactory(){
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
}

function loadGrid(){
	
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
	var fyNo;
	var datetime;
	var biNo;
	$('#date').val();
	$('#manager_list_tab').datagrid( {
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		singleSelect : true,
		title : '配置信息',
		fitColumns : true,
		fit:true,
        nowrap: false,  
        striped: true,  
		pagination : true,
		pageSize : 10,
		pageList : [ 10,20, 50 ],
		frozenColumns : [ [ {
			field : 'factoryName',
			title : '厂家名称',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'factoryNo',
			title : '厂家编码',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				fyNo=val;
				return val;
			}
		} ] ],
		columns : [ [  {
			hidden:true,
			field : 'busiNo',
			title : '业务编号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'busiName',
			title : '业务名称',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'opeDatetime',
			title : '访问日期',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				datetime=val;
				return val;
			}
		}, {
			field : 'sumDayCount',
			title : '访问次数',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'noNormalCount',
			title : '异常次数',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'view',
			title : '操作',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				 var param = {
							'map.busiNo' : biNo,
						    'map.opeDatetime':datetime,
						    'map.factoryNo':fyNo
						}
				return "<input type='button' value='调阅'/>";
			}
		} ] ],
		onClickCell: function(rowIndex, field, value){
			if(field=="view"){
				var rows=$('#manager_list_tab').datagrid('getRows');  
				var param = {
						'map.busiNo' : rows[rowIndex].busiNo,
					    'map.opeDatetime':rows[rowIndex].opeDatetime,
					    'map.factoryNo':rows[rowIndex].factoryNo
					}
				html_winopen(param);
			}
		}
	});

	 var param = {
				'map.factoryNo': $("#factoryno").find("option:selected").val(),
			    'map.beginDate':$("#flupDateStart").val(),
			    'map.endDate':$("#flupDateEnd").val()
			}
	loadData(path + '/platformTradelogaction!searchPageList.action',
			'manager_list_tab', param);	
	
    $('#container').highcharts({
        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: ['2014-07-01', '2014-07-02', '2014-07-03', '2014-07-04', '2014-07-05', '2014-07-06',
                '2014-07-07', '2014-07-08', '2014-07-09', '2014-07-10', '2014-07-11', '2014-07-12']
        },
        yAxis: {
            title: {
                text: '次数'
            },
			min:0,
			
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '次数'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '门诊挂号预约',
            data: [200, 300, 450, 500, 600, 550, 700, 500, 420, 440, 600, 700]
        }, {
            name: '医技检查预约',
            data: [100, 250, 150, 280, 400, 300, 500, 700, 630, 350, 500, 600]
        }, {
            name: '多媒体导航',
            data: [300, 420, 300, 300, 150, 220, 300, 500, 420, 420, 470, 500]
        }, {
            name: '智能分诊',
            data: [400, 250, 300, 200, 600, 460, 760, 630, 530, 410, 570, 400]
        }, {
            name: '院前候诊',
            data: [550, 350, 250, 400, 320, 560, 320, 480, 450, 690, 650, 300]
        }, {
            name: '查看检查报告',
            data: [300, 200, 450, 350, 490, 490, 430, 650, 440, 450, 480, 550]
        }]
    });
}

//打开调阅窗口
function html_winopen(param) {
	loadData(path + '/platformTradelogaction!findPageList.action','managerInfo', param);
	$("#configure_html").window("open");
}



function load_managerInfo(){
	$('#managerInfo').datagrid( {
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		singleSelect : true,
		fitColumns : true,
		fit:true,
        nowrap: false,  
        striped: true,  
		pagination : true,
		pageSize : 10,
		pageList : [ 10,20, 50 ],
		frozenColumns : [ [ {
			field : 'busiName',
			title : '业务名称',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'opeDatetime',
			title : '访问时间',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns : [ [ {
			field : 'sendContent',
			title : '发送内容',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'receContent',
			title : '接收内容',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'sumDayCount',
			title : '病人编号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'noNormalCount',
			title : '医保编号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} ] ]
	});
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