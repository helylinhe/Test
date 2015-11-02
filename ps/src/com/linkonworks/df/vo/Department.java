package com.linkonworks.df.vo;

public class Department implements java.io.Serializable{

	
	private String deptCode;
	private String deptSmpName;
	private String deptName;
	private String inputCode;
	private String deptAttribute;
	private Integer deptStatus;
	private String medicalInsuranceCode;
	private String medicalInsuranceName;
	private String deptSameCode;
	private String unitCode;
	
	
	private String clinicAttrName;
	
	private String outpOrInpName;
	
	//添加属性 2014-8-22
	private String  deptSummary;
	private String expertDept;
	private String flupDept;
	
	
	
	public String getDeptSummary() {
		return deptSummary;
	}





	public void setDeptSummary(String deptSummary) {
		this.deptSummary = deptSummary;
	}





	public String getExpertDept() {
		return expertDept;
	}





	public void setExpertDept(String expertDept) {
		this.expertDept = expertDept;
	}





	public String getFlupDept() {
		return flupDept;
	}





	public void setFlupDept(String flupDept) {
		this.flupDept = flupDept;
	}





	public String getClinicAttrName() {
		return clinicAttrName;
	}





	public void setClinicAttrName(String clinicAttrName) {
		this.clinicAttrName = clinicAttrName;
	}





	public String getOutpOrInpName() {
		return outpOrInpName;
	}





	public void setOutpOrInpName(String outpOrInpName) {
		this.outpOrInpName = outpOrInpName;
	}





	public Department() {
		super();
	}


	


	





	public Department(String deptCode, String deptSmpName, String deptName,
			String inputCode, String deptAttribute, Integer deptStatus,
			String medicalInsuranceCode, String medicalInsuranceName,
			String deptSameCode, String unitCode, String clinicAttrName,
			String outpOrInpName) {
		super();
		this.deptCode = deptCode;
		this.deptSmpName = deptSmpName;
		this.deptName = deptName;
		this.inputCode = inputCode;
		this.deptAttribute = deptAttribute;
		this.deptStatus = deptStatus;
		this.medicalInsuranceCode = medicalInsuranceCode;
		this.medicalInsuranceName = medicalInsuranceName;
		this.deptSameCode = deptSameCode;
		this.unitCode = unitCode;
		this.clinicAttrName = clinicAttrName;
		this.outpOrInpName = outpOrInpName;
	}





	public String getDeptSameCode() {
		return deptSameCode;
	}





	public void setDeptSameCode(String deptSameCode) {
		this.deptSameCode = deptSameCode;
	}





	public String getDeptCode() {
		return deptCode;
	}


	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}


	public String getDeptSmpName() {
		return deptSmpName;
	}


	public void setDeptSmpName(String deptSmpName) {
		this.deptSmpName = deptSmpName;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getInputCode() {
		return inputCode;
	}


	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}


	public String getDeptAttribute() {
		return deptAttribute;
	}


	public void setDeptAttribute(String deptAttribute) {
		this.deptAttribute = deptAttribute;
	}


	public Integer getDeptStatus() {
		return deptStatus;
	}


	public void setDeptStatus(Integer deptStatus) {
		this.deptStatus = deptStatus;
	}


	public String getMedicalInsuranceCode() {
		return medicalInsuranceCode;
	}


	public void setMedicalInsuranceCode(String medicalInsuranceCode) {
		this.medicalInsuranceCode = medicalInsuranceCode;
	}


	public String getMedicalInsuranceName() {
		return medicalInsuranceName;
	}


	public void setMedicalInsuranceName(String medicalInsuranceName) {
		this.medicalInsuranceName = medicalInsuranceName;
	}


	public String getUnitCode() {
		return unitCode;
	}


	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
	

	

	

	
	
	
	
}
