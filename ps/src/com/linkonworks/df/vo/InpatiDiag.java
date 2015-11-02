package com.linkonworks.df.vo;

public class InpatiDiag implements java.io.Serializable {

	private String id;
	private String patiSerial;
	private String inpatiNumber;
	private String inpatiSerialNumber;
	private String inHospitalDate;
	private String outHospitalDate;
	private String inHospitalDates;
	private String inHospitalWeight;
	private String inpatiTimes;
	private Integer age;
	private String inpatiDoctor;
	private String attendDoctor;
	private String chiefDoctor;
	private String bedDoctor;
	private String ward;
	private String dept;
	private String diag;
	private String inHospDiag;
	private String outHospDiag;
	private String outHospDiagOther;
	private String diagSituation;
	private String payType;
	private String hospitalCode;
	private String memo;
	private String department;
	private String outWard;
	private String medicalInsuranceCode;
	private String billingCode;
	private String name;
	private String gender;
	private String birthAddr;
	private String birthWeight;
	private String birthDate;
	private String country;
	private String race;
	private String certificateType;
	private String certificateNumber;
	private String mobileNumber;
	private String familyNumber;
	private String professionTitle;
	private String married;
	private String currentAddr;
	private String currentPostcode;
	private String accountAddr;
	private String accountPostcode;
	private String relationName;
	private String relation;
	private String relationMobileNumber;
	private String sameFamilyInpatNumber;
	private String currentInpatiSerial;
	private String unitCode;
	private String birthState;
	private String flupMobile;
	private String billingName;
	
	private String totalMoney;
	
	private String charityDidMoney;
	
	
	
	

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getCharityDidMoney() {
		return charityDidMoney;
	}

