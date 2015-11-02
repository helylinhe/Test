$(function() {
	 
	var now = new Date();    
	var year = now.getFullYear();       //年   
	var month1 = now.getMonth();     //月  
	var month2 = now.getMonth() + 1;     //月  
	var day = now.getDate();			//日
	var nowdate1=year+'-'+month1+'-'+day;
	var nowdate2=year+'-'+month2+'-'+day;
	$('#flupDateStart').val(nowdate1);
	$('#flupDateEnd').val(nowdate2);
	loadFactory();
	loadGrid();
	load_managerInfo();
	load_visitInfo();
	
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
	
	$('#flupDateStart').click(function() {
		WdatePicker( {
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});

	$('#flupDateEnd').click(function() {
		WdatePicker( {
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});
	
	$('#manager_list_tab').datagrid( {
		method:'get',
		fitColumns:true,
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : true,
	    title:'配置信息',
	    width:1000,
		pagination : true,
		pageSize:10,
        pageList:[10,20],
		columns : [ [ {
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
				
				return val;
			}
		}, {
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
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'opeDatetime',
			title : '访问日期',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				
				return val;
			}
		}, {
			field : 'sumDayCount',
			title : '访问次数',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				
				return "<a href='#' >"+val+"</a>";
			}
		},{
			field : 'normalCount',
			title : '正常次数',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				
				return "<a href='#' >"+val+"</a>";
			}
		}, {
			field : 'noNormalCount',
			title : '异常次数',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				if(val!='0'){
					return "<a href='#' >"+val+"</a>";
				}
				return val;
			}
		} ] ],
		onClickCell: function(rowIndex, field, value){
			var rows=$('#manager_list_tab').datagrid('getRows');  
			var param = {
					'map.busiNo' : rows[rowIndex].busiNo,
					'map.opeDatetime':rows[rowIndex].opeDatetime,
					'map.factoryNo':rows[rowIndex].factoryNo
			}
			if(field=="normalCount"){
				var d=$.extend({'map.opeResult':'T'}, param);
				visit_winopen(d,'正常访问次数');
			}else if(field=="noNormalCount" && value!='0'){
				var data=$.extend({'map.opeResult':'F'}, param);
				html_winopen(data,'异常访问次数');
			}else if(field=="sumDayCount" && value!='0'){
				html_winopen(param,'访问次数');
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
	 //加载图表数据
	 $.ajax({
			type : "post",
			url : path + '/platformTradelogaction!findChart.action?map.start='+$("#flupDateStart").val()+'&map.end='+$("#flupDateEnd").val()+'&map.factoryNo='+$("#factoryno").find("option:selected").val(),
			dataType : "json",
			success : function(data) {
				load_chart(data[0].Rows);
			}
		});
}

function load_chart(data){
	var GHW=[];
	var QMGS=[];
	var datetime=[];
	titleText = "接口交易";
	for ( var i = 0; i < data.length; i++) {
		GHW.push(parseFloat(data[i].GHW));
		QMGS.push(parseFloat(data[i].QMGS));
		datetime.push(data[i].opeDatetime)
	}
	
	$('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '接口交易'
        },
        xAxis: {
            categories: datetime,
        },
        yAxis: {
            min: 0,
            title: {
                text: '访问次数/次'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span>',
            formatter: function () {  
              return '<b>' + this.x + '</b><br/>' +  
           this.series.name + ': ' + this.y+'次';  
          } 
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{  
            name:"挂号网" ,  
            data: GHW  
        },{  
            name:"齐脉网" ,  
            data: QMGS  
        }] 
    });
	
}

//打开调阅窗口
function html_winopen(param,value) {
		loadData(path + '/platformTradelogaction!findPageList.action','managerInfo', param);
	var $win;
	$win = $('#configure_html').window({
	    title: value,
	    width: 1000,
	    height: 450,
	    top: ($(window).height() - 400) * 0.5,
	    left: ($(window).width() - 1000) * 0.5,
	    shadow: true,
	    modal: true,
	    iconCls: 'icon-search',
	    minimizable: false,
	    maximizable: false,
	    collapsible: false,
	});
	$("#configure_html").window("open");
}

//打开调阅窗口
function visit_winopen(param,value) {
		loadData(path + '/platformTradelogaction!visitList.action','visitInfo', param);
	var $win;
	$win = $('#visit_html').window({
	    title: value,
	    width: 800,
	    height: 450,
	    top: ($(window).height() - 400) * 0.5,
	    left: ($(window).width() - 800) * 0.5,
	    shadow: true,
	    modal: true,
	    iconCls: 'icon-search',
	    minimizable: false,
	    maximizable: false,
	    collapsible: false,
	});
	$("#visit_html").window("open");
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
			width : 200,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'receContent',
			title : '接收内容',
			width : 140,
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
			field : 'exceptionExplain',
			title : '异常明细',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}  ] ]
	});
}

function load_visitInfo(){
	$('#visitInfo').datagrid( {
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
			width : 200,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'receContent',
			title : '接收内容',
			width : 140,
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
		}] ]
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