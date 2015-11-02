package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PatiDiseaseDetailDao;
import com.linkonworks.df.busi.service.PatiDiseaseDetailService;
import com.linkonworks.df.vo.PatiDiseaseDetail;

public class PatiDiseaseDetailServiceImpl implements PatiDiseaseDetailService{

	private PatiDiseaseDetailDao patiDiseaseDetailDao;

	public PatiDiseaseDetailDao getPatiDiseaseDetailDao() {
		return patiDiseaseDetailDao;
	}

	public void setPatiDiseaseDetailDao(PatiDiseaseDetailDao patiDiseaseDetailDao) {
		this.patiDiseaseDetailDao = patiDiseaseDetailDao;
	}

	@Override
	public int inserBatch(List<PatiDiseaseDetail> list) {
		// TODO Auto-generated method stub
		return patiDiseaseDetailDao.insertBatch(list);
	}

	@Override
	public List<PatiDiseaseDetail> diseaseItems(Map<String, String> map) {
		// TODO Auto-generated method stub
		return patiDiseaseDetailDao.diseaseItems(map);
	}

	@Override
	public List<PatiDiseaseDetail> historyDiseasePage(Page page) {
		// TODO Auto-generated method stub
		return patiDiseaseDetailDao.historyDiseasePage(page);
	}

	@Override
	public int deletePatiDiseaseDetailInfo(String detailId) {
		// TODO Auto-generated method stub
		return patiDiseaseDetailDao.deletePatiDiseaseDetailInfo(detailId);
	}
	
	
}
