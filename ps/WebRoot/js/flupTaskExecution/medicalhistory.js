$(function (){
	
	$('#attackYearmon').val("");
	$('#attackYearmon').click(function() {
		WdatePicker( {
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});
	
	$('#diagDate').val("");
	$('#diagDate').click(function() {
		WdatePicker( {
			minDate : '{%y-80}-%M-%d',
			readOnly : true
		});
	});
	
	var param={};
	$.post(path+'/medicalHistoryaction!findICD10.action',param,function (data){
		var html="<option value=''></option>";
		for(var i=0;i<data.length;i++){
			html+="<option value="+data[i].diagnosisCode+">";
			html+=data[i].diagnosisName;
			html+="</option>";
		}
		$("#famDiagName").html(html);
	},'json');
	
	
})

/****
 * 保存病史信息
 * @return
 */
function  saveMedicalHistory(){
	
	/**获取首发症状**/
	var firSymptomValue="";
	var arr=$("#firSymptom input");
	$.each(arr,function (i,n){
		if($(this).attr("checked")=="checked"){
			firSymptomValue+=$(this).val()+",";
		 }
	})
	
	var param={
			"mh.patiSerial":$($('#mh_patiSerial', parent.document)).val(),
			"mh.inpatiNumber":$($('#mh_inpatiNumber', parent.document)).val(),
			"mh.inpatiSerialNumber":$($('#mh_inpatiSerialNumber', parent.document)).val(),
			"mh.name":$($('#mh_name', parent.document)).val(),
			"mh.attackYearmon":$("#attackYearmon").val(), 
			"mh.mhisyMnum":$("#mhisyMnum").val(), 
			"mh.mhisyMnum":$("#mhisyMnum").val(), 
			"mh.firSymptom":firSymptomValue, 
			"mh.firSymptomDepict":$("#firSymptomDepict").val(), 
			"mh.origDiagCode":$("#origDiagCode  option:selected").val(),
			"mh.origDiagDepict":$("#origDiagDepict").val(),
			"mh.ckdPeriod":$("#ckdPeriod  option:selected").val(),
			"mh.diagDate":$("#diagDate").val(),
			"mh.famHistState":$("#famHistState  option:selected").val(),
			"mh.famEntityName":$("#famEntityName  option:selected").val(),
			"mh.famDiagName":$("#famDiagName  option:selected").val(),
			"mh.famHistDepict":$("#famHistDepict").val(),
			"mh.allergyState":$("#allergyState  option:selected").val(),
			"mh.allergyDepict":$("#allergyDepict").val(),
			"mh.opsState":$("#opsState  option:selected").val(),
			"mh.opsDepict":$("#opsDepict").val(),
			"mh.smokingState":$("#smokingState  option:selected").val(),
			"mh.smokingYearnum":$("#smokingYearnum").val(),
			"mh.smokingNum":$("#smokingNum").val(),
			"mh.quiteSmokingYear":$("#quiteSmokingYear").val(),
			"mh.wineState":$("#wineState  option:selected").val(),
			"mh.wineYearnum":$("#wineYearnum").val(),
			"mh.wineNum":$("#wineNum").val(),
			"mh.quiteWineYear":$("#quiteWineYear").val(),
			"mh.infectState":$("#infectState  option:selected").val(),
			"mh.infectDepict":$("#infectDepict").val()};
	$.post(path+"/medicalHistoryaction!saveMedicalHistory.action",param,function (data){
		
	},'json')
}