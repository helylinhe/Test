$(function() {
	
	
	$("#xmdl_div").panel('close');
	$("#xmdl_div1").panel('close');
	
	
	/** ****动态报表名称****** */
		$('#sfzskwh_sfb').datagrid( {
			method:'get',
			fitColumns : true,
			collapsible : true,
			remoteSort : false,
			rownumbers : false,
			queryParams : '',
			singleSelect :true,
		    pagination : false,
			pageSize:5,
	        pageList:[10,20],
	        hideColumn:[[{
				field : 'id',
				title : '报表编号',
				width : 150,
				align : 'left',
				formatter : function(val, rec) {
					return val;
				}
			}]],
			columns : [[ {
				field : 'reportName',
				title : '报表表名称',
			    width : 150,
				align : 'left',
				formatter : function(val, rec) {
					return val;
				}
			}
			]],
			onClickRow: function (index, row) {
		                       
								$("#sfzskwh_sfb_div").panel('close');
	                            // 设置值到隐藏域中
	                            $("#flupNameId").val(row.id);
	                            $("#flupName").val(row.reportName);
	                            $("#mubantab").val(row.reportName);
	                            // 加载随访表对应的数据
	                            var param={'map.deptTableId':row.id};
	                            $.post(path+'/dynamicReportaction!findRightList.action',param,function (data){
	                        		$('#sfxm_tab_sfb').datagrid('loadData', data[0].rows);
	                        	},'json');
	                            
	                           
	                            
	                          
	                            
	        },onLoadSuccess:function(){
			    $("#sfzskwh_sfb_div").panel('close');
			}
		
	 });  
		loadData(path+'/dynamicReportaction!loadReportName.action','sfzskwh_sfb',null)
		
			/** *I类分组*** */
		/* $('#xmdl_tab').datagrid( {
					method : 'get',
					fitColumns : true,
					collapsible : true,
					remoteSort : false,
					rownumbers : false,
					queryParams : '',
					singleSelect : true,
					pagination : false,
					pageSize : 10,
					pageList : [ 10, 20 ],
					columns : [ [ {
						field : 'groupName',
						title : '项目名称',
						width : 150,
						align : 'left',
						formatter : function(val, rec) {
							return val;
						}
					} ] ],
					onDblClickRow : function(index, row) {
						$("#mubantab0").val(row.groupOne);
						$("#xmdl_div").panel('close');
						
						// 加载II级数据
						$("#mubantab1").val("");
						var param={'map.groupName':row.groupName};
						loadData(path+'/dynamicReportaction!loadReportItem.action','xmdl_tab1',param);
						
						// 对筛选条件进行筛选
						loadData(path+'/dynamicReportaction!pageList.action','sfxm_sfb',param);
					},

				});
		loadData(path+'/dynamicReportaction!loadInspectCheck.action','xmdl_tab',null)*/
	
	*//** **II类分组*** *//*
	$('#xmdl_tab1').datagrid( {
					method : 'get',
					fitColumns : true,
					collapsible : true,
					remoteSort : false,
					rownumbers : false,
					queryParams : '',
					singleSelect : true,
					pagination : false,
					pageSize : 10,
					pageList : [ 10, 20 ],
					columns : [ [ {
						field : 'groupTwo',
						title : '项目名称',
						width : 150,
						align : 'left',
						formatter : function(val, rec) {
							return val;
						}
					} ] ],
					onDblClickRow : function(index, row) {
						$("#mubantab1").val(row.groupTwo);
						$("#xmdl_div1").panel('close');
						
						// 对筛选条件进行筛选
						var param={'map.groupOne':$("#mubantab0").val(),'map.groupTwo':row.groupTwo};
						loadData(path+'/flupitemresponseaction!pageList.action','sfxm_sfb',param);
						
					},
					onLoadSuccess : function() {
						// $("#xmdl_div1").panel('close');
					}
				});
	
	var ids = [];
	var currentIndex = -1;
	$('#sfxm_sfb').datagrid( {
		method:'get',
		idField : 'R',
		fitColumns : true,
		collapsible : false,
		remoteSort : false,
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		title : '报表项',
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 20],
		height : 530,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		hideColumn : [ [ 
						{
							field : 'R',
							title : '项目代码',
							width : 80,
							align : 'center',
							formatter : function(val, rec) {
								return val;
							}
						},
		              {
		            	  field : 'tableName',
		            	  width : 150,
		            	  align : 'center',
		            	  formatter: function(val, rec){
		            	  return val;
		                  }
		              }] ],
		columns : [ [ {
			field : 'itemName',
			title : '指标项名称',
			width : 150,
			align : 'center',
			formatter: function(value,rec){
				return value
			}
		}, {
			field : 'groupName',
			title : '指标大类',
			width : 150,
			align : 'center',
			formatter: function(value,rel){
				return value
			}
		} ] ],
		onDblClickRow : function(index, row) {

		}
	});
	
	loadData(path+'/dynamicReportaction!pageList.action','sfxm_sfb',null);
	
		/**
		 * 右边信息
		 */
	var datagrid_id=0;
	$('#sfxm_tab_sfb').datagrid( {
		collapsible : false,
		remoteSort : false,
		rownumbers : true,
		singleSelect:false,
		idField : 'id',
		queryParams : '',
		height : 530,
		pagination:false,
		title : '动态报表对应项目',
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		toolbar : [{
			text : '上移',
			iconCls : 'icon-add',
			handler : function() {
			var rows= $('#sfxm_tab_sfb').datagrid("getSelected");
			if(rows==null){
				 $.messager.alert('提示','请选中一行进行移动','info');
			 }else{
				 moveJson('sfxm_tab_sfb',false);
			 }
			},
		},'-',{
			text : '下移',
			iconCls : 'icon-add',
			handler : function() {
			 var rows= $('#sfxm_tab_sfb').datagrid("getSelections");
			 if(rows==null){
				 $.messager.alert('提示','请选中一行进行移动','info');
			 }else{
					moveJson('sfxm_tab_sfb',true); 
			 }
			},
		}],
		hideColumn : [ [ 
						{
							field : 'grid_id',
							title : '项目代码',
							width : 80,
							align : 'center',
							formatter : function(val, rec) {
								val=datagrid_id;
								datagrid_id++;
								return val;
							}
						},
		                 {
							field : 'id',
							title : '项目代码',
							width : 80,
							align : 'center',
							formatter : function(val, rec) {
								return val;
							}
						},{
							field : 'tableName',
							title : '表名',
							width : 80,
							align : 'center',
							formatter : function(val, rec) {
								return val;
							}
						}
		                 ] ],
		columns : [ [ {
			field : 'itemName',
			title : '指标项名称',
			width : 250,
			align : 'center',
			formatter: function(value,row,index){
				
					return value;
			}
		} ,{
			field : 'groupName',
			title : '指标大类',
			width : 250,
			align : 'center',
			formatter: function(value,row,index){
				
					return value;
			}
		}] ],
		onDblClickRow : function(index, row) {
		},
		onClickRow : function(index, row) {

			currentIndex = index;
		}
	});
	loadData(path+'/dynamicReportaction!findRightList.action','sfxm_tab_sfb',null);
	
	/***************************************************************************
	 * 
	 * 清空按钮点击事件
	 */

	$('#clear').click(function(){
		/*$("#mubantab0").val('');
		$("#mubantab1").val('');
		$("#mubantab2").val('');
		$("#xmdl_div1").panel('close');
		$("#xmdl_div2").panel('close');
		loadData(path+'/flupitemresponseaction!pageList.action','sfxm_sfb',null);*/
	});

	
	$("#searchItem").click(function (){
		var groupNameValue = $("#mubantab0").val();
		var groupItemValue = $("#mubantab1").val();
		var param={"map.groupName":groupNameValue,"map.itemName":groupItemValue};
		loadData(path+'/dynamicReportaction!pageList.action','sfxm_sfb',param);
	});
	
	
	
	
	/***************************************************************************
	 * 添加项目
	 * 
	 */
	$("#revdataTosf").click(function (){
		if($("#mubantab").val().length==0){
		     $.messager.alert('提示','请先选择模板表','info');
			 return false;
		}		
	  var rows = $("#sfxm_sfb").datagrid('getSelections');
	  var rightRows=$("#sfxm_tab_sfb").datagrid('getRows');
	  for(var i=0; i<rows.length; i++){ 
		  			   var flag=checkSameItemName(rightRows,rows[i]);
		  				if(!flag){
				            $('#sfxm_tab_sfb').datagrid('appendRow',{
							 id: rows[i].R,  
							 groupName: rows[i].groupName,
							 itemName: rows[i].itemName,
							 tableName:rows[i].tableName
							 
				            });
		  				}else{
		  					$.messager.alert('提示','不能添加相同的随访项','info');
			  				 return false;
		  				}
	  }
	  $('#sfxm_sfb').datagrid('clearSelections');
	})
	
	
	// 删除按钮
	$('#remove_sfzskwh_sfb').click(
					function() {
						var rows2 = $('#sfxm_tab_sfb').datagrid('getSelections');
						if (rows2 == null || rows2.length == 0) {
							$.messager.alert('提示', '请选中需要移除的项!', 'info');
							return false;
						} else {
							$.messager.confirm('提示','您确定要进行移除操作吗?',
											function(r) {
												if (r) {
													var arr = new Array();
													for ( var d = 0; d < rows2.length; d++) {
														arr.push(rows2[d].id)	
														
													}
													for ( var i = 0; i < arr.length; i++) {
														var index = $('#sfxm_tab_sfb').datagrid('getRowIndex',arr[i]);
														$('#sfxm_tab_sfb').datagrid('deleteRow',index);
													}
													
													// 清空选中项
													$('#sfxm_tab_sfb').datagrid('clearSelections');

												}
											});
						}
					});
	
	/***************************************************************************
	 * 
	 * 保存随访项事件
	 * 
	 */
	$("#saveFlupItemResponse").click(function (){
		if($("#mubantab").val().length==0){
		     $.messager.alert('提示','请先选择模板表','info');
			 return false;
		}
		 var rows = $("#sfxm_tab_sfb").datagrid('getRows');
		var flupNameId=$("#flupNameId").val();
		var arrFlupGroupId="";
		if(rows.length>0){	
			for(var i=0;i<rows.length;i++){
				
					arrFlupGroupId += rows[i].tableName+";"+rows[i].groupName+";"+rows[i].itemName+";"+i+",";
				
			}
			var param={'map.flupNameId':flupNameId,'map.arrFlupGroupId':arrFlupGroupId};
			$.post(path+'/dynamicReportaction!addResponseItem.action',param,function (data){
				if(data>0){
					$.messager.alert('提示','保存成功','info');
					$("#sfxm_tab_sfb").datagrid('unselectAll');
					var p={'map.deptTableId':flupNameId}
					loadData(path+'/dynamicReportaction!findRightList.action','sfxm_tab_sfb',p);
				}
			},'json');
		}else{
			 $.messager.alert('提示','请添加随访项','info');
			 return false;
		}
		
	});

});


