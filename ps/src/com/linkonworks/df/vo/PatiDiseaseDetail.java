package com.linkonworks.df.vo;

import java.io.Serializable;

public class PatiDiseaseDetail implements Serializable {
	private String id;
	private String patiSerial;
	private String inpatiNumber;
	private String inpatiSerialNumber;
	private String medicalInsuranceCode;
	private String name;
	private String gender;
	private String age;
	private String diseaseNameId;
	private String diseaseGroupId;
	private String groupOne;
	private String groupTwo;
	private String itemName;
	private String dataType;
	private String itemValue;
	private String operateDate;
	private String operateEmployeeCode;
	private String unitCode;
	private String detailId;
	private String diseaseName;
	
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
	public String getDiseaseNameId() {
		return diseaseNameId;
	}
	public void setDiseaseNameId(String diseaseNameId) {
		this.diseaseNameId = diseaseNameId;
	}
	public String getDiseaseGroupId() {
		return diseaseGroupId;
	}
	public void setDiseaseGroupId(String diseaseGroupId) {
		this.diseaseGroupId = diseaseGroupId;
	}
	public String getGroupOne() {
		return groupOne;
	}
	public void setGroupOne(String groupOne) {
		this.groupOne = groupOne;
	}
	public String getGroupTwo() {
		return groupTwo;
	}
	public void setGroupTwo(String groupTwo) {
		this.groupTwo = groupTwo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getItemValue() {
		return itemValue;
	}
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
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
	
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	
	public String getMedicalInsuranceCode() {
		return medicalInsuranceCode;
	}
	public void setMedicalInsuranceCode(String medicalInsuranceCode) {
		this.medicalInsuranceCode = medicalInsuranceCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public PatiDiseaseDetail() {
		super();
	}
	public PatiDiseaseDetail(String id, String patiSerial, String inpatiNumber,
			String inpatiSerialNumber, String medicalInsuranceCode,
			String name, String gender, String age, String diseaseNameId,
			String diseaseGroupId, String groupOne, String groupTwo,
			String itemName, String dataType, String itemValue,
			String operateDate, String operateEmployeeCode, String unitCode,
			String detailId) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.inpatiSerialNumber = inpatiSerialNumber;
		this.medicalInsuranceCode = medicalInsuranceCode;
		this.name = name;
		this.gender = gender;
		this.age=age;
		this.diseaseNameId = diseaseNameId;
		this.diseaseGroupId = diseaseGroupId;
		this.groupOne = groupOne;
		this.groupTwo = groupTwo;
		this.itemName = itemName;
		this.dataType = dataType;
		this.itemValue = itemValue;
		this.operateDate = operateDate;
		this.operateEmployeeCode = operateEmployeeCode;
		this.unitCode = unitCode;
		this.detailId = detailId;
	}
	
	
}
