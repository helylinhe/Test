$(function() {
	
	
	/****
	 * 调用诊断信息
	 */
	createZdTable();
	
	
	
	
	/****
	 * 调用检查信息
	 */
	createCheckTable();
	
	/*****
	 * 调用手术信息
	 */
	createOperTable();
	
	/*****
	 * 就诊信息
	 */
	createInpatiTable();
	
	/****
	 * 调用检验信息
	 */
	createInspectTable();
	
	/****
	 * 调用检验详细表
	 */
	createInspectInfoTable();
	
	/****
	 * 历史随访信息
	 */
	createHistoryTable();
});

/****
 * 历史随访信息
 * @return
 */
function createHistoryTable() {
	$('#history_grid').datagrid( {
		method:'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : true,
	    title:'历史随访信息',
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
		},{field : 'view',
			title : '调阅 ',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return "<input type='button' value='调阅'/>";
			}
		}
		]],
		onClickCell: function(rowIndex, field, value){
		if(field=="view"){
			var rows=$('#history_grid').datagrid('getRows');  
			showTemplate(rows[rowIndex].flupTableNameId,rows[rowIndex].id,rows[rowIndex].patiSerial,rows[rowIndex].inpatiNumber);
			
		}
	}

 }); 
}
/***
 * 调用模板
 * @param flupNameId
 * @return
 */
function showTemplate(flupNameId,id,patiSerial,inpatiNumber){
	$.post(path+"/flupitemresponseaction!findPreviewGroup.action",{"flupNameId":flupNameId},function (d){
		$('#history_template').window('open');
		$("#history_template").html(d);
		var arr=$("#tableView tr td input");
		$.post(path+"/mobileflupaction!HistoryFlupInfo.action",{"map.taskId":id,"map.patiSerial":patiSerial,"map.inpatiNumber":inpatiNumber},function (data){
			var value;
			var type;
			var obj;
			for(var j=0;j<data.length;j++){
				 for(var i=0;i<arr.length;i++){
					 obj=$(arr[i]);
					 value=obj.attr("tag");
					 type=obj.attr("type");
					 if(value.indexOf(data[j].flupGroupId)>0){
						 if(type=="radio"){
								if(obj.val()==data[j].itemValue){
									obj.attr("checked",'checked');
								}
							}else if(type=="text"){
								obj.val(data[j].itemValue);
							}else if(type="checkbox"){
								if(obj.val()==data[j].itemValue){
									obj.attr("checked",true);
								}
							}
					 }
				 }
				
			}
		},"json");
	},'html');
}


/****
 * 诊断信息
 * @return
 */
function createZdTable() {
	$('#zd_grid').datagrid( {
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		singleSelect : true,
		title : '诊断信息',
		frozenColumns : [ [ {
			field : 'zdtype',
			title : '诊断类别',
			width : 200,
			align : 'center'
		}] ],
		columns:[[ {
			field : 'zdname',
			title : '诊断名称',
			width : 400,
			align : 'left'
		}]]
	});
}
/*****
 * 调用检验
 * @return
 */
function createInspectTable() {
	$('#jyDiv').datagrid({
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		singleSelect : true,
		fitColumns : true,
		pageSize : 10,
		pageList : [ 10, 20],
		pagination : true,
		title : '检验信息',
		columns : [ [ {
			field : 'name',
			title : '姓名',
			width : 80,
			align : 'center',
			hidden : true
		}, {
			field : 'patiSerial',
			title : '病人编号',
			width : 80,
			align : 'center',
			hidden : true
		}, {
			field : 'inpatiSerialNumber',
			title : '住院流水号',
			width : 80,
			align : 'center',
			hidden : true
		}, {
			field : 'itemName',
			title : '检验名称',
			width : 220,
			align : 'center',
			formatter : function(val, rec) {
				return val.replace(/\|/g, "★");
			}
		}, {
			field : 'inspectName',
			title : '项目名称',
			width : 160,
			align : 'center',
			formatter : function(val, rec) {
				return val.replace(/\|/g, "★");
			},
			hidden : true
		}, {
			field : 'inspectDate',
			title : '检验日期',
			width : 70,
			align : 'center'
		}, {
			field : 'inspectDoctor',
			title : '检验医生',
			width : 80,
			align : 'center',
			hidden : true

		}, {
			field : 'checkDoctor',
			title : '审核医生',
			width : 80,
			align : 'center',
			hidden : true
		}, {
			field : 'resultUnit',
			title : '结果单位',
			width : 80,
			align : 'center',
			hidden : true
		} ] ],
		onClickRow : function(rowIndex, rowData) {
			getInspectDetail(rowData);
		}
	});
}

