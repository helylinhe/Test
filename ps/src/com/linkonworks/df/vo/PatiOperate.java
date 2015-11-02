package com.linkonworks.df.vo;

public class PatiOperate implements java.io.Serializable {

	private String id;
	private String patiSerial;
	private String inpatiNumber;
	private String inpatiSerialNumber;
	private String dept;
	private String operationCode;
	private String operationName;
	private String operationDate;
	private String operationScale;
	private String operationDoctorCode;
	private String anesthesiaDoctorCode;
	private String anesthesiaType;
	private String operationDept;
	private String preOperationDiagCode;
	private String preOperationDiagName;

	public PatiOperate() {
		super();
	}

	public PatiOperate(String id, String patiSerial, String inpatiNumber,
			String inpatiSerialNumber, String dept, String operationCode,
			String operationName, String operationScale,
			String operationDoctorCode, String anesthesiaDoctorCode,
			String anesthesiaType, String operationDept,
			String preOperationDiagCode, String preOperationDiagName) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.inpatiSerialNumber = inpatiSerialNumber;
		this.dept = dept;
		this.operationCode = operationCode;
		this.operationName = operationName;
		this.operationScale = operationScale;
		this.operationDoctorCode = operationDoctorCode;
		this.anesthesiaDoctorCode = anesthesiaDoctorCode;
		this.anesthesiaType = anesthesiaType;
		this.operationDept = operationDept;
		this.preOperationDiagCode = preOperationDiagCode;
		this.preOperationDiagName = preOperationDiagName;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationScale() {
		return operationScale;
	}

	public void setOperationScale(String operationScale) {
		this.operationScale = operationScale;
	}

	public String getOperationDoctorCode() {
		return operationDoctorCode;
	}

	public void setOperationDoctorCode(String operationDoctorCode) {
		this.operationDoctorCode = operationDoctorCode;
	}

	public String getAnesthesiaDoctorCode() {
		return anesthesiaDoctorCode;
	}

	public void setAnesthesiaDoctorCode(String anesthesiaDoctorCode) {
		this.anesthesiaDoctorCode = anesthesiaDoctorCode;
	}

	public String getAnesthesiaType() {
		return anesthesiaType;
	}

	public void setAnesthesiaType(String anesthesiaType) {
		this.anesthesiaType = anesthesiaType;
	}

	public String getOperationDept() {
		return operationDept;
	}

	public void setOperationDept(String operationDept) {
		this.operationDept = operationDept;
	}

	public String getPreOperationDiagCode() {
		return preOperationDiagCode;
	}

	public void setPreOperationDiagCode(String preOperationDiagCode) {
		this.preOperationDiagCode = preOperationDiagCode;
	}

	public String getPreOperationDiagName() {
		return preOperationDiagName;
	}

	public void setPreOperationDiagName(String preOperationDiagName) {
		this.preOperationDiagName = preOperationDiagName;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

}
