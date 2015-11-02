package com.linkonworks.df.vo;

public class Role implements java.io.Serializable{

	private String roleCode;
	private String roleName;
	private String roleStatus;
	private String memo;
	
	
	public Role() {
		super();
	}


	public Role(String roleCode, String roleName, String roleStatus, String memo) {
		super();
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.roleStatus = roleStatus;
		this.memo = memo;
	}
	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRoleStatus() {
		return roleStatus;
	}


	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	
	
	
}
