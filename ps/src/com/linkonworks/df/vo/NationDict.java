package com.linkonworks.df.vo;

public class NationDict implements java.io.Serializable{
	

	private String nationCode;
	private String nationName;
	private String inputCode;

	
	
	
	public NationDict() {
		super();
	}



	public NationDict(String id, String nationCode, String nationName,
			String inputCode, Integer echoSerial, String memo) {
		super();

		this.nationCode = nationCode;
		this.nationName = nationName;
		this.inputCode = inputCode;
	}

	public String getNationCode() {
		return nationCode;
	}



	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}



	public String getNationName() {
		return nationName;
	}



	public void setNationName(String nationName) {
		this.nationName = nationName;
	}



	public String getInputCode() {
		return inputCode;
	}



	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}



	


	
	
	
	
	

}
