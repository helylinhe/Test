package com.linkonworks.df.vo;

public class DiagKnowledge implements java.io.Serializable{

	private String auditsState;
	private String deptName;
	private String knowledgeCode;
	private String deptCode;
	private String bodyPartName;
	private String mainSymptom;
	private String mainSymptomSpell;
	private String symptomDesc;
	private String symptomAnalyze;
	private String diagName;
	private String diagCode;
	private String advise;
	private String logDate;
	private String logEmpolyeeCode;
	private String diagRemark;
	private String dictId;
	public String getAuditsState() {
		return auditsState;
	}
	public void setAuditsState(String auditsState) {
		this.auditsState = auditsState;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getKnowledgeCode() {
		return knowledgeCode;
	}
	public void setKnowledgeCode(String knowledgeCode) {
		this.knowledgeCode = knowledgeCode;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getBodyPartName() {
		return bodyPartName;
	}
	public void setBodyPartName(String bodyPartName) {
		this.bodyPartName = bodyPartName;
	}
	public String getMainSymptom() {
		return mainSymptom;
	}
	public void setMainSymptom(String mainSymptom) {
		this.mainSymptom = mainSymptom;
	}
	public String getMainSymptomSpell() {
		return mainSymptomSpell;
	}
	public void setMainSymptomSpell(String mainSymptomSpell) {
		this.mainSymptomSpell = mainSymptomSpell;
	}
	public String getSymptomDesc() {
		return symptomDesc;
	}
	public void setSymptomDesc(String symptomDesc) {
		this.symptomDesc = symptomDesc;
	}
	public String getSymptomAnalyze() {
		return symptomAnalyze;
	}
	public void setSymptomAnalyze(String symptomAnalyze) {
		this.symptomAnalyze = symptomAnalyze;
	}
	public String getDiagName() {
		return diagName;
	}
	public void setDiagName(String diagName) {
		this.diagName = diagName;
	}
	public String getDiagCode() {
		return diagCode;
	}
	public void setDiagCode(String diagCode) {
		this.diagCode = diagCode;
	}
	public String getAdvise() {
		return advise;
	}
	public void setAdvise(String advise) {
		this.advise = advise;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getLogEmpolyeeCode() {
		return logEmpolyeeCode;
	}
	public void setLogEmpolyeeCode(String logEmpolyeeCode) {
		this.logEmpolyeeCode = logEmpolyeeCode;
	}
	public String getDiagRemark() {
		return diagRemark;
	}
	public void setDiagRemark(String diagRemark) {
		this.diagRemark = diagRemark;
	}
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public DiagKnowledge(String auditsState, String deptName,
			String knowledgeCode, String deptCode, String bodyPartName,
			String mainSymptom, String mainSymptomSpell, String symptomDesc,
			String symptomAnalyze, String diagName, String diagCode,
			String advise, String logDate, String logEmpolyeeCode,
			String diagRemark, String dictId) {
		super();
		this.auditsState = auditsState;
		this.deptName = deptName;
		this.knowledgeCode = knowledgeCode;
		this.deptCode = deptCode;
		this.bodyPartName = bodyPartName;
		this.mainSymptom = mainSymptom;
		this.mainSymptomSpell = mainSymptomSpell;
		this.symptomDesc = symptomDesc;
		this.symptomAnalyze = symptomAnalyze;
		this.diagName = diagName;
		this.diagCode = diagCode;
		this.advise = advise;
		this.logDate = logDate;
		this.logEmpolyeeCode = logEmpolyeeCode;
		this.diagRemark = diagRemark;
		this.dictId = dictId;
	}
	public DiagKnowledge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
