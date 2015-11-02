package com.linkonworks.df.vo;

public class HospitalConfig implements java.io.Serializable{
	
	private String id;
	private String hospital;
	private String authorizedKey;
	private String unitCode;
	private String mailingAddress;
	private String zipCode;
	private Integer approvedBedNum;
	private String hosShortName;
	
	
	public HospitalConfig() {
		super();
	}


	public HospitalConfig(String id, String hospital, String authorizedKey,
			String unitCode, String mailingAddress, String zipCode,
			Integer approvedBedNum,String hosShortName) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.authorizedKey = authorizedKey;
		this.unitCode = unitCode;
		this.mailingAddress = mailingAddress;
		this.zipCode = zipCode;
		this.approvedBedNum = approvedBedNum;
		this.hosShortName=hosShortName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getHospital() {
		return hospital;
	}


	public void setHospital(String hospital) {
		this.hospital = hospital;
	}


	public String getAuthorizedKey() {
		return authorizedKey;
	}


	public void setAuthorizedKey(String authorizedKey) {
		this.authorizedKey = authorizedKey;
	}


	public String getUnitCode() {
		return unitCode;
	}


	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}


	public String getMailingAddress() {
		return mailingAddress;
	}


	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public Integer getApprovedBedNum() {
		return approvedBedNum;
	}


	public void setApprovedBedNum(Integer approvedBedNum) {
		this.approvedBedNum = approvedBedNum;
	}


	public String getHosShortName() {
		return hosShortName;
	}


	public void setHosShortName(String hosShortName) {
		this.hosShortName = hosShortName;
	}

	
	
	
	

}
