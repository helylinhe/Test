package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.dao.MedicalHistoryDao;
import com.linkonworks.df.busi.service.MedicalHistoryService;
import com.linkonworks.df.vo.DiagGroup;
import com.linkonworks.df.vo.MedicalHistory;

public class MedicalHistoryServiceImpl implements MedicalHistoryService{
	
	private MedicalHistoryDao medicalHistoryDao;

	@Override
	public List<DiagGroup> findIcd1O(Map<String, String> map) {
		// TODO Auto-generated method stub
		return medicalHistoryDao.findIcd1O(map);
	}

	public MedicalHistoryDao getMedicalHistoryDao() {
		return medicalHistoryDao;
	}

	public void setMedicalHistoryDao(MedicalHistoryDao medicalHistoryDao) {
		this.medicalHistoryDao = medicalHistoryDao;
	}

	@Override
	public int insert(MedicalHistory mh) {
		// TODO Auto-generated method stub
		return medicalHistoryDao.insert(mh);
	}
	
	

}
