//随访历史记录数据
$(function(){
	
	/***************************************************************************
	 * 加载院区信息
	 */
	$.post(path+"/patidiseasedetailaction!loadHosptialConfig.action",function (data){
			var html="";
			if(data.length>1){
				html+="<option value=''>不限</option>";
			}
				for(var i=0;i<data.length;i++){
					html+="<option value='"+data[i].unitCode+"'>"
					html+=data[i].hosShortName
					html+="</option>";
				}
				$("#unitCode").html(html);
	},'json');
	/*********************
	 * 
	 * 加载病人列表
	 */
	document.getElementById("tdll").style.display = "none";
	$("#inpati_diag").datagrid( {
		method:'get',
		collapsible : false,
		remoteSort : false,
		singleSelect:true,
		idField : 'detailId',
		rownumbers : true,
		queryParams : '',
		singleSelect : true,
	    title:'病人信息',
		pagination : true,
		width:'100%',
		pageSize:10,
        pageList:[10,20,30,40], 
        hideColumn:[[
                     {
         				field : 'patiSerial',
         				title : '病人编号',
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
         				field : 'dept',
         				title : '科室代码',
         				width : 150,
         				align : 'left',
         				formatter : function(val, rec) {
         					return val;
         				}
                     }
                     ]],
					columns : [[{
						field : 'inpatiNumber',
						title : '住院号',
						width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'medicalInsuranceCode',
						title : '医保编号',
						width :120,
						align : 'center',
					},{
						field : 'name',
						title : '姓名',
						width :80,
						align : 'center',
					},{
						field : 'age',
						title : '年龄',
						width :60,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'gender',
						title : '性别',
						width :60,
						align : 'center',
						formatter : function(val, rec) {
							if(val=="1"){
							
								return "男"
							}else{
								return "女"
							}
						}
					},{
						field : 'inHospitalDate',
						title : '入院日期',
						width :100,
						align : 'center',
						formatter : function(val, rec) {
						
							return val;
						}
					},{
						field : 'outHospitalDate',
						title : '出院日期',
						width :100,
						align : 'center',
						formatter : function(val, rec) {
						
							return val;
						}
					},{
						field : 'department',
						title : '科室',
						width :100,
						align : 'center',
						formatter : function(val, rec) {
						
							return val;
						}
					},{
						field : 'unitCode',
						title : '院区',
						width :80,
						align : 'center',
						formatter : function(val, rec) {
							if(val=="1"){
								return "北院"
							}else{
								return "南院"
							}
						}
					}
					]],
					onClickRow:function (rowIndex, rowData){
						$("#inpati_diag_list").window("close");
						document.getElementById("tdll").style.display = "block";
						$('#name2').val(rowData.name);
						$('#inpatiNumber2').val(rowData.inpatiNumber);
						$('#medicalInsuranceCode2').val(rowData.medicalInsuranceCode);
						$('#age2').val(rowData.age);
						$('#gender2').val(rowData.gender==1?'男':'女');
						$('#inHospitalDate2').val(rowData.inHospitalDate);
						$('#outHospitalDate2').val(rowData.outHospitalDate);
						$('#department2').val(rowData.department);
						$('#unitCode2').val(rowData.unitCode==1?'北院':'南院');
						var param={"map.medicalInsuranceCode":rowData.medicalInsuranceCode,"map.inpatiNumber":rowData.inpatiNumber,"map.name":rowData.name};
						/*****
						 * 加载指标模板
						 */
						loadData(path+'/patiDiseaseDictAction!loadDG.action','blxx_tab',param);
						
						/***
						 * 加载历史指标信息
						 */
						loadData(path+'/patidiseasedetailaction!HistoryDiseaseList.action','history_disease',param);
						
						/****
						 * 赋值
						 */
						$("#diseasePatiSerial").val(rowData.patiSerial);
		        		$("#diseaseInpatiNumber").val(rowData.inpatiNumber);
		        		$("#diseaseInpatiSerialNumber").val(rowData.inpatiSerialNumber);
		        		$("#diseaseMedicalInsuranceCode").val(rowData.medicalInsuranceCode);
		        		$("#diseasePatiName").val(rowData.name);
		        		$("#diseaseInHospitalDate").val(rowData.inHospitalDate);
		        		$("#diseaseOutHospitalDate").val(rowData.outHospitalDate);
		        		$("#diseaseDepartment").val(rowData.department);
		        		$("#diseaseDeptCode").val(rowData.dept);		        
		        		$("#diseaseGender").val(rowData.gender);
		        		$("#diseaseAge").val(rowData.age);
		        		$("#diseaseUnitCode").val(rowData.unitCode);
		        		
		
					}
 		});
	
	
	/****
	 * 隐藏一些弹出层
	 */
	$("#edit_bingli_html").window("close");
	$("#inpati_diag_list").window("close");
	$("#edit_bingli_html").window('move',{
			left:400,
			top:80
	});
	
	 $.ajax({
         type: "post",
         dataType : "json",
         url: 'patiDiseaseDictAction!loadCombobox.action',
         success: function(data){
        	 $('#diseaseName').combobox({    
          	    valueField:'diseaseNameId',    
          	    textField:'diseaseName',
          	    data:data[0].diseaseName
          	});
        	 $('#diseaseName').combobox('select', data[0].diseaseName[0].diseaseNameId);
         }
});
	 

	 /***********************************************************************
		 * 
		 * 历史化疗信息
		 */
	 $("#history_disease").datagrid( {
			method:'get',
			collapsible : false,
			remoteSort : false,
			idField : 'detailId',
			rownumbers : true,
			queryParams : '',
			singleSelect : true,
		    title:'历史信息',
			pagination : true,
			width:'100%',
			pageSize:10,
	        pageList:[10,20,30,40],
	        hideColumn:[[{
					field : 'detailId',
					width : 150,
					align : 'left',
					formatter : function(val, rec) {
						return val;
					}
				},{
					field : 'diseaseNameId',
					width : 150,
					align : 'left',
					formatter : function(val, rec) {
						return val;
					}
				}
	        ]],
	        frozenColumns:[[ 
							{
							    field : 'ck',
							    checkbox : true
						  	}
						]],
						columns : [[
						 {
							field : 'inpatiNumber',
							title : '住院号',
							width : 100,
							align : 'center',
							formatter : function(val, rec) {
								return val;
							}
						},{
							field : 'medicalInsuranceCode',
							title : '医保编号',
						    width : 100,
							align : 'center',
						},{
							field : 'name',
							title : '姓名',
						    width : 100,
							align : 'center',
						},{
							field : 'diseaseName',
							title : '模板名称',
							width :120,
							align : 'center',
						},{
							field : 'operateDate',
							title : '录入时间',
							width :120,
							align : 'center',
						},{
							field : 'view',
							title : '调阅 ',
							width : 80,
							align : 'center',
							formatter : function(val, rec) {
								return "<input type='button' value='调阅'/>";
							}
						},{
							field : 'edit',
							title : '编辑 ',
							width : 80,
							align : 'center',
							formatter : function(val, rec) {
								return "<input type='button' value='编辑'/>";
							}
						},{
							field : 'print',
							title : '导出 ',
							width : 80,
							align : 'center',
							formatter : function(val, rec) {
								return "<input type='button' value='导出' />";
							}
						}
						]],
						onClickCell: function(rowIndex, field, value){
		 				var rows=$('#history_disease').datagrid('getRows'); 
						if(field=="view"){
							showHistoryDiseaeInfo(rows[rowIndex].diseaseNameId,rows[rowIndex].patiSerial,rows[rowIndex].inpatiNumber,rows[rowIndex].detailId,"",rows[rowIndex].inHospitalDate,rows[rowIndex].outHospitalDate,rows[rowIndex].department,"");
						}else if(field=="edit"){
							$("#detailId").val(rows[rowIndex].detailId);
							showHistoryDiseaeInfo(rows[rowIndex].diseaseNameId,rows[rowIndex].patiSerial,rows[rowIndex].inpatiNumber,rows[rowIndex].detailId,"button",rows[rowIndex].inHospitalDate,rows[rowIndex].outHospitalDate,rows[rowIndex].department,"");
						}else if(field=="print"){
							showHistoryDiseaeInfo(rows[rowIndex].diseaseNameId,rows[rowIndex].patiSerial,rows[rowIndex].inpatiNumber,rows[rowIndex].detailId,"",rows[rowIndex].inHospitalDate,rows[rowIndex].outHospitalDate,rows[rowIndex].department,"print");
						}
		 			}
	 		});
	 
/************************
 * 模板展示列表
 */	 
 $('#blxx_tab').datagrid( {
					method:'get',
					collapsible : false,
					remoteSort : false,
					idField : 'id',
					rownumbers : true,
					queryParams : '',
					singleSelect : false,
				    title:'患者疾病指标',
					pagination : true,
					width:'90%',
					pageSize:10,
                    pageList:[10,20,30,40],
                    toolbar: [
							'-',{    text:'新增模板',
								     iconCls:'icon-edit',
									 handler:function() {
										 if($("#diseasePatiSerial").val()=="" && $("#diseaseInpatiNumber").val()==""){
												$.messager.alert('提示', "请先查询出一个患者,在新增", 'info');
												return;
											}
										 $("#add_bingli_html").window("open");
										}
						}/*,'-',
							{    text:'删除模板',
								     iconCls:'icon-edit',
									 handler:function() {
										 var rows = $('#blxx_tab').datagrid('getSelections');
										 if(rows.length==0){
											 $.messager.alert('提示', '请选择一行在删除!', 'info');
											 return;
										 }
										 var id = "";
											for ( var i = 0; i < rows.length; i++) {
												id += rows[i].id + ',';
											}
											$.ajax({
									            type: "post",
									            url: path+'/patiDiseaseDictAction!delete.action',
									            dataType : "json",
									            data:{"id":id},
									            success: function(data){
									            	$.messager.alert('提示', data[0].info, 'info');
									            	serach();
									            },
									        });
									}
						}*/],
								columns : [ [ 
								{
									field : 'id',
									title : 'id',
								    width : 20,
									align : 'center',
									hidden:	true
								},
								 {
									field : 'patiSerial',
									title : '病人编号',
								    width : 30,
									align : 'center',
									hidden:	true
								},{
									field : 'inpatiNumber',
									title : '住院号',
									width : 200,
									align : 'center',
									hidden:	true,
									formatter : function(val, rec) {
										return val;
									}
								},{
									field : 'diseaseName',
									title : '指标模板名称',
									width : 150,
									align : 'center',
								},{
									field : 'add',
									title : '录入',
									width : 100,
									align : 'center',
									formatter : function(val, rec) {
										return "<input type='button' value='操作'/>";
									}
								}
								]], 
								onClickCell: function(rowIndex, field, value){
								if(field=="add"){
									var rows=$('#blxx_tab').datagrid('getRows');  
									$("#edit_bingli_html").window("open");
									 $.post(path+"/diseaseitemtemplateaction!showView.action",{"diseaseNameId" : rows[rowIndex].diseaseNameId,"showView":'button'},function (data){
													$("#edit_bingli_html").html(data);
													var html="<table  border=\"1\" bordercolor=\"#a0c6e5\" width=\"80%\"; style=\"border-collapse:collapse;margin-left: 5%; margin-right: 5%; margin-top:5px;\">";
													var gender;
													if($("#diseaseGender").val()=="1"){
															gender='男'
										    		   }else{
										    			    gender='女' 
										    		   }
													    html+="<tr><td><a style='text-decoration:none;font-weight:bold;'>住院号</a>：<label>"+$("#diseaseInpatiNumber").val()+"</label></td>" +
													    		   "<td><a style='text-decoration:none;font-weight:bold;'>住院流水号</a>：<label>"+$("#diseaseInpatiSerialNumber").val()+"</label></td>"+
													    		   "<td><a style='text-decoration:none;font-weight:bold;'>姓&nbsp;&nbsp;&nbsp;&nbsp;名</a>：<label>"+$("#diseasePatiName").val()+"</label></td>" +
													    		   "<td><a style='text-decoration:none;font-weight:bold;'>科&nbsp;&nbsp;&nbsp;&nbsp;室</a>：<label>"+$("#diseaseDepartment").val()+"</label></td>" +
													    		   	"</tr>"+
													    		   "<tr><td><a style='text-decoration:none;font-weight:bold;'>性&nbsp;&nbsp;别</a>：<label>"+gender+"</label></td>" +
													    		    "<td><a style='text-decoration:none;font-weight:bold;'>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</a>：<label>"+$("#diseaseAge").val()+"</label></td>"+
													    		    "<td><a style='text-decoration:none;font-weight:bold;'>入院日期</a>：<label>"+$("#diseaseInHospitalDate").val()+"</label></td>"+
													    		    "<td><a style='text-decoration:none;font-weight:bold;'>出院日期</a>：<label>"+$("#diseaseOutHospitalDate").val()+"</label></td>"+
													    	   "</tr></table>";	
													$("#tableDiseaseView").before(html);
												},"html");
									$("#blxx_tab").datagrid('unselectAll');
									 $("#diseaseDiseaseNameId").val(rows[rowIndex].diseaseNameId);
									 $("#history_disease").datagrid({title:rows[rowIndex].diseaseName+"模板指标信息"});  
								}
						}
       });  
});  


