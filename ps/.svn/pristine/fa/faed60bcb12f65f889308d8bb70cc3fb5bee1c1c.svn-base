var num = 2;
$(function() {
	setpos();
	$("#num").val(num);
	$("#sfzskwh_sfb_div").panel('close');
	$("#confast_div").panel('close');
	$("#confast_divDept").panel('close');
	$("#doctorconfast_div").panel('close');
	//加载所有的combobox数据
	$.ajax({
        type: "post",
        url: path+'/patiReturnRuleAction!loadCombobox.action',
        dataType : "json",
        success: function(data){
        	$('#deptCode').combogrid({    
        		 panelWidth:200,    
         	     idField:'deptCode',    
         	     textField:'deptName',
         	     data:data[0].department,
        		 columns:[[    
        		           {field:'deptCode',title:'科室编码',width:60,hidden:true},    
        		           {field:'deptName',title:'科室名称',width:120},    
        		           {field:'unitCode',title:'院区',width:50,
        		        	   formatter : function(value,row,index) {
        		   				if(value=='1'){return '北院';}
        		   				if(value=='2'){return '南院';}
        		   			     }
        		        	 },    
        		       ]] ,
        	    onHidePanel: function(){
	      	    	$.ajax({
	      	    	  type: "post",
	      	          dataType : "json",
	      	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
	      	          data:{"department.deptCode":$('#deptCode').combogrid("getValue")} ,
	      	          success: function(data){
	      	        	$('#doctorconfast_tab').datagrid({ 
	      	        	method:'get',
	      	      		idField : 'jobnum',
	      	      		rownumbers : false,
	      	      		width:'100%',
	      	      		queryParams : '',
	      	      		columns : [ [ {
	      	      			field : 'ck',
	      	      			checkbox : true
	      	      		},
	      	            	        {field:'jobnum',title:'',hidden:true},    
	      	            	        {field:'name',title:'医生姓名',width:170}
	      	            	    ]],
	      	            	  toolbar : [ {
	      	        			text : '增加',
	      	        			iconCls : 'icon-add',
	      	        			handler : function() {
	      	        				var rows = $('#doctorconfast_tab').datagrid('getSelections');
	      	        				if(rows.length==0){
	      	        					$.messager.alert('提示', '请选择要选中的项!', 'info');
	      	        				}else{
	      	        				var info ="";
	      	        				var code ="";
	      	        				$.each( rows, function(i, n){
	      	        					info += n.name +",";
	      	        					code += n.jobnum +",";
									});
	      	        				$("#flupDoctorCode").val(info.substring(0, info.length-1));
	      	        				$("#hflupDoctorCode").val(code.substring(0, code.length-1));
	      	        				$("#flupDoctorCode")[0].focus() ;
	      	        				$('#doctorconfast_tab').datagrid('unselectAll');
	      	        				$("#doctorconfast_div").panel('close');
	      	        				}
								}
	      	        		}],
	      		      	});
	      	        	$('#doctorconfast_tab').datagrid('loadData', data[0].rows);
	      	          }
	      	    	});
	      	  }
        	});
//        	$('#deptCode').combobox('loadData', data[0].department);
//        	$('#deptCode').combobox('select', data[0].department[0].deptCode);
        	//默认加载一次医生面板
        	$.ajax({
    	    	  type: "post",
    	          dataType : "json",
    	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
    	          data:{"department.deptCode":$('#deptCode').combogrid("getValue")} ,
    	          success: function(data){
    	        	$('#doctorconfast_tab').datagrid({ 
    	        	method:'get',
    	      		idField : 'jobnum',
    	      		rownumbers : false,
    	      		width:'100%',
    	      		queryParams : '',
    	      		columns : [ [ {
    	      			field : 'ck',
    	      			checkbox : true
    	      		},
    	            	        {field:'jobnum',title:'',hidden:true},    
    	            	        {field:'name',title:'医生姓名',width:170}
    	            	    ]],
    	            	  toolbar : [ {
    	        			text : '增加',
    	        			iconCls : 'icon-add',
    	        			handler : function() {
    	        				var rows = $('#doctorconfast_tab').datagrid('getSelections');
    	        				if(rows.length==0){
    	        					$.messager.alert('提示', '请选择要选中的项!', 'info');
    	        				}else{
    	        				var info ="";
    	        				var code ="";
    	        				$.each( rows, function(i, n){
    	        					info += n.name +",";
    	        					code += n.jobnum +",";
								});
    	        				$("#flupDoctorCode").val(info.substring(0, info.length-1));
    	        				$("#hflupDoctorCode").val(code.substring(0, code.length-1));
    	        				$("#flupDoctorCode")[0].focus() ;
    	        				$('#doctorconfast_tab').datagrid('unselectAll');
    	        				$("#doctorconfast_div").panel('close');
    	        				}
							}
    	        		}],
    		      	});
    	        	$('#doctorconfast_tab').datagrid('loadData', data[0].rows);
    	          }
    	    	});
        	serach();
        },
    });
	
	$('#config_list_tab').datagrid( {
		method:'get',
		pagination : true,
		pageNumber:1,
		pageSize : 10,
		pageList : [ 10, 20, 30],
		idField : 'id',
		rownumbers : false,
	    title:'导入规则配置',
		width:'100%',
		queryParams : '',
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'deptCode',
			title : '科室代码',
			width : 80,
			align : 'center',
			hidden:true
		}, {
			field : 'deptName',
			title : '所属科室',
			width : 150,
			align : 'center',
		},
		{
			field : 'returnTotNum',
			title : '复诊总次数',
			width : 100,
			align : 'center',
		},{
			field : 'flupDoctorCode',
			title : '复诊管理医生代码',
			width : 100,
			align : 'center',
			hidden:true
		},{
			field : 'flupDoctorName',
			title : '复诊管理医生',
			width : 200,
			align : 'center',
		},{
			field : 'diagName',
			title : '疾病名称',
			width : 200,
			align : 'center',
		}
		, {
			field : 'diagCode',
			title : '疾病代码',
			width : 150,
			align : 'center',
			hidden:true
		},
		{
			field : 'diagGpcode',
			title : '疾病组代码',
			width : 200,
			align : 'center',
			hidden:true
		},{
			field : 'diagGpname',
			title : '疾病组名称',
			width : 200,
			align : 'center',
		},{
			field : 'id',
			title : 'id',
			width : 150,
			align : 'center',
			hidden:true
		}, {
			field : 'operateDate',
			title : '操作日期',
			width : 110,
			align : 'center',
			hidden:true
		}, {
			field : 'operateEmployeeCode',
			title : '操作工号',
			width : 110,
			align : 'center',
			hidden:true
		},{
			field : 'retplanDeptCode',
			title : '复诊科室代码',
			width : 80,
			align : 'center',
			hidden:true
		} ,{
			field : 'retplanDeptName',
			title : '复诊科室名称',
			width : 80,
			align : 'center',
			hidden:true
		} 
		] ],
		toolbar : [ {
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				$("#type").val("");
				$.messager.confirm('确认','您确认想要将配置规则导入规则配置吗(请填写以上所有的下拉列表)？',function(r){   
					if (r){    
						submit();
						serach();
				    } 
				}); 
			}
		}, "-", {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				var rows = $('#config_list_tab').datagrid('getSelections');
				if (rows == null || rows.length == 0) {
					$.messager.alert('提示', '请选中需要修改的项!', 'info');
					return false;
				} else {
					if(rows.length>1){
						$.messager.alert('提示', '请选中一项在进行修改!', 'info');
					}else{
						//console.info(rows);
						$('#type').val("update");
						$('#id').val(rows[0].id);
						$('#deptCode').combogrid('setValue',rows[0].deptCode);
						if(rows[0].diagGpname==''&&rows[0].diagGpcode==''){
							$("#diagName").val(rows[0].diagName);
							$("#diagCode").val(rows[0].diagCode);
							$("#gpdiagName").attr("disabled","disabled");
							$("#diagName").removeAttr("disabled","disabled");
							$("input[name='rad']").eq(0).attr("checked",true);
							$("input[name='rad']").eq(1).attr("checked",false);
						}else{
							$("input[name='rad']").eq(1).attr("checked",true);
							$("input[name='rad']").eq(0).attr("checked",false);
							$("#gpdiagName").val(rows[0].diagGpname);
							$("#gpdiagCode").val(rows[0].diagGpcode);
							$("#diagName").attr("disabled","disabled");
							$("#gpdiagName").removeAttr("disabled","disabled");
						}
						$('#flupDoctorCode').val(rows[0].flupDoctorName);
						$('#hflupDoctorCode').val(rows[0].flupDoctorCode);
						$('#returnDeptName').val(rows[0].retplanDeptName);
						$('#returnDeptCode').val(rows[0].retplanDeptCode);
						$('#num').val(rows[0].returnTotNum);
						getPanelInfo();
						$.ajax({
			      	    	  type: "post",
			      	          dataType : "json",
			      	          url: 'dataImportRuleAction!getEmployeeByDeptCode.action',
			      	          data:{"department.deptCode":rows[0].deptCode} ,
			      	          success: function(data){
			      	        	$('#doctorconfast_tab').datagrid({ 
			      	        	method:'get',
			      	      		idField : 'jobnum',
			      	      		rownumbers : false,
			      	      		width:'100%',
			      	      		queryParams : '',
			      	      		columns : [ [ {
			      	      			field : 'ck',
			      	      			checkbox : true
			      	      		},
			      	            	        {field:'jobnum',title:'',hidden:true},    
			      	            	        {field:'name',title:'医生姓名',width:210}
			      	            	    ]],
			      	            	  toolbar : [ {
			      	        			text : '增加',
			      	        			iconCls : 'icon-add',
			      	        			handler : function() {
			      	        				var rows = $('#doctorconfast_tab').datagrid('getSelections');
			      	        				var info ="";
			      	        				var code ="";
			      	        				$.each( rows, function(i, n){
			      	        					info += n.name +",";
			      	        					code += n.jobnum +",";
											});
			      	        				$("#flupDoctorCode").val(info.substring(0, info.length-1));
			      	        				$("#hflupDoctorCode").val(code.substring(0, code.length-1));
			      	        				$("#doctorconfast_div").panel('close');
										}
			      	        		}],
			      		      	});
			      	        	$('#doctorconfast_tab').datagrid('loadData', data[0].rows);
			      	          }
			      	    	});
					}
				}
			}
		} , "-",{
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				if($('#type').val()!=""&&$('#type').val()!=null){
					submit();
					serach();
				}
			}
		}, "-",{
			text : '删除',
			iconCls : 'icon-cut',
			handler : function() {
				var rows = $('#config_list_tab').datagrid('getSelections');
				if(rows.length>=1){
					var id = "";
					for ( var i = 0; i < rows.length; i++) {
						id += rows[i].id + ',';
					}
					$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
					    if (r){  
					    	$.ajax({
								type: "post",
					            url: path+'/patiReturnRuleAction!updateRule.action',
					            dataType : "json",
					            data:{"id":id},
					            success: function(data){
					            	$.messager.alert('提示', data[0].message, 'info');
					            	serach();
									clean();
					            },
							});
					    }    
					}); 
				}else{
					$.messager.alert('提示', "请选择一行", 'info');
				}
			}
		}
		],
	});
});
function opfast() {
	$('#confast_div').panel('open');
}

