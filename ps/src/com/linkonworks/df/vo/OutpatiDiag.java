package com.linkonworks.df.vo;

public class OutpatiDiag implements java.io.Serializable{

	private String id;
	private String patiSerial;
	private String outpatiNumber;
	private String name;
	private String gender;
	private Integer age;
	private String diagDate;
	private String diagDept;
	private String diagDeptCode;
	private String diagDoctorCode;
	private String diagDoctorDept;
	private String dept;
	private String diagCode;
	private String diagName;
	private String patiType;
	private String hospitalCode;
	private String memo;
	
	
	public OutpatiDiag() {
		super();
	}


	public OutpatiDiag(String id, String patiSerial, String outpatiNumber,
			String name, String gender, Integer age, String diagDate,
			String diagDept, String diagDeptCode, String diagDoctorCode,
			String diagDoctorDept, String dept, String diagCode,
			String diagName, String patiType, String hospitalCode, String memo) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.outpatiNumber = outpatiNumber;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.diagDate = diagDate;
		this.diagDept = diagDept;
		this.diagDeptCode = diagDeptCode;
		this.diagDoctorCode = diagDoctorCode;
		this.diagDoctorDept = diagDoctorDept;
		this.dept = dept;
		this.diagCode = diagCode;
		this.diagName = diagName;
		this.patiType = patiType;
		this.hospitalCode = hospitalCode;
		this.memo = memo;
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


	public String getOutpatiNumber() {
		return outpatiNumber;
	}


	public void setOutpatiNumber(String outpatiNumber) {
		this.outpatiNumber = outpatiNumber;
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


	public String getDiagDate() {
		return diagDate;
	}


	public void setDiagDate(String diagDate) {
		this.diagDate = diagDate;
	}


	public String getDiagDept() {
		return diagDept;
	}


	public void setDiagDept(String diagDept) {
		this.diagDept = diagDept;
	}


	public String getDiagDeptCode() {
		return diagDeptCode;
	}


	public void setDiagDeptCode(String diagDeptCode) {
		this.diagDeptCode = diagDeptCode;
	}


	public String getDiagDoctorCode() {
		return diagDoctorCode;
	}


	public void setDiagDoctorCode(String diagDoctorCode) {
		this.diagDoctorCode = diagDoctorCode;
	}


	public String getDiagDoctorDept() {
		return diagDoctorDept;
	}


	public void setDiagDoctorDept(String diagDoctorDept) {
		this.diagDoctorDept = diagDoctorDept;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
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


	public String getPatiType() {
		return patiType;
	}


	public void setPatiType(String patiType) {
		this.patiType = patiType;
	}


	public String getHospitalCode() {
		return hospitalCode;
	}


	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}
