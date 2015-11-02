
function windowInfo(patiSerial,inpatiNumber,inpatiSerialNumber){
	
	$("#dispatch_patiSerial").val(patiSerial);
	$("#dispatch_inpatiNumber").val(inpatiNumber);
	$("#dispatch_inpatiSerialNumber").val(inpatiSerialNumber);
	$("#doctorWork").tabs("select","病例基本信息");
}