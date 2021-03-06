package com.linkonworks.df.vo;

public class FlupTask implements java.io.Serializable{

	private String id;
	private String patiSerial;
	private String inpatiNumber;
	private String inpatiSerialNumber;
	private String name;
	private String flupDoctorCode; 
	private String flupPlanDate;
	private String flupDate;
	private String flupComplete;
	private String diagCode;
	private String diagName;
	private String flupWay;
	private String flupPeriod;
	private String flupObject;
	private String flupMobile;
	private Integer flupStatus;
	private String flupEvaluate;
	private String flupTableNameId;
	private String flupType;
	private String flupTimes;
	private String deptCode;
	private String unitCode;
	//datagrid 需要的属性
	private String outHospitalDate;
	private String age;
	private String gender;
	private String deptName;
	private String outHospitalDiag;
	private String billingCode;
	private String employeeCode;
	private String flupDoctor;
	private String taskOpen;
	//手术时间
	private String operateTime;
	private String actualDoctorCode;
	private String actualDoctorName;
	//病组代码
	private  String diagGroupCode;
	private String diagGroupName;
	private String medicalInsuranceCode;
	
	
	
	public String getMedicalInsuranceCode() {
		return medicalInsuranceCode;
	}

	public void setMedicalInsuranceCode(String medicalInsuranceCode) {
		this.medicalInsuranceCode = medicalInsuranceCode;
	}

	public String getDiagGroupCode() {
		return diagGroupCode;
	}

	public void setDiagGroupCode(String diagGroupCode) {
		this.diagGroupCode = diagGroupCode;
	}

	public String getDiagGroupName() {
		return diagGroupName;
	}

	public void setDiagGroupName(String diagGroupName) {
		this.diagGroupName = diagGroupName;
	}

	


	public String getTaskOpen() {
		return taskOpen;
	}

	public void setTaskOpen(String taskOpen) {
		this.taskOpen = taskOpen;
	}




	private String returnDate;
	private String returnDeptCode;
	
	private String flupResult;
	private String flupFailre;
	
	
	
	//加入黑名单的原因
	private String addReasons;
	
	public String getAddReasons() {
		return addReasons;
	}

	public void setAddReasons(String addReasons) {
		this.addReasons = addReasons;
	}

	public FlupTask(String patiSerial, String inpatiNumber,
			String inpatiSerialNumber,String flupComplete,String flupDate,String actualDoctorCode,String id,String returnDate,String returnDeptCode) {
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.inpatiSerialNumber = inpatiSerialNumber;
		this.flupComplete = flupComplete;
		this.flupDate = flupDate;
		this.actualDoctorCode = actualDoctorCode;
		this.id = id;
		this.returnDate = returnDate;
		this.returnDeptCode = returnDeptCode;
	}
	
