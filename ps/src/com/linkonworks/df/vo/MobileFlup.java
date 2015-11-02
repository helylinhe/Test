package com.linkonworks.df.vo;

public class MobileFlup implements java.io.Serializable{

	private String id;
	private String flupGroupId;
	private String flupNameId;
	private String patiSerial;
	private String inpatiNumber;
	private String groupOne;
	private String groupTwo;
	private String groupThree;
	private String itemName;
	private String dataType;
	private String itemValue;
	private String flupTaskId;
	private String recordType;
	
	
	public MobileFlup() {
		super();
	}

	
	

	




	public MobileFlup(String id, String flupGroupId, String flupNameId,
			String patiSerial, String inpatiNumber, String groupOne,
			String groupTwo, String groupThree, String itemName,
			String dataType, String itemValue,String flupTaskId,String recordType) {
		super();
		this.id = id;
		this.flupGroupId = flupGroupId;
		this.flupNameId = flupNameId;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.groupOne = groupOne;
		this.groupTwo = groupTwo;
		this.groupThree = groupThree;
		this.itemName = itemName;
		this.dataType = dataType;
		this.itemValue = itemValue;
		this.flupTaskId=flupTaskId;
		this.recordType=recordType;
	}









	public String getFlupGroupId() {
		return flupGroupId;
	}









	public void setFlupGroupId(String flupGroupId) {
		this.flupGroupId = flupGroupId;
	}









	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	

	public String getFlupNameId() {
		return flupNameId;
	}


	public void setFlupNameId(String flupNameId) {
		this.flupNameId = flupNameId;
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

	public String getGroupThree() {
		return groupThree;
	}


	public void setGroupThree(String groupThree) {
		this.groupThree = groupThree;
	}









	public String getFlupTaskId() {
		return flupTaskId;
	}









	public void setFlupTaskId(String flupTaskId) {
		this.flupTaskId = flupTaskId;
	}









	public String getRecordType() {
		return recordType;
	}









	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}


	
	
	
	
}
