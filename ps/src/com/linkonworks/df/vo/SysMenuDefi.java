package com.linkonworks.df.vo;

public class SysMenuDefi {

	private String id;
	private String progName;
	private String menuLevel;
	private String menuNo;
	private String menuHigherNo;
	private String menuCode;
	private String menuName;
	private String operateDate;
	private String operateEmployeeCode;
	private String delState;
	private String urlAddress;
	
	private String privsId;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProgName() {
		return progName;
	}
	public void setProgName(String progName) {
		this.progName = progName;
	}
	public String getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuHigherNo() {
		return menuHigherNo;
	}
	public void setMenuHigherNo(String menuHigherNo) {
		this.menuHigherNo = menuHigherNo;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
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
	public String getDelState() {
		return delState;
	}
	public void setDelState(String delState) {
		this.delState = delState;
	}
	
	
	public String getUrlAddress() {
		return urlAddress;
	}
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}
	public String getPrivsId() {
		return privsId;
	}
	public void setPrivsId(String privsId) {
		this.privsId = privsId;
	}
	public SysMenuDefi(String id, String progName, String menuLevel,
			String menuNo, String menuHigherNo, String menuCode,
			String menuName, String operateDate, String operateEmployeeCode,
			String delState,String privsId,String urlAddress) {
		super();
		this.id = id;
		this.progName = progName;
		this.menuLevel = menuLevel;
		this.menuNo = menuNo;
		this.menuHigherNo = menuHigherNo;
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.operateDate = operateDate;
		this.operateEmployeeCode = operateEmployeeCode;
		this.delState = delState;
		this.privsId=privsId;
		this.urlAddress=urlAddress;
	}
	public SysMenuDefi() {
		super();
	}
	
	
	
	
}