/*
 * I II类分组弹出层
 */
function showGroupWindow(obj){
	$("#"+obj).panel('open');
}

/*******************************************************************************
 * 
 * 对弹出层进行定位
 * 
 * @return
 */
function selmuban(){
	 $("#sfzskwh_sfb_div").panel('open');
	 position('mubantab','sfzskwh_sfb_div');
	 
}



// 预览显示数据
function sfjb_tab_show(){
	  var tableNameId = $("#flupNameId").val();
	  if(tableNameId == null || tableNameId.length == 0 || tableNameId.replace(/\s/g,"").length==0){
	  	$.messager.alert('警告！','请选择随访表名！','error');
	  	return;
	  }
	$.post(
		path+"/dynamicReportaction!findView.action",
		{
			"map.flupNameId" : tableNameId
			
		},
		function (data)
		{
			if(data == 'error'){
				$.messager.alert('警告！','服务器异常！','error');
				retrun;
			}else{
				$('#sffwjl_tab_div').window('open');
				$('#sffwjl_tab_div').panel({title:$("#flupName").val()+"模板"});
				$('#sffwjl_tab_div').html(data);
			}
		},"html"
	);
}


/*******************************************************************************
 * 打印
 */
function printFlupItemResponse(){
	var flupNameId = $("#flupNameId").val();
	  if(flupNameId == null || flupNameId.length == 0 || flupNameId.replace(/\s/g,"").length==0){
	  	$.messager.alert('警告！','请选择随访表名！','error');
	  	return;
	  }
	 /*
		 * $.post(path+"/flupitemresponseaction!findPreviewGroup.action",{flupNameId :
		 * flupNameId},function (data){
		 * 
		 * },'html');
		 */
}

