package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PatiDiseaseDictDao;
import com.linkonworks.df.busi.service.PatiDiseaseDictService;
import com.linkonworks.df.vo.DiseaseNameDict;
import com.linkonworks.df.vo.InpatiDiag;
import com.linkonworks.df.vo.PatiDiseaseDetail;
import com.linkonworks.df.vo.PatiDiseaseDict;

public class PatiDiseaseDictServiceImpl implements PatiDiseaseDictService {
	
	private PatiDiseaseDictDao patiDiseaseDictDao;

	public PatiDiseaseDictDao getPatiDiseaseDictDao() {
		return patiDiseaseDictDao;
	}

	public void setPatiDiseaseDictDao(PatiDiseaseDictDao patiDiseaseDictDao) {
		this.patiDiseaseDictDao = patiDiseaseDictDao;
	}

	

	@Override
	public List<PatiDiseaseDict> findPageList(Page page) {
		// TODO Auto-generated method stub
		return patiDiseaseDictDao.findPageList(page);
	}

	@Override
	public List<DiseaseNameDict> findDiseaseNameDict(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return patiDiseaseDictDao.findDiseaseNameDict(map);
	}

	@Override
	public int insert(PatiDiseaseDict patiDiseaseDict) {
		// TODO Auto-generated method stub
		return patiDiseaseDictDao.insert(patiDiseaseDict);
	}

	@Override
	public int delete(String[] arr) {
		// TODO Auto-generated method stub
		return patiDiseaseDictDao.delete(arr);
	}

	@Override
	public List<PatiDiseaseDetail> findDate(PatiDiseaseDetail patiDiseaseDetail) {
		// TODO Auto-generated method stub
		return patiDiseaseDictDao.findDate(patiDiseaseDetail);
	}

	


}
