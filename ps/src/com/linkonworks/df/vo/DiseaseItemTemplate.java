package com.linkonworks.df.vo;

public class DiseaseItemTemplate implements java.io.Serializable{

	private String id; //表识
	
	private DiseaseNameDict diseaseNameDict;  //疾病指标名称 
	
	private DiseaseItem  diseaseItem;   //疾病指标项
	
	private String operateDate;
	private String employeeCode;
	private String useState;  //1在用；0停用
	private String showNo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DiseaseNameDict getDiseaseNameDict() {
		return diseaseNameDict;
	}
	public void setDiseaseNameDict(DiseaseNameDict diseaseNameDict) {
		this.diseaseNameDict = diseaseNameDict;
	}
	public DiseaseItem getDiseaseItem() {
		return diseaseItem;
	}
	public void setDiseaseItem(DiseaseItem diseaseItem) {
		this.diseaseItem = diseaseItem;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getUseState() {
		return useState;
	}
	public void setUseState(String useState) {
		this.useState = useState;
	}
	
	
	
	public String getShowNo() {
		return showNo;
	}
	public void setShowNo(String showNo) {
		this.showNo = showNo;
	}
	public DiseaseItemTemplate(String id, DiseaseNameDict diseaseNameDict,
			DiseaseItem diseaseItem, String operateDate, String employeeCode,
			String useState,String showNo) {
		super();
		this.id = id;
		this.diseaseNameDict = diseaseNameDict;
		this.diseaseItem = diseaseItem;
		this.operateDate = operateDate;
		this.employeeCode = employeeCode;
		this.useState = useState;
		this.showNo=showNo;
	}
	public DiseaseItemTemplate() {
		super();
	}
	
	
	
}
