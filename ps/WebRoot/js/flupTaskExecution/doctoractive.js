
//定义一个集合
var arrFileIndex=new Array();
var size=0;

function loadWindow(patiSerial,inpatiNumber,inpatiSerialNumber,flpWay,id,flupPlanDate,flupTimes,medicalInsuranceCode,rel){
		/****
		 * 记录本随访完成后，进行定位列表
		 * @param {Object} r
		 */
		$("#iframe_location").val(rel);
		if($("#doctorWork").tabs("exists","记录本随访")){
			  $.messager.confirm('确认对话框', '上次信息未保存,是否继续下一步操作？', function(r){
					if (r){
						$("#id").val(id);
						$("#inpatiSerialNumber").val(inpatiSerialNumber);
						$("#medicalInsuranceCode").val(medicalInsuranceCode);
						$("#patiSerial").val(patiSerial);
						$("#inpatiNumber").val(inpatiNumber);
						$("#flupPlanDate").val(flupPlanDate);
						$("#flupTimes").val(flupTimes); 
						$("#doctorWork").tabs('close','记录本随访');
						var url;
						if(flpWay==2){
							$("#doctorWork").tabs("select","短信随访");
						}else if(flpWay==1){
							url="/jsp/flupTaskExecution/phonefollow.jsp";
							$('#doctorWork').tabs('add',{    
							    title:'记录本随访',    
							    content:createFrame(path+url),    
							    closable:true,
							    fit:true
							}); 
						}
					}
					
			  });
		}else{
			$("#id").val(id);
			$("#inpatiSerialNumber").val(inpatiSerialNumber);
			$("#medicalInsuranceCode").val(medicalInsuranceCode);
			$("#patiSerial").val(patiSerial);
			$("#inpatiNumber").val(inpatiNumber);
			$("#flupPlanDate").val(flupPlanDate);
			$("#flupTimes").val(flupTimes);
			$("#doctorWork").tabs('close','记录本随访');
			var url;
			if(flpWay==2){
				$("#doctorWork").tabs("select","短信随访");
			}else if(flpWay==1){
				url="/jsp/flupTaskExecution/phonefollow.jsp";
				$('#doctorWork').tabs('add',{    
				    title:'记录本随访',    
				    content:createFrame(path+url),    
				    closable:true,
				    fit:true
				}); 
			}
			
			
		
		}
	
}

function windowInfo(patiSerial,inpatiNumber,inpatiSerialNumber,sbillingCode,hbillingCode,wflupWay,flupType
		,flupObject,flupPeriod,wflupStatus,flupPlanDate,flupMobile,id,flupName,flupTableNameId,name,flupDoctor){
	if($("#doctorWork").tabs("exists","随访属性信息")){
		  var url="/jsp/flupTaskExecution/suifangproperty.jsp";
		  $.messager.confirm('确认对话框', '上次信息未保存,是否继续下一步操作？', function(r){
				if (r){
					$("#dispatch_patiSerial").val(patiSerial);
					$("#dispatch_inpatiNumber").val(inpatiNumber);
					$("#dispatch_inpatiSerialNumber").val(inpatiSerialNumber);
					
					$("#flupDoctor").val(flupDoctor);
					$("#sbillingCode").val(sbillingCode);
					$("#hbillingCode").val(hbillingCode);
					$("#wflupWay").val(wflupWay);
					$("#flupType").val(flupType);
					$("#flupObject").val(flupObject);
					$("#flupPeriod").val(flupPeriod);
					$("#wflupStatus").val(wflupStatus);
					$("#flupPlanDate").val(flupPlanDate);
					$("#flupMobile").val(flupMobile);
					$("#id").val(id);
					$("#flupName").val(flupName);
					$("#flupTableNameId").val(flupTableNameId);
					$("#name").val(name);
					$("#doctorWork").tabs('close','随访属性信息');
					$("#doctorWork").tabs('close','记录本随访');
					$('#doctorWork').tabs('add',{    
					    title:'随访属性信息',    
					    content:createFrame(path+url),    
					    closable:true,
					    fit:true
					});
					//parent.loadBingDetail(patiSerial,inpatiNumber,inpatiSerialNumber);
					$("#doctorWork").tabs("select","病例基本信息");
					
				}
		  });
	}else{
		$("#dispatch_patiSerial").val(patiSerial);
		$("#dispatch_inpatiNumber").val(inpatiNumber);
		$("#dispatch_inpatiSerialNumber").val(inpatiSerialNumber);
		
		$("#flupDoctor").val(flupDoctor);
		$("#sbillingCode").val(sbillingCode);
		$("#hbillingCode").val(hbillingCode);
		$("#wflupWay").val(wflupWay);
		$("#flupType").val(flupType);
		$("#flupObject").val(flupObject);
		$("#flupPeriod").val(flupPeriod);
		$("#wflupStatus").val(wflupStatus);
		$("#flupPlanDate").val(flupPlanDate);
		$("#flupMobile").val(flupMobile);
		$("#id").val(id);
		$("#flupName").val(flupName);
		$("#flupTableNameId").val(flupTableNameId);
		$("#name").val(name);
		
		$("#doctorWork").tabs('close','随访属性信息');
		$("#doctorWork").tabs('close','记录本随访');
		var url="/jsp/flupTaskExecution/suifangproperty.jsp";
		$('#doctorWork').tabs('add',{    
		    title:'随访属性信息',    
		    content:createFrame(path+url),    
		    closable:true,
		    fit:true
		}); 
		
		$("#doctorWork").tabs("select","病例基本信息");
		
	}
}