function keyMove(e){
	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
	  var odiv=document.getElementById('sfzskwh_sfb_div');
	  var left =odiv.getBoundingClientRect().left;
	  var top = odiv.getBoundingClientRect().top;
	  
	  var odiv1=document.getElementById('xmdl_div');
	  var left1 =odiv1.getBoundingClientRect().left;
	  var top1 = odiv1.getBoundingClientRect().top;
	  
	  var odiv2=document.getElementById('xmdl_div1');
	  var left2 =odiv2.getBoundingClientRect().left;
	  var top2 = odiv2.getBoundingClientRect().top;
	  
	 
	  if(x<left||x>(left+200)){
		 // alert("左右");
		  $("#sfzskwh_sfb_div").panel('close');
	}else if(y<(top-20)||y>(top+100)){
		// alert("上下");
		$("#sfzskwh_sfb_div").panel('close');
	}
	  
	  if(x<left1||x>(left1+200)){
			 // alert("左右");
			  $("#xmdl_div").panel('close');
		}else if(y<(top1-20)||y>(top1+100)){
			// alert("上下");
			$("#xmdl_div").panel('close');
		}
	  
	  if(x<left2||x>(left2+200)){
			 // alert("左右");
			  $("#xmdl_div1").panel('close');
		}else if(y<(top2-20)||y>(top2+100)){
			// alert("上下");
			$("#xmdl_div1").panel('close');
		}
};