/****
 * 检验详细信息
 * @return
 */
function createInspectInfoTable(){
	$('#jyDivDetail').datagrid({
		collapsible : true,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		singleSelect : true,
		title : '检验详细',
		columns : [ [ {
			field : 'itemName',
			title : '检验名称',
			width : 200,
			align : 'center'
		}, {
			field : 'inspectName',
			title : '项目名称',
			width : 100,
			align : 'center'
		}, {
			field : 'inspectResult',
			title : '检验结果',
			width : 100,
			align : 'center'
		}, {
			field : 'referScale',
			title : '参考范围',
			width : 100,
			align : 'center'
		}, {
			field : 'resultUnit',
			title : '结果单位',
			width : 100,
			align : 'center'
		} ] ],
	});
}

function getInspectDetail(row) {
	$.ajax({
		type : "post",
		url : path + '/inspectAction!queryInspectDetail.action',
		dataType : "json",
		data : {
			"inspectId" : row.inspectId,
			"itemCode" : row.itemCode
		},
		success : function(data) {
			$('#jyDivDetail').datagrid({
				collapsible : false,
				remoteSort : false,
				idField : 'id',
				rownumbers : true,
				singleSelect : true,
				title : '检验详情',
				columns : [ [ {
					field : 'itemName',
					title : '检验名称',
					width : 150,
					align : 'center'
				}, {
					field : 'inspectName',
					title : '项目名称',
					width : 100,
					align : 'center'
				}, {
					field : 'inspectResult',
					title : '检验结果',
					width : 100,
					align : 'center'
				}, {
					field : 'referScale',
					title : '参考范围',
					width : 100,
					align : 'center'
				}, {
					field : 'resultUnit',
					title : '结果单位',
					width : 100,
					align : 'center'
				} ] ]
			});
			$('#jyDivDetail').datagrid("loadData", data[0].rows);
		}
	});
}
//调阅检验
/*function findJY() {
	var inpatiSerialNumber = $($('#inpati_serial_number', parent.document)).val();
	var patiSerial = $($('#pati_serial', parent.document)).val();
	var inpatiNumber = $($('#inpati_number', parent.document)).val()
	createInspectTable();
	createInspectInfoTable();
	var param = {
		'map.inpatiSerialNumber' : inpatiSerialNumber,
		'map.patiSerial' : patiSerial,
		'map.inpatiNumber' : inpatiNumber
	}
	loadData(path + '/inspectAction!queryInspectPages.action', 'jyDiv', param);
}*/
/**
 * 调阅检验
 */
/*function getJYInfo() {
	var name = $("#name").val();
	var inpatiSerialNumber = $('#inpati_serial_number').val();
	var patiSerial = $('#pati_serial').val();
	var inpatiNumber = $('#inpati_number').val();
	findJY(name, inpatiSerialNumber, patiSerial, inpatiNumber);
}*/

/****
 * 检查表
 * @return
 */
