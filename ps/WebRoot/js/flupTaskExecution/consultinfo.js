//患者咨询js
$(function() {
			
	$('#consult_tab').datagrid( {
		url : '',
		method : 'get',
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		title : '咨询信息',
		pagination : true,
		pageSize : 20,
		pageList : [ 20, 40 ],
		frozenColumns:[[{
			field : 'ck',
			checkbox : true
		}, {
			field : 'one',
			title : '病人编号',
			width : 55,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one1',
			title : '住院号',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one2',
			title : '姓名',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}]],
		columns : [ [ {
			field : 'one3',
			title : '身份证号',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one4',
			title : '咨询号码',
			width : 55,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one5',
			title : '咨询内容',
			width : 400,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one6',
			title : '意见建议',
			width : 500,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one7',
			title : '咨询日期',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one8',
			title : '服务工号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one9',
			title : '咨询状态',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return '<font color="green">' + val + '</font>';
			}
		}] ],
		 onDblClickRow :function(rowIndex,rowData){
		   	consultinfo_date();
		 } 
	});

	var consult_data = {
		"total" : 40,
		"rows" : [ {
			"id" : 0,
			"one" : "001",
			"one1" : "zy001",
			"one2" : "钟俊飞",
			"one3" : "341222198706052646",
			"one4" : "30",
			"one5" : "你好，我做的是切除阑尾手术，请问手术后有什么忌口吗？",
			"one6" : "阑尾炎手术后要以清谈及好消化的食物为主，如如小米稀粥、大米稀粥、馒头、牛奶，还有菜汤等一些好消化的食物。",
			"one7" : "2014-04-18",
			"one8" : "11001",
			"one9" : "完成"
		}, {
			"id" : 1,
			"one" : "002",
			"one1" : "zy002",
			"one2" : "张飞",
			"one3" : "414222198509112421",
			"one4" : "31",
			"one5" : "你好，三个月前做的接骨手术现在在进行康复训练，请问有什么好的建议吗？",
			"one6" : "你好，正确的整复，合理的外固定，一般6周左右可去除外固定。根据X线片的愈合情况为准。恢复到正常状态一般要三月以上的时间。祝您早日康复。",
			"one7" : "2014-04-16",
			"one8" : "11002",
			"one9" : "完成"
		}, {
			"id" : 2,
			"one" : "003",
			"one1" : "zy003",
			"one2" : "宋玉",
			"one3" : "111122198511228547",
			"one4" : "29",
			"one5" : "你好，一个月前做的肿瘤摘除手术，现在伤口还是很疼，请问这正常吗？",
			"one6" : "一般这种手术伤口好好处理，手术一个月后不会有明显的疼痛现象，请您认真检查伤口如何的如何，如果还是很痛的话建议您尽快到医院来检查。",
			"one7" : "2014-04-18",
			"one8" : "11003",
			"one9" : "完成"
		}, {
			"id" : 3,
			"one" : "004",
			"one1" : "zy004",
			"one2" : "王亚东",
			"one3" : "3331122198012110201",
			"one4" : "35",
			"one5" : "你好，我两个月前做的胃修补手术，现在可以吃肉了吗？",
			"one6" : "饮食应以低渣滓,体积小,易消化,温和性的饮食为主.刺激性调味品(如:辣椒,醋等)可少量使用或视个人适宜调整。",
			"one7" : "2014-04-18",
			"one8" : "11004",
			"one9" : "完成"
		}, {
			"id" : 4,
			"one" : "005",
			"one1" : "zy005",
			"one2" : "顾丽",
			"one3" : "",
			"one4" : "30",
			"one5" : "我一个月前做的小肠部分切除手术，现在可以正常吃东西吗？",
			"one6" : "食物调配须采循序渐进方式,由清淡而浓稠,由液体半固体固体。饮食摄取量应采少量多餐,然后逐渐增加。 ",
			"one7" : "2014-04-18",
			"one8" : "11005",
			"one9" : "完成"
		}, {
			"id" : 5,
			"one" : "006",
			"one1" : "zy006",
			"one2" : "李曦",
			"one3" : "男",
			"one4" : "30",
			"one5" : "我老婆一个星期前做的剖腹产手术，现在伤口还是很疼，请问这属于正常情况吗？",
			"one6" : "",
			"one7" : "2014-04-18",
			"one8" : "11006",
			"one9" : "未完成",
		}, {
			"id" : 6,
			"one" : "007",
			"one1" : "zy007",
			"one2" : "徐亚亚",
			"one3" : "男",
			"one4" : "30",
			"one5" : "我一个月前做的缝合手术，现在伤口很痒，请问有没有什么止痒的建议？",
			"one6" : "",
			"one7" : "2014-04-18",
			"one8" : "11007",
			"one9" : "未完成"
		}, ]
	}
	$('#consult_tab').datagrid('loadData', consult_data);

});
//信息交互历史表格
$(function() {
	$('#consultinfo_div').css('width','98%');
	$('#consultinfo_div').css('border','0');
	
	$('#consultinfo').datagrid( {
		url : '',
		method : 'get',
		fitColumns:true,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		title : '协助申请信息',
		pagination : true,
		pageSize : 20,
		pageList : [ 20, 40 ],
		columns : [ [ {
			field : 'one11',
			title : '协助医生工号',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one12',
			title : '协助医生姓名',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'one13',
			title : '咨询内容',
			width : 400,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one14',
			title : '回复内容',
			width : 400,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one16',
			title : '回复日期',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} , {
			field : 'one17',
			title : '回复状态',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} ] ]
	});
});