function opfastTable() {
	$('#sfzskwh_sfb_div').panel('open');
}



function serach(){
	var param={'map.deptCode':$("#deptCode").combogrid("getValue")
			};
	 loadData(path+'/patiReturnRuleAction!loadDateGrid.action','config_list_tab',param);
	 $("#config_list_tab").datagrid("uncheckAll");
  }

//监听键疾病盘按键
function keyDown(r){
    $("#confast_div").panel('open');
    var url = '';
    var rad = $("input[name='rad']:checked").val();
    if(rad=="1"){
    	url = '/diagKnowledgeAction!findDiagnosisDict.action';
    }else{
    	url = '/diagGroupAction!findDiagnosisDict.action';
    }
	$.ajax({
        type: "post",
        url: path+url,
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#confast_tab').datagrid({    
        	    columns:[[    
        	        {field:'diagnosisCode',title:'',hidden:true},    
        	        {field:'diagnosisName',title:'',width:210}
        	        
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
        	    	var rad = $("input[name='rad']:checked").val();
        	    	 if(rad=="1"){
        	    		 $("#diagName").val(row.diagnosisName);
     				     $("#diagCode").val(row.diagnosisCode);
        	    	}else{
        	    		 $("#gpdiagName").val(row.diagnosisName);
        	    		 $("#gpdiagCode").val(row.diagnosisCode);
        	    	}
				    $("#confast_div").panel('close');
				},    
        	}); 
       $('#confast_tab').datagrid('loadData', data[0].rows);
    }
});
}