/*******************************************************************************
 * 调阅历史化疗信息
 */
function showHistoryDiseaeInfo(diseaseNameId,patiSerial,inpatiNumber,detailId,showView,inHospitalDate,outHospitalDate,department,print){
	$.post(path+"/diseaseitemtemplateaction!showView.action",{"diseaseNameId" : diseaseNameId,"showView":showView},function (data){
		
		$("#edit_bingli_html").html(data);
		var html="<table  border=\"1\" bordercolor=\"#a0c6e5\" width=\"80%\"; style=\"border-collapse:collapse;margin-left: 5%; margin-right: 5%; margin-top:5px;\">";
		var gender;
		if($("#diseaseGender").val()=="1"){
			gender='男'
		   }else{
			   gender='女' 
		   }
		html+="<tr><td><a style='text-decoration:none;font-weight:bold;'>住院号</a>：<label>"+$("#diseaseInpatiNumber").val()+"</label></td>" +
		   "<td><a style='text-decoration:none;font-weight:bold;'>住院流水号</a>：<label>"+$("#diseaseInpatiSerialNumber").val()+"</label></td>"+
		   "<td><a style='text-decoration:none;font-weight:bold;'>姓&nbsp;&nbsp;&nbsp;&nbsp;名</a>：<label>"+$("#diseasePatiName").val()+"</label></td>" +
		   "<td><a style='text-decoration:none;font-weight:bold;'>科&nbsp;&nbsp;&nbsp;&nbsp;室</a>：<label>"+$("#diseaseDepartment").val()+"</label></td>" +
		   	"</tr>"+
		   "<tr><td><a style='text-decoration:none;font-weight:bold;'>性&nbsp;&nbsp;别</a>：<label>"+gender+"</label></td>" +
		    "<td><a style='text-decoration:none;font-weight:bold;'>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</a>：<label>"+$("#diseaseAge").val()+"</label></td>"+
		    "<td><a style='text-decoration:none;font-weight:bold;'>入院日期</a>：<label>"+$("#diseaseInHospitalDate").val()+"</label></td>"+
		    "<td><a style='text-decoration:none;font-weight:bold;'>出院日期</a>：<label>"+$("#diseaseOutHospitalDate").val()+"</label></td>"+
		    "</tr></table>";
		    $("#tableDiseaseView").before(html);
		     
		var arr=$("#tableDiseaseView tr td input,.diseaseselect");
		var param={'map.patiSerial':patiSerial,'map.inpatiNumber':inpatiNumber,'map.detailId':detailId};
		var value;
		var type;
		var obj;
		$.post(path+"/patidiseasedetailaction!HistroyDiseaseItems.action",param,function (data){
			for(var j=0;j<data.length;j++){
				for(var i=0;i<arr.length;i++){
					obj=$(arr[i]);
					if(!obj.hasClass("diseaseselect")){
						value=obj.attr("tag");
						type=obj.attr("type");
						if(value.indexOf(data[j].diseaseGroupId)>0){
							 if(type=="radio"){
									if(obj.val()==data[j].itemName){
										obj.attr("checked",'checked');
										obj.attr("lang","true");
									}
								}else if(type=="text"){
									obj.val(data[j].itemValue);
								}else if(type="checkbox"){
									if(obj.val()==data[j].itemValue){
										obj.attr("checked",true);
									}
								}
						 }
					}else{
						var options=obj.find("option");
						var optionValue;
						for(var x=0;x<options.length;x++){
							optionValue=options[x].value;
							if(data[j].itemValue==optionValue){
								options[x].selected=true;
							}
						}
					}
				}
			}
		},"json");
		if(print!=null && print!=""){
			
			$("#edit_bingli_html").html(data);
			var html="<table  border=\"1\" bordercolor=\"#a0c6e5\" width=\"80%\"; style=\"border-collapse:collapse;margin-left: 5%; margin-right: 5%; margin-top:5px;\">";
			var gender;
			if($("#diseaseGender").val()=="1"){
				gender='男'
			   }else{
				   gender='女' 
			   }
			html+="<tr><td><a style='text-decoration:none;font-weight:bold;'>住院号</a>：<label>"+$("#diseaseInpatiNumber").val()+"</label></td>" +
			   "<td><a style='text-decoration:none;font-weight:bold;'>住院流水号</a>：<label>"+$("#diseaseInpatiSerialNumber").val()+"</label></td>"+
			   "<td><a style='text-decoration:none;font-weight:bold;'>姓&nbsp;&nbsp;&nbsp;&nbsp;名</a>：<label>"+$("#diseasePatiName").val()+"</label></td>" +
			   "<td><a style='text-decoration:none;font-weight:bold;'>科&nbsp;&nbsp;&nbsp;&nbsp;室</a>：<label>"+$("#diseaseDepartment").val()+"</label></td>" +
			   	"</tr>"+
			   "<tr><td><a style='text-decoration:none;font-weight:bold;'>性&nbsp;&nbsp;别</a>：<label>"+gender+"</label></td>" +
			    "<td><a style='text-decoration:none;font-weight:bold;'>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</a>：<label>"+$("#diseaseAge").val()+"</label></td>"+
			    "<td><a style='text-decoration:none;font-weight:bold;'>入院日期</a>：<label>"+$("#diseaseInHospitalDate").val()+"</label></td>"+
			    "<td><a style='text-decoration:none;font-weight:bold;'>出院日期</a>：<label>"+$("#diseaseOutHospitalDate").val()+"</label></td>"+
			    "</tr></table>";
			    $("#tableDiseaseView").before(html);
			     
			var arr=$("#tableDiseaseView tr td input,.diseaseselect");
			var param={'map.patiSerial':patiSerial,'map.inpatiNumber':inpatiNumber,'map.detailId':detailId};
			var value;
			var type;
			var obj;
			$.post(path+"/patidiseasedetailaction!HistroyDiseaseItems.action",param,function (data){
				for(var j=0;j<data.length;j++){
					for(var i=0;i<arr.length;i++){
						obj=$(arr[i]);
						if(!obj.hasClass("diseaseselect")){
							value=obj.attr("tag");
							type=obj.attr("type");
							if(value.indexOf(data[j].diseaseGroupId)>0){
								 if(type=="radio"){
										if(obj.val()==data[j].itemName){
											obj.attr("checked",'checked');
											obj.attr("lang","true");
										}
									}else if(type=="text"){
										obj.val(data[j].itemValue);
									}else if(type="checkbox"){
										if(obj.val()==data[j].itemValue){
											obj.attr("checked",true);
										}
									}
							 }
						}else{
							var options=obj.find("option");
							var optionValue;
							for(var x=0;x<options.length;x++){
								optionValue=options[x].value;
								if(data[j].itemValue==optionValue){
									options[x].selected=true;
								}
							}
						}
					}
				}
				
				/****
				 * 导出化疗信息为WORD文档
				 * @return {TypeName} 
				 */
			var html=$("#edit_bingli_html").html();
			$("#content").val(html);
			$("#formDisease").submit();
				
			},"json");
			
			
			
			
		}else{
			$("#edit_bingli_html").window("open");
		}
	},"html");
}



