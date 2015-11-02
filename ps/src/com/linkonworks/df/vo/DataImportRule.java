package com.linkonworks.df.vo;

public class DataImportRule implements java.io.Serializable{
	
	public String id;
	public String deptCode;
	public String flupNameId;
	public String flupType;
	public String flupWay;
	public String flupObject;
	public String flupCycle;
	public Integer flupTotNum;
	public Integer flupFirstDay;
	public String flupStatus;
	public String flupDept;
	public String delState;
	public String diagName;
	public String diagCode;
	public String deptName;
	public String flupName;
	public String flupDoctorCode;
	public String flupPeonum;
	public String operateEmployeeCode;
	//随访天数
	private String flupNumDate;
	private String flupDateFlag;
	private String autoGeneration;

	
	
	public String getFlupDateFlag() {
		return flupDateFlag;
	}
	public void setFlupDateFlag(String flupDateFlag) {
		this.flupDateFlag = flupDateFlag;
	}
	public String getFlupNumDate() {
		return flupNumDate;
	}
	public void setFlupNumDate(String flupNumDate) {
		this.flupNumDate = flupNumDate;
	}
	public String flupDoctorName;
	
	
	public String getFlupDoctorName() {
		return flupDoctorName;
	}
	public void setFlupDoctorName(String flupDoctorName) {
		this.flupDoctorName = flupDoctorName;
	}
	public String getOperateEmployeeCode() {
		return operateEmployeeCode;
	}
	public void setOperateEmployeeCode(String operateEmployeeCode) {
		this.operateEmployeeCode = operateEmployeeCode;
	}
	public String getFlupDoctorCode() {
		return flupDoctorCode;
	}
	public void setFlupDoctorCode(String flupDoctorCode) {
		this.flupDoctorCode = flupDoctorCode;
	}
	public String getFlupPeonum() {
		return flupPeonum;
	}
	public void setFlupPeonum(String flupPeonum) {
		this.flupPeonum = flupPeonum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getFlupNameId() {
		return flupNameId;
	}
	public void setFlupNameId(String flupNameId) {
		this.flupNameId = flupNameId;
	}
	public String getFlupType() {
		return flupType;
	}
	public void setFlupType(String flupType) {
		this.flupType = flupType;
	}
	public String getFlupWay() {
		return flupWay;
	}
	public void setFlupWay(String flupWay) {
		this.flupWay = flupWay;
	}
	public String getFlupObject() {
		return flupObject;
	}
	public void setFlupObject(String flupObject) {
		this.flupObject = flupObject;
	}
	public String getFlupCycle() {
		return flupCycle;
	}
	public void setFlupCycle(String flupCycle) {
		this.flupCycle = flupCycle;
	}
	public Integer getFlupTotNum() {
		return flupTotNum;
	}
	public void setFlupTotNum(Integer flupTotNum) {
		this.flupTotNum = flupTotNum;
	}
	public Integer getFlupFirstDay() {
		return flupFirstDay;
	}
	public void setFlupFirstDay(Integer flupFirstDay) {
		this.flupFirstDay = flupFirstDay;
	}
	public String getFlupStatus() {
		return flupStatus;
	}
	public void setFlupStatus(String flupStatus) {
		this.flupStatus = flupStatus;
	}
	public String getFlupDept() {
		return flupDept;
	}
	public void setFlupDept(String flupDept) {
		this.flupDept = flupDept;
	}
	public String getDelState() {
		return delState;
	}
	public void setDelState(String delState) {
		this.delState = delState;
	}
	public String getDiagName() {
		return diagName;
	}
	public void setDiagName(String diagName) {
		this.diagName = diagName;
	}
	public String getDiagCode() {
		return diagCode;
	}
	public void setDiagCode(String diagCode) {
		this.diagCode = diagCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getFlupName() {
		return flupName;
	}
	public void setFlupName(String flupName) {
		this.flupName = flupName;
	}
	
	public String getAutoGeneration() {
		return autoGeneration;
	}
	public void setAutoGeneration(String autoGeneration) {
		this.autoGeneration = autoGeneration;
	}
	public DataImportRule(String id, String deptCode, String flupNameId,
			String flupType, String flupWay, String flupObject,
			String flupCycle, Integer flupTotNum, Integer flupFirstDay,
			String flupStatus, String flupDept, String delState,
			String diagName, String diagCode, String deptName, String flupName) {
		super();
		this.id = id;
		this.deptCode = deptCode;
		this.flupNameId = flupNameId;
		this.flupType = flupType;
		this.flupWay = flupWay;
		this.flupObject = flupObject;
		this.flupCycle = flupCycle;
		this.flupTotNum = flupTotNum;
		this.flupFirstDay = flupFirstDay;
		this.flupStatus = flupStatus;
		this.flupDept = flupDept;
		this.delState = delState;
		this.diagName = diagName;
		this.diagCode = diagCode;
		this.deptName = deptName;
		this.flupName = flupName;
	}
	public DataImportRule() {
		super();
	}
	
	
	
}