/*// 监听键盘按键
function keyDown(r){
	$("#xmdl_div").panel("open");
	$.ajax({
        type: "post",
        url: path+'/dynamicReportaction!loadInspectCheck.action',
        dataType : "json",
        data:{"map.groupName":r.value},
        success: function(data){
    		*//** *I类分组*** *//*
   		 $('#xmdl_tab').datagrid( {
   					method : 'get',
   					fitColumns : true,
   					collapsible : true,
   					remoteSort : false,
   					rownumbers : false,
   					singleSelect : true,
   					pagination : false,
   					pageSize : 10,
   					pageList : [ 10, 20 ],
   					columns : [ [ {
   						field : 'groupName',
   						title : '指标大类',
   						width : 150,
   						align : 'left',
   						formatter : function(val, rec) {
   							return val;
   						}
   					} ] ],
   					onDblClickRow : function(index, row) {
   						$("#mubantab0").val(row.groupOne);
   						$("#xmdl_div").panel('close');
   						// 加载II级数据
   						$("#mubantab1").val("");
   						var param={'map.groupName':row.groupName};
   						// loadData(path+'/flupgroupaction!flupSecondGroupData.action','xmdl_tab1',param);
   						// 对筛选条件进行筛选
   						loadData(path+'/dynamicReportaction!findRightList.action','sfxm_sfb',param);
   					},
   				});
   		 console.info(data[0]);
   		 $('#xmdl_tab').datagrid('loadData', data[0].rows);
    }
});
}


// 监听键盘按键
function keyDown1(r){
	$("#xmdl_div1").panel("open");
	$.ajax({
        type: "post",
        url: path+'/flupgroupaction!flupGroupData3.action',
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
    		*//** *I类分组*** *//*
   		 $('#xmdl_tab1').datagrid( {
   					method : 'get',
   					fitColumns : true,
   					collapsible : true,
   					remoteSort : false,
   					rownumbers : false,
   					singleSelect : true,
   					pagination : false,
   					pageSize : 10,
   					pageList : [ 10, 20 ],
   					columns : [ [ {
   						field : 'groupOne',
   						title : '项目名称',
   						width : 150,
   						align : 'left',
   						formatter : function(val, rec) {
   							return val;
   						}
   					} ] ],
   					onDblClickRow : function(index, row) {
   						$("#mubantab0").val("");
   						$("#xmdl_div1").panel('close');
   						// 加载II级数据
   						$("#mubantab1").val(row.groupOne);
   						var param={'map.itemName':row.groupOne};
   						// loadData(path+'/flupgroupaction!flupSecondGroupData.action','xmdl_tab1',param);
   						// 对筛选条件进行筛选
   						loadData(path+'/flupitemresponseaction!pageList.action','sfxm_sfb',param);
   					},
   				});
   		 $('#xmdl_tab1').datagrid('loadData', data[0].rows);
    }
});
}
*/