function createCheckTable() {
	$('#check_grid').datagrid( {
		collapsible : false,
		nowrap:false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		singleSelect : true,
		pagination : true,
		autoRowHeight:false,
		pageSize : 10,
		pageList : [ 10,20],
		title : '检验信息',
		frozenColumns : [ [ {
			field : 'examItem',
			title : '项目名称',
			width : 200,
			align : 'center'
		}, 
		    {
			field : 'inspectDate',
			title : '申请日期',
			width : 80,
			align : 'center'
		} ] ],
		columns : [ [  {
			field : 'examPara',
			title : '检查结果',
			width : 1000,
			align : 'left'
		}] ]
	});
}

/****
 * 手术信息
 * @return
 */
function createOperTable() {
	$('#oper_grid').datagrid( {
		fitColumns : true,
		collapsible : false,
		remoteSort : false,
		idField : 'inpatiNumber',
		rownumbers : true,
		singleSelect : true,
		striped : true,
		pageSize : 10,
		pageList : [ 10,20,30, 40 ],
		title : '手术信息',
		hideColumn : [ [ {
			field : 'inpatiNumber',
			title : '住院号',
			width : 40,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		} ] ],
		columns : [ [ {
			field : 'operationName',
			title : '手术名称',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'operationDoctorCode',
			title : '主刀医生',
			width : 40,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'operationDate',
			title : '手术日期',
			width : 40,
			align : 'center',
			formatter : function(val, rec) {
				return val.substring(0,10);
			}
		}] ]
	});
}

/*****
 * 就诊信息
 * @return
 */
