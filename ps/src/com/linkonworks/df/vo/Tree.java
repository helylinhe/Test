package com.linkonworks.df.vo;

public class Tree {
	private String id;
	private String text;
	private String state;
	private String menuLevel;
	private String menuHigherNo;
	private String menuCode;
	private String roleCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getMenuHigherNo() {
		return menuHigherNo;
	}
	public void setMenuHigherNo(String menuHigherNo) {
		this.menuHigherNo = menuHigherNo;
	}
	
	
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public Tree(String id, String text, String state, String menuLevel,
			String menuHigherNo,String menuCode,String roleCode) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.menuLevel = menuLevel;
		this.menuHigherNo = menuHigherNo;
		this.menuCode=menuCode;
		this.roleCode=roleCode;
	}
	public Tree() {
		super();
	}
	
	
}