//新增方法
function submit(){
	var text = "";
	for ( var int = 0; int < num; int++) {
		text += $("#"+(int+1)).val() + ",";
	}
	var rad = $("input[name='rad']:checked").val();
	var diag ="";
	var code="";
	var gdiag ="";
	var gcode="";
	 if(rad=="1"){
		 diag = $("#diagName").val() ;
		 code = $("#diagCode").val();
	    }else{
	      gdiag = $("#gpdiagName").val() ;
		  gcode = $("#gpdiagCode").val();
	    }
	 if(rad=="1"){
		 if(diag==''||code==''||$("#deptCode").combogrid("getValue")==''||$("#flupDoctorCode").val()==''||$("#flupCycle").val()==''){
			 $.messager.alert('提示', '请将上面信息填写完整！', 'info');
			 return;
		 }
	 }
	 if(rad=="2"){
		 if(gdiag==''||gcode==''||$("#deptCode").combogrid("getValue")==''||$("#flupDoctorCode").val()==''||$("#flupCycle").val()==''){
			 $.messager.alert('提示', '请将上面信息填写完整！', 'info');
			 return;
		 }
	 }
	$.ajax({
        type: "post",
        url: path+'/patiReturnRuleAction!insert.action',
        dataType : "json",
        data:{"patiReturnRule.returnCycle":text,
        	 "patiReturnRule.id":$("#id").val(),
        	 "patiReturnRule.deptCode":$("#deptCode").combogrid('getValue'),
        	 "patiReturnRule.returnCycle":"",
        	 "patiReturnRule.returnType":"",
        	 "patiReturnRule.returnTotNum":num,
        	 "patiReturnRule.flupDoctorCode":$("#hflupDoctorCode").val(),
        	 "patiReturnRule.diagCode":code,
        	 "patiReturnRule.diagName":diag,
        	 "patiReturnRule.diagGpcode":gcode,
        	 "patiReturnRule.diagGpname":gdiag,
        	 "patiReturnRule.returnDay":$("#returnDay").val(),
        	 "patiReturnRule.returnInfo":$("#returnInfo").val(),
        	 "patiReturnRule.retplanDeptCode": $("#returnDeptCode").val(),
        	 "type":$('#type').val()
        	},
        success: function(data){
        	$.messager.alert('提示', data[0].message, 'info');
        	$("#type").val("");
        },
    });
	clean();
  }

