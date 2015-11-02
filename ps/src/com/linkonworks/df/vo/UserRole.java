package com.linkonworks.df.vo;

public class UserRole implements java.io.Serializable{
	
	private String userId;
	private String roleCode;
	
	
	
	public UserRole() {
		super();
	}



	public UserRole(String userId, String roleCode) {
		super();
		this.userId = userId;
		this.roleCode = roleCode;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getRoleCode() {
		return roleCode;
	}



	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}



	
	
	

}
