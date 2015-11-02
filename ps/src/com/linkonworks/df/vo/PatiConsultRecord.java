package com.linkonworks.df.vo;

public class PatiConsultRecord implements java.io.Serializable{
	
	private String id;
	private String consultContent;
	private String advise;
	private String patiMobile;
	private String logEmployeeCode;
	private String logDate;
	private String assistApplyStatus;
	private String assistDoctorCode;
	private String replyVisitDate;
	private String replyVisitResult;
	private String consultStatus;
	
	public PatiConsultRecord(String id, String consultContent, String advise,
			String patiMobile, String logEmployeeCode, String logDate,
			String assistApplyStatus, String assistDoctorCode,
			String replyVisitDate, String replyVisitResult, String consultStatus) {
		super();
		this.id = id;
		this.consultContent = consultContent;
		this.advise = advise;
		this.patiMobile = patiMobile;
		this.logEmployeeCode = logEmployeeCode;
		this.logDate = logDate;
		this.assistApplyStatus = assistApplyStatus;
		this.assistDoctorCode = assistDoctorCode;
		this.replyVisitDate = replyVisitDate;
		this.replyVisitResult = replyVisitResult;
		this.consultStatus = consultStatus;
	}

	public PatiConsultRecord() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConsultContent() {
		return consultContent;
	}

	public void setConsultContent(String consultContent) {
		this.consultContent = consultContent;
	}

	public String getAdvise() {
		return advise;
	}

	public void setAdvise(String advise) {
		this.advise = advise;
	}

	public String getPatiMobile() {
		return patiMobile;
	}

	public void setPatiMobile(String patiMobile) {
		this.patiMobile = patiMobile;
	}

	public String getLogEmployeeCode() {
		return logEmployeeCode;
	}

	public void setLogEmployeeCode(String logEmployeeCode) {
		this.logEmployeeCode = logEmployeeCode;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getAssistApplyStatus() {
		return assistApplyStatus;
	}

	public void setAssistApplyStatus(String assistApplyStatus) {
		this.assistApplyStatus = assistApplyStatus;
	}

	public String getAssistDoctorCode() {
		return assistDoctorCode;
	}

	public void setAssistDoctorCode(String assistDoctorCode) {
		this.assistDoctorCode = assistDoctorCode;
	}

	public String getReplyVisitDate() {
		return replyVisitDate;
	}

	public void setReplyVisitDate(String replyVisitDate) {
		this.replyVisitDate = replyVisitDate;
	}

	public String getReplyVisitResult() {
		return replyVisitResult;
	}

	public void setReplyVisitResult(String replyVisitResult) {
		this.replyVisitResult = replyVisitResult;
	}

	public String getConsultStatus() {
		return consultStatus;
	}

	public void setConsultStatus(String consultStatus) {
		this.consultStatus = consultStatus;
	}
	
	

}
