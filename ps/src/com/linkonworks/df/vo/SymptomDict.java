package com.linkonworks.df.vo;

public class SymptomDict {

	private String symptomCode;
	private String symptomName;
	private String placeCode;
	private String inputCode;
	private String logDate;
	private String employeeCode;
	public String getSymptomCode() {
		return symptomCode;
	}
	public void setSymptomCode(String symptomCode) {
		this.symptomCode = symptomCode;
	}
	public String getSymptomName() {
		return symptomName;
	}
	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}
	public String getPlaceCode() {
		return placeCode;
	}
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
	public String getInputCode() {
		return inputCode;
	}
	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
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
	public SymptomDict(String symptomCode, String symptomName,
			String placeCode, String inputCode, String logDate,
			String employeeCode) {
		super();
		this.symptomCode = symptomCode;
		this.symptomName = symptomName;
		this.placeCode = placeCode;
		this.inputCode = inputCode;
		this.logDate = logDate;
		this.employeeCode = employeeCode;
	}
	public SymptomDict() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