function clean(){
	$('#id').val("");
	$("#diagName").val("");
	$("#diagCode").val("");
	$("#gpdiagName").val("");
	$('#gpdiagCode').val("");
	$('#returnDeptName').val("");
	$('#returnDeptCode').val("");
	$('#flupDoctorCode').val("");
	$('#hflupDoctorCode').val("");
	$('#flupCycle').val("");
	$('#returnDay').val("");
	$('#returnInfo').val("");
	$('#num').val("2");
}
function closeWindow(){
	$("#sfzskwh_sfb_div").panel('close');
}

function setpos() {
	var one = $("#flupDoctorCode").offset();
	var one1 = $("#returnDeptName").offset();
	var one2 ="";
	var rad = $("input[name='rad']:checked").val();
	if(rad=="1"){
		one2=  $("#diagName").offset();
	}else{
		one2=  $("#gpdiagName").offset();
	}
	$("#doctorconfast_div").offset( {
		top : one.top + 20,
		left : one.left	});
	$("#confast_divDept").offset( {
		top : one1.top + 20,
		left : one1.left
	});
	$("#confast_div").offset( {
		top : one2.top + 20,
		left : one2.left+120
	});
}



//获取医生的方法
function getDoctor(){
	  $("#doctorconfast_div").panel('open');
}


