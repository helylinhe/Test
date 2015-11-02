$(function(){
     $('#startDate').val(getNowFormatDate());
     $('#endDate').val(getNowFormatDate());
	 
    selectTime();

 });
function getNowFormatDate(){
    var day = new Date();
    var Year = 0;
    var Month = 0;
    var Day = 0;
    var CurrentDate = "";
    Year= day.getFullYear();//支持IE和火狐浏览器.
    Month= day.getMonth()+1;
    Day = day.getDate();
    CurrentDate += Year+"-";
    if (Month >= 10 ){
     CurrentDate += Month;
    }
    else{
     CurrentDate += "0" + Month+"-";
    }
    if (Day >= 10 ){
     CurrentDate += Day ;
    }
    else{
     CurrentDate += "0" + Day ;
    }
   return CurrentDate;
 } 
 function selectTime(){
	     var ev = $('#endDate').val();
		 var sv = $('#startDate').val();
		 $('#startDate').click(function() {
		      if (ev) {
		        WdatePicker({
		          minDate: '{%y-5}-%M-%d',
		          maxDate: ev,
		          readOnly: true
		        });
		      } else {
		        WdatePicker({
		          onpicked: function() {
		            $('#endDate').focus();
		          },
		          minDate: '{%y-5}-%M-%d',
		          maxDate : '%y-%M-%d',
		          readOnly: true
		        });
		      }
		    });
		$('#shoushuDate').click(function(){
			if(sv && ev){
			  WdatePicker({
		            minDate: $('#startDate').val(),
		            maxDate : $('#endDate').val(),
		            readOnly: true
		          });
			}
	
		});
		 $('#endDate').click(function() {
		        if (sv) {
		          WdatePicker({
		            minDate: sv,
		            //maxDate : '%y-%M-%d',
		            readOnly: true
		          });
		        } else {
		          $('#startDate').focus();
		        }
		   });
	}
	
	
//诊断信息
$(function(){
	var ids=[];
  $('#grid_table1').datagrid( {
		url : '',
		method:'get',
		fitColumns:true,
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		striped:true,
		title:'诊断信息',
		columns : [ [ {
			field : 'one1',
			title : '诊断类别',
			width : 100,
			align : 'center'
		},{
			field : 'one2',
			title : '诊断名称',
			width : 150,
			align : 'center'
		},{
			field : 'one3',
			hidden:true,
			title : '诊断代码',
			width : 30,
			align : 'center'
		}
		]]
	});		
});

//手术信息
$(function(){
	var ids=[];
  	$('#grid_table2').datagrid( {
		url : '',
		method:'get',
		fitColumns:true,
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		striped:true,
		title:'手术信息',
		columns : [ [ {
			field : 'one1',
			title : '手术名称',
			width : 100,
			align : 'center'
		},{
			field : 'one2',
			title : '主刀医生',
			width : 50,
			align : 'center'
		},{
			field : 'one3',
			title : '手术日期',
			width : 60,
			align : 'center'
		},{
			field : 'one4',
			title : '手术小结',
			width : 40,
			align : 'center'
		}
		]]
	});		
});

//检验
$(function(){
	var ids=[];
  	$('#grid_table3').datagrid( {
		url : '',
		method:'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		striped:true,
		title:'检验信息',
		frozenColumns:[[
			{
			field : 'one1',
			title : '样本类型',
			width : 55,
			align : 'center'
		},{
			field : 'one2',
			title : '项目名称',
			width : 80,
			align : 'center'
		}
		]],
		columns : [ [{
			field : 'one3',
			title : '检验结果',
			width : 55,
			align : 'center'
		},{
			field : 'one4',
			title : '参考范围',
			width : 60,
			align : 'center'
		},{
			field : 'one5',
			title : '检验日期',
			width : 60,
			align : 'center'
		},{
			field : 'one6',
			title : '检验医生',
			width : 60,
			align : 'center'
		},{
			field : 'one7',
			title : '审核医生',
			width : 60,
			align : 'center'
		},{
			field : 'one8',
			title : '结果单位',
			width : 55,
			align : 'center'
		}
	]]
});		

});

//检查
$(function(){
var ids=[];
$('#grid_table4').datagrid( {
		url : '',
		method:'get',
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		striped:true,
		title:'检查信息',
		frozenColumns:[[
			{
			field : 'one1',
			title : '报告类型',
			width : 55,
			align : 'center'
		},{
			field : 'one2',
			title : '报告编号',
			width : 80,
			align : 'center'
		}
		]],
		columns : [ [ {
			field : 'one3',
			title : '检查日期',
			width : 60,
			align : 'center'
		},{
			field : 'one4',
			title : '检查部位',
			width : 100,
			align : 'center'
		},{
			field : 'one5',
			title : '临床诊断',
			width : 100,
			align : 'center'
		},{
			field : 'one6',
			title : '检查所见',
			width : 100,
			align : 'center'
		},{
			field : 'one7',
			title : '结论',
			width : 100,
			align : 'center'
		},{
			field : 'one8',
			title : '检查医师',
			width : 60,
			align : 'center'
		},{
			field : 'one9',
			title : '报告医师',
			width : 60,
			align : 'center'
		},{
			field : 'one10',
			title : '审核医师',
			width : 60,
			align : 'center'
		}
		]]
	});		
});


//病人就诊信息
$(function(){
	$('#visit_grid').datagrid( {
		url : '',
		method:'get',
		fitColumns:true,
		collapsible : false,
		remoteSort : false,
		idField : 'id',
		rownumbers : true,
		queryParams : '',
		singleSelect : false,
		title:'就诊信息表',
		pagination : true,
		pageSize:20,
		pageList:[20,40],
		columns : [ [{
			field : 'one1',
			title : '住院号',
			width : 40,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one2',
			title : '住院流水号',
			width : 50,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}, {
			field : 'one3',
			title : '入院日期',
			width : 60,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'one4',
			title : '出院日期',
			width : 60,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'one5',
			title : '主治医生',
			width : 60,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'one6',
			title : '所属科室',
			width : 300,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		},{
			field : 'one7',
			title : '出院小结',
			width : 40,
			align : 'center',
			formatter : function(val, rec) {
				return val;
			}
		}
		]],
   });     
   
   var visit_data={"total":40,"rows":[
   		{"id":0,"one1":"10021","one2":"20140410","one3":"2014-4-10","one4":"2014-5-10","one5":"周六","one6":"心血管内科","one7":"<a href='#' style='font-size:12px;' onclick='verdict_open()'>调阅</a>"},
   		{"id":1,"one1":"10021","one2":"20140315","one3":"2014-3-1","one4":"2014-3-15","one5":"赵武","one6":"骨科","one7":"<a href='#' style='font-size:12px;' onclick='verdict_open()'>调阅</a>"},
   		{"id":2,"one1":"10021","one2":"20130615","one3":"2013-6-15","one4":"2013-8-13","one5":"李四","one6":"胆石外科","one7":"<a href='#' style='font-size:12px;' onclick='verdict_open()'>调阅</a> "},
   		{"id":3,"one1":"10021","one2":"20121127","one3":"2012-11-27","one4":"2013-1-8","one5":"钟俊飞","one6":"心脏外科","one7":"<a href='#' style='font-size:12px;' onclick='verdict_open()'>调阅</a>"}
	]}
	$('#visit_grid').datagrid('loadData', visit_data);
});       

function verdict_open(){
	$("#verdict_windows").window("open");
}