package com.linkonworks.df.vo;

public class PatiDiseaseDict {
		
	private String id;
	private String patiSerial;
	private String inpatiNumber;
	private String inpatiSerialNumber;
	private String medicalInsuranceCode;
	private String name;
	private String deptCode;
	private String diseaseNameId;
	private String operateDate;
	private String operateEmployeeCode;
	private String unitCode;
	private String diseaseName;
	
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
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
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDiseaseNameId() {
		return diseaseNameId;
	}
	public void setDiseaseNameId(String diseaseNameId) {
		this.diseaseNameId = diseaseNameId;
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
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getMedicalInsuranceCode() {
		return medicalInsuranceCode;
	}
	public void setMedicalInsuranceCode(String medicalInsuranceCode) {
		this.medicalInsuranceCode = medicalInsuranceCode;
	}
	public PatiDiseaseDict(String id, String patiSerial, String inpatiNumber,
			String inpatiSerialNumber, String medicalInsuranceCode,String name,
			String deptCode, String diseaseNameId, String operateDate,
			String operateEmployeeCode, String unitCode, String diseaseName) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.inpatiSerialNumber = inpatiSerialNumber;
		this.medicalInsuranceCode = medicalInsuranceCode;
		this.name=name;
		this.deptCode = deptCode;
		this.diseaseNameId = diseaseNameId;
		this.operateDate = operateDate;
		this.operateEmployeeCode = operateEmployeeCode;
		this.unitCode = unitCode;
		this.diseaseName = diseaseName;
	}
	public PatiDiseaseDict() {
		super();
	}
	
}