	public void setCharityDidMoney(String charityDidMoney) {
		this.charityDidMoney = charityDidMoney;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getFlupMobile() {
		return flupMobile;
	}

	public void setFlupMobile(String flupMobile) {
		this.flupMobile = flupMobile;
	}

	private PatiOperate patiOperate;

	public String getOutWard() {
		return outWard;
	}

	public void setOutWard(String outWard) {
		this.outWard = outWard;
	}

	public String getInpatiTimes() {
		return inpatiTimes;
	}

	public void setInpatiTimes(String inpatiTimes) {
		this.inpatiTimes = inpatiTimes;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getInHospDiag() {
		return inHospDiag;
	}

	public void setInHospDiag(String inHospDiag) {
		this.inHospDiag = inHospDiag;
	}

	public String getOutHospDiag() {
		return outHospDiag;
	}

	public void setOutHospDiag(String outHospDiag) {
		this.outHospDiag = outHospDiag;
	}

	public String getOutHospDiagOther() {
		return outHospDiagOther;
	}

	public void setOutHospDiagOther(String outHospDiagOther) {
		this.outHospDiagOther = outHospDiagOther;
	}

	public InpatiDiag() {
		super();
	}

	public InpatiDiag(String id, String patiSerial, String inpatiNumber,
			String inpatiSerialNumber, String inHospitalDate,
			String outHospitalDate, String inHospitalDates,
			String inHospitalWeight, Integer age, String inpatiDoctor,
			String attendDoctor, String chiefDoctor, String bedDoctor,
			String ward, String dept, String diag, String inHospitalDiag,
			String outHospitalDiag, String outHospitalDiagOther,
			String diagSituation, String payType, String hospitalCode,
			String memo, PatiOperate patiOperate) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.inpatiSerialNumber = inpatiSerialNumber;
		this.inHospitalDate = inHospitalDate;
		this.outHospitalDate = outHospitalDate;
		this.inHospitalDates = inHospitalDates;
		this.inHospitalWeight = inHospitalWeight;
		this.age = age;
		this.inpatiDoctor = inpatiDoctor;
		this.attendDoctor = attendDoctor;
		this.chiefDoctor = chiefDoctor;
		this.bedDoctor = bedDoctor;
		this.ward = ward;
		this.dept = dept;
		this.diag = diag;
		this.diagSituation = diagSituation;
		this.payType = payType;
		this.hospitalCode = hospitalCode;
		this.memo = memo;
		this.patiOperate = patiOperate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatiSerial() {
		return patiSerial;
	}

	public void setPatiSerial(String patiSerial) {
		this.patiSerial = patiSerial;
	}

	public String getInpatiNumber() {
		return inpatiNumber;
	}

	public void setInpatiNumber(String inpatiNumber) {
		this.inpatiNumber = inpatiNumber;
	}

	public String getInpatiSerialNumber() {
		return inpatiSerialNumber;
	}

	public void setInpatiSerialNumber(String inpatiSerialNumber) {
		this.inpatiSerialNumber = inpatiSerialNumber;
	}

	public String getInHospitalDate() {
		return inHospitalDate;
	}

	public void setInHospitalDate(String inHospitalDate) {
		this.inHospitalDate = inHospitalDate;
	}

	public String getOutHospitalDate() {
		return outHospitalDate;
	}

	public void setOutHospitalDate(String outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
	}

	public String getInHospitalDates() {
		return inHospitalDates;
	}

	public void setInHospitalDates(String inHospitalDates) {
		this.inHospitalDates = inHospitalDates;
	}

	public String getInHospitalWeight() {
		return inHospitalWeight;
	}

	public void setInHospitalWeight(String inHospitalWeight) {
		this.inHospitalWeight = inHospitalWeight;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getInpatiDoctor() {
		return inpatiDoctor;
	}

	public void setInpatiDoctor(String inpatiDoctor) {
		this.inpatiDoctor = inpatiDoctor;
	}

	public String getAttendDoctor() {
		return attendDoctor;
	}

	public void setAttendDoctor(String attendDoctor) {
		this.attendDoctor = attendDoctor;
	}

	public String getChiefDoctor() {
		return chiefDoctor;
	}

	public void setChiefDoctor(String chiefDoctor) {
		this.chiefDoctor = chiefDoctor;
	}

	public String getBedDoctor() {
		return bedDoctor;
	}

	public void setBedDoctor(String bedDoctor) {
		this.bedDoctor = bedDoctor;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDiag() {
		return diag;
	}

	public void setDiag(String diag) {
		this.diag = diag;
	}

	public String getDiagSituation() {
		return diagSituation;
	}

	public void setDiagSituation(String diagSituation) {
		this.diagSituation = diagSituation;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public PatiOperate getPatiOperate() {
		return patiOperate;
	}

	public void setPatiOperate(PatiOperate patiOperate) {
		this.patiOperate = patiOperate;
	}

	public String getMedicalInsuranceCode() {
		return medicalInsuranceCode;
	}

	public void setMedicalInsuranceCode(String medicalInsuranceCode) {
		this.medicalInsuranceCode = medicalInsuranceCode;
	}

	public String getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthAddr() {
		return birthAddr;
	}

	public void setBirthAddr(String birthAddr) {
		this.birthAddr = birthAddr;
	}

	public String getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(String birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFamilyNumber() {
		return familyNumber;
	}

	public void setFamilyNumber(String familyNumber) {
		this.familyNumber = familyNumber;
	}

	public String getProfessionTitle() {
		return professionTitle;
	}

	public void setProfessionTitle(String professionTitle) {
		this.professionTitle = professionTitle;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getCurrentAddr() {
		return currentAddr;
	}

	public void setCurrentAddr(String currentAddr) {
		this.currentAddr = currentAddr;
	}

	public String getCurrentPostcode() {
		return currentPostcode;
	}

	public void setCurrentPostcode(String currentPostcode) {
		this.currentPostcode = currentPostcode;
	}

	public String getAccountAddr() {
		return accountAddr;
	}

	public void setAccountAddr(String accountAddr) {
		this.accountAddr = accountAddr;
	}

	public String getAccountPostcode() {
		return accountPostcode;
	}

	public void setAccountPostcode(String accountPostcode) {
		this.accountPostcode = accountPostcode;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getRelationMobileNumber() {
		return relationMobileNumber;
	}

	public void setRelationMobileNumber(String relationMobileNumber) {
		this.relationMobileNumber = relationMobileNumber;
	}

	public String getSameFamilyInpatNumber() {
		return sameFamilyInpatNumber;
	}

	public void setSameFamilyInpatNumber(String sameFamilyInpatNumber) {
		this.sameFamilyInpatNumber = sameFamilyInpatNumber;
	}

	public String getCurrentInpatiSerial() {
		return currentInpatiSerial;
	}

	public void setCurrentInpatiSerial(String currentInpatiSerial) {
		this.currentInpatiSerial = currentInpatiSerial;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getBirthState() {
		return birthState;
	}

	public void setBirthState(String birthState) {
		this.birthState = birthState;
	}

}