function mysort(index, type, gridname) {
    if ("up" == type) {
        if (index != 0) {
            var toup = $('#' + gridname).datagrid('getData').rows[index];
            var todown = $('#' + gridname).datagrid('getData').rows[index - 1];
            $('#' + gridname).datagrid('getData').rows[index] = todown;
            $('#' + gridname).datagrid('getData').rows[index - 1] = toup;
            $('#' + gridname).datagrid('refreshRow', index);
            $('#' + gridname).datagrid('refreshRow', index - 1);
            $('#' + gridname).datagrid('selectRow', index - 1);
        }
    } else if ("down" == type) {
        var rows = $('#' + gridname).datagrid('getRows').length;
        if (index != rows - 1) {
            var todown = $('#' + gridname).datagrid('getData').rows[index];
            var toup = $('#' + gridname).datagrid('getData').rows[index + 1];
            $('#' + gridname).datagrid('getData').rows[index + 1] = todown;
            $('#' + gridname).datagrid('getData').rows[index] = toup;
            $('#' + gridname).datagrid('refreshRow', index);
            $('#' + gridname).datagrid('refreshRow', index + 1);
            $('#' + gridname).datagrid('selectRow', index + 1);
        }
    }
 
}


function moveJson(dateGrid,flg) {
	 var allRows = $('#'+dateGrid).datagrid("getRows");
	 var rows = $('#'+dateGrid).datagrid("getSelections");
	 var allLength1=allRows.length-1;
	 var allLength2=0;
	if(flg){
		 for(var i = rows.length ; i > 0;i--){
			var index =$('#'+dateGrid).datagrid("getRowIndex",rows[i-1]); 
			 if(index<allLength1){
				 allRows.splice(index,1);
				 if(i>0){
					 allRows.splice((index+1),0,rows[i-1]);
				 }else{
					 allRows.splice((index+1),0,rows[i]);
				 }
			 }else{
				 allLength1--;
			 }
		 }
	}else{
		
		for(var i = 0 ; i < rows.length;i++){
			var index =$('#'+dateGrid).datagrid("getRowIndex",rows[i]); 
				 if(index>allLength2 ){
					 allRows.splice(index,1);
					 allRows.splice((index-1),0,rows[i]);
				 }else{
					 allLength2++;
				 }
		 }
	}
	 $('#'+dateGrid).datagrid("loadData",allRows);
}



function checkSameItemName(rightRows,rows){
	var flag=false;
	for(var j=0;j<rightRows.length;j++){
		if(rightRows[j].itemName==rows.itemName){
			if(rightRows[j].groupName==rows.groupName){
				flag=true;
				break;
			}
		}else{
			continue;
		}
	}
	return flag;
}
	