/*******************************************************************************
 * 
 * 点击查找的方法
 */
function serach(){
	$('#inpati_diag').datagrid('unselectAll');
	if($.trim($("#medicalInsuranceCode").val())=="" && $.trim($("#inpatiNumber").val())=="" && $.trim($("#name").val())==""){
		$.messager.alert('信息提示','请填写信息进行查询','info');
		return false;
	}
	$.ajax({
        type: "post",
        url: path+'/patiDiseaseDictAction!getPatiInfo.action',
        dataType : "json",
        data:{"map.medicalInsuranceCode":$("#medicalInsuranceCode").val(),"map.inpatiNumber":$("#inpatiNumber").val(),"map.name":$("#name").val()},
        
        success: function(data){
        	if(data[0].rows.length>0){
        		var param={"map.medicalInsuranceCode":$("#medicalInsuranceCode").val(),"map.inpatiNumber":$("#inpatiNumber").val(),"map.name":$("#name").val()};
        		$("#inpati_diag_list").window("open");
        		loadData(path+'/patiDiseaseDictAction!getPatiInfo.action','inpati_diag',param);
       		  
        	}else{
        		if(data[0].rows.length>0){
	        		/****
	        		 * 调用指标模板
	        		 */
	        		loadData(path+'/patiDiseaseDictAction!loadDG.action','blxx_tab',{"map.medicalInsuranceCode":$("#medicalInsuranceCode").val(),"map.inpatiNumber":$("#inpatiNumber").val(),"map.name":$("#name").val()});
	        		
	        		/****
	        		 * 调用历史信息
	        		 */
	        		loadData(path+'/patidiseasedetailaction!HistoryDiseaseList.action','history_disease',{"map.medicalInsuranceCode":$("#medicalInsuranceCode").val(),"map.inpatiNumber":$("#inpatiNumber").val(),"map.name":$("#name").val()});
	        		/****
	        		 * 对隐藏与进行赋值
	        		 */
	        		$("#diseasePatiSerial").val(data[0].rows[0].patiSerial);
	        		$("#diseaseInpatiNumber").val(data[0].rows[0].inpatiNumber);
	        		$("#diseaseInpatiSerialNumber").val(data[0].rows[0].diseaseInpatiSerialNumber);
	        		$("#diseaseMedicalInsuranceCode").val(data[0].rows[0].medicalInsuranceCode);
	        		$("#diseasePatiName").val(data[0].rows[0].name);
	        		$("#diseaseDepartment").val(data[0].rows[0].department);
	        		$("#diseaseDeptCode").val(data[0].rows[0].dept);
	        		$("#diseaseInHospitalDate").val(data[0].rows[0].inHospitalDate);
	        		$("#diseaseOutHospitalDate").val(data[0].rows[0].outHospitalDate);
	        		$("#diseaseGender").val(data[0].rows[0].gender);
	        		$("#diseaseAge").val(data[0].rows[0].age);
	        		$("#diseaseUnitCode").val(data[0].rows[0].unitCode);
	        		}
        		
        	}
        },
    });
	
	
}
/*******************************************************************************
 * 点击保存的方法
 */
