$(function() {

	 $("#sfzskwh_sfb_div").panel('close');
	
	/******疾病表名*******/
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
				field : 'diseaseNameId',
				title : '随访表编号',
				width : 150,
				align : 'left',
				formatter : function(val, rec) {
					return val;
				}
			}]],
			columns : [[ {
				field : 'diseaseName',
				title : '疾病指标名称',
			    width : 150,
				align : 'left',
				formatter : function(val, rec) {
					return val;
				}
			}
			]],
			onClickRow: function (index, row) {
		                        $("#mubantab").val(row.diseaseName);
								//修改随访表标题 
								$("#sfxm_tab_sfb").datagrid({title:row.diseaseName+"对应项目"});  
	                            $("#sfzskwh_sfb_div").panel('close');
	                            //设置值到隐藏域中
	                            $("#diseaseNameId").val(row.diseaseNameId);
	                            //加载随访表对应的数据
	                            var param={'map.diseaseNameId':row.diseaseNameId};
	                            loadData(path+'/diseaseitemtemplateaction!pageListRight.action','sfxm_tab_sfb',param);
	                            
	                           
	                            
	        },onLoadSuccess:function(){
			    $("#sfzskwh_sfb_div").panel('close');
			}
		
	 });  
		loadData(path+'/diseaseitemtemplateaction!diseaseNameDict.action','sfzskwh_sfb',null)
		
	/****
	 * 左边疾病指标展示
	 */
	var ids = [];
	var currentIndex = -1;
	$('#sfxm_sfb').datagrid( {
		method:'get',
		idField : 'diseaseGroupId',
		fitColumns : true,
		collapsible : false,
		remoteSort : false,
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		title : '疾病指标项目',
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
						field : 'diseaseGroupId',
						width : 150,
						align : 'center',
							formatter: function(val, rec){
								return val;
							}
		                }
		                ] ],
		columns : [ [ {
			field : 'itemName',
			title : '指标名称',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'groupOne',
			title : 'I级分组',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'groupTwo',
			title : 'II级分组',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}

		}, {
			field : 'recordType',
			title : '记录方式',
			width : 60,
			align : 'center',
			formatter : function(val, rec) {
			    if(val=="wb"){
			    	return "文本";
			    }else if(val=="fx"){
			    	return "复选";
			    }else if(val=="dx"){
			    	return "单选";
			    }else if(val=="xlk"){
			    	return "下拉框";
			    }
				return val;
			}
		} ] ],
		onDblClickRow : function(index, row) {

		}
	});
	
	loadData(path+'/diseaseitemtemplateaction!pageList.action','sfxm_sfb',null);
	

		/**
		 * 右边信息
		 */
	$('#sfxm_tab_sfb').datagrid( {
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		queryParams : '',
		height : 530,
		title : '疾病模板对应名称',
		pagination : false,
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
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		hideColumn : [ [ 
		                 {
							field : 'id',
							title : '项目代码',
							width : 150,
							align : 'center',
							formatter : function(val, rec) {
								return val;
							}
						}
		                 ] ],
		columns : [ [ {
			field : 'itemName',
			title : '指标名称',
			width : 150,
			align : 'center',
			formatter: function(value,row,index){
				if (row.diseaseItem){
					return row.diseaseItem.itemName;
				} else {
					return value;
				}
			}
		} , {
			field : 'groupOne',
			title : 'I级分组',
			width : 150,
			align : 'center',
			formatter: function(value,row,index){
				if (row.diseaseItem){
					return row.diseaseItem.groupOne;
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
				if (row.diseaseItem){
					return row.diseaseItem.groupTwo;
				} else {
					return value;
				}
			}
		}, {
			field : 'recordType',
			title : '记录方式',
			width : 70,
			align : 'center',
			formatter: function(value,row,index){
				if (row.diseaseItem){
					if(row.diseaseItem.recordType=="fx"){
						return "复选";
					}
					if(row.diseaseItem.recordType=="dx"){
						return "单选";
					}
					if(row.diseaseItem.recordType=="wb"){
						return "文本";
					}
					if(row.diseaseItem.recordType=="xlk"){
						return "下拉框";
					}
					
				} else {
					return value;
				}
			}
		} ] ],
		onDblClickRow : function(index, row) {
		},
		onClickRow : function(index, row) {

			currentIndex = index;
		}
	});
	
	/*******加载随访表名对应项目*******/
	loadData(path+'/diseaseitemtemplateaction!pageListRight.action','sfxm_tab_sfb',{"map.diseaseNameId":''});
	
	
	/*****
	 * 
	 * 清空按钮点击事件
	 */

	$('#clear').click(function(){
		$("#mubantab0").val('');
		$("#mubantab1").val('');
		$("#mubantab2").val('');
		$("#xmdl_div1").panel('close');
		$("#xmdl_div2").panel('close');
		$("#xmdl_div").panel('close');
		var param={"map.groupOne":'',"map.groupTwo":''};
		loadData(path+'/diseaseitemtemplateaction!pageList.action','sfxm_sfb',param);
	});

	
	
	
	var timer=null;
	$("#mubantab").blur(function (){
		clearInterval(timer);
		if(!$("#sfzskwh_sfb_div").hasClass("hover")){
			timer=setTimeout(function (){
				$('#sfzskwh_sfb_div').panel('close');
			}, 300);
		}
	});
	
	$("#mubantab").focus(function (){
		clearInterval(timer);
		setTimeout(function (){
			$('#sfzskwh_sfb_div').panel('open');
		}, 300);
	});
	
	$("#sfzskwh_sfb_div").hover(function(){
		clearInterval(timer);
		$(this).addClass("hover");
		},function(){ 
			$(this).removeClass("hover");
			if(document.activeElement.id!='mubantab'){
				$('#sfzskwh_sfb_div').panel('close');
			}
	});
	
	
	var timer1=null;
	$("#mubantab0").blur(function (){
		clearInterval(timer1);
		if(!$("#xmdl_div").hasClass("hover")){
			timer=setTimeout(function (){
				$('#xmdl_div').panel('close');
			}, 300);
		}
	});
	
	$("#mubantab0").focus(function (){
		clearInterval(timer1);
		setTimeout(function (){
			$('#xmdl_div').panel('open');
		}, 300);
	});
	
	$("#xmdl_div").hover(function(){
		clearInterval(timer1);
		$(this).addClass("hover");
		},function(){ 
			$(this).removeClass("hover");
			if(document.activeElement.id!='mubantab0'){
				$('#xmdl_div').panel('close');
			}
	});
	
	
	
	var timer2=null;
	$("#mubantab1").blur(function (){
		clearInterval(timer2);
		if(!$("#xmdl_div1").hasClass("hover")){
			timer=setTimeout(function (){
				$('#xmdl_div1').panel('close');
			}, 300);
		}
	});
	
	$("#mubantab1").focus(function (){
		clearInterval(timer2);
		setTimeout(function (){
			$('#xmdl_div1').panel('open');
		}, 300);
	});
	
	$("#xmdl_div1").hover(function(){
		clearInterval(timer2);
		$(this).addClass("hover");
		},function(){ 
			$(this).removeClass("hover");
			if(document.activeElement.id!='mubantab1'){
				$('#xmdl_div1').panel('close');
			}
	});
	
	
	
	
	/******
	 * 移出点击事件JS
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
	var timer=null;
	$("#mubantab").blur(function (){
		clearInterval(timer);
		if(!$("#sfzskwh_sfb_div").hasClass("hover")){
			timer=setTimeout(function (){
				$('#sfzskwh_sfb_div').panel('close');
			}, 300);
		}
	});
	
	$("#mubantab").focus(function (){
		clearInterval(timer);
		setTimeout(function (){
			$('#sfzskwh_sfb_div').panel('open');
		}, 300);
	});
	
	$("#sfzskwh_sfb_div").hover(function(){
		$(this).addClass("hover");
		},function(){ 
			$(this).removeClass("hover");
	});
	
	
	/******
	 *添加项目 
	 *
	 */
	$("#revdataTosf").click(function (){
		if($("#mubantab").val().length==0){
		     alert("请先选择模板表");
			 return false;
		}		
	//获取要移动的行
	  var rows = $("#sfxm_sfb").datagrid('getSelections');
	//获取右边所有的数据行
	  var rightRows=$('#sfxm_tab_sfb').datagrid('getRows');
	  var recordType; 
	  for(var i=0; i<rows.length; i++){  
		         var flag=checkDistinItems(rightRows,rows);
		        if(!flag){
			  		 if(rows[i].recordType=="fx"){
			  			recordType="复选";	
			  		 }else if(rows[i].recordType=="dx"){
			  			recordType="单选";
			  		 }else if(rows[i].recordType=="xlk"){
			  			recordType="下拉框";
			  		 }else {
			  			recordType="文本";
			  		 }
		            $('#sfxm_tab_sfb').datagrid('appendRow',{
					 id: rows[i].diseaseGroupId,  
		             itemName: rows[i].itemName,
		             groupOne: rows[i].groupOne,
					 groupTwo: rows[i].groupTwo,
					 groupThree: rows[i].groupThree,
					 recordType:recordType
		            });
		        }else{
		        	 alert("不能添加相同的随访项");
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
			$.messager.alert("请先选择模板表");
			 return false;
		}
		
		var diseaseNameIdValue=$("#diseaseNameId").val();
		var arrDiseaseGroupId="";
		var rows=$('#sfxm_tab_sfb').datagrid('getRows');
		if(rows.length>0){	
			for(var i=0;i<rows.length;i++){
				  if(rows[i].id!=null && rows[i].id!=""){
					    arrDiseaseGroupId += rows[i].id+"_"+i+",";	
					    
				  }else{
						arrDiseaseGroupId += rows[i].diseaseItem.diseaseGroupId+"_"+i+",";	

				  }
				
			}
			
			var param={'map.diseaseNameId':diseaseNameIdValue,'map.arrDiseaseGroupId':arrDiseaseGroupId};
			$.post(path+'/diseaseitemtemplateaction!addFlupDiseaseItemTemplate.action',param,function (data){
				if(data>0){
					$.messager.alert('提示','保存成功','info');
					var p={'map.diseaseNameId':diseaseNameIdValue,'page.pageSize':20}
					loadData(path+'/diseaseitemtemplateaction!pageListRight.action','sfxm_tab_sfb',p);
				}
			},'json');
		}else{
			$.messager.alert("请添加随访项");
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

/*****
 * 
 * 对弹出层进行定位
 * @return
 */
function selmuban(){
	 $("#sfzskwh_sfb_div").panel('open');
	 position('mubantab','sfzskwh_sfb_div');
	 
}


/******
 * 查询点击事件
 * @return {TypeName} 
 */
function queryDiseasData(){
	var param={"map.diseaseName":$("#diseaseItems").val()};
	loadData(path+'/diseaseitemtemplateaction!pageList.action','sfxm_sfb',param);
	
}


//预览显示数据
function sfjb_tab_show(){
	  var diseaseNameIdValue = $("#diseaseNameId").val();
	  if(diseaseNameIdValue == null || diseaseNameIdValue.length == 0 || diseaseNameIdValue.replace(/\s/g,"").length==0){
	  	$.messager.alert('警告！','请选择随访表名！','error');
	  	return;
	  }
	$.post(
		path+"/diseaseitemtemplateaction!showView.action",
		{
			diseaseNameId : diseaseNameIdValue,
			showView :""
		},
		function (data)
		{
			if(data == 'error'){
				$.messager.alert('警告！','服务器异常！','error');
				retrun;
			}else{
				$('#sffwjl_tab_div').window('open');
				$('#sffwjl_tab_div').html(data);
				$('#sffwjl_tab_div').panel({title:$("#mubantab").val()+"模板"});
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
	  
	 
	  if(x<left||x>(left+200)){
		 // alert("左右");
		  $("#sfzskwh_sfb_div").panel('close');
	}else if(y<(top-20)||y>(top+100)){
		//alert("上下");
		$("#sfzskwh_sfb_div").panel('close');
	}
};


function checkDistinItems(rightRows,rows){
	var flag=false;
	for(var j=0;j<rightRows.length;j++){
		if(rightRows[j].diseaseItem!=null){
			if(rightRows[j].diseaseItem.groupOne!=rows[0].groupOne){
				continue;
			}else{
				if(rightRows[j].diseaseItem.groupTwo!=rows[0].groupTwo){
					continue;
				}else{
						if(rightRows[j].diseaseItem.itemName!=rows[0].itemName){
							continue;
						}else{
							if(rightRows[j].diseaseItem.recordType!=rows[0].recordType){
								continue;
							}else{
								flag=true;
								break;
							}
						}
				}
			}
	}else{
		if(rightRows[j].groupOne!=rows[0].groupOne){
			continue;
		}else{
			if(rightRows[j].groupTwo!=rows[0].groupTwo){
				continue;
			}else{
				
					if(rightRows[j].itemName!=rows[0].itemName){
						continue;
					}else{
						var type;
						if(rows[0].recordType=="wb"){
							type="文本";
						}else if(rows[0].recordType=="dx"){
							type="单选";
						}else if(rows[0].recordType=="fx"){
							type="复选";
						}else{
							type="下拉框";
						}
						if(rightRows[j].recordType!=type){
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
	return flag;
}

Array.prototype.getIndexByDiseaseValue= function(value,groupOne)
{
  var index = -1;
  for (var i = 0; i < this.length; i++)
  {
      if ((this[i].diseaseItem.itemName == value) &&(this[i].diseaseItem.groupOne==groupOne))
      {
          index = i;
          break;
      }
  }
  return index;
}


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


