package com.linkonworks.df.vo;

public class PatiReturnRule {
	
	private String id;
	private String deptCode;
	private String returnType;
	private String returnCycle;
	private String returnTotNum; 
	private String flupDoctorCode;
	private String diagCode;
	private String diagName;
	private String diagGpcode;
	private String diagGpname;
	private String operateDate;
	private String operateEmployeeCode;
	private String delState;
	private String returnDay;
	private String returnInfo;
	private String retplanDeptCode;
	
	//datagrid属性
	private String deptName;
	private String flupDoctorName;
	private String retplanDeptName;
	
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getFlupDoctorName() {
		return flupDoctorName;
	}
	public void setFlupDoctorName(String flupDoctorName) {
		this.flupDoctorName = flupDoctorName;
	}
	public String getRetplanDeptName() {
		return retplanDeptName;
	}
	public void setRetplanDeptName(String retplanDeptName) {
		this.retplanDeptName = retplanDeptName;
	}
	public String getRetplanDeptCode() {
		return retplanDeptCode;
	}
	public void setRetplanDeptCode(String retplanDeptCode) {
		this.retplanDeptCode = retplanDeptCode;
	}
	public String getReturnDay() {
		return returnDay;
	}
	public void setReturnDay(String returnDay) {
		this.returnDay = returnDay;
	}
	public String getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}
	public PatiReturnRule(String id, String deptCode, String returnType,
			String returnCycle, String returnTotNum, String flupDoctorCode,
			String diagCode, String diagName, String diagGpcode,
			String diagGpname, String operateDate, String operateEmployeeCode,
			String delState) {
		super();
		this.id = id;
		this.deptCode = deptCode;
		this.returnType = returnType;
		this.returnCycle = returnCycle;
		this.returnTotNum = returnTotNum;
		this.flupDoctorCode = flupDoctorCode;
		this.diagCode = diagCode;
		this.diagName = diagName;
		this.diagGpcode = diagGpcode;
		this.diagGpname = diagGpname;
		this.operateDate = operateDate;
		this.operateEmployeeCode = operateEmployeeCode;
		this.delState = delState;
	}
	public PatiReturnRule() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getReturnCycle() {
		return returnCycle;
	}
	public void setReturnCycle(String returnCycle) {
		this.returnCycle = returnCycle;
	}
	public String getReturnTotNum() {
		return returnTotNum;
	}
	public void setReturnTotNum(String returnTotNum) {
		this.returnTotNum = returnTotNum;
	}
	public String getFlupDoctorCode() {
		return flupDoctorCode;
	}
	public void setFlupDoctorCode(String flupDoctorCode) {
		this.flupDoctorCode = flupDoctorCode;
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
	public String getDiagGpcode() {
		return diagGpcode;
	}
	public void setDiagGpcode(String diagGpcode) {
		this.diagGpcode = diagGpcode;
	}
	public String getDiagGpname() {
		return diagGpname;
	}
	public void setDiagGpname(String diagGpname) {
		this.diagGpname = diagGpname;
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
	public String getDelState() {
		return delState;
	}
	public void setDelState(String delState) {
		this.delState = delState;
	}
	


}
