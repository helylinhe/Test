package com.linkonworks.df.vo;

public class FlupNameDict implements java.io.Serializable{

	
	private String flupNameId;
	private String flupName;
	private String flupGroupId;
	private String flupNameSpell;
	private String flupNameVersion;
	private String flupType;
	private String deptCode;
	private String diagCode;
	private String diagName;
	private String operateDate;
	private String employeeCode;
	private String useState;
	private String buttonUseState;
	
	
	//datagrid需要的数据
	private String deptName;
	private String unitCode;
	
	
	
	public String getUnitCode() {
		return unitCode;
	}



	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public FlupNameDict() {
		super();
	}



	public FlupNameDict(String flupNameId, String flupName, String flupGroupId,
			String flupNameSpell, String flupNameVersion, String flupType,
			String deptCode, String diagCode, String diagName,
			String operateDate, String employeeCode, String useState,
			String deptName) {
		super();
		this.flupNameId = flupNameId;
		this.flupName = flupName;
		this.flupGroupId = flupGroupId;
		this.flupNameSpell = flupNameSpell;
		this.flupNameVersion = flupNameVersion;
		this.flupType = flupType;
		this.deptCode = deptCode;
		this.diagCode = diagCode;
		this.diagName = diagName;
		this.operateDate = operateDate;
		this.employeeCode = employeeCode;
		this.useState = useState;
		this.deptName = deptName;
	}



	public String getFlupNameId() {
		return flupNameId;
	}



	public void setFlupNameId(String flupNameId) {
		this.flupNameId = flupNameId;
	}



	public String getFlupName() {
		return flupName;
	}



	public void setFlupName(String flupName) {
		this.flupName = flupName;
	}



	public String getFlupGroupId() {
		return flupGroupId;
	}



	public void setFlupGroupId(String flupGroupId) {
		this.flupGroupId = flupGroupId;
	}



	public String getFlupNameSpell() {
		return flupNameSpell;
	}



	public void setFlupNameSpell(String flupNameSpell) {
		this.flupNameSpell = flupNameSpell;
	}



	public String getFlupNameVersion() {
		return flupNameVersion;
	}



	public void setFlupNameVersion(String flupNameVersion) {
		this.flupNameVersion = flupNameVersion;
	}



	public String getFlupType() {
		return flupType;
	}



	public void setFlupType(String flupType) {
		this.flupType = flupType;
	}



	public String getDeptCode() {
		return deptCode;
	}



	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
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



	public String getOperateDate() {
		return operateDate;
	}



	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}



	public String getEmployeeCode() {
		return employeeCode;
	}



	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}



	public String getUseState() {
		return useState;
	}



	public void setUseState(String useState) {
		this.useState = useState;
	}


	public String getButtonUseState() {
		return buttonUseState;
	}



	public void setButtonUseState(String buttonUseState) {
		this.buttonUseState = buttonUseState;
	}

	
	
	
}