function getPatiInfo(patiSerial,inpatiNumber,inpatiSerialNumber){
	$("#dispatch_patiSerial").val(patiSerial);
	$("#dispatch_inpatiNumber").val(inpatiNumber);
	$("#dispatch_inpatiSerialNumber").val(inpatiSerialNumber);
}


function windowInfo2(patiSerial,inpatiNumber,inpatiSerialNumber,sbillingCode,hbillingCode,wflupWay,flupType
		,flupObject,flupPeriod,wflupStatus,flupPlanDate,flupMobile,id,flupName,flupTableNameId,name,flupDoctor){
	if($("#doctorWork").tabs("exists","随访属性信息")){
		  var url="/jsp/flupTaskExecution/suifangproperty.jsp";
//		  $.messager.confirm('确认对话框', '上次信息未保存,是否继续下一步操作？', function(r){
//				if (r){
					$("#dispatch_patiSerial").val(patiSerial);
					$("#dispatch_inpatiNumber").val(inpatiNumber);
					$("#dispatch_inpatiSerialNumber").val(inpatiSerialNumber);
//					$("#medicalInsuranceCode").val(medicalInsuranceCode);
					
					$("#flupDoctor").val(flupDoctor);
					$("#sbillingCode").val(sbillingCode);
					$("#hbillingCode").val(hbillingCode);
					$("#wflupWay").val(wflupWay);
					$("#flupType").val(flupType);
					$("#flupObject").val(flupObject);
					$("#flupPeriod").val(flupPeriod);
					$("#wflupStatus").val(wflupStatus);
					$("#flupPlanDate").val(flupPlanDate);
					$("#flupMobile").val(flupMobile);
					$("#id").val(id);
					$("#flupName").val(flupName);
					$("#flupTableNameId").val(flupTableNameId);
					$("#name").val(name);
					$("#doctorWork").tabs('close','随访属性信息');
					$('#doctorWork').tabs('add',{    
					    title:'随访属性信息',    
					    content:createFrame(path+url),    
					    closable:true,
					    fit:true
					});
					//parent.loadBingDetail(patiSerial,inpatiNumber,inpatiSerialNumber);
					$("#doctorWork").tabs("select","记录本随访");
					
				}
//		  });
//	}else
//	{
//		$("#dispatch_patiSerial").val(patiSerial);
//		$("#dispatch_inpatiNumber").val(inpatiNumber);
//		$("#dispatch_inpatiSerialNumber").val(inpatiSerialNumber);
//		
//		$("#flupDoctor").val(flupDoctor);
//		$("#sbillingCode").val(sbillingCode);
//		$("#hbillingCode").val(hbillingCode);
//		$("#wflupWay").val(wflupWay);
//		$("#flupType").val(flupType);
//		$("#flupObject").val(flupObject);
//		$("#flupPeriod").val(flupPeriod);
//		$("#wflupStatus").val(wflupStatus);
//		$("#flupPlanDate").val(flupPlanDate);
//		$("#flupMobile").val(flupMobile);
//		$("#id").val(id);
//		$("#flupName").val(flupName);
//		$("#flupTableNameId").val(flupTableNameId);
//		$("#name").val(name);
//		
//		$("#doctorWork").tabs('close','随访属性信息');
//		var url="/jsp/flupTaskExecution/suifangproperty.jsp";
//		$('#doctorWork').tabs('add',{    
//		    title:'随访属性信息',    
//		    content:createFrame(path+url),    
//		    closable:true,
//		    fit:true
//		}); 
//		
//		$("#doctorWork").tabs("select","记录本随访");
//		
//	}
}

function loadHistoryInfo(patiSerial,inpatiNumber,inpatiSerialNumber,name){
	$("#mh_patiSerial").val(patiSerial);
	$("#mh_inpatiNumber").val(inpatiNumber);
	$("#mh_inpatiSerialNumber").val(inpatiSerialNumber);
	$("#mh_name").val(name);
	
	var url="/jsp/flupTaskExecution/medicalHistory.jsp";
	$('#doctorWork').tabs('add',{    
	    title:'病史信息',    
	    content:createFrame(path+url),    
	    closable:true,
	    fit:true
	});
	
}

/*function  loadBingDetail(patiSerial,inpatiNumber,inpatiSerialNumber){
	  if (!$('#doctorWork').tabs('exists', "病例基本信息")) {
		  $("#patiSerial").val(patiSerial);
		  $("#inpatiNumber").val(inpatiNumber);
		  $('#inpatiSerialNumber').val(inpatiSerialNumber);
		  
		  url="/jsp/caseManagement/addbinli.jsp";
        $('#doctorWork').tabs('add', {
            title: "病例基本信息",
            content: createFrame(path+url),
            closable: true
        });
    } 
}*/

function closeChild(){
	$("#doctorWork").tabs("close","记录本随访");
	$("#doctorWork").tabs("select","随访任务列表");
}