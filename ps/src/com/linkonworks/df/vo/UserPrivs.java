package com.linkonworks.df.vo;

public class UserPrivs implements java.io.Serializable{
	
	private String userId;
	private String privsId;
	
	
	public UserPrivs() {
		super();
	}


	public UserPrivs(String userId, String privsId) {
		super();
		this.userId = userId;
		this.privsId = privsId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPrivsId() {
		return privsId;
	}


	public void setPrivsId(String privsId) {
		this.privsId = privsId;
	}
	
	
	

}
