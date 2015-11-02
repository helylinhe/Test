function loadData(url,obj,param){
	$.post(url,param,function(data){
		if(data[0].rows!=null && data[0].rows!=''){
			var blm_datapatient_data={"total":data[0].totalRecord,"rows":data[0].rows};
			$('#'+obj).datagrid('loadData', blm_datapatient_data);
		}else{
			$('#'+obj).datagrid('loadData',{ total: 0, rows: [] });
		}
		 var p = $('#'+obj).datagrid('getPager'); 
		  $(p).pagination({
			  		pageNumber: data[0].pageNo,
		  			beforePageText: '第',//页数文本框前显示的汉字 
					afterPageText: '页    共 '+data[0].totalPage+' 页', 
					displayMsg: '当前显示 {from} - {to} 条记录   共 '+data[0].totalRecord+'条记录',
					onSelectPage:function (pageNumber, pageSize){
			  		if(param!=null){
				  		delete param["page.pageNo"]; 
				  		delete param["page.pageSize"]; 
			  		}
			  			var data = $.extend({'page.pageNo':pageNumber,'page.pageSize':pageSize}, param);
						$.post(url,data,function (d){
							$('#'+obj).datagrid("unselectAll");
							$('#'+obj).datagrid('loadData',{"total":d[0].totalRecord,"rows":d[0].rows});
							$('#'+obj).datagrid('getPager').pagination({
								beforePageText: '第',//页数文本框前显示的汉字 
								afterPageText: '页    共 '+d[0].totalPage+' 页', 
								displayMsg: '当前显示 {from} - {to} 条记录   共 '+d[0].totalRecord+'条记录'
							});	
							
						},'json')
					}
		  });
	},'json')
}

/****
 * 
 * @param obj1 表示文本款
 * @param obj2 浮动层
 * @return
 */
function position(obj1,obj2){
	 var off= $("#"+obj1).offset();
	 $("#"+obj2).offset( {
			top : off.top + 20,
			left : off.left
		});
}

/****
 * 
 * 清除浮动弹出层
 */
function clearFloalDiv(parentDiv,childDiv){
	$("#"+parentDiv).panel('close');
	if(childDiv!=null){
		$("#"+childDiv).panel('close');
	}
}


/* 方法:Array.remove(dx)
 * 功能:删除数组元素.
 * 参数:dx删除元素的下标.
 * 返回:在原数组上修改数组
 */

//经常用的是通过遍历,重构数组.
Array.prototype.remove=function(dx)
{
  if(isNaN(dx)||dx>this.length){return false;}
  for(var i=0,n=0;i<this.length;i++)
  {
      if(this[i]!=this[dx])
      {
          this[n++]=this[i]
      }
  }
  this.length-=1
}



//在数组中获取指定值的元素索引
Array.prototype.getIndexByValue= function(value,groupOne)
{
  var index = -1;
  for (var i = 0; i < this.length; i++)
  {
      if ((this[i].flupGroup.itemName == value) &&(this[i].flupGroup.groupOne==groupOne))
      {
          index = i;
          break;
      }
  }
  return index;
}


/*
 * 
 * 
 *  判断重复，重复数据不能进行添加
 */

function checkDistine(arr,value,groupOne,groupTwo){
	var flag=false;
	 for (var i = 0; i < arr.length; i++){
		/* if(arr[i].flupGroup.groupTwo!=null && groupTwo!=""){
			 if((arr[i].flupGroup.itemName == value) &&(arr[i].flupGroup.groupOne==groupOne) && (arr[i].flupGroup.groupTwo==groupTwo)){
				 flag=true;
			 } 
		 }else{
			 if((arr[i].flupGroup.itemName == value) &&(arr[i].flupGroup.groupOne==groupOne)){
				 flag=true;
			 }
		 }*/
		 if((arr[i].flupGroup.itemName == value) &&(arr[i].flupGroup.groupOne==groupOne) && (arr[i].flupGroup.groupTwo==groupTwo)){
			 flag=true;
		 }else{
			 flag=false;
		 } 
	 }
	 
	 return flag;
}


/****
 * 时间比较
 * @param startTime
 * @param endTime
 * @return
 */
//2014-08-04
//2014-08-14
function compareTime(startTime,endTime) {
    var arr = startTime.split("-");
    var starttime = new Date(arr[0], arr[1],arr[2]);
    var starttimes = starttime.getTime();
    var arrs = endTime.split("-");
    var lktime = new Date(arrs[0], arrs[1],arrs[2]);
    var lktimes = lktime.getTime();
    if (starttimes <= lktimes) {
    	 return true;
    } else{
        return false;
    }

}
