package com.linkonworks.df.vo;

public class FlupDetail implements java.io.Serializable{

	private String id;
	private String flupId;
	private String patiSerial;
	private String inpatiNumber;
	private String sendMobileNumber;
	private String sendWay;
	private String infoType;
	private String sendContent;
	private String sendDate;
	private String name;
	
	
	
	





	public FlupDetail() {
		super();
	}



	


	public FlupDetail(String id, String flupId, String patiSerial,
			String inpatiNumber, String sendMobileNumber, String sendWay,
			String infoType, String sendContent, String sendDate, String name) {
		super();
		this.id = id;
		this.flupId = flupId;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.sendMobileNumber = sendMobileNumber;
		this.sendWay = sendWay;
		this.infoType = infoType;
		this.sendContent = sendContent;
		this.sendDate = sendDate;
		this.name = name;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getFlupId() {
		return flupId;
	}



	public void setFlupId(String flupId) {
		this.flupId = flupId;
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



	public String getSendMobileNumber() {
		return sendMobileNumber;
	}



	public void setSendMobileNumber(String sendMobileNumber) {
		this.sendMobileNumber = sendMobileNumber;
	}



	public String getSendWay() {
		return sendWay;
	}



	public void setSendWay(String sendWay) {
		this.sendWay = sendWay;
	}



	public String getInfoType() {
		return infoType;
	}



	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}



	public String getSendContent() {
		return sendContent;
	}



	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}



	public String getSendDate() {
		return sendDate;
	}



	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	
	
}
