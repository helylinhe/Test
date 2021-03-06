package com.linkonworks.df.vo;

public class DiagGroup {

	private String groupCode;
	private String diagnosisCode;
	private String groupName;
	private String diagnosisName;
	private String logDate;
	private String employeeCode;
	
	private String deptCode;
	private String id;
	
	
	private String deptName;
	private String unitCode;
	private String groupType;
	
	
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
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
	public DiagGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiagGroup(String groupCode, String diagnosisCode, String groupName,
			String diagnosisName, String logDate, String employeeCode) {
		super();
		this.groupCode = groupCode;
		this.diagnosisCode = diagnosisCode;
		this.groupName = groupName;
		this.diagnosisName = diagnosisName;
		this.logDate = logDate;
		this.employeeCode = employeeCode;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getDiagnosisCode() {
		return diagnosisCode;
	}
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDiagnosisName() {
		return diagnosisName;
	}
	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
}