function createInpatiTable() {
	$('#inpati_grid').datagrid(
			{
				fitColumns : true,
				collapsible : false,
				remoteSort : false,
				idField : 'patiSerial',
				rownumbers : true,
				singleSelect : true,
				title : '多次就诊',
				pagination : true,
				pageSize : 20,
				pageList : [ 20, 40 ],
				hideColumn : [ [ {
					field : 'patiSerial',
					title : '病人编号',
					width : 40,
					align : 'center',
					formatter : function(val, rec) {
						return val;
					}
				} ] ],
				columns : [ [ {
					field : 'inpatiNumber',
					title : '住院号',
					width : 50,
					align : 'center',
					formatter : function(val, rec) {
						return val;
					}
				},{
					field : 'name',
					title : '姓名',
					width : 50,
					align : 'center',
					formatter : function(val, rec) {
						return val;
					}
				},{
					field : 'inpatiSerialNumber',
					title : '住院流水号',
					width : 60,
					align : 'center',
					formatter : function(val, rec) {
						return val;
					}
				}, {
					field : 'inHospitalDate',
					title : '住院日期',
					width : 60,
					align : 'center',
					formatter : function(val, rec) {
						return val.substring(0,10);
					}
				}, {
					field : 'outHospitalDate',
					title : '出院日期',
					width : 60,
					align : 'center',
					formatter : function(val, rec) {
					    return val.substring(0,10);
					}
				}, {
					field : 'attendDoctor',
					title : '主治医生',
					width : 60,
					align : 'center',
					formatter : function(val, rec) {
						return val;
					}
				}, {
					field : 'department',
					title : '所属科室',
					width : 60,
					align : 'center',
					formatter : function(val, rec) {
						return val;
					}
				}, {
					field : 'memo',
					title : '出院小结',
					width : 40,
					align : 'center',
					formatter : function(val, rec) {
						return val;
					}
				} ] ],
				onLoadSuccess:function(data){
				setValue(data.rows[0]);
				var zdData = {
						"total" : 3,
						"rows" : [ {
							'zdtype' : '门诊诊断',
							'zdname' : data.rows[0].diag
						}, {
							'zdtype' : '出院诊断：主要诊断',
							'zdname' : data.rows[0].outHospDiag
						}, {
							'zdtype' : '出院诊断：其他诊断',
							'zdname' : data.rows[0].outHospDiagOther
						} ]
					}
					$('#zd_grid').datagrid('loadData', zdData)
			    },
				onClickRow : function(index, row) {
			    	var param = {
						'map.inpatiSerialNumber' : row.inpatiSerialNumber,
					    'map.patiSerial':row.patiSerial,
					    'map.inpatiNumber':row.inpatiNumber
					}
					loadData(path + '/patiOperateAction!queryPages.action',
							'oper_grid', param);
					loadData(path + '/checkAction!queryPages.action',
							'check_grid', param);
					var zdData = {
						"total" : 3,
						"rows" : [ {
							'zdtype' : '门诊诊断',
							'zdname' : row.diag
						}, {
							'zdtype' : '出院诊断：主要诊断',
							'zdname' : row.outHospDiag
						}, {
							'zdtype' : '出院诊断：其他诊断',
							'zdname' : row.outHospDiagOther
						} ]
					}
					$('#zd_grid').datagrid('loadData', zdData)
					setValue(row)
				}
			});
	
	
	
	var param={
		     'map.inpatiSerialNumber':$('#inpatiSerialNumber', parent.document).val(),
		     'map.patiSerial':$('#patiSerial', parent.document).val(),
		     'map.inpatiNumber':$('#inpatiNumber', parent.document).val()
		    }
	
	loadData(path + '/inpatiDiagAction!queryPages.action', 'inpati_grid',param);
	loadData(path + '/patiOperateAction!queryPages.action','oper_grid',param);
	loadData(path + '/checkAction!queryPages.action','check_grid', param);
	loadData(path + '/inspectAction!queryPages.action','jyDiv', param);
	loadData(path + '/patiAction!queryHistory.action','history_grid', param);
}
function setValue(row) {
	$('#chief_doctor').val(row.chiefDoctor);
	$('#attend_doctor').val(row.attendDoctor);
	$('#inpati_doctor').val(row.inpatiDoctor);
	$('#in_hospital_date').val(row.inHospitalDate.substring(0,10));
	$('#out_hospital_date').val(row.outHospitalDate.substring(0,10));
	$('#in_dept').val(row.department);
	$('#inpati_times').val(row.inpatiTimes);
	$('#in_hospital_dates').val(row.inHospitalDates);
	$('#out_ward').val(row.outWard);
	$('#name').val(row.name);
	$('#pati_serial').val(row.patiSerial);
	$('#inpati_number').val(row.inpatiNumber);
	$('#inpati_serial_number').val(row.inpatiSerialNumber);
	$('#medical_insurance_code').val(row.medicalInsuranceCode);
	$('#billing_name').val(row.billingName);
	$('#age').val(row.age);
	$('#birth_addr').val(row.birthAddr);
	$('#birth_weight').val(row.birthWeight);
	$('#birth_date').val(row.birthDate.substring(0,10));
	$('#country').val(row.country);
	$('#race').val(row.race);
	$('#certificate_type').val(row.certificateType);
	$('#certificate_number').val(row.certificateNumber);
	$('#mobile_number').val(row.mobileNumber);
	$('#family_number').val(row.familyNumber);
	$('#profession_title').val(row.professionTitle);
	$('#current_addr').val(row.currentAddr);
	$('#current_postcode').val(row.currentPostcode);
	$('#account_addr').val(row.accountAddr);
	$('#account_postcode').val(row.accountPostcode);
	$('#relation_name').val(row.relationName);
	$('#relation').val(row.relation);
	$('#relation_mobile_number').val(row.relationMobileNumber);
	$('#same_family_inpat_number').val(row.sameFamilyInpatNumber);
	$('#unit_code').val(row.relation=='1'?'北院':'南院');
	$("input[name=birth_state][value='" + row.birthState + "']").attr("checked", true);
	$("input[name=married][value='" + row.married + "']").attr("checked", true);
	$("input[name=gender][value='" + row.gender + "']").attr("checked", true);
	$('#in_hospital_weight').val(row.inHospitalWeight);
	$('#diag_situation').val(row.diagSituation);
	$('#flup_mobile').val(row.flupMobile);
	$('#billing_name').val(row.billingName);
	$('#totalMoney').val(row.totalMoney);
	$('#charityDidMoney').val(row.charityDidMoney==''?0:row.charityDidMoney);
}

