package com.linkonworks.df.vo;

public class Dict implements java.io.Serializable{
	
	private String id;
	private String codeType;
	private String code;
	private String name;
	private String inputCode;
	private String echoSerial;
	private String memo;
	
	
	public Dict() {
		super();
	}


	public Dict(String id, String codeType, String code, String name,
			String inputCode, String echoSerial, String memo) {
		super();
		this.id = id;
		this.codeType = codeType;
		this.code = code;
		this.name = name;
		this.inputCode = inputCode;
		this.echoSerial = echoSerial;
		this.memo = memo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCodeType() {
		return codeType;
	}


	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getInputCode() {
		return inputCode;
	}


	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}


	public String getEchoSerial() {
		return echoSerial;
	}


	public void setEchoSerial(String echoSerial) {
		this.echoSerial = echoSerial;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	
	
	
	
	

}
