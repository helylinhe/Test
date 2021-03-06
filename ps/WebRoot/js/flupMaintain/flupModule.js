$(function() {
	
	
	$.ajax({
        type: "post",
        url: 'flupmoduleaction!loadCombobox.action',
        dataType : "json",
        success: function(data){
        	//one3
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
        	});
        	//maintainDept
        	$('#wdeptCode').combogrid({    
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
        	});
        	//umaintainDept
        	$('#udeptCode').combogrid({    
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
        	});
//        	$('#deptCode').combobox('select', data[0].department[0].deptCode);
//        	$('#wdeptCode').combobox('select', data[0].wdepartment[0].deptCode);
//        	$('#udeptCode').combobox('select', data[0].udepartment[0].deptCode);	
        	loadData(path+'/flupmoduleaction.action','flupModule_table',{'map.deptCode': $('#deptCode').combogrid("getValue")});
        }
        });
	
	//进入页面加载数据
	//loadData(path+'/flupmoduleaction.action','flupModule_table',null);
	//触发点击按钮事件
	$('#queryInfo').click(function(){
		var param ={'map.maintainDept':$("#deptCode").combogrid("getValue"),'map.infoBeyone': $('#one4').val(),'map.infoName' : $('#one1').val(),'map.infoBelong' : $('#one5').val(),'map.infoContent' :$('#one2').val()};
		loadData(path+'/flupmoduleaction.action','flupModule_table',param);
	});
	// 绘制表格
	$('#flupModule_table').datagrid( {
		// url : '',
		method : 'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : true,
		title : '信息随访模板',
		striped : true,
		pagination : true,
		pageSize : 10,
		fitColumns : true,
		pageList : [ 10, 20 ],
		
		
		
		
		
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, 
		{
			hidden : true,
			field : 'id',
			title : '编号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}
		, 
		{
			hidden : true,
			field : 'infoCode',
			title : '信息编号',
			width : 80,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}
		, {
			field : 'infoName',
			title : '信息名称',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'infoContent',
			title : '信息内容',
			width : 600,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'maintainDept',
			title : '所属科室',
			width : 120,
			align : 'center',
			hidden: true
			
		},{
			field : 'maintainDeptName',
			title : '所属科室',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'infoBeyone',
			title : '信息归属',
			width : 120,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'infoBelong',
			title : '信息类别',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'operateDate',
			title : '操作日期',
			width : 150,
			align : 'center',
			formatter : function(val, rec) {
				//return getNowFormatDate();
				return val;
			}
		}, {
			field : 'operateEmpolyeeCode',
			title : '操作员',
			width : 100,
			align : 'center',
			formatter : function(val, rec) {
//				return '雷玉斌';
					return val;
			}
		} ] ],
		toolbar : [ {
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				$("#add_sftable_html").window("open");
			}
		}, "-", {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				var rows = $('#flupModule_table').datagrid('getSelections');
				if (rows == null || rows.length == 0) {
					$.messager.alert('提示', '请选中需要修改的项!', 'info');
					return false;
				} else {
							var row = $('#flupModule_table').datagrid('getSelected');
							if(row){
								$('#update_sftable_html').dialog('open').dialog('setTitle');
								$('#fm').form('load',row);
							}
				}
			}
		} ],
		onClickRow : function(index, row) {
			
			/*
			$("#deptCode").combobox("setValue",row.maintainDept);
			
			$("#one4").val(row.infoBeyone);
			$("#one5").val(row.infoBelong);
			$("#one1").val(row.infoName);
			$("#one2").val(row.infoContent);
			*/
		}
	});
	
	$('#add').click(function(){
		/****
		 * 修改弹出层的Title
		 */
		$("#add_sftable_html").attr("title","信息随访模板添加")
		//var infoCode = $('#infoCode').val();
		var infoName = $('#infoName').val();
		var infoContent = $('#infoContent').val();
		var maintainDept = $('#wdeptCode').combogrid('getValue');
		var infoBeyone = $('#infoBeyone').val();
		var infoBelong = $('#infoBelong').val();
		/*
		if(infoCode == null || infoCode.length == 0 || infoCode.replace(/\s/g,"").length==0){
			 $.messager.alert('警告！','信息编号不能为空！','error');
			return;
		}
		*/
			if(maintainDept == null || maintainDept.length == 0 || maintainDept.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','所属科室不能为空！','error');
				return;
			}
			if(infoName == null || infoName.length == 0 || infoName.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','信息名称不能为空！','error');
				return;
			}
			if(infoContent == null || infoContent.length == 0 || infoContent.replace(/\s/g,"").length==0){
				 $.messager.alert('警告！','信息内容不能为空！','error');
				return;
			}
		
		$.messager.confirm("添加信息随访模板维护","确认添加？",function(r){
			if(r){
				$.post(
						path+"/flupmoduleaction!addFlupModule.action",
						{
							// infoCode : infoCode,
							infoName : infoName,
							infoContent : infoContent,
							maintainDept : maintainDept,
							infoBeyone : infoBeyone,
							infoBelong : infoBelong
						},
						function(data)
						{
							if(data=='success'){
								$.messager.alert('消息','添加成功','info');
								$('#add_sftable_html').dialog('close');
								/****
								 * 清空弹出层中的一些信息
								 */
								$("#infoCode").val(""); //信息编号清空
								$("#infoName").val(""); //信息名称清空
								$("#infoContent").val(""); //信息内容清空
								window.location.reload();
							}else{
								//$.messager.alert('消息','添加失败','error');
								$.messager.alert('消息','添加失败,该信息已经存在','error');
							}
						},'text');
			}
		});
	});
	
	//修改
	$('#update').click(function(){
		
		/****
		 * 修改弹出层的Title
		 */
		$("#add_sftable_html").attr("title","信息随访模板修改")
		
		var infoCode = $('#uinfoCode').val();
		var infoName = $('#uinfoName').val();
		var infoContent = $('#uinfoContent').val();
		var maintainDept = $('#udeptCode').combogrid("getValue");
		var infoBeyone = $('#uinfoBeyone').val();
		var infoBelong = $('#uinfoBelong').val();
		
		if(maintainDept == null || maintainDept.length == 0 || maintainDept.replace(/\s/g,"").length==0){
			 $.messager.alert('警告！','所属科室不能为空！','error');
			return;
		}
		if(infoCode == null || infoCode.length == 0 || infoCode.replace(/\s/g,"").length==0)
		{
				$.messager.alert('警告！','信息编号不能为空！','error');
				return;
		}
		
		if(infoContent == null || infoContent.length == 0 || infoContent.replace(/\s/g,"").length==0)
		{
				$.messager.alert('警告！','信息内容不能为空！','error');
				return;
		} 
		$.messager.confirm('修改随访模板维护','确认修改？',function(r){
			if(r){
				$.post(
					path+"/flupmoduleaction!updateFlupModule.action",
					{
							//id : $('#uid').val(),
							infoCode : infoCode,
							infoName : infoName,
							infoContent : infoContent,
							maintainDept : maintainDept,
							infoBeyone : infoBeyone,
							infoBelong : infoBelong
					},
					function(data){
						if(data == 'success'){
								$.messager.alert('消息','修改成功','info');
								$('#update_sftable_html').dialog('close')
								window.location.reload();
							}else{
								$.messager.alert('消息','修改失败','error');
							}
					},'text'
						
				);
			}
		});
	});
	/*
	 加载数据
	var blxx_list_tab = {
		"total" : 40,
		"rows" : [
				{
					"id" : 0,
					"one" : "001",
					"one1" : "脊柱专科1",
					"one2" : "为保证您顺利康复,请于出院后一个月,携带出院小结和映像资料,进行随访复查,感谢您的信任！",
					"one3" : "骨科",
					"one4" : "个人",
					"one5" : "康复提示",
					"one6" : "男",
					"one7" : "雷玉斌"
				},
				{
					"id" : 1,
					"one" : "002",
					"one1" : "脊柱专科2",
					"one2" : "五一劳动节终到来，歇歇；工作压力繁琐事，放放；家人朋友和知己，聚聚；大好河山南北方，转转；放松身心真愉快，乐乐；劳动让世界发展，劳动令生活美好，劳动是一切幸福的源泉。五一劳动节来临之际，祝朋友们身体健康，假期愉快！",
					"one3" : "骨科",
					"one4" : "个人",
					"one5" : "节日问候",
					"one6" : "男",
					"one7" : "雷玉斌"
				},
				{
					"id" : 2,
					"one" : "003",
					"one1" : "脊柱专科3",
					"one2" : "亲爱的患者，在您生日来临之际，本院祝您身体健康，阖家欢乐！",
					"one3" : "骨科",
					"one4" : "个人",
					"one5" : "生日问候",
					"one6" : "男",
					"one7" : "雷玉斌"
				},
				{
					"id" : 3,
					"one" : "004",
					"one1" : "内科1",
					"one2" : "晨起喝杯水不但可以预防晨练出现意外，还有利尿排毒、防治便秘、促进全身血液循环的功效，晨起后喝温开水以1杯（150-200毫升）为宜",
					"one3" : "内科",
					"one4" : "个人",
					"one5" : "康复指导",
					"one6" : "男",
					"one7" : "30"
				} ]
	}
	$('#safe_list_tab').datagrid('loadData', blxx_list_tab);
	*/
});
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