package com.linkonworks.df.vo;

public class DiseaseNameDict {
	
	private String diseaseNameId; //疾病指标类名称ID
	
	private String diseaseName; //疾病指标类名称
	
	private String diseaseNameSpell; //疾病指标类名称首拼
	
	private String deptCode; //科室代码
	
	private String operateDate; // 操作日期
	
	private String employeeCode; //操作工号
	
	private String useState; //使用状态
	
	private String useStateBt;//按钮
	private String deptName;
	
	




	

	public String getUseStateBt() {
		return useStateBt;
	}

	public void setUseStateBt(String useStateBt) {
		this.useStateBt = useStateBt;
	}

	public String getDiseaseNameId() {
		return diseaseNameId;
	}

	public void setDiseaseNameId(String diseaseNameId) {
		this.diseaseNameId = diseaseNameId;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseNameSpell() {
		return diseaseNameSpell;
	}

	public void setDiseaseNameSpell(String diseaseNameSpell) {
		this.diseaseNameSpell = diseaseNameSpell;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public DiseaseNameDict(String diseaseNameId, String diseaseName,
			String diseaseNameSpell, String deptCode, String operateDate,
			String employeeCode, String useState, String useStateBt,
			String deptName) {
		super();
		this.diseaseNameId = diseaseNameId;
		this.diseaseName = diseaseName;
		this.diseaseNameSpell = diseaseNameSpell;
		this.deptCode = deptCode;
		this.operateDate = operateDate;
		this.employeeCode = employeeCode;
		this.useState = useState;
		this.useStateBt = useStateBt;
		this.deptName = deptName;
	}

	public DiseaseNameDict() {
		super();
	}
	
	


}
