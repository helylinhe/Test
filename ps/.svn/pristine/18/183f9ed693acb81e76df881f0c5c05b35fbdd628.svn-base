$(function() {
	
	$("#xmdl_div").panel('close');
	$("#xmdl_div1").panel('close');
	$("#xmdl_div2").panel('close');
	
	
	/******随访表名*******/
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
				field : 'flupNameId',
				title : '随访表编号',
				width : 150,
				align : 'left',
				formatter : function(val, rec) {
					return val;
				}
			}]],
			columns : [[ {
				field : 'flupName',
				title : '随访表名称',
			    width : 150,
				align : 'left',
				formatter : function(val, rec) {
					return val;
				}
			}
			]],
			onClickRow: function (index, row) {
		                        $("#mubantab").val(row.flupName);
								//修改随访表标题 
								$("#sfxm_tab_sfb").datagrid({title:row.flupName+"对应项目"});    
	                            $("#sfzskwh_sfb_div").panel('close');
	                            //设置值到隐藏域中
	                            $("#flupNameId").val(row.flupNameId);
	                            $("#flupName").val(row.flupName);
	                            //加载随访表对应的数据
	                            var param={'map.flupNameId':row.flupNameId};
	                            $.post(path+'/flupitemresponseaction!pageFlupItemList.action',param,function (data){
	                        		$('#sfxm_tab_sfb').datagrid('loadData', data[0].rows);
	                        	},'json');               
	        },onLoadSuccess:function(){
			    $("#sfzskwh_sfb_div").panel('close');
			}
		
	 });  
		loadData(path+'/flupitemresponseaction!flupNamDict.action','sfzskwh_sfb',null)
	
	/*****
	 * 左边信息加载
	 * @param {Object} val
	 * @param {Object} rec
	 * @return {TypeName} 
	 */
	var ids = [];
	var currentIndex = -1;
	$('#sfxm_sfb').datagrid( {
		method:'get',
		idField : 'id',
		fitColumns : true,
		collapsible : false,
		remoteSort : false,
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		title : '随访表项目',
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
						field : 'id',
						width : 150,
						align : 'center',
							formatter: function(val, rec){
								return val;
							}
		                }
		                ] ],
		columns : [ [ {
			field : 'itemName',
			title : '项目名称',
			width : 150,
			align : 'center',
			formatter: function(value,row,index){
				if (row.flupGroup){
					return row.flupGroup.itemName;
				} else {
					return value;
				}
			}
		}, {
			field : 'groupOne',
			title : 'I级分组',
			width : 150,
			align : 'center',
			formatter: function(value,row,index){
				if (row.flupGroup){
					return row.flupGroup.groupOne;
				} else {
					return value;
				}
			}
		}, {
			field : 'groupTwo',
			title : 'II级分组',
			width : 150,
			align : 'center',
			formatter: function(value,row,index){
				if (row.flupGroup){
					return row.flupGroup.groupTwo;
				} else {
					return value;
				}
			}

		},{
			field : 'recordType',
			title : '记录方式',
			width : 100,
			align : 'center',
			formatter: function(value,row,index){
				if (row.flupGroup){
					if(row.flupGroup.recordType=="fx"){
						return "复选";
					}
					if(row.flupGroup.recordType=="dx"){
						return "单选";
					}
					if(row.flupGroup.recordType=="wb"){
						return "文本";
					}
					
				} else {
					return value;
				}
			}
		} ] ],
		onDblClickRow : function(index, row) {

		}
	});
	
	loadData(path+'/flupitemresponseaction!pageList.action','sfxm_sfb',null);
	

		/**
		 * 右边信息
		 */
	$('#sfxm_tab_sfb').datagrid( {
		collapsible : false,
		remoteSort : false,
		rownumbers : true,
		singleSelect:false,
		idField : 'id',
		queryParams : '',
		height : 530,
		pagination:false,
		title : '随访表对应项目',
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
							field : 'id',
							title : '项目代码',
							width : 80,
							align : 'center',
							formatter : function(val, rec) {
								return val;
							}
						}
		                 ] ],
		columns : [ [ {
			field : 'itemName',
			title : '项目名称',
			width : 150,
			align : 'center',
			formatter: function(value,row,index){
				if (row.flupGroup){
					return row.flupGroup.itemName;
				} else {
					return value;
				}
			}
		} , {
			field : 'groupOne',
			title : 'I级分组',
			width : 120,
			align : 'center',
			formatter: function(value,row,index){
				if (row.flupGroup){
					return row.flupGroup.groupOne;
				} else {
					return value;
				}
			}
		}, {
			field : 'groupTwo',
			title : 'II级分组',
			width : 100,
			align : 'center',
			formatter: function(value,row,index){
				if (row.flupGroup){
					return row.flupGroup.groupTwo;
				} else {
					return value;
				}
			}
		},{
			field : 'recordType',
			title : '记录方式',
			width : 80,
			align : 'center',
			formatter: function(value,row,index){
				if (row.flupGroup){
					if(row.flupGroup.recordType=="fx"){
						return "复选";
					}
					if(row.flupGroup.recordType=="dx"){
						return "单选";
					}
					if(row.flupGroup.recordType=="wb"){
						return "文本";
					}
					
				} else {
					return value;
				}
			}
		}] ],
		onDblClickRow : function(index, row) {
		},
		onClickRow : function(index, row) {

			currentIndex = index;
		}
	});
	
	/*******加载随访表名对应项目*******/
	$.post(path+'/flupitemresponseaction!pageFlupItemList.action',function (data){
		$('#sfxm_tab_sfb').datagrid('loadData', data[0].rows);
	},'json');
	
	

	
	
	
	
	/*****
	 * 删除随访项
	 * @return {TypeName} 
	 */
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
	/******
	 *添加项目 
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
		  			var flag=checkSameItemName(rightRows,rows);
		  			if(!flag){
		  				var record;
		  				var recordType=rows[i].flupGroup.recordType;
		  				if(recordType=="dx"){
		  					record='单选';
		  				}else if(recordType=="wb"){
		  					record='文本';
		  				}else if(recordType=="fx"){
		  					record='复选';
		  				}
			            $('#sfxm_tab_sfb').datagrid('appendRow',{
						 id: rows[i].id,  
			             itemName: rows[i].flupGroup.itemName,
			             groupOne: rows[i].flupGroup.groupOne,
						 groupTwo: rows[i].flupGroup.groupTwo,
						 groupThree: rows[i].flupGroup.groupThree,
						 recordType:record
			            });
		  			}else{
		  				$.messager.alert('提示','不能添加相同的随访项','info');
		  				 return false;
		  			}
	  }
	  $('#sfxm_sfb').datagrid('clearSelections');
	})
	
	
	/*******
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
				if(rows[i].id!=null){
					arrFlupGroupId += rows[i].id+"_"+i+",";
				}
			}
			var param={'map.flupNameId':flupNameId,'map.arrFlupGroupId':arrFlupGroupId};
			$.post(path+'/flupitemresponseaction!addFlupItemResponse.action',param,function (data){
				if(data>0){
					$.messager.alert('提示','保存成功','info');
					$("#sfxm_tab_sfb").datagrid('unselectAll');
					var p={'map.flupNameId':flupNameId,'page.pageSize':20}
					loadData(path+'/flupitemresponseaction!pageFlupItemList.action','sfxm_tab_sfb',p);
				}
			},'json');
		}else{
			 $.messager.alert('提示','请添加随访项','info');
			 return false;
		}
		
	});

});


/*****
 * 查询按钮进行查询信息
 */
