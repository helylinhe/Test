package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.DiseaseItemDao;
import com.linkonworks.df.busi.service.DiseaseItemService;
import com.linkonworks.df.vo.DiseaseItem;

public class DiseaseItemServiceImpl implements DiseaseItemService {

	private DiseaseItemDao diseaseItemDao;

	@Override
	public Integer delete(Map<String, Object> map) throws Exception {
		return diseaseItemDao.delete(map);
	}

	@Override
	public List<DiseaseItem> getPageDisease(Page page) {
		return diseaseItemDao.getPageDisease(page);
	}

	@Override
	public int insert(DiseaseItem diseaseItem) {
		return diseaseItemDao.insert(diseaseItem);
	}

	@Override
	public int update(DiseaseItem diseaseItem) {
		return diseaseItemDao.update(diseaseItem);
	}

	public DiseaseItemDao getDiseaseItemDao() {
		return diseaseItemDao;
	}

	public void setDiseaseItemDao(DiseaseItemDao diseaseItemDao) {
		this.diseaseItemDao = diseaseItemDao;
	}

	@Override
	public List<DiseaseItem> getPageGroupOne(Page page) {
		return diseaseItemDao.getPageGroupOne(page);
	}


	@Override
	public int checkDiseaseItem(Map<String, String> map) {
		// TODO Auto-generated method stub
		return diseaseItemDao.checkDiseaseItem(map);
	}

}