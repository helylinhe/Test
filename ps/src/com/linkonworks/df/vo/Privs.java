package com.linkonworks.df.vo;
 
public class Privs  implements java.io.Serializable{

	private String privsId;
	private String privsName;
	private String privsType;
	private String menuCode;
	private String progName;
	private String memo;
	
	public Privs() {
		super();
	}

	
	
	public Privs(String privsId, String privsName, String privsType,
			String menuCode, String progName, String memo) {
		super();
		this.privsId = privsId;
		this.privsName = privsName;
		this.privsType = privsType;
		this.menuCode = menuCode;
		this.progName = progName;
		this.memo = memo;
	}



	public String getPrivsId() {
		return privsId;
	}

	public void setPrivsId(String privsId) {
		this.privsId = privsId;
	}

	public String getPrivsName() {
		return privsName;
	}

	public void setPrivsName(String privsName) {
		this.privsName = privsName;
	}

	public String getPrivsType() {
		return privsType;
	}

	public void setPrivsType(String privsType) {
		this.privsType = privsType;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getProgName() {
		return progName;
	}

	public void setProgName(String progName) {
		this.progName = progName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	

	

	
	
	
	
}
