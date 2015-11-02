$(function() {
	var currentIndex = -1;
	$('#projectdata_table')
			.datagrid(
					{
						url : '../data/suifang_sflljl.json',
						method : 'get',
						collapsible : false,
						remoteSort : false,
						idField : 'id',
						rownumbers : true,
						queryParams : '',
						singleSelect : false,
						title : '病例信息',
						pagination : true,
						pageSize : 20,
						fitColumns : true,
						pageList : [ 20, 40 ],
						hideColumn : [ [ {
							field : 'one',
							title : '项目代码',
							width : 100,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						} ] ],
						frozenColumns : [ [ {
							field : 'one1',
							title : '项目名称',
							width : 220,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						} ] ],
						columns : [ [ {
							field : 'one3',
							title : 'I类分组',
							width : 200,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'one4',
							title : 'II类分组',
							width : 200,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'one41',
							title : 'III类分组',
							width : 150,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'one2',
							title : '记录方式',
							width : 80,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'one5',
							title : '操作日期',
							width : 80,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'one6',
							title : '操作医生',
							width : 80,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'one7',
							title : '参考科室',
							width : 100,
							align : 'left',
							formatter : function(val, rec) {
								return val;
							}
						}, {
							field : 'one8',
							title : '参考诊断',
							width : 240,
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
										add();
									}
								},
								'-',
								{
									text : '修改',
									iconCls : 'icon-edit',
									handler : function() {
										if (currentIndex == -1) {
											$.messager.alert('提示',
													'请选择需要修改的项!', 'info');
											return false;
										} else {
											$('#projectdata_table').datagrid(
													'updateRow',
													{
														index : currentIndex,
														row : {
															one : $("#one")
																	.val(),
															one1 : $("#one1")
																	.val(),
															one2 : $("#one2")
																	.val(),
															one3 : $("#one3")
																	.val(),
															one4 : $("#one4")
																	.val(),
															one5 : 'P',
															one6 : '小三医生'
														}
													});
											$.messager.alert('提示', '修改成功!',
													'info');
										}
									}
								},
								'-',
								{
									text : '删除',
									iconCls : 'icon-remove',
									handler : function() {
										if (currentIndex == -1) {
											$.messager.alert('提示',
													'请选择需要删除的项!', 'info');
											return false;
										} else {
											if (confirm("你确定要删除该条记录吗?")) {
												$('#projectdata_table')
														.datagrid('deleteRow',
																currentIndex);
												$.messager.alert('提示', '删除成功!',
														'info');
											}
										}
									}
								}, '-', {
									text : '清除文本框',
									iconCls : 'icon-remove',
									handler : function() {
										clearTxt();
									}
								} ],
						onDblClickRow : function(index, row) {

						},
						onClickRow : function(index, row) {
							clearTxt();
							$("#one").val(row.one);
							$("#one1").val(row.one1);
							$("#one2").val(row.one2);
							$("#one3").val(row.one3);
							$("#one4").val(row.one4);
							$("#one5").val(row.one41);
							currentIndex = index;
						}
					});
	var xianm = {
		"total" : 40,
		"rows" : [
		// 此处为东方医院心内科冠心病数据项目
				{
					"one" : "00012",
					"one1" : "I级",
					"one3" : "临床症状",
					"one4" : "心绞痛分级",
					"one41" : "饮酒频率",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00012",
					"one1" : "II级",
					"one3" : "临床症状",
					"one4" : "心绞痛分级",
					"one41" : "饮酒频率",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00012",
					"one1" : "III级",
					"one3" : "临床症状",
					"one4" : "心绞痛分级",
					"one41" : "饮酒频率",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00012",
					"one1" : "IV级",
					"one3" : "临床症状",
					"one4" : "心绞痛分级",
					"one41" : "饮酒频率",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00013",
					"one1" : "I级",
					"one3" : "临床症状",
					"one4" : "心功能分级",
					"one41" : "饮酒频率",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00013",
					"one1" : "II级",
					"one3" : "临床症状",
					"one4" : "心功能分级",
					"one41" : "饮酒频率",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00013",
					"one1" : "III级",
					"one3" : "临床症状",
					"one4" : "心功能分级",
					"one41" : "饮酒频率",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00013",
					"one1" : "IV级",
					"one3" : "临床症状",
					"one4" : "心功能分级",
					"one41" : "饮酒频率",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00014",
					"one1" : "心绞痛再发",
					"one3" : "再次入院情况",
					"one4" : "再次入院",
					"one41" : "是否戒烟",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00015",
					"one1" : "急性心肌梗死",
					"one3" : "再次入院情况",
					"one4" : "再次入院",
					"one41" : "是否戒烟",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00016",
					"one1" : "出血事件",
					"one3" : "再次入院情况",
					"one4" : "再次入院",
					"one41" : "是否戒烟",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00017",
					"one1" : "心功能不全",
					"one3" : "再次入院情况",
					"one4" : "再次入院",
					"one41" : "是否戒烟",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00018",
					"one1" : "其它",
					"one3" : "再次入院情况",
					"one4" : "再次入院",
					"one41" : "是否戒烟",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00019",
					"one1" : "轻微出血",
					"one3" : "临床症状",
					"one4" : "出血事件",
					"one41" : "开始吸烟年龄",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00019",
					"one1" : "严重出血",
					"one3" : "临床症状",
					"one4" : "出血事件",
					"one41" : "开始吸烟年龄",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00020",
					"one1" : "再次入院日期",
					"one3" : "再次入院情况",
					"one4" : "",
					"one41" : "开始吸烟年龄",
					"one2" : "文本",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "阿司匹林片",
					"one3" : "服用药物情况",
					"one4" : "",
					"one41" : "开始吸烟年龄",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "氯吡格雷",
					"one3" : "服用药物情况",
					"one4" : "",
					"one41" : "开始吸烟年龄",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "其它抗血小板药物",
					"one3" : "服用药物情况",
					"one4" : "",
					"one41" : "开始吸烟年龄",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "抗凝药物",
					"one3" : "服用药物情况",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "ACEI或ARB",
					"one3" : "服用药物情况",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "钙离子拮抗剂",
					"one3" : "服用药物情况",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "他汀类药物",
					"one3" : "服用药物情况",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "其它",
					"one3" : "服用药物情况",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "血常规",
					"one3" : "实验室检查",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "血小板聚集率",
					"one3" : "实验室检查",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "肝功能",
					"one3" : "实验室检查",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "肾功能",
					"one3" : "实验室检查",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "血脂",
					"one3" : "实验室检查",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "血糖",
					"one3" : "实验室检查",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "糖化血红蛋白",
					"one3" : "实验室检查",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				}, {
					"one" : "00021",
					"one1" : "C反应蛋白",
					"one3" : "实验室检查",
					"one4" : "",
					"one41" : "",
					"one2" : "单选",
					"one5" : "2014-4-13",
					"one6" : "王医生",
					"one7" : "心内科",
					"one8" : "冠心病"
				} ]
	}
	$('#projectdata_table').datagrid('loadData', xianm);

	$('#xmdl_tab').datagrid( {
		url : '../data/suifang_sflljl.json',
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
		hideColumn : [ [ {
			field : 'one',
			title : '项目代码',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns : [ [ {
			field : 'one1',
			title : '项目名称',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		onDblClickRow : function(index, row) {
			$("#one3").val(row.one1);
			$("#xmdl_div").panel('close');
		},
		onLoadSuccess : function() {
			$("#xmdl_div").panel('close');
		}

	});
	var xianm_name = {
		"total" : 40,
		"rows" : [
		// 此处是东方医院心内科冠心病随访大类数据
				{
					"one" : "001",
					"one1" : "临床症状"
				}, {
					"one" : "002",
					"one1" : "再次入院情况"
				}, {
					"one" : "003",
					"one1" : "服用药物情况"
				}, {
					"one" : "004",
					"one1" : "实验室检查"
				} ]
	}
	$('#xmdl_tab').datagrid('loadData', xianm_name);

	$('#xmdl_tab1').datagrid( {
		url : '../data/suifang_sflljl.json',
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
		hideColumn : [ [ {
			field : 'one',
			title : '项目代码',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns : [ [ {
			field : 'one1',
			title : '项目名称',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		onDblClickRow : function(index, row) {
			$("#one4").val(row.one1);
			$("#xmdl_div1").panel('close');
		},
		onLoadSuccess : function() {
			$("#xmdl_div1").panel('close');
		}

	});
	var xianm_name1 = {
		"total" : 40,
		"rows" : [
		// 此处为东方医院心内科冠心病随访小类
				{
					"one" : "001",
					"one1" : "心绞痛分级"
				}, {
					"one" : "002",
					"one1" : "再次入院"
				}, {
					"one" : "003",
					"one1" : "心功能分级"
				}, {
					"one" : "003",
					"one1" : "出血事件"
				} ]
	}
	$('#xmdl_tab1').datagrid('loadData', xianm_name1);

	// III
	$('#xmdl_tab2').datagrid( {
		url : '../data/suifang_sflljl.json',
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
		hideColumn : [ [ {
			field : 'one',
			title : '项目代码',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns : [ [ {
			field : 'one1',
			title : '项目名称',
			width : 150,
			align : 'left',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		onDblClickRow : function(index, row) {
			$("#one5").val(row.one1);
			$("#xmdl_div2").panel('close');
		},
		onLoadSuccess : function() {
			$("#xmdl_div2").panel('close');
		}

	});
	var xianm_name2 = {
		"total" : 40,
		"rows" : [
		// 此处为东方医院心内科冠心病随访小类
				{
					"one" : "001",
					"one1" : "饮酒频率"
				}, {
					"one" : "002",
					"one1" : "是否戒烟"
				}, {
					"one" : "003",
					"one1" : "开始吸烟年龄"
				} ]
	}
	$('#xmdl_tab2').datagrid('loadData', xianm_name2);
});
// 项目大类
function bb() {
	$("#xmdl_div").panel('open');

}
function close() {
	// $("#xmdl_div").panel('close');
	alert("DDD");
}
// 项目小类
function bb1() {
	$("#xmdl_div1").panel('open');
}

// 项目小类
function bb2() {
	$("#xmdl_div2").panel('open');
}
// 新增
function add() {
	var data = $('#projectdata_table').datagrid('getData');
	var total = data.rows.length + 1;
	$('#projectdata_table').datagrid('appendRow', {
		one : "000" + total,
		one1 : $("#one1").val(),
		one2 : $("#one2").val(),
		one3 : $("#one3").val(),
		one4 : $("#one4").val(),
		one5 : 'P',
		one6 : '小三医生'
	});
}
// 清除
function clearTxt() {
	$("#one").val("");
	$("#one1").val("");
	$("#one2").val("");
	$("#one3").val("");
	$("#one4").val("");

}