function keyMove(e){
	  x=e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft;
	  y=e.clientY+document.body.scrollTop+document.documentElement.scrollTop;
	  var odiv=document.getElementById('doctorconfast_div');
	  var left =odiv.getBoundingClientRect().left;
	  var top = odiv.getBoundingClientRect().top;
	
	  var rdiv=document.getElementById('confast_div');
	  var rleft =rdiv.getBoundingClientRect().left;
	  var rtop = rdiv.getBoundingClientRect().top;
	  
	  var ddiv=document.getElementById("confast_divDept");
	  var dleft =ddiv.getBoundingClientRect().left;
	  var dtop = ddiv.getBoundingClientRect().top;
	  
	  if(x<left||x>(left+220)){
		  $("#doctorconfast_div").panel('close');
	  }else if(y<(top-20)||y>(top+200)){
  		//alert("上下");
  		$("#doctorconfast_div").panel('close');
	  }
	  if(x<rleft||x>(rleft+220)){
		  $("#confast_div").panel('close');
	  }else if(y<(rtop-20)||y>(rtop+150)){
		  $("#confast_div").panel('close');
	  }
	  if(x<dleft||x>(dleft+220)){
		  $("#confast_divDept").panel('close');
	  }else if(y<(dtop-20)||y>(dtop+150)){
		  $("#confast_divDept").panel('close');
	  }
};

//随访周期获取焦的方法
function getflupCycleinfo(){
	 num = $("#num").val();
	$("#add_sfzsk_html").window('open');
	if($("#flupCycle").val()!=""){
		var text = "";
		var str= "text";
		for ( var int = 0; int < num; int++) {
			text += "第"+(int+1)+"次复诊间隔天数:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(int+1)+"'>" +
					"第"+(int+1)+"次复诊内容:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(str+(int+1))+"'></br>" ;
		}
		$("#flupCycleinfo").html(text);
		var info = $("#flupCycle").val();
		var Strinfo = $("#returnInfo").val();
		var Strid = "text";
		var strs= new Array();
		var strsinfo= new Array();
		strs = info.split(",");
		strsinfo =Strinfo.split(",");
		for ( var int = 0; int < strs.length; int++) {
			$("#"+(int+1)).val(strs[int]) ;
		}
		for ( var int = 0; int < strsinfo.length; int++) {
			$("#"+(Strid+(int+1))).val(strsinfo[int]) ;
		}
	}else{
	  getPanelInfo();
	}
}
//弹出层保存的方法
function saveNum(){
	var str = "text";
	for (var int = 0; int < num; int++) {
		if(isNaN($("#"+(int+1)).val())){
			$.messager.alert('提示', '请填写有效数字,再保存!', 'info');
			return;
		}
		if($("#"+(int+1)).val()==''){
			$.messager.alert('提示', '请将填写完整,再保存!', 'info');
			return;
		}
		if($("#"+(str+(int+1))).val()==''){
			$.messager.alert('提示', '请将填写完整,再保存!', 'info');
			return;
		}
	}
	var text = "";
	var textstr ="";
	
	for ( var int = 0; int < num; int++) {
		text += $("#"+(int+1)).val() + ",";
		textstr +=  $("#"+(str+(int+1))).val() + ",";
	}
	$("#returnDay").val(text);
	$("#returnInfo").val(textstr);
	$("#flupCycle").val(text.substring(0, text.length-1));
	$("#num").val(num);
	$("#add_sfzsk_html").window('close');
}

//修改获取弹出层里面的数据
function getPanelInfo(){
	num = $("#num").val();
	var text = "";
	var str= "text";
	for ( var int = 0; int < num; int++) {
		text += "第"+(int+1)+"次复诊间隔天数:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(int+1)+"'>" +
				"第"+(int+1)+"次复诊内容:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(str+(int+1))+"'></br>" ;
	}
	 $("#flupCycleinfo").html(text);
	if ($("#type").val()=='update') {
		var rows = $('#config_list_tab').datagrid('getSelections');
		$.ajax({
	        type: "post",
	        url: path+'/patiReturnRuleAction!getReRetdayDetails.action',
	        dataType : "json",
	        data:{"type":$("#type").val(),"retdayDetail.ruleId":rows[0].id},
	        success: function(data){
	        	var text = "";
	        	var textInfo="";
	        	var strId = "text";
	        	$.each( data[0].rows, function(i, n){
	        		  $("#"+(n.returnNumber)).val(n.returnSerialNumber);
	        		  $("#"+(strId+n.returnNumber)).val(n.returnContent);
	        		  text +=n.returnSerialNumber+",";
	        		  textInfo+=n.returnContent+',';
	        	});
	        	$("#flupCycle").val(text.substring(0, text.length-1));
	        	$("#returnDay").val(text.substring(0, text.length-1));
	        	$("#returnInfo").val(textInfo.substring(0, textInfo.length-1));
	        },
	    });
	}
}