	public String getActualDoctorCode() {
		return actualDoctorCode;
	}
	public void setActualDoctorCode(String actualDoctorCode) {
		this.actualDoctorCode = actualDoctorCode;
	}
	public String getActualDoctorName() {
		return actualDoctorName;
	}
	public void setActualDoctorName(String actualDoctorName) {
		this.actualDoctorName = actualDoctorName;
	}
	
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getFlupDoctor() {
		return flupDoctor;
	}
	public void setFlupDoctor(String flupDoctor) {
		this.flupDoctor = flupDoctor;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getReturnDeptCode() {
		return returnDeptCode;
	}
	public void setReturnDeptCode(String returnDeptCode) {
		this.returnDeptCode = returnDeptCode;
	}
	


	//随访信息
	private String outHospDiag;
	private String sendContent;
	private String sendWay;
	private String sendResult;
	private String operationDate;
	private String operationName;
	private String chiefDoctor;
	private String attendDoctor;
	
	//随访表名称
	private String flupName;
	
	
	public String getOutHospitalDate() {
		return outHospitalDate;
	}
	public void setOutHospitalDate(String outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getOutHospitalDiag() {
		return outHospitalDiag;
	}
	public void setOutHospitalDiag(String outHospitalDiag) {
		this.outHospitalDiag = outHospitalDiag;
	}
	public String getBillingCode() {
		return billingCode;
	}
	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatiSerial() {
		return patiSerial;
	}
	public void setPatiSerial(String patiSerial) {
		this.patiSerial = patiSerial;
	}
	public String getInpatiNumber() {
		return inpatiNumber;
	}
	public void setInpatiNumber(String inpatiNumber) {
		this.inpatiNumber = inpatiNumber;
	}
	public String getInpatiSerialNumber() {
		return inpatiSerialNumber;
	}
	public void setInpatiSerialNumber(String inpatiSerialNumber) {
		this.inpatiSerialNumber = inpatiSerialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlupDoctorCode() {
		return flupDoctorCode;
	}
	public void setFlupDoctorCode(String flupDoctorCode) {
		this.flupDoctorCode = flupDoctorCode;
	}
	public String getFlupPlanDate() {
		return flupPlanDate;
	}
	public void setFlupPlanDate(String flupPlanDate) {
		this.flupPlanDate = flupPlanDate;
	}
	public String getFlupDate() {
		return flupDate;
	}
	public void setFlupDate(String flupDate) {
		this.flupDate = flupDate;
	}
	public String getFlupComplete() {
		return flupComplete;
	}
	public void setFlupComplete(String flupComplete) {
		this.flupComplete = flupComplete;
	}
	public String getDiagCode() {
		return diagCode;
	}
	public void setDiagCode(String diagCode) {
		this.diagCode = diagCode;
	}
	public String getDiagName() {
		return diagName;
	}
	public void setDiagName(String diagName) {
		this.diagName = diagName;
	}
	public String getFlupWay() {
		return flupWay;
	}
	public void setFlupWay(String flupWay) {
		this.flupWay = flupWay;
	}
	public String getFlupPeriod() {
		return flupPeriod;
	}
	public void setFlupPeriod(String flupPeriod) {
		this.flupPeriod = flupPeriod;
	}
	public String getFlupObject() {
		return flupObject;
	}
	public void setFlupObject(String flupObject) {
		this.flupObject = flupObject;
	}
	public String getFlupMobile() {
		return flupMobile;
	}
	public void setFlupMobile(String flupMobile) {
		this.flupMobile = flupMobile;
	}
	public Integer getFlupStatus() {
		return flupStatus;
	}
	public void setFlupStatus(Integer flupStatus) {
		this.flupStatus = flupStatus;
	}
	public String getFlupEvaluate() {
		return flupEvaluate;
	}
	public void setFlupEvaluate(String flupEvaluate) {
		this.flupEvaluate = flupEvaluate;
	}
	public String getFlupTableNameId() {
		return flupTableNameId;
	}
	public void setFlupTableNameId(String flupTableNameId) {
		this.flupTableNameId = flupTableNameId;
	}
	public String getFlupType() {
		return flupType;
	}
	public void setFlupType(String flupType) {
		this.flupType = flupType;
	}
	public String getFlupTimes() {
		return flupTimes;
	}
	public void setFlupTimes(String flupTimes) {
		this.flupTimes = flupTimes;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
	public String getOutHospDiag() {
		return outHospDiag;
	}
	public void setOutHospDiag(String outHospDiag) {
		this.outHospDiag = outHospDiag;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	public String getSendWay() {
		return sendWay;
	}
	public void setSendWay(String sendWay) {
		this.sendWay = sendWay;
	}
	public String getSendResult() {
		return sendResult;
	}
	public void setSendResult(String sendResult) {
		this.sendResult = sendResult;
	}
	public String getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getChiefDoctor() {
		return chiefDoctor;
	}
	public void setChiefDoctor(String chiefDoctor) {
		this.chiefDoctor = chiefDoctor;
	}
	public String getAttendDoctor() {
		return attendDoctor;
	}
	public void setAttendDoctor(String attendDoctor) {
		this.attendDoctor = attendDoctor;
	}
	
	
	
	public String getFlupResult() {
		return flupResult;
	}

	public void setFlupResult(String flupResult) {
		this.flupResult = flupResult;
	}

	public String getFlupFailre() {
		return flupFailre;
	}

	public void setFlupFailre(String flupFailre) {
		this.flupFailre = flupFailre;
	}

	public String getFlupName() {
		return flupName;
	}
	public void setFlupName(String flupName) {
		this.flupName = flupName;
	}
	public FlupTask() {
		
	}
	public FlupTask(String id, String patiSerial, String inpatiNumber,
			String inpatiSerialNumber, String name, String flupDoctorCode,
			String flupPlanDate, String flupDate, String flupComplete,
			String diagCode, String diagName, String flupWay,
			String flupPeriod, String flupObject, String flupMobile,
			Integer flupStatus, String flupEvaluate, String flupTableNameId,
			String flupType, String flupTimes, String deptCode,
			String unitCode, String outHospitalDate, String age, String gender,
			String deptName, String outHospitalDiag, String billingCode,
			String outHospDiag, String sendContent, String sendWay,
			String sendResult, String operationDate, String operationName,
			String chiefDoctor, String attendDoctor,String flupName) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.inpatiSerialNumber = inpatiSerialNumber;
		this.name = name;
		this.flupDoctorCode = flupDoctorCode;
		this.flupPlanDate = flupPlanDate;
		this.flupDate = flupDate;
		this.flupComplete = flupComplete;
		this.diagCode = diagCode;
		this.diagName = diagName;
		this.flupWay = flupWay;
		this.flupPeriod = flupPeriod;
		this.flupObject = flupObject;
		this.flupMobile = flupMobile;
		this.flupStatus = flupStatus;
		this.flupEvaluate = flupEvaluate;
		this.flupTableNameId = flupTableNameId;
		this.flupType = flupType;
		this.flupTimes = flupTimes;
		this.deptCode = deptCode;
		this.unitCode = unitCode;
		this.outHospitalDate = outHospitalDate;
		this.age = age;
		this.gender = gender;
		this.deptName = deptName;
		this.outHospitalDiag = outHospitalDiag;
		this.billingCode = billingCode;
		this.outHospDiag = outHospDiag;
		this.sendContent = sendContent;
		this.sendWay = sendWay;
		this.sendResult = sendResult;
		this.operationDate = operationDate;
		this.operationName = operationName;
		this.chiefDoctor = chiefDoctor;
		this.attendDoctor = attendDoctor;
		this.flupName=flupName;
	}
	
	
	
}
