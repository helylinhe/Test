package com.linkonworks.df.vo;

public class Pati implements java.io.Serializable {
	private String id;
	private String patiSerial;
	private String inpatiSerialNumber;
	private String inpatiNumber;
	private String medicalInsuranceCode;
	private String billingCode;
	private String name;
	private String gender;
	private String age;
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
	private String inpatiTimes;
	private String currentInpatiSerial;
	private String hospitalCode;
	private String memo;
	private String unitCode;
	private String blackListState;
	private String dataFrom;
	private String generateDate;
	private String delState;
	private String birthState;
	private String flupStatus;
	private String flupWay;
	private String outHospitalDate;
	private String diag;
	private InpatiDiag inpatiDiag;
	private String department;
	private String flupMobile;
	private String employeeCode;// 操作工号
	private String outHospDiagOther;
	private String outHospDiag;
	private String idNo;
	private String billingName;
	
	//显示总费用跟慈善救助基金跟主刀医生
	private String totalMoney;
	private String charityAidMoney;
	private String operationDoctorCode;
	private String inHospitalDate;
	private String doctorName;
	private String inHospitalDiag;
	private String flupTableNameId;
	private String deptCode;
	
	public String getInHospitalDate() {
		return inHospitalDate;
	}

	public void setInHospitalDate(String inHospitalDate) {
		this.inHospitalDate = inHospitalDate;
	}

	public String getOperationDoctorCode() {
		return operationDoctorCode;
	}

	public void setOperationDoctorCode(String operationDoctorCode) {
		this.operationDoctorCode = operationDoctorCode;
	}

	
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getCharityAidMoney() {
		return charityAidMoney;
	}

	public void setCharityAidMoney(String charityAidMoney) {
		this.charityAidMoney = charityAidMoney;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getOutHospDiagOther() {
		return outHospDiagOther;
	}

	public void setOutHospDiagOther(String outHospDiagOther) {
		this.outHospDiagOther = outHospDiagOther;
	}

	public String getOutHospDiag() {
		return outHospDiag;
	}

	public void setOutHospDiag(String outHospDiag) {
		this.outHospDiag = outHospDiag;
	}

	public String getInpatiSerialNumber() {
		return inpatiSerialNumber;
	}

	public void setInpatiSerialNumber(String inpatiSerialNumber) {
		this.inpatiSerialNumber = inpatiSerialNumber;
	}
	

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	
	
	public String getInHospitalDiag() {
		return inHospitalDiag;
	}

	public void setInHospitalDiag(String inHospitalDiag) {
		this.inHospitalDiag = inHospitalDiag;
	}

	public Pati() {
		super();
	}

	public Pati(String id, String patiSerial, String inpatiNumber,
			String medicalInsuranceCode, String payType, String name,
			String gender, String age, String birthAddr, String birthWeight,
			String birthDate, String country, String race,
			String certificateType, String certificateNumber,
			String mobileNumber, String familyNumber, String professionTitle,
			String married, String currentAddr, String currentPostcode,
			String accountAddr, String accountPostcode, String relationName,
			String relation, String relationMobileNumber,
			String sameFamilyInpatNumber, String inpatiTimes,
			String currentInpatiSerial, String hospitalCode, String memo,
			InpatiDiag inpatiDiag,String billingName) {
		super();
		this.id = id;
		this.patiSerial = patiSerial;
		this.inpatiNumber = inpatiNumber;
		this.medicalInsuranceCode = medicalInsuranceCode;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthAddr = birthAddr;
		this.birthWeight = birthWeight;
		this.birthDate = birthDate;
		this.country = country;
		this.race = race;
		this.certificateType = certificateType;
		this.certificateNumber = certificateNumber;
		this.mobileNumber = mobileNumber;
		this.familyNumber = familyNumber;
		this.professionTitle = professionTitle;
		this.married = married;
		this.currentAddr = currentAddr;
		this.currentPostcode = currentPostcode;
		this.accountAddr = accountAddr;
		this.accountPostcode = accountPostcode;
		this.relationName = relationName;
		this.relation = relation;
		this.relationMobileNumber = relationMobileNumber;
		this.sameFamilyInpatNumber = sameFamilyInpatNumber;
		this.inpatiTimes = inpatiTimes;
		this.currentInpatiSerial = currentInpatiSerial;
		this.hospitalCode = hospitalCode;
		this.memo = memo;
		this.inpatiDiag = inpatiDiag;
		this.billingName=billingName;
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


	public void setAge(String age) {
		this.age = age;
	}
	

	public String getAge() {
		return age;
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

	public String getInpatiTimes() {
		return inpatiTimes;
	}

	public void setInpatiTimes(String inpatiTimes) {
		this.inpatiTimes = inpatiTimes;
	}

	public String getCurrentInpatiSerial() {
		return currentInpatiSerial;
	}

	public void setCurrentInpatiSerial(String currentInpatiSerial) {
		this.currentInpatiSerial = currentInpatiSerial;
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

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getBlackListState() {
		return blackListState;
	}

	public void setBlackListState(String blackListState) {
		this.blackListState = blackListState;
	}

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	public String getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}

	public String getDelState() {
		return delState;
	}

	public void setDelState(String delState) {
		this.delState = delState;
	}

	public InpatiDiag getInpatiDiag() {
		return inpatiDiag;
	}

	public void setInpatiDiag(InpatiDiag inpatiDiag) {
		this.inpatiDiag = inpatiDiag;
	}

	public String getFlupStatus() {
		return flupStatus;
	}

	public void setFlupStatus(String flupStatus) {
		this.flupStatus = flupStatus;
	}

	public String getFlupWay() {
		return flupWay;
	}

	public void setFlupWay(String flupWay) {
		this.flupWay = flupWay;
	}

	public String getOutHospitalDate() {
		return outHospitalDate;
	}

	public void setOutHospitalDate(String outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
	}

	public String getBirthState() {
		return birthState;
	}

	public void setBirthState(String birthState) {
		this.birthState = birthState;
	}

	public String getDiag() {
		return diag;
	}

	public void setDiag(String diag) {
		this.diag = diag;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFlupMobile() {
		return flupMobile;
	}

	public void setFlupMobile(String flupMobile) {
		this.flupMobile = flupMobile;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getFlupTableNameId() {
		return flupTableNameId;
	}

	public void setFlupTableNameId(String flupTableNameId) {
		this.flupTableNameId = flupTableNameId;
	}
	
}
