  //项目大类,小类
  $(function(){
	          $('#ssks_tab').datagrid( {
					url : '../data/suifang_sflljl.json',
					method:'get',
					collapsible : true,
					remoteSort : false,
					rownumbers : false,
					queryParams : '',
					singleSelect :true,
				    pagination : false,
					pageSize:5,
                    pageList:[20,40],
					columns : [[{
						field : 'one',
						title : '科室编号',
						width : 55,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'one1',
						title : '科室名称',
					    width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					]],
                    onDblClickRow: function (index, row) {
				                        $("#one4").val(row.one1);
										$('#ssks_div').panel('close');
                    },onLoadSuccess:function(){
					   $('#ssks_div').panel('close');
					}
				
             });  
           var ssks_name={"total":40,"rows":[{"one":"000","one1":"心内科"},
                     	{"one":"001","one1":"外科"},{"one":"002","one1":"内科"},{"one":"003","one1":"骨科"},]}
			            $('#ssks_tab').datagrid('loadData', ssks_name);

          $('#zyzd_tab').datagrid( {
					url : '../data/suifang_sflljl.json',
					method:'get',
					fitColumns : true,
					collapsible : true,
					remoteSort : false,
					rownumbers : false,
					queryParams : '',
					singleSelect :true,
				    pagination : false,
					pageSize:5,
                    pageList:[20,40],
					columns : [[{
						field : 'one',
						title : '诊断编号',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'one1',
						title : '诊断名称',
					    width : 150,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					]],
                    onDblClickRow: function (index, row) {
				                        $("#one5").val(row.one1);
										$('#zyzd_div').panel('close');
                    }
				,onLoadSuccess:function(){
					   $('#zyzd_div').panel('close');
					}
             });  
			  var zyzd_name={"total":40,"rows":[
                     {"one":"001","one1":"冠心病"}]}
			            $('#zyzd_tab').datagrid('loadData',zyzd_name);
			});
			             		
	  //所属科室	 	
      function bb()
	   {
			      $('#ssks_div').panel('open');
	   }
   //主要诊断
	 function bb1()
	         {
			      $('#zyzd_div').panel('open');
			 }
	
	 //清除
	 function clearTxt(){
	                        $("#one1").val("");
							$("#one2").val("");
							$("#one3").val("");
							$("#one4").val("");
							$("#one5").val("");
							
	 } 
    //加载随访表数据

	 $(function(){
	   var currentIndex=-1;
			 $('#tabledata_tab').datagrid( {
					url : '../data/suifang_sflljl.json',
					method:'get',
					collapsible : false,
					remoteSort : false,
					idField : 'id',
					rownumbers : true,
					title:'随访表信息',
					queryParams : '',
					singleSelect : true,
				    pagination : true,
					pageSize:20,
                    pageList:[20,40],
					frozenColumns:[[
						{
						field : 'one',
						title : '随访表代码',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'one1',
						title : '随访表名',
					    width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}]],
					columns : [[ {
						field : 'one2',
						title : '随访类别',
					    width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					, {
						field : 'one3',
						title : '随访周期',
					    width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'one4',
						title : '所属科室',
						width : 150,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one5',
						title : '主要诊断',
						width : 150,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one6',
						title : '操作日期',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one7',
						title : '操作医生',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					]], toolbar:[
						 {
							 text:'新增',
							 iconCls:'icon-add',
							 handler:function(){add_sfbwh_winopen();}
                         },'-',
					     {
							 text:'修改',
							 iconCls:'icon-edit',
							 handler:function(){
										        if(currentIndex==-1){
															$.messager.alert('提示', '请选择需要修改的项!', 'info');
																return false;
														} else {

															add_sfbwh_winopen();
													 }
							 }
                        },'-',
						{
							 text:'删除',
							 iconCls:'icon-remove',
							 handler:function(){
							            if(currentIndex==-1){
												$.messager.alert('提示', '请选择需要删除的项!', 'info');
												return false;
										} else {
										   if(confirm("你确定要删除该条记录吗?")){
													 $('#tabledata_tab').datagrid('deleteRow',currentIndex);
													 $.messager.alert('提示', '删除成功!', 'info');
										 }
			                       
			                           }
							 }
                         },'-',
						{
							 text:'清除文本框',
							 iconCls:'icon-remove',
							 handler:function(){clearTxt();}
                         }
					],onDblClickRow: function (index, row){
					       
					},onClickRow:function(index,row){
					    clearTxt();
						$("#one1").val(row.one1);
						$("#one2").val(row.one2);
						$("#one3").val(row.one3);
						$("#one4").val(row.one4);
						$("#one5").val(row.one5);
					   currentIndex=index;
					}
             });   
          var sfbwh_tab={"total":40,"rows":[
                     	{"one":"0000","one1":"冠心病随访","one2":"专科","one3":"1月","one4":"心内科","one5":"","one6":"2012-12-12","one7":"王平"},
						{"one":"0001","one1":"糖尿病随访","one2":"专科","one3":"1月","one4":"内科","one5":"","one6":"2012-12-12","one7":"王平"}
						]}
			            $('#tabledata_tab').datagrid('loadData', sfbwh_tab);
            
	 });
	 
	 