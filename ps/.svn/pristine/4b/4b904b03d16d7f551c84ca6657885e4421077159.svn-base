package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PatiDao;
import com.linkonworks.df.busi.service.PatiService;
import com.linkonworks.df.vo.Pati;

public class PatiServiceImpl implements PatiService {
	private PatiDao patiDao;

	@Override
	public int insert(Pati pati) {
		return patiDao.insert(pati);
	}

	public PatiDao getPatiDao() {
		return patiDao;
	}

	public void setPatiDao(PatiDao patiDao) {
		this.patiDao = patiDao;
	}

	@Override
	public int insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return patiDao.insert(map);
	}

	@Override
	public List<Pati> getPagePati(Page page) {
		return patiDao.getPagePati(page);
	}

	@Override
	public int delete(List<String> list) {
		return patiDao.delete(list);
	}

	@Override
	public Pati getPatiInfo(Map map) {
		return patiDao.getPatiInfo(map);
	}

	@Override
	public int update(Pati pati) {
		return patiDao.update(pati);
	}

	@Override
	public Pati checkPati(Map<String, Object> map) {
		return patiDao.checkPati(map);
	}

	@Override
	public List<Map<String, Object>> historyInfo(Page page) {
		// TODO Auto-generated method stub
		return patiDao.historyInfo(page);
	}

}
