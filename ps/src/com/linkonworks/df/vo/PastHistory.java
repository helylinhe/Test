package com.linkonworks.df.vo;

public class PastHistory implements java.io.Serializable{
	
	private String id;
	private String patiSerial;
	private String inpatiNumber;
	private String inpatiSerialNumber;
	private String mhisyCode;
	private String phisyName;
	private String phisyState;
	private String phisyDepict;
	private String curState;
	private String operateDate;
	private String operateEmployeeCode;
	private String unitCode;
	public PastHistory(String id, String patiSerial, String inpatiNumber,
			String inpatiSerialNumber, String mhisyCode, String phisyName,
			String phisyState, String phisyDepict, String curState,
			String operateDate, String operateEmployeeCode, String unitCode) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.inpatiSerialNumber = inpatiSerialNumber;
		this.mhisyCode = mhisyCode;
		this.phisyName = phisyName;
		this.phisyState = phisyState;
		this.phisyDepict = phisyDepict;
		this.curState = curState;
		this.operateDate = operateDate;
		this.operateEmployeeCode = operateEmployeeCode;
		this.unitCode = unitCode;
	}
	public PastHistory() {
		super();
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
	public String getMhisyCode() {
		return mhisyCode;
	}
	public void setMhisyCode(String mhisyCode) {
		this.mhisyCode = mhisyCode;
	}
	public String getPhisyName() {
		return phisyName;
	}
	public void setPhisyName(String phisyName) {
		this.phisyName = phisyName;
	}
	public String getPhisyState() {
		return phisyState;
	}
	public void setPhisyState(String phisyState) {
		this.phisyState = phisyState;
	}
	public String getPhisyDepict() {
		return phisyDepict;
	}
	public void setPhisyDepict(String phisyDepict) {
		this.phisyDepict = phisyDepict;
	}
	public String getCurState() {
		return curState;
	}
	public void setCurState(String curState) {
		this.curState = curState;
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
	
	
	

}