function consultinfo_date(){
		//添加历史交互信息表格内容
		var consultinfo_date = {
			"total" : 40,
			"rows" : [ {
				"id":1,
				"one11" : "120011",
				"one12" : "陈亮",
				"one13" : "你好，一个月前做的肿瘤摘除手术，现在伤口还是很疼，请问这正常吗？",
				"one14" : "一般这种情况很少见，如果不是伤口没处理妥当的话还请尽快来医院检查。",
				"one15" : "2014-5-6 14:25:12",
				"one17" : "已回复"
			}]
		}
		$('#consultinfo').datagrid('loadData', consultinfo_date);
	}

//申请协助医生信息列表
$(function(){
	$('#doctor_grid').datagrid( {
		url : '',
		method : 'get',
		fitColumns : true,
		collapsible : true,
		remoteSort : false,
		rownumbers : false,
		queryParams : '',
		singleSelect : true,
		pagination : false,
		pageSize : 5,
		pageList : [ 20, 40 ],
		columns : [ [{
			field : 'one1',
			title : '姓名',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one2',
			title : '工号',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} , {
			field : 'one3',
			title : '科室',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one4',
			title : '电话',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}] ],
		onClickRow : function(index, row) {
			$("#doctor_name").val(row.one2);
			$('#doctor_div').panel('close');
		},
		onLoadSuccess : function() {
			$('#doctor_div').panel('close');
		}
	});
	
	var doctor_data = {
		"total" : 40,
		"rows" : [ {
			"id" : 0,
			"one1":"陈亮",
			"one2" : "1100012",
			"one3":"五官科",
			"one4":"13817936978"
		}, {
			"id" : 1,
			"one1":"许飞",
			"one2" : "1100013",
			"one3":"内科",
			"one4":"15858591108"
		}, {
			"id" : 2,
			"one1":"李洁",
			"one2" : "1100014",
			"one3":"外科",
			"one4":"13917041821"
		} ]
	}
	$('#doctor_grid').datagrid('loadData', doctor_data);
	$('#confirm').click(function() {
		var name = $("#doctor_name").val();
		var question = $("#question").val();
		if (name == "" & questtion == "") {
			$.messager.alert('提示', '内容不能为空!', 'info');
		} else {
			$('#doctor_div').panel('open');
		}
	});
});
function opfast() {
	$('#doctor_div').panel('open');
}