function submit(){
	$.ajax({
        type: "post",
        url:  path+'/patiDiseaseDictAction!insert.action',
        dataType : "json",
        data:{"patiDiseaseDict.patiSerial":$("#diseasePatiSerial").val(),
        	"patiDiseaseDict.inpatiNumber":$("#diseaseInpatiNumber ").val(),
        	"patiDiseaseDict.inpatiSerialNumber":$("#diseaseInpatiSerialNumber").val(),
        	"patiDiseaseDict.medicalInsuranceCode":$("#diseaseMedicalInsuranceCode").val(),
        	"patiDiseaseDict.name":$("#diseasePatiName").val(),
        	"patiDiseaseDict.unitCode":$("#unitCode").val(),
        	"patiDiseaseDict.deptCode":$("#diseaseDeptCode").val(),
        	"patiDiseaseDict.diseaseNameId":$("#diseaseName").combobox("getValue")},
        success: function(data){
        	$.messager.alert('提示', data[0].info, 'info');
        	$("#add_bingli_html").window("close");
        	var param={'map.medicalInsuranceCode':$("#diseaseMedicalInsuranceCode").val(),'map.inpatiNumber':$("#diseaseInpatiNumber").val(),'map.patiSerial':$("#diseasePatiSerial").val()};
        	loadData(path+'/patiDiseaseDictAction!loadDG.action','blxx_tab',param);
        	/*******************************************************************
			 * 历史化疗信息
			 */
        	loadData(path+'/patidiseasedetailaction!HistoryDiseaseList.action','history_disease',param);
        	
        },
    });
  }




