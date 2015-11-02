package com.linkonworks.df.vo;

public class BlackList implements java.io.Serializable{

	public String id;
	public String patiSerial;
	public String inpatiNumber;
	public String medicalInsuranceCode;
	public String idNumber;
	public String name;
	public String gender;
	public Integer age;
	public String addReasons;
	public String state;
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
	public String getMedicalInsuranceCode() {
		return medicalInsuranceCode;
	}
	public void setMedicalInsuranceCode(String medicalInsuranceCode) {
		this.medicalInsuranceCode = medicalInsuranceCode;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddReasons() {
		return addReasons;
	}
	public void setAddReasons(String addReasons) {
		this.addReasons = addReasons;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public BlackList(String id, String patiSerial, String inpatiNumber,
			String medicalInsuranceCode, String idNumber, String name,
			String gender, Integer age, String addReasons, String state) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.medicalInsuranceCode = medicalInsuranceCode;
		this.idNumber = idNumber;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.addReasons = addReasons;
		this.state = state;
	}
	public BlackList() {
		super();
	}
	
	
	
}
