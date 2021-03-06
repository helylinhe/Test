package com.linkonworks.df.vo;

public class DeptFlupCount {
	
	private String flupTableNameId;
	private String deptCode;
	private String deptName;
	private String flupName;
	private String totalCountNum;
	private String complateCountUnum;
	private String count;
	private String flupDate;
	private String flupRate;
	
	
	public String getFlupDate() {
		return flupDate;
	}
	public void setFlupDate(String flupDate) {
		this.flupDate = flupDate;
	}
	public String getFlupRate() {
		return flupRate;
	}
	public void setFlupRate(String flupRate) {
		this.flupRate = flupRate;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getFlupTableNameId() {
		return flupTableNameId;
	}
	public void setFlupTableNameId(String flupTableNameId) {
		this.flupTableNameId = flupTableNameId;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getFlupName() {
		return flupName;
	}
	public void setFlupName(String flupName) {
		this.flupName = flupName;
	}
	public String getTotalCountNum() {
		return totalCountNum;
	}
	public void setTotalCountNum(String totalCountNum) {
		this.totalCountNum = totalCountNum;
	}
	public String getComplateCountUnum() {
		return complateCountUnum;
	}
	public void setComplateCountUnum(String complateCountUnum) {
		this.complateCountUnum = complateCountUnum;
	}
	public DeptFlupCount(String flupTableNameId, String deptCode,
			String deptName, String flupName, String totalCountNum,
			String complateCountUnum) {
		super();
		this.flupTableNameId = flupTableNameId;
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.flupName = flupName;
		this.totalCountNum = totalCountNum;
		this.complateCountUnum = complateCountUnum;
	}
	public DeptFlupCount() {
		super();
	}


}
