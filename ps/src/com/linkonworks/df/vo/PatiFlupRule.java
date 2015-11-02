package com.linkonworks.df.vo;

public class PatiFlupRule implements java.io.Serializable {

	private String id;
	private String patiSerial;
	private String inpatiNumber;
	private String inpatiSerialNumber;
	private String name;
	private String flupStatus;
	private String flupMobile;
	private String flupWay;
	private String flupType;
	private String flupPeriod;
	private String planedFlupDate;
	private String flupObject;
	private String flupDoctor;
	private String flupTableNameId;
	private String operateDate;
	private String operateEmployeeCode;
	private String deptCode;
	
	
	/***
	 * 逻辑展示字段
	 */
	private String age;
	private String outHospDiag;
	private String flupDate;
	private String flupDoctorCode;
	private String flupPlanDate;
	
	public PatiFlupRule() {
		super();
	}

	

	public PatiFlupRule(String id, String patiSerial, String inpatiNumber,String inpatiSerialNumber,
			String name, String flupStatus, String flupMobile, String flupWay,
			String flupType, String flupPeriod, String planedFlupDate,
			String flupObject, String flupDoctor, String flupTableNameId,
			String operateDate, String operateEmployeeCode, String deptCode,
			String age, String outHospDiag, String flupDate,
			String flupDoctorCode,String flupPlanDate) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.name = name;
		this.flupStatus = flupStatus;
		this.flupMobile = flupMobile;
		this.flupWay = flupWay;
		this.flupType = flupType;
		this.flupPeriod = flupPeriod;
		this.planedFlupDate = planedFlupDate;
		this.flupObject = flupObject;
		this.flupDoctor = flupDoctor;
		this.flupTableNameId = flupTableNameId;
		this.operateDate = operateDate;
		this.operateEmployeeCode = operateEmployeeCode;
		this.deptCode = deptCode;
		this.age = age;
		this.outHospDiag = outHospDiag;
		this.flupDate = flupDate;
		this.flupDoctorCode = flupDoctorCode;
		this.flupPlanDate=flupPlanDate;
		this.inpatiSerialNumber=inpatiSerialNumber;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlupStatus() {
		return flupStatus;
	}

	public void setFlupStatus(String flupStatus) {
		this.flupStatus = flupStatus;
	}

	
	public String getFlupMobile() {
		return flupMobile;
	}

	public void setFlupMobile(String flupMobile) {
		this.flupMobile = flupMobile;
	}

	public String getFlupWay() {
		return flupWay;
	}

	public void setFlupWay(String flupWay) {
		this.flupWay = flupWay;
	}

	public String getFlupType() {
		return flupType;
	}

	public void setFlupType(String flupType) {
		this.flupType = flupType;
	}

	public String getFlupPeriod() {
		return flupPeriod;
	}

	public void setFlupPeriod(String flupPeriod) {
		this.flupPeriod = flupPeriod;
	}

	public String getPlanedFlupDate() {
		return planedFlupDate;
	}

	public void setPlanedFlupDate(String planedFlupDate) {
		this.planedFlupDate = planedFlupDate;
	}

	public String getFlupObject() {
		return flupObject;
	}

	public void setFlupObject(String flupObject) {
		this.flupObject = flupObject;
	}

	public String getFlupDoctor() {
		return flupDoctor;
	}

	public void setFlupDoctor(String flupDoctor) {
		this.flupDoctor = flupDoctor;
	}

	public String getFlupTableNameId() {
		return flupTableNameId;
	}

	public void setFlupTableNameId(String flupTableNameId) {
		this.flupTableNameId = flupTableNameId;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateEmployeeCode() {
		return operateEmployeeCode;
	}

	public void setOperateEmployeeCode(String operateEmployeeCode) {
		this.operateEmployeeCode = operateEmployeeCode;
	}

	
	public String getDeptCode() {
		return deptCode;
	}



	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}



	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getOutHospDiag() {
		return outHospDiag;
	}

	public void setOutHospDiag(String outHospDiag) {
		this.outHospDiag = outHospDiag;
	}

	public String getFlupDate() {
		return flupDate;
	}

	public void setFlupDate(String flupDate) {
		this.flupDate = flupDate;
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



	public String getInpatiSerialNumber() {
		return inpatiSerialNumber;
	}



	public void setInpatiSerialNumber(String inpatiSerialNumber) {
		this.inpatiSerialNumber = inpatiSerialNumber;
	}
	
	
	
}