function setDivHeight(divid,num){
	$('#'+divid).window({    
	    width:350,    
	    height:((num*30)+80),    
	    modal:true ,
	}); 
}

function radio_click(obj){
    obj.value=='1'?$("#gpdiagName").attr("disabled","disabled"):$("#diagName").attr("disabled","disabled");
    obj.value=='2'?$("#gpdiagName").removeAttr("disabled","disabled"):$("#diagName").removeAttr("disabled","disabled");
   
}

function addNum(){
		var text= "";
		var str= "text";
		var day="";
		var textstr="";
		for ( var int = 0; int < num; int++) {
			day += $("#"+(int+1)).val() + ",";
			textstr += $("#"+(str+(int+1))).val() + ",";
		}
		 $("#returnDay").val(day);
		 $("#returnInfo").val(textstr);
		 num++;
		for ( var int = 0; int < num; int++) {
			text += "第"+(int+1)+"次复诊间隔天数:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(int+1)+"'>" +
					"第"+(int+1)+"次复诊内容:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(str+(int+1))+"'></br>" ;
		}
		 $("#flupCycleinfo").html(text);
	    day = $("#returnDay").val();
	    textstr =$("#returnInfo").val();
		var days= new Array();
		days = day.split(",");
		var texts= new Array();
		texts = textstr.split(",");
		for ( var int = 0; int < days.length; int++) {
			$("#"+(int+1)).val(days[int]) ;
		}
		for ( var int = 0; int < texts.length; int++) {
			$("#"+(str+(int+1))).val(texts[int]) ;
		}
		
}


function minusNum(){
	var text= "";
	var str= "text";
	var day="";
	var textstr="";
	for ( var int = 0; int < num; int++) {
		day += $("#"+(int+1)).val() + ",";
		textstr += $("#"+(str+(int+1))).val() + ",";
	}
	 $("#returnDay").val(day);
	 $("#returnInfo").val(textstr);
	 num--;
	for ( var int = 0; int < num; int++) {
		text += "第"+(int+1)+"次复诊间隔天数:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(int+1)+"'>" +
				"第"+(int+1)+"次复诊内容:<input style='width:120px  ; border: 1px solid #999;margin-top: 3px'  id ='"+(str+(int+1))+"'></br>" ;
	}
	 $("#flupCycleinfo").html(text);
    day = $("#returnDay").val();
    textstr =$("#returnInfo").val();
	var days= new Array();
	days = day.split(",");
	var texts= new Array();
	texts = textstr.split(",");
	for ( var int = 0; int < days.length; int++) {
		$("#"+(int+1)).val(days[int]) ;
	}
	for ( var int = 0; int < texts.length; int++) {
		$("#"+(str+(int+1))).val(texts[int]) ;
	}
	
}

//监听科室键盘按键
function keyDownDept(r){
    $("#confast_divDept").panel('open');
	$.ajax({
        type: "post",
        url: path+"/patiReturnRuleAction!getDepartmentInfo.action",
        dataType : "json",
        data:{"keyInfo":r.value+"%"},
        success: function(data){
        	$('#confast_tabDept').datagrid({    
        	    columns:[[    
        	        {field:'deptCode',title:'',hidden:true},  
        	        {field:'deptName',title:'科室名称',width:100}, 
        	        {field:'unitCode',title:'院区',width:100,
        	        formatter : function(value,row,index) {
        				if(value=='1'){return '北院';}
        				if(value=='2'){return '南院';}
        			}
        	        }
        	    ]],
        	    singleSelect : true,
        	    onClickRow:function(index,row){
				    $("#returnDeptName").val(row.deptName);
				    $("#returnDeptCode").val(row.deptCode);
				    $("#confast_divDept").panel('close');
				},    
        	}); 
        // console.info(data);
       $('#confast_tabDept').datagrid('loadData', data[0].rows);
    }
});
}