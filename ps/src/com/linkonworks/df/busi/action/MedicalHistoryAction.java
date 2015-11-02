package com.linkonworks.df.busi.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.service.MedicalHistoryService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.vo.DiagGroup;
import com.linkonworks.df.vo.MedicalHistory;
import com.opensymphony.xwork2.ActionSupport;

public class MedicalHistoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private MedicalHistoryService medicalHistoryService;
	private MedicalHistory mh;
	
	/***
	 * 获取ICD10信息
	 * @return
	 */
	public String findICD10(){
		Map<String,String> map=new HashMap<String,String>();
		List<DiagGroup> list=medicalHistoryService.findIcd1O(map);
		JsonUtil.jsonDataList(list);
		return null;
	}

	/*****
	 * 保存病史信息
	 * @return
	 */
	public String saveMedicalHistory(){
		int count=medicalHistoryService.insert(mh);
		return null;
	}

	public MedicalHistoryService getMedicalHistoryService() {
		return medicalHistoryService;
	}


	public void setMedicalHistoryService(MedicalHistoryService medicalHistoryService) {
		this.medicalHistoryService = medicalHistoryService;
	}

	public MedicalHistory getMh() {
		return mh;
	}

	public void setMh(MedicalHistory mh) {
		this.mh = mh;
	}
	
	
	
}
