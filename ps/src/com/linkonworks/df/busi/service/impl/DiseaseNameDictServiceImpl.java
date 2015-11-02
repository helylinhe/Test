package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;


import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.DiseaseNameDictDao;
import com.linkonworks.df.busi.service.DiseaseNameDictService;
import com.linkonworks.df.vo.DiagnosisDict;
import com.linkonworks.df.vo.DiseaseNameDict;
import com.linkonworks.df.vo.User;

public class DiseaseNameDictServiceImpl implements DiseaseNameDictService{
	
	private DiseaseNameDictDao diseaseNameDictDao;

	public void setDiseaseNameDictDao(DiseaseNameDictDao diseaseNameDictDao) {
		this.diseaseNameDictDao = diseaseNameDictDao;
	}

	@Override
	public List<DiseaseNameDict> getDiseaseNameDict(Page page) {
		// TODO Auto-generated method stub
		return diseaseNameDictDao.getDiseaseNameDict(page);
	}

	@Override
	public int updateState(DiseaseNameDict diseaseNameDict) {
		// TODO Auto-generated method stub
		return diseaseNameDictDao.updateState(diseaseNameDict);
	}

	@Override
	public int updateDiseaseNameDict(DiseaseNameDict diseaseNameDict) {
		// TODO Auto-generated method stub
		return diseaseNameDictDao.updateDiseaseNameDict(diseaseNameDict);
	}

	@Override
	public int addDiseaseNameDict(DiseaseNameDict diseaseNameDict) {
		// TODO Auto-generated method stub
		return diseaseNameDictDao.addDiseaseNameDict(diseaseNameDict);
	}

	@Override
	public int checkFlupGroup(DiseaseNameDict f) {
		// TODO Auto-generated method stub
		return diseaseNameDictDao.checkFlupGroup(f);
	}


	

	
	

	


	


	








}