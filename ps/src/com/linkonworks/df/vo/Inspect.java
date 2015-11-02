package com.linkonworks.df.vo;

public class Inspect implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String patiSerial;//病人编号
	private String inpatiNumber;//住院号
	private String inpatiSerialNumber;  //住院流水号
	private String name;//姓名
	private String gender;
	private Integer age;
	private String sample;
	private String serial;
	private String itemCode;
	private String itemName;
	private String inspectResult;
	private String resultFlag;
	private String resultUnit;
	private String referScale;
	private String inspectDate;
	private String inspectDoctor;
	private String checkDoctor;
	private String inspectName;
	private String inspectId;
	
	private String reportItemName;
	private String reportItemCode;
	
	
	public String getReportItemCode() {
		return reportItemCode;
	}

	public void setReportItemCode(String reportItemCode) {
		this.reportItemCode = reportItemCode;
	}

	public String getReportItemName() {
		return reportItemName;
	}

	public void setReportItemName(String reportItemName) {
		this.reportItemName = reportItemName;
	}

	public String getInspectId() {
		return inspectId;
	}

	public void setInspectId(String inspectId) {
		this.inspectId = inspectId;
	}

	public Inspect() {
		super();
	}

	public Inspect(String id, String patiSerial, String inpatiNumber,
			String inpatiSerailNumber, String name, String gender, Integer age,
			String sample, String serial, String itemCode, String itemName,
			String inspectResult, String resultFlag, String resultUnit,
			String referScale, String inspectDate, String inspectDoctor,
			String checkDoctor,String inspectName) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.sample = sample;
		this.serial = serial;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.inspectResult = inspectResult;
		this.resultFlag = resultFlag;
		this.resultUnit = resultUnit;
		this.referScale = referScale;
		this.inspectDate = inspectDate;
		this.inspectDoctor = inspectDoctor;
		this.checkDoctor = checkDoctor;
		this.inspectName=inspectName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInpatiNumber() {
		return inpatiNumber;
	}

	public void setInpatiNumber(String inpatiNumber) {
		this.inpatiNumber = inpatiNumber;
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

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getInspectResult() {
		return inspectResult;
	}

	public void setInspectResult(String inspectResult) {
		this.inspectResult = inspectResult;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	public String getResultUnit() {
		return resultUnit;
	}

	public void setResultUnit(String resultUnit) {
		this.resultUnit = resultUnit;
	}

	public String getReferScale() {
		return referScale;
	}

	public void setReferScale(String referScale) {
		this.referScale = referScale;
	}

	public String getInspectDate() {
		return inspectDate;
	}

	public void setInspectDate(String inspectDate) {
		this.inspectDate = inspectDate;
	}

	public String getInspectDoctor() {
		return inspectDoctor;
	}

	public void setInspectDoctor(String inspectDoctor) {
		this.inspectDoctor = inspectDoctor;
	}

	public String getCheckDoctor() {
		return checkDoctor;
	}

	public void setCheckDoctor(String checkDoctor) {
		this.checkDoctor = checkDoctor;
	}

	public String getInpatiSerialNumber() {
		return inpatiSerialNumber;
	}

	public void setInpatiSerialNumber(String inpatiSerialNumber) {
		this.inpatiSerialNumber = inpatiSerialNumber;
	}
	public String getInspectName() {
		return inspectName;
	}

	public void setInspectName(String inspectName) {
		this.inspectName = inspectName;;
	}
	public String getPatiSerial() {
		return patiSerial;
	}

	public void setPatiSerial(String patiSerial) {
		this.patiSerial = patiSerial;
	}

}