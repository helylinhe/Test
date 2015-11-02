  $(function(){
	         var currentIndex=-1;
			 $('#keshisuifangcxtable').datagrid( {
					url : '../data/suifangProjectMaintain.json',
					method:'get',
					collapsible : false,
					remoteSort : false,
					idField : 'id',
					rownumbers : true,
					queryParams : '',
					singleSelect : true,
				    title:'科室随访统计内容',
					pagination : true,
					pageSize:20,
                    pageList:[20,40],
					frozenColumns:[[
						{
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
					    width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'one2',
						title : '姓名',
					    width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					]],
					columns : [[ {
						field : 'one3',
						title : '性别',
					    width : 50,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}, {
						field : 'one4',
						title : '年龄',
						width : 50,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one5',
						title : '所属科室',
						width : 100,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one6',
						title : '出院诊断',
						width : 200,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one7',
						title : '付款方式',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one8',
						title : '随访状态',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one9',
						title : '随访分类',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one10',
						title : '随访方式',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one11',
						title : '随访医生',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					},{
						field : 'one12',
						title : '操作日期',
						width : 80,
						align : 'center',
						formatter : function(val, rec) {
							return val;
						}
					}
					]],
			 });  
          var keshisuifangcxtable_data={"total":40,"rows":[
                     	//此处为东方医院心内科冠心病数据项目
                   {"one":"0001","one1":"2014010001","one2":"钟俊飞","one3":"男","one4":"29","one5":"骨科","one6":"无","one7":"医保","one8":"随访期","one9":"专科","one10":"上门","one11":"王宁","one12":"2014-02-02"} , 
					 {"one":"0001","one1":"2014010001","one2":"钟俊飞","one3":"男","one4":"29","one5":"骨科","one6":"无","one7":"干保","one8":"随访期","one9":"专科","one10":"上门","one11":"王宁","one12":"2014-02-02"} , 
					   {"one":"0001","one1":"2014010001","one2":"钟俊飞","one3":"男","one4":"29","one5":"骨科","one6":"无","one7":"居保","one8":"随访期","one9":"专科","one10":"上门","one11":"王宁","one12":"2014-02-02"} , 
					   {"one":"0001","one1":"2014010001","one2":"钟俊飞","one3":"男","one4":"29","one5":"骨科","one6":"无","one7":"社保","one8":"随访期","one9":"专科","one10":"上门","one11":"王宁","one12":"2014-02-02"} , 
					   {"one":"0001","one1":"2014010001","one2":"钟俊飞","one3":"男","one4":"29","one5":"骨科","one6":"无","one7":"医保","one8":"随访期","one9":"专科","one10":"上门","one11":"王宁","one12":"2014-02-02"} , 

						]}
			            $('#keshisuifangcxtable').datagrid('loadData', keshisuifangcxtable_data);
  });

             