function opfastTable() {
	$('#sfzskwh_sfb_div').panel('open');
}

function add_bingli_html() {
	$('#add_bingli_html').window('close');
}





$(function (){
	
	/*********************
	 * 为文本框作为日期 添加事件
	 */
	$("input[data='rq']").live('click',function (){
		WdatePicker({
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});
	/***********************************
	 * 
	 * 保存患者指标信息
	 */
	$("#saveDisease").live('click',function (){
		var group=new Array();
		$.messager.confirm('确认对话框', '指标是否保存', function(r){
			if (r){
				var group=new Array();
				for(var i=0;i<$(".diseasechekbox").length;i++){
					 if($(".diseasechekbox")[i].checked==true){
						 group.push($(".diseasechekbox")[i].attributes.tag.nodeValue+","+$(".diseasechekbox")[i].value);
					 }
				}
				for(var i=0;i<$(".diseasetext").length;i++){
					 if($(".diseasetext")[i].value!=""){
						 group.push($(".diseasetext")[i].attributes.tag.nodeValue+","+$(".diseasetext")[i].value);
					 }
				}
				for(var i=0;i<$(".diseaseselect").length;i++){
						
						 group.push($($(".diseaseselect")[i]).find("option:selected").attr("tag")+","+$(".diseaseselect")[i].value);
				}
				for(var i=0;i<$(".diseaseradio").length;i++){
					 if($(".diseaseradio")[i].checked==true){
						 group.push($(".diseaseradio")[i].attributes.tag.nodeValue+","+$(".diseaseradio")[i].value);
					 }
				}
				var param={"map.patiSerial":$("#diseasePatiSerial").val(),"map.inpatiNumber":$("#diseaseInpatiNumber").val(),"map.inpatiSerialNumber":$("#diseaseInpatiSerialNumber").val(),"map.medicalInsuranceCode":$("#diseaseMedicalInsuranceCode").val(),"map.name":$("#diseasePatiName").val(),"map.diseaseNameId":$("#diseaseDiseaseNameId").val(),"map.group":group,"map.gender":$("#diseaseGender").val(),"map.age":$("#diseaseAge").val(),"map.unitCode":$("#diseaseUnitCode").val(),"map.detailId":$("#detailId").val()};
				$.post(path+"/patidiseasedetailaction!addDisease.action",param,function (data){
					if(data>0){
						$.messager.alert('提示','添加成功','info');
						$("#edit_bingli_html").window("close");
						/*******************************************************
						 * 对化疗信息进行重新加载
						 */
			        	loadData(path+'/patidiseasedetailaction!HistoryDiseaseList.action','history_disease',param);
					}
				})
			}
			$("#edit_bingli_html").window("close");
		})
		
	})
	
	
	/***************************************************************************
	 * 处理单选
	 */
	$(".diseaseradio").live('click',function (){
		var langValue=$(this).attr("lang");
		if(langValue!=null && langValue!=''){
			$(this).removeAttr("checked"); 
			$(this).attr("lang","");
		}else{
			$(this).attr("checked","checked");
			$(this).attr("lang","true");
		}
	});
	
	/***************************************************************************
	 * 
	 * 导出化疗记录信息
	 */
	
	$("#export").live('click',function (){
		
	});
})







