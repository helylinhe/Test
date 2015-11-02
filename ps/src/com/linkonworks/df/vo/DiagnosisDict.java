package com.linkonworks.df.vo;

public class DiagnosisDict implements java.io.Serializable{
	
	private String id;
	private String diagnosisCode;
	private String diagnosisName;
	private Integer  approvedIndicator;
	private String createDate;
	private Integer chronicDiseaseFlag;
	private String inputCode;
	
	public DiagnosisDict() {
		super();
	}

	public DiagnosisDict(String id, String diagnosisCode, String diagnosisName,
			Integer approvedIndicator, String createDate,
			Integer chronicDiseaseFlag, String inputCode) {
		super();
		this.id = id;
		this.diagnosisCode = diagnosisCode;
		this.diagnosisName = diagnosisName;
		this.approvedIndicator = approvedIndicator;
		this.createDate = createDate;
		this.chronicDiseaseFlag = chronicDiseaseFlag;
		this.inputCode = inputCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public Integer getApprovedIndicator() {
		return approvedIndicator;
	}

	public void setApprovedIndicator(Integer approvedIndicator) {
		this.approvedIndicator = approvedIndicator;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getChronicDiseaseFlag() {
		return chronicDiseaseFlag;
	}

	public void setChronicDiseaseFlag(Integer chronicDiseaseFlag) {
		this.chronicDiseaseFlag = chronicDiseaseFlag;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	

	
	
	
	

}