function queryData(){
   var value = $("#flupItems").val();
   var param ={'map.itemName':value};
  /* $.post(path+'/flupitemresponseaction!pageList',param,function (data){
	   var blm_datapatient_data={"total":data[0].totalRecord,"rows":data[0].rows};
		 $("#sfxm_sfb").datagrid('loadData', blm_datapatient_data);
   },'json');*/
   loadData(path+'/flupitemresponseaction!pageList.action','sfxm_sfb',param);
}

/*****
 * 
 * 对弹出层进行定位
 * @return
 */
function selmuban(){
	 $("#sfzskwh_sfb_div").panel('open');
	 position('mubantab','sfzskwh_sfb_div');
	 
}



/****
 * 预览显示数据
 * @return {TypeName} 
 */
function sfjb_tab_show(){
	  var flupNameId = $("#flupNameId").val();
	  if(flupNameId == null || flupNameId.length == 0 || flupNameId.replace(/\s/g,"").length==0){
	  	$.messager.alert('警告！','请选择随访表名！','error');
	  	return;
	  }
	$.post(
		path+"/flupitemresponseaction!findFlupTemplate.action",
		{
			flupNameId : flupNameId,
			showButton : ""
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
		//alert("上下");
		$("#sfzskwh_sfb_div").panel('close');
	}
	  
	  if(x<left1||x>(left1+200)){
			 // alert("左右");
			  $("#xmdl_div").panel('close');
		}else if(y<(top1-20)||y>(top1+100)){
			//alert("上下");
			$("#xmdl_div").panel('close');
		}
	  
	  if(x<left2||x>(left2+200)){
			 // alert("左右");
			  $("#xmdl_div1").panel('close');
		}else if(y<(top2-20)||y>(top2+100)){
			//alert("上下");
			$("#xmdl_div1").panel('close');
		}
};




/****
 * 移动JS代码
 * @param {Object} dateGrid
 * @param {Object} flg
 * @return {TypeName} 
 */
function moveJson(dateGrid,flg) {
	 var allRows = $('#'+dateGrid).datagrid("getRows");
	 var rows = $('#'+dateGrid).datagrid("getSelections");
	if(flg){
		 for(var i = rows.length ; i > 0;i--){
			 var index =$('#'+dateGrid).datagrid("getRowIndex",rows[i-1]); 
			 if(index==(allRows.length-1)){
				 return;
			 }
			 allRows.splice(index,1);
			 allRows.splice((index+1),0,rows[i-1]);
		 }
	}else{
		for(var i = 0 ; i < rows.length;i++){
			 var index =$('#'+dateGrid).datagrid("getRowIndex",rows[i]); 
			 if(index==0){
				 return;
			 }
			 allRows.splice(index,1);
			 allRows.splice((index-1),0,rows[i]);
		 }
	}
	 $('#'+dateGrid).datagrid("loadData",allRows);
}


/****
 * 验证随访项信息
 * @param {Object} rightRows
 * @param {Object} rows
 * @return {TypeName} 
 */
function checkSameItemName(rightRows,rows){
	var flag=false;
	for(var j=0;j<rightRows.length;j++){
		if(rightRows[j].flupGroup!=null){
			if(rightRows[j].flupGroup.groupOne!=rows[0].flupGroup.groupOne){
				continue;
			}else{
				if(rightRows[j].flupGroup.groupTwo!=rows[0].flupGroup.groupTwo){
					continue;
				}else{
					if(rightRows[j].flupGroup.groupThree!=rows[0].flupGroup.groupThree){
						continue;
					}else{
						if(rightRows[j].flupGroup.itemName!=rows[0].flupGroup.itemName){
							continue;
						}else{
							if(rightRows[j].flupGroup.recordType!=rows[0].flupGroup.recordType){
								continue;
							}else{
								flag=true;
								break;
							}
						}
						
					}
				}
			}
	}else{
		if(rightRows[j].groupOne!=rows[0].flupGroup.groupOne){
			continue;
		}else{
			if(rightRows[j].groupTwo!=rows[0].flupGroup.groupTwo){
				continue;
			}else{
				if(rightRows[j].groupThree!=rows[0].flupGroup.groupThree){
					continue;
				}else{
					if(rightRows[j].itemName!=rows[0].flupGroup.itemName){
						continue;
					}else{
						if(rightRows[j].recordType!=rows[0].flupGroup.recordType){
							continue;
						}else{
							flag=true;
							break;
						}
					}
					
				}
			}
		}
	 }
	}
	return flag;
}
	


