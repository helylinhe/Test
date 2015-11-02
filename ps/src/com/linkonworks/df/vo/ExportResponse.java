package com.linkonworks.df.vo;

public class ExportResponse {
	private Integer id;
	private String groupName;
	private String itemName;
	private String tableName;
	private String deptNameId;
	private String showNo;
	
	/***
	 * 逻辑处理
	 * @return
	 */
	private String columnName;
	
	
	public String getShowNo() {
		return showNo;
	}
	public void setShowNo(String showNo) {
		this.showNo = showNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getDeptNameId() {
		return deptNameId;
	}
	public void setDeptNameId(String deptNameId) {
		this.deptNameId = deptNameId;
	}
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public ExportResponse(Integer id, String groupName, String itemName,
			String tableName, String deptNameId,String shwoNo) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.itemName = itemName;
		this.tableName = tableName;
		this.deptNameId = deptNameId;
		this.showNo = shwoNo;
	}
	public ExportResponse() {
		super();
	}
	
	

}
